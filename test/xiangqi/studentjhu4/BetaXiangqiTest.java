package xiangqi.studentjhu4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import xiangqi.XiangqiGameFactory;
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
}
