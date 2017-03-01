package xiangqi.studentjhu4;

import xiangqi.common.XiangqiGameVersion;
import xiangqi.studentjhu4.beta.BetaXiangqiBoard;
import xiangqi.studentjhu4.delta.DeltaXiangqiBoard;
import xiangqi.studentjhu4.gamma.GammaXiangqiBoard;

public class XiangqiBoardFactory{
	
	/**
	 * Factory methods that returns an instance of a XiangqiBoard
	 * @param version version the version requested
	 * @return the instance of the requested game board
	 */
	public static XiangqiBoard makeXiangqiBoard(XiangqiGameVersion version){
		switch(version){
			case BETA_XQ:
				return new BetaXiangqiBoard();
			case GAMMA_XQ:
				return new GammaXiangqiBoard();
			case DELTA_XQ:
				return new DeltaXiangqiBoard();
			default:
				return null;
		}
	}

}
