package com.logica.hummingbird.validation.packet;

import com.logica.hummingbird.validation.TmPacketDummy;

public class PeriodicTimeGapCheck extends BasePacketRule {

	protected long lastSsc = 0;
	protected long currentSsc = 0;
	
	protected TmPacketDummy packet = null;
	
	public PeriodicTimeGapCheck() {
		stateName = "Continiuity";
		ruleName = "Packet Periodicity Based Check";
	}

	public boolean rule(TmPacketDummy packet) {		
		currentSsc = packet.ssc;
		this.packet = packet;
		return true;
	}
	
	public void run() {		
		forward(lastSsc != currentSsc, packet);		
		lastSsc = currentSsc;
	}
}
