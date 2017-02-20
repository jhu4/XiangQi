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
	
	@Test	// 1 empty element []->[]
	public void sortEmptyArray()
	{
		Sortable<Integer>[] result = sorter.stableSort(new Sortable[0] );
		assertEquals(0, result.length);
	}
	
	@Test	//2 One Integer: [1]->[1]
	public void sortOneElement(){
		Sortable<Integer>[] array = iFactory.makeSortableArray(1);
		assertEquals(1,array.length);
		assertEquals(new Integer(1), array[0].getPayload());
		assertEquals(0,array[0].getIndex());
		Sortable<Integer>[] result = sorter.stableSort(array);
		assertEquals(new Integer(1), result[0].getPayload());
		assertEquals(0,result[0].getIndex());
	}
	 
	@Test	//3 Two Integers in order: [1,2]->[1,2]
	public void sortTwoElementsInOrder(){
		Sortable<Integer>[] array = iFactory.makeSortableArray(1,2);
		assertEquals(2,array.length);
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
	
	@Test	//4 Two Integers not in order: [2,1]->[1,2]
	public void sortTwoElementsNotInOrder(){
		Sortable<Integer>[] array = iFactory.makeSortableArray(2,1);
		assertEquals(2,array.length);
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
	
	@Test	//5 Three Integers in order: [1,2,3]->[1,2,3]
	public void sortThreeElementsInOrder(){
		Sortable<Integer>[] array = iFactory.makeSortableArray(1,2,3);
		assertEquals(3,array.length);
		assertEquals(new Integer(1), array[0].getPayload());
		assertEquals(0,array[0].getIndex());
		assertEquals(new Integer(2), array[1].getPayload());
		assertEquals(1,array[1].getIndex());
		assertEquals(new Integer(3), array[2].getPayload());
		assertEquals(2,array[2].getIndex());
		Sortable<Integer>[] result = sorter.stableSort(array);
		assertEquals(new Integer(1), result[0].getPayload());
		assertEquals(0,result[0].getIndex());
		assertEquals(new Integer(2), result[1].getPayload());
		assertEquals(1,result[1].getIndex());
		assertEquals(new Integer(3), result[2].getPayload());
		assertEquals(2,result[2].getIndex());
	}
	
	@Test	//6 Three Integers not in order: [3,1,2]->[1,2,3]
	public void sortThreeElementsNotInOrder312(){
		Sortable<Integer>[] array = iFactory.makeSortableArray(3,1,2);
		assertEquals(3,array.length);
		assertEquals(new Integer(3), array[0].getPayload());
		assertEquals(0,array[0].getIndex());
		assertEquals(new Integer(1), array[1].getPayload());
		assertEquals(1,array[1].getIndex());
		assertEquals(new Integer(2), array[2].getPayload());
		assertEquals(2,array[2].getIndex());
		Sortable<Integer>[] result = sorter.stableSort(array);
		assertEquals(new Integer(1), result[0].getPayload());
		assertEquals(1,result[0].getIndex());
		assertEquals(new Integer(2), result[1].getPayload());
		assertEquals(2,result[1].getIndex());
		assertEquals(new Integer(3), result[2].getPayload());
		assertEquals(0,result[2].getIndex());		
	}
	
	@Test	//7 Three Integers not in order: [3,2,1]->[1,2,3]
	public void sortThreeElementsNotInOrder321(){
		Sortable<Integer>[] array = iFactory.makeSortableArray(3,2,1);
		assertEquals(3,array.length);
		assertEquals(new Integer(3), array[0].getPayload());
		assertEquals(0,array[0].getIndex());
		assertEquals(new Integer(2), array[1].getPayload());
		assertEquals(1,array[1].getIndex());
		assertEquals(new Integer(1), array[2].getPayload());
		assertEquals(2,array[2].getIndex());
		Sortable<Integer>[] result = sorter.stableSort(array);
		assertEquals(new Integer(1), result[0].getPayload());
		assertEquals(2,result[0].getIndex());
		assertEquals(new Integer(2), result[1].getPayload());
		assertEquals(1,result[1].getIndex());
		assertEquals(new Integer(3), result[2].getPayload());
		assertEquals(0,result[2].getIndex());		
	}
	
	@Test	//8 Four Integers in order: [1,2,3,4]->[1,2,3,4]
	public void sortFourElementsInOrder(){
		Sortable<Integer>[] array = iFactory.makeSortableArray(1,2,3,4);
		assertEquals(4,array.length);
		assertEquals(new Integer(1), array[0].getPayload());
		assertEquals(0,array[0].getIndex());
		assertEquals(new Integer(2), array[1].getPayload());
		assertEquals(1,array[1].getIndex());
		assertEquals(new Integer(3), array[2].getPayload());
		assertEquals(2,array[2].getIndex());
		assertEquals(new Integer(4), array[3].getPayload());
		assertEquals(3,array[3].getIndex());
		Sortable<Integer>[] result = sorter.stableSort(array);
		assertEquals(new Integer(1), result[0].getPayload());
		assertEquals(0,result[0].getIndex());
		assertEquals(new Integer(2), result[1].getPayload());
		assertEquals(1,result[1].getIndex());
		assertEquals(new Integer(3), result[2].getPayload());
		assertEquals(2,result[2].getIndex());
		assertEquals(new Integer(4), result[3].getPayload());
		assertEquals(3,result[3].getIndex());	
	}
	
	@Test	//9 Four Integers not in order: [4,3,2,1]->[1,2,3,4]
	public void sortFourElementsNotInOrder4321(){
		Sortable<Integer>[] array = iFactory.makeSortableArray(4,3,2,1);
		assertEquals(4,array.length);
		assertEquals(new Integer(4), array[0].getPayload());
		assertEquals(0,array[0].getIndex());
		assertEquals(new Integer(3), array[1].getPayload());
		assertEquals(1,array[1].getIndex());
		assertEquals(new Integer(2), array[2].getPayload());
		assertEquals(2,array[2].getIndex());
		assertEquals(new Integer(1), array[3].getPayload());
		assertEquals(3,array[3].getIndex());
		Sortable<Integer>[] result = sorter.stableSort(array);
		assertEquals(new Integer(1), result[0].getPayload());
		assertEquals(3,result[0].getIndex());
		assertEquals(new Integer(2), result[1].getPayload());
		assertEquals(2,result[1].getIndex());
		assertEquals(new Integer(3), result[2].getPayload());
		assertEquals(1,result[2].getIndex());
		assertEquals(new Integer(4), result[3].getPayload());
		assertEquals(0,result[3].getIndex());	
	}
	
	@Test	//10 Four Integers not in order with a tie: [4,3,4,1]->[1,3,4,4]
	public void sortFourElementsNotInOrderwithTies(){
		Sortable<Integer>[] array = iFactory.makeSortableArray(4,3,4,1);
		assertEquals(4,array.length);
		assertEquals(new Integer(4), array[0].getPayload());
		assertEquals(0,array[0].getIndex());
		assertEquals(new Integer(3), array[1].getPayload());
		assertEquals(1,array[1].getIndex());
		assertEquals(new Integer(4), array[2].getPayload());
		assertEquals(2,array[2].getIndex());
		assertEquals(new Integer(1), array[3].getPayload());
		assertEquals(3,array[3].getIndex());
		Sortable<Integer>[] result = sorter.stableSort(array);
		assertEquals(new Integer(1), result[0].getPayload());
		assertEquals(3,result[0].getIndex());
		assertEquals(new Integer(3), result[1].getPayload());
		assertEquals(1,result[1].getIndex());
		assertEquals(new Integer(4), result[2].getPayload());
		assertEquals(0,result[2].getIndex());
		assertEquals(new Integer(4), result[3].getPayload());
		assertEquals(2,result[3].getIndex());	
	}
	
	@Test	//11 Five integers with all equal elements: [5,5,5,5,5]->[5,5,5,5,5]
	public void sortFiveElementsEqual(){
		Sortable<Integer>[] array = iFactory.makeSortableArray(5,5,5,5,5);
		assertEquals(5,array.length);
		assertEquals(new Integer(5), array[0].getPayload());
		assertEquals(0,array[0].getIndex());
		assertEquals(new Integer(5), array[1].getPayload());
		assertEquals(1,array[1].getIndex());
		assertEquals(new Integer(5), array[2].getPayload());
		assertEquals(2,array[2].getIndex());
		assertEquals(new Integer(5), array[3].getPayload());
		assertEquals(3,array[3].getIndex());
		assertEquals(new Integer(5), array[4].getPayload());
		assertEquals(4,array[4].getIndex());
		Sortable<Integer>[] result = sorter.stableSort(array);
		assertEquals(new Integer(5), result[0].getPayload());
		assertEquals(0,result[0].getIndex());
		assertEquals(new Integer(5), result[1].getPayload());
		assertEquals(1,result[1].getIndex());
		assertEquals(new Integer(5), result[2].getPayload());
		assertEquals(2,result[2].getIndex());
		assertEquals(new Integer(5), result[3].getPayload());
		assertEquals(3,result[3].getIndex());
		assertEquals(new Integer(5), result[4].getPayload());
		assertEquals(4,result[4].getIndex());	
	}
	
	@Test	//12 Five characters in order: [a,b,c,d,e]->[a,b,c,d,e]
	public void sortFiveCharacterInOrder(){
		SortableFactory<Character> charFactory = new SortableFactory<Character>();
		Sortable<Character>[] array = charFactory.makeSortableArray('a','b','c','d','e');
		assertEquals(5,array.length);
		assertEquals(new Character('a'), array[0].getPayload());
		assertEquals(0,array[0].getIndex());
		assertEquals(new Character('b'), array[1].getPayload());
		assertEquals(1,array[1].getIndex());
		assertEquals(new Character('c'), array[2].getPayload());
		assertEquals(2,array[2].getIndex());
		assertEquals(new Character('d'), array[3].getPayload());
		assertEquals(3,array[3].getIndex());
		assertEquals(new Character('e'), array[4].getPayload());
		assertEquals(4,array[4].getIndex());
		Sortable<Character>[] result = sorter.stableSort(array);
		assertEquals(new Character('a'), result[0].getPayload());
		assertEquals(0,result[0].getIndex());
		assertEquals(new Character('b'), result[1].getPayload());
		assertEquals(1,result[1].getIndex());
		assertEquals(new Character('c'), result[2].getPayload());
		assertEquals(2,result[2].getIndex());
		assertEquals(new Character('d'), result[3].getPayload());
		assertEquals(3,result[3].getIndex());
		assertEquals(new Character('e'), result[4].getPayload());
		assertEquals(4,result[4].getIndex());
	}

	@Test	//13 Five characters not in order: [c,d,e,a,b]->[a,b,c,d,e]
	public void sortFiveCharactersNotInOrder(){
		SortableFactory<Character> charFactory = new SortableFactory<Character>();
		Sortable<Character>[] array = charFactory.makeSortableArray('c','d','e','a','b');
		assertEquals(5,array.length);
		assertEquals(new Character('c'), array[0].getPayload());
		assertEquals(0,array[0].getIndex());
		assertEquals(new Character('d'), array[1].getPayload());
		assertEquals(1,array[1].getIndex());
		assertEquals(new Character('e'), array[2].getPayload());
		assertEquals(2,array[2].getIndex());
		assertEquals(new Character('a'), array[3].getPayload());
		assertEquals(3,array[3].getIndex());
		assertEquals(new Character('b'), array[4].getPayload());
		assertEquals(4,array[4].getIndex());
		Sortable<Character>[] result = sorter.stableSort(array);
		assertEquals(new Character('a'), result[0].getPayload());
		assertEquals(3,result[0].getIndex());
		assertEquals(new Character('b'), result[1].getPayload());
		assertEquals(4,result[1].getIndex());
		assertEquals(new Character('c'), result[2].getPayload());
		assertEquals(0,result[2].getIndex());
		assertEquals(new Character('d'), result[3].getPayload());
		assertEquals(1,result[3].getIndex());
		assertEquals(new Character('e'), result[4].getPayload());
		assertEquals(2,result[4].getIndex());		
	}
	
	@Test	//14 Five characters with ties and not in order: [c,c,d,a,a]->[a,a,c,c,d] 
	public void sortFiveCharactersWithTiesNotInOrder(){
		SortableFactory<Character> charFactory = new SortableFactory<Character>();
		Sortable<Character>[] array = charFactory.makeSortableArray('c','c','d','a','a');
		assertEquals(5,array.length);
		assertEquals(new Character('c'), array[0].getPayload());
		assertEquals(0,array[0].getIndex());
		assertEquals(new Character('c'), array[1].getPayload());
		assertEquals(1,array[1].getIndex());
		assertEquals(new Character('d'), array[2].getPayload());
		assertEquals(2,array[2].getIndex());
		assertEquals(new Character('a'), array[3].getPayload());
		assertEquals(3,array[3].getIndex());
		assertEquals(new Character('a'), array[4].getPayload());
		assertEquals(4,array[4].getIndex());
		Sortable<Character>[] result = sorter.stableSort(array);
		assertEquals(new Character('a'), result[0].getPayload());
		assertEquals(3,result[0].getIndex());
		assertEquals(new Character('a'), result[1].getPayload());
		assertEquals(4,result[1].getIndex());
		assertEquals(new Character('c'), result[2].getPayload());
		assertEquals(0,result[2].getIndex());
		assertEquals(new Character('c'), result[3].getPayload());
		assertEquals(1,result[3].getIndex());
		assertEquals(new Character('d'), result[4].getPayload());
		assertEquals(2,result[4].getIndex());		
	}
	
	@Test	//15 Six characters with special characters and 
			//capitals and not in order: [c,C,!,A,a]->[!,A,C,a,c]
	public void sortFiveCharactersWithTiesAndCapitalsNotInOrder(){
		SortableFactory<Character> charFactory = new SortableFactory<Character>();
		Sortable<Character>[] array = charFactory.makeSortableArray('c','C','!','A','a','a');
		assertEquals(6,array.length);
		assertEquals(new Character('c'), array[0].getPayload());
		assertEquals(0,array[0].getIndex());
		assertEquals(new Character('C'), array[1].getPayload());
		assertEquals(1,array[1].getIndex());
		assertEquals(new Character('!'), array[2].getPayload());
		assertEquals(2,array[2].getIndex());
		assertEquals(new Character('A'), array[3].getPayload());
		assertEquals(3,array[3].getIndex());
		assertEquals(new Character('a'), array[4].getPayload());
		assertEquals(4,array[4].getIndex());
		assertEquals(new Character('a'), array[5].getPayload());
		assertEquals(5,array[5].getIndex());
		Sortable<Character>[] result = sorter.stableSort(array);
		assertEquals(new Character('!'), result[0].getPayload());
		assertEquals(2,result[0].getIndex());
		assertEquals(new Character('A'), result[1].getPayload());
		assertEquals(3,result[1].getIndex());
		assertEquals(new Character('C'), result[2].getPayload());
		assertEquals(1,result[2].getIndex());
		assertEquals(new Character('a'), result[3].getPayload());
		assertEquals(4,result[3].getIndex());
		assertEquals(new Character('a'), result[4].getPayload());
		assertEquals(5,result[4].getIndex());
		assertEquals(new Character('c'), result[5].getPayload());
		assertEquals(0,result[5].getIndex());		
	}
}
