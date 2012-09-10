package org.hbird.transport.payloadcodec.codecparameters;

import java.util.BitSet;

import org.hbird.core.commons.tmtc.Parameter;
import org.hbird.core.spacesystemmodel.encoding.Encoding;

/**
 * Parameter Decorator.
 *
 * @author Mark Doyle
 *
 * @param <T>
 */
public abstract class CodecParameter<T> implements Parameter<T> {
	private static final long serialVersionUID = 6597747873295079865L;

	protected Parameter<T> parameter;

	protected Encoding encoding;

	public CodecParameter(final Parameter<T> hostParameter, final Encoding encoding) {
		this.parameter = hostParameter;
		this.encoding = encoding;
	}

	/**
	 * TODO Javadoc
	 * @param inBytes
	 * @param offset
	 */
	public abstract void decode(byte[] inBytes, int offset);

	/**
	 * TODO Javadoc
	 * @param inBitset
	 * @param offset
	 */
	public abstract void decode(BitSet inBitset, int offset);

	/**
	 * TODO javadoc
	 * @param targetBytes
	 * @param offset
	 * @return
	 */
	public abstract byte[] encodeToByteArray(byte[] targetBytes, int offset);

	/**
	 * TODO javadoc
	 * @param targetBitSet
	 * @param offset
	 * @return
	 */
	public abstract BitSet encodeToBitSet(BitSet targetBitSet, int offset);

	// Pass through methods which the Codec Parameter does not need to alter in it's decoration.
	// ----------------------------------------------------------------------------------------

	@Override
	public String getQualifiedName() {
		return parameter.getQualifiedName();
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

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("CodecParameter [parameter=");
		builder.append(parameter);
		builder.append("]");
		return builder.toString();
	}

	public void setEncoding(final Encoding encoding) {
		this.encoding = encoding;
	}

	@Override
	public long getReceivedTime() {
		return this.parameter.getReceivedTime();
	}

	@Override
	public void setReceivedTime(final long timestamp) {
		this.parameter.setReceivedTime(timestamp);
	}

	@Override
	public boolean isReadOnly() {
		return this.parameter.isReadOnly();
	}
}
