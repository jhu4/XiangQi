package xiangqi.studentjhu4.xiangqiPieceRule;

import xiangqi.common.XiangqiCoordinate;
import xiangqi.common.XiangqiGameVersion;
import xiangqi.common.XiangqiPieceType;
import xiangqi.studentjhu4.XiangqiBoard;

public class AdvisorRule extends XiangqiPieceRule{

	public AdvisorRule(XiangqiPieceType type, XiangqiGameVersion version) {
		super(type, version);
	}

	@Override
	protected boolean testSpecificRule(XiangqiBoard board, XiangqiCoordinate source, XiangqiCoordinate dest) {
		return versionRule(dest) && calculateDistance(source, dest)==2;
	}

	protected boolean versionRule(XiangqiCoordinate dest){
		switch (version){
			case GAMMA_XQ:
				return destFileBoundaryRule(4,6,dest)
						&& destRankBoundaryRule(1,3,dest);
			default:
				System.out.println("GeneralRule::versionRule default");
		}
		return true;
	}
}
