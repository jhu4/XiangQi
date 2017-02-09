package xiangqi.studentjhu4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import xiangqi.XiangqiGameFactory;
import xiangqi.common.MoveResult;
import xiangqi.common.XiangqiColor;
import xiangqi.common.XiangqiCoordinate;
import xiangqi.common.XiangqiGame;
import xiangqi.common.XiangqiGameVersion;
import xiangqi.common.XiangqiPiece;
import xiangqi.common.XiangqiPieceType;
import xiangqi.studentjhu4.AlphaXiangqiTest.TestCoordinate;

/**
 * Test cases for Beta Xiangqi Game
 * @author Dorothy
 *
 */
public class BetaXiangqiTest {
	private XiangqiGame game;
	
	static class TestCoordinate implements XiangqiCoordinate{
		private final int rank;
		private final int file;
		
		private TestCoordinate(int rank, int file){
			this.rank=rank;
			this.file=file;
		}
		
		public static XiangqiCoordinate makeCoordinate(int rank,int file){
			return new TestCoordinate(rank,file);
		}
		 
		@Override
		public int getRank() {
			return rank;
		}

		@Override
		public int getFile() {
			return file;
		}
	}
	
	// wrapper method
	private static XiangqiCoordinate makeCoordinate(int rank, int file){
		return TestCoordinate.makeCoordinate(rank, file);
	}
	
	@Before
	public void setup(){
		game=XiangqiGameFactory.makeXiangqiGame(XiangqiGameVersion.BETA_XQ);
	}
	
	@Test //1
	public void factoryProduceBetaXiangQiGame(){
		assertNotNull(game);
	}
	
	@Test //2
	public void redPiecesInitializedCorrectlyInRedAspect(){
		final XiangqiPiece p11=game.getPieceAt(makeCoordinate(1,1), XiangqiColor.RED);
		final XiangqiPiece p12=game.getPieceAt(makeCoordinate(1,2), XiangqiColor.RED);
		final XiangqiPiece p13=game.getPieceAt(makeCoordinate(1,3), XiangqiColor.RED);
		final XiangqiPiece p14=game.getPieceAt(makeCoordinate(1,4), XiangqiColor.RED);
		final XiangqiPiece p15=game.getPieceAt(makeCoordinate(1,5), XiangqiColor.RED);
		final XiangqiPiece p23=game.getPieceAt(makeCoordinate(2,3), XiangqiColor.RED);
		assertEquals(XiangqiColor.RED,p11.getColor());
		assertEquals(XiangqiColor.RED,p12.getColor());
		assertEquals(XiangqiColor.RED,p13.getColor());
		assertEquals(XiangqiColor.RED,p14.getColor());
		assertEquals(XiangqiColor.RED,p15.getColor());
		assertEquals(XiangqiColor.RED,p23.getColor());
		assertEquals(XiangqiPieceType.CHARIOT,p11.getPieceType());
		assertEquals(XiangqiPieceType.ADVISOR,p12.getPieceType());
		assertEquals(XiangqiPieceType.GENERAL,p13.getPieceType());
		assertEquals(XiangqiPieceType.ADVISOR,p14.getPieceType());
		assertEquals(XiangqiPieceType.CHARIOT,p15.getPieceType());
		assertEquals(XiangqiPieceType.SOLDIER,p23.getPieceType());
	}
	
	@Test //4
	public void blackPiecesInitializedCorrectlyInRedAspect(){
		final XiangqiPiece p55=game.getPieceAt(makeCoordinate(5,5), XiangqiColor.RED);
		final XiangqiPiece p54=game.getPieceAt(makeCoordinate(5,2), XiangqiColor.RED);
		final XiangqiPiece p53=game.getPieceAt(makeCoordinate(5,3), XiangqiColor.RED);
		final XiangqiPiece p52=game.getPieceAt(makeCoordinate(5,4), XiangqiColor.RED);
		final XiangqiPiece p51=game.getPieceAt(makeCoordinate(5,5), XiangqiColor.RED);
		final XiangqiPiece p43=game.getPieceAt(makeCoordinate(4,3), XiangqiColor.RED);
		assertEquals(XiangqiColor.BLACK,p55.getColor());
		assertEquals(XiangqiColor.BLACK,p54.getColor());
		assertEquals(XiangqiColor.BLACK,p53.getColor());
		assertEquals(XiangqiColor.BLACK,p52.getColor());
		assertEquals(XiangqiColor.BLACK,p51.getColor());
		assertEquals(XiangqiColor.BLACK,p43.getColor());
		assertEquals(XiangqiPieceType.CHARIOT,p55.getPieceType());
		assertEquals(XiangqiPieceType.ADVISOR,p54.getPieceType());
		assertEquals(XiangqiPieceType.GENERAL,p53.getPieceType());
		assertEquals(XiangqiPieceType.ADVISOR,p52.getPieceType());
		assertEquals(XiangqiPieceType.CHARIOT,p51.getPieceType());
		assertEquals(XiangqiPieceType.SOLDIER,p43.getPieceType());
	}
	
	@Test //4
	public void redPiecesInitializedCorrectlyInBlackAspect(){
		final XiangqiPiece p55=game.getPieceAt(makeCoordinate(5,5), XiangqiColor.BLACK);
		final XiangqiPiece p54=game.getPieceAt(makeCoordinate(5,2), XiangqiColor.BLACK);
		final XiangqiPiece p53=game.getPieceAt(makeCoordinate(5,3), XiangqiColor.BLACK);
		final XiangqiPiece p52=game.getPieceAt(makeCoordinate(5,4), XiangqiColor.BLACK);
		final XiangqiPiece p51=game.getPieceAt(makeCoordinate(5,5), XiangqiColor.BLACK);
		final XiangqiPiece p43=game.getPieceAt(makeCoordinate(4,3), XiangqiColor.BLACK);
		assertEquals(XiangqiColor.RED,p55.getColor());
		assertEquals(XiangqiColor.RED,p54.getColor());
		assertEquals(XiangqiColor.RED,p53.getColor());
		assertEquals(XiangqiColor.RED,p52.getColor());
		assertEquals(XiangqiColor.RED,p51.getColor());
		assertEquals(XiangqiColor.RED,p43.getColor());
		assertEquals(XiangqiPieceType.CHARIOT,p55.getPieceType());
		assertEquals(XiangqiPieceType.ADVISOR,p54.getPieceType());
		assertEquals(XiangqiPieceType.GENERAL,p53.getPieceType());
		assertEquals(XiangqiPieceType.ADVISOR,p52.getPieceType());
		assertEquals(XiangqiPieceType.CHARIOT,p51.getPieceType());
		assertEquals(XiangqiPieceType.SOLDIER,p43.getPieceType());
	}
	
	@Test //5
	public void blackPiecesInitializedCorrectlyInBlackAspect(){
		final XiangqiPiece p11=game.getPieceAt(makeCoordinate(1,1), XiangqiColor.BLACK);
		final XiangqiPiece p12=game.getPieceAt(makeCoordinate(1,2), XiangqiColor.BLACK);
		final XiangqiPiece p13=game.getPieceAt(makeCoordinate(1,3), XiangqiColor.BLACK);
		final XiangqiPiece p14=game.getPieceAt(makeCoordinate(1,4), XiangqiColor.BLACK);
		final XiangqiPiece p15=game.getPieceAt(makeCoordinate(1,5), XiangqiColor.BLACK);
		final XiangqiPiece p23=game.getPieceAt(makeCoordinate(2,3), XiangqiColor.BLACK);
		assertEquals(XiangqiColor.BLACK,p11.getColor());
		assertEquals(XiangqiColor.BLACK,p12.getColor());
		assertEquals(XiangqiColor.BLACK,p13.getColor());
		assertEquals(XiangqiColor.BLACK,p14.getColor());
		assertEquals(XiangqiColor.BLACK,p15.getColor());
		assertEquals(XiangqiColor.BLACK,p23.getColor());
		assertEquals(XiangqiPieceType.CHARIOT,p11.getPieceType());
		assertEquals(XiangqiPieceType.ADVISOR,p12.getPieceType());
		assertEquals(XiangqiPieceType.GENERAL,p13.getPieceType());
		assertEquals(XiangqiPieceType.ADVISOR,p14.getPieceType());
		assertEquals(XiangqiPieceType.CHARIOT,p15.getPieceType());
		assertEquals(XiangqiPieceType.SOLDIER,p23.getPieceType());
	}
	
	@Test //6
	public void nonepiecesInitializedCorrectlyInBothAspect(){
		//any coordinate in the file of 2-4 except (2,3) and (4,3) 
		for(int rank=2;rank<=4;rank++){
			for(int file=1;file<=5;file++){
				if((rank!=2 && file!=3)||(rank!=4 && file!=3)){
					XiangqiPiece pxy_red=game.getPieceAt(makeCoordinate(rank,file), XiangqiColor.RED);
					XiangqiPiece pxy_black=game.getPieceAt(makeCoordinate(rank,file), XiangqiColor.BLACK);
					assertEquals(XiangqiColor.NONE,pxy_red.getColor());
					assertEquals(XiangqiPieceType.NONE,pxy_red.getPieceType());
					assertEquals(XiangqiColor.NONE,pxy_black.getColor());
					assertEquals(XiangqiPieceType.NONE,pxy_black.getPieceType());
				}
			}
		}
	}
	
	@Test //7
	public void invalidCoordinateMove(){
		assertEquals(MoveResult.ILLEGAL,game.makeMove(makeCoordinate(0,-1),makeCoordinate(-10,99)));
		assertEquals(MoveResult.ILLEGAL,game.makeMove(makeCoordinate(3,3),makeCoordinate(3,4)));
	}
	
	@Test //8
	public void redChariotCanMoveFrom11To21Correctly(){
		assertEquals(MoveResult.OK,game.makeMove(makeCoordinate(1,1),makeCoordinate(2,1)));
		XiangqiPiece p11=game.getPieceAt(makeCoordinate(1,1),XiangqiColor.RED);
		XiangqiPiece p21=game.getPieceAt(makeCoordinate(2,1),XiangqiColor.RED);
		assertEquals(XiangqiPieceType.NONE,p11.getPieceType());
		assertEquals(XiangqiColor.NONE,p11.getColor());
		assertEquals(XiangqiPieceType.CHARIOT,p21.getPieceType());
		assertEquals(XiangqiColor.RED,p21.getColor());
		
	}
	
	@Test //9
	public void redChariotCanMoveFrom15To45(){
		assertEquals(MoveResult.OK,game.makeMove(makeCoordinate(1,5),makeCoordinate(4,5)));
		XiangqiPiece p15=game.getPieceAt(makeCoordinate(1,5),XiangqiColor.RED);
		XiangqiPiece p45=game.getPieceAt(makeCoordinate(4,5),XiangqiColor.RED);
		assertEquals(XiangqiPieceType.NONE,p15.getPieceType());
		assertEquals(XiangqiColor.NONE,p15.getColor());
		assertEquals(XiangqiPieceType.CHARIOT,p45.getPieceType());
		assertEquals(XiangqiColor.RED,p45.getColor());
		
	}
	
	@Test //10
	public void redChariotCanMoveFrom15To55(){
		assertEquals(MoveResult.OK,game.makeMove(makeCoordinate(1,5),makeCoordinate(5,5)));
		XiangqiPiece p15=game.getPieceAt(makeCoordinate(1,5),XiangqiColor.RED);
		XiangqiPiece p55=game.getPieceAt(makeCoordinate(5,5),XiangqiColor.RED);
		assertEquals(XiangqiPieceType.NONE,p15.getPieceType());
		assertEquals(XiangqiColor.NONE,p15.getColor());
		assertEquals(XiangqiPieceType.CHARIOT,p55.getPieceType());
		assertEquals(XiangqiColor.RED,p55.getColor());
	}
	
	@Test //11
	public void redChariotCanNotMoveFrom11To22(){
		assertEquals(MoveResult.ILLEGAL,game.makeMove(makeCoordinate(1,1),makeCoordinate(2,2)));
		XiangqiPiece p11=game.getPieceAt(makeCoordinate(1,1),XiangqiColor.RED);
		XiangqiPiece p22=game.getPieceAt(makeCoordinate(2,2),XiangqiColor.RED);
		assertEquals(XiangqiPieceType.CHARIOT,p11.getPieceType());
		assertEquals(XiangqiColor.RED,p11.getColor());
		assertEquals(XiangqiPieceType.NONE,p22.getPieceType());
		assertEquals(XiangqiColor.NONE,p22.getColor());
	}
	
	@Test //12
	public void redChariotCanNotMoveFrom15To14(){
		assertEquals(MoveResult.ILLEGAL,game.makeMove(makeCoordinate(1,5),makeCoordinate(1,4)));
		XiangqiPiece p15=game.getPieceAt(makeCoordinate(1,5),XiangqiColor.RED);
		XiangqiPiece p14=game.getPieceAt(makeCoordinate(1,4),XiangqiColor.RED);
		assertEquals(XiangqiPieceType.CHARIOT,p15.getPieceType());
		assertEquals(XiangqiColor.RED,p15.getColor());
		assertEquals(XiangqiPieceType.ADVISOR,p14.getPieceType());
		assertEquals(XiangqiColor.RED,p14.getColor());
	}
	
	@Test //13
	public void redChariotCanNotMoveFrom11To11(){
		assertEquals(MoveResult.ILLEGAL,game.makeMove(makeCoordinate(1,1),makeCoordinate(1,1)));
		XiangqiPiece p11=game.getPieceAt(makeCoordinate(1,1),XiangqiColor.RED);
		assertEquals(XiangqiPieceType.CHARIOT,p11.getPieceType());
		assertEquals(XiangqiColor.RED,p11.getColor());
	}
	
	@Test //14
	public void redChariotCanNotMoveToOutOfBoardCoordinate(){
		assertEquals(MoveResult.ILLEGAL,game.makeMove(makeCoordinate(1,1),makeCoordinate(0,1)));
		XiangqiPiece p11=game.getPieceAt(makeCoordinate(1,1),XiangqiColor.RED);
		assertEquals(XiangqiPieceType.CHARIOT,p11.getPieceType());
		assertEquals(XiangqiColor.RED,p11.getColor());
	}
	
	@Test //15 
	public void gameRoundAltersCorrectly(){
		assertEquals(MoveResult.OK,game.makeMove(makeCoordinate(1,1),makeCoordinate(2,1)));
		XiangqiPiece p11_red=game.getPieceAt(makeCoordinate(1,1),XiangqiColor.RED);
		XiangqiPiece p21_red=game.getPieceAt(makeCoordinate(2,1),XiangqiColor.RED);
		assertEquals(XiangqiPieceType.NONE,p11_red.getPieceType());
		assertEquals(XiangqiColor.NONE,p11_red.getColor());
		assertEquals(XiangqiPieceType.CHARIOT,p21_red.getPieceType());
		assertEquals(XiangqiColor.RED,p21_red.getColor());
		assertEquals(MoveResult.OK,game.makeMove(makeCoordinate(1,1),makeCoordinate(2,1)));
		XiangqiPiece p55_red=game.getPieceAt(makeCoordinate(5,5),XiangqiColor.RED);
		XiangqiPiece p45_red=game.getPieceAt(makeCoordinate(4,5),XiangqiColor.RED);
		assertEquals(XiangqiPieceType.NONE,p55_red.getPieceType());
		assertEquals(XiangqiColor.NONE,p55_red.getColor());
		assertEquals(XiangqiPieceType.CHARIOT,p45_red.getPieceType());
		assertEquals(XiangqiColor.BLACK,p45_red.getColor());
		XiangqiPiece p11_black=game.getPieceAt(makeCoordinate(1,1),XiangqiColor.BLACK);
		XiangqiPiece p21_black=game.getPieceAt(makeCoordinate(2,1),XiangqiColor.BLACK);
		assertEquals(XiangqiPieceType.NONE,p11_black.getPieceType());
		assertEquals(XiangqiColor.NONE,p11_black.getColor());
		assertEquals(XiangqiPieceType.CHARIOT,p21_black.getPieceType());
		assertEquals(XiangqiColor.BLACK,p21_black.getColor());
	}
	
	@Test //16
	public void soldierCanMoveFrom23To33AndEatEnemysPiece(){
		assertEquals(MoveResult.OK,game.makeMove(makeCoordinate(2,3),makeCoordinate(3,3)));
		XiangqiPiece p23red=game.getPieceAt(makeCoordinate(2,3),XiangqiColor.RED);
		XiangqiPiece p33red=game.getPieceAt(makeCoordinate(3,3),XiangqiColor.RED);
		assertEquals(XiangqiPieceType.NONE,p23red.getPieceType());
		assertEquals(XiangqiColor.NONE,p23red.getColor());
		assertEquals(XiangqiPieceType.SOLDIER,p33red.getPieceType());
		assertEquals(XiangqiColor.RED,p33red.getColor());
		assertEquals(MoveResult.OK,game.makeMove(makeCoordinate(2,3),makeCoordinate(3,3)));
		XiangqiPiece p23black=game.getPieceAt(makeCoordinate(2,3),XiangqiColor.BLACK);
		XiangqiPiece p33black=game.getPieceAt(makeCoordinate(3,3),XiangqiColor.BLACK);
		assertEquals(XiangqiPieceType.NONE,p23black.getPieceType());
		assertEquals(XiangqiColor.NONE,p23black.getColor());
		assertEquals(XiangqiPieceType.SOLDIER,p33black.getPieceType());
		assertEquals(XiangqiColor.BLACK,p33black.getColor());
	}
	
	@Test //17
	public void soldierCanNotMoveHorizontally(){
		assertEquals(MoveResult.ILLEGAL,game.makeMove(makeCoordinate(2,3),makeCoordinate(2,4)));
		XiangqiPiece p23red=game.getPieceAt(makeCoordinate(2,3),XiangqiColor.RED);
		XiangqiPiece p24red=game.getPieceAt(makeCoordinate(2,4),XiangqiColor.RED);
		assertEquals(XiangqiPieceType.SOLDIER,p23red.getPieceType());
		assertEquals(XiangqiColor.RED,p23red.getColor());
		assertEquals(XiangqiPieceType.NONE,p24red.getPieceType());
		assertEquals(XiangqiColor.NONE,p24red.getColor());
	}
	
	@Test //18
	public void soldierCanNotMoveBackward(){
		assertEquals(MoveResult.OK,game.makeMove(makeCoordinate(2,3),makeCoordinate(3,3)));
		assertEquals(MoveResult.OK,game.makeMove(makeCoordinate(1,1), makeCoordinate(2,1)));
		assertEquals(MoveResult.ILLEGAL,game.makeMove(makeCoordinate(3,3),makeCoordinate(3,2)));
	}
	
	@Test //19
	public void soldierCannotStepOnTheSameColor(){
		assertEquals(MoveResult.OK,game.makeMove(makeCoordinate(1,1),makeCoordinate(3,1)));
		assertEquals(MoveResult.OK,game.makeMove(makeCoordinate(1,1),makeCoordinate(2,1)));
		assertEquals(MoveResult.OK,game.makeMove(makeCoordinate(3,1),makeCoordinate(3,3)));
		XiangqiPiece p33red=game.getPieceAt(makeCoordinate(3,3),XiangqiColor.RED);
		assertEquals(XiangqiColor.RED,p33red.getColor());
		assertEquals(XiangqiPieceType.CHARIOT,p33red.getPieceType());
		assertEquals(MoveResult.OK,game.makeMove(makeCoordinate(1,5),makeCoordinate(4,5)));
		assertEquals(MoveResult.ILLEGAL,game.makeMove(makeCoordinate(2,3),makeCoordinate(3,3)));
		p33red=game.getPieceAt(makeCoordinate(3,3),XiangqiColor.RED);
		assertEquals(XiangqiColor.RED,p33red.getColor());
		assertEquals(XiangqiPieceType.CHARIOT,p33red.getPieceType());
	}
	
	@Test //20
	public void chariotCannotGoCrossAnyPiecesVertically(){
		assertEquals(MoveResult.OK,game.makeMove(makeCoordinate(1,1),makeCoordinate(2,1)));
		assertEquals(MoveResult.OK,game.makeMove(makeCoordinate(1,5),makeCoordinate(2,5)));
		assertEquals(MoveResult.ILLEGAL,game.makeMove(makeCoordinate(2,1),makeCoordinate(5,1)));
		XiangqiPiece p25black=game.getPieceAt(makeCoordinate(2,5),XiangqiColor.BLACK);
		XiangqiPiece p45black=game.getPieceAt(makeCoordinate(4,5),XiangqiColor.BLACK);
		assertEquals(XiangqiColor.BLACK,p25black.getColor());
		assertEquals(XiangqiColor.RED,p45black.getColor());
		assertEquals(XiangqiPieceType.CHARIOT,p45black.getPieceType());
		assertEquals(XiangqiPieceType.CHARIOT,p25black.getPieceType());
	}
	
	@Test //21
	public void chariotCannotGoCrossAnyPiecesHorizontally(){
		assertEquals(MoveResult.OK,game.makeMove(makeCoordinate(1,1),makeCoordinate(3,1)));
		assertEquals(MoveResult.OK,game.makeMove(makeCoordinate(2,3),makeCoordinate(3,3)));
		assertEquals(MoveResult.ILLEGAL,game.makeMove(makeCoordinate(3,1),makeCoordinate(3,4)));	
	}
	
	@Test //22
	public void advisorCanMoveOneDiagonal(){
		assertEquals(MoveResult.OK,game.makeMove(makeCoordinate(1,2),makeCoordinate(2,1)));
		assertEquals(MoveResult.OK,game.makeMove(makeCoordinate(1,2),makeCoordinate(2,1)));
		assertEquals(MoveResult.OK,game.makeMove(makeCoordinate(1,4),makeCoordinate(2,5)));
		assertEquals(MoveResult.OK,game.makeMove(makeCoordinate(1,4),makeCoordinate(2,5)));
	}
	
	@Test //23
	public void advisorCanNotEatSameColor(){
		assertEquals(MoveResult.ILLEGAL,game.makeMove(makeCoordinate(1,2),makeCoordinate(2,3)));
		assertEquals(MoveResult.ILLEGAL,game.makeMove(makeCoordinate(1,4),makeCoordinate(2,3)));
		assertEquals(MoveResult.OK,game.makeMove(makeCoordinate(1,2),makeCoordinate(2,1)));
		assertEquals(MoveResult.ILLEGAL,game.makeMove(makeCoordinate(1,2),makeCoordinate(2,3)));
		assertEquals(MoveResult.ILLEGAL,game.makeMove(makeCoordinate(1,4),makeCoordinate(2,3)));
	}
	
	@Test //23
	public void advisorCanNotMoveOrthognally(){
		assertEquals(MoveResult.ILLEGAL,game.makeMove(makeCoordinate(1,2),makeCoordinate(2,2)));
		assertEquals(MoveResult.ILLEGAL,game.makeMove(makeCoordinate(1,4),makeCoordinate(4,4)));
		assertEquals(MoveResult.OK,game.makeMove(makeCoordinate(1,2),makeCoordinate(2,1)));
		assertEquals(MoveResult.ILLEGAL,game.makeMove(makeCoordinate(1,2),makeCoordinate(2,2)));
		assertEquals(MoveResult.ILLEGAL,game.makeMove(makeCoordinate(1,4),makeCoordinate(4,4)));
		assertEquals(MoveResult.OK,game.makeMove(makeCoordinate(1,2),makeCoordinate(2,1)));
		assertEquals(MoveResult.ILLEGAL,game.makeMove(makeCoordinate(2,1),makeCoordinate(2,2)));
		assertEquals(MoveResult.OK,game.makeMove(makeCoordinate(2,1),makeCoordinate(3,2)));
		assertEquals(MoveResult.ILLEGAL,game.makeMove(makeCoordinate(2,1),makeCoordinate(2,2)));
		assertEquals(MoveResult.OK,game.makeMove(makeCoordinate(2,1),makeCoordinate(3,2)));
	}
	
	@Test //24
	public void generalCanMoveFrom13To23(){
		assertEquals(MoveResult.OK,game.makeMove(makeCoordinate(2,3),makeCoordinate(3,3)));
		assertEquals(MoveResult.OK,game.makeMove(makeCoordinate(2,3),makeCoordinate(3,3)));
		assertEquals(MoveResult.OK,game.makeMove(makeCoordinate(1,3),makeCoordinate(2,3)));
		assertEquals(MoveResult.OK,game.makeMove(makeCoordinate(1,3),makeCoordinate(2,3)));
	}
}
