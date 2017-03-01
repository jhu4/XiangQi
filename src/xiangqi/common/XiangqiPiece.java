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
 * An interface used for a simple data structure (probably) that identifies a piece. It is
 * usually used when querying the XiangqiGame for the piece that is on the board.
 * @version Dec 26, 2016
 */
public interface XiangqiPiece
{
	/**
	 * @return the color of the piece
	 */
	XiangqiColor getColor ();
	
	/**
	 * @return the piece type
	 */
	XiangqiPieceType getPieceType();
}
