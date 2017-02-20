/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design.
 * The course was taken at Worcester Polytechnic Institute.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Copyright ©2016 Gary F. Pollice
 *******************************************************************************/

package stablesort;

import masterutil.Sortable;

/**
 * This class performs stable sorts on an array of objects.
 * @version Sep 26, 2016
 */
public class StableSorter implements StableSort
{
	
	/*
	 * @see stablesort.StableSort#stableSort(T)
	 */
	@Override
	public <T extends Comparable<T>> T[] stableSort(T ... items)
	{
		T[] result = (T[]) new Comparable[items.length];
		result = items.clone();
		doBubbleSort(result);
		return result;
	}
	
	/**
	 * Probably least efficient implementation of BubbleSort, but good enough for
	 * this assignment.
	 */
	private void doBubbleSort(Comparable [] array)
	{
		final int n = array.length - 1;
		boolean swapped = false;
		do {
			swapped = false;
			for (int i = 1; i <= n; i++) {
				if (array[i].compareTo(array[i-1]) < 0) {
					swap(array, i, i-1);
					swapped = true;
				}
			}
		} while (swapped);
	}
	
	/**
	 * Swap two items in the array
	 * @param array the array we're working on
	 * @param i1 index of first item
	 * @param i2 index of second item
	 */
	private void swap(Comparable [] array, int i1, int i2)
	{
		Comparable temp = array[i1];
		array[i1] = array[i2];
		array[i2] = temp;
	}
}
