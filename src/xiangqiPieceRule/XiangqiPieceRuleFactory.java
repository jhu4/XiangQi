package xiangqiPieceRule;

import xiangqi.common.XiangqiPieceType;

public class XiangqiPieceRuleFactory{
	
	public static XiangqiPieceRule makeXiangqiPieceRule(XiangqiPieceType type){
		switch(type.getPrintableName()){
			case "Chariot":
				return new ChariotRule(type);
			case "Soldier":
				return new SoldierRule(type);
			case "Advisor":
				return new AdvisorRule(type);
			case "General":
				return new GeneralRule(type);
			default:
				return new NoneRule(type);
		}
	}
}
