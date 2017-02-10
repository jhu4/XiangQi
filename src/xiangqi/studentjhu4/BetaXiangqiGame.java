package xiangqi.studentjhu4;

import java.util.Collection;
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
import static xiangqi.studentjhu4.XiangqiCoordinateImpl.makeCoordinate;

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
	public MoveResult makeMove(XiangqiCoordinate source, XiangqiCoordinate dest){
		MoveResult result;
		XiangqiColor boardColor=board.getBoardColor();
		XiangqiColor enemyColor=board.getBoardColor()==XiangqiColor.RED?XiangqiColor.BLACK:XiangqiColor.RED;
		if(isValidMove(source,dest,board.getBoardColor())){
			XiangqiPiece pc=board.getPieceAt(source,board.getBoardColor());
			if(pc.getPieceType()==XiangqiPieceType.GENERAL){
				board.updateGeneralLocation(dest);
			}
			else{
				board.updatePiecesLocations(source, dest);
			}
			board.makeMove(source,dest);
			moveCounter++;
			result=(moveCounter>=MoveBound)?MoveResult.DRAW:MoveResult.OK;
			if(isCheckmate(enemyColor)){
				result=boardColor==XiangqiColor.RED?MoveResult.RED_WINS:MoveResult.BLACK_WINS;
			} 
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
		
	private boolean isValidMove(XiangqiCoordinate source, XiangqiCoordinate dest, XiangqiColor aspect){
		XiangqiPiece pc=getPieceAt(source,aspect);
		XiangqiPieceRule rule=rulemap.get(pc.getPieceType().getPrintableName());
		if(rule.test(board, source, dest)){
			return true;
		}
		else{
			return false;
		}
	}
	
	private boolean isValidMockMove(XiangqiCoordinate source, XiangqiCoordinate dest, XiangqiColor aspect){
		XiangqiPiece pc=getPieceAt(source,aspect);
		XiangqiPieceRule rule=rulemap.get(pc.getPieceType().getPrintableName());
		if(rule.mockTest(board, source, dest)){
			return true;
		}
		else{
			return false;
		}
	}
	
	private void updateLastMoveResult(MoveResult mr){
		this.lastMoveResult=mr;
	}
	
	
	private boolean isGeneralUnderAttack(XiangqiColor aspect){
		XiangqiColor enemyColor=aspect==XiangqiColor.RED?XiangqiColor.BLACK:XiangqiColor.RED;
		XiangqiCoordinate generalLocationInEnemyAspect=
				board.convertCoordinateToOtherColor(board.getGeneralLocation(aspect));
		Collection<Integer> enemysLocation=board.getPieces(enemyColor).keySet();
		for(Integer key: enemysLocation){
			XiangqiCoordinate loca=makeCoordinate((key-key%100)/100,key%100);
			if(isValidMockMove(loca,generalLocationInEnemyAspect,enemyColor))
				return true;
		} 
		return false; 
	}
	
	private boolean isCheckmate(XiangqiColor aspect){
		return isGeneralUnderAttack(aspect);
	}
}
