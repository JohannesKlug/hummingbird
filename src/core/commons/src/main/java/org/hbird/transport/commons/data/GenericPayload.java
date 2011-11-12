package org.hbird.transport.commons.data;

import org.apache.commons.lang.ArrayUtils;

public class GenericPayload {
	
	public byte[] payload;
	public String layoutIdentifier;
	public long timeStamp;
	
	public GenericPayload(byte[] payload, String layoutIdentifier, long timeStamp) {
		this.payload = ArrayUtils.clone(payload);
		this.layoutIdentifier = layoutIdentifier;
		this.timeStamp = timeStamp;
	}

}
