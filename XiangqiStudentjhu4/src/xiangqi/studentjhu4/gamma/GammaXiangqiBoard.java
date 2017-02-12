package xiangqi.studentjhu4.gamma;

import java.util.HashMap;

import xiangqi.common.XiangqiColor;
import xiangqi.common.XiangqiPiece;
import xiangqi.common.XiangqiPieceType;
import xiangqi.studentjhu4.XiangqiBoard;
import xiangqi.studentjhu4.XiangqiPieceImpl;

public class GammaXiangqiBoard extends XiangqiBoard{
	public GammaXiangqiBoard(){
		ranks=11;
		files=10;
		board=new XiangqiPiece[ranks][files];
		redpieces=new HashMap<Integer,XiangqiPiece>();
		blackpieces=new HashMap<Integer,XiangqiPiece>();
		//initialize the whole board
		for(int i=0;i<ranks;i++){
			for(int j=0;j<files;j++){
				board[i][j]=XiangqiPieceImpl.makePiece(XiangqiPieceType.NONE,XiangqiColor.NONE);
			}
		}
		//Initialized red pieces
		board[1][1]=XiangqiPieceImpl.makePiece(XiangqiPieceType.CHARIOT, XiangqiColor.RED);
		board[1][3]=XiangqiPieceImpl.makePiece(XiangqiPieceType.ELEPHANT, XiangqiColor.RED);
		board[1][4]=XiangqiPieceImpl.makePiece(XiangqiPieceType.ADVISOR, XiangqiColor.RED);
		board[1][5]=XiangqiPieceImpl.makePiece(XiangqiPieceType.GENERAL, XiangqiColor.RED);
		board[1][6]=XiangqiPieceImpl.makePiece(XiangqiPieceType.ADVISOR, XiangqiColor.RED);
		board[1][7]=XiangqiPieceImpl.makePiece(XiangqiPieceType.ELEPHANT, XiangqiColor.RED);
		board[1][9]=XiangqiPieceImpl.makePiece(XiangqiPieceType.CHARIOT, XiangqiColor.RED);
		board[4][1]=XiangqiPieceImpl.makePiece(XiangqiPieceType.SOLDIER, XiangqiColor.RED);
		board[4][3]=XiangqiPieceImpl.makePiece(XiangqiPieceType.SOLDIER, XiangqiColor.RED);
		board[4][5]=XiangqiPieceImpl.makePiece(XiangqiPieceType.SOLDIER, XiangqiColor.RED);
		board[4][7]=XiangqiPieceImpl.makePiece(XiangqiPieceType.SOLDIER, XiangqiColor.RED);
		board[4][9]=XiangqiPieceImpl.makePiece(XiangqiPieceType.SOLDIER, XiangqiColor.RED);
		//black pieces
		board[10][9]=XiangqiPieceImpl.makePiece(XiangqiPieceType.CHARIOT, XiangqiColor.BLACK);
		board[10][7]=XiangqiPieceImpl.makePiece(XiangqiPieceType.ELEPHANT, XiangqiColor.BLACK);
		board[10][6]=XiangqiPieceImpl.makePiece(XiangqiPieceType.ADVISOR, XiangqiColor.BLACK);
		board[10][5]=XiangqiPieceImpl.makePiece(XiangqiPieceType.GENERAL, XiangqiColor.BLACK);
		board[10][4]=XiangqiPieceImpl.makePiece(XiangqiPieceType.ADVISOR, XiangqiColor.BLACK);
		board[10][3]=XiangqiPieceImpl.makePiece(XiangqiPieceType.ELEPHANT, XiangqiColor.BLACK);
		board[10][1]=XiangqiPieceImpl.makePiece(XiangqiPieceType.CHARIOT, XiangqiColor.BLACK);
		board[7][9]=XiangqiPieceImpl.makePiece(XiangqiPieceType.SOLDIER, XiangqiColor.BLACK);
		board[7][7]=XiangqiPieceImpl.makePiece(XiangqiPieceType.SOLDIER, XiangqiColor.BLACK);
		board[7][5]=XiangqiPieceImpl.makePiece(XiangqiPieceType.SOLDIER, XiangqiColor.BLACK);
		board[7][3]=XiangqiPieceImpl.makePiece(XiangqiPieceType.SOLDIER, XiangqiColor.BLACK);
		board[7][1]=XiangqiPieceImpl.makePiece(XiangqiPieceType.SOLDIER, XiangqiColor.BLACK);
	}
}
