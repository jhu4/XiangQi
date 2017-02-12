package xiangqi.studentjhu4.gamma;

import xiangqi.common.MoveResult;
import xiangqi.common.XiangqiColor;
import xiangqi.common.XiangqiCoordinate;
import xiangqi.common.XiangqiGame;
import xiangqi.common.XiangqiGameVersion;
import xiangqi.common.XiangqiPiece;
import xiangqi.studentjhu4.XiangqiBoard;
import xiangqi.studentjhu4.XiangqiBoardFactory;

public class GammaXiangqiGame implements XiangqiGame{
	private XiangqiBoard board;
	
	
	public GammaXiangqiGame(){
		board=XiangqiBoardFactory.makeXiangqiBoard(XiangqiGameVersion.GAMMA_XQ);
		
	}
	@Override
	public MoveResult makeMove(XiangqiCoordinate source, XiangqiCoordinate destination) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMoveMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XiangqiPiece getPieceAt(XiangqiCoordinate where, XiangqiColor aspect) {
		return board.getPieceAt(where, aspect);
	}

}
