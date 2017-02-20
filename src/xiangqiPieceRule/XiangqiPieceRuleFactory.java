package xiangqiPieceRule;

import xiangqi.common.XiangqiGameVersion;
import xiangqi.common.XiangqiPieceType;

public class XiangqiPieceRuleFactory{
	
	public static XiangqiPieceRule makeXiangqiPieceRule(XiangqiPieceType type,XiangqiGameVersion version){
		switch(type.getPrintableName()){
			case "Chariot":
				return new ChariotRule(type,version);
			case "Soldier":
				return new SoldierRule(type,version);
			case "Advisor":
				return new AdvisorRule(type,version);
			case "General":
				return new GeneralRule(type,version);
			default:
				return new NoneRule(type,version);
		}
	}
}
