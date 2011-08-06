package org.hbird.transport.packetcodec.testsupport;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hbird.transport.spacesystemmodel.SpaceSystemModel;
import org.hbird.transport.spacesystemmodel.HummingbirdParameterGroup;
import org.hbird.transport.spacesystemmodel.ParameterGroup;
import org.hbird.transport.spacesystemmodel.exceptions.InvalidParameterTypeException;
import org.hbird.transport.spacesystemmodel.exceptions.UnknownParameterGroupException;
import org.hbird.transport.spacesystemmodel.parameters.FloatParameter;
import org.hbird.transport.spacesystemmodel.parameters.IntegerParameter;
import org.hbird.transport.spacesystemmodel.parameters.Parameter;
import org.hbird.transport.spacesystemmodel.parameters.HummingbirdParameter;
import org.hbird.transport.spacesystemmodel.parameters.behaviours.Float64Behaviour;
import org.hbird.transport.spacesystemmodel.parameters.behaviours.IntegerUnsignedBehaviour;
import org.hbird.transport.spacesystemmodel.parameters.types.NumberParameterType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class is used for testing the ParameterGroup model and anything that uses the SpaceSystemModel. It is a simple
 * ParameterGroup model representing a space system which can be populated with values by tests. The container model
 * follows the CCSDS standards and therefore uses the TMFrame, TMFrameHeader, TMPacket, and a TMFrameTail concepts. They
 * will be read by CCSDS packet
 * 
 * FIXME Should be in it's own project. It's an implementation of the container model just for testing.
 * 
 * @author Mark Doyle <markjohndoyle@googlemail.com>, <mark.doyle@logica.com>
 * @author Johannes Klug
 * @since Hummingbird 0.0.1
 */
public class MockParameterContainerModel implements SpaceSystemModel {
	/**
	 * Logger for this class
	 */
	public static final Logger LOG = LoggerFactory.getLogger(MockParameterContainerModel.class);

	/**
	 * MockSpaceSystemModel's telemetry packet alias
	 */
	public static final String TM_PACKET_ALIAS = "TMPacket";

	/**
	 * MockSpaceSystemModel's telemetry frame header alias
	 */
	public static final String TM_PACKET_HEADER_ALIAS = "TMPacketHeader";

	public static final String PAYLOAD_APID_ALIAS = "ApId";

	/**
	 * MockSpaceSystemModel's telemetry packet body alias
	 */
	public static final String TM_PACKET_PAYLOAD_ALIAS = "TMPacketPayload";

	public static final String TM_FLIGHT_DATA_PAYLOAD = "TMPayload Flight data";

	public static final String TM_LASER_DATA_PAYLOAD = "TMPayload Weapon data";

	public static final String TM_ALL_SYS_PAYLOAD = "TMPayload All systems data";

	public static final String FLIGHT_HOURS_PARAM_ALIAS = "FlightHours";

	public static final String LASER_TEMP_PARAM_ALIAS = "LaserTemp";

	public static final String FLIGHT_DATA_PAYLOAD_APID = "333";

	public static final String LASER_DATA_PAYLOAD_APID = "555";

	public static final String ALL_SYS_PAYLOAD_APID = "999";

	public static final String PAYLOAD_LENGTH_PARAM_ALIAS = "PayloadLength";

	private final Map<String, ParameterGroup> containers = new HashMap<String, ParameterGroup>();
	private final Map<String, HummingbirdParameter> parameters = new HashMap<String, HummingbirdParameter>();

	private final Map<Parameter, List<String>> restrictions = new HashMap<Parameter, List<String>>();

	public MockParameterContainerModel() throws InvalidParameterTypeException {
		initialiseModel();
	}

	/**
	 * Creates an operational mock ParameterGroup hierarchy which is used by the FrameBroker.
	 * 
	 * @throws InvalidParameterTypeException
	 * 
	 */
	private void initialiseModel() throws InvalidParameterTypeException {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Beginning initialisation of container model mock up");
		}

		// Create the parameter types
		NumberParameterType paramType11bitInt = new NumberParameterType("11bitInt", "11bit integer type", "Parameter type for 11bit integers",
				new UnsignedIntegerCodecParameter(11, false), 0);

		NumberParameterType paramType16bitInt = new NumberParameterType("16bitInt", "16bit integer type", "Parameter type for 16bit integers",
				new UnsignedIntegerCodecParameter(16, false), 0);

		NumberParameterType test32bitInt = new NumberParameterType("test32bitInt", "test param", "32 bit int test param",
				new UnsignedIntegerCodecParameter(32, true), 0);

		NumberParameterType test64bitFloat = new NumberParameterType("test64bitFloat", "test param", "64 float test param", new Double64ParameterCodec(), 0);

		/** Build the upper frame skeleton of the Model **/
		// Create packet and add to the containers collection.
		HummingbirdParameterGroup tmPacket = new HummingbirdParameterGroup(TM_PACKET_ALIAS, "X-Wing packet", "Test X-Wing packet for unit testing");
		this.addToContainers(tmPacket);
		HummingbirdParameterGroup tmPacketHeader = new HummingbirdParameterGroup(TM_PACKET_HEADER_ALIAS, "X-Wing packet header",
				"Test X-Wing packet header for unit testing");
		this.addToContainers(tmPacketHeader);
		HummingbirdParameterGroup tmPacketPayload = new HummingbirdParameterGroup(TM_PACKET_PAYLOAD_ALIAS, "X-Wing packet payload",
				"Test X-Wing packet payload for unit testing");
		this.addToContainers(tmPacketPayload);

		tmPacket.addParameterGroup(tmPacketHeader);
		tmPacket.addParameterGroup(tmPacketPayload);

		// Create the APID parameter and add it to the packet header.
		IntegerParameter apidParameter = new IntegerParameter(PAYLOAD_APID_ALIAS, "Test Apid", "Test Application Id", paramType11bitInt, 0);
		this.addToParameters(apidParameter);
		// this.addToContainers(apidParameter);
		tmPacketHeader.addParameter(apidParameter);

		// Create the payload length parameter type and add it to the packet header and the parameters collection.
		IntegerParameter payloadLengthParameter = new IntegerParameter(PAYLOAD_LENGTH_PARAM_ALIAS, "Payload length", "Payload length parameter",
				paramType16bitInt, 0);
		// this.addToContainers(payloadLengthParameter);
		this.addToParameters(payloadLengthParameter);
		tmPacketHeader.addParameter(payloadLengthParameter);

		// Create the Packet Payloads and add them to the payload container
		HummingbirdParameterGroup flightDataPayload = new HummingbirdParameterGroup(TM_FLIGHT_DATA_PAYLOAD, "Flight hours payload",
				"Test TM packet payload containing flight data");
		this.addRestrictionToGlobalMap(apidParameter, FLIGHT_DATA_PAYLOAD_APID);
		flightDataPayload.addRestriction(apidParameter, FLIGHT_DATA_PAYLOAD_APID);
		this.addToContainers(flightDataPayload);
		tmPacketPayload.addParameterGroup(flightDataPayload);

		HummingbirdParameterGroup laserDataPayload = new HummingbirdParameterGroup(TM_LASER_DATA_PAYLOAD, "Laser temp payload",
				"Test TM packet payload containing laser data");
		this.addRestrictionToGlobalMap(apidParameter, LASER_DATA_PAYLOAD_APID);
		laserDataPayload.addRestriction(apidParameter, LASER_DATA_PAYLOAD_APID);
		this.addToContainers(laserDataPayload);
		tmPacketPayload.addParameterGroup(laserDataPayload);

		HummingbirdParameterGroup allSystemsPayload = new HummingbirdParameterGroup(TM_ALL_SYS_PAYLOAD, "All systems payload", "Test TM packet payload containing all data");
		this.addRestrictionToGlobalMap(apidParameter, ALL_SYS_PAYLOAD_APID);
		allSystemsPayload.addRestriction(apidParameter, ALL_SYS_PAYLOAD_APID);
		this.addToContainers(allSystemsPayload);
		tmPacketPayload.addParameterGroup(allSystemsPayload);

		IntegerParameter flightHoursParameter = new IntegerParameter(FLIGHT_HOURS_PARAM_ALIAS, "test param", "test param holding flight hours as an int value",
				test32bitInt, 0);
		flightDataPayload.addParameter(flightHoursParameter);
		this.addToParameters(flightHoursParameter);
		// this.addToContainers(flightHoursParameter);

		FloatParameter laserTemperatureParameter = new FloatParameter(LASER_TEMP_PARAM_ALIAS, "test param", "test param holding a float value", test64bitFloat,
				0.0);
		laserDataPayload.addParameter(laserTemperatureParameter);
		this.addToParameters(laserTemperatureParameter);
		// this.addToContainers(laserTemperatureParameter);

		allSystemsPayload.addParameter(flightHoursParameter);
		allSystemsPayload.addParameter(laserTemperatureParameter);

		if (LOG.isDebugEnabled()) {
			LOG.debug("Completed mock container model initialisaion");
		}
	}

	@Override
	public ParameterGroup getParameterGroup(final String name) throws UnknownParameterGroupException {

		ParameterGroup container = containers.get(name);

		if (container == null) {
			throw new UnknownParameterGroupException(containers, "Your container lookup for '" + name
					+ "' did not return any containers. Check your SpaceSystem configuration.");
		}

		return container;
	}

	@Override
	public Map<String, HummingbirdParameter> getAllParameters() {
		return parameters;
	}

	@Override
	public HummingbirdParameter getParameter(final String name) {
		return parameters.get(name);
	}

	private void addRestrictionToGlobalMap(final HummingbirdParameter paramContainer, final String comparisonValue) {
		List<String> pList;
		if (restrictions.containsKey(paramContainer)) {
			pList = restrictions.get(paramContainer);
			pList.add(comparisonValue);
		}
		else {
			pList = new ArrayList<String>();
			pList.add(comparisonValue);
			restrictions.put(paramContainer, pList);
		}
	}

	/**
	 * Convenience method to add a container with the key set to the containers name. This is less error prone and less
	 * work assuming you want the key to be the same as the container name.
	 * 
	 * @param container
	 */
	public void addToContainers(final HummingbirdParameterGroup container) {
		this.containers.put(container.getName(), container);
	}

	private void addToParameters(final HummingbirdParameter parameter) {
		this.parameters.put(parameter.getName(), parameter);
	}

	@Override
	public String getSpaceSystemModelFilePath() {
		return null;
	}

	@Override
	public Map<Parameter, List<String>> getAllParameterRestrictions() {
		return restrictions;
	}

	@Override
	public Collection<ParameterGroup> getAllParameterGroups() {
		return containers.values();
	}

}
