package org.hbird.transport.protocols.ccsds.transferframe.typeconverters;

import org.apache.camel.Converter;
import org.hbird.transport.commons.data.GenericPayload;
import org.hbird.transport.protocols.ccsds.spacepacket.data.PacketPayload;

@Converter
public class ToGenericPayloadConverter {
	
	@Converter
	public static GenericPayload fromCcsdsPacketPayload(PacketPayload payload) {
		return new GenericPayload(payload.payload, String.valueOf(payload.apid));
	}
	
	@Converter
	public static PacketPayload fromGenericPayload(GenericPayload payload) {
		if (payload.layoutIdentifier != null) {
			Integer apid = 0;
			try {
				apid = Integer.parseInt(payload.layoutIdentifier);
			}
			catch (NumberFormatException e) {
				return null;
			}
			return new PacketPayload(apid, payload.payload);
		}
		return null; 
	}

}
