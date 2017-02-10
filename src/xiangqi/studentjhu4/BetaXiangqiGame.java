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
	int moveCounter=0;
	final int MoveBound=20;
	MoveResult lastMoveResult;
	
	public BetaXiangqiGame(){
		board=XiangqiBoardFactory.makeXiangqiBoard(XiangqiGameVersion.BETA_XQ);
		rulemap=new  HashMap<String,XiangqiPieceRule>();
		rulemap.put("",XiangqiPieceRuleFactory.makeXiangqiPieceRule(XiangqiPieceType.NONE,XiangqiGameVersion.BETA_XQ));
		rulemap.put("Chariot",XiangqiPieceRuleFactory.makeXiangqiPieceRule(XiangqiPieceType.CHARIOT,XiangqiGameVersion.BETA_XQ));
		rulemap.put("Soldier",XiangqiPieceRuleFactory.makeXiangqiPieceRule(XiangqiPieceType.SOLDIER,XiangqiGameVersion.BETA_XQ));
		rulemap.put("Advisor",XiangqiPieceRuleFactory.makeXiangqiPieceRule(XiangqiPieceType.ADVISOR,XiangqiGameVersion.BETA_XQ));
		rulemap.put("General",XiangqiPieceRuleFactory.makeXiangqiPieceRule(XiangqiPieceType.GENERAL,XiangqiGameVersion.BETA_XQ));
	}
	
	@Override
	public MoveResult makeMove(XiangqiCoordinate source, XiangqiCoordinate destination){
		MoveResult result;
		if(isValidMove(source,destination,board.getBoardColor())){
			board.makeMove(source,destination);
			moveCounter++;
			result=(moveCounter>=MoveBound)?MoveResult.DRAW:MoveResult.OK;
		}
		else{
			result=MoveResult.ILLEGAL;
		}
		updateLastMoveResult(result);
		return result;
	}

	@Override
	public String getMoveMessage() {
		return lastMoveResult==MoveResult.ILLEGAL?"ILLEGAL MOVE":null;
	}

	@Override
	public XiangqiPiece getPieceAt(XiangqiCoordinate where, XiangqiColor aspect) {
		return board.getPieceAt(where, aspect);
	}
	
	public XiangqiColor whoseRound(){
		return board.getBoardColor();
	}
	
	/**
	 * Test if it is a valid move
	 * @param source Coordinate
	 * @param destination Coordinate 
	 * @return true if it is a valid move
	 */
	private boolean isValidMove(XiangqiCoordinate source, XiangqiCoordinate destination, XiangqiColor aspect){
		XiangqiPiece pc=getPieceAt(source,aspect);
		XiangqiPieceRule rule=rulemap.get(pc.getPieceType().getPrintableName());
		if(rule.test(board, source, destination)){
			return true;
		}
		else{
			return false;
		}
	}
	
	private void updateLastMoveResult(MoveResult mr){
		this.lastMoveResult=mr;
	}
}
