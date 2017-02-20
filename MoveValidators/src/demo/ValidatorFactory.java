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

import java.util.*;
import java.util.function.BiPredicate;

/**
 * Description
 * @version Jan 9, 2017
 */
public class ValidatorFactory
{
	private static BiPredicate<Coordinate, Coordinate> orthogonalValidator = 
			(Coordinate c1, Coordinate c2) -> c1.isOrthogonal(c2);
	private static BiPredicate<Coordinate, Coordinate> diagonalValidator = 
			(Coordinate c1, Coordinate c2) -> c1.isDiagonal(c2);
	private static BiPredicate<Coordinate, Coordinate> adjacentValidator = 
			(Coordinate c1, Coordinate c2) -> c1.distanceTo(c2) == 1;
	private static BiPredicate<Coordinate, Coordinate> diagonalOrOrthogonalValidator = 
			(Coordinate c1, Coordinate c2) -> c1.isOrthogonal(c2) || c1.isDiagonal(c2);
	private static BiPredicate<Coordinate, Coordinate> differentCoordinateValidator = 
			(Coordinate c1, Coordinate c2) -> !c1.equals(c2);
		
	public static enum PieceType {P, R, N, B, Q, K};
	
	public static List<BiPredicate<Coordinate, Coordinate>> makeValidators(PieceType pt)
	{
		List<BiPredicate<Coordinate, Coordinate>> validators = 
				new LinkedList<BiPredicate<Coordinate, Coordinate>>();
		switch (pt) {
			case R:
				validators.add(differentCoordinateValidator);
				validators.add(orthogonalValidator);
				break;
			case B:
				validators.add(differentCoordinateValidator);
				validators.add(diagonalValidator);
				break;
			case Q:
				validators.add(differentCoordinateValidator);
				validators.add(diagonalOrOrthogonalValidator);
				break;
			case K:
				validators.add(adjacentValidator);
				validators.add(diagonalOrOrthogonalValidator);
				break;
			default:
				System.out.println("Not yet implemented");
				break;
		}
		return validators;
	}
}
