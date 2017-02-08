package xiangqi.studentjhu4;

import xiangqi.common.XiangqiColor;
import xiangqi.common.XiangqiCoordinate;
import xiangqi.common.XiangqiPiece;
import xiangqi.common.XiangqiPieceType;

public abstract class XiangqiBoard{
	protected XiangqiPiece[][] board;
	protected int ranks;
	protected int files;
	protected int round=1;
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
		if(aspect==XiangqiColor.RED){
			return board[where.getRank()][where.getFile()];
		}
		else if(aspect==XiangqiColor.BLACK){
			return board[ranks-where.getRank()][files-where.getFile()];
		}
		else{
			return XiangqiPieceImpl.makePiece(XiangqiPieceType.NONE, XiangqiColor.NONE);
		}
	}
}
