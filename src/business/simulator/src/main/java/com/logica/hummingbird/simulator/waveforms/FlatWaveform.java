package org.hbird.simulator.waveforms;

public class FlatWaveform extends WaveformImpl {
	
	
	private double value;
	
	public FlatWaveform(int readings, double value) {
		super(readings);
		this.value = value;
	}

	public double nextValue() {
		return value;
	}


	

}
