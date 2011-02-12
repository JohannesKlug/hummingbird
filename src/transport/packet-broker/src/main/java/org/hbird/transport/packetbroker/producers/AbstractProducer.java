package org.hbird.transport.packetbroker.producers;

import org.hbird.transport.spacesystemmodel.ContainerFactory;
import org.hbird.transport.telemetry.DefaultSpacePacket;
import org.hbird.transport.telemetry.HummingbirdPacket;

public abstract class AbstractProducer {

	/**
	 * TODO Comment? What the hell is it? haha This is a Space system model instantiation which is populated each time
	 * the spacesystemmodel is updated.
	 */
	private ContainerFactory containerFactory;

	protected HummingbirdPacket packet = new DefaultSpacePacket();

	public AbstractProducer(ContainerFactory containerFactory) {
		this.setContainerFactory(containerFactory);
	}

	public void setContainerFactory(ContainerFactory containerFactory) {
		this.containerFactory = containerFactory;
	}

	public ContainerFactory getContainerFactory() {
		return containerFactory;
	}

	public HummingbirdPacket getPacket() {
		return packet;
	}

	public void clearPacket() {
		packet = new DefaultSpacePacket();
	}
}
