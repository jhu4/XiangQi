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

package test;

import java.util.*;
import java.util.function.Function;
import aquarium.hw.TemperatureSensor;

/**
 * <p>
 * The TestTemperatureSensor allows testing of an aquarium control that requires a temperature
 * sensor and a temperature adjuster. It allows the test code to simulate changes in temperature
 * by calling setTemperature(). This can be done directly by the test case code or
 * from the TestTemperatureAdapter.
 * </p> <p>
 * The TestTemperatureSensor works in collaboration with the TestTemperatureAdapter.
 * </p>
 * @version Jul 28, 2016
 */
public class TestTemperatureSensor implements TemperatureSensor
{
	private Collection<Function<Double, Void>> observers;
	private double currentTemp, lastReportedTemp, delta;
	private static final double DEFAULT_DELTA = 0.5;
	
	/**
	 * Create a temperature sensor with a default delta of 0.5°C.
	 */
	public TestTemperatureSensor()
	{
		this(DEFAULT_DELTA);
	}
	
	/**
	 * Create a temperature sensor with the specified delta
	 * @param delta the sensor's delta
	 */
	public TestTemperatureSensor(double delta)
	{
		observers = new LinkedList<Function<Double, Void>>();
		lastReportedTemp = currentTemp = Double.MIN_NORMAL;
		this.delta = Math.abs(delta);
	}
	
	/*
	 * @see aquarium.Observable#addObserver(Function<Double, Void> anObserver)
	 */
	@Override
	public void addObserver(Function<Double, Void> anObserver)
	{
		observers.add(anObserver);
	}

	/*
	 * @see aquarium.Observable#removeObserver(aquarium.Observer)
	 */
	@Override
	public void removeObserver(Function<Double, Void> observer)
	{
		observers.remove(observer);
	}

	/*
	 * @see aquarium.hw.TemperatureSensor#setDelta(double)
	 */
	@Override
	public void setDelta(double delta)
	{
		this.delta = Math.abs(delta);
	}

	private void notifyObservers()
	{
		observers.forEach(f -> f.apply(currentTemp));
//		for (Function<Double, Void> f : observers) {
//			f.apply(currentTemp);
//		}
	}
	
	public void setTemperature(double temp)
	{
		currentTemp = temp;
		final double diff = Math.abs(currentTemp - lastReportedTemp);
		if (diff >= delta) {
			lastReportedTemp = currentTemp;
			notifyObservers();
		}
	}

	/*
	 * @see aquarium.hw.TemperatureSensor#gettemperature)
	 */
	@Override
	public double getTemperature()
	{
		return currentTemp;
	}
}
