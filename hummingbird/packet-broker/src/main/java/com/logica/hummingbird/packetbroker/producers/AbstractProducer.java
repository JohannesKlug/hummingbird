package com.logica.hummingbird.packetbroker.producers;

import com.logica.hummingbird.spacesystemmodel.ContainerFactory;
import com.logica.hummingbird.telemetry.HummingbirdPacket;
import com.logica.hummingbird.telemetry.Packet;

public abstract class AbstractProducer {

	/**
	 * This is a CCSDS TmFrame model which is populated each time the spacesystemmodel
	 * is updated.
	 */
	private ContainerFactory containerFactory;
	
	protected HummingbirdPacket packet = new Packet();

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
