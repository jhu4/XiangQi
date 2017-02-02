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

import static aquarium.TemperatureController.TemperatureScale.*;
import static aquarium.hw.TemperatureAdjuster.AdjusterState.*;
import static org.junit.Assert.assertEquals;
import org.junit.*;
import aquarium.hw.*;
import aquarium.hw.TemperatureAdjuster.AdjusterState;
import test.TestTemperatureAdjuster;
import test.TestTemperatureSensor;

public class TemperatureControllerTest
{
	private TestTemperatureSensor ts;
	private TestTemperatureAdjuster ta;
	private TemperatureController controller;
	private TemperatureAdjuster adjuster;
	private TemperatureSensor sensor;
	
	@Before
	public void setup()
	{
		sensor = ts = new TestTemperatureSensor();
		adjuster = ta = new TestTemperatureAdjuster(ts);
		controller = TemperatureControllerImpl.makeTemperatureController(
				sensor, adjuster);
	}
	
	@Test
	public void newControllerIsCelsius20C1CVariance()
	{
//		System.out.println("Starting temp = " + controller.getCurrentTemperature());
		waitForState(OFF);
		assertEquals(20.0, controller.getCurrentTemperature(), 1.0);
		assertEquals(1.0, controller.getAcceptableVariation(), 0.01);
		assertEquals(CELSIUS, controller.getTemperatureScale());
	}

	@Test
	public void temperatureIs19_8CAdjusterIsOFF()
	{
		ts.setTemperature(19.8);
		waitForState(OFF);
		assertEquals(OFF, ta.getState());
	}

	@Test
	public void temperatureIs23AdjusterIsCOOLING()
	{
		ta.setWaitTime(100);
		ts.setTemperature(23.0);
		assertEquals(COOLING, ta.getState());
	}
	
	@Test
	public void temperatureTo20_5CMeansNoChange()
	{
		waitForState(OFF);
		ts.setTemperature(20.5);
		assertEquals(OFF, ta.getState());
	}
	
	@Test
	public void temperatureHeatsUpControllerCoolsItDown()
	{
		waitForState(OFF);
		ts.setTemperature(28.0);
		waitForState(OFF);
		assertEquals(20.0, controller.getCurrentTemperature(), 1.0);
	}
	
	@Test
	public void temperatureIs15AdjusterIsHEATING()
	{
		ta.setWaitTime(100);
		ts.setTemperature(15.0);
		assertEquals(HEATING, ta.getState());
	}
	
	@Test
	public void setTemperatureTo18C()
	{
		waitForState(OFF);
		ta.setWaitTime(100);
		controller.setTemperature(18.0);
		assertEquals(COOLING, ta.getState());
		waitForState(OFF);
		assertEquals(18.0, sensor.getTemperature(), 1.0);
	}
	
	
	@Test
	public void setTemperatureTo22C()
	{
		controller.setAcceptableVariation(0.5);
		waitForState(OFF);
		assertEquals(20.0, controller.getCurrentTemperature(), 0.5);
		assertEquals(0.5, controller.getAcceptableVariation(), 0.01);
		waitForState(OFF);
		ta.setWaitTime(10);
		controller.setTemperature(22.0);
		assertEquals(HEATING, ta.getState());
		waitForState(OFF);
		assertEquals(22.0, controller.getCurrentTemperature(), 0.5);
	}
	
	@Test
	public void testTemperature18To21(){
		controller.setAcceptableVariation(0.5);
		waitForState(OFF);
		assertEquals(20.0,controller.getCurrentTemperature(),0.5);
		assertEquals(0.5,controller.getAcceptableVariation(),0.01);
		ta.setWaitTime(10);
		controller.setTemperature(18.0);
		assertEquals(COOLING, ta.getState());
		controller.setTemperature(21.0);
		assertEquals(HEATING, ta.getState());
		waitForState(OFF);
		assertEquals(21.0,controller.getCurrentTemperature(),0.5);
		assertEquals(0.5,controller.getAcceptableVariation(),0.01);		
	}
	
	
	@Test
	public void testTemperature23To19(){
		controller.setAcceptableVariation(0.5);
		waitForState(OFF);
		assertEquals(20.0,controller.getCurrentTemperature(),0.5);
		assertEquals(0.5,controller.getAcceptableVariation(),0.01);
		ta.setWaitTime(10);
		controller.setTemperature(23.0);
		assertEquals(HEATING, ta.getState());
		controller.setTemperature(19.0);
		assertEquals(COOLING, ta.getState());
		waitForState(OFF);
		assertEquals(19.0,controller.getCurrentTemperature(),0.5);
		assertEquals(0.5,controller.getAcceptableVariation(),0.01);		
	}
	
	@Test
	public void set20CScaleToFarenheit(){
		controller.setAcceptableVariation(0.5);
		waitForState(OFF);
		controller.setTemperatureScale(FAHRENHEIT);
		assertEquals(68,controller.getCurrentTemperature(),0.9);
		assertEquals(0.9,controller.getAcceptableVariation(),0.01);
	}
	
	@Test
	public void set68FScaleToCelsius(){
		controller.setTemperatureScale(FAHRENHEIT);
		controller.setTemperature(68.0);
		controller.setAcceptableVariation(0.9);
		waitForState(OFF);
		controller.setTemperatureScale(CELSIUS);
		assertEquals(20,controller.getCurrentTemperature(),0.5);
		assertEquals(0.5,controller.getAcceptableVariation(),0.01);
	}
	
	@Test
	public void setTemperatureToFahrenheitInProcess20C(){
		controller.setAcceptableVariation(0.5);
		waitForState(OFF);
		assertEquals(20,controller.getCurrentTemperature(),0.5);
		assertEquals(0.5, controller.getAcceptableVariation(), 0.01);
		assertEquals(CELSIUS,controller.getTemperatureScale());
		ta.setWaitTime(10);
		controller.setTemperature(25.0);
		assertEquals(HEATING,ta.getState());
		waitToHeatUpToTemperature(22.0);
		controller.setTemperatureScale(FAHRENHEIT);
		assertEquals(71.6,controller.getCurrentTemperature(),0.9);
		assertEquals(FAHRENHEIT,controller.getTemperatureScale());
		waitForState(OFF);
		assertEquals(77,controller.getCurrentTemperature(),0.9);
		assertEquals(FAHRENHEIT,controller.getTemperatureScale());
	}
	
	@Test
	public void setTemperatureToCelsiusInProcess75F(){
		controller.setTemperatureScale(FAHRENHEIT);
		controller.setAcceptableVariation(0.9);
		controller.setTemperature(75.0);
		waitForState(OFF);
		assertEquals(75,controller.getCurrentTemperature(),0.9);
		assertEquals(0.9, controller.getAcceptableVariation(), 0.01);
		assertEquals(FAHRENHEIT,controller.getTemperatureScale());
		ta.setWaitTime(10);
		controller.setTemperature(65);
		assertEquals(COOLING,ta.getState());
		waitToCoolDownToTemperature(70.0);
		controller.setTemperatureScale(CELSIUS);
		assertEquals(21.1,controller.getCurrentTemperature(),0.5);
		assertEquals(CELSIUS,controller.getTemperatureScale());
		waitForState(OFF);
		assertEquals(18.33,controller.getCurrentTemperature(),0.5);
		assertEquals(CELSIUS,controller.getTemperatureScale());
	}
	
	@Test
	public void testSetVairiation(){
		controller.setAcceptableVariation(5);
		assertEquals(5,controller.getAcceptableVariation(),0.01);
		controller.setTemperatureScale(FAHRENHEIT);
		assertEquals(9,controller.getAcceptableVariation(),0.01);
	}
	
	@Test
	public void setToLowVariationToCoolDownInCelsius(){
		waitForState(OFF);
		controller.setAcceptableVariation(15);
		ts.setTemperature(30);
		assertEquals(OFF,ta.getState());
		assertEquals(30,controller.getCurrentTemperature(),0);
		ta.setWaitTime(10);
		controller.setAcceptableVariation(0.5);
		assertEquals(COOLING,ta.getState());
		waitForState(OFF);
		assertEquals(20.0,controller.getCurrentTemperature(),0.5);
		assertEquals(0.5,controller.getAcceptableVariation(),0.01);
	}
	
	@Test
	public void setToLowVariationToHeatupInCelsius(){
		waitForState(OFF);
		controller.setAcceptableVariation(15);
		ts.setTemperature(10);
		assertEquals(OFF,ta.getState());
		assertEquals(10,controller.getCurrentTemperature(),0);
		ta.setWaitTime(10);
		controller.setAcceptableVariation(0.5);
		assertEquals(HEATING,ta.getState());
		waitForState(OFF);
		assertEquals(20.0,controller.getCurrentTemperature(),0.5);
		assertEquals(0.5,controller.getAcceptableVariation(),0.01);
	}
	
	@Test
	public void testChangingVarianceInFahrenheit(){
		ts.setTemperature(24);
		controller.setTemperatureScale(FAHRENHEIT);
		controller.setAcceptableVariation(9);
		assertEquals(OFF,ta.getState());
		controller.setAcceptableVariation(1);
		assertEquals(COOLING,ta.getState());
		controller.setTemperature(86);
		assertEquals(HEATING,ta.getState());
		controller.setAcceptableVariation(20);
		assertEquals(OFF,ta.getState());
	}
	
	
	/**
	 * Wait to heat up to the specified temperature
	 * @double degree temperature in degrees
	 */
	private void waitToHeatUpToTemperature(double degree){
		do{		
			Thread.yield();
		}while(controller.getCurrentTemperature()<=degree);
	}
	
	/**
	 * Wait to cool down to the specified temperature
	 * @double degree temperature in degrees
	 */
	private void waitToCoolDownToTemperature(double degree){
		do{
			//nothing
			Thread.yield();
		}while(controller.getCurrentTemperature()>=degree);
	}
	
	
	/**
	 * Wait for the specified state
	 */
	private void waitForState(AdjusterState s)
	{
		do {
			// wait for the change
		} while (ta.getState() != s);
	}
}
