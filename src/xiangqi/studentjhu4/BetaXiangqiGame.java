package xiangqi.studentjhu4;

import java.util.HashMap;
import xiangqi.common.MoveResult;
import xiangqi.common.XiangqiColor;
import xiangqi.common.XiangqiCoordinate;
import xiangqi.common.XiangqiGame;
import xiangqi.common.XiangqiGameVersion;
import xiangqi.common.XiangqiPiece;
import xiangqi.common.XiangqiPieceType;
import xiangqiPieceRule.XiangqiPieceRule;
import xiangqiPieceRule.XiangqiPieceRuleFactory;

public class BetaXiangqiGame implements XiangqiGame {
	private XiangqiBoard board;
	 HashMap<String,XiangqiPieceRule> rulemap;
	 
	public BetaXiangqiGame(){
		board=XiangqiBoardFactory.makeXiangqiBoard(XiangqiGameVersion.BETA_XQ);
		rulemap=new  HashMap<String,XiangqiPieceRule>();
		rulemap.put("",XiangqiPieceRuleFactory.makeXiangqiPieceRule(XiangqiPieceType.NONE));
		rulemap.put("Chariot",XiangqiPieceRuleFactory.makeXiangqiPieceRule(XiangqiPieceType.CHARIOT));
	}
	
	@Override
	public MoveResult makeMove(XiangqiCoordinate source, XiangqiCoordinate destination){
		XiangqiPiece pc=getPieceAt(source,XiangqiColor.RED);
		XiangqiPieceRule rule=rulemap.get(pc.getPieceType().getPrintableName());
		
		if(rule.test(board, source, destination)){
			return MoveResult.OK;
		}
		else{
			return MoveResult.ILLEGAL;
		}
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
