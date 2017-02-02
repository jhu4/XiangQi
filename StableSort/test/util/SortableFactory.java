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

import java.lang.reflect.Array;
import java.util.*;

/**
 * Create sortable objects easily and consistently.
 * @version Sep 27, 2016
 */
public class SortableFactory<T extends Comparable<T>>
{
	private int nextIndex;
	
	/**
	 * Default constructor.
	 */
	public SortableFactory()
	{
		nextIndex = 0;
	}
	
	/**
	 * Creation method for Sortable objects.
	 * @param payload the object that is the payload of the Sortable
	 * @return the Sortable object.
	 */
	public Sortable<T> makeSortable(T payload)
	{
		return new Sortable<T>(payload, nextIndex++);
	}
	
	/**
	 * Given a set of objects, return an array set of sortable objects.
	 * @param payloads an array of objects that will become the payload for the
	 * 	Sortables
	 * @return the array of Sortables
	 */
	public Sortable<T>[] makeSortableArray(T ... payloads)
	{
		Sortable<T>[] result = new Sortable[payloads.length];
		nextIndex = 0;
		for (T payload : payloads) {
			result[nextIndex] = makeSortable(payload);
		}
		return result;
	}
}
