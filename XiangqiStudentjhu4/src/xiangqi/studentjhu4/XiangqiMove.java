package xiangqi.studentjhu4;

import java.util.HashMap;

import xiangqi.common.XiangqiColor;
import xiangqi.common.XiangqiCoordinate;
import xiangqi.common.XiangqiPiece;

public class XiangqiMove {
	public XiangqiPiece srcPiece;
	public XiangqiPiece destPiece;
	public XiangqiCoordinate src;
	public XiangqiCoordinate dest;
	public XiangqiColor color;
	public HashMap<Integer,XiangqiPiece> redpieces;
	public HashMap<Integer,XiangqiPiece> blackpieces;
	public XiangqiCoordinateImpl redGeneralLocation;
	public XiangqiCoordinateImpl blackGeneralLocation;
	
	public XiangqiMove(XiangqiBoard board, XiangqiCoordinate src, XiangqiCoordinate dest){
		this.src=src;
		this.dest=dest;
		this.color=board.getBoardColor();
		this.srcPiece=board.getPieceAt(src, color);
		this.destPiece=board.getPieceAt(dest, color);
		this.redpieces=new HashMap<Integer,XiangqiPiece>(board.getPieces(XiangqiColor.RED));
		this.blackpieces=new HashMap<Integer,XiangqiPiece>(board.getPieces(XiangqiColor.BLACK));
		this.redGeneralLocation=(XiangqiCoordinateImpl) board.getGeneralLocation(XiangqiColor.RED);
		this.blackGeneralLocation=(XiangqiCoordinateImpl) board.getGeneralLocation(XiangqiColor.BLACK);
	}
}
