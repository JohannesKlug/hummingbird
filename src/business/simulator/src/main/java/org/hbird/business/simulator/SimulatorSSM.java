package org.hbird.business.simulator;

import java.util.BitSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.camel.EndpointInject;
import org.apache.camel.ProducerTemplate;
import org.hbird.business.simulator.waveforms.Waveform;
import org.hbird.transport.commons.util.BitSetUtility;
import org.hbird.transport.commons.util.exceptions.BitSetOperationException;
import org.hbird.transport.spacesystemmodel.ParameterGroup;
import org.hbird.transport.spacesystemmodel.SpaceSystemModelFactory;
import org.hbird.transport.spacesystemmodel.exceptions.UnknownParameterGroupException;
import org.hbird.transport.spacesystemmodel.parameters.Parameter;
import org.hbird.transport.spacesystemmodel.parameters.DefaultParameter;

/**
 * CCSDS Space System model defined telemetry simulator. Acronyms used: SSM = Space System Model
 * 
 * @author Mark Doyle
 * @author Johannes Klug
 * 
 */
public class SimulatorSSM {

	@EndpointInject(uri = "seda:simMessages")
	ProducerTemplate template;

	/** Root packet {@link ParameterGroup} name */
	private static String packetHeaderAlias;

	/** Factory producing the SSM */
	SpaceSystemModelFactory ssmFactory;
	ParameterGroup packetRoot;
	Map<String, DefaultParameter> allParams;

	private Map<String, Waveform> waveformMap;

	private long messageInterval = 1000;

	public Map<String, Waveform> getWaveformMap() {
		return waveformMap;
	}

	public void setWaveformMap(final Map<String, Waveform> waveformMap) {
		this.waveformMap = waveformMap;
	}

	public void setMessageInterval(final long messageInterval) {
		this.messageInterval = messageInterval;
	}

	public SimulatorSSM(final SpaceSystemModelFactory spaceSystemModelFactory, final String packetRootName) throws UnknownParameterGroupException {
		this.ssmFactory = spaceSystemModelFactory;
		this.packetRoot = ssmFactory.getParameterGroup(packetRootName);
		this.allParams = ssmFactory.getAllParameters();
	}

	public final Collection<DefaultParameter> getAllParameters() {
		return this.ssmFactory.getAllParameters().values();
	}

	/**
	 * Returns the Telemetry container sets. These are the abstract containers that group related parameters together.
	 * 
	 * @param packetNode
	 * @param sections
	 * @return
	 * @throws UnknownParameterGroupException
	 */
	public final List<ParameterGroup> getAllPacketSections(final String packetNode, final List<ParameterGroup> sections) throws UnknownParameterGroupException {
		ParameterGroup packetSection = this.ssmFactory.getParameterGroup(packetNode);

		if (!(packetSection instanceof DefaultParameter)) {
			System.out.println("Adding section " + packetSection.getName());
			sections.add(packetSection);

			for (ParameterGroup c : packetSection.getSubParameterGroups()) {
				this.getAllPacketSections(c.getName(), sections);
			}
			System.out.println("Found " + sections.size() + " Packet sections");
		}

		return sections;
	}

	public final Collection<ParameterGroup> getAllContainers() {
		return this.ssmFactory.getAllParameterGroups();
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
				((DefaultParameter) p).setValue(Integer.parseInt(val));
				packetRoot.getSubParameterGroups();
			}
		}
	}

	public synchronized BitSet encode(final String name, final Map<String, Double> fields) throws BitSetOperationException, UnknownParameterGroupException {
		for (Map.Entry<String, Double> entry : fields.entrySet()) {
			DefaultParameter parameter = ssmFactory.getParameter(entry.getKey());
			if (parameter == null) {
				throw new UnknownParameterGroupException(entry.getKey());
			}
			else {
				parameter.setValue(entry.getValue());
			}
		}

		BitSet packet = new BitSet();
		ssmFactory.getParameterGroup(name).marshall(packet, 0);
		return packet;
	}

	public void generateMessage() {
		Map<String, Double> fields = new HashMap<String, Double>();

		for (Map.Entry<String, Waveform> entry : waveformMap.entrySet()) {
			fields.put(entry.getKey(), entry.getValue().nextValue());
		}

		BitSet encodedPacketAsBitset;
		try {
			encodedPacketAsBitset = encode(packetRoot.getName(), fields);
			template.sendBody(BitSetUtility.toByteArray(encodedPacketAsBitset, encodedPacketAsBitset.size()));
		}
		catch (BitSetOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (UnknownParameterGroupException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	//Setter is needed only for the Humsat-integrationtest of the Transport Tier.  
	public void setTemplate(ProducerTemplate template) {
		this.template = template;
	}
}
