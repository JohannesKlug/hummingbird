package com.logica.hummingbird.simulator;

import java.util.Map;

import com.logica.hummingbird.spacesystemmodel.Container;
import com.logica.hummingbird.spacesystemmodel.ContainerFactory;
import com.logica.hummingbird.spacesystemmodel.exceptions.UnknownContainerNameException;
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
		this.allParams = ssmFactory.getAllParameters();
	}

}
