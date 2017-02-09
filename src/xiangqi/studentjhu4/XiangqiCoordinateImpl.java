package xiangqi.studentjhu4;

import xiangqi.common.XiangqiCoordinate;

public class XiangqiCoordinateImpl implements XiangqiCoordinate{
	private int rank;
	private int file;
	
	private XiangqiCoordinateImpl(int rank,int file){
		this.rank=rank;
		this.file=file;
	}
	
	public static XiangqiCoordinateImpl makeCoordinate(int rank, int file){
		return new XiangqiCoordinateImpl(rank,file);
	}
	
	@Override
	public int getRank() {
		return rank;
	}

	@Override
	public int getFile() {
		return file;
	}
	
	public boolean isOrthogonal(XiangqiCoordinateImpl c){
		return (rank==c.getRank()) || (file==c.getFile());
	}

	public boolean notEquals(XiangqiCoordinateImpl c) {
		return !(rank==c.getRank() && file==c.getFile());
	}
}
