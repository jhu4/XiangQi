package xiangqi.studentjhu4;

import xiangqi.common.XiangqiColor;
import xiangqi.common.XiangqiCoordinate;
import xiangqi.common.XiangqiPiece;

public interface XiangqiBoard {
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
	XiangqiPiece getPieceAt(XiangqiCoordinate where, XiangqiColor aspect);
	
}
