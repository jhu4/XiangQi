package xiangqi.studentjhu4;

import xiangqi.common.XiangqiCoordinate;

public class XiangqiCoordinateImpl implements XiangqiCoordinate{
	private int rank;
	private int file;
	
	private XiangqiCoordinateImpl(int rank,int file){
		this.rank=rank;
		this.file=file;
	}
	
	/**
	 * Constructor for XiangqiCoordinateImpl
	 * @param rank rank of the coordinate
	 * @param file file of the coordinate
	 * @return
	 */
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
		return isSameFile(c)^isSameRank(c);
	}
	
	public boolean isDiagonal(XiangqiCoordinateImpl c) {
		return Math.abs(rank-c.getRank())==Math.abs(file-c.getFile());
	}
	
	public boolean isSameFile(XiangqiCoordinateImpl c) {
		return file==c.getFile();
	}
	
	public boolean isSameRank(XiangqiCoordinateImpl c) {
		return rank==c.getRank();
	}
	
	public boolean isNotBackward(XiangqiCoordinateImpl c) {
		return c.getRank()-rank>=0;
	}

	public int distanceTo(XiangqiCoordinateImpl c){
		return Math.abs(rank-c.getRank())+Math.abs(file-c.getFile());
	}

}
