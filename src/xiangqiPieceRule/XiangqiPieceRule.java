package xiangqiPieceRule;

import static xiangqi.studentjhu4.XiangqiCoordinateImpl.makeCoordinate;
import static xiangqiPieceRule.CoordinateValidatorFactory.makeValidators;

import java.util.Iterator;
import java.util.List;
import java.util.function.BiPredicate;

import xiangqi.common.XiangqiColor;
import xiangqi.common.XiangqiCoordinate;
import xiangqi.common.XiangqiPiece;
import xiangqi.common.XiangqiPieceType;
import xiangqi.studentjhu4.XiangqiBoard;
import xiangqi.studentjhu4.XiangqiCoordinateImpl;

public abstract class XiangqiPieceRule {
	protected final List<BiPredicate<XiangqiCoordinateImpl, XiangqiCoordinateImpl>> coordinateValidator;
	
	public XiangqiPieceRule(XiangqiPieceType type){
		this.coordinateValidator=makeValidators(type);
	}
	
	public boolean test(XiangqiBoard board, XiangqiCoordinate source, XiangqiCoordinate destination){
		return testCommonRule(board,source,destination)&&testSpecificRule(board,source,destination);
	}
	
	protected boolean testCommonRule(XiangqiBoard board, XiangqiCoordinate source, XiangqiCoordinate destination){
		return testDestNotOutOfBoundRule(board,source,destination)
				&& testNotControllingEnemyRule(board,source)
				&& testCoordinateMoveRule(source,destination)
				&& testCannotEatSameColorRule(board,source,destination);
	}
	
	protected abstract boolean testSpecificRule(XiangqiBoard board, XiangqiCoordinate source, XiangqiCoordinate destination);
	
	/**
	 * Test if a piece can do the action in simple rule in coordinate-wise
	 * @param board The game board
	 * @param source The source coordinate
	 * @return true if it can, false if it cannot
	 */
	protected boolean testCoordinateMoveRule(XiangqiCoordinate source, XiangqiCoordinate destination){
		boolean result = true;
		Iterator<BiPredicate<XiangqiCoordinateImpl, XiangqiCoordinateImpl>> iter = coordinateValidator.iterator();
		while (result && iter.hasNext()) {
			result = iter.next().test(makeCoordinate(source.getRank(), source.getFile())
					,makeCoordinate(destination.getRank(), destination.getFile()));
		}
		return result;
	}
	
	/**
	 * Test if a piece can move from source to destination in its color rule
	 * @param board The game board
	 * @param source The source coordinate
	 * @param destination The destination coordinate on the board
	 * @return true if the destination has no piece or piece in different color, false otherwise
	 */
	protected boolean testCannotEatSameColorRule(XiangqiBoard board,XiangqiCoordinate source, XiangqiCoordinate destination){
		XiangqiColor boardcolor = board.getBoardColor();
		XiangqiPiece from=board.getPieceAt(source, boardcolor);
		XiangqiPiece to=board.getPieceAt(destination, boardcolor);
		if(from.getColor()==to.getColor())
			return false;
		else
			return true;
	}
	
	protected boolean testDestNotOutOfBoundRule(XiangqiBoard board,XiangqiCoordinate source, XiangqiCoordinate destination){
		int filebound=board.getExclusiveFileBound();
		int rankbound=board.getExclusiveRankBound();  
		boolean destNotOutOfBound=destination.getFile()<filebound && destination.getRank()<rankbound
				&& destination.getFile()>0 && destination.getRank()>0;
		return destNotOutOfBound;
	}
	
	protected boolean testNotControllingEnemyRule(XiangqiBoard board,XiangqiCoordinate source){
		XiangqiColor boardColor = board.getBoardColor();
		if(boardColor==board.getPieceAt(source, boardColor).getColor()){
			return true;
		}
		else{
			return false;
		}
	}
}
