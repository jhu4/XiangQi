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
		for(int length=items.length-1;length>0;length--){
			for(int i=0;i<length;i++){
				if(items[i].compareTo(items[i+1])>0){
					//swap the element if they are not in order
					T temp = items[i];
					items[i]=items[i+1];
					items[i+1]=temp;
				}
			}
		}
		return items;
	}
}
