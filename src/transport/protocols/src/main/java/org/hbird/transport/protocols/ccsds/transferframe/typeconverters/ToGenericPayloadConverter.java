package org.hbird.transport.protocols.ccsds.transferframe.typeconverters;

import org.apache.camel.Converter;
import org.hbird.core.commons.data.GenericPayload;
import org.hbird.transport.protocols.ccsds.spacepacket.data.PacketPayload;

@Converter
public class ToGenericPayloadConverter {

	@Converter
	public static GenericPayload fromCcsdsPacketPayload(final PacketPayload payload) {
		return new GenericPayload(payload.payload, String.valueOf(payload.payloadIdentifier), payload.timeStamp);
	}

	@Converter
	public static PacketPayload fromGenericPayload(final GenericPayload payload) {
		if (payload.layoutIdentifier != null) {
			Integer apid = 0;
			try {
				apid = Integer.parseInt(payload.layoutIdentifier);
			}
			catch (final NumberFormatException e) {
				return null;
			}
			return new PacketPayload(apid, payload.payload, payload.timeStamp);
		}
		return null;
	}

}
