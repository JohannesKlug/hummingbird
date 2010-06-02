package com.logica.hummingbird.spacesystemmodel.testsupport;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.logica.hummingbird.spacesystemmodel.ContainerImpl;
import com.logica.hummingbird.spacesystemmodel.Container;
import com.logica.hummingbird.spacesystemmodel.ContainerFactory;
import com.logica.hummingbird.spacesystemmodel.exceptions.UnknownContainerNameException;
import com.logica.hummingbird.spacesystemmodel.parameters.FloatParameter;
import com.logica.hummingbird.spacesystemmodel.parameters.IntegerParameter;
import com.logica.hummingbird.spacesystemmodel.parameters.ParameterImpl;
import com.logica.hummingbird.spacesystemmodel.parameters.ParameterType;
import com.logica.hummingbird.spacesystemmodel.parameters.ParameterType.eParameterType;

/**
 * This class is used for testing the Container model and anything that uses the SpaceSystemModel. It is a simple
 * Container model representing a space system which can be populated with values by tests. The container model follows
 * the CCSDS standards and therefore uses the TMFrame, TMFrameHeader, TMPacket, and a TMFrameTail concepts. They can go
 * by any name since they are accessed using the constants X_ALIAS defined in the class.
 * 
 * @author Mark Doyle <markjohndoyle@googlemail.com>, <mark.doyle@logica.com>
 * @since Hummingbird 0.0.1
 */
public class MockContainerModelFactory implements ContainerFactory {
	/**
	 * Logger for this class
	 */
	public static final Logger LOG = LoggerFactory.getLogger(MockContainerModelFactory.class);

	/**
	 * MockSpaceSystemModel's telemetry frame alias
	 */
	public static final String TM_FRAME_ALIAS = "TMFrame";

	/**
	 * MockSpaceSystemModel's telemetry packet body alias
	 */
	public static final String TM_PACKET_BODY_ALIAS = "TMPacketBody";

	/**
	 * MockSpaceSystemModel's telemetry frame header alias
	 */
	public static final String TM_PACKET_HEADER_ALIAS = "TMPacketHeader";

	/**
	 * MockSpaceSystemModel's telemetry frame tail alias
	 */
	public static final String TM_FRAME_TAIL_ALIAS = "TMFrameTail";

	/**
	 * MockSpaceSystemModel's telemetry packet alias
	 */
	public static final String TM_PACKET_ALIAS = "TMPacket";

	/**
	 * MockSpaceSystemModel's telemetry packet header alias
	 */
	public static final String TM_FRAME_HEADER_ALIAS = "TMFrameHeader";

	public static final String TEST_PARAM_A = "TestParamA";

	public static final String TEST_PARAM_B = "TestParamB";

	public static final String PACKET_ID_NAME = "ApId";

	public static final String PACKET_TYPE_B_ID = "333";

	public static final String PACKET_TYPE_A_ID = "555";

	private Map<String, ContainerImpl> containers = new HashMap<String, ContainerImpl>();
	private Map<String, ParameterImpl> parameters = new HashMap<String, ParameterImpl>();

	public MockContainerModelFactory() {
		initialise();
	}

	/**
	 * Creates an operational mock Container hierarchy which is used by the FrameBroker.
	 * 
	 */
	private void initialise() {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Beginning initialisation of container model mock up");
		}

		/** Build the upper frame skeleton of the Model **/
		// Create the Frame, header, packet and tail and add them to the
		// containers collection
		ContainerImpl tmFrame = new ContainerImpl(TM_FRAME_ALIAS, "Test frame", "Test TM frame for unit testing");
		this.addToContainers(tmFrame);
		ContainerImpl tmHeader = new ContainerImpl(TM_FRAME_HEADER_ALIAS, "Test header", "Test TM header for unit testing");
		this.addToContainers(tmHeader);
		ContainerImpl tmPacket = new ContainerImpl(TM_PACKET_ALIAS, "Test packet", "Test TM packet for unit testing");
		this.addToContainers(tmPacket);
		ContainerImpl tmTail = new ContainerImpl(TM_FRAME_TAIL_ALIAS, "Test tail", "Test TM tail for unit testing");
		this.addToContainers(tmTail);
		// Add the header, packet and tail to the frame container.
		ArrayList<Container> containersToAdd = new ArrayList<Container>(3);
		containersToAdd.add(tmHeader);
		containersToAdd.add(tmPacket);
		containersToAdd.add(tmTail);
		tmFrame.addContainer(containersToAdd);

		/** Build the lower packet level of the model **/
		// Create the packet header and add it to the containers collection.
		ContainerImpl tmPacketHeader = new ContainerImpl(TM_PACKET_HEADER_ALIAS, "Test packet header", "Test TM packet header for unit testing");
		this.addToContainers(tmPacketHeader);

		// Create the apid (ID) parameter type and add it to the packet header and the parameters collection.
		ParameterType paramType11bitInt = new ParameterType("11bitInt", "11bit integer type", "Parameter type for 11bit integers", eParameterType.INTEGER,
				false, 0, 11);
		IntegerParameter packetIdParameter = new IntegerParameter(PACKET_ID_NAME, "Test Apid", "Test Application Id", paramType11bitInt, 0);
		this.addToParameters(packetIdParameter);
		this.addToContainers(packetIdParameter);
		tmPacketHeader.addContainer(packetIdParameter);

		// Create the packet body and add it to the containers collection
		ContainerImpl tmPacketBody = new ContainerImpl(TM_PACKET_BODY_ALIAS, "Test packet body", "Test TM packet header for unit testing");
		this.addToContainers(tmPacketBody);

		// Create a packet type, add it to the packet body, add a restriction to
		// associate it to an ID, and add it to the containers collection
		ContainerImpl packetTypeA = new ContainerImpl("TMPacketTypeA", "Test packet body", "Test TM packet for unit testing");
		packetTypeA.addRestriction(packetIdParameter, PACKET_TYPE_A_ID);
		this.addToContainers(packetTypeA);
		tmPacketBody.addContainer(packetTypeA);

		// Create a parameter for packetTypeA and add it to the packet type and
		// the container collection
		ParameterType test32bitInt = new ParameterType("test32bitInt", "test param", "32 bit int test param", eParameterType.INTEGER, false, 1, 32);
		IntegerParameter testParameterA = new IntegerParameter(TEST_PARAM_A, "test param", "test param holding an int value", test32bitInt, 0);
		packetTypeA.addContainer(testParameterA);
		this.addToParameters(testParameterA);
		this.addToContainers(testParameterA);

		// Create a packet type, add it to the packet body, add a restriction to
		// associate it to an ID, and add it to the containers collection
		ContainerImpl packetTypeB = new ContainerImpl("TMPacketTypeB", "Test packet body", "Test TM packet for unit testing");
		packetTypeB.addRestriction(packetIdParameter, PACKET_TYPE_B_ID);
		this.addToContainers(packetTypeB);
		tmPacketBody.addContainer(packetTypeB);

		// Create a parameter for packetTypeB and add it to the packet type and
		// the container collection
		ParameterType test64bitFloat = new ParameterType("test64bitFloat", "test param", "64 float test param", eParameterType.FLOAT, false, 1, 64);
		FloatParameter testParameterB = new FloatParameter(TEST_PARAM_B, "test param", "test param holding a float value", test64bitFloat, 1.0f);
		packetTypeB.addContainer(testParameterB);
		this.addToParameters(testParameterB);
		this.addToContainers(testParameterB);

		// Add the packet inners (header and body) to the packet
		List<Container> packetInners = new ArrayList<Container>(2);
		packetInners.add(tmPacketHeader);
		packetInners.add(tmPacketBody);
		tmPacket.addContainer(packetInners);

		if (LOG.isDebugEnabled()) {
			LOG.debug("Completed mock container model initialisaion");
		}
	}

	@Override
	public Container getContainer(String name) throws UnknownContainerNameException {

		ContainerImpl container = containers.get(name);

		if (container == null) {
			throw new UnknownContainerNameException(containers,
					"Your container lookup for '" + name + "' did not return any containers. Check your SpaceSystem configuration.");
		}

		return container;
	}

	@Override
	public Map<String, ParameterImpl> getAllParameters() {
		return parameters;
	}

	@Override
	public ParameterImpl getParameter(String name) {
		return parameters.get(name);
	}

	/**
	 * Convenience method to add a container with the key set to the containers name. This is less error prone and less
	 * work assuming you want the key to be the same as the container name.
	 * 
	 * @param container
	 */
	public void addToContainers(ContainerImpl container) {
		this.containers.put(container.getName(), container);
	}

	private void addToParameters(ParameterImpl parameter) {
		this.parameters.put(parameter.getName(), parameter);
	}

}
