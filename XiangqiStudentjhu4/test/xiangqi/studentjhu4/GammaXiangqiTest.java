package xiangqi.studentjhu4;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import xiangqi.XiangqiGameFactory;
import xiangqi.common.XiangqiCoordinate;
import xiangqi.common.XiangqiGame;
import xiangqi.common.XiangqiGameVersion;
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
}
