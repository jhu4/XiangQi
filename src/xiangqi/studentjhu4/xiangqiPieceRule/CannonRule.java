package xiangqi.studentjhu4.xiangqiPieceRule;

import xiangqi.common.XiangqiColor;
import xiangqi.common.XiangqiCoordinate;
import xiangqi.common.XiangqiGameVersion;
import xiangqi.common.XiangqiPieceType;
import xiangqi.studentjhu4.XiangqiBoard;

public class CannonRule extends XiangqiPieceRule{

	public CannonRule(XiangqiPieceType type, XiangqiGameVersion version) {
		super(type, version);
	}

	@Override
	protected boolean testSpecificRule(XiangqiBoard board, XiangqiCoordinate source, XiangqiCoordinate dest) {
		XiangqiColor color=board.getBoardColor();
		if(board.getPieceAt(dest, color).getColor()==XiangqiColor.NONE){
			return calculatePiecesOnOrthogonalPath(board, source, dest)==0;
		}
		else{
			return calculatePiecesOnOrthogonalPath(board, source, dest)==1;
		}
	}
}
