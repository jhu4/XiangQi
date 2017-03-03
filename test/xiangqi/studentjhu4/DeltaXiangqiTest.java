package xiangqi.studentjhu4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static xiangqi.common.MoveResult.BLACK_WINS;
import static xiangqi.common.MoveResult.DRAW;
import static xiangqi.common.MoveResult.ILLEGAL;
import static xiangqi.common.MoveResult.OK;
import static xiangqi.common.MoveResult.RED_WINS;
import static xiangqi.common.XiangqiColor.BLACK;
import static xiangqi.common.XiangqiColor.RED;
import static xiangqi.common.XiangqiPieceType.ADVISOR;
import static xiangqi.common.XiangqiPieceType.CHARIOT;
import static xiangqi.common.XiangqiPieceType.ELEPHANT;
import static xiangqi.common.XiangqiPieceType.GENERAL;
import static xiangqi.common.XiangqiPieceType.SOLDIER;
import static xiangqi.common.XiangqiPieceType.CANNON;
import static xiangqi.common.XiangqiPieceType.HORSE;

import java.util.concurrent.CompletionException;

import org.junit.Before;
import org.junit.Test;

import xiangqi.XiangqiGameFactory;
import xiangqi.common.XiangqiColor;
import xiangqi.common.XiangqiCoordinate;
import xiangqi.common.XiangqiGame;
import xiangqi.common.XiangqiGameVersion;
import xiangqi.common.XiangqiPiece;
import xiangqi.common.XiangqiPieceType;
import xiangqi.studentjhu4.GammaXiangqiTest.TestCoordinate;
import xiangqi.studentjhu4.GammaXiangqiTest.TestPiece;

public class DeltaXiangqiTest {
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
			blackSoldier = makePiece(SOLDIER, BLACK),
			redCannon = makePiece(CANNON,RED),
			blackCannon = makePiece(CANNON,BLACK),
			redHorse = makePiece(HORSE,RED),
			blackHorse = makePiece(HORSE,BLACK);
			
			
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
		game=XiangqiGameFactory.makeXiangqiGame(XiangqiGameVersion.DELTA_XQ);
	}
	
	@Test //1
	public void factoryProduceGammaXiangqiGame(){
		assertNotNull(game);
	}
	
	@Test //2
	public void redChariotsInitializedCorrectlyInRedAspect(){
		final XiangqiPiece p11r=game.getPieceAt(c11, RED);
		final XiangqiPiece p19r=game.getPieceAt(makeCoordinate(1,9), RED);
		assertEquals(RED,p11r.getColor());
		assertEquals(RED,p19r.getColor());
		assertEquals(CHARIOT,p11r.getPieceType());
		assertEquals(CHARIOT,p19r.getPieceType());
	}
			
	@Test //3
	public void blackChariotsInitializedCorrectlyInRedApspect(){
		final XiangqiPiece p101r=game.getPieceAt(c101, RED);
		final XiangqiPiece p109r=game.getPieceAt(makeCoordinate(10,9), RED);
		assertEquals(BLACK,p109r.getColor());
		assertEquals(BLACK,p101r.getColor());
		assertEquals(CHARIOT,p109r.getPieceType());
		assertEquals(CHARIOT,p101r.getPieceType());		
	}	

	@Test //4
	public void redChariotsInitializedCorrectlyInBlackApspect(){	
		final XiangqiPiece p101b=game.getPieceAt(c101, BLACK);
		final XiangqiPiece p109b=game.getPieceAt(makeCoordinate(10,9), BLACK);
		assertEquals(RED,p109b.getColor());
		assertEquals(RED,p101b.getColor());
		assertEquals(CHARIOT,p109b.getPieceType());
		assertEquals(CHARIOT,p101b.getPieceType());
	}
	
	@Test //5
	public void blackChariotsInitializedCorrectlyInBlackApspect(){
		final XiangqiPiece p11b=game.getPieceAt(c11, BLACK);
		final XiangqiPiece p19b=game.getPieceAt(makeCoordinate(1,9), BLACK);
		assertEquals(BLACK,p11b.getColor());
		assertEquals(BLACK,p19b.getColor());
		assertEquals(CHARIOT,p11b.getPieceType());
		assertEquals(CHARIOT,p19b.getPieceType());
	}
	
	@Test //6
	public void redElephantInitializedCorrectlyInRedAspect(){
		final XiangqiPiece p13r=game.getPieceAt(c13, RED);
		final XiangqiPiece p17r=game.getPieceAt(c17, RED);
		assertEquals(RED,p13r.getColor());
		assertEquals(RED,p17r.getColor());
		assertEquals(ELEPHANT,p13r.getPieceType());
		assertEquals(ELEPHANT,p17r.getPieceType());
	}

	@Test //7
	public void redElephantInitializedCorrectlyInBlackAspect(){
		final XiangqiPiece p107b=game.getPieceAt(c107, BLACK);
		final XiangqiPiece p103b=game.getPieceAt(c103, BLACK);
		assertEquals(RED,p107b.getColor());
		assertEquals(RED,p103b.getColor());
		assertEquals(ELEPHANT,p107b.getPieceType());
		assertEquals(ELEPHANT,p103b.getPieceType());
	}
	

	@Test //8
	public void blackElephantInitializedCorrectlyInBlackAspect(){
		final XiangqiPiece p13b=game.getPieceAt(c13, BLACK);
		final XiangqiPiece p17b=game.getPieceAt(c17, BLACK);
		assertEquals(BLACK,p13b.getColor());
		assertEquals(BLACK,p17b.getColor());
		assertEquals(ELEPHANT,p13b.getPieceType());
		assertEquals(ELEPHANT,p17b.getPieceType());
	}
	

	@Test //9
	public void blackElephantInitializedCorrectlyInRedAspect(){
		final XiangqiPiece p107r=game.getPieceAt(c107, RED);
		final XiangqiPiece p103r=game.getPieceAt(c103, RED);
		assertEquals(BLACK,p107r.getColor());
		assertEquals(BLACK,p103r.getColor());
		assertEquals(ELEPHANT,p107r.getPieceType());
		assertEquals(ELEPHANT,p103r.getPieceType());
	}
	
	@Test //10
	public void redAdvisorInitializedCorrectlyInRedAspect(){
		final XiangqiPiece p14r=game.getPieceAt(c14, RED);
		final XiangqiPiece p16r=game.getPieceAt(c16, RED);
		assertEquals(RED,p14r.getColor());
		assertEquals(RED,p16r.getColor());
		assertEquals(ADVISOR,p14r.getPieceType());
		assertEquals(ADVISOR,p16r.getPieceType());
	}
	
	@Test //11
	public void redAdvisorInitializedCorrectlyInBlackAspect(){
		final XiangqiPiece p106b=game.getPieceAt(c106, BLACK);
		final XiangqiPiece p104b=game.getPieceAt(makeCoordinate(10,4), BLACK);
		assertEquals(RED,p106b.getColor());
		assertEquals(RED,p104b.getColor());
		assertEquals(ADVISOR,p106b.getPieceType());
		assertEquals(ADVISOR,p104b.getPieceType());
	}
	
	
	@Test //12
	public void blackAdvisorInitializedCorrectlyInBlackAspect(){
		final XiangqiPiece p14b=game.getPieceAt(c14, BLACK);
		final XiangqiPiece p16b=game.getPieceAt(c16, BLACK);
		assertEquals(BLACK,p14b.getColor());
		assertEquals(BLACK,p16b.getColor());
		assertEquals(ADVISOR,p14b.getPieceType());
		assertEquals(ADVISOR,p16b.getPieceType());
	}
	
	@Test //13
	public void blackAdvisorInitializedCorrectlyInRedAspect(){
		final XiangqiPiece p106r=game.getPieceAt(c106, RED);
		final XiangqiPiece p104r=game.getPieceAt(makeCoordinate(10,4), RED);
		assertEquals(BLACK,p106r.getColor());
		assertEquals(BLACK,p104r.getColor());
		assertEquals(ADVISOR,p106r.getPieceType());
		assertEquals(ADVISOR,p104r.getPieceType());
	}
	
	@Test //14
	public void redGeneralInitializedCorrectlyInRedRAspect(){
		final XiangqiPiece p15r=game.getPieceAt(makeCoordinate(1,5), RED);
		assertEquals(RED,p15r.getColor());
		assertEquals(GENERAL,p15r.getPieceType());
	}
	
	@Test //15
	public void blackGeneralInitializedCorrectlyInRedAspect(){
		final XiangqiPiece p105r=game.getPieceAt(c105, RED);
		assertEquals(BLACK,p105r.getColor());
		assertEquals(GENERAL,p105r.getPieceType());
	}
	
	@Test //16
	public void blackGeneralInitializedCorrectlyInBlackAspect(){
		final XiangqiPiece p15b=game.getPieceAt(makeCoordinate(1,5), BLACK);
		assertEquals(BLACK,p15b.getColor());
		assertEquals(GENERAL,p15b.getPieceType());
	}
	
	@Test //17
	public void redGeneralInitializedCorrectlyInBlackAspect(){
		final XiangqiPiece p105b=game.getPieceAt(c105, BLACK);
		assertEquals(RED,p105b.getColor());
		assertEquals(GENERAL,p105b.getPieceType());
	}
	
	@Test //18
	public void redSoldierInitializedCorrectlyInRedAspect(){
		final XiangqiPiece p41r=game.getPieceAt(c41, RED);
		final XiangqiPiece p43r=game.getPieceAt(c43, RED);
		final XiangqiPiece p45r=game.getPieceAt(c45, RED);
		final XiangqiPiece p47r=game.getPieceAt(c47, RED);
		final XiangqiPiece p49r=game.getPieceAt(c49, RED);
		assertEquals(RED,p41r.getColor());
		assertEquals(RED,p43r.getColor());
		assertEquals(RED,p45r.getColor());
		assertEquals(RED,p47r.getColor());
		assertEquals(RED,p49r.getColor());
		assertEquals(SOLDIER,p41r.getPieceType());
		assertEquals(SOLDIER,p43r.getPieceType());
		assertEquals(SOLDIER,p45r.getPieceType());
		assertEquals(SOLDIER,p47r.getPieceType());
		assertEquals(SOLDIER,p49r.getPieceType());
	}
	
	@Test //19
	public void blackSoldierInitializedCorrectlyInBlackAspect(){
		final XiangqiPiece p41b=game.getPieceAt(c41, BLACK);
		final XiangqiPiece p43b=game.getPieceAt(c43, BLACK);
		final XiangqiPiece p45b=game.getPieceAt(c45, BLACK);
		final XiangqiPiece p47b=game.getPieceAt(c47, BLACK);
		final XiangqiPiece p49b=game.getPieceAt(c49, BLACK);
		assertEquals(BLACK,p41b.getColor());
		assertEquals(BLACK,p43b.getColor());
		assertEquals(BLACK,p45b.getColor());
		assertEquals(BLACK,p47b.getColor());
		assertEquals(BLACK,p49b.getColor());
		assertEquals(SOLDIER,p41b.getPieceType());
		assertEquals(SOLDIER,p43b.getPieceType());
		assertEquals(SOLDIER,p45b.getPieceType());
		assertEquals(SOLDIER,p47b.getPieceType());
		assertEquals(SOLDIER,p49b.getPieceType());
	}
	
	@Test //20
	public void redSoldierInitializedCorrectlyInBlackAspect(){
		final XiangqiPiece p71b=game.getPieceAt(c71, BLACK);
		final XiangqiPiece p73b=game.getPieceAt(c73, BLACK);
		final XiangqiPiece p75b=game.getPieceAt(c75, BLACK);
		final XiangqiPiece p77b=game.getPieceAt(c77, BLACK);
		final XiangqiPiece p79b=game.getPieceAt(c79, BLACK);
		assertEquals(RED,p71b.getColor());
		assertEquals(RED,p73b.getColor());
		assertEquals(RED,p75b.getColor());
		assertEquals(RED,p77b.getColor());
		assertEquals(RED,p79b.getColor());
		assertEquals(SOLDIER,p71b.getPieceType());
		assertEquals(SOLDIER,p73b.getPieceType());
		assertEquals(SOLDIER,p75b.getPieceType());
		assertEquals(SOLDIER,p77b.getPieceType());
		assertEquals(SOLDIER,p79b.getPieceType());
	}
	
	@Test //21
	public void blackSoldierInitializedCorrectlyInRedAspect(){
		final XiangqiPiece p71r=game.getPieceAt(c71, RED);
		final XiangqiPiece p73r=game.getPieceAt(c73, RED);
		final XiangqiPiece p75r=game.getPieceAt(c75, RED);
		final XiangqiPiece p77r=game.getPieceAt(c77, RED);
		final XiangqiPiece p79r=game.getPieceAt(c79, RED);
		assertEquals(BLACK,p71r.getColor());
		assertEquals(BLACK,p73r.getColor());
		assertEquals(BLACK,p75r.getColor());
		assertEquals(BLACK,p77r.getColor());
		assertEquals(BLACK,p79r.getColor());
		assertEquals(SOLDIER,p71r.getPieceType());
		assertEquals(SOLDIER,p73r.getPieceType());
		assertEquals(SOLDIER,p75r.getPieceType());
		assertEquals(SOLDIER,p77r.getPieceType());
		assertEquals(SOLDIER,p79r.getPieceType());
	}
	
	@Test //22
	public void getPieceAtreturnNoneNone(){
		final XiangqiPiece p21r=game.getPieceAt(c21, RED);
		final XiangqiPiece p55b=game.getPieceAt(c55, BLACK);
		assertEquals(XiangqiColor.NONE,p21r.getColor());
		assertEquals(XiangqiColor.NONE,p55b.getColor());
		assertEquals(XiangqiPieceType.NONE,p21r.getPieceType());
		assertEquals(XiangqiPieceType.NONE,p55b.getPieceType());
	}
	
	//23
	@Test(expected=CompletionException.class) 
	public void catchExceptionWhenGetPieceAtInvalidPlace(){
		final XiangqiPiece invalid=game.getPieceAt(makeCoordinate(-1,-1), RED);
	}
	
	//23.5
	@Test
	public void illegalWhenMakeInvalidCoordinateMove(){
		assertEquals(ILLEGAL,game.makeMove(makeCoordinate(-1,0), c11));
	}
	
	@Test //24
	public void chariotCanMoveVertically(){
		assertEquals(OK,game.makeMove(c11, c21));
		assertEquals(OK,game.makeMove(c11, c31));
		assertEquals(OK,game.makeMove(c21, c11));
		assertEquals(OK,game.makeMove(c31, c21));
	}
	
	//24.5
	@Test 
	public void pieceCannotStayAtSameLocation(){
		assertEquals(ILLEGAL,game.makeMove(c11, c11));
		assertEquals(ILLEGAL,game.makeMove(c12, c12));
		assertEquals(ILLEGAL,game.makeMove(c13, c13));
		assertEquals(ILLEGAL,game.makeMove(c14, c14));
		assertEquals(ILLEGAL,game.makeMove(c15, c15));
		assertEquals(ILLEGAL,game.makeMove(c32, c32));
		assertEquals(ILLEGAL,game.makeMove(c41, c41));
	}
	
	@Test //25
	public void chariotCanMoveHorizontally(){
		assertEquals(OK,game.makeMove(c11, c21));
		assertEquals(OK,game.makeMove(c11, c21));
		assertEquals(OK,game.makeMove(c21, c22));
		assertEquals(OK,game.makeMove(c21, c22));
		assertEquals(OK,game.makeMove(c22, c21));
		assertEquals(OK,game.makeMove(c22, c21));
	}
	
	@Test //26
	public void chariotCanNotEatSameColorPiece(){
		assertEquals(ILLEGAL,game.makeMove(c11, c41));
		assertEquals(ILLEGAL,game.makeMove(c11, c41));
	}
	
	@Test //27
	public void chariotCanNotJump(){
		assertEquals(ILLEGAL,game.makeMove(c11, c101));
		assertEquals(OK,game.makeMove(c11, c21));
		assertEquals(ILLEGAL,game.makeMove(c11, c101));
	}
	
	@Test //28
	public void chariotCanNotMoveDiagonally(){
		assertEquals(ILLEGAL,game.makeMove(c11, c22));
		assertEquals(OK,game.makeMove(c11, c21));
		assertEquals(ILLEGAL,game.makeMove(c11, c22));
	}
	@Test //29
	public void advisorCanMoveDiagonallyWithDistanceOne(){
		assertEquals(OK,game.makeMove(c14, c25));
		assertEquals(OK,game.makeMove(c14, c25));
		assertEquals(OK,game.makeMove(c25, c34));
		assertEquals(OK,game.makeMove(c25, c34));
		assertEquals(OK,game.makeMove(c16, c25));
		assertEquals(OK,game.makeMove(c16, c25));
		assertEquals(OK,game.makeMove(c25, c36));
		assertEquals(OK,game.makeMove(c25, c36));
		assertEquals(OK,game.makeMove(c34, c25));
		assertEquals(OK,game.makeMove(c34, c25));
		assertEquals(OK,game.makeMove(c25, c14));
		assertEquals(OK,game.makeMove(c25, c14));
	}
	
	@Test //29
	public void advisorCanNotMoveOrthogaonally(){
		assertEquals(OK,game.makeMove(c14, c25));
		assertEquals(OK,game.makeMove(c14, c25));
		assertEquals(ILLEGAL,game.makeMove(c25, c24));
		assertEquals(ILLEGAL,game.makeMove(c25, c35));
		assertEquals(OK,game.makeMove(c25, c34));
		assertEquals(ILLEGAL,game.makeMove(c25, c24));
		assertEquals(ILLEGAL,game.makeMove(c25, c35));
		assertEquals(OK,game.makeMove(c25, c34));
	}
	
	@Test //30
	public void advisorCanNotMoveOutOfThePalace(){
		assertEquals(OK,game.makeMove(c14, c25));
		assertEquals(ILLEGAL,game.makeMove(c14, c23));
		assertEquals(OK,game.makeMove(c14, c25));
		assertEquals(ILLEGAL,game.makeMove(c14, c23));
		assertEquals(OK,game.makeMove(c25, c36));
		assertEquals(ILLEGAL,game.makeMove(c36, c45));
		assertEquals(OK,game.makeMove(c25, c36));
		assertEquals(ILLEGAL,game.makeMove(c36, c45));
	}
	
	@Test //32
	public void elephantCanMoveDiagonallyInDistanceOfTwo(){
		assertEquals(OK,game.makeMove(c13, c31));
		assertEquals(redElephant,game.getPieceAt(c31, RED));
		assertEquals(OK,game.makeMove(c13, c31));
		assertEquals(OK,game.makeMove(c17, c35));
		assertEquals(OK,game.makeMove(c17, c35));
	}
	
	@Test //33
	public void elephantCanNotMoveInOneOrThreeDiagonal(){
		assertEquals(ILLEGAL, game.makeMove(c13, c22));
		assertEquals(ILLEGAL, game.makeMove(c13,c57));
	}
	
	@Test //34
	public void elephantCanNotMoveOrthogonally(){
		assertEquals(ILLEGAL, game.makeMove(c13,c53));
		assertEquals(OK, game.makeMove(c13,c31));
		assertEquals(OK, game.makeMove(c11, c21));
		assertEquals(ILLEGAL, game.makeMove(c13,c53));
	}
	
	@Test //35
	public void elephantCanNotMoveIfBlocked(){
		assertEquals(OK,game.makeMove(c11, c21));
		assertEquals(OK,game.makeMove(c11, c21));
		assertEquals(OK,game.makeMove(c21, c22));
		assertEquals(OK,game.makeMove(c21, c22));
		assertEquals(ILLEGAL,game.makeMove(c13, c31));
		assertEquals(OK,game.makeMove(c45, c55));
		assertEquals(ILLEGAL,game.makeMove(c13, c31));
	}
	
	@Test //36
	public void elephantCanNotCrossTheRiver(){
		assertEquals(OK,game.makeMove(c13, c35));
		assertEquals(OK,game.makeMove(c17, c39));
		assertEquals(OK,game.makeMove(c35, c53));
		assertEquals(OK,game.makeMove(c39, c57));
		assertEquals(ILLEGAL,game.makeMove(c53, c75));
		assertEquals(OK,game.makeMove(c53, c31));
		assertEquals(ILLEGAL,game.makeMove(c57,c79));
	}
	
	@Test //37
	public void generalCanMoveVertically(){
		assertEquals(OK,game.makeMove(c15, c25));
		assertEquals(OK,game.makeMove(c15, c25));
		assertEquals(OK,game.makeMove(c25, c35));
		assertEquals(OK,game.makeMove(c25, c35));
	}
	
	@Test //38
	public void generalCanMoveHorizontally(){
		assertEquals(OK,game.makeMove(c14, c25));
		assertEquals(OK,game.makeMove(c14, c25));
		assertEquals(OK,game.makeMove(c15, c14));
		assertEquals(OK,game.makeMove(c15, c14));
	}
	
	@Test //39
	public void generalCanNoTMoveDiagonally(){
		assertEquals(ILLEGAL,game.makeMove(c15, c24));
	}
	
	@Test //40
	public void generalCanNotMoveOutOfPalace(){
		assertEquals(OK,game.makeMove(c45, c55));
		assertEquals(OK,game.makeMove(c45, c55));
		assertEquals(OK,game.makeMove(c14, c25));
		assertEquals(OK,game.makeMove(c15, c25));
		assertEquals(OK,game.makeMove(c15, c14));
		assertEquals(OK,game.makeMove(c25, c35));
		assertEquals(ILLEGAL,game.makeMove(c14, c13));
		assertEquals(OK,game.makeMove(c14, c24));
		assertEquals(ILLEGAL,game.makeMove(c35, c45));
		assertEquals(ILLEGAL,game.makeMove(c35, c55));
	}
	
	/*
	@Test //40.5
	public void generalCanDoFlyingGeneralMove(){
		assertEquals(OK,game.makeMove(c45, c55));
		assertEquals(OK,game.makeMove(c45, c55));
		assertEquals(OK,game.makeMove(c55, c65));
		assertEquals(OK,game.makeMove(c11, c21));
		assertEquals(OK,game.makeMove(c65, c75));
		assertEquals(OK,game.makeMove(c21, c11));
		assertEquals(OK,game.makeMove(c75, c85));
		assertEquals(OK,game.makeMove(c11, c21));
		assertEquals(OK,game.makeMove(c85, c95));
		assertEquals(OK,game.makeMove(c15, c25));
		assertEquals(OK,game.makeMove(c15, c95));
	}
	*/	
		
	@Test //41
	public void soldierCanMoveForwardInDistanceOfOne(){
		assertEquals(OK,game.makeMove(c45, c55));
		assertEquals(OK,game.makeMove(c41, c51));
	}
	
	@Test //42
	public void soldierCanNotMoveDiagonally(){
		assertEquals(ILLEGAL,game.makeMove(c41, c52));
	}
	
	@Test //43
	public void soldierCanNotMoveHorizontalInOurSide(){
		assertEquals(ILLEGAL,game.makeMove(c41, c42));
		assertEquals(OK,game.makeMove(c41, c51));
		assertEquals(ILLEGAL,game.makeMove(c43, c44));		
	}
	
	@Test //44
	public void soldierCanMoveHorizontallyOverRiver(){
		assertEquals(OK,game.makeMove(c41, c51));
		assertEquals(OK,game.makeMove(c45, c55));
		assertEquals(OK,game.makeMove(c51, c61));
		assertEquals(OK,game.makeMove(c55, c65));
		assertEquals(OK,game.makeMove(c61, c62));
		assertEquals(OK,game.makeMove(c65, c66));
	}
	
	@Test //45
	public void soldierCanNotMoveBackwardInOurSide(){
		assertEquals(ILLEGAL,game.makeMove(c45, c35));
		assertEquals(OK,game.makeMove(c41, c51));
		assertEquals(OK,game.makeMove(c49, c59));
		assertEquals(ILLEGAL,game.makeMove(c51, c41));
		assertEquals(OK,game.makeMove(c51, c61));
		assertEquals(ILLEGAL,game.makeMove(c59, c49));
	}
	
	@Test //46
	public void soldierCanNotMoveBackwardOverRiver(){
		assertEquals(OK,game.makeMove(c49, c59));
		assertEquals(OK,game.makeMove(c43, c53));
		assertEquals(OK,game.makeMove(c59, c69));
		assertEquals(OK,game.makeMove(c53, c63));
		assertEquals(OK,game.makeMove(c69, c79));
		assertEquals(OK,game.makeMove(c63, c73));
		assertEquals(ILLEGAL,game.makeMove(c79, c69));
		assertEquals(OK,game.makeMove(c79, c78));
		assertEquals(ILLEGAL,game.makeMove(c73, c63));
	}
	
	@Test //47
	public void playerCannotSuicideUsingChariotToCheck(){
		assertEquals(OK,game.makeMove(c45, c55));
		assertEquals(OK,game.makeMove(c45, c55));
		assertEquals(OK,game.makeMove(c11, c21));
		assertEquals(OK,game.makeMove(c55, c65));
		assertEquals(OK,game.makeMove(c21, c25));
		assertEquals(blackSoldier,game.getPieceAt(c65, BLACK));
		assertEquals(ILLEGAL,game.makeMove(c65, c64));
		assertEquals(blackSoldier,game.getPieceAt(c65, BLACK));
		assertEquals(OK,game.makeMove(c14, c25));
		assertEquals(OK,game.makeMove(c49, c59));
		assertEquals(OK,game.makeMove(c65, c64));
	}
	
	@Test //48
	public void playerMustProtectingItsGeneral(){
		assertEquals(OK,game.makeMove(c45, c55));
		assertEquals(OK,game.makeMove(c19, c29));
		assertEquals(OK,game.makeMove(c55, c65));
		assertEquals(OK,game.makeMove(c29, c26));
		assertEquals(OK,game.makeMove(c65, c75));
		assertEquals(OK,game.makeMove(c26, c96));
		assertEquals(OK,game.makeMove(c75, c85));
		assertEquals(OK,game.makeMove(c96, c95));
		assertEquals(ILLEGAL,game.makeMove(c85, c95));
		assertEquals(ILLEGAL,game.makeMove(c11, c21));
		assertEquals(OK,game.makeMove(c14, c25));
	}
	
	
	@Test //49
	public void noIllegalMsgWithOKMove(){
		assertEquals(OK,game.makeMove(makeCoordinate(1,1),makeCoordinate(2,1)));
		assertEquals(null,game.getMoveMessage());
	}
	
	@Test //50
	public void illegalMsgWithIllegalMove(){
		assertEquals(ILLEGAL,game.makeMove(makeCoordinate(1,1),makeCoordinate(1,3)));
		assertTrue(game.getMoveMessage().length()>=1);
	}
	
	@Test //51
	public void legalMsgWorkSeveralTimes(){
		assertEquals(ILLEGAL,game.makeMove(makeCoordinate(1,1),makeCoordinate(1,3)));
		assertEquals(OK,game.makeMove(makeCoordinate(1,1),makeCoordinate(2,1)));
		assertEquals(null,game.getMoveMessage());
		assertEquals(ILLEGAL,game.makeMove(c45, c44));
		assertTrue(game.getMoveMessage().length()>=5);
	}
	
	@Test //52
	public void testRedWins(){
		assertEquals(OK,game.makeMove(c11, c21));//red
		assertEquals(OK,game.makeMove(c11, c21));
		assertEquals(OK,game.makeMove(c21, c24));//red
		assertEquals(OK,game.makeMove(c21, c11));
		assertEquals(OK,game.makeMove(c24, c104));//red
		assertEquals(ILLEGAL,game.makeMove(c11, c21));
		assertEquals(OK,game.makeMove(c15, c25));
		assertEquals(OK,game.makeMove(c19, c29));//red
		assertEquals(OK,game.makeMove(c45, c55));
		assertEquals(OK,game.makeMove(c29, c26));//red
		assertEquals(OK,game.makeMove(c55, c65));
		assertEquals(OK,game.makeMove(c26, c106));//red
		assertEquals(OK,game.makeMove(c41, c51));
		assertEquals(OK,game.makeMove(c45, c55));//red
		assertEquals(OK,game.makeMove(c17, c39));
		assertEquals(OK,game.makeMove(c55, c65));//red
		assertEquals(OK,game.makeMove(c49, c59));
		assertEquals(OK,game.makeMove(c65, c75));//red
		assertEquals(OK,game.makeMove(c13, c31));
		assertEquals(RED_WINS,game.makeMove(c75, c85));//red
		assertEquals(redSoldier,game.getPieceAt(c85, RED));
		assertEquals(blackGeneral,game.getPieceAt(c95, RED));
		assertEquals(redChariot,game.getPieceAt(c104, RED));
		assertEquals(redChariot,game.getPieceAt(c14, BLACK));
		assertEquals(noPiece,game.getPieceAt(c15, BLACK));
		assertEquals(noPiece,game.getPieceAt(c24, BLACK));
		assertEquals(noPiece,game.getPieceAt(c26, BLACK));
		assertEquals(noPiece,game.getPieceAt(c34, BLACK));
		assertEquals(noPiece,game.getPieceAt(c36, BLACK));
	}
	
	@Test //53
	public void testBlackWin(){
		assertEquals(OK,game.makeMove(c45, c55));
		assertEquals(OK,game.makeMove(c11, c21));//black
		assertEquals(OK,game.makeMove(c41, c51));
		assertEquals(OK,game.makeMove(c21, c24));//black
		assertEquals(OK,game.makeMove(c55, c65));
		assertEquals(OK,game.makeMove(c24, c104));//black
		assertEquals(OK,game.makeMove(c15, c25));
		assertEquals(OK,game.makeMove(c104, c103));//black
		assertEquals(OK,game.makeMove(c51, c61));
		assertEquals(OK,game.makeMove(c103, c106));//black
		assertEquals(OK,game.makeMove(c61, c71));
		assertEquals(OK,game.makeMove(c19, c49));//black
		assertEquals(OK,game.makeMove(c25, c35));
		assertEquals(OK,game.makeMove(c14, c25));//black
		assertEquals(OK,game.makeMove(c47, c57));
		assertEquals(OK,game.makeMove(c15, c14));//black
		assertEquals(OK,game.makeMove(c49, c59));
		assertEquals(OK,game.makeMove(c49, c69));//black
		assertEquals(OK,game.makeMove(c57, c67));
		assertEquals(BLACK_WINS,game.makeMove(c69, c65));//black
	}
	
	//Above are the test cases that I borrowed from Gamma(some are adjusted a little)
	//Below are the test cases that I added for Delta
	
	//54
	@Test
	public void testHorsesAreOnTheBoard(){
		assertEquals(redHorse,game.getPieceAt(c12, RED));
		assertEquals(redHorse,game.getPieceAt(c18, RED));
		assertEquals(blackHorse,game.getPieceAt(c102, RED));
		assertEquals(blackHorse,game.getPieceAt(c108, RED));
		assertEquals(blackHorse,game.getPieceAt(c12, BLACK));
		assertEquals(blackHorse,game.getPieceAt(c18, BLACK));
		assertEquals(redHorse,game.getPieceAt(c102, BLACK));
		assertEquals(redHorse,game.getPieceAt(c108, BLACK));
	}
	
	//55
	@Test
	public void testCannonsAreOnTheBoard(){
		assertEquals(redCannon,game.getPieceAt(c32, RED));
		assertEquals(redCannon,game.getPieceAt(c38, RED));
		assertEquals(blackCannon,game.getPieceAt(c82, RED));
		assertEquals(blackCannon,game.getPieceAt(c88, RED));
		assertEquals(blackCannon,game.getPieceAt(c32, BLACK));
		assertEquals(blackCannon,game.getPieceAt(c38, BLACK));
		assertEquals(redCannon,game.getPieceAt(c82, BLACK));
		assertEquals(redCannon,game.getPieceAt(c88, BLACK));
		
	}
	
	//56
	@Test
	public void testCannonCanNotEatSameColor(){
		assertEquals(OK,game.makeMove(c32, c42));
		assertEquals(OK,game.makeMove(c32, c33));
		assertEquals(ILLEGAL,game.makeMove(c42, c48));
	}
	
	//57
	public void testCannonCanNotMoveDiagonally(){
		assertEquals(ILLEGAL,game.makeMove(c32,c21));
	}
	
	//58
	@Test
	public void testCannonCanMoveOrthogonally(){
		assertEquals(OK,game.makeMove(c32, c42));
		assertEquals(OK,game.makeMove(c32, c37));
	}
	
	//59
	@Test
	public void testCannonCanJumpOverOnePieceToAttak(){
		assertEquals(OK,game.makeMove(c32, c102));
		assertEquals(OK,game.makeMove(c32, c102));
	}
	
	//60
	@Test
	public void testCannonCanNotJumperOverMoreThanOnePieceToAttack(){
		assertEquals(OK,game.makeMove(c32, c72));
		assertEquals(OK,game.makeMove(c32, c102));
		assertEquals(ILLEGAL,game.makeMove(c72, c77));
		assertEquals(ILLEGAL,game.makeMove(c72, c79));
	}
	
	//61
	@Test
	public void testCannonCanNotJumpWhenOnlyMoving(){
		assertEquals(OK,game.makeMove(c32, c72));
		assertEquals(OK,game.makeMove(c32, c102));
		assertEquals(ILLEGAL,game.makeMove(c72, c74));
		assertEquals(ILLEGAL,game.makeMove(c72, c76));
		assertEquals(ILLEGAL,game.makeMove(c72, c78));
	}
	
	//62
	@Test
	public void testCannonCanNotAttackIfNotJumping(){
		assertEquals(OK,game.makeMove(c32, c72));
		assertEquals(OK,game.makeMove(c32, c72));
		assertEquals(ILLEGAL,game.makeMove(c72, c73));
		assertEquals(ILLEGAL,game.makeMove(c72, c71));
	}
	
	//63
	@Test
	public void testHorseCannotMoveOrthogonally(){
		assertEquals(OK,game.makeMove(c32, c52));
		assertEquals(OK,game.makeMove(c38, c58));
		assertEquals(ILLEGAL,game.makeMove(c12, c42));
		assertEquals(ILLEGAL,game.makeMove(c18, c48));
	}
	
	//64
	@Test
	public void testHorseCannotMoveDiagonally(){
		assertEquals(ILLEGAL,game.makeMove(c12, c34));
		assertEquals(ILLEGAL,game.makeMove(c18, c36));
	}
	
	//65
	@Test
	public void testHorseCanMoveOneOrthogonalOneDiagonal(){
		assertEquals(OK,game.makeMove(c12, c33));
		assertEquals(OK,game.makeMove(c18, c39));
		assertEquals(OK,game.makeMove(c33, c25));
	}
	
	//66
	@Test
	public void testHorseCannotJumpOverPieces(){
		assertEquals(ILLEGAL,game.makeMove(c12, c24));
		assertEquals(OK,game.makeMove(c12, c31));
		assertEquals(ILLEGAL,game.makeMove(c18, c26));
		assertEquals(OK,game.makeMove(c12, c31));
		assertEquals(ILLEGAL,game.makeMove(c31, c52));
	}
	
	//67
	@Test
	public void testHorseCanCaptureEnemy(){
		assertEquals(OK,game.makeMove(c12, c33));
		assertEquals(OK,game.makeMove(c45, c55));
		assertEquals(OK,game.makeMove(c33, c25));
		assertEquals(OK,game.makeMove(c55, c65));
		assertEquals(OK,game.makeMove(c25, c37));
		assertEquals(OK,game.makeMove(c65, c75));
		assertEquals(OK,game.makeMove(c37, c45));
		assertEquals(OK,game.makeMove(c43, c53));
		assertEquals(OK,game.makeMove(c32, c35));
		assertEquals(ILLEGAL,game.makeMove(c41, c51));
		assertEquals(OK,game.makeMove(c14, c25));
		assertEquals(OK,game.makeMove(c45, c64));
		assertEquals(ILLEGAL,game.makeMove(c51, c61));
		assertEquals(OK,game.makeMove(c25, c14));
		assertEquals(OK,game.makeMove(c64, c83));
		assertEquals(OK,game.makeMove(c18, c37));
	}
	
	//68
	@Test
	public void testRepetitionCheckingBlackWin1(){
		assertEquals(OK,game.makeMove(c11, c21));
		assertEquals(OK,game.makeMove(c11, c21));
		assertEquals(OK,game.makeMove(c21, c11));
		assertEquals(OK,game.makeMove(c21, c11));
		assertEquals(OK,game.makeMove(c11, c21));
		assertEquals(OK,game.makeMove(c11, c21));
		assertEquals(OK,game.makeMove(c21, c11));
		assertEquals(OK,game.makeMove(c21, c11));
		assertEquals(BLACK_WINS,game.makeMove(c11, c21));
	}
	
	//68
	@Test
	public void testRepetitionCheckingRedWin1(){
		assertEquals(OK,game.makeMove(c45, c55));
		assertEquals(OK,game.makeMove(c45, c55));
		assertEquals(OK,game.makeMove(c11, c21));
		assertEquals(OK,game.makeMove(c11, c21));
		assertEquals(OK,game.makeMove(c21, c11));
		assertEquals(OK,game.makeMove(c21, c11));
		assertEquals(OK,game.makeMove(c11, c21));
		assertEquals(OK,game.makeMove(c11, c21));
		assertEquals(OK,game.makeMove(c21, c11));
		assertEquals(RED_WINS,game.makeMove(c21, c11));
	}
	
	//70
	@Test
	public void testRepetitionCheckingBlackWins2(){
		assertEquals(OK,game.makeMove(c45, c55));
		assertEquals(OK,game.makeMove(c11, c21));
		assertEquals(OK,game.makeMove(c11, c21));
		assertEquals(OK,game.makeMove(c21, c11));
		assertEquals(OK,game.makeMove(c21, c11));
		assertEquals(OK,game.makeMove(c11, c21));
		assertEquals(OK,game.makeMove(c11, c21));
		assertEquals(OK,game.makeMove(c21, c11));
		assertEquals(BLACK_WINS,game.makeMove(c21, c11));
	}
}