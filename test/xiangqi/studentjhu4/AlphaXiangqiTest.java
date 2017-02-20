package xiangqi.studentjhu4;
import static org.junit.Assert.*;
import org.junit.Before;

import xiangqi.XiangqiGameFactory;

import org.junit.Test;
import xiangqi.XiangqiGameFactory;
import xiangqi.common.MoveResult;
import xiangqi.common.XiangqiColor;
import xiangqi.common.XiangqiCoordinate;
import xiangqi.common.XiangqiGame;
import xiangqi.common.XiangqiGameVersion;
import xiangqi.common.XiangqiPiece;
import xiangqi.common.XiangqiPieceType;
import xiangqi.common.XiangqiGame;
import xiangqi.common.XiangqiGameVersion;

/**
 * Test cases for XiangQi Alpha
 * @author Dorothy
 *
 */
public class AlphaXiangqiTest {
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
	
	@Before
	public void setup(){
		game=XiangqiGameFactory.makeXiangqiGame(XiangqiGameVersion.ALPHA_XQ);
	}
	
	
	@Test //1
	public void factoryProduceAlphaXiangQiGame(){
		assertNotNull(game);
	}
	
	@Test //2
	public void redMakesValidFirstMove(){
		assertEquals(MoveResult.OK,game.makeMove(TestCoordinate.makeCoordinate(1,1),
													TestCoordinate.makeCoordinate(1, 2)));
	}
	
	@Test //3
	public void blackMakesValidSecondMove(){
		game.makeMove(TestCoordinate.makeCoordinate(1,1),TestCoordinate.makeCoordinate(1, 2));
		assertEquals(MoveResult.RED_WINS,game.makeMove(TestCoordinate.makeCoordinate(1, 1),
														TestCoordinate.makeCoordinate(1, 2)));
	}
	
	@Test //4
	public void tryToMoveToInvalidLocation(){
		assertEquals(MoveResult.ILLEGAL,game.makeMove(TestCoordinate.makeCoordinate(1, 1),
				TestCoordinate.makeCoordinate(2, 1)));
		assertTrue(game.getMoveMessage().length()>=1);
	}
	
	@Test //5
	public void tryToMoveFromInvalidLocation(){
		assertEquals(MoveResult.ILLEGAL,game.makeMove(TestCoordinate.makeCoordinate(2, 1),
				TestCoordinate.makeCoordinate(1, 2)));
		assertTrue(game.getMoveMessage().length()>=1);
	}
	
	@Test //6
	public void getPieceAtReturnsNoneNone(){
		final XiangqiPiece p=game.getPieceAt(TestCoordinate.makeCoordinate(1, 1), XiangqiColor.RED);
		assertEquals(XiangqiPieceType.NONE,p.getPieceType());
		assertEquals(XiangqiColor.NONE,p.getColor());
	}
	
}