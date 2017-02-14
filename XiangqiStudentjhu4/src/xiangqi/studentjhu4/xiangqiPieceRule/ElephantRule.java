package xiangqi.studentjhu4.xiangqiPieceRule;

import xiangqi.common.XiangqiCoordinate;
import xiangqi.common.XiangqiGameVersion;
import xiangqi.common.XiangqiPieceType;
import xiangqi.studentjhu4.XiangqiBoard;

public class ElephantRule extends XiangqiPieceRule {

	public ElephantRule(XiangqiPieceType type, XiangqiGameVersion version) {
		super(type, version);
	}

	protected boolean testSpecificRule(XiangqiBoard board, XiangqiCoordinate source, XiangqiCoordinate dest) {
		return this.calculateDistance(source, dest)==4;
	}

}
