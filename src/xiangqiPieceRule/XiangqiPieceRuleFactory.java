package xiangqiPieceRule;

import xiangqi.common.XiangqiPieceType;

public class XiangqiPieceRuleFactory{
	
	public static XiangqiPieceRule makeXiangqiPieceRule(XiangqiPieceType type){
		switch(type.getPrintableName()){
			case "Chariot":
				return new ChariotRule(type);
			default:
				return new NoneRule(type);
		}
	}
}
