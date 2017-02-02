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
	
}
