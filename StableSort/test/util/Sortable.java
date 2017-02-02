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

/**
 * This is a test object tha can be ussed in the unit tests for the Stable Sort assignment.
 * @version Sep 27, 2016
 */
public class Sortable<T extends Comparable<T>> implements Comparable
{
	private final T payload;
	private final int index;
	public Sortable(T payload, int index)
	{
		this.payload = payload;
		this.index = index;
	}
	
	/**
	 * @return the payload
	 */
	public T getPayload()
	{
		return payload;
	}
	
	/**
	 * @return the index
	 */
	public int getIndex()
	{
		return index;
	}

	/*
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + index;
		result = prime * result + ((payload == null) ? 0 : payload.hashCode());
		return result;
	}

	/*
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Sortable)) {
			return false;
		}
		Sortable other = (Sortable) obj;
		if (index != other.index) {
			return false;
		}
		if (payload == null) {
			if (other.payload != null) {
				return false;
			}
		} else if (!payload.equals(other.payload)) {
			return false;
		}
		return true;
	}

	@Override
	public int compareTo(Object o)
	{
		Sortable<T> c = (Sortable<T>) o;
		return payload.compareTo(c.payload);
	}
}
