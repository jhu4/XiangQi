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
	
	public boolean testCommonRule(XiangqiBoard board, XiangqiCoordinate source, XiangqiCoordinate destination){
		return testCoordinateMoveRule(source,destination)
				&& testColorMoveRule(board,source,destination);
	}
	
	public abstract boolean testSpecificRule(XiangqiBoard board, XiangqiCoordinate source, XiangqiCoordinate destination);
	
	/**
	 * Test if a piece can do the action in simple rule in coordinate-wise
	 * @param board The game board
	 * @param source The source coordinate
	 * @return true if it can, false if it cannot
	 */
	public boolean testCoordinateMoveRule(XiangqiCoordinate source, XiangqiCoordinate destination){
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
	public boolean testColorMoveRule(XiangqiBoard board,XiangqiCoordinate source, XiangqiCoordinate destination){
		XiangqiColor round = board.getRound();
		XiangqiPiece from=board.getPieceAt(source, round);
		XiangqiPiece to=board.getPieceAt(destination, round);
		if(from.getColor()==to.getColor())
			return false;
		else
			return true;
	}
}
