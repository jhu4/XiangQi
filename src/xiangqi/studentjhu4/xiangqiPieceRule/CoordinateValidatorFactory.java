package xiangqi.studentjhu4.xiangqiPieceRule;

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
	private static BiPredicate<XiangqiCoordinateImpl, XiangqiCoordinateImpl> notBackwardValidator = 
			(XiangqiCoordinateImpl c1, XiangqiCoordinateImpl c2) -> c1.isNotBackward(c2);
	private static BiPredicate<XiangqiCoordinateImpl, XiangqiCoordinateImpl> notOrthogonalValidator = 
			(XiangqiCoordinateImpl c1, XiangqiCoordinateImpl c2) -> !c1.isOrthogonal(c2);
	private static BiPredicate<XiangqiCoordinateImpl, XiangqiCoordinateImpl> notDiagonalValidator = 
			(XiangqiCoordinateImpl c1, XiangqiCoordinateImpl c2) -> !c1.isDiagonal(c2);			
			
	public static List<BiPredicate<XiangqiCoordinateImpl, XiangqiCoordinateImpl>> makeValidators(XiangqiPieceType type)
	{
		List<BiPredicate<XiangqiCoordinateImpl, XiangqiCoordinateImpl>> validators = 
				new LinkedList<BiPredicate<XiangqiCoordinateImpl, XiangqiCoordinateImpl>>();
		switch (type.getPrintableName()) {
			case "Chariot":
				validators.add(orthogonalValidator);
				break;
			case "Soldier":
				validators.add(notBackwardValidator);
				break;
			case "Advisor":
				validators.add(diagonalValidator);
				break;
			case "General":
				validators.add(orthogonalValidator);
				break;
			case "Elephant":
				validators.add(diagonalValidator);
				break;
			case "Cannon":
				validators.add(orthogonalValidator);
				break;
			case "Horse":
				validators.add(notOrthogonalValidator);
				validators.add(notDiagonalValidator);
				break;	
			default:
				//not yet implemented or None type
				break;
		}
		return validators;
	}
}
