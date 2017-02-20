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

package demo;

/**
 * Coordinate implementation for a chessboard
 * @version Jan 9, 2017
 */
public class Coordinate
{
	private final int x, y;
	
	/**
	 * Private default constructor
	 * @param x the x-coordinate
	 * @param y the y-coordinate
	 */
	private Coordinate(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Creation method for Coordinates
	 * @param x the x-coordinate
	 * @param y the y-coordinate
	 * @return the Coordinate instance
	 */
	public static Coordinate makeCoordinate(int x, int y)
	{
		return new Coordinate(x, y);
	}
	
	/**
	 * The distance to another coordinate is the sum of the differences between
	 * the two Coordinates' x and y coordinates.
	 * @param c another Coordinate
	 * @return return the distance to the other coordinate
	 */
	public int distanceTo(Coordinate c)
	{
		return Math.abs(c.x - x) + Math.abs(c.y - y);
	}
	
	/**
	 * @param c another Coordinate
	 * @return true if another Coordinate is on the same row or column as this Coordinate.
	 */
	public boolean isOrthogonal(Coordinate c)
	{
		return c.x == x || c.y == y; 
	}
	
	/**
	 * @param c another Coordinate
	 * @return true if the another coordinate is on a diagonal from this Coordinate
	 */
	public boolean isDiagonal(Coordinate c)
	{
		return Math.abs(c.x - x) == Math.abs(c.y - y);
	}

	/**
	 * @return the x-coordinate
	 */
	public int getX()
	{
		return x;
	}

	/**
	 * @return the y-coordinate
	 */
	public int getY()
	{
		return y;
	}

	/*
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	/*
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Coordinate)) {
			return false;
		}
		Coordinate other = (Coordinate) obj;
		if (x != other.x) {
			return false;
		}
		if (y != other.y) {
			return false;
		}
		return true;
	}
	
}
