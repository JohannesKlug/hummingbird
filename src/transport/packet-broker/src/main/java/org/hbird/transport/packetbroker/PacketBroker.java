/**
 * Licensed under the Apache License, Version 2.0. You may obtain a copy of 
 * the License at http://www.apache.org/licenses/LICENSE-2.0 or at this project's root.
 */

package org.hbird.transport.packetbroker;

import java.util.BitSet;

import org.hbird.transport.commons.util.exceptions.BitSetOperationException;
import org.hbird.transport.spacesystemmodel.ParameterGroup;
import org.hbird.transport.spacesystemmodel.SpaceSystemModel;
import org.hbird.transport.spacesystemmodel.exceptions.UnknownParameterGroupException;
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
	 * @throws UnknownParameterGroupException
	 * 
	 */
	void unmarshall(String container, BitSet data) throws UnknownParameterGroupException;

	/**
	 * Marshalls the container identified through the container parameter name into the BitSet.
	 * 
	 * @param container
	 *            The name of the container as registered within the container factory.
	 * @param data
	 *            The data stream into which the data shall be marshalled.
	 * @throws UnknownParameterGroupException
	 * @throws BitSetOperationException
	 * 
	 */
	void marshall(String container, BitSet data) throws UnknownParameterGroupException, BitSetOperationException;

	/**
	 * Marshalls the container identified through the container parameter name into into the String using the container.
	 * 
	 * @param container
	 *            The name of the container as registered within the container factory.
	 * @param String
	 *            The data stream from which the data shall be extracted.
	 * @throws UnknownParameterGroupException
	 * 
	 */
	void marshall(String container, String data) throws UnknownParameterGroupException;

	/**
	 * Returns a container reference.
	 * 
	 * @param container
	 *            Identifier of the container.
	 * @throws UnknownParameterGroupException
	 * @throws Exception
	 * 
	 */
	ParameterGroup getContainer(String container) throws UnknownParameterGroupException;

	HummingbirdPacket getPacket();

	SpaceSystemModel getFactory();

	void setFactory(SpaceSystemModel factory);
}
