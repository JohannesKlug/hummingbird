package org.hbird.transport.protocols.ccsds.transferframe.data;

import java.io.Serializable;

import org.apache.commons.lang.ArrayUtils;

public class FramePayload implements Serializable {
	private static final long serialVersionUID = -4445554350294779460L;

	public byte[] payload;
	public boolean isNextFrame;
	public long timeStamp;

	public FramePayload(final byte[] payload, final boolean isNextFrame, final long timeStamp) {
		this.payload = ArrayUtils.clone(payload);
		this.isNextFrame = isNextFrame;
		this.timeStamp = timeStamp;
	}

}
