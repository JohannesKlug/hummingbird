package com.logica.hummingbird.validation.base;


/**
 * Handler which only triggers the next downstream handler if a specific number
 * of violations have occured in a configurable time interval.
 * 
 * The handler will issue a separate warning for each violation after the 
 * 
 * 
 * @author Villemosg
 *
 */
public class ViolationCountFilter implements ISender {

	protected ISender sender = null;
	
	/** The number of consequitive violations. Will be reset to 0 when the first non-violation is received. */
	protected long violations = 0;

	/** Flag setting whether all states recalculation should be stored. */
	protected boolean storeOnlyChanges = true;
	
	/** Limit when to trigger the next downstream handler. Default value is 2 because a value 
	 * of 1 is the same as no limit handler... */
	protected long triggerLimit = 2;

	public void send(String stateName, boolean stateValue) {
		if (stateValue == false) {
			violations++;

			if (violations >= triggerLimit) {
				sender.send(stateName, stateValue);
			}
			else {
				/** TODO issue log message that violation has been ignored. */
			}
		}
		else {
			/** In case teh state is valid, then all violations are cleared. */
			violations = 0;
			sender.send(stateName, stateValue);
		}
	}

	public void reset() {
		violations = 0;
	}

	public long getViolations() {
		return violations;
	}

	public void setViolations(long violations) {
		this.violations = violations;
	}

	public long getTriggerLimit() {
		return triggerLimit;
	}

	public void setTriggerLimit(long triggerLimit) {
		this.triggerLimit = triggerLimit;
	}

	public ISender getSender() {
		return sender;
	}

	public void setSender(ISender sender) {
		this.sender = sender;
	}

	public boolean isStoreOnlyChanges() {
		return storeOnlyChanges;
	}

	public void setStoreOnlyChanges(boolean storeOnlyChanges) {
		this.storeOnlyChanges = storeOnlyChanges;
	}
}
