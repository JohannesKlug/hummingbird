package org.hbird.packetbroker.producers;

import org.hbird.spacesystemmodel.ContainerFactory;
import org.hbird.telemetry.HummingbirdPacket;
import org.hbird.telemetry.DefaultSpacePacket;

public abstract class AbstractProducer {

	/**
	 * This is a CCSDS TmFrame model which is populated each time the spacesystemmodel
	 * is updated.
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
}
