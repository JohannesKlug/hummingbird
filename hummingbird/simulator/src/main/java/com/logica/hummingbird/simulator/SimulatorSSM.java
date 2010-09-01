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
 * Acronyms used:
 * SSM = Space System Model
 * @author Mark Doyle
 *
 */
public class SimulatorSSM {
	
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
	
	public final Map<Parameter, List<String>> getAllParameterRestrictions() {
		Map<Parameter, List<String>> restrictions = ssmFactory.getAllParameterRestrictions();
		for(Parameter p : restrictions.keySet()) {
			System.out.print("Possible " + p.getName() + " restrictions are: ");
			for(String val : restrictions.get(p)) {
				System.out.print(val + " ");
			}
			System.out.println();
		}

		return restrictions;
	}
	
	public final void getPackets() {
		Map<Parameter, List<String>> restrictions = this.getAllParameterRestrictions();
		
		for(Parameter p : restrictions.keySet()) {
			for(String val : restrictions.get(p)) {
				((ParameterContainer)p).setValue(Integer.parseInt(val));
				System.out.println(packetRoot);
			}
		}
	}

}
