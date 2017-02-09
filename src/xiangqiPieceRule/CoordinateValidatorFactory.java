package xiangqiPieceRule;

import java.util.LinkedList;
import java.util.List;
import java.util.function.BiPredicate;

import xiangqi.common.XiangqiPieceType;
import xiangqi.studentjhu4.XiangqiCoordinateImpl;



public class CoordinateValidatorFactory {
	private static BiPredicate<XiangqiCoordinateImpl, XiangqiCoordinateImpl> orthogonalValidator = 
			(XiangqiCoordinateImpl c1, XiangqiCoordinateImpl c2) -> c1.isOrthogonal(c2);
	private static BiPredicate<XiangqiCoordinateImpl, XiangqiCoordinateImpl> diagonalValidator = 
			(XiangqiCoordinateImpl c1, XiangqiCoordinateImpl c2) -> c1.isDiagonal(c2);
			
	private static BiPredicate<XiangqiCoordinateImpl, XiangqiCoordinateImpl> sameFileValidator = 
			(XiangqiCoordinateImpl c1, XiangqiCoordinateImpl c2) -> c1.isSameFile(c2);
	private static BiPredicate<XiangqiCoordinateImpl, XiangqiCoordinateImpl> sameRankValidator = 
			(XiangqiCoordinateImpl c1, XiangqiCoordinateImpl c2) -> c1.isSameRank(c2);
			
	private static BiPredicate<XiangqiCoordinateImpl, XiangqiCoordinateImpl> forwardValidator = 
			(XiangqiCoordinateImpl c1, XiangqiCoordinateImpl c2) -> c1.isForward(c2);
			
	public static List<BiPredicate<XiangqiCoordinateImpl, XiangqiCoordinateImpl>> makeValidators(XiangqiPieceType type)
	{
		List<BiPredicate<XiangqiCoordinateImpl, XiangqiCoordinateImpl>> validators = 
				new LinkedList<BiPredicate<XiangqiCoordinateImpl, XiangqiCoordinateImpl>>();
		switch (type.getPrintableName()) {
			case "Chariot":
				validators.add(orthogonalValidator);
				break;
			case "Soldier":
				validators.add(sameFileValidator);
				validators.add(forwardValidator);
			default:
				//not yet implemented or None type
				break;
		}
		return validators;
	}
}
