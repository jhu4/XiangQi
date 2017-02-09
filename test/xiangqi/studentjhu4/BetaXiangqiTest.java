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
	public void nonepiecesInitializedCorrectlyInRedAspect(){
		//any coordinate in the file of 2-4 except (2,3) and (4,3) 
		for(int rank=2;rank<=4;rank++){
			for(int file=1;file<=5;file++){
				if((rank!=2 && file!=3)||(rank!=4 && file!=3)){
					XiangqiPiece pxy=game.getPieceAt(makeCoordinate(rank,file), XiangqiColor.RED);
					assertEquals(XiangqiColor.NONE,pxy.getColor());
					assertEquals(XiangqiPieceType.NONE,pxy.getPieceType());
				}
			}
		}
	}
	
	@Test //7
	public void redChariotCanMoveFrom11To21(){
		assertEquals(MoveResult.OK,game.makeMove(makeCoordinate(1,1),makeCoordinate(2,1)));
	}
	
	@Test //8
	public void redChariotCanMoveFrom15To45(){
		assertEquals(MoveResult.OK,game.makeMove(makeCoordinate(1,5),makeCoordinate(4,5)));
	}
	
	@Test //9
	public void redChariotCanNotMoveFrom11To22(){
		assertEquals(MoveResult.ILLEGAL,game.makeMove(makeCoordinate(1,1),makeCoordinate(2,2)));
	}
	
	@Test //10
	public void redChariotCanNotMoveFrom11To12(){
		assertEquals(MoveResult.ILLEGAL,game.makeMove(makeCoordinate(1,1),makeCoordinate(1,2)));
	}
}
