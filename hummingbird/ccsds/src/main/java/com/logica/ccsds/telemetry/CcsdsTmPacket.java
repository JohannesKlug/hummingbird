package com.logica.ccsds.telemetry;

import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CcsdsTmPacket {
	/** Logger for this class */
	private final static Logger LOG = LoggerFactory.getLogger(CcsdsTmPacket.class);
	
	protected String packetName;
	
	CcsdsTmPacketHeader packetHeader = new CcsdsTmPacketHeader();

	CcsdsTmPacketPayload payload = new CcsdsTmPacketPayload();

	
	public CcsdsTmPacket() {
		this.packetName = "Default empty Packet";
	}
	
	public CcsdsTmPacket(String packetName) {
		this.packetName = packetName;
	}

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

	public void setParameterInPacket(CcsdsTmParameter parameter) throws SecurityException, IllegalArgumentException, IllegalAccessException {
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
		builder.append("CcsdsTmPacket [packetName=");
		builder.append(packetName);
		builder.append(", packetHeader=");
		builder.append(packetHeader);
		builder.append(", payload=");
		builder.append(payload);
		builder.append("]");
		return builder.toString();
	}

	public void setName(String field) {
		this.packetName = field;
	}

	public String getPacketName() {
		return packetName;
	}

	public void setPacketName(String packetName) {
		this.packetName = packetName;
	}

}
