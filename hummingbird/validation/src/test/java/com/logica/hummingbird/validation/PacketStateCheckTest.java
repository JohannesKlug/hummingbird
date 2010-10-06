package com.logica.hummingbird.validation;


import com.logica.hummingbird.validation.base.OnlyChangeFilter;
import com.logica.hummingbird.validation.base.ViolationCountFilter;
import com.logica.hummingbird.validation.packet.Packet;
import com.logica.hummingbird.validation.packet.PeriodicTimeGapCheck;
import com.logica.hummingbird.validation.packet.SequenceCounterGapCheck;

import junit.framework.TestCase;

public class PacketStateCheckTest extends TestCase {

	
	
	/**
	 *  @USERSTORY As an operator I can get notifications in case gaps are detected in the packet stream, so that I can passivly monitor the data flow.
	 */
	public void testCounterBasedPacketValidation() {
		/** Create the packets. */
		Packet packet1 = new Packet();
		Packet packet2 = new Packet();

		/** Create rules. */
		SequenceCounterGapCheck sscGapCheckPacket1 = new SequenceCounterGapCheck();
		SequenceCounterGapCheck sscGapCheckPacket2 = new SequenceCounterGapCheck();
		PeriodicTimeGapCheck periodicCheck = new PeriodicTimeGapCheck();

		/** Add the rules. */
		packet1.addRule(sscGapCheckPacket1);
		packet2.addRule(sscGapCheckPacket2);
		packet2.addRule(periodicCheck);

		/** Setup two handlers. */
		ViolationCountFilter handler1 = new ViolationCountFilter();
		ViolationCountFilter handler2 = new ViolationCountFilter();

		sscGapCheckPacket1.setSender(handler1);
		sscGapCheckPacket2.setSender(handler2);
		periodicCheck.setSender(handler2);

		OnlyChangeFilter onlyChangeFilter = new OnlyChangeFilter(); 
		
		handler1.setSender(onlyChangeFilter);
		handler2.setSender(onlyChangeFilter);

		DummySender sender = new DummySender();
		onlyChangeFilter.setSender(sender);


		
		
		/** Start sending telemetry*/
		for (long counter = 0; counter < 100; counter++) {

			if (counter == 0) {
				/** the first time the state change will be send. */
				packet1.check(new TmPacketDummy(counter, 10));
				packet2.check(new TmPacketDummy(counter, 10));
				assertTrue("Failed for counter " + counter, handler1.getViolations() == 0);
				assertTrue("Failed for counter " + counter, handler2.getViolations() == 0);
				assertTrue("Failed for counter " + counter, sender.sendCalled == true);
				sender.sendCalled = false;
			}
			/** At specific counters, create one gap in packet 1. */
			else if (counter == 20) {
				packet2.check(new TmPacketDummy(counter, 10));
				counter++;
				
				packet1.check(new TmPacketDummy(counter, 10));
				packet2.check(new TmPacketDummy(counter, 10));
				assertTrue(handler1.getViolations() == 1);
				assertTrue(handler2.getViolations() == 0);
				assertTrue(sender.sendCalled == false); 
			}
			/** At specific counters, create multiple gaps. */
			else if (counter == 40) {
				packet2.check(new TmPacketDummy(counter, 10));
				counter++;
				packet2.check(new TmPacketDummy(counter, 10));
				counter++;
				packet2.check(new TmPacketDummy(counter, 10));
				counter++;
				packet2.check(new TmPacketDummy(counter, 10));

				
				packet1.check(new TmPacketDummy(counter, 10));
				assertTrue(handler1.getViolations() == 1);
				assertTrue(handler2.getViolations() == 0);
				assertTrue(sender.sendCalled == false);						
			}
			else if (counter == 60) {

				periodicCheck.run();
				
				periodicCheck.run();
				assertTrue("Failed for counter " + counter, handler1.getViolations() == 0);
				assertTrue("Failed for counter " + counter, handler2.getViolations() == 1);
				assertTrue("Failed for counter " + counter, sender.sendCalled == false);

				periodicCheck.run();
				assertTrue("Failed for counter " + counter, handler1.getViolations() == 0);
				assertTrue("Failed for counter " + counter, handler2.getViolations() == 2);
				assertTrue("Failed for counter " + counter, sender.sendCalled == true);
				sender.sendCalled = false;
				
				packet1.check(new TmPacketDummy(counter, 10));
				packet2.check(new TmPacketDummy(counter, 10));
				sender.sendCalled = false;
			}
			else {
				packet1.check(new TmPacketDummy(counter, 10));
				packet2.check(new TmPacketDummy(counter, 10));
				assertTrue("Failed for counter " + counter, handler1.getViolations() == 0);
				assertTrue("Failed for counter " + counter, handler2.getViolations() == 0);
				assertTrue("Failed for counter " + counter, sender.sendCalled == false);
			}
		}
		
	}

}
