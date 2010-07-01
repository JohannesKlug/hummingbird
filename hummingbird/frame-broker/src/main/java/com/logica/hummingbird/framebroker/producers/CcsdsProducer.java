package com.logica.hummingbird.framebroker.producers;

import com.logica.ccsds.telemetry.CcsdsTmFrame;
import com.logica.hummingbird.spacesystemmodel.ContainerFactory;

public abstract class CcsdsProducer {

	/**
	 * This is a CCSDS TmFrame model which is populated each time the spacesystemmodel
	 * is updated.
	 */
	protected CcsdsTmFrame tmFrame = new CcsdsTmFrame();

	private ContainerFactory containerFactory;

	public CcsdsProducer(ContainerFactory containerFactory) {
		this.setContainerFactory(containerFactory);
	}

	public void setContainerFactory(ContainerFactory containerFactory) {
		this.containerFactory = containerFactory;
	}

	public ContainerFactory getContainerFactory() {
		return containerFactory;
	}

	public void setFrame(CcsdsTmFrame tmFrame) {
		this.tmFrame = tmFrame;
	}

	public CcsdsTmFrame getTmFrame() {
		return tmFrame;
	}

}
