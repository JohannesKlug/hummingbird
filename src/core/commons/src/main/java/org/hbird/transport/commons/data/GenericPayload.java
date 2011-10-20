package org.hbird.transport.commons.data;

public class GenericPayload {
	
	public byte[] payload;
	public String layoutIdentifier;
	
	public GenericPayload(byte[] payload, String layoutIdentifier) {
		this.payload = payload;
		this.layoutIdentifier = layoutIdentifier;
	}

}
