package org.hbird.transport.payloadcodec;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.hbird.core.commons.tmtc.exceptions.UnknownParameterException;
import org.hbird.core.spacesystemmodel.SpaceSystemModel;
import org.hbird.core.spacesystemmodel.encoding.Encoding;
import org.hbird.core.spacesystemmodel.encoding.Encoding.BinaryRepresentation;
import org.hbird.core.spacesystemmodel.exceptions.ParameterNotInGroupException;
import org.hbird.core.spacesystemmodel.exceptions.ParameterNotInModelException;
import org.hbird.core.spacesystemmodel.exceptions.UnknownParameterGroupException;
import org.hbird.core.spacesystemmodel.tmtc.Parameter;
import org.hbird.core.spacesystemmodel.tmtc.ParameterGroup;
import org.hbird.core.spacesystemmodel.tmtc.provided.HummingbirdParameterGroup;
import org.hbird.transport.payloadcodec.codecdecorators.ParameterGroupCodecDecorator;
import org.hbird.transport.payloadcodec.codecparameters.CodecParameter;
import org.hbird.transport.payloadcodec.exceptions.NoEncodingException;
import org.hbird.transport.payloadcodec.exceptions.UnexpectedParameterTypeException;
import org.hbird.transport.payloadcodec.exceptions.UnknownParameterEncodingException;
import org.hbird.transport.payloadcodec.exceptions.UnsupportedParameterEncodingException;
import org.hbird.transport.payloadcodec.testsupport.MockSpaceSystemModel;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ParameterGroupCodecDecoratorTest {

	private final SpaceSystemModel ssm = new MockSpaceSystemModel();
	private final ParameterGroupCodecDecorator decorator = new ParameterGroupCodecDecorator(ssm.getEncodings());

	@Mock
	private SpaceSystemModel mockModel;

	private static Map<String, Encoding> mockEncodings;

	private ParameterGroup mockGroup;

	@Mock
	private Parameter<String> mockStringParameter;
	private static final String MOCK_STRING_PARAMETER_NAME = "MockStringParameter";

	@BeforeClass
	public static void setupEncodings() {
		mockEncodings = new HashMap<String, Encoding>(1);
		final Encoding asciiEncoding = new Encoding(8, BinaryRepresentation.ASCII);
		mockEncodings.put(MOCK_STRING_PARAMETER_NAME, asciiEncoding);
	}

	/**
	 * TODO Pre-Mockito, uses test support MockSpaceSystemModel and the ParameterGroupCodecDecorator field initialised
	 * in this class. Convert to Mockito like the other tests at some point.
	 */
	@Test
	public void testDecorateParameterGroup() throws UnsupportedParameterEncodingException, UnknownParameterEncodingException, UnexpectedParameterTypeException,
	UnknownParameterGroupException, ParameterNotInGroupException, NoEncodingException, UnknownParameterException, ParameterNotInModelException {
		final Map<String, ParameterGroup> codecAwareParameterGroups = decorator.decorateParameterGroups(ssm.getParameterGroups());

		for (final ParameterGroup pg : codecAwareParameterGroups.values()) {
			final Map<String, Parameter<Integer>> integerParameters = pg.getIntegerParameters();
			if (integerParameters != null) {
				for (final Parameter<Integer> p : integerParameters.values()) {
					if (!(p instanceof CodecParameter<?>)) {
						fail("Parameter " + p.getQualifiedName() + " was not decorated by the codec decorator");
					}
					final CodecParameter<Integer> cp = (CodecParameter<Integer>) p;
					assertNotNull(cp);
				}
			}

			final Map<String, Parameter<Long>> longParameters = pg.getLongParameters();
			if (longParameters != null) {
				for (final Parameter<Long> p : longParameters.values()) {
					if (!(p instanceof CodecParameter<?>)) {
						fail("Parameter " + p.getQualifiedName() + " was not decorated by the codec decorator");
					}
					final CodecParameter<Long> cp = (CodecParameter<Long>) p;
					assertNotNull(cp);
				}
			}
		}
	}

	@Test
	public void testDecorateStringContainingParameterGroup() throws NoEncodingException, UnsupportedParameterEncodingException,
	UnknownParameterEncodingException, UnexpectedParameterTypeException {

		final ParameterGroupCodecDecorator decorator = new ParameterGroupCodecDecorator(mockEncodings);

		// Setup
		final Map<String, ParameterGroup> parameterGroups = new HashMap<String, ParameterGroup>(1);
		mockGroup = new HummingbirdParameterGroup("Mock Group", "MG", "", "");
		parameterGroups.put("mockGroup", mockGroup);
		final Map<String, Parameter<String>> stringParameters = new HashMap<String, Parameter<String>>();
		stringParameters.put("mockStringParam", mockStringParameter);

		when(mockModel.getParameterGroups()).thenReturn(parameterGroups);
		when(mockStringParameter.getQualifiedName()).thenReturn(MOCK_STRING_PARAMETER_NAME);

		mockGroup.addStringParameter(mockStringParameter);

		final Map<String, ParameterGroup> codecAwareParameterGroups = decorator.decorateParameterGroups(mockModel.getParameterGroups());

		for (final ParameterGroup pg : codecAwareParameterGroups.values()) {
			final Map<String, Parameter<String>> decoratedStringParameters = pg.getStringParameters();
			if (decoratedStringParameters != null) {
				for (final Parameter<String> p : decoratedStringParameters.values()) {
					if (!(p instanceof CodecParameter<?>)) {
						fail("Parameter " + p.getQualifiedName() + " was not decorated by the codec decorator");
					}
					final CodecParameter<String> cp = (CodecParameter<String>) p;
					assertNotNull(cp);
				}
			}
		}

	}

}
