package org.hbird.transport.spacesystemmodel.parameters.types;

import java.util.List;

import org.hbird.transport.spacesystemmodel.SpaceSystemModelItem;
import org.hbird.transport.spacesystemmodel.Unit;
import org.hbird.transport.spacesystemmodel.exceptions.InvalidParameterTypeException;
import org.hbird.transport.spacesystemmodel.parameters.behaviours.NumberParameterTypeBehaviour;

/**
 * FIXME Javadoc
 * 
 */
public class NumberParameterType implements SpaceSystemModelItem {

	private final NumberParameterTypeBehaviour numberBehaviour;

	/** The initial value of the parameter. */
	protected final long initialValue;

	/** The unit of the parameter. */
	protected List<Unit> unit = null;

	private final String name;

	private final String shortDescription;

	private final String longDescription;

	/**
	 * Constructor of the ParameterType class.
	 * 
	 * @param name
	 *            The name of the container.
	 * @param shortDescription
	 *            A one line description of the container, used for tooltip type information.
	 * @param longDescription
	 *            A detailed description of the container.
	 * @param type
	 *            The simple java type.
	 * @param signed
	 *            Flag indicating whether the type is signed or not.
	 * @param initialValue
	 *            The default value of all parameters of this type.
	 * @param sizeInBits
	 *            The size of the parameters of this type in bits.
	 * @throws InvalidParameterTypeException
	 * 
	 */
	public NumberParameterType(final String name, final String shortDescription, final String longDescription, final NumberParameterTypeBehaviour numberType,
			final long initialValue) throws InvalidParameterTypeException {

		this.name = name;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
		this.numberBehaviour = numberType;
		this.initialValue = initialValue;
	}

	/**
	 * Returns the initial value, i.e. the default value of all parameters of this type.
	 * 
	 * @return long The initial value of the parameters of this type.
	 * 
	 */
	public long getInitialValue() {
		return initialValue;
	}

	/**
	 * Returns the size in bits.
	 * 
	 * @return long The size in bits.
	 * 
	 */
	public long getSizeInBits() {
		return numberBehaviour.getSizeInBits();
	}


	/**
	 * Returns the unit of the type.
	 * 
	 * @return List<Unit> Returns the unit of the type.
	 * 
	 */
	public List<Unit> getUnit() {
		return unit;
	}

	/**
	 * Sets the unit of the type.
	 * 
	 * @param unit
	 *            The units of the type.
	 * 
	 */
	public void setUnit(final List<Unit> unit) {
		this.unit = unit;
	}

	/**
	 * Adds a unit to the list of units.
	 * 
	 * @param unit
	 *            The unit of the type.
	 * 
	 */
	public void addUnit(final Unit unit) {
		this.unit.add(unit);
	}


	public NumberParameterTypeBehaviour getNumberBehaviour() {
		return numberBehaviour;
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
