package org.hbird.transport.commons.data;

public class GenericPayload {
	
	public byte[] payload;
	public Object layoutIdentifier;
	
	public GenericPayload(byte[] payload, Object layoutIdentifier) {
		this.payload = payload;
		this.layoutIdentifier = layoutIdentifier;
	}

}
