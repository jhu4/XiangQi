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

package util;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Test cases for the classes in the util package.
 * @version Sep 27, 2016
 */
public class SortUtilityTest
{

	@Test
	public void createAnIntegerSortable()
	{
		Sortable<Integer> s = new Sortable<Integer>(1, 0);
		assertEquals(new Integer(1), s.getPayload());
		assertEquals(0, s.getIndex());
	}
	
	@Test
	public void createIntegerSortableThroughFactory()
	{
		SortableFactory<Integer> f = new SortableFactory<Integer>();
		Sortable<Integer> s = f.makeSortable(1);
		assertEquals(new Integer(1), s.getPayload());
		assertEquals(0, s.getIndex());
	}
	
	@Test
	public void createCharactSortableArrayThroughFactory()
	{
		SortableFactory<Character> f = new SortableFactory<Character>();
		Sortable<Character>[] sArray = f.makeSortableArray('c', 'a', 'b');
		assertEquals(new Character('c'), sArray[0].getPayload());
		assertEquals(0, sArray[0].getIndex());
		assertEquals(new Character('a'), sArray[1].getPayload());
		assertEquals(1, sArray[1].getIndex());
		assertEquals(new Character('b'), sArray[2].getPayload());
		assertEquals(2, sArray[2].getIndex());
	}
}
