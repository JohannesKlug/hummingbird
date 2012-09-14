package org.hbird.transport.protocols.ip.udp;

import java.net.InetSocketAddress;

import org.apache.camel.Header;
import org.apache.mina.common.IoSession;
import org.hbird.core.commons.data.GenericPayload;

public class MinaUdpToGenericPayloadReceiver {

	/**
	 * Processes a {@link GenericPayload} object give a Camel Mina UDP datagram and session using
	 * the source IP address as the payload layout identifier.
	 * @param datagram UDP payload
	 * @param ioSession
	 * @return {@link GenericPayload}
	 */
	public static GenericPayload fromIpBasedPayloadIdentifier(final byte[] datagram, @Header("CamelMinaIoSession") final IoSession ioSession) {
		final InetSocketAddress sockadd = (InetSocketAddress)ioSession.getLocalAddress();
		final String ipAddress = sockadd.getAddress().getHostAddress();

		final GenericPayload packetPayload = new GenericPayload(datagram, ipAddress,  System.currentTimeMillis());
		return packetPayload;
	}
}