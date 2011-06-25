/**
 * Licensed under the Apache License, Version 2.0. You may obtain a copy of 
 * the License at http://www.apache.org/licenses/LICENSE-2.0 or at this project's root.
 */

package org.hbird.transport.spacesystemmodel;

import java.math.BigDecimal;

/**
 * The unit of a parameter.
 * 
 * A unit is described based on the 7 base SI dimensions; Kelvin to measure temperature. Seconds to measure time. Ampere
 * to measure charge. Meter to measure distance. Candela to measure lumenosity. Kilogram to measure mass. Mole to
 * measure amount.
 * 
 * The attributes holding the values are all powers of the dimension. A value of meter=1 thus means 'meter' where as
 * meter=2 means 'meter^2'. A negative value expresses a negative exponent. meter=-1 thus means '1/meter' and meter=2
 * means '1/meter^2'. The dimensions can be combined. Speed measures as meter/seconds is thus meter=1 and seconds=-1.
 * Acceleration measured in meter/seconds^2 is expressed as meter=1 and seconds=-2.
 */
public class Unit implements SpaceSystemModelItem {

	private final String name;

	private final String shortDescription;

	private final String longDescription;

	/** TODO */
	private BigDecimal power;

	/** TODO */
	private String factor;

	/** SI dimension for temperature. */
	private final int kelvin = 0;

	/** SI dimension for time. */
	private final int seconds = 0;

	/** SI dimension for charge. */
	private final int ampere = 0;

	/** SI dimension for distance. */
	private final int meter = 0;

	/** SI dimension for luminosity. */
	private final int candela = 0;

	/** SI dimension for mass. */
	private final int kilogram = 0;

	/** SI dimension for amount. */
	private final int mole = 0;


	/**
	 * Constructor of the Unit class.
	 * 
	 * @param name
	 *            The name of the container.
	 * @param shortDescription
	 *            A one line description of the container, used for tooltip type information.
	 * @param longDescription
	 *            A detailed description of the container.
	 * @param power
	 *            TODO
	 * @param factor
	 *            TODO
	 * 
	 */
	public Unit(final String name, final String shortDescription, final String longDescription, final BigDecimal power, final String factor) {
		this.name = name;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;

		this.power = power;
		this.factor = factor;
	}

	public BigDecimal getPower() {
		return power;
	}

	public void setPower(final BigDecimal power) {
		this.power = power;
	}

	public String getFactor() {
		return factor;
	}

	public void setFactor(final String factor) {
		this.factor = factor;
	}


	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getShortDescription() {
		return this.shortDescription;
	}

	@Override
	public String getLongDescription() {
		return this.longDescription;
	}
}
