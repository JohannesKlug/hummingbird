package org.hbird.transport.packetcodec.testsupport;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hbird.transport.spacesystemmodel.HummingbirdParameterGroup;
import org.hbird.transport.spacesystemmodel.ParameterGroup;
import org.hbird.transport.spacesystemmodel.SpaceSystemModel;
import org.hbird.transport.spacesystemmodel.exceptions.InvalidParameterTypeException;
import org.hbird.transport.spacesystemmodel.exceptions.UnknownParameterGroupException;
import org.hbird.transport.spacesystemmodel.parameters.HummingbirdParameter;
import org.hbird.transport.spacesystemmodel.parameters.Parameter;
import org.hbird.transport.spacesystemmodel.parameters.Parameter.Encoding;
import org.hbird.transport.spacesystemmodel.parameters.Parameter.Endianness;
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
public class MockContainerModelFactory implements SpaceSystemModel {
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

	private final Map<String, Parameter<?>> parameters = new HashMap<String, Parameter<?>>();
	private final List<Parameter<Integer>> integerParameters = new ArrayList<Parameter<Integer>>();
	private final List<Parameter<Long>> longParameters = new ArrayList<Parameter<Long>>();

	private final Map<Parameter<?>, List<Object>> restrictions = new HashMap<Parameter<?>, List<Object>>();

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
		final HummingbirdParameterGroup tmFrame = new HummingbirdParameterGroup(TM_FRAME_ALIAS, "Test frame",
				"Test TM frame for unit testing");
		this.addToContainers(tmFrame);
		final HummingbirdParameterGroup tmFrameHeader = new HummingbirdParameterGroup(TM_FRAME_HEADER_ALIAS, "Test header",
				"Test TM header for unit testing");
		this.addToContainers(tmFrameHeader);
		final HummingbirdParameterGroup tmPacket = new HummingbirdParameterGroup(TM_PACKET_ALIAS, "Test packet",
				"Test TM packet for unit testing");
		this.addToContainers(tmPacket);
		final HummingbirdParameterGroup tmFrameTail = new HummingbirdParameterGroup(TM_FRAME_TAIL_ALIAS, "Test tail",
				"Test TM tail for unit testing");
		this.addToContainers(tmFrameTail);
		// Add the header, packet and tail to the frame container.
		final ArrayList<ParameterGroup> containersToAdd = new ArrayList<ParameterGroup>();

		// Add a flag to the Frame Header
		final HummingbirdParameter<Integer> happyFlagParameter = new HummingbirdParameter<Integer>(HAPPY_FLAG_ALIAS,
				"happy?", "Flag of Happiness", 1, Endianness.LITTLE, Encoding.unsigned);

		tmFrameHeader.addParameter(happyFlagParameter);
		this.addToParameters(happyFlagParameter);
		integerParameters.add(happyFlagParameter);

		containersToAdd.add(tmFrameHeader);

		containersToAdd.add(tmPacket);

		// Add a flag to the Frame Tail
		final Parameter<Integer> validityFlagParameter = new HummingbirdParameter<Integer>(VALIDITY_FLAG_ALIAS, "valid?",
				"Flag of Validity", 1, Endianness.LITTLE, Encoding.unsigned);

		tmFrameTail.addParameter(validityFlagParameter);
		containersToAdd.add(tmFrameTail);
		this.addToParameters(validityFlagParameter);
		integerParameters.add(validityFlagParameter);

		tmFrame.addParameterGroup(containersToAdd);

		/** Build the lower packet level of the model **/
		// Create the packet header and add it to the containers collection.
		final HummingbirdParameterGroup tmPacketHeader = new HummingbirdParameterGroup(TM_PACKET_HEADER_ALIAS,
				"Test packet header", "Test TM packet header for unit testing");
		this.addToContainers(tmPacketHeader);

		// Create the apid (ID) parameter type and add it to the packet header and the parameters collection.
		final Parameter<Integer> packetIdParameter = new HummingbirdParameter<Integer>(PACKET_ID_ALIAS, "Test Apid",
				"Test Application Id", 11, Endianness.LITTLE, Encoding.unsigned);
		this.addToParameters(packetIdParameter);
		integerParameters.add(packetIdParameter);
		tmPacketHeader.addParameter(packetIdParameter);

		// Create the payload length parameter type and add it to the packet header and the parameters collection.
		final Parameter<Integer> payloadLengthParameter = new HummingbirdParameter<Integer>(PAYLOAD_LENGTH_PARAM_ALIAS,
				"Payload length", "Payload length parameter", 16, Endianness.LITTLE, Encoding.unsigned);
		this.addToParameters(payloadLengthParameter);
		integerParameters.add(payloadLengthParameter);
		tmPacketHeader.addParameter(payloadLengthParameter);

		// Create the packet body and add it to the containers collection
		final HummingbirdParameterGroup tmPacketBody = new HummingbirdParameterGroup(TM_PACKET_BODY_ALIAS,
				"Test packet body", "Test TM packet header for unit testing");
		this.addToContainers(tmPacketBody);

		// Create a packet type, add it to the packet body, add a restriction to
		// associate it to an ID, and add it to the containers collection
		final HummingbirdParameterGroup packetTypeA = new HummingbirdParameterGroup("TMPacketTypeA", "Test packet body",
				"Test TM packet for unit testing");
		packetTypeA.addRestriction(packetIdParameter, PACKET_TYPE_A_ID);
		addRestrictionToGlobalMap(packetIdParameter, PACKET_TYPE_A_ID);
		this.addToContainers(packetTypeA);
		tmPacketBody.addParameterGroup(packetTypeA);

		// Create a parameter for packetTypeA and add it to the packet type and
		// the container collection
		final Parameter<Integer> testParameterA = new HummingbirdParameter<Integer>(TEST_PARAM_A, "test param",
				"test param holding an int value", 32, Endianness.LITTLE, Encoding.unsigned);
		packetTypeA.addParameter(testParameterA);
		this.addToParameters(testParameterA);
		integerParameters.add(testParameterA);

		// Create a packet type, add it to the packet body, add a restriction to
		// associate it to an ID, and add it to the containers collection
		final HummingbirdParameterGroup packetTypeB = new HummingbirdParameterGroup("TMPacketTypeB", "Test packet body",
				"Test TM packet for unit testing");
		packetTypeB.addRestriction(packetIdParameter, PACKET_TYPE_B_ID);
		addRestrictionToGlobalMap(packetIdParameter, PACKET_TYPE_B_ID);
		this.addToContainers(packetTypeB);
		tmPacketBody.addParameterGroup(packetTypeB);

		// Create a parameter for packetTypeB and add it to the packet type and
		// the container collection
		final HummingbirdParameter<Float> testParameterB = new HummingbirdParameter<Float>(TEST_PARAM_B, "test param",
				"test param holding a float value", 32, Endianness.BIG, Encoding.IEEE754_1985);
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

	private void addRestrictionToGlobalMap(final Parameter<?> restrictionParameter, final String comparisonValue) {
		List<Object> pList;
		if (restrictions.containsKey(restrictionParameter)) {
			pList = restrictions.get(restrictionParameter);
			pList.add(comparisonValue);
		}
		else {
			pList = new ArrayList<Object>();
			pList.add(comparisonValue);
			restrictions.put(restrictionParameter, pList);
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

	/**
	 * Convenience method to add a container with the key set to the containers name. This is less error prone and less
	 * work assuming you want the key to be the same as the container name.
	 * 
	 * @param container
	 */
	public void addToContainers(final ParameterGroup container) {
		this.containers.put(container.getName(), container);
	}

	private void addToParameters(final Parameter<?> parameter) {
		this.parameters.put(parameter.getName(), parameter);
	}


	@Override
	public Collection<ParameterGroup> getAllParameterGroups() {
		return containers.values();
	}

	@Override
	public List<Parameter<Integer>> getIntegerParameters() {
		return integerParameters;
	}

	@Override
	public List<Parameter<Long>> getLongParameters() {
		return longParameters;
	}

	@Override
	public Map<Parameter<?>, List<Object>> getAllParameterRestrictions() {
		return restrictions;
	}

	@Override
	public Map<String, Parameter<?>> getAllParameters() {
		return parameters;
	}

	@Override
	public Parameter<?> getParameter(final String name) {
		return parameters.get(name);
	}

}
