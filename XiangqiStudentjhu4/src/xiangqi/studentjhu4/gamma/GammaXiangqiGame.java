package xiangqi.studentjhu4.gamma;

import static xiangqi.studentjhu4.XiangqiCoordinateImpl.makeCoordinate;

import java.util.Collection;
import java.util.HashMap;
import java.util.Stack;

import xiangqi.common.MoveResult;
import xiangqi.common.XiangqiColor;
import xiangqi.common.XiangqiCoordinate;
import xiangqi.common.XiangqiGame;
import xiangqi.common.XiangqiGameVersion;
import xiangqi.common.XiangqiPiece;
import xiangqi.common.XiangqiPieceType;
import xiangqi.studentjhu4.XiangqiBoard;
import xiangqi.studentjhu4.XiangqiBoardFactory;
import xiangqi.studentjhu4.XiangqiMove;
import xiangqi.studentjhu4.xiangqiPieceRule.XiangqiPieceRule;
import xiangqi.studentjhu4.xiangqiPieceRule.XiangqiPieceRuleFactory;

public class GammaXiangqiGame implements XiangqiGame{
	private XiangqiBoard board;
	HashMap<String,XiangqiPieceRule> rulemap;
	int moveCounter=0;
	final int MoveBound=50;
	MoveResult lastMoveResult;
	Stack<XiangqiMove> movement=new Stack<XiangqiMove>();
	
	public GammaXiangqiGame(){
		board=XiangqiBoardFactory.makeXiangqiBoard(XiangqiGameVersion.GAMMA_XQ);
		rulemap=new  HashMap<String,XiangqiPieceRule>();
		rulemap.put("",XiangqiPieceRuleFactory.makeXiangqiPieceRule(XiangqiPieceType.NONE,XiangqiGameVersion.GAMMA_XQ));
		rulemap.put("Chariot",XiangqiPieceRuleFactory.makeXiangqiPieceRule(XiangqiPieceType.CHARIOT,XiangqiGameVersion.GAMMA_XQ));
		rulemap.put("Elephant",XiangqiPieceRuleFactory.makeXiangqiPieceRule(XiangqiPieceType.ELEPHANT,XiangqiGameVersion.GAMMA_XQ));
		rulemap.put("Advisor",XiangqiPieceRuleFactory.makeXiangqiPieceRule(XiangqiPieceType.ADVISOR,XiangqiGameVersion.GAMMA_XQ));
		rulemap.put("General",XiangqiPieceRuleFactory.makeXiangqiPieceRule(XiangqiPieceType.GENERAL,XiangqiGameVersion.GAMMA_XQ));
		rulemap.put("Soldier",XiangqiPieceRuleFactory.makeXiangqiPieceRule(XiangqiPieceType.SOLDIER,XiangqiGameVersion.GAMMA_XQ));

	}
	
	@Override
	public MoveResult makeMove(XiangqiCoordinate source, XiangqiCoordinate dest) {
		MoveResult result;
		XiangqiColor boardColor=board.getBoardColor();
		XiangqiColor enemyColor=boardColor==XiangqiColor.RED?XiangqiColor.BLACK:XiangqiColor.RED;
		if(isValidMove(source,dest,board.getBoardColor())){
			movement.push(new XiangqiMove(board,source,dest));
			//update the board state
			board.updatePiecesList(source, dest);
			//here alters the board color
			board.makeMove(source,dest);
			//reverse the board state if it is illegal
			if(isGeneralUnderAttack(boardColor)){
				board.reverseMove(movement.pop());
				updateLastMoveResult(MoveResult.ILLEGAL);
				return MoveResult.ILLEGAL;
			}
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
	
	private boolean isCheckmate(XiangqiColor color){
		return isGeneralUnderAttack(color) 
				&& !canAnyPiecesSolveCheck(color);
	}
	
	private boolean canAnyPiecesSolveCheck(XiangqiColor color){
		XiangqiCoordinate futureCoordinate;
		HashMap<Integer,XiangqiPiece> copy=new HashMap<Integer,XiangqiPiece>(board.getPieces(color));
		Collection<Integer> mypiecesLocation=copy.keySet();
		for(Integer key: mypiecesLocation){
			XiangqiCoordinate loca=makeCoordinate((key-key%100)/100,key%100);
			for(int rank=1;rank<board.getExclusiveRankBound();rank++){
				for(int file=1;file<board.getExclusiveFileBound();file++){
					futureCoordinate=makeCoordinate(rank,file);
					if(isValidMove(loca,futureCoordinate,color)){
						movement.push(new XiangqiMove(board,loca,futureCoordinate));
						board.updatePiecesList(loca,futureCoordinate);
						board.makeMove(loca,futureCoordinate);
						//reverse the board state if it is illegal
						if(!isGeneralUnderAttack(color)){
							board.reverseMove(movement.pop());
							return true;
						}
						board.reverseMove(movement.pop());
					}
				}
			}
		}
		return false;
	}
	
	private boolean isGeneralUnderAttack(XiangqiColor aspect){
		XiangqiColor enemyColor=aspect==XiangqiColor.RED?XiangqiColor.BLACK:XiangqiColor.RED;
		XiangqiCoordinate thisGeneralLocationInEnemyAspect=board.convertCoordinateToOtherColor(board.getGeneralLocation(aspect));
		Collection<Integer> enemysLocation=board.getPieces(enemyColor).keySet();
		for(Integer key: enemysLocation){
			XiangqiCoordinate loca=makeCoordinate((key-key%100)/100,key%100);
			if(isValidMockMove(loca,thisGeneralLocationInEnemyAspect,enemyColor))
				return true;
		}
		return false; 
	}
	
	private boolean isValidMockMove(XiangqiCoordinate source, XiangqiCoordinate dest, XiangqiColor enemyAspect){
		XiangqiPiece pc=getPieceAt(source,enemyAspect);
		XiangqiPieceRule rule=rulemap.get(pc.getPieceType().getPrintableName());
		if(rule.mockTest(board,source, dest,enemyAspect)){
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
