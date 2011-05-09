/**
 * Licensed under the to the Apache License, Version 2.0. You may obtain a copy of 
 * the License at http://www.apache.org/licenses/LICENSE-2.0 or at this project's root.
 */

package org.hbird.transport.packetbroker;

import java.util.BitSet;

import org.hbird.transport.commons.util.exceptions.BitSetOperationException;
import org.hbird.transport.spacesystemmodel.Container;
import org.hbird.transport.spacesystemmodel.ContainerFactory;
import org.hbird.transport.spacesystemmodel.exceptions.UnknownContainerNameException;
import org.hbird.transport.telemetry.HummingbirdPacket;

/**
 * The interface of the Packet Broker.
 * 
 * @author Gert Villemos
 * @author Mark Doyle
 * @author Johannes Klug
 */
public interface PacketBroker {

	/**
	 * Unmarshalls the bit-set using the container identified through the container parameter name. Following the
	 * unmarshalling the 'getContainerFactory' can be used to get a reference to a sub-container.
	 * 
	 * @param container
	 *            The name of the container as registered within the container factory.
	 * @param data
	 *            The data stream from which the data shall be extracted.
	 * @throws UnknownContainerNameException
	 * 
	 */
	void unmarshall(String container, BitSet data) throws UnknownContainerNameException;

	/**
	 * Marshalls the container identified through the container parameter name into the BitSet.
	 * 
	 * @param container
	 *            The name of the container as registered within the container factory.
	 * @param data
	 *            The data stream into which the data shall be marshalled.
	 * @throws UnknownContainerNameException
	 * @throws BitSetOperationException
	 * 
	 */
	void marshall(String container, BitSet data) throws UnknownContainerNameException, BitSetOperationException;

	/**
	 * Marshalls the container identified through the container parameter name into into the String using the container.
	 * 
	 * @param container
	 *            The name of the container as registered within the container factory.
	 * @param String
	 *            The data stream from which the data shall be extracted.
	 * @throws UnknownContainerNameException
	 * 
	 */
	void marshall(String container, String data) throws UnknownContainerNameException;

	/**
	 * Returns a container reference.
	 * 
	 * @param container
	 *            Identifier of the container.
	 * @throws UnknownContainerNameException
	 * @throws Exception
	 * 
	 */
	Container getContainer(String container) throws UnknownContainerNameException;

	HummingbirdPacket getPacket();

	ContainerFactory getFactory();

	void setFactory(ContainerFactory factory);
}
