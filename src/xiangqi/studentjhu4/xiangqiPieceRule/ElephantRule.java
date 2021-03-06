package xiangqi.studentjhu4.xiangqiPieceRule;

import static xiangqi.studentjhu4.XiangqiCoordinateImpl.makeCoordinate;

import xiangqi.common.XiangqiCoordinate;
import xiangqi.common.XiangqiGameVersion;
import xiangqi.common.XiangqiPieceType;
import xiangqi.studentjhu4.XiangqiBoard;

public class ElephantRule extends XiangqiPieceRule {

	public ElephantRule(XiangqiPieceType type, XiangqiGameVersion version) {
		super(type, version);
	}

	protected boolean testSpecificRule(XiangqiBoard board, XiangqiCoordinate source, XiangqiCoordinate dest) {
		return this.calculateDistance(source, dest)==4 
				&& calculatePiecesOnDiagonal(board,source,dest)==0
				&& destRankBoundaryRule(1, 5, dest);
	}
	
	private int calculatePiecesOnDiagonal(XiangqiBoard board,XiangqiCoordinate source,XiangqiCoordinate dest){
		return board.getNumberPieceDiagonalPathBtw(makeCoordinate(source.getRank(),source.getFile())
				,makeCoordinate(dest.getRank(),dest.getFile()));
	}
	
}
