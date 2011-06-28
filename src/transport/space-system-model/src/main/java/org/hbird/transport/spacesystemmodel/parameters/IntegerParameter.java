package org.hbird.transport.spacesystemmodel.parameters;

import org.hbird.transport.spacesystemmodel.parameters.types.ParameterType;

public class IntegerParameter extends DefaultParameter<Integer> {

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
	public IntegerParameter(final String name, final String shortDescription, final String longDescription, final ParameterType type, final int value) {
		super(name, shortDescription, longDescription, type);
		this.setValue(value);
	}

	@Override
	public boolean match(final String value) {
		return (this.getValue().intValue() == Integer.parseInt(value));
	}


}


// @Override
// public BitSet unmarshall(BitSet packet) {
// if (LOG.isDebugEnabled()) {
// LOG.debug("Unmarshalling " + this.name + " from packet : " + packet);
// }
//
// // Extract this Integer form the given binary bitset.
// value = this.type.getNumberBehaviour().valueFromBitSet(packet);
//
// // Notify all our observers that the value has changed.
// for (ParameterObserver paramObserver : updatedParameterObservers) {
// paramObserver.updated(name, value.intValue(), shortDescription, longDescription);
// }
//
// // Chop off this integer parameter because it has now been unmarshalled
// if (LOG.isDebugEnabled()) {
// LOG.debug("Bitset before post unmarshall chop = " + BitSetUtility.binDump(packet));
// }
// BitSet returnPacket = packet.get((int) type.getSizeInBits(), packet.length() + 1);
// if (LOG.isDebugEnabled()) {
// LOG.debug("Bitset after post unmarshall chop = " + BitSetUtility.binDump(returnPacket));
// }
// // Return the rest of the binary bitset to the calling container
// return returnPacket;
// }
//
// @Override
// public int marshall(BitSet packet, int offset) throws BitSetOperationException {
// packet = this.type.getNumberBehaviour().insertIntoBitSet(getValue(), packet, offset);
//
// return offset + (int) type.getSizeInBits();
// }
