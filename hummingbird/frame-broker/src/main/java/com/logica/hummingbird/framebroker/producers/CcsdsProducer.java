package com.logica.hummingbird.framebroker.producers;

import com.logica.hummingbird.ccsds.TmFrame;
import com.logica.hummingbird.spacesystemmodel.ContainerFactory;
import com.logica.hummingbird.spacesystemmodel.SpaceSystemModelObserver;

public abstract class CcsdsProducer implements SpaceSystemModelObserver {
	
	// FIXME TmFrame being static is not a good design!
	protected static TmFrame frame;
	
	public static TmFrame getFrame() {
		return frame;
	}

	public static void setFrame(TmFrame tmFrame) {
		CcsdsProducer.frame = tmFrame;
	}

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

}
