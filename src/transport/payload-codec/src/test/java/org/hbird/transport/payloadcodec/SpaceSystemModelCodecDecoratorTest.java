package org.hbird.transport.payloadcodec;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.hbird.transport.payloadcodec.codecparameters.CodecParameter;
import org.hbird.transport.payloadcodec.exceptions.NoEncodingException;
import org.hbird.transport.payloadcodec.exceptions.UnexpectedParameterTypeException;
import org.hbird.transport.payloadcodec.exceptions.UnknownParameterEncodingException;
import org.hbird.transport.payloadcodec.exceptions.UnsupportedParameterEncodingException;
import org.hbird.transport.payloadcodec.testsupport.MockSpaceSystemModel;
import org.hbird.transport.spacesystemmodel.SpaceSystemModel;
import org.hbird.transport.spacesystemmodel.exceptions.ParameterNotInGroupException;
import org.hbird.transport.spacesystemmodel.exceptions.ParameterNotInModelException;
import org.hbird.transport.spacesystemmodel.exceptions.UnknownParameterException;
import org.hbird.transport.spacesystemmodel.exceptions.UnknownParameterGroupException;
import org.hbird.transport.spacesystemmodel.parameters.Parameter;
import org.hbird.transport.spacesystemmodel.tmtcgroups.ParameterGroup;
import org.junit.Test;

public class SpaceSystemModelCodecDecoratorTest {

	private final SpaceSystemModel ssm = new MockSpaceSystemModel();
	SpaceSystemModelCodecDecorator decorator = new SpaceSystemModelCodecDecorator();

	@Test
	public void testDecorateSpaceSystemModel() throws UnsupportedParameterEncodingException, UnknownParameterEncodingException, UnexpectedParameterTypeException, UnknownParameterGroupException, ParameterNotInGroupException, NoEncodingException, UnknownParameterException, ParameterNotInModelException {
		SpaceSystemModel codecModel = decorator.decorateSpaceSystemModel(ssm, ssm.getEncodings());

		for(Parameter<Integer> p : codecModel.getAllUniqueIntegerParameters().values()) {
			if(!(p instanceof CodecParameter<?>)) {
				fail("Parameter " + p.getQualifiedName() + " was not decorated by the codec decorator");
			}
			CodecParameter<Integer> cp = (CodecParameter<Integer>)p;
			assertNotNull(cp);
		}

		for(ParameterGroup pgs : codecModel.getParameterGroupsCollection()) {
			if (pgs.getIntegerParameters() != null) {
				for(Parameter<Integer> p : pgs.getIntegerParameters().values()) {
					if(!(p instanceof CodecParameter<?>)) {
						fail("Parameter " + p.getQualifiedName() + " was not decorated by the codec decorator");
					}
					CodecParameter<Integer> cp = (CodecParameter<Integer>)p;
					assertNotNull(cp);
				}
			}
		}
	}

}
