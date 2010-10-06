package com.logica.hummingbird.validation.packet;

import com.logica.hummingbird.validation.TmPacketDummy;




/**
 * Rule class for checking for gaps in the parameter stream.
 * 

 * @author Villemosg
 *
 */
public class SequenceCounterGapCheck extends BasePacketRule {

	/** The counter at which the SSC wraps. The last value is NOT included, i.e. the 
	 * counter goes {0, 1, 2, ... , 65533, 65534, 0, 1, 2, ...}. */
	private int wrapCount = 65535;

	/** The next expected SSC. Calculated based in the last received + 1. If the checker has
	 * been reset, then the value will be 0, but any value will be accepted. */
	protected long expectedSsc = 0;

	/** Markes the gap as reset. A reset gapchecker will automatically return true for
	 * the first packet received. */
	protected boolean initialised = false;

	/** How many packets (based on the SSC) must be lost to trigger the rule? */
	protected long triggerLimit = 1;
	
	public SequenceCounterGapCheck() {
		stateName = "Continiuity";
		ruleName = "Sequence Counter Based Check";
	}
	
	public boolean rule(TmPacketDummy packet) {
		boolean ruleParsed = true;
		
		if (initialised == false) {
			initialised = true;
		}
		else {			
			/** Only trigger an alarm if more packets have been lost than the 
			 * minimum trigger limit. */
			if (triggerLimit <= packet.ssc%getWrapCount() - expectedSsc) {
				ruleParsed = false;	
			}	
		}				
				
		expectedSsc = (packet.ssc + 1)%getWrapCount();
		
		return ruleParsed;
	}

	public void reset() {
		initialised = false;
	}

	public long getTriggerLimit() {
		return triggerLimit;
	}

	public void setTriggerLimit(long triggerLimit) {
		this.triggerLimit = triggerLimit;
	}

	public void setWrapCount(int wrapCount) {
		this.wrapCount = wrapCount;
	}

	public int getWrapCount() {
		return wrapCount;
	}
}
