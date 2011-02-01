package org.hbird.transport.protocols.ccsds.spacepacket;

import org.apache.commons.lang.ArrayUtils;

public class PacketPayload {
	public int apid;
	public byte[] payload;
	
	public PacketPayload(int apid, byte[] payload) {
		this.apid = apid;
		this.payload = ArrayUtils.clone(payload);
	}
	
	public String toString() {
		return "packet apId: " + apid + ", payload: " + new String(payload);
	}

}
