package xiangqi.studentjhu4;

import xiangqi.common.XiangqiGameVersion;
import xiangqi.studentjhu4.beta.BetaXiangqiBoard;
import xiangqi.studentjhu4.gamma.GammaXiangqiBoard;

public class XiangqiBoardFactory{
	
	/**
	 * Factory methods that returns an instance of a XiangqiBoard
	 * @param version version the version requested
	 * @return the instance of the requested game board
	 */
	public static XiangqiBoard makeXiangqiBoard(XiangqiGameVersion version){
		return version==XiangqiGameVersion.BETA_XQ?new BetaXiangqiBoard():new GammaXiangqiBoard();
	}

}
