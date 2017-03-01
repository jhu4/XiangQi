package xiangqi.studentjhu4.delta;

import java.util.HashMap;

import xiangqi.common.XiangqiGameVersion;
import xiangqi.common.XiangqiPieceType;
import xiangqi.studentjhu4.XiangqiBoardFactory;
import xiangqi.studentjhu4.XiangqiGameImpl;
import xiangqi.studentjhu4.xiangqiPieceRule.XiangqiPieceRule;
import xiangqi.studentjhu4.xiangqiPieceRule.XiangqiPieceRuleFactory;

public class DeltaXiangqiGame extends XiangqiGameImpl{
	public DeltaXiangqiGame(){
		moveBound=Integer.MAX_VALUE;//LOL will change it later
		board=XiangqiBoardFactory.makeXiangqiBoard(XiangqiGameVersion.DELTA_XQ);
		rulemap=new  HashMap<String,XiangqiPieceRule>();
		rulemap.put("",XiangqiPieceRuleFactory.makeXiangqiPieceRule(XiangqiPieceType.NONE,XiangqiGameVersion.DELTA_XQ));
		rulemap.put("Chariot",XiangqiPieceRuleFactory.makeXiangqiPieceRule(XiangqiPieceType.CHARIOT,XiangqiGameVersion.DELTA_XQ));
		rulemap.put("Elephant",XiangqiPieceRuleFactory.makeXiangqiPieceRule(XiangqiPieceType.ELEPHANT,XiangqiGameVersion.DELTA_XQ));
		rulemap.put("Advisor",XiangqiPieceRuleFactory.makeXiangqiPieceRule(XiangqiPieceType.ADVISOR,XiangqiGameVersion.DELTA_XQ));
		rulemap.put("General",XiangqiPieceRuleFactory.makeXiangqiPieceRule(XiangqiPieceType.GENERAL,XiangqiGameVersion.DELTA_XQ));
		rulemap.put("Soldier",XiangqiPieceRuleFactory.makeXiangqiPieceRule(XiangqiPieceType.SOLDIER,XiangqiGameVersion.DELTA_XQ));
		rulemap.put("Cannon",XiangqiPieceRuleFactory.makeXiangqiPieceRule(XiangqiPieceType.CANNON,XiangqiGameVersion.DELTA_XQ));
		rulemap.put("Horse",XiangqiPieceRuleFactory.makeXiangqiPieceRule(XiangqiPieceType.HORSE,XiangqiGameVersion.DELTA_XQ));
	}
}
