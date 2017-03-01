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
 * Description
 * @version Dec 26, 2016
 */
public enum XiangqiPieceType
{
	GENERAL("General", "G"),
	ADVISOR("Advisor", "A"),
	ELEPHANT("Elephant", "E"),
	HORSE("Horse", "H"),
	CHARIOT("Chariot", "R"),
	CANNON("Cannon", "C"),
	SOLDIER("Soldier", "S"),
	NONE("", "."),
	;
	
	private final String printableName;
	private final String symbol;
	
	/**
	 * The constructor for each enumerable item sets up the state so that
	 * the symbol for each item and the printable name are set up.
	 * 
	 * @param printableName the value returned from toString
	 * @param symbol a one character string that can be used when displaying or
	 * 	printing the board.
	 */
	private XiangqiPieceType(String printableName, String symbol)
	{
		this.printableName = printableName;
		this.symbol = symbol;
	}

	/**
	 * @return the printableName
	 */
	public String getPrintableName()
	{
		return printableName;
	}

	/**
	 * @return the symbol
	 */
	public String getSymbol()
	{
		return symbol;
	}
	
	@Override
	public String toString()
	{
		return printableName;
	}
}
