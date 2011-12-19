package org.hbird.transport.payloadcodec;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.Map;

import org.hbird.core.commons.tmtc.Parameter;
import org.hbird.core.commons.tmtc.ParameterGroup;
import org.hbird.core.commons.tmtc.exceptions.UnknownParameterException;
import org.hbird.transport.payloadcodec.codecparameters.CodecParameter;
import org.hbird.transport.payloadcodec.codecparameters.ParameterGroupCodecDecorator;
import org.hbird.transport.payloadcodec.exceptions.NoEncodingException;
import org.hbird.transport.payloadcodec.exceptions.UnexpectedParameterTypeException;
import org.hbird.transport.payloadcodec.exceptions.UnknownParameterEncodingException;
import org.hbird.transport.payloadcodec.exceptions.UnsupportedParameterEncodingException;
import org.hbird.transport.payloadcodec.testsupport.MockSpaceSystemModel;
import org.hbird.transport.spacesystemmodel.SpaceSystemModel;
import org.hbird.transport.spacesystemmodel.exceptions.ParameterNotInGroupException;
import org.hbird.transport.spacesystemmodel.exceptions.ParameterNotInModelException;
import org.hbird.transport.spacesystemmodel.exceptions.UnknownParameterGroupException;
import org.junit.Test;

public class ParameterGroupCodecDecoratorTest {

	private final SpaceSystemModel ssm = new MockSpaceSystemModel();
	private final ParameterGroupCodecDecorator decorator = new ParameterGroupCodecDecorator(ssm.getEncodings());

	@Test
	public void testDecorateParameterGroup() throws UnsupportedParameterEncodingException, UnknownParameterEncodingException, UnexpectedParameterTypeException,
			UnknownParameterGroupException, ParameterNotInGroupException, NoEncodingException, UnknownParameterException, ParameterNotInModelException {
		Map<String, ParameterGroup> codecAwareParameterGroups = decorator.decorateParameterGroups(ssm.getParameterGroups());

		for (ParameterGroup pg : codecAwareParameterGroups.values()) {
			Map<String, Parameter<Integer>> integerParameters = pg.getIntegerParameters();
			if (integerParameters != null) {
				for (Parameter<Integer> p : integerParameters.values()) {
					if (!(p instanceof CodecParameter<?>)) {
						fail("Parameter " + p.getQualifiedName() + " was not decorated by the codec decorator");
					}
					CodecParameter<Integer> cp = (CodecParameter<Integer>) p;
					assertNotNull(cp);
				}
			}

			Map<String, Parameter<Long>> longParameters = pg.getLongParameters();
			if (longParameters != null) {
				for (Parameter<Long> p : longParameters.values()) {
					if (!(p instanceof CodecParameter<?>)) {
						fail("Parameter " + p.getQualifiedName() + " was not decorated by the codec decorator");
					}
					CodecParameter<Long> cp = (CodecParameter<Long>) p;
					assertNotNull(cp);
				}
			}
		}
	}

}
