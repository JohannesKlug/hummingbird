package org.hbird.transport.protocols.ccsds.transferframe.typeconverters;

import org.apache.camel.Converter;
import org.hbird.transport.commons.data.GenericPayload;
import org.hbird.transport.protocols.ccsds.spacepacket.data.PacketPayload;

@Converter
public class CcsdsPacketPayloadToGenericPayloadConverter {
	
	@Converter
	public static GenericPayload fromCcsdsPacketPayload(PacketPayload payload) {
		return new GenericPayload(payload.payload, payload.apid);
	}

}
