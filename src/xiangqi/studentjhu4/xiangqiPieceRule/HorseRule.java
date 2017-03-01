package xiangqi.studentjhu4.xiangqiPieceRule;

import xiangqi.common.XiangqiColor;
import xiangqi.common.XiangqiCoordinate;
import xiangqi.common.XiangqiGameVersion;
import xiangqi.common.XiangqiPieceType;
import xiangqi.studentjhu4.XiangqiBoard;
import static xiangqi.studentjhu4.XiangqiCoordinateImpl.makeCoordinate;

public class HorseRule extends XiangqiPieceRule{

	public HorseRule(XiangqiPieceType type, XiangqiGameVersion version) {
		super(type, version);
	}

	@Override
	protected boolean testSpecificRule(XiangqiBoard board, XiangqiCoordinate source, XiangqiCoordinate dest) {
		if(calculateDistance(source, dest)==3){
			int direction;
			XiangqiCoordinate coor;
			if(Math.abs(source.getFile()-dest.getFile())==2){
				direction=dest.getFile()>source.getFile()?1:-1;
				coor=makeCoordinate(source.getRank(),source.getFile()+direction);
				if(board.getPieceAt(coor,board.getBoardColor()).getColor()==XiangqiColor.NONE){
					return true;
				}
			}
			else{
				direction=dest.getRank()>source.getRank()?1:-1;
				coor=makeCoordinate(source.getRank()+direction,source.getFile());
				if(board.getPieceAt(coor,board.getBoardColor()).getColor()==XiangqiColor.NONE){
					return true;
				}
			}
		
		}
		return false;
	}
}
