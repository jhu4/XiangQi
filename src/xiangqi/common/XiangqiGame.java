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

package xiangqi.common;

/**
 * The XiangqiGame interface is the primary interface between the student's code and any
 * external (non-student written) code. Every version of Xiàngqí must realize the
 * XiangqiGame interface.
 * @version Dec 26, 2016
 */
public interface XiangqiGame
{
	/**
	 * <p>
	 * Make a move in the game. The XiangqiGame instance needs to keep track of the
	 * player on move.
	 * </p><p>
	 * NOTE: If the attempted move is illegal, this method returns a 
	 * MoveResult.ILLEGAL and ignores the move. It is up to the client to decide what
	 * to do.
	 * </p>
	 * 
	 * @param source the coordinate where the piece moving starts
	 * @param destination the coordinate where the piece moving ends
	 * @return the move result
	 */
	MoveResult makeMove(XiangqiCoordinate source, XiangqiCoordinate destination);
	
	/**
	 * This method is called to obtain additional information about a move that has just been
	 * attempted or made. It must return a message about illegal moves when a client attempts to make
	 * such a move.
	 * If a valid move is made, the implementation is free to return either an empty string or some
	 * other string that describes the board situation.
	 * @return
	 */
	String getMoveMessage();
	
	/**
	 * Method used for querying the board.
	 * @param where the coordinate to access
	 * @param aspect the player from whom the request is made. This is needed
	 *   in order to determine which location the <code>where</code> parameter
	 *   references
	 * @return the piece at the specified coordinate. If the coordinate is empty,
	 *   this returns a piece with the type of XiangqiPieceType.NONE, and a color of 
	 *   XiangqiColor.NONE.
	 */
	XiangqiPiece getPieceAt(XiangqiCoordinate where, XiangqiColor aspect);
	
	/**
	 * In some games, it may be possible to performe some initialization before the
	 * game begins. The default method does nothing. This can be overridden by the
	 * instances that require initialization.
	 * @param args an array of objects that are needed for initialization
	 */
	default void initialize(Object... args) { }
}
