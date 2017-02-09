package xiangqiPieceRule;

import xiangqi.common.XiangqiCoordinate;
import xiangqi.common.XiangqiPieceType;
import xiangqi.studentjhu4.XiangqiBoard;
import xiangqi.studentjhu4.XiangqiCoordinateImpl;

public class ChariotRule extends XiangqiPieceRule {

	public ChariotRule(XiangqiPieceType type) {
		super(type);
	}

	@Override
	public boolean test(XiangqiBoard board, XiangqiCoordinate source, XiangqiCoordinate destination) {
		return testCoordinateMoveRule(source,destination);
	}
}
