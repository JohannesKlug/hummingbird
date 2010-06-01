package com.logica.hummingbird.framebroker.producers;

import com.logica.hummingbird.ccsds.telemetry.TmFrame;
import com.logica.hummingbird.spacesystemmodel.ContainerFactory;
import com.logica.hummingbird.spacesystemmodel.SpaceSystemModelObserver;

public abstract class CcsdsProducer implements SpaceSystemModelObserver {

	/**
	 * This is a CCSDS TmFrame model which is populated each time the spacesystemmodel
	 * is updated.
	 */
	protected static TmFrame frame;

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

	public static void setFrame(TmFrame tmFrame) {
		CcsdsProducer.frame = tmFrame;
	}

	public static TmFrame getFrame() {
		return frame;
	}

}
