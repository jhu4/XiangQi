package xiangqiPieceRule;

import xiangqi.common.XiangqiCoordinate;
import xiangqi.common.XiangqiPieceType;
import xiangqi.studentjhu4.XiangqiBoard;
import xiangqi.studentjhu4.XiangqiCoordinateImpl;

public class NoneRule extends XiangqiPieceRule{
	
	public NoneRule(XiangqiPieceType type) {
		super(type);
	}
	
	@Override
	public boolean testSpecificRule(XiangqiBoard board, XiangqiCoordinate source, XiangqiCoordinate destination) {
		return false;
	}	
}
