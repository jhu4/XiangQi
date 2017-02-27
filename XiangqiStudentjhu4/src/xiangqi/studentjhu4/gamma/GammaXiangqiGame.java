package xiangqi.studentjhu4.gamma;

import static xiangqi.studentjhu4.XiangqiCoordinateImpl.makeCoordinate;

import java.util.Collection;
import java.util.HashMap;
import java.util.Stack;

import xiangqi.common.MoveResult;
import xiangqi.common.XiangqiColor;
import xiangqi.common.XiangqiCoordinate;
import xiangqi.common.XiangqiGame;
import xiangqi.common.XiangqiGameVersion;
import xiangqi.common.XiangqiPiece;
import xiangqi.common.XiangqiPieceType;
import xiangqi.studentjhu4.XiangqiBoard;
import xiangqi.studentjhu4.XiangqiBoardFactory;
import xiangqi.studentjhu4.XiangqiGameImpl;
import xiangqi.studentjhu4.XiangqiMove;
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
