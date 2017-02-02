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

/**
 * The TemperatureController is a key part of the Aquarium system. It monitors the
 * water temperature and collaborates with a temperature adjuster mechanism that
 * is able to heat or cool the water.
 * @version Aug 1, 2016
 */
public interface TemperatureController
{
	/**
	 * An enumeration that indicates which scale should be used to set and
	 * report temperatures.
	 */
	enum TemperatureScale { FAHRENHEIT, CELSIUS };
	
	/**
	 * Set the desired temperature of the water in the aquarium. The controller
	 * will keep the temperature within the acceptable variation specified by the 
	 * system.
	 * @param temperature the desired water temperature in the aquarium, specified
	 * 	as degrees in the current temperature scale
	 */
	void setTemperature(double temperature);
	
	/**
	 * Handle a request to get the current temperature from the aquarium.
	 * @return the actual temperature in of the water in the aquarium, reported in
	 * 	the current temperature scale
	 */
	double getCurrentTemperature();
	
	/**
	 * Set the acceptable variation in temperature before the temperature
	 * controller should take action to get the temperature back to the
	 * desired point.
	 * @param delta the variation in temperature, specified in the current
	 * 	temperature scale
	 */
	void setAcceptableVariation(double variance);
	
	/**
	 * Return the current acceptable temperature variation, reported in the current
	 * temperature scale.
	 * @return the current temperature variation
	 */
	double getAcceptableVariation();
	
	/**
	 * <p>
	 * Set the temperature scale to the specified scale. This will cause all
	 * future temperatures that are reported or supplied as arguments to
	 * methods to be in that scale. The operation of the controller should not
	 * be affected by a change in temperature scale.
	 * </p><p>
	 * For example, if the desired temperature is 20°C and the acceptable variation is
	 * 0.5°, which is also Celsius, and the scale is changed to Fahrenheit, then the
	 * desired temperature will not change (although there may be a change in the internal
	 * state of the controller), it will just be reported as 68.0. Likewise, the acceptable
	 * variation would be reported as 0.9.
	 * </p>
	 * @param newTemperatureScale either FAHRENHEIT or CELSIUS
	 */
	void setTemperatureScale(TemperatureScale newTemperatureScale);
	
	/**
	 * Return the current temperature scale for this temperature controller.
	 * @return the current temperature scale.
	 */
	TemperatureScale getTemperatureScale();
}
