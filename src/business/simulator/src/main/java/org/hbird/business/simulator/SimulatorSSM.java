package org.hbird.business.simulator;

import java.util.BitSet;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hbird.transport.commons.util.exceptions.BitSetOperationException;
import org.hbird.transport.spacesystemmodel.Container;
import org.hbird.transport.spacesystemmodel.ContainerFactory;
import org.hbird.transport.spacesystemmodel.exceptions.UnknownContainerNameException;
import org.hbird.transport.spacesystemmodel.parameters.Parameter;
import org.hbird.transport.spacesystemmodel.parameters.ParameterContainer;

/**
 * CCSDS Space System model defined telemetry simulator. Acronyms used: SSM = Space System Model
 * 
 * @author Mark Doyle
 * @author Johannes Klug
 * 
 */
public class SimulatorSSM implements Runnable {

	/** Root packet {@link Container} name */
	private static String packetHeaderAlias;

	/** Factory producing the SSM */
	ContainerFactory ssmFactory;
	Container packetRoot;
	Map<String, ParameterContainer> allParams;

	public SimulatorSSM(ContainerFactory spaceSystemModelFactory, String packetRootName) throws UnknownContainerNameException {
		this.ssmFactory = spaceSystemModelFactory;
		this.packetRoot = ssmFactory.getContainer(packetRootName);
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
	
	public synchronized BitSet encode(String name, Map<String, Double> fields) throws BitSetOperationException, UnknownContainerNameException {
		for (Map.Entry<String, Double> entry : fields.entrySet()) {
			ParameterContainer parameter = ssmFactory.getParameter((String) entry.getKey());
			if (parameter == null) {
				throw new UnknownContainerNameException(entry.getKey());
			} else {
				parameter.setValue(entry.getValue());
			}
		}
		
		BitSet packet = new BitSet();
		ssmFactory.getContainer(name).marshall(packet, 0);
		return packet;
	}

	public void run() {
		System.out.println("Running sim - NOT YET IMPLEMENTED");
	}

}
