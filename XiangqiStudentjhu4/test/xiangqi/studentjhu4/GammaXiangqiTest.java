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
	public void redChariotsInitializedCorrectlyInRedAspect(){
		final XiangqiPiece p11r=game.getPieceAt(makeCoordinate(1,1), XiangqiColor.RED);
		final XiangqiPiece p19r=game.getPieceAt(makeCoordinate(1,9), XiangqiColor.RED);
		assertEquals(XiangqiColor.RED,p11r.getColor());
		assertEquals(XiangqiColor.RED,p19r.getColor());
		assertEquals(XiangqiPieceType.CHARIOT,p11r.getPieceType());
		assertEquals(XiangqiPieceType.CHARIOT,p19r.getPieceType());
	}
			
	@Test //3
	public void blackChariotsInitializedCorrectlyInRedApspect(){
		final XiangqiPiece p101r=game.getPieceAt(makeCoordinate(10,1), XiangqiColor.RED);
		final XiangqiPiece p109r=game.getPieceAt(makeCoordinate(10,9), XiangqiColor.RED);
		assertEquals(XiangqiColor.BLACK,p109r.getColor());
		assertEquals(XiangqiColor.BLACK,p101r.getColor());
		assertEquals(XiangqiPieceType.CHARIOT,p109r.getPieceType());
		assertEquals(XiangqiPieceType.CHARIOT,p101r.getPieceType());		
	}	

	@Test //4
	public void redChariotsInitializedCorrectlyInBlackApspect(){	
		final XiangqiPiece p101b=game.getPieceAt(makeCoordinate(10,1), XiangqiColor.BLACK);
		final XiangqiPiece p109b=game.getPieceAt(makeCoordinate(10,9), XiangqiColor.BLACK);
		assertEquals(XiangqiColor.RED,p109b.getColor());
		assertEquals(XiangqiColor.RED,p101b.getColor());
		assertEquals(XiangqiPieceType.CHARIOT,p109b.getPieceType());
		assertEquals(XiangqiPieceType.CHARIOT,p101b.getPieceType());
	}
	
	@Test //5
	public void blackChariotsInitializedCorrectlyInBlackApspect(){
		final XiangqiPiece p11b=game.getPieceAt(makeCoordinate(1,1), XiangqiColor.BLACK);
		final XiangqiPiece p19b=game.getPieceAt(makeCoordinate(1,9), XiangqiColor.BLACK);
		assertEquals(XiangqiColor.BLACK,p11b.getColor());
		assertEquals(XiangqiColor.BLACK,p19b.getColor());
		assertEquals(XiangqiPieceType.CHARIOT,p11b.getPieceType());
		assertEquals(XiangqiPieceType.CHARIOT,p19b.getPieceType());
	}
	
	@Test //6
	public void redElephantInitializedCorrectlyInRedAspect(){
		final XiangqiPiece p13r=game.getPieceAt(makeCoordinate(1,3), XiangqiColor.RED);
		final XiangqiPiece p17r=game.getPieceAt(makeCoordinate(1,7), XiangqiColor.RED);
		assertEquals(XiangqiColor.RED,p13r.getColor());
		assertEquals(XiangqiColor.RED,p17r.getColor());
		assertEquals(XiangqiPieceType.ELEPHANT,p13r.getPieceType());
		assertEquals(XiangqiPieceType.ELEPHANT,p17r.getPieceType());
	}

	@Test //7
	public void redElephantInitializedCorrectlyInBlackAspect(){
		final XiangqiPiece p107b=game.getPieceAt(makeCoordinate(10,7), XiangqiColor.BLACK);
		final XiangqiPiece p103b=game.getPieceAt(makeCoordinate(10,3), XiangqiColor.BLACK);
		assertEquals(XiangqiColor.RED,p107b.getColor());
		assertEquals(XiangqiColor.RED,p103b.getColor());
		assertEquals(XiangqiPieceType.ELEPHANT,p107b.getPieceType());
		assertEquals(XiangqiPieceType.ELEPHANT,p103b.getPieceType());
	}
	

	@Test //8
	public void blackElephantInitializedCorrectlyInBlackAspect(){
		final XiangqiPiece p13b=game.getPieceAt(makeCoordinate(1,3), XiangqiColor.BLACK);
		final XiangqiPiece p17b=game.getPieceAt(makeCoordinate(1,7), XiangqiColor.BLACK);
		assertEquals(XiangqiColor.BLACK,p13b.getColor());
		assertEquals(XiangqiColor.BLACK,p17b.getColor());
		assertEquals(XiangqiPieceType.ELEPHANT,p13b.getPieceType());
		assertEquals(XiangqiPieceType.ELEPHANT,p17b.getPieceType());
	}
	

	@Test //9
	public void blackElephantInitializedCorrectlyInRedAspect(){
		final XiangqiPiece p107r=game.getPieceAt(makeCoordinate(10,7), XiangqiColor.RED);
		final XiangqiPiece p103r=game.getPieceAt(makeCoordinate(10,3), XiangqiColor.RED);
		assertEquals(XiangqiColor.BLACK,p107r.getColor());
		assertEquals(XiangqiColor.BLACK,p103r.getColor());
		assertEquals(XiangqiPieceType.ELEPHANT,p107r.getPieceType());
		assertEquals(XiangqiPieceType.ELEPHANT,p103r.getPieceType());
	}
	
	@Test //10
	public void redAdvisorInitializedCorrectlyInRedAspect(){
		final XiangqiPiece p14r=game.getPieceAt(makeCoordinate(1,4), XiangqiColor.RED);
		final XiangqiPiece p16r=game.getPieceAt(makeCoordinate(1,6), XiangqiColor.RED);
		assertEquals(XiangqiColor.RED,p14r.getColor());
		assertEquals(XiangqiColor.RED,p16r.getColor());
		assertEquals(XiangqiPieceType.ADVISOR,p14r.getPieceType());
		assertEquals(XiangqiPieceType.ADVISOR,p16r.getPieceType());
	}
	
	@Test //11
	public void redAdvisorInitializedCorrectlyInBlackAspect(){
		final XiangqiPiece p106b=game.getPieceAt(makeCoordinate(10,6), XiangqiColor.BLACK);
		final XiangqiPiece p104b=game.getPieceAt(makeCoordinate(10,4), XiangqiColor.BLACK);
		assertEquals(XiangqiColor.RED,p106b.getColor());
		assertEquals(XiangqiColor.RED,p104b.getColor());
		assertEquals(XiangqiPieceType.ADVISOR,p106b.getPieceType());
		assertEquals(XiangqiPieceType.ADVISOR,p104b.getPieceType());
	}
	
	
	@Test //12
	public void blackAdvisorInitializedCorrectlyInBlackAspect(){
		final XiangqiPiece p14b=game.getPieceAt(makeCoordinate(1,4), XiangqiColor.BLACK);
		final XiangqiPiece p16b=game.getPieceAt(makeCoordinate(1,6), XiangqiColor.BLACK);
		assertEquals(XiangqiColor.BLACK,p14b.getColor());
		assertEquals(XiangqiColor.BLACK,p16b.getColor());
		assertEquals(XiangqiPieceType.ADVISOR,p14b.getPieceType());
		assertEquals(XiangqiPieceType.ADVISOR,p16b.getPieceType());
	}
	
	@Test //13
	public void blackAdvisorInitializedCorrectlyInRedAspect(){
		final XiangqiPiece p106r=game.getPieceAt(makeCoordinate(10,6), XiangqiColor.RED);
		final XiangqiPiece p104r=game.getPieceAt(makeCoordinate(10,4), XiangqiColor.RED);
		assertEquals(XiangqiColor.BLACK,p106r.getColor());
		assertEquals(XiangqiColor.BLACK,p104r.getColor());
		assertEquals(XiangqiPieceType.ADVISOR,p106r.getPieceType());
		assertEquals(XiangqiPieceType.ADVISOR,p104r.getPieceType());
	}
	
	@Test //14
	public void redGeneralInitializedCorrectlyInRedRespect(){
		final XiangqiPiece p15r=game.getPieceAt(makeCoordinate(1,5), XiangqiColor.RED);
		assertEquals(XiangqiColor.RED,p15r.getColor());
		assertEquals(XiangqiPieceType.GENERAL,p15r.getPieceType());
	}
}