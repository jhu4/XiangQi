package xiangqi.studentjhu4;

import static xiangqi.studentjhu4.XiangqiCoordinateImpl.makeCoordinate;

import java.util.Collection;
import java.util.HashMap;
import java.util.Stack;

import xiangqi.common.MoveResult;
import xiangqi.common.XiangqiColor;
import xiangqi.common.XiangqiCoordinate;
import xiangqi.common.XiangqiGame;
import xiangqi.common.XiangqiPiece;
import xiangqi.studentjhu4.xiangqiPieceRule.XiangqiPieceRule;

public class XiangqiGameImpl implements XiangqiGame{
	protected XiangqiBoard board;
	protected HashMap<String,XiangqiPieceRule> rulemap;
	protected int moveCounter=0;
	protected int moveBound;
	protected MoveResult lastMoveResult;
	protected Stack<XiangqiMove> movement=new Stack<XiangqiMove>();
	
	@Override
	public MoveResult makeMove(XiangqiCoordinate source, XiangqiCoordinate dest) {
		MoveResult result;
		XiangqiColor boardColor=board.getBoardColor();
		XiangqiColor enemyColor=boardColor==XiangqiColor.RED?XiangqiColor.BLACK:XiangqiColor.RED;
		if(isValidMove(source,dest,board.getBoardColor())){
			//save a copy of the board state before the move
			movement.push(new XiangqiMove(board,source,dest));
			//update the board state
			board.updatePiecesList(source, dest);
			//here alters the board color and actually make a move
			board.makeMove(source,dest);
			XiangqiMove newMove=new XiangqiMove(board,source,dest);
			//check repetition moves
			if(isRepetitiveMove(newMove,boardColor)){
				return boardColor==XiangqiColor.RED?MoveResult.BLACK_WINS:MoveResult.RED_WINS;
			}
			//reverse the board state if it is illegal
			if(isGeneralUnderAttack(boardColor)){
				board.reverseMove(movement.pop());
				updateLastMoveResult(MoveResult.ILLEGAL);
				return MoveResult.ILLEGAL;
			}
			updateChecker(boardColor,newMove);
			moveCounter++;
			result=(moveCounter>=moveBound)?MoveResult.DRAW:MoveResult.OK;
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
	
	protected boolean isValidMove(XiangqiCoordinate source, XiangqiCoordinate dest, XiangqiColor aspect){
		XiangqiPiece pc;
		try{
			pc=getPieceAt(source,aspect);
		}
		catch(Exception e){
			return false;
		}
		XiangqiPieceRule rule=rulemap.get(pc.getPieceType().getPrintableName());
		if(rule.test(board, source, dest)){
			return true;
		}
		else{
			return false;
		}
	}
	
	protected void updateChecker(XiangqiColor aspect, XiangqiMove move){
		//doing nothing
	}
	
	protected boolean isRepetitiveMove(XiangqiMove move, XiangqiColor aspect){
		return false;
	}
	
	protected boolean isCheckmate(XiangqiColor color){
		return isGeneralUnderAttack(color) 
				&& !canAnyPiecesSolveCheck(color);
	}
	
	protected boolean canAnyPiecesSolveCheck(XiangqiColor color){
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
	
	protected boolean isGeneralUnderAttack(XiangqiColor aspect){
		XiangqiColor enemyColor=aspect==XiangqiColor.RED?XiangqiColor.BLACK:XiangqiColor.RED;
		XiangqiCoordinate thisGeneralLocationInEnemyAspect=board.convertCoordinateToOtherColor(board.getGeneralLocation(aspect));
		Collection<Integer> enemysLocation=board.getPieces(enemyColor).keySet();
		for(Integer key: enemysLocation){
			XiangqiCoordinate loca=makeCoordinate((key-key%100)/100,key%100);
			if(isValidVirtualMove(loca,thisGeneralLocationInEnemyAspect,enemyColor))
				return true;
		}
		return false; 
	}
	
	protected boolean isValidVirtualMove(XiangqiCoordinate source, XiangqiCoordinate dest, XiangqiColor enemyAspect){
		XiangqiPiece pc=getPieceAt(source,enemyAspect);
		XiangqiPieceRule rule=rulemap.get(pc.getPieceType().getPrintableName());
		if(rule.virtualTest(board,source, dest,enemyAspect)){
			return true;
		}
		else{
			return false;
		}
	}
	
	protected void updateLastMoveResult(MoveResult mr){
		this.lastMoveResult=mr;
	}
}
