package xiangqi.studentjhu4.xiangqiPieceRule;

import xiangqi.common.XiangqiColor;
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
		if(isFlyingGeneralMove(board,dest)){
			return this.calculatePiecesOnOrthogonalPath(board, source, dest)==0;
		}
		else{
			return versionRule(board,source,dest)
					&& oneDistanceRule(source,dest);
		}
	}

	private boolean versionRule(XiangqiBoard board, XiangqiCoordinate source, XiangqiCoordinate dest){
		switch (version){
			case BETA_XQ:
				return destFileBoundaryRule(2,4,dest)
						&& destRankBoundaryRule(1,1,dest);
			case GAMMA_XQ:
			case DELTA_XQ:
				return destRankBoundaryRule(1,3,dest)
							&& destFileBoundaryRule(4,6,dest);
			default:
				System.out.println("GeneralRule::versionRule default");
		}
		return true;
	}
	
	private boolean isFlyingGeneralMove(XiangqiBoard board, XiangqiCoordinate dest){
		XiangqiCoordinate G=board.getOpponentGeneralLocation();
		if(G.getFile()==dest.getFile() 
				&& G.getRank()==dest.getRank()){
			return true;
		}
		return false;
	}
}
