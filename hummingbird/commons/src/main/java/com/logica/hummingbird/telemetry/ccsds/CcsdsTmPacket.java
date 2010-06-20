package com.logica.hummingbird.telemetry.ccsds;

import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CcsdsTmPacket {
	/** Logger for this class */
	private final static Logger LOG = LoggerFactory.getLogger(CcsdsTmPacket.class);
	
	CcsdsTmPacketHeader packetHeader = new CcsdsTmPacketHeader();

	CcsdsTmPacketPayload payload = new CcsdsTmPacketPayload();

	public CcsdsTmPacketHeader getHeader() {
		return this.packetHeader;
	}

	public CcsdsTmPacketPayload getPayload() {
		return this.payload;
	}

	public void setHeader(CcsdsTmPacketHeader header) {
		this.packetHeader = header;
	}

	public void setPayload(CcsdsTmPacketPayload payload) {
		this.payload = payload;
	}

	public void setParameterInPacket(CcsdsTmNumberParameter parameter) throws SecurityException, IllegalArgumentException, IllegalAccessException {
		String name = parameter.getName();

		Class<? extends CcsdsTmPacketHeader> headerClass = this.packetHeader.getClass();
		Class<? extends CcsdsTmPacketPayload> payloadClass = this.payload.getClass();

		// Check the packet header for a parameter of this name
		Field field;
		try {
			field = headerClass.getDeclaredField(name);
			if (field != null) {
				field.set(this.packetHeader, parameter.getValue());
				return;
			}
		}
		catch (NoSuchFieldException e) {
			if(LOG.isDebugEnabled()) {
				LOG.debug(parameter.getName() + " is not a field of this Packet header.  Checking the payload");
			}
		}

		// Must be a payload parameter to set it there
		payload.addParameter(parameter);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CcsdsTmPacket [\n\tpacketHeader = ");
		builder.append(packetHeader);
		builder.append("\n\tpayload = ");
		builder.append(payload);
		builder.append("\n]");
		return builder.toString();
	}
}
