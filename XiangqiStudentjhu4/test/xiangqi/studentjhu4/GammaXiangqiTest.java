package xiangqi.studentjhu4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import xiangqi.XiangqiGameFactory;
import xiangqi.common.XiangqiColor;
import xiangqi.common.XiangqiCoordinate;
import xiangqi.common.XiangqiGame;
import xiangqi.common.XiangqiGameVersion;
import xiangqi.common.XiangqiPiece;
import xiangqi.common.XiangqiPieceType;
import xiangqi.studentjhu4.BetaXiangqiTest.TestCoordinate;

public class GammaXiangqiTest {
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
		game=XiangqiGameFactory.makeXiangqiGame(XiangqiGameVersion.GAMMA_XQ);
	}
	
	@Test //1
	public void factoryProduceGammaXiangqiGame(){
		assertNotNull(game);
	}
	
	@Test //2
	public void chariotsInitializedCorrectly(){
		final XiangqiPiece p11r=game.getPieceAt(makeCoordinate(1,1), XiangqiColor.RED);
		final XiangqiPiece p19r=game.getPieceAt(makeCoordinate(1,1), XiangqiColor.RED);
		final XiangqiPiece p101r=game.getPieceAt(makeCoordinate(10,9), XiangqiColor.RED);
		final XiangqiPiece p109r=game.getPieceAt(makeCoordinate(10,1), XiangqiColor.RED);
		final XiangqiPiece p101b=game.getPieceAt(makeCoordinate(10,9), XiangqiColor.BLACK);
		final XiangqiPiece p109b=game.getPieceAt(makeCoordinate(10,1), XiangqiColor.BLACK);
		final XiangqiPiece p11b=game.getPieceAt(makeCoordinate(1,1), XiangqiColor.BLACK);
		final XiangqiPiece p19b=game.getPieceAt(makeCoordinate(1,1), XiangqiColor.BLACK);
		assertEquals(XiangqiColor.RED,p11r.getColor());
		assertEquals(XiangqiColor.RED,p19r.getColor());
		assertEquals(XiangqiColor.RED,p109b.getColor());
		assertEquals(XiangqiColor.RED,p101b.getColor());
		assertEquals(XiangqiColor.BLACK,p11b.getColor());
		assertEquals(XiangqiColor.BLACK,p19b.getColor());
		assertEquals(XiangqiColor.BLACK,p109r.getColor());
		assertEquals(XiangqiColor.BLACK,p101r.getColor());
		assertEquals(XiangqiPieceType.CHARIOT,p11r.getPieceType());
		assertEquals(XiangqiPieceType.CHARIOT,p19r.getPieceType());
		assertEquals(XiangqiPieceType.CHARIOT,p11b.getPieceType());
		assertEquals(XiangqiPieceType.CHARIOT,p19b.getPieceType());
		assertEquals(XiangqiPieceType.CHARIOT,p109b.getPieceType());
		assertEquals(XiangqiPieceType.CHARIOT,p101b.getPieceType());
		assertEquals(XiangqiPieceType.CHARIOT,p109r.getPieceType());
		assertEquals(XiangqiPieceType.CHARIOT,p101r.getPieceType());	
	}
}
