package xiangqi.studentjhu4.xiangqiPieceRule;

import static xiangqi.studentjhu4.XiangqiCoordinateImpl.makeCoordinate;
import static xiangqi.studentjhu4.xiangqiPieceRule.CoordinateValidatorFactory.makeValidators;

import java.util.Iterator;
import java.util.List;
import java.util.function.BiPredicate;

import xiangqi.common.XiangqiColor;
import xiangqi.common.XiangqiCoordinate;
import xiangqi.common.XiangqiGameVersion;
import xiangqi.common.XiangqiPiece;
import xiangqi.common.XiangqiPieceType;
import xiangqi.studentjhu4.XiangqiBoard;
import xiangqi.studentjhu4.XiangqiCoordinateImpl;

public abstract class XiangqiPieceRule {
	protected final List<BiPredicate<XiangqiCoordinateImpl, XiangqiCoordinateImpl>> coordinateValidator;
	protected final XiangqiGameVersion version;
	public XiangqiPieceRule(XiangqiPieceType type,XiangqiGameVersion version){
		this.coordinateValidator=makeValidators(type);
		this.version=version;
	}
	
	/**
	 * The main test method for a specific Rule
	 * @param board The game board
	 * @param source The source coordinate
	 * @param dest The destination coordinate on the board
	 * @return true if the move is valid, false otherwise
	 */
	public boolean test(XiangqiBoard board, XiangqiCoordinate source, XiangqiCoordinate dest){
		return testCommonRule(board,source,dest) && testSpecificRule(board,source,dest);
	}
	
	/**
	 * Mocking the one's move testing regardless of the real color on the board
	 * @param board The game board
	 * @param source The source coordinate
	 * @param dest The destination coordinate on the board
	 * @return true if the move is valid, false otherwise
	 */
	public boolean mockTest(XiangqiBoard board, XiangqiCoordinate source, XiangqiCoordinate dest,XiangqiColor enemyAspect){
		XiangqiCoordinate src=board.getBoardColor()==enemyAspect?source:board.convertCoordinateToOtherColor(source);
		XiangqiCoordinate des=board.getBoardColor()==enemyAspect?dest:board.convertCoordinateToOtherColor(dest);
		return testDestNotOutOfBoundRule(board,source,dest)
				&& testCoordinateMoveRule(source,dest)
				&& testSpecificRule(board,src,des);
	}
	
	/**
	 * The Common rules test method for any Rule
	 * @param board The game board
	 * @param source The source coordinate
	 * @param dest The destination coordinate on the board
	 * @return true if the move is valid for common rules, false otherwise
	 */
	protected boolean testCommonRule(XiangqiBoard board, XiangqiCoordinate source, XiangqiCoordinate dest){
		return testDestNotOutOfBoundRule(board,source,dest)
				&& testNotControllingEnemyRule(board,source)
				&& testCoordinateMoveRule(source,dest)
				&& testCannotEatSameColorRule(board,source,dest);
	}
	
	/**
	 * Detailed and specific rules tester for a specific rule
	 * @param board The game board
	 * @param source The source coordinate
	 * @param dest The destination coordinate on the board
	 * @return true if rules pass, false otherwise
	 */
	protected abstract boolean testSpecificRule(XiangqiBoard board, XiangqiCoordinate source, XiangqiCoordinate dest);
	
	/**
	 * Test if a piece can do the action in simple rule in coordinate-wise
	 * @param board The game board
	 * @param source The source coordinate
	 * @return true if it can, false if it cannot
	 */
	protected boolean testCoordinateMoveRule(XiangqiCoordinate source, XiangqiCoordinate dest){
		boolean result = true;
		Iterator<BiPredicate<XiangqiCoordinateImpl, XiangqiCoordinateImpl>> iter = coordinateValidator.iterator();
		while (result && iter.hasNext()) {
			result = iter.next().test(makeCoordinate(source.getRank(), source.getFile())
					,makeCoordinate(dest.getRank(), dest.getFile()));
		}
		return result;
	}
	
	/**
	 * Test if a piece can move from source to destination in its color rule
	 * @param board The game board
	 * @param source The source coordinate
	 * @param dest The destination coordinate on the board
	 * @return true if the destination has no piece or piece in different color, false otherwise
	 */
	protected boolean testCannotEatSameColorRule(XiangqiBoard board,XiangqiCoordinate source, XiangqiCoordinate dest){
		XiangqiColor boardcolor = board.getBoardColor();
		XiangqiPiece from=board.getPieceAt(source, boardcolor);
		XiangqiPiece to=board.getPieceAt(dest, boardcolor);
		if(from.getColor()==to.getColor())
			return false;
		else
			return true;
	}
	
	/**
	 * Test the destination coordinate is not out of bound
	 * @param board The game board
	 * @param source The source coordinate
	 * @param dest The destination coordinate on the board
	 * @return true if not out of bound, false otherwise
	 */
	protected boolean testDestNotOutOfBoundRule(XiangqiBoard board,XiangqiCoordinate source, XiangqiCoordinate dest){
		int filebound=board.getExclusiveFileBound();
		int rankbound=board.getExclusiveRankBound();  
		boolean destNotOutOfBound=dest.getFile()<filebound && dest.getRank()<rankbound
				&& dest.getFile()>0 && dest.getRank()>0;
		return destNotOutOfBound;
	}
	
	/**
	 * Tester for check the player is not controlling the enemy's piece
	 * @param board The game board
	 * @param source The source coordinate
	 * @return true if the player is controlling his/her own piece, false otherwise
	 */
	protected boolean testNotControllingEnemyRule(XiangqiBoard board,XiangqiCoordinate source){
		XiangqiColor boardColor = board.getBoardColor();
		if(boardColor==board.getPieceAt(source, boardColor).getColor()){
			return true;
		}
		else{
			return false;
		}
	}
	 
	/**
	 * Calculated the distance btw 2 coordinates
	 * @param source The source coordinate
	 * @param dest The destination coordinate on the board
	 * @return x+y
	 */
	protected int calculateDistance(XiangqiCoordinate source,XiangqiCoordinate dest){
		return makeCoordinate(source.getRank(),source.getFile())
				.distanceTo(makeCoordinate(dest.getRank(),dest.getFile()));
	}
	
	/**
	 * Calculated how many the pieces in the orthogonal path
	 * @param board The game board
	 * @param source The source coordinate
	 * @param dest The destination coordinate on the board
	 * @return number of pieces in the path
	 */
	protected int calculatePiecesOnOrthogonalPath(XiangqiBoard board,XiangqiCoordinate source,XiangqiCoordinate dest){
		return board.getNumberPieceOrthogonalPathBtw(makeCoordinate(source.getRank(),source.getFile())
				,makeCoordinate(dest.getRank(),dest.getFile()));
	}
	
	/**
	 * Test whether a piece violates its moving distance(only can move to adjacent Coordinate)
	 * @param source The source coordinate
	 * @param dest The destination coordinate on the board
	 * @return true if the piece only move to its adjacent node, false otherwise 
	 */
	protected boolean oneDistanceRule(XiangqiCoordinate source,XiangqiCoordinate dest){
		return calculateDistance(source,dest)==1;
	}
	
	/**
	 * Test if the destination go out of the file boundary(inclusive)
	 * @param sm smaller boundary
	 * @param lar larger boundary
	 * @param dest the destination coordinate
	 * @return true if it is in the boundary
	 */
	protected boolean destFileBoundaryRule(int sm, int lar, XiangqiCoordinate dest){
		return dest.getFile()<=lar && dest.getFile()>=sm;
	}
	
	/**
	 * Test if the destination go out of the rank boundary(inclusive)
	 * @param sm smaller boundary
	 * @param lar larger boundary
	 * @param dest the destination coordinate
	 * @return true if it is in the boundary
	 */
	protected boolean destRankBoundaryRule(int sm, int lar, XiangqiCoordinate dest){
		return dest.getRank()<=lar && dest.getRank()>=sm;
	}
}
