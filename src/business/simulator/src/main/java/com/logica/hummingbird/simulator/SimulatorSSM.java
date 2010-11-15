package com.logica.hummingbird.simulator;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.logica.hummingbird.spacesystemmodel.Container;
import com.logica.hummingbird.spacesystemmodel.ContainerFactory;
import com.logica.hummingbird.spacesystemmodel.exceptions.UnknownContainerNameException;
import com.logica.hummingbird.spacesystemmodel.parameters.Parameter;
import com.logica.hummingbird.spacesystemmodel.parameters.ParameterContainer;
import com.logica.hummingbird.xtce.XtceModelFactory;
import com.logica.hummingbird.xtce.exceptions.InvalidXtceFileException;

/**
 * CCSDS Space System model defined telemetry simulator. Acronyms used: SSM = Space System Model
 * 
 * @author Mark Doyle
 * 
 */
public class SimulatorSSM implements Runnable {

	private static String packetHeaderAlias;

	ContainerFactory ssmFactory;
	Container packetRoot;
	Map<String, ParameterContainer> allParams;

	public SimulatorSSM(ContainerFactory spaceSystemModelFactory, String packetRootName) throws UnknownContainerNameException {
		this.ssmFactory = spaceSystemModelFactory;
		this.packetRoot = ssmFactory.getContainer(packetRootName);
		this.allParams = ssmFactory.getAllParameters();
	}

	public SimulatorSSM(String xtceSsmFilePath, String packetRootName) throws UnknownContainerNameException, InvalidXtceFileException {
		this.ssmFactory = new XtceModelFactory(xtceSsmFilePath);
		this.packetRoot = ssmFactory.getContainer(packetRootName);
		System.out.println("packet root container = " + packetRoot.toString());
		this.allParams = ssmFactory.getAllParameters();
	}

	public final Collection<ParameterContainer> getAllParameters() {
		return this.ssmFactory.getAllParameters().values();
	}

	/**
	 * Returns the Telemetry sections. These are the abstract containers that group related parameters together.
	 * 
	 * @param packetNode
	 * @param sections
	 * @return
	 * @throws UnknownContainerNameException
	 */
	public final List<Container> getAllPacketSections(String packetNode, List<Container> sections) throws UnknownContainerNameException {
		Container packetSection = this.ssmFactory.getContainer(packetNode);

		if (!(packetSection instanceof ParameterContainer)) {
			System.out.println("Adding section " + packetSection.getName());
			sections.add(packetSection);

			for (Container c : packetSection.getSubContainers()) {
				this.getAllPacketSections(c.getName(), sections);
			}
			System.out.println("Found " + sections.size() + " Packet sections");
		}

		return sections;
	}

	public final Collection<Container> getAllContainers() {
		return this.ssmFactory.getAllContainers();
	}

	public final Map<Parameter, List<String>> getAllParameterRestrictions() {
		Map<Parameter, List<String>> restrictions = ssmFactory.getAllParameterRestrictions();
		for (Parameter p : restrictions.keySet()) {
			System.out.print("Possible " + p.getName() + " restrictions are: ");
			for (String val : restrictions.get(p)) {
				System.out.print(val + " ");
			}
			System.out.println();
		}

		return restrictions;
	}

	public final void getPackets() {
		Map<Parameter, List<String>> restrictions = this.getAllParameterRestrictions();

		for (Parameter p : restrictions.keySet()) {
			for (String val : restrictions.get(p)) {
				((ParameterContainer) p).setValue(Integer.parseInt(val));
				packetRoot.getSubContainers();
			}
		}
	}

	public void run() {
		System.out.println("Running sim - NOT YET IMPLEMENTED");
	}

}
