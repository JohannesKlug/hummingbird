package org.hbird.business.simulator.waveforms;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class WaveformTest {

	@Test
	public void flatWaveform() {
		FlatWaveform fw = new FlatWaveform(1);
		assertEquals(1, fw.nextValue(), 0.001);
		assertEquals(1, fw.nextValue(), 0.001);
		assertEquals(1, fw.nextValue(), 0.001);
		assertEquals(1, fw.nextValue(), 0.001);

	}

	@Test
	public void linearWaveform() {
		LinearWaveform lw = new LinearWaveform(2, 120d, 10d);
		assertEquals(120.0, lw.nextValue(), 0.001);
		assertEquals(130.0, lw.nextValue(), 0.001);
		assertEquals(120.0, lw.nextValue(), 0.001);
		assertEquals(130.0, lw.nextValue(), 0.001);

	}

	@Test
	public void linearWaveformWithFractions() {
		LinearWaveform lw = new LinearWaveform(5, 0d, 0.25d);
		assertEquals(0.0, lw.nextValue(), 0.001);
		assertEquals(0.25, lw.nextValue(), 0.001);
		assertEquals(0.5, lw.nextValue(), 0.001);
		assertEquals(0.75, lw.nextValue(), 0.001);
		assertEquals(1.0, lw.nextValue(), 0.001);
		assertEquals(0.0, lw.nextValue(), 0.001);

	}

}
