package com.logica.hummingbird.framebroker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.logica.hummingbird.framebroker.exceptions.UnknownContainerNameException;
import com.logica.hummingbird.framebroker.parameters.IntegerParameter;
import com.logica.hummingbird.framebroker.parameters.Parameter;
import com.logica.hummingbird.framebroker.parameters.ParameterType;
import com.logica.hummingbird.framebroker.parameters.ParameterType.eParameterType;

/**
 * 
 * @author Mark Doyle
 *
 */
public class MockContainerModelFactory implements IContainerFactory {

	private Map<String, Container> containers = new HashMap<String, Container>();
	private Map<String, Parameter> parameters = new HashMap<String, Parameter>();

	private boolean initialised = false;

	/**
	 * Creates an operational mock Container hierarchy which is used by the FrameBroker.
	 * 
	 */
	@Override
	public void initialise() {
		/** Build the upper frame skeleton of the Model **/
		// Create the Frame, header, packet and tail and add them to the containers collection
		Container tmFrame = new Container("TMFrame", "Test frame", "Test TM frame for unit testing");
		containers.put("TMFrame", tmFrame);
		Container tmHeader = new Container("TMHeader", "Test header", "Test TM header for unit testing");
		containers.put("TMHeader", tmHeader);
		Container tmPacket = new Container("TMPacket", "Test packet", "Test TM packet for unit testing");
		containers.put("TMPacket", tmPacket);
		Container tmTail = new Container("TMTail", "Test tail", "Test TM tail for unit testing");
		containers.put("TMTail", tmTail);
		// Add the header, packet and tail to the frame container. 
		ArrayList<IContainer> containersToAdd = new ArrayList<IContainer>(3);
		containersToAdd.add(tmHeader);
		containersToAdd.add(tmPacket);
		containersToAdd.add(tmTail);
		tmFrame.addContainer(containersToAdd);

		/** Build the lower packet level of the model **/
		// Create the packet header and add it to the containers collection. 
		Container tmPacketHeader = new Container("TMPacketHeader", "Test packet header", "Test TM packet header for unit testing");
		containers.put("TMPacketHeader", tmPacketHeader);
		
		// Create the apid (ID) parameter type and add it to the packet header.
		//TODO are parameter types and/or parameters added to the containers colleciton?
		ParameterType paramTypeApid = new ParameterType("Apid", "Apid type", "Parameter type for the Apid", eParameterType.INTEGER, false, 0, 11);
		IntegerParameter paramApid = new IntegerParameter("ApId", "Test Apid", "Test Application Id", paramTypeApid, 0);
		tmPacketHeader.addContainer(paramApid);
		
		// Create the packet body containing
		Container tmPacketBody = new Container("TMPacketBody", "Test packet body", "Test TM packet header for unit testing");
		tmPacketBody.addRestriction(paramApid, "555"); //TODO restriction on packet body?
		containers.put("TMPacketBody", tmPacketBody);
		
		ParameterType test32bitInt = new ParameterType("test32bitInt", "test param", "32 bit int test param",eParameterType.INTEGER, true, 0, 32);
		IntegerParameter testValue = new IntegerParameter("Test param value", "test param", "test param holding a value", test32bitInt, 5000);
		Container packetTypeA = new Container("TMPacketTypeA", "Test packet body", "Test TM packet for unit testing");
		packetTypeA.addContainer(testValue);
		containers.put("TMPacketTypeA", packetTypeA);
		Container packetTypeB = new Container("TMPacketTypeB", "Test packet body", "Test TM packet for unit testing");
		containers.put("TMPacketTypeB", packetTypeB);
		
		List<IContainer> packetInners = new ArrayList<IContainer>(2);
		packetInners.add(tmPacketHeader);
		packetInners.add(tmPacketBody);
		tmPacket.addContainer(packetInners);

		this.initialised = true;
	}

	@Override
	public IContainer getContainer(String name) throws UnknownContainerNameException {
		if (initialised == false) {
			initialise();
		}

		Container container = containers.get(name);

		if (container == null) {
			throw new UnknownContainerNameException(containers, "Your container lookup for '" + name + "' did not return any containers. Check your SpaceSystem configuration.");
		}

		return container;
	}

	@Override
	public Map<String, Parameter> getAllParameters() {
		return parameters;
	}

	@Override
	public Parameter getParameter(String name) {
		if (initialised == false) {
			initialise();
		}
		return parameters.get(name);
	}

}
