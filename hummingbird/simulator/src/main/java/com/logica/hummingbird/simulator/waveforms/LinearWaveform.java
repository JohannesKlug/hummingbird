package com.logica.hummingbird.simulator.waveforms;

public class LinearWaveform extends WaveformImpl {
	
	private Number fromValue, increment;
	private int currentReading = 0;

	public LinearWaveform(int readings, Number fromValue, Number increment) {
		super(readings);
		this.fromValue = fromValue;
		this.increment = increment;
	}

	public double nextValue() {
		
		double currentValue = fromValue.doubleValue() + (increment.doubleValue() * currentReading);
		
		currentReading++;
		
		if (currentReading == readings) {
			currentReading = 0;
		}
		
		return currentValue;
			
	}
		
}