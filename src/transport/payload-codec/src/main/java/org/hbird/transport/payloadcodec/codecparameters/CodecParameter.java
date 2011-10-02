package org.hbird.transport.payloadcodec.codecparameters;

import java.util.BitSet;

import org.hbird.transport.spacesystemmodel.parameters.Parameter;

/**
 * Parameter Decorator.
 * 
 * @author Mark Doyle
 * 
 * @param <T>
 */
public abstract class CodecParameter<T> implements Parameter<T> {

	protected Parameter<T> parameter;

	public CodecParameter(final Parameter<T> hostParameter) {
		this.parameter = hostParameter;
	}

	public abstract void decode(Byte[] inBytes);

	public abstract void decode(BitSet inBitset);

	public abstract Byte[] encodeToByteArray(T value);

	public abstract BitSet encodeToBitSet(BitSet out, int offset);
	

	// Pass through methods which the Codec Parameter does not need to alter in it's decoration.
	// ----------------------------------------------------------------------------------------

	@Override
	public int getSizeInBits() {
		return parameter.getSizeInBits();
	}


	@Override
	public Endianness getEndianness() {
		return parameter.getEndianness();
	}


	@Override
	public Encoding getEncoding() {
		return parameter.getEncoding();
	}


	@Override
	public boolean isValue(final Object obj) {
		return parameter.isValue(obj);
	}


	@Override
	public String getName() {
		return parameter.getName();
	}


	@Override
	public String getShortDescription() {
		return parameter.getShortDescription();
	}


	@Override
	public String getLongDescription() {
		return parameter.getLongDescription();
	}

	@Override
	public T getValue() {
		return parameter.getValue();
	}

	@Override
	public void setValue(final T value) {
		parameter.setValue(value);
	}
}
