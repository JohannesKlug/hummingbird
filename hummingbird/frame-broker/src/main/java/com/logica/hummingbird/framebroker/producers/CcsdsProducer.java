package com.logica.hummingbird.framebroker.producers;

import com.logica.ccsds.telemetry.CcsdsTmPacket;
import com.logica.hummingbird.spacesystemmodel.ContainerFactory;

public abstract class CcsdsProducer {

	/**
	 * This is a CCSDS TmFrame model which is populated each time the spacesystemmodel
	 * is updated.
	 */
	private ContainerFactory containerFactory;
	
	protected CcsdsTmPacket packet = new CcsdsTmPacket();

	public CcsdsProducer(ContainerFactory containerFactory) {
		this.setContainerFactory(containerFactory);
	}

	public void setContainerFactory(ContainerFactory containerFactory) {
		this.containerFactory = containerFactory;
	}

	public ContainerFactory getContainerFactory() {
		return containerFactory;
	}

	public CcsdsTmPacket getPacket() {
		return packet;
	}
}
