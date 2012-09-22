package org.hbird.test.integration;

import java.util.Random;

import org.apache.camel.EndpointInject;
import org.apache.camel.ProducerTemplate;
import org.hbird.core.commons.tmtc.Parameter;
import org.hbird.core.commons.tmtc.ParameterGroup;
import org.hbird.core.spacesystemmodel.SpaceSystemModel;
import org.hbird.core.spacesystemmodel.exceptions.UnknownParameterGroupException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TmTcGenerator {

	private static final Logger LOG = LoggerFactory.getLogger(TmTcGenerator.class);

	private final SpaceSystemModel model;

	@EndpointInject(uri = "seda:tmSource")
	ProducerTemplate template;

	public TmTcGenerator(final SpaceSystemModel model) {
		this.model = model;
	}

	public ParameterGroup generateGroup() {
		ParameterGroup groupToEncode = null;
		try {
			groupToEncode = model.getParameterGroup("Thunderbird.tm.RocketPayload");
			if (groupToEncode.getIntegerParameters() != null) {
				for (final Parameter<Integer> parameter : groupToEncode.getIntegerParameters().values()) {
					LOG.debug("Setting value for:" + parameter.getQualifiedName());
					parameter.setValue(getRandomPositiveNumber(model.getEncodings().get(parameter.getQualifiedName()).getSizeInBits()));
				}
			}
		}
		catch (final UnknownParameterGroupException e) {
			e.printStackTrace();
			System.exit(1);
		}

		template.sendBody(groupToEncode);
		return groupToEncode;

	}

	private int getRandomPositiveNumber(final int sizeInBits) {
		final Random rand = new Random();
		return (int) (rand.nextInt() % Math.pow(2, sizeInBits));
	}

}
