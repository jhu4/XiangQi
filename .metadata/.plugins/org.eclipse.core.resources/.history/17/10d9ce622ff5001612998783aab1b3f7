package xiangqi.studentjhu4.xiangqiPieceRule;

import xiangqi.common.XiangqiCoordinate;
import xiangqi.common.XiangqiGameVersion;
import xiangqi.common.XiangqiPieceType;
import xiangqi.studentjhu4.XiangqiBoard;

public class GeneralRule extends XiangqiPieceRule{

	
	public GeneralRule(XiangqiPieceType type, XiangqiGameVersion version) {
		super(type, version);
	}

	@Override
	protected boolean testSpecificRule(XiangqiBoard board, XiangqiCoordinate source, XiangqiCoordinate dest) {
		return versionRule(dest)
				&& oneDistanceRule(source,dest);
	}

	private boolean versionRule( XiangqiCoordinate dest){
		switch (version){
			case BETA_XQ:
				return destFileBoundaryRule(2,4,dest)
						&& destRankBoundaryRule(1,1,dest);
			default:
				System.out.println("GeneralRule::versionRule default");
		}
		return true;
	}

}
