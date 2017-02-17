/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design.
 * The course was taken at Worcester Polytechnic Institute.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Copyright ©2016-2017 Gary F. Pollice
 *******************************************************************************/

package grading;

import static xiangqi.common.XiangqiColor.*;
import static xiangqi.common.XiangqiPieceType.*;
import static org.junit.Assert.*;
import static xiangqi.common.MoveResult.*;
import org.junit.*;
import xiangqi.XiangqiGameFactory;
import xiangqi.common.*;

/**
 * Self-contained master tests
 * @version Feb 14, 2017
 */
public class BetaMasterGradingTests
{
	//
	// Test case code begins here
	//
	private XiangqiGame game;
	
	private static XiangqiCoordinate c11 = makeCoordinate(1, 1),
			c12 = makeCoordinate(1, 2), c13 = makeCoordinate(1, 3),
			c14 = makeCoordinate(1, 4), c15 = makeCoordinate(1, 5),
			c21 = makeCoordinate(2, 1), c22 = makeCoordinate(2, 2),
			c23 = makeCoordinate(2, 3), c24 = makeCoordinate(2, 4),
			c25 = makeCoordinate(2, 5), c31 = makeCoordinate(3, 1),
			c32 = makeCoordinate(3, 2), c33 = makeCoordinate(3, 3),
			c34 = makeCoordinate(3, 4), c35 = makeCoordinate(3, 5),
			c41 = makeCoordinate(4, 1), c42 = makeCoordinate(4, 2),
			c43 = makeCoordinate(4, 3), c44 = makeCoordinate(4, 4),
			c45 = makeCoordinate(4, 5), c51 = makeCoordinate(5, 1),
			c52 = makeCoordinate(5, 2), c53 = makeCoordinate(5, 3),
			c54 = makeCoordinate(5, 4), c55 = makeCoordinate(5, 5);

	private static XiangqiPiece noPiece = 
			makePiece(XiangqiPieceType.NONE, XiangqiColor.NONE), 
			redChariot = makePiece(CHARIOT, RED),
			redAdvisor = makePiece(ADVISOR, RED),
			redGeneral = makePiece(GENERAL, RED),
			redSoldier = makePiece(SOLDIER, RED),
			blackChariot = makePiece(CHARIOT, BLACK),
			blackAdvisor = makePiece(ADVISOR, BLACK),
			blackGeneral = makePiece(GENERAL, BLACK),
			blackSoldier = makePiece(SOLDIER, BLACK);
	
	@Before
	public void setup()
	{
		game = XiangqiGameFactory.makeXiangqiGame(XiangqiGameVersion.BETA_XQ);
	}
	
	@Test
	public void correctInitialPositions()
	{
		assertEquals(redGeneral, game.getPieceAt(c13, RED));
		assertEquals(redChariot, game.getPieceAt(c11, RED));
		assertEquals(redChariot, game.getPieceAt(c15, RED));
		assertEquals(redAdvisor, game.getPieceAt(c12, RED));
		assertEquals(redAdvisor, game.getPieceAt(c14, RED));
		assertEquals(redSoldier, game.getPieceAt(c23, RED));
		assertEquals(blackGeneral, game.getPieceAt(c13, BLACK));
		assertEquals(blackChariot, game.getPieceAt(c11, BLACK));
		assertEquals(blackChariot, game.getPieceAt(c15, BLACK));
		assertEquals(blackAdvisor, game.getPieceAt(c12, BLACK));
		assertEquals(blackAdvisor, game.getPieceAt(c14, BLACK));
		assertEquals(blackSoldier, game.getPieceAt(c23, BLACK));
	}

	@Test
	public void queryAnEmptyLocation()
	{
		assertEquals(noPiece, game.getPieceAt(c22, BLACK));
	}
	
	@Test
	public void makeMoveWithInvalidCoordinates()
	{
		assertEquals(ILLEGAL, game.makeMove(makeCoordinate(0, 3), c14));
		assertEquals(ILLEGAL, game.makeMove(c11, makeCoordinate(1, 6)));
	}
	
	@Test
	public void makeValidChariotMove()
	{
		assertEquals(OK, game.makeMove(c11, c21));
		assertEquals(redChariot, game.getPieceAt(c21, RED));
		assertEquals(noPiece, game.getPieceAt(c11, RED));
	}
	
	@Test
	public void attemptToMoveOpponentPiece()
	{
		assertEquals(ILLEGAL, game.makeMove(c51, c41));
	}
	
	@Test
	public void attemptToCaptureOwnPiece()
	{
		assertEquals(ILLEGAL, game.makeMove(c11, c12));
	}
	
	@Test
	public void ensureMessageOnIllegalMove()
	{
		game.makeMove(c11, c12);
		assertTrue(game.getMoveMessage().length() > 5);		// Minimum of 6 characters seems reasonable
	}
	
	@Test
	public void tryToMoveChariotDiagonally()
	{
		assertEquals(ILLEGAL, game.makeMove(c15, c24));
	}
	
	@Test
	public void makeValidMoveForEachPlayer()
	{
		game.makeMove(c11, c31);
		assertEquals(redChariot, game.getPieceAt(c31, RED));
		assertEquals(OK, game.makeMove(c15, c25));
		assertEquals(blackChariot, game.getPieceAt(c25, BLACK));
	}
	
	@Test
	public void validAdvisorMove()
	{
		assertEquals(OK, game.makeMove(c12, c21));
		assertEquals(redAdvisor, game.getPieceAt(c21, RED));
	}
	
	@Test
	public void invalidAdvisorMove()
	{
		assertEquals(ILLEGAL, game.makeMove(c12, c22));
	}
	
	@Test
	public void validSoldierMove()
	{
		assertEquals(OK, game.makeMove(c23, c33));
		assertEquals(redSoldier, game.getPieceAt(c33, RED));
	}
	
	@Test
	public void invalidSoldierMove()
	{
		assertEquals(ILLEGAL, game.makeMove(c23, c22));
	}
	
	@Test
	public void soldierCapturesSoldier()
	{
		game.makeMove(c23, c33);
		assertEquals(OK, game.makeMove(c23,  c33));
		assertEquals(blackSoldier, game.getPieceAt(c33, BLACK));
	}
	
	@Test
	public void validGeneralMove()
	{
		game.makeMove(c12, c21);
		game.makeMove(c11, c21);
		assertEquals(OK, game.makeMove(c13, c12));
		assertEquals(redGeneral, game.getPieceAt(c12, RED));
	}
	
	@Test
	public void invalidGeneralMove()
	{
		assertEquals(ILLEGAL, game.makeMove(c13, c22));
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
}

class TestCoordinate implements XiangqiCoordinate
{
	private final int rank;
	private final int file;
	
	public TestCoordinate(int rank, int file)
	{
		this.rank = rank;
		this.file = file;
	}
	
	@Override
	public int getRank()
	{
		return rank;
	}

	@Override
	public int getFile()
	{
		return file;
	}
}

class TestPiece implements XiangqiPiece
{
	private final XiangqiColor color;
	private final XiangqiPieceType pieceType;
	
	public TestPiece(XiangqiPieceType pieceType, XiangqiColor color)
	{
		this.pieceType = pieceType;
		this.color = color;
	}
	
	/*
	 * @see xiangqi.common.XiangqiPiece#getColor()
	 */
	@Override
	public XiangqiColor getColor()
	{
		return color;
	}

	/*
	 * @see xiangqi.common.XiangqiPiece#getPieceType()
	 */
	@Override
	public XiangqiPieceType getPieceType()
	{
		return pieceType;
	}

	@Override
	public boolean equals(Object obj)
	{
		XiangqiPiece other = (XiangqiPiece) obj;
		if (color != other.getColor())
			return false;
		if (pieceType != other.getPieceType())
			return false;
		return true;
	}
}
