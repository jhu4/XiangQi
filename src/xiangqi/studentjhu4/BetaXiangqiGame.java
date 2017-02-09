package xiangqi.studentjhu4;

import java.util.Iterator;
import java.util.List;
import java.util.function.BiPredicate;

import xiangqi.common.MoveResult;
import xiangqi.common.XiangqiColor;
import xiangqi.common.XiangqiCoordinate;
import xiangqi.common.XiangqiGame;
import xiangqi.common.XiangqiGameVersion;
import xiangqi.common.XiangqiPiece;
import static xiangqi.studentjhu4.ValidatorFactory.makeValidators;
import static xiangqi.studentjhu4.XiangqiCoordinateImpl.makeCoordinate;

public class BetaXiangqiGame implements XiangqiGame {
	private XiangqiBoard board;
	
	public BetaXiangqiGame(){
		board=XiangqiBoardFactory.makeXiangqiBoard(XiangqiGameVersion.BETA_XQ);
	}
	
	@Override
	public MoveResult makeMove(XiangqiCoordinate source, XiangqiCoordinate destination){
		final List<BiPredicate<XiangqiCoordinateImpl, XiangqiCoordinateImpl>> chessValidators=
				makeValidators(getPieceAt(source,XiangqiColor.RED).getPieceType());
		
		boolean result = true;
		Iterator<BiPredicate<XiangqiCoordinateImpl, XiangqiCoordinateImpl>> iter = chessValidators.iterator();
		while (result && iter.hasNext()) {
			result = iter.next().test(makeCoordinate(source.getRank(), source.getRank())
					, makeCoordinate(destination.getRank(), destination.getFile()));
		}
		if(result) return MoveResult.OK;
		else return MoveResult.ILLEGAL;
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
