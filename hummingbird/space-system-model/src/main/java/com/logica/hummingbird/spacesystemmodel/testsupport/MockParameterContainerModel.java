package com.logica.hummingbird.spacesystemmodel.testsupport;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.logica.hummingbird.spacesystemmodel.Container;
import com.logica.hummingbird.spacesystemmodel.ContainerFactory;
import com.logica.hummingbird.spacesystemmodel.ContainerImpl;
import com.logica.hummingbird.spacesystemmodel.exceptions.InvalidParameterTypeException;
import com.logica.hummingbird.spacesystemmodel.exceptions.UnknownContainerNameException;
import com.logica.hummingbird.spacesystemmodel.parameters.FloatParameter;
import com.logica.hummingbird.spacesystemmodel.parameters.IntegerParameter;
import com.logica.hummingbird.spacesystemmodel.parameters.ParameterContainer;
import com.logica.hummingbird.spacesystemmodel.parameters.behaviours.Float64Behaviour;
import com.logica.hummingbird.spacesystemmodel.parameters.behaviours.IntegerUnsignedBehaviour;
import com.logica.hummingbird.spacesystemmodel.parameters.types.NumberParameterType;

/**
 * This class is used for testing the Container model and anything that uses the SpaceSystemModel. It is a simple
 * Container model representing a space system which can be populated with values by tests. The container model follows
 * the CCSDS standards and therefore uses the TMFrame, TMFrameHeader, TMPacket, and a TMFrameTail concepts. 
 * They will be read by CCSDS packet 
 * 
 * @author Mark Doyle <markjohndoyle@googlemail.com>, <mark.doyle@logica.com>
 * @since Hummingbird 0.0.1
 */
public class MockParameterContainerModel implements ContainerFactory {
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

	private Map<String, ContainerImpl> containers = new HashMap<String, ContainerImpl>();
	private Map<String, ParameterContainer> parameters = new HashMap<String, ParameterContainer>();

	public MockParameterContainerModel() throws InvalidParameterTypeException {
		initialiseModel();
	}

	/**
	 * Creates an operational mock Container hierarchy which is used by the FrameBroker.
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
				new IntegerUnsignedBehaviour(11, false), 0);

		NumberParameterType paramType16bitInt = new NumberParameterType("16bitInt", "16bit integer type", "Parameter type for 16bit integers",
				new IntegerUnsignedBehaviour(16, false), 0);

		NumberParameterType test32bitInt = new NumberParameterType("test32bitInt", "test param", "32 bit int test param",
				new IntegerUnsignedBehaviour(32, true), 0);

		NumberParameterType test64bitFloat = new NumberParameterType("test64bitFloat", "test param", "64 float test param", new Float64Behaviour(), 0);

		/** Build the upper frame skeleton of the Model **/
		// Create packet and add to the containers collection.
		ContainerImpl tmPacket = new ContainerImpl(TM_PACKET_ALIAS, "X-Wing packet", "Test X-Wing packet for unit testing");
		this.addToContainers(tmPacket);
		ContainerImpl tmPacketHeader = new ContainerImpl(TM_PACKET_HEADER_ALIAS, "X-Wing packet header", "Test X-Wing packet header for unit testing");
		this.addToContainers(tmPacketHeader);
		ContainerImpl tmPacketPayload = new ContainerImpl(TM_PACKET_PAYLOAD_ALIAS, "X-Wing packet payload", "Test X-Wing packet payload for unit testing");
		this.addToContainers(tmPacketPayload);

		tmPacket.addContainer(tmPacketHeader);
		tmPacket.addContainer(tmPacketPayload);
		
		// Create the APID parameter and add it to the packet header.
		IntegerParameter apidParameter = new IntegerParameter(PAYLOAD_APID_ALIAS, "Test Apid", "Test Application Id", paramType11bitInt, 0);
		this.addToParameters(apidParameter);
		this.addToContainers(apidParameter);
		tmPacketHeader.addContainer(apidParameter);

		// Create the payload length parameter type and add it to the packet header and the parameters collection.
		IntegerParameter payloadLengthParameter = new IntegerParameter(PAYLOAD_LENGTH_PARAM_ALIAS, "Payload length", "Payload length parameter",
				paramType16bitInt, 0);
		this.addToContainers(payloadLengthParameter);
		this.addToParameters(payloadLengthParameter);
		tmPacketHeader.addContainer(payloadLengthParameter);

		// Create the Packet Payloads and add them to the payload container
		ContainerImpl flightDataPayload = new ContainerImpl(TM_FLIGHT_DATA_PAYLOAD, "Flight hours payload", "Test TM packet payload containing flight data");
		flightDataPayload.addRestriction(apidParameter, FLIGHT_DATA_PAYLOAD_APID);
		this.addToContainers(flightDataPayload);
		tmPacketPayload.addContainer(flightDataPayload);

		ContainerImpl laserDataPayload = new ContainerImpl(TM_LASER_DATA_PAYLOAD, "Laser temp payload", "Test TM packet payload containing laser data");
		laserDataPayload.addRestriction(apidParameter, LASER_DATA_PAYLOAD_APID);
		this.addToContainers(laserDataPayload);
		tmPacketPayload.addContainer(laserDataPayload);

		ContainerImpl allSystemsPayload = new ContainerImpl(TM_ALL_SYS_PAYLOAD, "All systems payload", "Test TM packet payload containing all data");
		allSystemsPayload.addRestriction(apidParameter, ALL_SYS_PAYLOAD_APID);
		this.addToContainers(allSystemsPayload);
		tmPacketPayload.addContainer(allSystemsPayload);

		IntegerParameter flightHoursParameter = new IntegerParameter(FLIGHT_HOURS_PARAM_ALIAS, "test param", "test param holding flight hours as an int value",
				test32bitInt, 0);
		flightDataPayload.addContainer(flightHoursParameter);
		this.addToParameters(flightHoursParameter);
		this.addToContainers(flightHoursParameter);

		FloatParameter laserTemperatureParameter = new FloatParameter(LASER_TEMP_PARAM_ALIAS, "test param", "test param holding a float value", test64bitFloat, 0.0);
		laserDataPayload.addContainer(laserTemperatureParameter);
		this.addToParameters(laserTemperatureParameter);
		this.addToContainers(laserTemperatureParameter);

		allSystemsPayload.addContainer(flightHoursParameter);
		allSystemsPayload.addContainer(laserTemperatureParameter);

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

	@Override
	public String getSpaceSystemModelFilePath() {
		return null;
	}

}
