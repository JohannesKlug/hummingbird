package org.hbird.simulator.waveforms;

public class LinearWaveform extends WaveformImpl {
	
	private Double fromValue = 0d;
	private Double increment = 0d;
	private int currentReading = 0;

	public LinearWaveform(int readings, Double fromValue, Double increment) {
		super(readings);
		this.fromValue = fromValue;
		this.increment = increment;
	}

	public double nextValue() {
		
		double currentValue = fromValue + (increment * currentReading);
		
		currentReading++;
		
		if (currentReading == readings) {
			currentReading = 0;
		}
		
		return currentValue;
			
	}
		
}