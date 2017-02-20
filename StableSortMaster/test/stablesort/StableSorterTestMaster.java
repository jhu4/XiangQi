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

import static org.junit.Assert.*;
import java.util.Random;
import org.junit.*;
import masterutil.*;

/**
 * Test cases for StableSorter.
 * @version Sep 26, 2016
 */
public class StableSorterTestMaster
{
	private SortableFactory<Integer> iFactory = null;
	private StableSorter sorter = null;
	
	@Before
	public void setup()
	{
		iFactory = new SortableFactory<Integer>();
		sorter = new StableSorter();
	}
	
	@Test	// 1
	public void sortEmptyArray()
	{
		final Sortable<Integer>[] result = sorter.stableSort(new Sortable[0] );
		assertEquals(0, result.length);
	}
	
	@Test	// 2
	public void sortSingleElementArray()
	{
		final Sortable<Integer>[] result = sorter.stableSort(iFactory.makeSortable(1));
		assertEquals(1, (int)result[0].getPayload());
	}
	
	@Test	// 3
	public void sortAlreadySortedTwoElementArray()
	{
		final Sortable<Integer>[] startArray = iFactory.makeSortableArray(1, 2);
		final Sortable<Integer>[] sortedArray = sorter.stableSort(startArray);
		assertArrayEquals(startArray, sortedArray);
	}
	
	@Test	// 4
	public void sortTwoElementArrayThatIsOutOfOrder()
	{
		final Sortable<Integer>[] startArray = iFactory.makeSortableArray(2, 1);
		// Clone the array in case the student implementation does not create a new array
		final Sortable<Integer>[] sortedArray = sorter.stableSort(startArray.clone());
		assertEquals(startArray[0], sortedArray[1]);
		assertEquals(startArray[1], sortedArray[0]);
	}
	
	@Test	// 5
	public void sortThreeElementOutOfOrderArray()
	{
		final Sortable<Integer>[] startArray = iFactory.makeSortableArray(0, 1, -1);
		final Sortable<Integer>[] sortedArray = sorter.stableSort(startArray.clone());
		assertTrue(arrayIsStablySorted(sortedArray));
	}
	
	@Test 	// 6
	public void sortAnotherThreeElementOutOfOrderArray() 
	{
		final Sortable<Integer>[] startArray = iFactory.makeSortableArray(5, 4, 14);
		final Sortable<Integer>[] sortedArray = sorter.stableSort(startArray.clone());
		assertTrue(arrayIsStablySorted(sortedArray));
	}
	
	@Test 	// 7
	public void sortIntegerObjects()
	{
		final Integer[] startArray = {3, 5, 7, 2};
		final Integer[] sortedArray = sorter.stableSort(startArray);
		assertTrue(arrayIsSorted(sortedArray));
	}
	
	@Test	// 8
	public void sortStringSortables()
	{
		final SortableFactory<String> sFactory = new SortableFactory<String>();
		final Sortable<String>[] startArray = sFactory.makeSortableArray("c", "e", "a", "r");
		final Sortable<String>[] sortedArray = sorter.stableSort(startArray.clone());
		assertTrue(arrayIsStablySorted(sortedArray));
	}
	
	@Test	// 9
	public void generateRandomTests()
	{
		for (int i = 1; i <= 20; i++) {
			final Sortable<Integer>[] startArray = makeRandomSortableIntegerArray();
			final Sortable<Integer>[] sortedArray = sorter.stableSort(startArray.clone());
			assertTrue("Test for " + startArray + " fails", arrayIsStablySorted(sortedArray));
		}
	}
	
	@Test	// 10
	public void stableSortSameIntegers()
	{
		final Sortable<Integer>[] startArray = iFactory.makeSortableArray(1, 1, 1, 1, 1, 1);
		swap(startArray, 0, 3);
		swap(startArray, 2, 5);
		final Sortable<Integer>[] sortedArray = sorter.stableSort(startArray.clone());
		assertTrue(arrayIsStablySorted(sortedArray));
	}
	
	// Helper methods
	private boolean arrayIsSorted(Comparable [] array) {
		for (int i = 1; i < array.length; i++) {
			if (array[i].compareTo(array[i-1]) < 0) return false;
		}
		return true;
	}
	
	private boolean arrayIsStablySorted(Sortable [] array) {
		for (int i = 1; i < array.length; i++) {
			if (array[i].compareTo(array[i-1]) < 0) return false;
			if (array[i].getIndex() < array[i].getIndex()) return false;
		}
		return true;
	}
	
	private Sortable<Integer>[] makeRandomSortableIntegerArray()
	{
		final Random generator = new Random(System.currentTimeMillis());
		final int arrayLength = 3 + generator.nextInt(50);
		final Integer[] a = new Integer[arrayLength];
		for (int i = 0; i < arrayLength; i++) {
			a[i] = generator.nextInt();
		}
		return iFactory.makeSortableArray(a);
	}
	
	private void swap(Sortable [] array, int i1, int i2)
	{
		Sortable temp = array[i1];
		array[i1] = array[i2];
		array[i2] = temp;
	}
}
