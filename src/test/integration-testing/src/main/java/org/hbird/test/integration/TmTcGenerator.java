package org.hbird.test.integration;

import java.util.Random;

import org.apache.camel.EndpointInject;
import org.apache.camel.ProducerTemplate;
import org.hbird.core.commons.tmtc.Parameter;
import org.hbird.core.commons.tmtc.ParameterGroup;
import org.hbird.transport.spacesystemmodel.SpaceSystemModel;
import org.hbird.transport.spacesystemmodel.exceptions.UnknownParameterGroupException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TmTcGenerator {
	
	private static final Logger LOG = LoggerFactory.getLogger(TmTcGenerator.class);
	
	private SpaceSystemModel model;
	
    @EndpointInject(uri = "seda:tmSource")
    ProducerTemplate template;
	
	public TmTcGenerator(SpaceSystemModel model) {
		this.model = model;
	}
	
	
	public ParameterGroup generateGroup() {
		ParameterGroup groupToEncode = null;
		try {
			groupToEncode = model.getParameterGroup("Thunderbird.tm.RocketPayload");
			if (groupToEncode.getParameterReport().getNumberIntParameters() >0) {
				for (Parameter<Integer> parameter : groupToEncode.getIntegerParameters().values()) {
					LOG.debug("Setting value for:" + parameter.getQualifiedName());
					parameter.setValue(getRandomPositiveNumber(model.getEncodings().get(parameter.getQualifiedName()).getSizeInBits()));
				}
			}
		}
		catch (UnknownParameterGroupException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		template.sendBody(groupToEncode);
		return groupToEncode;
		
	}
	
	private int getRandomPositiveNumber(int sizeInBits) {
		Random rand = new Random();
		return (int) (rand.nextInt() % Math.pow(2, sizeInBits));
	}

}
