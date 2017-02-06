package xiangqi.studentjhu4;

import xiangqi.common.MoveResult;
import xiangqi.common.XiangqiColor;
import xiangqi.common.XiangqiCoordinate;
import xiangqi.common.XiangqiGame;
import xiangqi.common.XiangqiPiece;
import xiangqi.common.XiangqiPieceType;

public class AlphaXiangqiGame implements XiangqiGame {
	
	private int moveCount;
	
	public AlphaXiangqiGame(){
		this.moveCount=0;
	}
	
	@Override
	public MoveResult makeMove(XiangqiCoordinate source, XiangqiCoordinate destination) {
		if (source.getRank()==2 || destination.getRank()==2) return MoveResult.ILLEGAL;
		return moveCount++ ==0?MoveResult.OK:MoveResult.RED_WINS;
	}

	@Override
	public String getMoveMessage() {
		return "Invalid move";
	}

	@Override
	public XiangqiPiece getPieceAt(XiangqiCoordinate where, XiangqiColor aspect) {
		return XiangqiPieceImpl.makePiece(XiangqiPieceType.NONE, XiangqiColor.NONE);
	}

}
