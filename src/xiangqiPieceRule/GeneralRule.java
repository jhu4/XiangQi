package xiangqiPieceRule;

import xiangqi.common.XiangqiCoordinate;
import xiangqi.common.XiangqiPieceType;
import xiangqi.studentjhu4.XiangqiBoard;

public class GeneralRule extends XiangqiPieceRule{

	public GeneralRule(XiangqiPieceType type) {
		super(type);
	}

	@Override
	protected boolean testSpecificRule(XiangqiBoard board, XiangqiCoordinate source, XiangqiCoordinate dest) {
		return calculateDistance(source, dest)==1;
	}

}
