package xiangqiPieceRule;

import static xiangqi.studentjhu4.XiangqiCoordinateImpl.makeCoordinate;
import static xiangqiPieceRule.CoordinateValidatorFactory.makeValidators;

import java.util.Iterator;
import java.util.List;
import java.util.function.BiPredicate;

import xiangqi.common.XiangqiCoordinate;
import xiangqi.common.XiangqiPieceType;
import xiangqi.studentjhu4.XiangqiBoard;
import xiangqi.studentjhu4.XiangqiCoordinateImpl;

public abstract class XiangqiPieceRule {
	protected XiangqiPieceType type;
	protected final List<BiPredicate<XiangqiCoordinateImpl, XiangqiCoordinateImpl>> coordinateValidator;
	
	public XiangqiPieceRule(XiangqiPieceType type){
		this.type=type;
		this.coordinateValidator=makeValidators(type);
	}
	
	public abstract boolean test(XiangqiBoard board, XiangqiCoordinate source, XiangqiCoordinate destination);
	
	public XiangqiPieceType getPieceRuleType(){
		return type;
	}
	
	public boolean testCoordinateMoveRule(XiangqiCoordinate source, XiangqiCoordinate destination){
		boolean result = true;
		Iterator<BiPredicate<XiangqiCoordinateImpl, XiangqiCoordinateImpl>> iter = coordinateValidator.iterator();
		while (result && iter.hasNext()) {
			result = iter.next().test(makeCoordinate(source.getRank(), source.getFile())
					,makeCoordinate(destination.getRank(), destination.getFile()));
		}
		return result;
	}
}
