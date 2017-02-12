package xiangqi.studentjhu4.beta;

import java.util.HashMap;

import xiangqi.common.XiangqiColor;
import xiangqi.common.XiangqiCoordinate;
import xiangqi.common.XiangqiPiece;
import xiangqi.common.XiangqiPieceType;
import xiangqi.studentjhu4.XiangqiBoard;
import xiangqi.studentjhu4.XiangqiPieceImpl;

import static xiangqi.studentjhu4.XiangqiCoordinateImpl.makeCoordinate;

public class BetaXiangqiBoard extends XiangqiBoard{
	
	public BetaXiangqiBoard(){
		ranks=6;
		files=6;
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
		board[1][2]=XiangqiPieceImpl.makePiece(XiangqiPieceType.ADVISOR, XiangqiColor.RED);
		board[1][3]=XiangqiPieceImpl.makePiece(XiangqiPieceType.GENERAL, XiangqiColor.RED);
		board[1][4]=XiangqiPieceImpl.makePiece(XiangqiPieceType.ADVISOR, XiangqiColor.RED);
		board[1][5]=XiangqiPieceImpl.makePiece(XiangqiPieceType.CHARIOT, XiangqiColor.RED);
		board[2][3]=XiangqiPieceImpl.makePiece(XiangqiPieceType.SOLDIER, XiangqiColor.RED);
		redpieces.put(new Integer(101),board[1][1]);
		redpieces.put(new Integer(102),board[1][2]);
		redpieces.put(new Integer(103),board[1][4]);
		redpieces.put(new Integer(104),board[1][5]);
		redpieces.put(new Integer(203),board[2][3]);
		redGeneralLocation=makeCoordinate(1,3);
		//Initialized black pieces
		board[5][5]=XiangqiPieceImpl.makePiece(XiangqiPieceType.CHARIOT, XiangqiColor.BLACK);
		board[5][4]=XiangqiPieceImpl.makePiece(XiangqiPieceType.ADVISOR, XiangqiColor.BLACK);
		board[5][3]=XiangqiPieceImpl.makePiece(XiangqiPieceType.GENERAL, XiangqiColor.BLACK);
		board[5][2]=XiangqiPieceImpl.makePiece(XiangqiPieceType.ADVISOR, XiangqiColor.BLACK);
		board[5][1]=XiangqiPieceImpl.makePiece(XiangqiPieceType.CHARIOT, XiangqiColor.BLACK);
		board[4][3]=XiangqiPieceImpl.makePiece(XiangqiPieceType.SOLDIER, XiangqiColor.BLACK);
		blackpieces.put(new Integer(101), board[5][5]);
		blackpieces.put(new Integer(102), board[5][4]);
		blackpieces.put(new Integer(104), board[5][2]);
		blackpieces.put(new Integer(105), board[5][1]);
		blackpieces.put(new Integer(203), board[4][3]);
		blackGeneralLocation=makeCoordinate(1,3);
	}
}
