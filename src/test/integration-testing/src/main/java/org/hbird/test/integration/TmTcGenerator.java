package org.hbird.test.integration;

import org.hbird.transport.spacesystemmodel.SpaceSystemModel;
import org.hbird.transport.spacesystemmodel.exceptions.UnknownParameterGroupException;
import org.hbird.transport.spacesystemmodel.parameters.Parameter;
import org.hbird.transport.spacesystemmodel.tmtcgroups.ParameterGroup;

public class TmTcGenerator {
	
	private SpaceSystemModel model;
	
	public TmTcGenerator(SpaceSystemModel model) {
		this.model = model;
	}
	
	
	public ParameterGroup generateGroup() {
		ParameterGroup groupToEncode = null;
		try {
			groupToEncode = model.getParameterGroup("Thunderbird.tm.RocketPayload");
			if (groupToEncode.getParameterReport().getNumberIntParameters() >0) {
				for (Parameter<Integer> parameter : groupToEncode.getIntegerParameters().values()) {
					parameter.setValue(1);
				}
			}
		}
		catch (UnknownParameterGroupException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		return groupToEncode;
		
	}

}
