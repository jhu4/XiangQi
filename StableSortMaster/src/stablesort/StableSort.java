/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design. The course was
 * taken at Worcester Polytechnic Institute. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License
 * v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Copyright ©2016 Gary F. Pollice
 *******************************************************************************/

package stablesort;

/**
 * This interface describes the method for performing a stable sort on an
 * array of comparable items. 
 * @version Sep 27, 2016
 */
public interface StableSort
{
	/**
	 * Perform a stable sort of an array of items that implement the Comparable
	 * interface.
	 * @param items the array of (unsorted) items
	 * @return the array of sorted items
	 */
	<T extends Comparable<T>> T[] stableSort(T... items);
}