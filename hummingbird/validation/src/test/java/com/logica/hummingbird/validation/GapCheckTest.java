package com.logica.hummingbird.validation;

import com.logica.hummingbird.validation.packet.SequenceCounterGapCheck;

import junit.framework.TestCase;

public class GapCheckTest extends TestCase {

	public void testWrap() {

		SequenceCounterGapCheck check = new SequenceCounterGapCheck(); 

		// Iterate through packets until we wrap, to test wrapping.
		TmPacketDummy packet = new TmPacketDummy(0, 0);

		/** Count upto wrap point. */
		for (long counter = 10; counter < check.getWrapCount() + 100; counter++) {
			if (counter <= check.getWrapCount()) {
				packet.ssc = counter;
				packet.timestamp = counter;
			}
			else {
				packet.ssc = counter - check.getWrapCount();
				packet.timestamp = counter - check.getWrapCount();
			}

			assertTrue("Assertion failed for counter " + packet.ssc, check.rule(packet) == true);
		}
	}

	public void testSingleGapLimit() {
		SequenceCounterGapCheck check = new SequenceCounterGapCheck();

		// Create packet list with gaps
		/** Start sending telemetry*/
		for (long counter = 0; counter < 100; counter++) {
			/** At specific counters, create one gap. */
			if (counter == 20) {
				counter++;
				assertTrue(check.rule(new TmPacketDummy(counter, 10)) == false);
			}
			/** At specific counters, create multiple gaps. */
			else if (counter == 40) {
				counter = counter + 3;
				assertTrue(check.rule(new TmPacketDummy(counter, 10)) == false);
			}			
			else {
				assertTrue(check.rule(new TmPacketDummy(counter, 10)) == true);			
			}
		}
	}
	
	public void testMultiGapLimit() {
		SequenceCounterGapCheck check = new SequenceCounterGapCheck();
		check.setTriggerLimit(3);
		
		// Create packet list with gaps
		/** Start sending telemetry*/
		for (long counter = 0; counter < 100; counter++) {
			/** At specific counters, create one gap. */
			if (counter == 20) {
				counter++;
				assertTrue(check.rule(new TmPacketDummy(counter, 10)) == true);
			}
			/** At specific counters, create multiple gaps. */
			else if (counter == 40) {
				counter = counter + 2;
				assertTrue(check.rule(new TmPacketDummy(counter, 10)) == true);
			}
			else if (counter == 60) {
				counter = counter + 3;
				assertTrue(check.rule(new TmPacketDummy(counter, 10)) == false);
			}
			else if (counter == 80) {
				counter = counter + 4;
				assertTrue(check.rule(new TmPacketDummy(counter, 10)) == false);
			}			
			else {
				assertTrue("Failed for counter " + counter, check.rule(new TmPacketDummy(counter, 10)) == true);			
			}
		}		
	}
}
