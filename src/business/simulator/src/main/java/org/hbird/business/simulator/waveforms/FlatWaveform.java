package org.hbird.business.simulator.waveforms;

public class FlatWaveform extends WaveformImpl {

	private final double value;

	public FlatWaveform(final double value) {
		super(1);
		this.value = value;
	}

	public double nextValue() {
		return value;
	}

}
