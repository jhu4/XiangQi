package xiangqi.studentjhu4;

import xiangqi.common.XiangqiCoordinate;

public class XiangqiCoordinateImpl implements XiangqiCoordinate{

	@Override
	public int getRank() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getFile() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public boolean isOrthogonal(XiangqiCoordinateImpl c){
		return true;
	}
	
	public boolean isDiagonal(XiangqiCoordinateImpl c){
		return true;
	}
	
}
