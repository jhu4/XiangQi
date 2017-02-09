package xiangqiPieceRule;

import xiangqi.common.XiangqiCoordinate;
import xiangqi.common.XiangqiPieceType;
import xiangqi.studentjhu4.XiangqiBoard;

public class SoldierRule extends XiangqiPieceRule{
	
	public SoldierRule(XiangqiPieceType type) {
		super(type);
	}

	@Override
	protected boolean testSpecificRule(XiangqiBoard board, XiangqiCoordinate source, XiangqiCoordinate dest) {
		return this.calculateDistance(source, dest)==1;
	}
}
