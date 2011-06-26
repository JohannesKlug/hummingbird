package org.hbird.transport.packetbroker.parameterbehaviours;

public abstract class AbstractIntegerBehaviour extends AbstractNumberBehaviour {

	public AbstractIntegerBehaviour(int sizeInBits, boolean isBigEndian) {
		super(sizeInBits, isBigEndian);
	}

}
