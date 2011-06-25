package org.hbird.transport.packetbroker.producers;

import org.hbird.transport.spacesystemmodel.SpaceSystemModelFactory;
import org.hbird.transport.telemetry.DefaultSpacePacket;
import org.hbird.transport.telemetry.HummingbirdPacket;

public abstract class AbstractProducer {

	/**
	 * TODO Comment? What the hell is it? haha This is a Space system model instantiation which is populated each time
	 * the spacesystemmodel is updated.
	 */
	private SpaceSystemModelFactory containerFactory;

	protected HummingbirdPacket packet = new DefaultSpacePacket();

	public AbstractProducer(SpaceSystemModelFactory containerFactory) {
		this.setContainerFactory(containerFactory);
	}

	public void setContainerFactory(SpaceSystemModelFactory containerFactory) {
		this.containerFactory = containerFactory;
	}

	public SpaceSystemModelFactory getContainerFactory() {
		return containerFactory;
	}

	public HummingbirdPacket getPacket() {
		return packet;
	}

	public void clearPacket() {
		packet = new DefaultSpacePacket();
	}
}
