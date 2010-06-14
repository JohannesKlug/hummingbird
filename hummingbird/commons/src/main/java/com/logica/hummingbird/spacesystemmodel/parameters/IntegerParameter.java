package com.logica.hummingbird.spacesystemmodel.parameters;

import java.util.BitSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.logica.hummingbird.spacesystemmodel.ParameterObserver;
import com.logica.hummingbird.spacesystemmodel.parameters.types.NumberParameterType;
import com.logica.hummingbird.util.BitSetUtility;

public class IntegerParameter extends ParameterContainer {
	private static final Logger LOG = LoggerFactory.getLogger(IntegerParameter.class);

	/**
	 * The value of the integer. It must be of type Long, since Hummingbird supports 64bit Integers.
	 * */
	protected Long value = 0L;

	/**
	 * Constructor of the IntegerParameter class.
	 * 
	 * @param name
	 *            The name of the container. Used as the unique identifier of the container.
	 * @param shortDescription
	 *            A one-line description, tooltip style, of the container.
	 * @param longDescription
	 *            A full description of the container, help style.
	 * @param NumberParameterType
	 *            The type of the container. The type defines the length and behaviour of the parameter.
	 * @param value
	 *            The initial value.
	 */
	public IntegerParameter(String name, String shortDescription, String longDescription, NumberParameterType type, long value) {
		super(name, shortDescription, longDescription, type);
		this.value = value;
	}

	@Override
	public BitSet unmarshall(BitSet packet) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Unmarshalling " + this.name + " from packet : " + packet);
		}

		value = BitSetUtility.extractInteger(packet, 0, (int) type.getSizeInBits(), type.isSigned());

		for (ParameterObserver paramObserver : updatedParameterObservers) {
			paramObserver.updated(name, value);
		}

		BitSet returnPacket = packet.get((int) type.getSizeInBits(), packet.length());
		return returnPacket;
	}

	@Override
	public int marshall(BitSet packet, int offset) {
		try {
			BitSetUtility.insertInteger(packet, offset, (int) type.getSizeInBits(), value);
		}
		catch (RuntimeException e) {
			LOG.error("Error encoding parameter '" + this.name + "'. The value '" + this.value + "' cannot be encoded in " + type.getSizeInBits() + " bit(s).");
		}

		return offset + (int) type.getSizeInBits();
	}

	@Override
	public String toString() {
		return "[int (" + this.type.getSizeInBits() + ") " + this.name + "=" + this.value + "]";
	}

	@Override
	public Number getValue() {
		return value;
	}

	@Override
	public boolean match(String value) {
		return (this.value == Integer.parseInt(value));
	}

	@Override
	public void setValue(double value) {
		this.value = (long) value;
	}
}
