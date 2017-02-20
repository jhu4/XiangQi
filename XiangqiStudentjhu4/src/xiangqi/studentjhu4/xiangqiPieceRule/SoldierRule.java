package xiangqi.studentjhu4.xiangqiPieceRule;

import xiangqi.common.XiangqiCoordinate;
import xiangqi.common.XiangqiGameVersion;
import xiangqi.common.XiangqiPieceType;
import xiangqi.studentjhu4.XiangqiBoard;

public class SoldierRule extends XiangqiPieceRule{
	
	public SoldierRule(XiangqiPieceType type, XiangqiGameVersion version) {
		super(type, version);
	}

	@Override
	protected boolean testSpecificRule(XiangqiBoard board, XiangqiCoordinate source, XiangqiCoordinate dest) {
		if(version==XiangqiGameVersion.GAMMA_XQ && isOverRiver(board,source)){
			return calculateDistance(source, dest)==1;
		}
		return calculateDistance(source, dest)==1 && source.getFile()==dest.getFile();
	}
	
	private boolean isOverRiver(XiangqiBoard board, XiangqiCoordinate source){
		return source.getRank()>=board.getRiverBound();
	}
}
