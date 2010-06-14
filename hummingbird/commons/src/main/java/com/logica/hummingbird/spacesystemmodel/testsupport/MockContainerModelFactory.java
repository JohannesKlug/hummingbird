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
import com.logica.hummingbird.spacesystemmodel.exceptions.InvalidParameterTypeException;
import com.logica.hummingbird.spacesystemmodel.exceptions.UnknownContainerNameException;
import com.logica.hummingbird.spacesystemmodel.parameters.FloatParameter;
import com.logica.hummingbird.spacesystemmodel.parameters.IntegerParameter;
import com.logica.hummingbird.spacesystemmodel.parameters.ParameterContainer;
import com.logica.hummingbird.spacesystemmodel.parameters.NumberParameterType;
import com.logica.hummingbird.spacesystemmodel.parameters.NumberParameterType.eParameterType;

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

	public static final String PACKET_ID_ALIAS = "ApId";
	
	public static final String PAYLOAD_LENGTH_PARAM_ALIAS = "PayloadLength";

	public static final String PACKET_TYPE_B_ID = "333";

	public static final String PACKET_TYPE_A_ID = "555";
	
	public static final String HAPPY_FLAG_ALIAS = "HappyFlag";
	
	public static final String VALIDITY_FLAG_ALIAS = "ValidityFlag";

	private Map<String, ContainerImpl> containers = new HashMap<String, ContainerImpl>();
	private Map<String, ParameterContainer> parameters = new HashMap<String, ParameterContainer>();

	public MockContainerModelFactory() throws InvalidParameterTypeException {
		initialise();
	}

	/**
	 * Creates an operational mock Container hierarchy which is used by the FrameBroker.
	 * @throws InvalidParameterTypeException 
	 * 
	 */
	private void initialise() throws InvalidParameterTypeException {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Beginning initialisation of container model mock up");
		}

		/** Build the upper frame skeleton of the Model **/
		// Create the Frame, header, packet and tail and add them to the
		// containers collection
		ContainerImpl tmFrame = new ContainerImpl(TM_FRAME_ALIAS, "Test frame", "Test TM frame for unit testing");
		this.addToContainers(tmFrame);
		ContainerImpl tmFrameHeader = new ContainerImpl(TM_FRAME_HEADER_ALIAS, "Test header", "Test TM header for unit testing");
		this.addToContainers(tmFrameHeader);
		ContainerImpl tmPacket = new ContainerImpl(TM_PACKET_ALIAS, "Test packet", "Test TM packet for unit testing");
		this.addToContainers(tmPacket);
		ContainerImpl tmFrameTail = new ContainerImpl(TM_FRAME_TAIL_ALIAS, "Test tail", "Test TM tail for unit testing");
		this.addToContainers(tmFrameTail);
		// Add the header, packet and tail to the frame container.
		ArrayList<Container> containersToAdd = new ArrayList<Container>(3);
		
		NumberParameterType paramType1bitInt = new NumberParameterType("1bitInt", "1bit integer type", "Parameter type for 1bit integers", eParameterType.INTEGER,
				false, 0, 1);

		// Add a flag to the Frame Header
		
		IntegerParameter happyFlagParameter = new IntegerParameter(HAPPY_FLAG_ALIAS, "happy?", "Flag of Happiness", paramType1bitInt, 0);
		tmFrameHeader.addContainer(happyFlagParameter);
		this.addToContainers(happyFlagParameter);
		this.addToParameters(happyFlagParameter);

		containersToAdd.add(tmFrameHeader);
		
		containersToAdd.add(tmPacket);

		// Add a flag to the Frame Tail
		IntegerParameter validityFlagParameter = new IntegerParameter(VALIDITY_FLAG_ALIAS, "valid?", "Flag of Validity", paramType1bitInt, 0);
		tmFrameTail.addContainer(validityFlagParameter);
		containersToAdd.add(tmFrameTail);
		this.addToContainers(validityFlagParameter);
		this.addToParameters(validityFlagParameter);
		
		tmFrame.addContainer(containersToAdd);

		/** Build the lower packet level of the model **/
		// Create the packet header and add it to the containers collection.
		ContainerImpl tmPacketHeader = new ContainerImpl(TM_PACKET_HEADER_ALIAS, "Test packet header", "Test TM packet header for unit testing");
		this.addToContainers(tmPacketHeader);

		// Create the apid (ID) parameter type and add it to the packet header and the parameters collection.
		NumberParameterType paramType11bitInt = new NumberParameterType("11bitInt", "11bit integer type", "Parameter type for 11bit integers", eParameterType.INTEGER,
				false, 0, 11);
		IntegerParameter packetIdParameter = new IntegerParameter(PACKET_ID_ALIAS, "Test Apid", "Test Application Id", paramType11bitInt, 0);
		this.addToParameters(packetIdParameter);
		this.addToContainers(packetIdParameter);
		tmPacketHeader.addContainer(packetIdParameter);

		// Create the payload length parameter type and add it to the packet header and the parameters collection.
		NumberParameterType paramType16bitInt = new NumberParameterType("16bitInt", "16bit integer type", "Parameter type for 16bit integers", eParameterType.INTEGER,
				false, 0, 16);
		IntegerParameter payloadLengthParameter = new IntegerParameter(PAYLOAD_LENGTH_PARAM_ALIAS, "Payload length", "Payload lenght parameter", paramType16bitInt, 0);
		this.addToContainers(payloadLengthParameter);
		this.addToParameters(payloadLengthParameter);
		tmPacketHeader.addContainer(payloadLengthParameter);

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
		NumberParameterType test32bitInt = new NumberParameterType("test32bitInt", "test param", "32 bit int test param", eParameterType.INTEGER, false, 1, 32);
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
		NumberParameterType test64bitFloat = new NumberParameterType("test64bitFloat", "test param", "64 float test param", eParameterType.FLOAT, true, 0, 64);
		FloatParameter testParameterB = new FloatParameter(TEST_PARAM_B, "test param", "test param holding a float value", test64bitFloat, 0.0);
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
	public Map<String, ParameterContainer> getAllParameters() {
		return parameters;
	}

	@Override
	public ParameterContainer getParameter(String name) {
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

	private void addToParameters(ParameterContainer parameter) {
		this.parameters.put(parameter.getName(), parameter);
	}

}
