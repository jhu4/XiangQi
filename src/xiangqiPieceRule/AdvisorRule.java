package xiangqiPieceRule;

import xiangqi.common.XiangqiCoordinate;
import xiangqi.common.XiangqiPieceType;
import xiangqi.studentjhu4.XiangqiBoard;

public class AdvisorRule extends XiangqiPieceRule{

	public AdvisorRule(XiangqiPieceType type) {
		super(type);
	}

	@Override
	protected boolean testSpecificRule(XiangqiBoard board, XiangqiCoordinate source, XiangqiCoordinate dest) {
		return calculateDistance(source, dest)==2;
	}

}
