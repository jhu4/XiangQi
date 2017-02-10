package xiangqi.studentjhu4;

import java.util.HashMap;

import xiangqi.common.XiangqiColor;
import xiangqi.common.XiangqiCoordinate;
import xiangqi.common.XiangqiPiece;
import xiangqi.common.XiangqiPieceType;
import static xiangqi.studentjhu4.XiangqiCoordinateImpl.makeCoordinate;

public class BetaXiangqiBoard extends XiangqiBoard{
	
	public BetaXiangqiBoard(){
		ranks=6;
		files=6;
		board=new XiangqiPiece[ranks][files];
		redpieces=new HashMap<XiangqiCoordinateImpl,XiangqiPiece>();
		blackpieces=new HashMap<XiangqiCoordinateImpl,XiangqiPiece>();
		//initialize the whole board
		for(int i=0;i<ranks;i++){
			for(int j=0;j<files;j++){
				board[i][j]=XiangqiPieceImpl.makePiece(XiangqiPieceType.NONE,XiangqiColor.NONE);
			}
		}
		//Initialized red pieces
		board[1][1]=XiangqiPieceImpl.makePiece(XiangqiPieceType.CHARIOT, XiangqiColor.RED);
		board[1][2]=XiangqiPieceImpl.makePiece(XiangqiPieceType.ADVISOR, XiangqiColor.RED);
		board[1][3]=XiangqiPieceImpl.makePiece(XiangqiPieceType.GENERAL, XiangqiColor.RED);
		board[1][4]=XiangqiPieceImpl.makePiece(XiangqiPieceType.ADVISOR, XiangqiColor.RED);
		board[1][5]=XiangqiPieceImpl.makePiece(XiangqiPieceType.CHARIOT, XiangqiColor.RED);
		board[2][3]=XiangqiPieceImpl.makePiece(XiangqiPieceType.SOLDIER, XiangqiColor.RED);
		redpieces.put(makeCoordinate(1,1),board[1][1]);
		redpieces.put(makeCoordinate(1,2),board[1][2]);
		redpieces.put(makeCoordinate(1,3),board[1][3]);
		redpieces.put(makeCoordinate(1,4),board[1][4]);
		redpieces.put(makeCoordinate(1,5),board[1][5]);
		redpieces.put(makeCoordinate(2,3),board[2][3]);
		//Initialized black pieces
		board[5][5]=XiangqiPieceImpl.makePiece(XiangqiPieceType.CHARIOT, XiangqiColor.BLACK);
		board[5][4]=XiangqiPieceImpl.makePiece(XiangqiPieceType.ADVISOR, XiangqiColor.BLACK);
		board[5][3]=XiangqiPieceImpl.makePiece(XiangqiPieceType.GENERAL, XiangqiColor.BLACK);
		board[5][2]=XiangqiPieceImpl.makePiece(XiangqiPieceType.ADVISOR, XiangqiColor.BLACK);
		board[5][1]=XiangqiPieceImpl.makePiece(XiangqiPieceType.CHARIOT, XiangqiColor.BLACK);
		board[4][3]=XiangqiPieceImpl.makePiece(XiangqiPieceType.SOLDIER, XiangqiColor.BLACK);
		blackpieces.put(makeCoordinate(1,1), board[5][5]);
		blackpieces.put(makeCoordinate(1,2), board[5][4]);
		blackpieces.put(makeCoordinate(1,3), board[5][3]);
		blackpieces.put(makeCoordinate(1,4), board[5][2]);
		blackpieces.put(makeCoordinate(1,5), board[5][1]);
		blackpieces.put(makeCoordinate(2,3), board[4][3]);
	}
}
