package com.logica.hummingbird.simulator.waveforms;

public abstract class WaveformImpl implements Waveform {
	
	protected int readings;
	
	public WaveformImpl(int readings) {
		this.readings = readings;
	}

	public int getReadings() {
		return readings;
	}

}
