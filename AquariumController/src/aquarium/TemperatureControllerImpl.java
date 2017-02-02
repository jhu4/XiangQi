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

package aquarium;

import static aquarium.hw.TemperatureAdjuster.AdjusterState.*;
import aquarium.hw.*;
import aquarium.hw.TemperatureAdjuster.AdjusterState;
import static aquarium.TemperatureController.TemperatureScale.*;
import java.util.function.Function;

/**
 * This is the implementation of the TemperatureController.
 * TemperatureController monitors the water temperature and 
 * collaborates with a temperature adjuster mechanism that
 * is able to heat or cool the water.
 * @version Jan 20, 2017
 */
public final class TemperatureControllerImpl implements TemperatureController
{
	private final TemperatureSensor sensor;
	private TemperatureAdjuster adjuster = null;
	private AdjusterState currentState;
	private double desiredTemperature;
	private double acceptableVariation;
	private TemperatureScale previousTempScale;
	
	private final Function<Double, Void> observeTemperatureChange = (Double temp) -> {
		final double delta = Math.abs(desiredTemperature - temp);
		final AdjusterState state = getCurrentState();
		currentState = delta < acceptableVariation ? OFF
				: desiredTemperature > temp ? HEATING : COOLING;
		if (state != currentState) {
			adjuster.setState(currentState);
		} 
		return null;
	};
	
	/**
	 * Private constructor. The only way to create an instance of this class
	 * is to use the factory method.
	 */
	private TemperatureControllerImpl(TemperatureSensor sensor, TemperatureAdjuster adjuster)
	{
		this.sensor = sensor;
		this.adjuster = adjuster;
		this.previousTempScale = CELSIUS;
		currentState = OFF;
		desiredTemperature = 20.0;
		acceptableVariation = 1.0;
		sensor.addObserver(observeTemperatureChange);
		observeTemperatureChange.apply(sensor.getTemperature());
	}
	
	/**
	 * Factory method for creating an instance of the TemperatureControllerImpl. This creates
	 * the 
	 * @param sensor the sensor associated with the controller
	 * @param adjuster the adjuster associated with the controller
	 * @return the resulting controller
	 */
	static public TemperatureController makeTemperatureController(
			TemperatureSensor sensor, TemperatureAdjuster adjuster)
	{
		return new TemperatureControllerImpl(sensor, adjuster);
	}
	
	/*
	 * @see aquarium.TemperatureController#setTemperature(double)
	 */
	@Override
	public void setTemperature(double temperature)
	{
		desiredTemperature = previousTempScale==CELSIUS? temperature : temperatureFtoC(temperature);
		observeTemperatureChange.apply(sensor.getTemperature());
	}

	/*
	 * @see aquarium.TemperatureController#getCurrentTemperature()
	 */
	@Override
	public double getCurrentTemperature()
	{
		double temp = sensor.getTemperature();
		return previousTempScale==CELSIUS? temp : temperatureCtoF(temp);
	}

	/*
	 * @see aquarium.TemperatureController#setAcceptableVariation(double)
	 */
	@Override
	public void setAcceptableVariation(double variance)
	{
		if(previousTempScale==CELSIUS){
			acceptableVariation=variance;
			sensor.setDelta(variance);
		}
		else{
			//convert the degree from F to C and save the value
			acceptableVariation=ratioFtoC(variance);
			sensor.setDelta(ratioFtoC(variance));
		}
		observeTemperatureChange.apply(sensor.getTemperature());
	}

	/*
	 * @see aquarium.TemperatureController#getAcceptableVariation()
	 */
	@Override
	public double getAcceptableVariation()
	{
		return previousTempScale==CELSIUS? acceptableVariation : ratioCtoF(acceptableVariation);
	}
	
	/*
	 * @see aquarium.TemperatureController#setTemperatureScale(aquarium.TemperatureController.TemperatureScale)
	 */
	@Override
	public void setTemperatureScale(TemperatureScale newTemperatureScale)
	{
		//change the scale to the new scale unit
		previousTempScale=newTemperatureScale;	
	}

	/*
	 * @see aquarium.TemperatureController#getTemperatureScale()
	 */
	@Override
	public TemperatureScale getTemperatureScale()
	{
		return previousTempScale;
	}
	
	private AdjusterState getCurrentState()
	{
		return currentState;
	}
	
	/**
	 * Convert the temperature from Celsius to Fahrenheit
	 * @param number temperature degree in Celsius
	 * @return temperature degree in Fahrenheit
	 */
	private double temperatureCtoF(double number){
		return number*9/5+32;
	}
	
	/**
	 * Convert the temperature from Fahrenheit to Celsius
	 * @param number temperature degree in Fahrenheit
	 * @return temperature degree in Celsius
	 */
	private double temperatureFtoC(double number){
		return (number-32)*5/9;
	}
	
	/**
	 * Convert Celsius scale to Fahrenheit scale
	 * @param number the scale ratio in Celsius
	 * @return the scale ratio in Fahrenheit
	 */
	private double ratioCtoF(double number){
		return number*9/5;
	}
	
	/**
	 * Convert Fahrenheit scale to Celsius scale
	 * @param number the scale ratio in Fahrenheit
	 * @return the scale ratio in Celsius
	 */
	private double ratioFtoC(double number){
		return number*5/9;
	}

}
