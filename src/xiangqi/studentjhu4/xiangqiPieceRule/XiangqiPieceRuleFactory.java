package xiangqi.studentjhu4.xiangqiPieceRule;

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
			case "Elephant":
				return new ElephantRule(type,version);
			case "Cannon":
				return new CannonRule(type,version);
			case "Horse":
				return new HorseRule(type,version);
			default:
				return new NoneRule(type,version);
		}
	}
}
