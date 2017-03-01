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
 * The XiangqiCoordinate interface describes the coordinates that are used to identify
 * locations on the Xiàngqí board. These coordinates are two or three-digit numbers as
 * described in the Xiàngqí: Chinese Chess Developers' Guide.
 * 
 * Note that the rank and file of a coordinate is from a specific player's point of view.
 * There is nothing in this interface that indicates which player corresponds to the
 * coordinate. It is up to the game implementation to determine this as necessary. For
 * example when the <code>onMove()</code> method of the XiangqiGame is called, the game
 * implementation will probably want to convert the coordinate to one that is used
 * internally in the game engine.
 * @version Dec 26, 2016
 */
public interface XiangqiCoordinate
{
	/**
	 * The rank is the horizontal row number. It is an integer in the inclusive range of 1-10. 
	 * The rank is always from the specific player's point of view. So Red's rank 1 is 
	 * Black's rank 10.
	 * @return the rank of the location on the board
	 */
	int getRank();
	
	/**
	 * The file is the vertical column number. It is an integer in the inclusive range of 1-9.
	 * The file is always from the specific player's point of view. So Red's left Cannon is on 
	 * Red's rank 2 and Black's rank 8.
	 * @return the file of the coordinate on the board
	 */
	int getFile();
}
