package org.hbird.transport.payloadcodec;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.hbird.transport.payloadcodec.codecparameters.CodecParameter;
import org.hbird.transport.payloadcodec.exceptions.UnexpectedParameterTypeException;
import org.hbird.transport.payloadcodec.exceptions.UnknownParameterEncodingException;
import org.hbird.transport.payloadcodec.exceptions.UnsupportedParameterEncodingException;
import org.hbird.transport.spacesystemmodel.ParameterGroup;
import org.hbird.transport.spacesystemmodel.SpaceSystemModel;
import org.hbird.transport.spacesystemmodel.exceptions.ParameterNotInGroupException;
import org.hbird.transport.spacesystemmodel.exceptions.UnknownParameterGroupException;
import org.hbird.transport.spacesystemmodel.parameters.Parameter;
import org.junit.Test;

public class SpaceSystemModelCodecDecoratorTest {

	private final SpaceSystemModel ssm = new MockSpaceSystemModel();

	@Test
	public void testDecorateSpaceSystemModel() throws UnsupportedParameterEncodingException, UnknownParameterEncodingException, UnexpectedParameterTypeException, UnknownParameterGroupException, ParameterNotInGroupException {
		SpaceSystemModel codecModel = SpaceSystemModelCodecDecorator.decorateSpaceSystemModel(ssm);
		for(Parameter<Integer> p : codecModel.getIntegerParameters()) {
			if(!(p instanceof CodecParameter<?>)) {
				fail("Parameter " + p.getName() + " was not decorated by the codec decorator");
			}
			CodecParameter<Integer> cp = (CodecParameter<Integer>)p;
			assertNotNull(cp);
		}

		for(ParameterGroup pgs : codecModel.getAllParameterGroups()) {
			for(Parameter<Integer> p : pgs.getIntegerParameters()) {
				if(!(p instanceof CodecParameter<?>)) {
					fail("Parameter " + p.getName() + " was not decorated by the codec decorator");
				}
				CodecParameter<Integer> cp = (CodecParameter<Integer>)p;
				assertNotNull(cp);
			}
		}
	}

}
