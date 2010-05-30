package com.logica.hummingbird.framebroker.producers;

import com.logica.hummingbird.ccsds.TmFrame;
import com.logica.hummingbird.framebroker.IContainerFactory;

public abstract class CcsdsProducer implements IProducer {
	
	// FIXME TmFrame being static is not a good design!
	protected static TmFrame frame;
	
	public static TmFrame getFrame() {
		return frame;
	}

	public static void setFrame(TmFrame tmFrame) {
		CcsdsProducer.frame = tmFrame;
	}

	private IContainerFactory containerFactory;

	public CcsdsProducer(IContainerFactory containerFactory) {
		this.setContainerFactory(containerFactory);
	}

	public void setContainerFactory(IContainerFactory containerFactory) {
		this.containerFactory = containerFactory;
	}

	public IContainerFactory getContainerFactory() {
		return containerFactory;
	}

}
