package xiangqi.studentjhu4;

import xiangqi.common.XiangqiColor;
import xiangqi.common.XiangqiCoordinate;
import xiangqi.common.XiangqiPiece;
import xiangqi.common.XiangqiPieceType;
import static xiangqi.studentjhu4.XiangqiCoordinateImpl.makeCoordinate;

import java.util.HashMap;
import java.util.concurrent.CompletionException;

public abstract class XiangqiBoard{
	protected XiangqiPiece[][] board;
	protected int ranks;
	protected int files;
	protected int river;
	protected HashMap<Integer,XiangqiPiece> redpieces;
	protected HashMap<Integer,XiangqiPiece> blackpieces;
	protected XiangqiCoordinateImpl redGeneralLocation;
	protected XiangqiCoordinateImpl blackGeneralLocation;
	protected XiangqiColor boardColor=XiangqiColor.RED;
	
	/**
	 * Method used for querying the board.
	 * @param where the coordinate to access
	 * @param aspect the player from whom the request is made. This is needed
	 *   in order to determine which location the <code>where</code> parameter
	 *   references
	 * @return the piece at the specified coordinate. If the coordinate is empty,
	 *   this returns a piece with the type of XiangqiPieceType.NONE, and a color of 
	 *   XiangqiColor.NONE.
	 */
	public XiangqiPiece getPieceAt(XiangqiCoordinate where, XiangqiColor aspect) {
		if (aspect==XiangqiColor.NONE){
			return XiangqiPieceImpl.makePiece(XiangqiPieceType.NONE, XiangqiColor.NONE);
		}
		boolean validCoordinate=where.getFile()>0 && where.getFile()<files 
										&&where.getRank()>0 && where.getRank()<ranks;								
		if(!validCoordinate){
			throw new CompletionException("Out of bound", new Throwable());
		}
		if(aspect==XiangqiColor.BLACK){
			where=convertCoordinateToOtherColor(where);
		}
		return board[where.getRank()][where.getFile()];
	}
	
	/**
	 * Get the color of the game board
	 * @return RED or BLACK
	 */
	public XiangqiColor getBoardColor(){
		return boardColor;
	}
	
	/**
	 * Get the boundary representing crossing the river
	 * @return boundary of the river
	 */
	public int getRiverBound(){
		return river;
	}
	
	/**
	 * Update the board with the move
	 * @param source from coordinate
	 * @param dest to coordinate
	 */
	public void makeMove(XiangqiCoordinate source, XiangqiCoordinate dest) {
		if(boardColor==XiangqiColor.BLACK){
			source=convertCoordinateToOtherColor(source);
			dest=convertCoordinateToOtherColor(dest);
		}	
		board[dest.getRank()][dest.getFile()]=board[source.getRank()][source.getFile()];
		board[source.getRank()][source.getFile()]=
				XiangqiPieceImpl.makePiece(XiangqiPieceType.NONE, XiangqiColor.NONE);
		alterColor();
	}
	
	public void reverseMove(XiangqiMove move){
		boardColor=move.color;
		redpieces=move.redpieces;
		blackpieces=move.blackpieces;
		redGeneralLocation=move.redGeneralLocation;
		blackGeneralLocation=move.blackGeneralLocation;
		XiangqiCoordinate src=move.src;
		XiangqiCoordinate dest=move.dest;
		if(boardColor==XiangqiColor.BLACK){
			src=convertCoordinateToOtherColor(src);
			dest=convertCoordinateToOtherColor(dest);
		}
		board[src.getRank()][src.getFile()]=move.srcPiece;
		board[dest.getRank()][dest.getFile()]=move.destPiece;
	}
	
	/**
	 * Update the pieces information on board
	 * @param source Move from
	 * @param dest Move to
	 */
	public void updatePiecesList(XiangqiCoordinate source, XiangqiCoordinate dest){
		XiangqiPiece pc= getPieceAt(source,getBoardColor());
		if(pc.getPieceType()==XiangqiPieceType.GENERAL){
			updateGeneralLocation(dest);
		}
		updatePiecesLocations(source, dest);
	}
	
	protected void updateGeneralLocation(XiangqiCoordinate newlocation){
		if(boardColor==XiangqiColor.RED){
			redGeneralLocation=makeCoordinate(newlocation.getRank(),newlocation.getFile());
		}
		else{
			blackGeneralLocation=makeCoordinate(newlocation.getRank(),newlocation.getFile());
		}
	}
	
	protected void updatePiecesLocations(XiangqiCoordinate source, XiangqiCoordinate dest){
		XiangqiPiece updatepc;
		if(boardColor==XiangqiColor.RED){
			//if there is a black piece on the destination coordinate, remove it from the black list
			if(getPieceAt(dest, XiangqiColor.RED).getColor()==XiangqiColor.BLACK){
				blackpieces.remove(hashing(convertCoordinateToOtherColor(dest)));
			}
			updatepc=redpieces.remove(hashing(source));
			redpieces.put(hashing(dest),updatepc);
		}
		else{
			//if there is a red piece on the destination coordinate, remove it from the red list
			if(getPieceAt(dest,XiangqiColor.BLACK).getColor()==XiangqiColor.RED){
				redpieces.remove(hashing(convertCoordinateToOtherColor(dest)));
			}
			updatepc=blackpieces.remove(hashing(source));
			blackpieces.put(hashing(dest),updatepc);
		}
	}
	
	/**
	 * Get the numbers of piece from a coordinate to another coordinate in an orthogonal path
	 * @param from the start location(exclusive)
	 * @param to the end location(exclusive)
	 * @return the number of pieces on the path
	 */
	public int getNumberPieceOrthogonalPathBtw(XiangqiCoordinateImpl from,XiangqiCoordinateImpl to) {
		if(boardColor==XiangqiColor.BLACK){
			from=convertCoordinateToOtherColor(from);
			to=convertCoordinateToOtherColor(to);
		}
		if(from.getRank()==to.getRank()){
			return getNumberPieceInRankBetween(from.getRank(),from.getFile(),to.getFile());
		}
		else if(from.getFile()==to.getFile()){
			return getNumberPieceInFileBetween(to.getFile(), from.getRank(),to.getRank());
		}
		else{
			throw new CompletionException("XiangqiBoard::getNumberPieceOrthogonalPathBtw Not an orthogonal path"
					, new Throwable());
		}
	}
	
	/**
	 * 
	 * Get the numbers of piece from a coordinate to another coordinate in a diagonal path
	 * @param from the start location(exclusive)
	 * @param to the end location(exclusive)
	 * @return the number of pieces on the path
	 */
	public int getNumberPieceDiagonalPathBtw(XiangqiCoordinateImpl from,
			XiangqiCoordinateImpl to) {
		if(Math.abs(from.getFile()-to.getFile())!=Math.abs(from.getRank()-to.getRank())){
			throw new CompletionException("XiangqiBoard::getNumberPieceDiagonalPathBtw Not a diagonal path"
					, new Throwable());
		}
		int result=0;
		if(boardColor==XiangqiColor.BLACK){
			from=convertCoordinateToOtherColor(from);
			to=convertCoordinateToOtherColor(to);
		}
		int fileDirection=from.getFile()<to.getFile()?1:-1;
		int rankDirection=from.getRank()<to.getRank()?1:-1;
		for(int i=1;i<Math.abs(from.getRank()-to.getRank());i++){
			if(board[from.getRank()+i*rankDirection][from.getFile()+i*fileDirection].getPieceType()
					!=XiangqiPieceType.NONE){
				result++;
			}
		}
		return result;
	}
	
	/**
	 * Get the rank boundary
	 * @return number representing rank boundary
	 */
	public int getExclusiveRankBound(){
		return this.ranks;
	}
	
	/**
	 * Get the file boundary
	 * @return number representing file boundary
	 */
	public int getExclusiveFileBound(){
		return this.files;
	}

	/**
	 * Getter
	 * @param color RED or BLACK
	 * @return a hashmap containing all the pieces in color
	 */
	public HashMap<Integer,XiangqiPiece> getPieces(XiangqiColor color){
		return color==XiangqiColor.RED?redpieces:blackpieces;
	}
	 
	/**
	 * The coordinate in enemy's aspect
	 * @param c the coordinate
	 * @return the coordinate in enemy's aspect
	 */
	public XiangqiCoordinateImpl convertCoordinateToOtherColor(XiangqiCoordinate c){
		return makeCoordinate(ranks-c.getRank(),files-c.getFile());
	}
	
	/**
	 * Getter for general's location
	 * @param color the general in which color
	 * @return the general location in its own aspect
	 */
	public XiangqiCoordinate getGeneralLocation(XiangqiColor color){
		return color==XiangqiColor.RED?redGeneralLocation:blackGeneralLocation;
	}
	
	/**
	 * Get the opponent general location in my aspect
	 * @return general coordinate in my aspect
	 */
	public XiangqiCoordinate getOpponentGeneralLocation(){
		if(boardColor==XiangqiColor.RED){
			return convertCoordinateToOtherColor(blackGeneralLocation);
		}
		else{
			return convertCoordinateToOtherColor(redGeneralLocation);
		}
	}
	
	private int getNumberPieceInFileBetween(int file, int start,int end) {
		if((end-start)==1) return 0;
		int incrementor=start<end?1:-1;
		int count=-1;
		for(int i=start;i!=end;i+=incrementor){
			if(board[i][file].getPieceType()!=XiangqiPieceType.NONE){
				count++;
			}
		}
		return count;
	}	
	
	private int getNumberPieceInRankBetween(int rank, int start,int end){
		if((end-start)==1) return 0;
		int incrementor=start<end?1:-1;
		int count=-1;
		for(int i=start;i!=end;i+=incrementor){
			if(board[rank][i].getPieceType()!=XiangqiPieceType.NONE){
				count++;
			}
		}
		return count;
		
	}

	private void alterColor(){
		boardColor=(boardColor==XiangqiColor.BLACK)?XiangqiColor.RED:XiangqiColor.BLACK;
	}
	
	
	private Integer hashing(XiangqiCoordinate coordinate){
		return new Integer(coordinate.getRank()*100+coordinate.getFile());
	}

}
