package xiangqi.studentjhu4;

import xiangqi.common.XiangqiColor;
import xiangqi.common.XiangqiCoordinate;
import xiangqi.common.XiangqiPiece;
import xiangqi.common.XiangqiPieceType;

public class BetaXiangqiBoard implements XiangqiBoard {
	private XiangqiPiece[][] board;
	final int ranks=6;
	final int files=6;
	
	public BetaXiangqiBoard(){
		board=new XiangqiPiece[ranks][files];
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
		//Initialized black pieces
		board[5][5]=XiangqiPieceImpl.makePiece(XiangqiPieceType.CHARIOT, XiangqiColor.BLACK);
		board[5][2]=XiangqiPieceImpl.makePiece(XiangqiPieceType.ADVISOR, XiangqiColor.BLACK);
		board[5][3]=XiangqiPieceImpl.makePiece(XiangqiPieceType.GENERAL, XiangqiColor.BLACK);
		board[5][4]=XiangqiPieceImpl.makePiece(XiangqiPieceType.ADVISOR, XiangqiColor.BLACK);
		board[5][1]=XiangqiPieceImpl.makePiece(XiangqiPieceType.CHARIOT, XiangqiColor.BLACK);
		board[4][3]=XiangqiPieceImpl.makePiece(XiangqiPieceType.SOLDIER, XiangqiColor.BLACK);
	}
	
	@Override
	public XiangqiPiece getPieceAt(XiangqiCoordinate where, XiangqiColor aspect) {
		if(aspect==XiangqiColor.RED){
			return board[where.getRank()][where.getFile()];
		}
		else if(aspect==XiangqiColor.BLACK){
			return board[ranks-where.getRank()][files-where.getFile()];
		}
		else{
			return XiangqiPieceImpl.makePiece(XiangqiPieceType.NONE, XiangqiColor.NONE);
		}
	}

}
