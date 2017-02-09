package xiangqi.studentjhu4;

import java.util.LinkedList;
import java.util.List;
import java.util.function.BiPredicate;

import xiangqi.common.XiangqiPieceType;



public class ValidatorFactory {
	private static BiPredicate<XiangqiCoordinateImpl, XiangqiCoordinateImpl> orthogonalValidator = 
			(XiangqiCoordinateImpl c1, XiangqiCoordinateImpl c2) -> c1.isOrthogonal(c2);

	public static List<BiPredicate<XiangqiCoordinateImpl, XiangqiCoordinateImpl>> makeValidators(XiangqiPieceType type)
	{
		List<BiPredicate<XiangqiCoordinateImpl, XiangqiCoordinateImpl>> validators = 
				new LinkedList<BiPredicate<XiangqiCoordinateImpl, XiangqiCoordinateImpl>>();
		switch (type.getPrintableName()) {
			case "Chariot":
				System.out.println("Chariot Validator");
				validators.add(orthogonalValidator);
				break;
			default:
				System.out.println("Not yet implemented");
				break;
		}
		return validators;
	}
}
