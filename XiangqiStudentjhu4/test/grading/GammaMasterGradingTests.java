/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design.
 * The course was taken at Worcester Polytechnic Institute.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Copyright 漏2016-2017 Gary F. Pollice
 *******************************************************************************/

package grading;

import static org.junit.Assert.*;
import static xiangqi.common.MoveResult.*;
import static xiangqi.common.XiangqiColor.*;
import static xiangqi.common.XiangqiPieceType.*;
import java.util.concurrent.CompletionException;
import org.junit.*;
import xiangqi.XiangqiGameFactory;
import xiangqi.common.*;

/**
 * Master test cases for Gama Xiangqi.
 * @version Feb 22, 2017
 */
public class GammaMasterGradingTests
{
	//
	// Test case code begins here
	//
	private XiangqiGame game;
	
	private static XiangqiCoordinate c11 = makeCoordinate(1, 1),
			c12 = makeCoordinate(1, 2), c13 = makeCoordinate(1, 3),
			c14 = makeCoordinate(1, 4), c15 = makeCoordinate(1, 5),
			c16 = makeCoordinate(1, 6), c17 = makeCoordinate(1, 7),
			c18 = makeCoordinate(1, 8), c19 = makeCoordinate(1, 9),
			c21 = makeCoordinate(2, 1), c22 = makeCoordinate(2, 2),
			c23 = makeCoordinate(2, 3), c24 = makeCoordinate(2, 4),
			c25 = makeCoordinate(2, 5), c26 = makeCoordinate(2, 6),
			c27 = makeCoordinate(2, 7), c28 = makeCoordinate(2, 8),
			c29 = makeCoordinate(2, 9), c31 = makeCoordinate(3, 1),
			c32 = makeCoordinate(3, 2), c33 = makeCoordinate(3, 3),
			c34 = makeCoordinate(3, 4), c35 = makeCoordinate(3, 5),
			c36 = makeCoordinate(3, 6), c37 = makeCoordinate(3, 7),
			c38 = makeCoordinate(3, 8), c39 = makeCoordinate(3, 9),
			c41 = makeCoordinate(4, 1), c42 = makeCoordinate(4, 2),
			c43 = makeCoordinate(4, 3), c44 = makeCoordinate(4, 4),
			c45 = makeCoordinate(4, 5), c46 = makeCoordinate(4, 6),
			c47 = makeCoordinate(4, 7), c48 = makeCoordinate(4, 8),
			c49 = makeCoordinate(4, 9), c51 = makeCoordinate(5, 1),
			c52 = makeCoordinate(5, 2), c53 = makeCoordinate(5, 3),
			c54 = makeCoordinate(5, 4), c55 = makeCoordinate(5, 5),
			c56 = makeCoordinate(5, 6), c57 = makeCoordinate(5, 7),
			c58 = makeCoordinate(5, 8), c59 = makeCoordinate(5, 9),
			c61 = makeCoordinate(6, 1), c62 = makeCoordinate(6, 2),
			c63 = makeCoordinate(6, 3), c64 = makeCoordinate(6, 4),
			c65 = makeCoordinate(6, 5), c66 = makeCoordinate(6, 6),
			c67 = makeCoordinate(6, 7), c68 = makeCoordinate(6, 8),
			c69 = makeCoordinate(6, 9), c71 = makeCoordinate(7, 1),
			c72 = makeCoordinate(7, 2), c73 = makeCoordinate(7, 3),
			c74 = makeCoordinate(7, 4), c75 = makeCoordinate(7, 5),
			c76 = makeCoordinate(7, 6), c77 = makeCoordinate(7, 7),
			c78 = makeCoordinate(7, 8), c79 = makeCoordinate(7, 9),
			c81 = makeCoordinate(8, 1), c82 = makeCoordinate(8, 2),
			c83 = makeCoordinate(8, 3), c84 = makeCoordinate(8, 4),
			c85 = makeCoordinate(8, 5), c86 = makeCoordinate(8, 6),
			c87 = makeCoordinate(8, 7), c88 = makeCoordinate(8, 8),
			c89 = makeCoordinate(8, 9), c91 = makeCoordinate(9, 1),
			c92 = makeCoordinate(9, 2), c93 = makeCoordinate(9, 3),
			c94 = makeCoordinate(9, 4), c95 = makeCoordinate(9, 5),
			c96 = makeCoordinate(9, 6), c97 = makeCoordinate(9, 7),
			c98 = makeCoordinate(9, 8), c99 = makeCoordinate(9, 9),
			c101 = makeCoordinate(10, 1), c102 = makeCoordinate(10, 2),
			c103 = makeCoordinate(10, 3), c104 = makeCoordinate(10, 4),
			c105 = makeCoordinate(10, 5), c106 = makeCoordinate(10, 6),
			c107 = makeCoordinate(10, 7), c108 = makeCoordinate(10, 8),
			c109 = makeCoordinate(10, 9);
	
	private static XiangqiPiece noPiece = 
			makePiece(XiangqiPieceType.NONE, XiangqiColor.NONE), 
			redChariot = makePiece(CHARIOT, RED),
			redElephant = makePiece(ELEPHANT, RED),
			redAdvisor = makePiece(ADVISOR, RED),
			redGeneral = makePiece(GENERAL, RED),
			redSoldier = makePiece(SOLDIER, RED),
			blackChariot = makePiece(CHARIOT, BLACK),
			blackElephant = makePiece(ELEPHANT, BLACK),
			blackAdvisor = makePiece(ADVISOR, BLACK),
			blackGeneral = makePiece(GENERAL, BLACK),
			blackSoldier = makePiece(SOLDIER, BLACK);
	
	@Before
	public void setup()
	{
		game = XiangqiGameFactory.makeXiangqiGame(XiangqiGameVersion.GAMMA_XQ);
	}
	
	@Test
	public void correctInitialPositions()
	{
		assertEquals(redGeneral, game.getPieceAt(c15, RED));
		assertEquals(redChariot, game.getPieceAt(c11, RED));
		assertEquals(redChariot, game.getPieceAt(c19, RED));
		assertEquals(redElephant, game.getPieceAt(c13, RED));
		assertEquals(redElephant, game.getPieceAt(c17, RED));
		assertEquals(redAdvisor, game.getPieceAt(c14, RED));
		assertEquals(redAdvisor, game.getPieceAt(c16, RED));
		assertEquals(redSoldier, game.getPieceAt(c41, RED));
		assertEquals(redSoldier, game.getPieceAt(c43, RED));
		assertEquals(redSoldier, game.getPieceAt(c45, RED));
		assertEquals(redSoldier, game.getPieceAt(c47, RED));
		assertEquals(redSoldier, game.getPieceAt(c49, RED));
		assertEquals(blackGeneral, game.getPieceAt(c15, BLACK));
		assertEquals(blackChariot, game.getPieceAt(c11, BLACK));
		assertEquals(blackChariot, game.getPieceAt(c19, BLACK));
		assertEquals(blackElephant, game.getPieceAt(c13, BLACK));
		assertEquals(blackElephant, game.getPieceAt(c17, BLACK));
		assertEquals(blackAdvisor, game.getPieceAt(c14, BLACK));
		assertEquals(blackAdvisor, game.getPieceAt(c16, BLACK));
		assertEquals(blackSoldier, game.getPieceAt(c41, BLACK));
		assertEquals(blackSoldier, game.getPieceAt(c43, BLACK));
		assertEquals(blackSoldier, game.getPieceAt(c45, BLACK));
		assertEquals(blackSoldier, game.getPieceAt(c47, BLACK));
		assertEquals(blackSoldier, game.getPieceAt(c49, BLACK));
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
		assertEquals(ILLEGAL, game.makeMove(c11, makeCoordinate(1, 11)));
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
		assertEquals(ILLEGAL, game.makeMove(c109, c99));
	}
	
	@Test
	public void attemptToCaptureOwnPiece()
	{
		assertEquals(ILLEGAL, game.makeMove(c11, c13));
	}
	
	@Test
	public void ensureMessageOnIllegalMove()
	{
		game.makeMove(c11, c13);
		assertTrue(game.getMoveMessage().length() > 5);		// Minimum of 6 characters seems reasonable
	}
	
	@Test
	public void tryToMoveChariotDiagonally()
	{
		assertEquals(ILLEGAL, game.makeMove(c19, c28));
	}
	
	@Test
	public void makeValidMoveForEachPlayer()
	{
		game.makeMove(c11, c31);
		assertEquals(redChariot, game.getPieceAt(c31, RED));
		assertEquals(OK, game.makeMove(c19, c39));
		assertEquals(blackChariot, game.getPieceAt(c39, BLACK));
	}
	
	@Test
	public void validAdvisorMove()
	{
		assertEquals(OK, game.makeMove(c14, c25));
		assertEquals(redAdvisor, game.getPieceAt(c25, RED));
	}
	
	@Test
	public void invalidAdvisorMove()
	{
		game.makeMove(c14, c25);	// valid
		assertEquals(ILLEGAL, game.makeMove(c16, c26));
	}
	
	@Test
	public void validSoldierMove()
	{
		assertEquals(OK, game.makeMove(c43, c53));
		assertEquals(redSoldier, game.getPieceAt(c53, RED));
	}
	
	@Test
	public void invalidSoldierMoveBackwards()
	{
		assertEquals(ILLEGAL, game.makeMove(c43, c33));
	}
	
	@Test
	public void invalidSoldierMoveSideways()
	{
		assertEquals(ILLEGAL, game.makeMove(c45, c44));
	}
	
	@Test
	public void soldierMovesSidewaysAfterCrossingTheRiver()
	{
		makeValidMoves(c41, c51, c11, c21, c51, c61, c21, c11, c61, c62);
	}
	
	@Test
	public void soldierCapturesSoldier()
	{
		makeValidMoves(c45, c55, c45, c55, c55, c65); 
		assertEquals(redSoldier, game.getPieceAt(c65, RED));
	}
	
	@Test
	public void validGeneralMove()
	{
		
		assertEquals(OK, game.makeMove(c15, c25));
		assertEquals(redGeneral, game.getPieceAt(c25, RED));
	}
	
	@Test
	public void invalidGeneralMove()
	{
		assertEquals(ILLEGAL, game.makeMove(c15, c24));
	}
	
	@Test
	public void validElephantMove()
	{
		makeValidMoves(c17, c35);
		assertEquals(redElephant, game.getPieceAt(c35, RED));
	}
	
	@Test
	public void invalidElephantMove()
	{
		assertEquals(ILLEGAL, game.makeMove(c17, c37));
	}
	
	@Test
	public void elephantAttemptsToCrossTheRiver()
	{
		makeValidMoves(c13, c35, c11, c21, c35, c53, c45, c55);
		assertEquals(ILLEGAL, game.makeMove(c53, c75));
	}
	
	@Test
	public void generalAttemptsToMoveOutOfThePalace()
	{
		makeValidMoves(c15, c25, c11, c21, c25, c26, c21, c11);
		assertEquals(ILLEGAL, game.makeMove(c26, c27));
	}
	
	@Test
	public void advisorAttemptsToMoveOutOfThePalace()
	{
		makeValidMoves(c14, c25, c11, c21, c25, c36, c21, c11);
		assertEquals(ILLEGAL, game.makeMove(c36, c27));
	}
	
	@Test(expected=CompletionException.class)
	public void invalidCoordinateToGetPieceAt()
	{
		game.getPieceAt(makeCoordinate(-5,  -3), RED);
	}
	
	@Test
	public void completeGame()
	{
		makeValidMoves(c11, c21, c19, c29,
				c21, c24, c29, c19,
				c24, c94, c19, c29,
				c94, c93, c29, c19,
				c19, c29, c13, c31,
				c29, c24, c17, c39,
				c93, c103, c39, c57,
				c24, c94, c19, c29);
		assertEquals(RED_WINS, game.makeMove(c103, c104));
	}
	
	@Test
	public void drawOnTime()
	{
		makeValidMoves(c11, c21, c11, c21,
				c21, c11, c21, c11,
				c11, c21, c11, c21,
				c21, c11, c21, c11,
				c11, c21, c11, c21,
				c21, c11, c21, c11,
				c11, c21, c11, c21,
				c21, c11, c21, c11,
				c11, c21, c11, c21,
				c21, c11, c21, c11,
				c11, c21, c11, c21,
				c21, c11, c21, c11,
				c11, c21, c11, c21,
				c21, c11, c21, c11,
				c11, c21, c11, c21,
				c21, c11, c21, c11,
				c11, c21, c11, c21,
				c21, c11, c21, c11,
				c11, c21, c11, c21,
				c21, c11, c21, c11,
				c11, c21, c11, c21,
				c21, c11, c21, c11,
				c11, c21, c11, c21,
				c21, c11, c21, c11,
				c11, c21);
		assertEquals(DRAW, game.makeMove(c11, c21));
	}
	
	// Helper methods
	private static XiangqiCoordinate makeCoordinate(int rank, int file)
	{
		return new GammaTestCoordinate(rank, file);
	}

	public static XiangqiPiece makePiece(XiangqiPieceType pieceType, XiangqiColor color)
	{
		return new GammaTestPiece(pieceType, color);
	}
	
	private void makeValidMoves(XiangqiCoordinate ... c)
	{
		int i = 1;
		while (i < c.length) {
			MoveResult mr = game.makeMove(c[i-1], c[i]);
			if (mr == ILLEGAL) {
				System.out.println(c[i-1] + "-" + c[i] + ": " +game.getMoveMessage());
			}
			assertEquals(OK, mr);
			i += 2;
		}
	}
	
	private void printPieceAt(XiangqiCoordinate c, XiangqiColor a)
	{
		XiangqiPiece p = game.getPieceAt(c, a);
		System.out.println(p.getColor() + " " + p.getPieceType());
	}
}

class GammaTestCoordinate implements XiangqiCoordinate
{
	private final int rank;
	private final int file;
	
	public GammaTestCoordinate(int rank, int file)
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
	public String toString() {
		return "(" + rank + ", " + file + ")";
	}

	@Override
	public int getFile()
	{
		return file;
	}
}

class GammaTestPiece implements XiangqiPiece
{
	private final XiangqiColor color;
	private final XiangqiPieceType pieceType;
	
	public GammaTestPiece(XiangqiPieceType pieceType, XiangqiColor color)
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
	public String toString()
	{
		return color + " " + pieceType;
	}

	@Override
	public boolean equals(Object obj)
	{
		XiangqiPiece other = (XiangqiPiece) obj;
		if (color != other.getColor()) {
			System.out.println(color + " 鈮� " + other.getColor());
			return false;
		}
		if (pieceType != other.getPieceType()) {
			System.out.println(pieceType + " 鈮� " + other.getPieceType());
			return false;
		}
		return true;
	}
}
