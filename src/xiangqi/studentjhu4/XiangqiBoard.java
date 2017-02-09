package xiangqi.studentjhu4;

import xiangqi.common.XiangqiColor;
import xiangqi.common.XiangqiCoordinate;
import xiangqi.common.XiangqiPiece;
import xiangqi.common.XiangqiPieceType;

public abstract class XiangqiBoard{
	protected XiangqiPiece[][] board;
	protected int ranks;
	protected int files;
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
										
		if(aspect==XiangqiColor.RED && validCoordinate){
			return board[where.getRank()][where.getFile()];
		}
		else if(aspect==XiangqiColor.BLACK && validCoordinate){
			return board[ranks-where.getRank()][files-where.getFile()];
		}
		else{
			return XiangqiPieceImpl.makePiece(XiangqiPieceType.NONE, XiangqiColor.NONE);
		}
	}
	
	public XiangqiColor getBoardColor(){
		return boardColor;
	}
	
	private void alterColor(){
		boardColor=(boardColor==XiangqiColor.BLACK)?XiangqiColor.RED:XiangqiColor.BLACK;
	}

	public void makeMove(XiangqiCoordinate source, XiangqiCoordinate destination) {
		if(boardColor==XiangqiColor.RED){
			board[destination.getRank()][destination.getFile()]=board[source.getRank()][source.getFile()];
			board[source.getRank()][source.getFile()]=
					XiangqiPieceImpl.makePiece(XiangqiPieceType.NONE, XiangqiColor.NONE);
		}
		else{
			board[ranks-destination.getRank()][files-destination.getFile()]=
					board[ranks-source.getRank()][files-source.getRank()];
			board[ranks-source.getRank()][files-source.getRank()]=
					XiangqiPieceImpl.makePiece(XiangqiPieceType.NONE, XiangqiColor.NONE);
		}
		alterColor();
	}
	
	public int getExclusiveRankBound(){
		return this.ranks;
	}
	
	public int getExclusiveFileBound(){
		return this.files;
	}
}
