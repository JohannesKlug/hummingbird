package org.hbird.transport.protocols.ccsds.spacepacket.data;

import java.io.Serializable;

import org.apache.commons.lang.ArrayUtils;

public class PacketPayload implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1837235324860411156L;
	public int apid;
	public byte[] payload;
	public long timeStamp;
	
	public PacketPayload(int apid, byte[] payload, long timeStamp) {
		this.apid = apid;
		this.payload = ArrayUtils.clone(payload);
		this.timeStamp = timeStamp;
	}
	
	public String toString() {
		return "packet apId: " + apid + ", payload: " + new String(payload) + ", timeStamp: " + timeStamp;
	}

}
