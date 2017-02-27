package xiangqi.studentjhu4.gamma;

import java.util.HashMap;
import xiangqi.common.XiangqiGameVersion;
import xiangqi.common.XiangqiPieceType;
import xiangqi.studentjhu4.XiangqiBoardFactory;
import xiangqi.studentjhu4.XiangqiGameImpl;
import xiangqi.studentjhu4.xiangqiPieceRule.XiangqiPieceRule;
import xiangqi.studentjhu4.xiangqiPieceRule.XiangqiPieceRuleFactory;

public class GammaXiangqiGame extends XiangqiGameImpl{
	public GammaXiangqiGame(){
		moveBound=50;
		board=XiangqiBoardFactory.makeXiangqiBoard(XiangqiGameVersion.GAMMA_XQ);
		rulemap=new  HashMap<String,XiangqiPieceRule>();
		rulemap.put("",XiangqiPieceRuleFactory.makeXiangqiPieceRule(XiangqiPieceType.NONE,XiangqiGameVersion.GAMMA_XQ));
		rulemap.put("Chariot",XiangqiPieceRuleFactory.makeXiangqiPieceRule(XiangqiPieceType.CHARIOT,XiangqiGameVersion.GAMMA_XQ));
		rulemap.put("Elephant",XiangqiPieceRuleFactory.makeXiangqiPieceRule(XiangqiPieceType.ELEPHANT,XiangqiGameVersion.GAMMA_XQ));
		rulemap.put("Advisor",XiangqiPieceRuleFactory.makeXiangqiPieceRule(XiangqiPieceType.ADVISOR,XiangqiGameVersion.GAMMA_XQ));
		rulemap.put("General",XiangqiPieceRuleFactory.makeXiangqiPieceRule(XiangqiPieceType.GENERAL,XiangqiGameVersion.GAMMA_XQ));
		rulemap.put("Soldier",XiangqiPieceRuleFactory.makeXiangqiPieceRule(XiangqiPieceType.SOLDIER,XiangqiGameVersion.GAMMA_XQ));
	}
}
