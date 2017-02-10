package xiangqi.studentjhu4;

import xiangqi.common.XiangqiColor;
import xiangqi.common.XiangqiCoordinate;
import xiangqi.common.XiangqiPiece;
import xiangqi.common.XiangqiPieceType;
import static xiangqi.studentjhu4.XiangqiCoordinateImpl.makeCoordinate;

import java.util.HashMap;

public abstract class XiangqiBoard{
	protected XiangqiPiece[][] board;
	protected int ranks;
	protected int files;
	protected HashMap<XiangqiCoordinateImpl,XiangqiPiece> redpieces;
	protected HashMap<XiangqiCoordinateImpl,XiangqiPiece> blackpieces;
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
	public XiangqiPiece getPieceAt(XiangqiCoordinate where, XiangqiColor aspect){
		boolean validCoordinate=where.getFile()>0 && where.getFile()<files 
										&&where.getRank()>0 && where.getRank()<ranks;
		if(aspect==XiangqiColor.BLACK){
			where=convertCoordinateToBlack(where);
		}
		if(validCoordinate){
			return board[where.getRank()][where.getFile()];
		}
		else{
			return XiangqiPieceImpl.makePiece(XiangqiPieceType.NONE, XiangqiColor.NONE);
		}
	}
	
	/**
	 * Get the color of the game board
	 * @return RED or BLACK
	 */
	public XiangqiColor getBoardColor(){
		return boardColor;
	}
	
	public void makeMove(XiangqiCoordinate source, XiangqiCoordinate dest) {
		if(boardColor==XiangqiColor.BLACK){
			source=convertCoordinateToBlack(source);
			dest=convertCoordinateToBlack(dest);
		}	
		board[dest.getRank()][dest.getFile()]=board[source.getRank()][source.getFile()];
		board[source.getRank()][source.getFile()]=
				XiangqiPieceImpl.makePiece(XiangqiPieceType.NONE, XiangqiColor.NONE);
		alterColor();
	}
	
	/**
	 * Update the general location
	 * @param dest the new location
	 */
	public void updateGeneralLocation(XiangqiCoordinate dest){
		if(boardColor==XiangqiColor.RED){
			redGeneralLocation=makeCoordinate(dest.getRank(),dest.getFile());
		}
		else{
			blackGeneralLocation=makeCoordinate(dest.getRank(),dest.getFile());
		}
	}
	
	/**
	 * Get the numbers of piece from a coordinate to another coordinate
	 * @param from the start location(exclusive)
	 * @param to the end location(exclusive)
	 * @return
	 */
	public int getNumberPieceOrthogonalPathBtw(XiangqiCoordinateImpl from,XiangqiCoordinateImpl to) {
		if(boardColor==XiangqiColor.BLACK){
			from=convertCoordinateToBlack(from);
			to=convertCoordinateToBlack(to);
		}
		if(from.getRank()==to.getRank()){
			return getNumberPieceInRankBetween(from.getRank(),from.getFile(),to.getFile());
		}
		else{
			return getNumberPieceInFileBetween(to.getFile(), from.getRank(),to.getRank());
		}
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

	private XiangqiCoordinateImpl convertCoordinateToBlack(XiangqiCoordinate c){
		return makeCoordinate(ranks-c.getRank(),files-c.getFile());
	}
	
	private void alterColor(){
		boardColor=(boardColor==XiangqiColor.BLACK)?XiangqiColor.RED:XiangqiColor.BLACK;
	}
	

}
