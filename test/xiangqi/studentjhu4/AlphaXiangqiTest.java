package xiangqi.studentjhu4;
import static org.junit.Assert.*;
import org.junit.Before;

import xiangqi.XiangqiGameFactory;

import org.junit.Test;
import xiangqi.XiangqiGameFactory;
import xiangqi.common.MoveResult;
import xiangqi.common.XiangqiGame;
import xiangqi.common.XiangqiGameVersion;
/**
 * Test cases for XiangQi Alpha
 * @author Dorothy
 *
 */
public class AlphaXiangqiTest {
	private XiangqiGame game;
	
	@Before
	public void setup(){
		game=XiangqiGameFactory.makeXiangqiGame(XiangqiGameVersion.ALPHA_XQ);
	}
	
	
	@Test
	public void factoryProduceAlphaXiangQiGame(){
		assertNotNull(game);
	}
	
	@Test
	public void redMakesFirstValidMove(){
		assertEquals(MoveResult.OK,game.makeMove(TestCoordinate.makeCoordinate(1,1)));
	}
}
