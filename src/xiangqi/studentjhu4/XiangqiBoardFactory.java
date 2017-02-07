package xiangqi.studentjhu4;

import xiangqi.common.XiangqiGameVersion;

public class XiangqiBoardFactory{
	
	/**
	 * Factory methods that returns an instance of a XiangqiBoard
	 * @param version version the version requested
	 * @return the instance of the requested game board
	 */
	public static XiangqiBoard makeXiangqiBoard(XiangqiGameVersion version){
		return new BetaXiangqiBoard();
	}

}
