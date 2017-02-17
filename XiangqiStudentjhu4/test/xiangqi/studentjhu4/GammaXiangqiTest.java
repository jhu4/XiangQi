package xiangqi.studentjhu4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static xiangqi.common.XiangqiColor.*;
import static xiangqi.common.XiangqiPieceType.*;

import java.util.concurrent.CompletionException;

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

public class GammaXiangqiTest {
	private XiangqiGame game;
	
	private static XiangqiCoordinate 
			c11 = makeCoordinate(1, 1), c12 = makeCoordinate(1, 2),
			c13 = makeCoordinate(1, 3), c14 = makeCoordinate(1, 4),
			c15 = makeCoordinate(1, 5), c16 = makeCoordinate(1, 6),
			c17 = makeCoordinate(1, 7), c18 = makeCoordinate(1, 8),
			c19 = makeCoordinate(1, 9),
			c21 = makeCoordinate(2, 1), c22 = makeCoordinate(2, 2),
			c23 = makeCoordinate(2, 3), c24 = makeCoordinate(2, 4),
			c25 = makeCoordinate(2, 5), c26 = makeCoordinate(2, 6),
			c27 = makeCoordinate(2, 7), c28 = makeCoordinate(2, 8),
			c29 = makeCoordinate(2, 9),
			c31 = makeCoordinate(3, 1), c32 = makeCoordinate(3, 2),
			c33 = makeCoordinate(3, 3), c34 = makeCoordinate(3, 4),
			c35 = makeCoordinate(3, 5), c36 = makeCoordinate(3 ,6),
			c37 = makeCoordinate(3, 7), c38 = makeCoordinate(3 ,8),
			c39 = makeCoordinate(3, 9),
			c41 = makeCoordinate(4, 1), c42 = makeCoordinate(4, 2),
			c43 = makeCoordinate(4, 3), c44 = makeCoordinate(4, 4),
			c45 = makeCoordinate(4, 5), c46 = makeCoordinate(4, 6),
			c47 = makeCoordinate(4, 7), c48 = makeCoordinate(4, 8),
			c49 = makeCoordinate(4, 9),
			c51 = makeCoordinate(5, 1), c52 = makeCoordinate(5, 2),
			c53 = makeCoordinate(5, 3), c54 = makeCoordinate(5, 4),
			c55 = makeCoordinate(5, 5), c56 = makeCoordinate(5, 6),
			c57 = makeCoordinate(5, 7), c58 = makeCoordinate(5, 8),
			c59 = makeCoordinate(5, 9), 
			c61 = makeCoordinate(6, 1), c62 = makeCoordinate(6, 2),
			c63 = makeCoordinate(6, 3), c64 = makeCoordinate(6, 4),
			c65 = makeCoordinate(6, 5), c66 = makeCoordinate(6, 6),
			c67 = makeCoordinate(6, 7), c68 = makeCoordinate(6, 8),
			c69 = makeCoordinate(6, 9), 
			c71 = makeCoordinate(7, 1), c72 = makeCoordinate(7, 2),
			c73 = makeCoordinate(7, 3), c74 = makeCoordinate(7, 4),
			c75 = makeCoordinate(7, 5), c76 = makeCoordinate(7, 6),
			c77 = makeCoordinate(7, 7), c78 = makeCoordinate(7, 8),
			c79 = makeCoordinate(7, 9), 
			c81 = makeCoordinate(8, 1), c82 = makeCoordinate(8, 2),
			c83 = makeCoordinate(8, 3), c84 = makeCoordinate(8, 4),
			c85 = makeCoordinate(8, 5), c86 = makeCoordinate(8, 6),
			c87 = makeCoordinate(8, 7), c88 = makeCoordinate(8, 8),
			c89 = makeCoordinate(8, 9), 
			c91 = makeCoordinate(9, 1), c92 = makeCoordinate(9, 2),
			c93 = makeCoordinate(9, 3), c94 = makeCoordinate(9, 4),
			c95 = makeCoordinate(9, 5), c96 = makeCoordinate(9, 6),
			c97 = makeCoordinate(9, 7), c98 = makeCoordinate(9, 8),
			c99 = makeCoordinate(9, 9),
			c101 = makeCoordinate(10, 1), c102 = makeCoordinate(10, 2),
			c103 = makeCoordinate(10, 3), c104 = makeCoordinate(10, 4),
			c105 = makeCoordinate(10, 5), c106 = makeCoordinate(10, 6),
			c107 = makeCoordinate(10, 7), c108 = makeCoordinate(10, 8),
			c109 = makeCoordinate(10, 9);
	
	private static XiangqiPiece noPiece = 
			makePiece(XiangqiPieceType.NONE, XiangqiColor.NONE), 
			redChariot = makePiece(CHARIOT, RED),
			redElephant= makePiece(ELEPHANT,RED),
			redAdvisor = makePiece(ADVISOR, RED),
			redGeneral = makePiece(GENERAL, RED),
			redSoldier = makePiece(SOLDIER, RED),
			blackChariot = makePiece(CHARIOT, BLACK),
			blackElephant= makePiece(ELEPHANT, BLACK),
			blackAdvisor = makePiece(ADVISOR, BLACK),
			blackGeneral = makePiece(GENERAL, BLACK),
			blackSoldier = makePiece(SOLDIER, BLACK);
	

	static class TestCoordinate implements XiangqiCoordinate
	{
		private final int rank;
		private final int file;
		
		public TestCoordinate(int rank, int file){
			this.rank = rank;
			this.file = file;
		}
		
		@Override
		public int getRank(){
			return rank;
		}
	
		@Override
		public int getFile(){
			return file;
		}
	}
	
	static class TestPiece implements XiangqiPiece
	{
		private final XiangqiColor color;
		private final XiangqiPieceType pieceType;
		
		public TestPiece(XiangqiPieceType pieceType, XiangqiColor color){
			this.pieceType = pieceType;
			this.color = color;
		}
		
		/*
		 * @see xiangqi.common.XiangqiPiece#getColor()
		 */
		@Override
		public XiangqiColor getColor(){
			return color;
		}
	
		/*
		 * @see xiangqi.common.XiangqiPiece#getPieceType()
		 */
		@Override
		public XiangqiPieceType getPieceType(){
			return pieceType;
		}
	
		@Override
		public boolean equals(Object obj){
			XiangqiPiece other = (XiangqiPiece) obj;
			if (color != other.getColor())
				return false;
			if (pieceType != other.getPieceType())
				return false;
			return true;
		}
	}
	
	// Helper methods
	private static XiangqiCoordinate makeCoordinate(int rank, int file)
	{
		return new TestCoordinate(rank, file);
	}

	public static XiangqiPiece makePiece(XiangqiPieceType pieceType, XiangqiColor color)
	{
		return new TestPiece(pieceType, color);
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
		final XiangqiPiece p11r=game.getPieceAt(c11, XiangqiColor.RED);
		final XiangqiPiece p19r=game.getPieceAt(makeCoordinate(1,9), XiangqiColor.RED);
		assertEquals(XiangqiColor.RED,p11r.getColor());
		assertEquals(XiangqiColor.RED,p19r.getColor());
		assertEquals(XiangqiPieceType.CHARIOT,p11r.getPieceType());
		assertEquals(XiangqiPieceType.CHARIOT,p19r.getPieceType());
	}
			
	@Test //3
	public void blackChariotsInitializedCorrectlyInRedApspect(){
		final XiangqiPiece p101r=game.getPieceAt(c101, XiangqiColor.RED);
		final XiangqiPiece p109r=game.getPieceAt(makeCoordinate(10,9), XiangqiColor.RED);
		assertEquals(XiangqiColor.BLACK,p109r.getColor());
		assertEquals(XiangqiColor.BLACK,p101r.getColor());
		assertEquals(XiangqiPieceType.CHARIOT,p109r.getPieceType());
		assertEquals(XiangqiPieceType.CHARIOT,p101r.getPieceType());		
	}	

	@Test //4
	public void redChariotsInitializedCorrectlyInBlackApspect(){	
		final XiangqiPiece p101b=game.getPieceAt(c101, XiangqiColor.BLACK);
		final XiangqiPiece p109b=game.getPieceAt(makeCoordinate(10,9), XiangqiColor.BLACK);
		assertEquals(XiangqiColor.RED,p109b.getColor());
		assertEquals(XiangqiColor.RED,p101b.getColor());
		assertEquals(XiangqiPieceType.CHARIOT,p109b.getPieceType());
		assertEquals(XiangqiPieceType.CHARIOT,p101b.getPieceType());
	}
	
	@Test //5
	public void blackChariotsInitializedCorrectlyInBlackApspect(){
		final XiangqiPiece p11b=game.getPieceAt(c11, XiangqiColor.BLACK);
		final XiangqiPiece p19b=game.getPieceAt(makeCoordinate(1,9), XiangqiColor.BLACK);
		assertEquals(XiangqiColor.BLACK,p11b.getColor());
		assertEquals(XiangqiColor.BLACK,p19b.getColor());
		assertEquals(XiangqiPieceType.CHARIOT,p11b.getPieceType());
		assertEquals(XiangqiPieceType.CHARIOT,p19b.getPieceType());
	}
	
	@Test //6
	public void redElephantInitializedCorrectlyInRedAspect(){
		final XiangqiPiece p13r=game.getPieceAt(c13, XiangqiColor.RED);
		final XiangqiPiece p17r=game.getPieceAt(c17, XiangqiColor.RED);
		assertEquals(XiangqiColor.RED,p13r.getColor());
		assertEquals(XiangqiColor.RED,p17r.getColor());
		assertEquals(XiangqiPieceType.ELEPHANT,p13r.getPieceType());
		assertEquals(XiangqiPieceType.ELEPHANT,p17r.getPieceType());
	}

	@Test //7
	public void redElephantInitializedCorrectlyInBlackAspect(){
		final XiangqiPiece p107b=game.getPieceAt(c107, XiangqiColor.BLACK);
		final XiangqiPiece p103b=game.getPieceAt(c103, XiangqiColor.BLACK);
		assertEquals(XiangqiColor.RED,p107b.getColor());
		assertEquals(XiangqiColor.RED,p103b.getColor());
		assertEquals(XiangqiPieceType.ELEPHANT,p107b.getPieceType());
		assertEquals(XiangqiPieceType.ELEPHANT,p103b.getPieceType());
	}
	

	@Test //8
	public void blackElephantInitializedCorrectlyInBlackAspect(){
		final XiangqiPiece p13b=game.getPieceAt(c13, XiangqiColor.BLACK);
		final XiangqiPiece p17b=game.getPieceAt(c17, XiangqiColor.BLACK);
		assertEquals(XiangqiColor.BLACK,p13b.getColor());
		assertEquals(XiangqiColor.BLACK,p17b.getColor());
		assertEquals(XiangqiPieceType.ELEPHANT,p13b.getPieceType());
		assertEquals(XiangqiPieceType.ELEPHANT,p17b.getPieceType());
	}
	

	@Test //9
	public void blackElephantInitializedCorrectlyInRedAspect(){
		final XiangqiPiece p107r=game.getPieceAt(c107, XiangqiColor.RED);
		final XiangqiPiece p103r=game.getPieceAt(c103, XiangqiColor.RED);
		assertEquals(XiangqiColor.BLACK,p107r.getColor());
		assertEquals(XiangqiColor.BLACK,p103r.getColor());
		assertEquals(XiangqiPieceType.ELEPHANT,p107r.getPieceType());
		assertEquals(XiangqiPieceType.ELEPHANT,p103r.getPieceType());
	}
	
	@Test //10
	public void redAdvisorInitializedCorrectlyInRedAspect(){
		final XiangqiPiece p14r=game.getPieceAt(c14, XiangqiColor.RED);
		final XiangqiPiece p16r=game.getPieceAt(c16, XiangqiColor.RED);
		assertEquals(XiangqiColor.RED,p14r.getColor());
		assertEquals(XiangqiColor.RED,p16r.getColor());
		assertEquals(XiangqiPieceType.ADVISOR,p14r.getPieceType());
		assertEquals(XiangqiPieceType.ADVISOR,p16r.getPieceType());
	}
	
	@Test //11
	public void redAdvisorInitializedCorrectlyInBlackAspect(){
		final XiangqiPiece p106b=game.getPieceAt(c106, XiangqiColor.BLACK);
		final XiangqiPiece p104b=game.getPieceAt(makeCoordinate(10,4), XiangqiColor.BLACK);
		assertEquals(XiangqiColor.RED,p106b.getColor());
		assertEquals(XiangqiColor.RED,p104b.getColor());
		assertEquals(XiangqiPieceType.ADVISOR,p106b.getPieceType());
		assertEquals(XiangqiPieceType.ADVISOR,p104b.getPieceType());
	}
	
	
	@Test //12
	public void blackAdvisorInitializedCorrectlyInBlackAspect(){
		final XiangqiPiece p14b=game.getPieceAt(c14, XiangqiColor.BLACK);
		final XiangqiPiece p16b=game.getPieceAt(c16, XiangqiColor.BLACK);
		assertEquals(XiangqiColor.BLACK,p14b.getColor());
		assertEquals(XiangqiColor.BLACK,p16b.getColor());
		assertEquals(XiangqiPieceType.ADVISOR,p14b.getPieceType());
		assertEquals(XiangqiPieceType.ADVISOR,p16b.getPieceType());
	}
	
	@Test //13
	public void blackAdvisorInitializedCorrectlyInRedAspect(){
		final XiangqiPiece p106r=game.getPieceAt(c106, XiangqiColor.RED);
		final XiangqiPiece p104r=game.getPieceAt(makeCoordinate(10,4), XiangqiColor.RED);
		assertEquals(XiangqiColor.BLACK,p106r.getColor());
		assertEquals(XiangqiColor.BLACK,p104r.getColor());
		assertEquals(XiangqiPieceType.ADVISOR,p106r.getPieceType());
		assertEquals(XiangqiPieceType.ADVISOR,p104r.getPieceType());
	}
	
	@Test //14
	public void redGeneralInitializedCorrectlyInRedRAspect(){
		final XiangqiPiece p15r=game.getPieceAt(makeCoordinate(1,5), XiangqiColor.RED);
		assertEquals(XiangqiColor.RED,p15r.getColor());
		assertEquals(XiangqiPieceType.GENERAL,p15r.getPieceType());
	}
	
	@Test //15
	public void blackGeneralInitializedCorrectlyInRedAspect(){
		final XiangqiPiece p105r=game.getPieceAt(c105, XiangqiColor.RED);
		assertEquals(XiangqiColor.BLACK,p105r.getColor());
		assertEquals(XiangqiPieceType.GENERAL,p105r.getPieceType());
	}
	
	@Test //16
	public void blackGeneralInitializedCorrectlyInBlackAspect(){
		final XiangqiPiece p15b=game.getPieceAt(makeCoordinate(1,5), XiangqiColor.BLACK);
		assertEquals(XiangqiColor.BLACK,p15b.getColor());
		assertEquals(XiangqiPieceType.GENERAL,p15b.getPieceType());
	}
	
	@Test //17
	public void redGeneralInitializedCorrectlyInBlackAspect(){
		final XiangqiPiece p105b=game.getPieceAt(c105, XiangqiColor.BLACK);
		assertEquals(XiangqiColor.RED,p105b.getColor());
		assertEquals(XiangqiPieceType.GENERAL,p105b.getPieceType());
	}
	
	@Test //18
	public void redSoldierInitializedCorrectlyInRedAspect(){
		final XiangqiPiece p41r=game.getPieceAt(c41, XiangqiColor.RED);
		final XiangqiPiece p43r=game.getPieceAt(c43, XiangqiColor.RED);
		final XiangqiPiece p45r=game.getPieceAt(c45, XiangqiColor.RED);
		final XiangqiPiece p47r=game.getPieceAt(c47, XiangqiColor.RED);
		final XiangqiPiece p49r=game.getPieceAt(c49, XiangqiColor.RED);
		assertEquals(XiangqiColor.RED,p41r.getColor());
		assertEquals(XiangqiColor.RED,p43r.getColor());
		assertEquals(XiangqiColor.RED,p45r.getColor());
		assertEquals(XiangqiColor.RED,p47r.getColor());
		assertEquals(XiangqiColor.RED,p49r.getColor());
		assertEquals(XiangqiPieceType.SOLDIER,p41r.getPieceType());
		assertEquals(XiangqiPieceType.SOLDIER,p43r.getPieceType());
		assertEquals(XiangqiPieceType.SOLDIER,p45r.getPieceType());
		assertEquals(XiangqiPieceType.SOLDIER,p47r.getPieceType());
		assertEquals(XiangqiPieceType.SOLDIER,p49r.getPieceType());
	}
	
	@Test //19
	public void blackSoldierInitializedCorrectlyInBlackAspect(){
		final XiangqiPiece p41b=game.getPieceAt(c41, XiangqiColor.BLACK);
		final XiangqiPiece p43b=game.getPieceAt(c43, XiangqiColor.BLACK);
		final XiangqiPiece p45b=game.getPieceAt(c45, XiangqiColor.BLACK);
		final XiangqiPiece p47b=game.getPieceAt(c47, XiangqiColor.BLACK);
		final XiangqiPiece p49b=game.getPieceAt(c49, XiangqiColor.BLACK);
		assertEquals(XiangqiColor.BLACK,p41b.getColor());
		assertEquals(XiangqiColor.BLACK,p43b.getColor());
		assertEquals(XiangqiColor.BLACK,p45b.getColor());
		assertEquals(XiangqiColor.BLACK,p47b.getColor());
		assertEquals(XiangqiColor.BLACK,p49b.getColor());
		assertEquals(XiangqiPieceType.SOLDIER,p41b.getPieceType());
		assertEquals(XiangqiPieceType.SOLDIER,p43b.getPieceType());
		assertEquals(XiangqiPieceType.SOLDIER,p45b.getPieceType());
		assertEquals(XiangqiPieceType.SOLDIER,p47b.getPieceType());
		assertEquals(XiangqiPieceType.SOLDIER,p49b.getPieceType());
	}
	
	@Test //20
	public void redSoldierInitializedCorrectlyInBlackAspect(){
		final XiangqiPiece p71b=game.getPieceAt(c71, XiangqiColor.BLACK);
		final XiangqiPiece p73b=game.getPieceAt(c73, XiangqiColor.BLACK);
		final XiangqiPiece p75b=game.getPieceAt(c75, XiangqiColor.BLACK);
		final XiangqiPiece p77b=game.getPieceAt(c77, XiangqiColor.BLACK);
		final XiangqiPiece p79b=game.getPieceAt(c79, XiangqiColor.BLACK);
		assertEquals(XiangqiColor.RED,p71b.getColor());
		assertEquals(XiangqiColor.RED,p73b.getColor());
		assertEquals(XiangqiColor.RED,p75b.getColor());
		assertEquals(XiangqiColor.RED,p77b.getColor());
		assertEquals(XiangqiColor.RED,p79b.getColor());
		assertEquals(XiangqiPieceType.SOLDIER,p71b.getPieceType());
		assertEquals(XiangqiPieceType.SOLDIER,p73b.getPieceType());
		assertEquals(XiangqiPieceType.SOLDIER,p75b.getPieceType());
		assertEquals(XiangqiPieceType.SOLDIER,p77b.getPieceType());
		assertEquals(XiangqiPieceType.SOLDIER,p79b.getPieceType());
	}
	
	@Test //21
	public void blackSoldierInitializedCorrectlyInRedAspect(){
		final XiangqiPiece p71r=game.getPieceAt(c71, XiangqiColor.RED);
		final XiangqiPiece p73r=game.getPieceAt(c73, XiangqiColor.RED);
		final XiangqiPiece p75r=game.getPieceAt(c75, XiangqiColor.RED);
		final XiangqiPiece p77r=game.getPieceAt(c77, XiangqiColor.RED);
		final XiangqiPiece p79r=game.getPieceAt(c79, XiangqiColor.RED);
		assertEquals(XiangqiColor.BLACK,p71r.getColor());
		assertEquals(XiangqiColor.BLACK,p73r.getColor());
		assertEquals(XiangqiColor.BLACK,p75r.getColor());
		assertEquals(XiangqiColor.BLACK,p77r.getColor());
		assertEquals(XiangqiColor.BLACK,p79r.getColor());
		assertEquals(XiangqiPieceType.SOLDIER,p71r.getPieceType());
		assertEquals(XiangqiPieceType.SOLDIER,p73r.getPieceType());
		assertEquals(XiangqiPieceType.SOLDIER,p75r.getPieceType());
		assertEquals(XiangqiPieceType.SOLDIER,p77r.getPieceType());
		assertEquals(XiangqiPieceType.SOLDIER,p79r.getPieceType());
	}
	
	@Test //22
	public void getPieceAtreturnNoneNone(){
		final XiangqiPiece p21r=game.getPieceAt(c21, XiangqiColor.RED);
		final XiangqiPiece p55b=game.getPieceAt(c55, XiangqiColor.BLACK);
		assertEquals(XiangqiColor.NONE,p21r.getColor());
		assertEquals(XiangqiColor.NONE,p55b.getColor());
		assertEquals(XiangqiPieceType.NONE,p21r.getPieceType());
		assertEquals(XiangqiPieceType.NONE,p55b.getPieceType());
	}
	
	@Test(expected=CompletionException.class) //23
	public void catchExceptionWhenGetPieceAtInvalidPlace(){
		final XiangqiPiece invalid=game.getPieceAt(makeCoordinate(-1,-1), XiangqiColor.RED);
	}
	
	@Test //24
	public void chariotCanMoveVertically(){
		assertEquals(MoveResult.OK,game.makeMove(c11, c21));
		assertEquals(MoveResult.OK,game.makeMove(c11, c31));
		assertEquals(MoveResult.OK,game.makeMove(c21, c11));
		assertEquals(MoveResult.OK,game.makeMove(c31, c21));
	}
	
	@Test //25
	public void chariotCanMoveHorizontally(){
		assertEquals(MoveResult.OK,game.makeMove(c11, c12));
		assertEquals(MoveResult.OK,game.makeMove(c11, c12));
		assertEquals(MoveResult.OK,game.makeMove(c12, c11));
		assertEquals(MoveResult.OK,game.makeMove(c12, c11));
	}
	
	@Test //26
	public void chariotCanNotEatSameColorPiece(){
		assertEquals(MoveResult.ILLEGAL,game.makeMove(c11, c41));
		assertEquals(MoveResult.ILLEGAL,game.makeMove(c11, c41));
	}
	
	@Test //27
	public void chariotCanNotJump(){
		assertEquals(MoveResult.ILLEGAL,game.makeMove(c11, c101));
		assertEquals(MoveResult.OK,game.makeMove(c11, c21));
		assertEquals(MoveResult.ILLEGAL,game.makeMove(c11, c101));
	}
	
	@Test //28
	public void chariotCanNotMoveDiagonally(){
		assertEquals(MoveResult.ILLEGAL,game.makeMove(c11, c22));
		assertEquals(MoveResult.OK,game.makeMove(c11, c12));
		assertEquals(MoveResult.ILLEGAL,game.makeMove(c11, c22));
	}
	@Test //29
	public void advisorCanMoveDiagonallyWithDistanceOne(){
		assertEquals(MoveResult.OK,game.makeMove(c14, c25));
		assertEquals(MoveResult.OK,game.makeMove(c14, c25));
		assertEquals(MoveResult.OK,game.makeMove(c25, c34));
		assertEquals(MoveResult.OK,game.makeMove(c25, c34));
		assertEquals(MoveResult.OK,game.makeMove(c16, c25));
		assertEquals(MoveResult.OK,game.makeMove(c16, c25));
		assertEquals(MoveResult.OK,game.makeMove(c25, c36));
		assertEquals(MoveResult.OK,game.makeMove(c25, c36));
		assertEquals(MoveResult.OK,game.makeMove(c34, c25));
		assertEquals(MoveResult.OK,game.makeMove(c34, c25));
		assertEquals(MoveResult.OK,game.makeMove(c25, c14));
		assertEquals(MoveResult.OK,game.makeMove(c25, c14));
	}
	
	@Test //29
	public void advisorCanNotMoveOrthogaonally(){
		assertEquals(MoveResult.OK,game.makeMove(c14, c25));
		assertEquals(MoveResult.OK,game.makeMove(c14, c25));
		assertEquals(MoveResult.ILLEGAL,game.makeMove(c25, c24));
		assertEquals(MoveResult.ILLEGAL,game.makeMove(c25, c35));
		assertEquals(MoveResult.OK,game.makeMove(c25, c34));
		assertEquals(MoveResult.ILLEGAL,game.makeMove(c25, c24));
		assertEquals(MoveResult.ILLEGAL,game.makeMove(c25, c35));
		assertEquals(MoveResult.OK,game.makeMove(c25, c34));
	}
	
	@Test //30
	public void advisorCanNotMoveOutOfThePalace(){
		assertEquals(MoveResult.OK,game.makeMove(c14, c25));
		assertEquals(MoveResult.ILLEGAL,game.makeMove(c14, c23));
		assertEquals(MoveResult.OK,game.makeMove(c14, c25));
		assertEquals(MoveResult.ILLEGAL,game.makeMove(c14, c23));
		assertEquals(MoveResult.OK,game.makeMove(c25, c36));
		assertEquals(MoveResult.ILLEGAL,game.makeMove(c36, c45));
		assertEquals(MoveResult.OK,game.makeMove(c25, c36));
		assertEquals(MoveResult.ILLEGAL,game.makeMove(c36, c45));
	}
	
	@Test //32
	public void elephantCanMoveDiagonallyInDistanceOfTwo(){
		assertEquals(MoveResult.OK,game.makeMove(c13, c31));
		assertEquals(MoveResult.OK,game.makeMove(c13, c31));
		assertEquals(MoveResult.OK,game.makeMove(c17, c35));
		assertEquals(MoveResult.OK,game.makeMove(c17, c35));
	}
	
	@Test //33
	public void elephantCanNotMoveInOneOrThreeDiagonal(){
		assertEquals(MoveResult.ILLEGAL, game.makeMove(c13, c22));
		assertEquals(MoveResult.ILLEGAL, game.makeMove(c13,c57));
	}
	
	@Test //34
	public void elephantCanNotMoveOrthogonally(){
		assertEquals(MoveResult.ILLEGAL, game.makeMove(c13,c53));
		assertEquals(MoveResult.OK, game.makeMove(c13,c31));
		assertEquals(MoveResult.OK, game.makeMove(c11, c21));
		assertEquals(MoveResult.ILLEGAL, game.makeMove(c13,c53));
	}
	@Test //35
	public void elephantCanNotMoveIfBlocked(){
		assertEquals(MoveResult.OK,game.makeMove(c11, c21));
		assertEquals(MoveResult.OK,game.makeMove(c11, c21));
		assertEquals(MoveResult.OK,game.makeMove(c21, c22));
		assertEquals(MoveResult.OK,game.makeMove(c21, c22));
		assertEquals(MoveResult.ILLEGAL,game.makeMove(c13, c31));
		assertEquals(MoveResult.OK,game.makeMove(c45, c55));
		assertEquals(MoveResult.ILLEGAL,game.makeMove(c13, c31));
	}
}
