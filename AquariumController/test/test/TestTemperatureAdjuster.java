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

import static aquarium.hw.TemperatureAdjuster.AdjusterState.*;
import aquarium.hw.TemperatureAdjuster;

/**
 * <p>
 * The TestTemperatureAdjuster allows testing of an aquarium control that requires a temperature
 * sensor and a temperature adjuster. It allows the test code to cause the temperature to rise
 * and fall based upon the setting of the adjuster.
 * </p>
 * <p>
 * The TestTemperatureAdjuster works in collaboration with the TestTemperatureSensor. To use this 
 * test double you supply a TestTemperatureSensor  in the constructor. You can also set the increments in
 * degrees that you want to simulate cooling or heating of the water in the aquarium.
 * </p>
 * @version Jul 31, 2016
 */
public class TestTemperatureAdjuster implements TemperatureAdjuster
{
	class AdjustThread extends Thread
	{
		private AdjusterState oldState;
		private AdjusterState newState;
		private TestTemperatureAdjuster adjuster;
		public AdjustThread(AdjusterState oldState, AdjusterState newState, TestTemperatureAdjuster adjuster) {
			this.oldState = oldState;
			this.newState = newState;
			this.adjuster = adjuster;
		}
		
		public void run()
		{
			if (newState != OFF) {
				while (adjuster.getState() == newState) {
					double newTemp = newState == HEATING ? sensor.getTemperature() + delta
							: sensor.getTemperature() - delta;
					sensor.setTemperature(newTemp);
					doWait();
				}
			}
		}
	}
	
	private final TestTemperatureSensor sensor;
	private double delta;
	private static final double DEFAULT_DELTA = 0.1;
	private volatile AdjusterState state;
	private int waitTime = 0;
	
	/**
	 * Constructor that creates a TestTemperatureAdjuster instance that is linked to the
	 * TestTemperatureSensor provided. It also sets the change delta to the default of 0.005 °C.
	 * @param sensor the TestTemperatureSensor this adjuster collaborates with
	 */
	public TestTemperatureAdjuster(TestTemperatureSensor sensor)
	{
		this(sensor, DEFAULT_DELTA);
	}
	
	/**
	 * Constructor that creates a TestTemperatureAdjuster instance that is linked to the
	 * TestTemperatureSensor provided and sets the change delta to the delta specified
	 * @param sensor the TestTemperatureSensor this adjuster collaborates with
	 * @param delta the change delta when heating and cooling. This is the amount that the
	 * 	water temperature will raise or lower incrementally when the adjuster is heating
	 *  or cooling.
	 */
	public TestTemperatureAdjuster(TestTemperatureSensor sensor, double delta)
	{
		this.sensor = sensor;
		this.delta = Math.abs(delta);
		state = OFF;
	}
	
	/*
	 * @see aquarium.hw.TemperatureAdjuster#setState(aquarium.hw.TemperatureAdjuster.AdjusterState)
	 */
	@Override
	public void setState(AdjusterState newState)
	{
		AdjusterState oldState = state;
		state = newState;
		if (newState != oldState) {	// change in state
			new AdjustThread(state, newState, this).start();
		}
	}
	
	/**
	 * Get the current state of the adjuster.
	 * @return the current state
	 */
	public AdjusterState getState()
	{
		return state;
	}

	/**
	 * @return the waitTime (ms to wait between new temperatures)
	 */
	public int getWaitTime()
	{
		return waitTime;
	}

	/**
	 * @param waitTime the waitTime to set
	 */
	public void setWaitTime(int waitTime)
	{
		this.waitTime = waitTime;
	}
	
	private void doWait()
	{
		if (waitTime > 0) {
			try {
				Thread.sleep(waitTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
