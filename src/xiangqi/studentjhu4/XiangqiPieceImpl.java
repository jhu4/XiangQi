package xiangqi.studentjhu4;

import xiangqi.common.XiangqiColor;
import xiangqi.common.XiangqiPiece;
import xiangqi.common.XiangqiPieceType;

public class XiangqiPieceImpl implements XiangqiPiece {
	private final XiangqiColor color;
	private final XiangqiPieceType type;
	
	private XiangqiPieceImpl(XiangqiPieceType type, XiangqiColor color) {
		this.type=type;
		this.color=color;
	}
	public static XiangqiPiece makePiece(XiangqiPieceType type,XiangqiColor color){
		return new XiangqiPieceImpl(type,color);
	}
	
	@Override
	public XiangqiColor getColor() {
		return color;
	}

	@Override
	public XiangqiPieceType getPieceType() {
		return type;
	}

}
