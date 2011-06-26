package org.hbird.transport.packetbroker.testsupport;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hbird.transport.spacesystemmodel.SpaceSystemModelFactory;
import org.hbird.transport.spacesystemmodel.DefaultParameterGroup;
import org.hbird.transport.spacesystemmodel.ParameterGroup;
import org.hbird.transport.spacesystemmodel.exceptions.InvalidParameterTypeException;
import org.hbird.transport.spacesystemmodel.exceptions.UnknownParameterGroupException;
import org.hbird.transport.spacesystemmodel.parameters.FloatParameter;
import org.hbird.transport.spacesystemmodel.parameters.IntegerParameter;
import org.hbird.transport.spacesystemmodel.parameters.Parameter;
import org.hbird.transport.spacesystemmodel.parameters.DefaultParameter;
import org.hbird.transport.spacesystemmodel.parameters.behaviours.Float64Behaviour;
import org.hbird.transport.spacesystemmodel.parameters.behaviours.IntegerUnsignedBehaviour;
import org.hbird.transport.spacesystemmodel.parameters.types.NumberParameterType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class is used for testing the ParameterGroup model and anything that uses the SpaceSystemModel. It is a simple
 * ParameterGroup model representing a space system which can be populated with values by tests. The container model
 * follows the CCSDS standards and therefore uses the TMFrame, TMFrameHeader, TMPacket, and a TMFrameTail concepts. They
 * can go by any name since they are accessed using the constants X_ALIAS defined in the class.
 * 
 * FIXME Should be in it's own project. It's an implementation of the container model just for testing.
 * 
 * @author Mark Doyle <markjohndoyle@googlemail.com>, <mark.doyle@logica.com>
 * @since Hummingbird 0.0.1
 */
public class MockContainerModelFactory implements SpaceSystemModelFactory {
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

	private final Map<String, ParameterGroup> containers = new HashMap<String, ParameterGroup>();
	private final Map<String, DefaultParameter> parameters = new HashMap<String, DefaultParameter>();

	public MockContainerModelFactory() throws InvalidParameterTypeException {
		initialise();
	}

	/**
	 * Creates an operational mock ParameterGroup hierarchy which is used by the FrameBroker.
	 * 
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
		final DefaultParameterGroup tmFrame = new DefaultParameterGroup(TM_FRAME_ALIAS, "Test frame", "Test TM frame for unit testing");
		this.addToContainers(tmFrame);
		final DefaultParameterGroup tmFrameHeader = new DefaultParameterGroup(TM_FRAME_HEADER_ALIAS, "Test header", "Test TM header for unit testing");
		this.addToContainers(tmFrameHeader);
		final DefaultParameterGroup tmPacket = new DefaultParameterGroup(TM_PACKET_ALIAS, "Test packet", "Test TM packet for unit testing");
		this.addToContainers(tmPacket);
		final DefaultParameterGroup tmFrameTail = new DefaultParameterGroup(TM_FRAME_TAIL_ALIAS, "Test tail", "Test TM tail for unit testing");
		this.addToContainers(tmFrameTail);
		// Add the header, packet and tail to the frame container.
		final ArrayList<ParameterGroup> containersToAdd = new ArrayList<ParameterGroup>();

		final NumberParameterType paramType1bitInt = new NumberParameterType("1bitInt", "1bit integer type", "Parameter type for 1bit integers",
				new IntegerUnsignedBehaviour(1, false), 0);

		// Add a flag to the Frame Header

		final IntegerParameter happyFlagParameter = new IntegerParameter(HAPPY_FLAG_ALIAS, "happy?", "Flag of Happiness", paramType1bitInt, 0);
		tmFrameHeader.addParameter(happyFlagParameter);
		// this.addToContainers(happyFlagParameter);
		this.addToParameters(happyFlagParameter);

		containersToAdd.add(tmFrameHeader);

		containersToAdd.add(tmPacket);

		// Add a flag to the Frame Tail
		final IntegerParameter validityFlagParameter = new IntegerParameter(VALIDITY_FLAG_ALIAS, "valid?", "Flag of Validity", paramType1bitInt, 0);
		tmFrameTail.addParameter(validityFlagParameter);
		containersToAdd.add(tmFrameTail);
		// this.addToContainers(validityFlagParameter);
		this.addToParameters(validityFlagParameter);

		tmFrame.addParameterGroup(containersToAdd);

		/** Build the lower packet level of the model **/
		// Create the packet header and add it to the containers collection.
		final DefaultParameterGroup tmPacketHeader = new DefaultParameterGroup(TM_PACKET_HEADER_ALIAS, "Test packet header",
				"Test TM packet header for unit testing");
		this.addToContainers(tmPacketHeader);

		// Create the apid (ID) parameter type and add it to the packet header and the parameters collection.
		final NumberParameterType paramType11bitInt = new NumberParameterType("11bitInt", "11bit integer type", "Parameter type for 11bit integers",
				new IntegerUnsignedBehaviour(11, false), 0);
		final IntegerParameter packetIdParameter = new IntegerParameter(PACKET_ID_ALIAS, "Test Apid", "Test Application Id", paramType11bitInt, 0);
		this.addToParameters(packetIdParameter);
		// this.addToContainers(packetIdParameter);
		tmPacketHeader.addParameter(packetIdParameter);

		// Create the payload length parameter type and add it to the packet header and the parameters collection.
		final NumberParameterType paramType16bitInt = new NumberParameterType("16bitInt", "16bit integer type", "Parameter type for 16bit integers",
				new IntegerUnsignedBehaviour(16, false), 0);
		final IntegerParameter payloadLengthParameter = new IntegerParameter(PAYLOAD_LENGTH_PARAM_ALIAS, "Payload length", "Payload lenght parameter",
				paramType16bitInt, 0);
		// this.addToContainers(payloadLengthParameter);
		this.addToParameters(payloadLengthParameter);
		tmPacketHeader.addParameter(payloadLengthParameter);

		// Create the packet body and add it to the containers collection
		final DefaultParameterGroup tmPacketBody = new DefaultParameterGroup(TM_PACKET_BODY_ALIAS, "Test packet body", "Test TM packet header for unit testing");
		this.addToContainers(tmPacketBody);

		// Create a packet type, add it to the packet body, add a restriction to
		// associate it to an ID, and add it to the containers collection
		final DefaultParameterGroup packetTypeA = new DefaultParameterGroup("TMPacketTypeA", "Test packet body", "Test TM packet for unit testing");
		packetTypeA.addRestriction(packetIdParameter, PACKET_TYPE_A_ID);
		this.addToContainers(packetTypeA);
		tmPacketBody.addParameterGroup(packetTypeA);

		// Create a parameter for packetTypeA and add it to the packet type and
		// the container collection
		final NumberParameterType test32bitInt = new NumberParameterType("test32bitInt", "test param", "32 bit int test param", new IntegerUnsignedBehaviour(
				32, false), 0);
		final IntegerParameter testParameterA = new IntegerParameter(TEST_PARAM_A, "test param", "test param holding an int value", test32bitInt, 0);
		packetTypeA.addParameter(testParameterA);
		this.addToParameters(testParameterA);
		// this.addToContainers(testParameterA);

		// Create a packet type, add it to the packet body, add a restriction to
		// associate it to an ID, and add it to the containers collection
		final DefaultParameterGroup packetTypeB = new DefaultParameterGroup("TMPacketTypeB", "Test packet body", "Test TM packet for unit testing");
		packetTypeB.addRestriction(packetIdParameter, PACKET_TYPE_B_ID);
		this.addToContainers(packetTypeB);
		tmPacketBody.addParameterGroup(packetTypeB);

		// Create a parameter for packetTypeB and add it to the packet type and
		// the container collection
		final NumberParameterType test64bitFloat = new NumberParameterType("test64bitFloat", "test param", "64 float test param", new Float64Behaviour(), 0);
		final FloatParameter testParameterB = new FloatParameter(TEST_PARAM_B, "test param", "test param holding a float value", test64bitFloat, 0.0);
		packetTypeB.addParameter(testParameterB);
		this.addToParameters(testParameterB);
		// this.addToContainers(testParameterB);

		// Add the packet inners (header and body) to the packet
		final List<ParameterGroup> packetInners = new ArrayList<ParameterGroup>(2);
		packetInners.add(tmPacketHeader);
		packetInners.add(tmPacketBody);
		tmPacket.addParameterGroup(packetInners);

		if (LOG.isDebugEnabled()) {
			LOG.debug("Completed mock container model initialisaion");
		}
	}

	@Override
	public ParameterGroup getParameterGroup(final String name) throws UnknownParameterGroupException {

		final ParameterGroup container = containers.get(name);

		if (container == null) {
			throw new UnknownParameterGroupException(containers, "Your container lookup for '" + name
					+ "' did not return any containers. Check your SpaceSystem configuration.");
		}

		return container;
	}

	@Override
	public Map<String, DefaultParameter> getAllParameters() {
		return parameters;
	}

	@Override
	public DefaultParameter getParameter(final String name) {
		return parameters.get(name);
	}

	/**
	 * Convenience method to add a container with the key set to the containers name. This is less error prone and less
	 * work assuming you want the key to be the same as the container name.
	 * 
	 * @param container
	 */
	public void addToContainers(final DefaultParameterGroup container) {
		this.containers.put(container.getName(), container);
	}

	private void addToParameters(final DefaultParameter parameter) {
		this.parameters.put(parameter.getName(), parameter);
	}

	@Override
	public String getSpaceSystemModelFilePath() {
		return null;
	}

	@Override
	public Map<Parameter, List<String>> getAllParameterRestrictions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<ParameterGroup> getAllParameterGroups() {
		return containers.values();
	}

}
