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
import org.junit.*;
import util.*;

/**
 * Test cases for StableSorter.
 * @version Sep 26, 2016
 */
public class StableSorterTest
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
		Sortable<Integer>[] result = sorter.stableSort(new Sortable[0] );
		assertEquals(0, result.length);
	}
	
	@Test	//2
	public void sortOneElement(){
		Sortable<Integer>[] array = iFactory.makeSortableArray(1);
		assertEquals(new Integer(1), array[0].getPayload());
		assertEquals(0,array[0].getIndex());
		Sortable<Integer>[] result = sorter.stableSort(array);
		assertEquals(new Integer(1), result[0].getPayload());
		assertEquals(0,result[0].getIndex());
	}
	 
	@Test	//3
	public void sortTwoElementsInOrder(){
		Sortable<Integer>[] array = iFactory.makeSortableArray(1,2);
		assertEquals(new Integer(1), array[0].getPayload());
		assertEquals(0,array[0].getIndex());
		assertEquals(new Integer(2), array[1].getPayload());
		assertEquals(1,array[1].getIndex());
		Sortable<Integer>[] result = sorter.stableSort(array);
		assertEquals(new Integer(1), result[0].getPayload());
		assertEquals(0,result[0].getIndex());
		assertEquals(new Integer(2), result[1].getPayload());
		assertEquals(1,result[1].getIndex());		
	}
	
	
	@Test	//4
	public void sortTwoElementsNotInOrder(){
		Sortable<Integer>[] array = iFactory.makeSortableArray(2,1);
		assertEquals(new Integer(2), array[0].getPayload());
		assertEquals(0,array[0].getIndex());
		assertEquals(new Integer(1), array[1].getPayload());
		assertEquals(1,array[1].getIndex());
		Sortable<Integer>[] result = sorter.stableSort(array);
		assertEquals(new Integer(1), result[0].getPayload());
		assertEquals(1,result[0].getIndex());
		assertEquals(new Integer(2), result[1].getPayload());
		assertEquals(0,result[1].getIndex());
	}
	
	@Test	//5
	public void sortThreeElementsInOrder(){
		Sortable<Integer>[] array = iFactory.makeSortableArray(1,2,3);
		assertEquals(new Integer(1), array[0].getPayload());
		assertEquals(0,array[0].getIndex());
		assertEquals(new Integer(2), array[1].getPayload());
		assertEquals(1,array[1].getIndex());
		assertEquals(new Integer(3), array[2].getPayload());
		assertEquals(2,array[2].getIndex());
		Sortable<Integer>[] result = sorter.stableSort(array);
		assertEquals(new Integer(1), array[0].getPayload());
		assertEquals(0,array[0].getIndex());
		assertEquals(new Integer(2), array[1].getPayload());
		assertEquals(1,array[1].getIndex());
		assertEquals(new Integer(3), array[2].getPayload());
		assertEquals(2,array[2].getIndex());
	}
	
	@Test	//6
	public void sortThreeElementsNotInOrder312(){
		Sortable<Integer>[] array = iFactory.makeSortableArray(3,1,2);
		assertEquals(new Integer(3), array[0].getPayload());
		assertEquals(0,array[0].getIndex());
		assertEquals(new Integer(1), array[1].getPayload());
		assertEquals(1,array[1].getIndex());
		assertEquals(new Integer(2), array[2].getPayload());
		assertEquals(2,array[2].getIndex());
		Sortable<Integer>[] result = sorter.stableSort(array);
		assertEquals(new Integer(1), array[0].getPayload());
		assertEquals(1,array[0].getIndex());
		assertEquals(new Integer(2), array[1].getPayload());
		assertEquals(2,array[1].getIndex());
		assertEquals(new Integer(3), array[2].getPayload());
		assertEquals(0,array[2].getIndex());		
	}
	
	@Test	//7
	public void sortThreeElementsNotInOrder321(){
		Sortable<Integer>[] array = iFactory.makeSortableArray(3,2,1);
		assertEquals(new Integer(3), array[0].getPayload());
		assertEquals(0,array[0].getIndex());
		assertEquals(new Integer(2), array[1].getPayload());
		assertEquals(1,array[1].getIndex());
		assertEquals(new Integer(1), array[2].getPayload());
		assertEquals(2,array[2].getIndex());
		Sortable<Integer>[] result = sorter.stableSort(array);
		assertEquals(new Integer(1), array[0].getPayload());
		assertEquals(2,array[0].getIndex());
		assertEquals(new Integer(2), array[1].getPayload());
		assertEquals(1,array[1].getIndex());
		assertEquals(new Integer(3), array[2].getPayload());
		assertEquals(0,array[2].getIndex());		
	}
	
	@Test	//8
	public void sortFourElementsNotInOrder4321(){
		Sortable<Integer>[] array = iFactory.makeSortableArray(4,3,2,1);
		assertEquals(new Integer(4), array[0].getPayload());
		assertEquals(0,array[0].getIndex());
		assertEquals(new Integer(3), array[1].getPayload());
		assertEquals(1,array[1].getIndex());
		assertEquals(new Integer(2), array[2].getPayload());
		assertEquals(2,array[2].getIndex());
		assertEquals(new Integer(1), array[3].getPayload());
		assertEquals(3,array[3].getIndex());
		Sortable<Integer>[] result = sorter.stableSort(array);
		assertEquals(new Integer(1), array[0].getPayload());
		assertEquals(3,array[0].getIndex());
		assertEquals(new Integer(2), array[1].getPayload());
		assertEquals(2,array[1].getIndex());
		assertEquals(new Integer(3), array[2].getPayload());
		assertEquals(1,array[2].getIndex());
		assertEquals(new Integer(4), array[3].getPayload());
		assertEquals(0,array[3].getIndex());	
	}
	
	@Test	//9
	public void sortFourElementsNotInOrderwithTies(){
		Sortable<Integer>[] array = iFactory.makeSortableArray(4,3,4,1);
		assertEquals(new Integer(4), array[0].getPayload());
		assertEquals(0,array[0].getIndex());
		assertEquals(new Integer(3), array[1].getPayload());
		assertEquals(1,array[1].getIndex());
		assertEquals(new Integer(4), array[2].getPayload());
		assertEquals(2,array[2].getIndex());
		assertEquals(new Integer(1), array[3].getPayload());
		assertEquals(3,array[3].getIndex());
		Sortable<Integer>[] result = sorter.stableSort(array);
		assertEquals(new Integer(1), array[0].getPayload());
		assertEquals(3,array[0].getIndex());
		assertEquals(new Integer(3), array[1].getPayload());
		assertEquals(1,array[1].getIndex());
		assertEquals(new Integer(4), array[2].getPayload());
		assertEquals(0,array[2].getIndex());
		assertEquals(new Integer(4), array[3].getPayload());
		assertEquals(2,array[3].getIndex());	
	}
	
	
}
