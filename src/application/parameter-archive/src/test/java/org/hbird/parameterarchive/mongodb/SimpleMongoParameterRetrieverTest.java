package org.hbird.parameterarchive.mongodb;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.hbird.core.commons.tmtc.Parameter;
import org.hbird.core.spacesystemmodel.parameters.HummingbirdParameter;
import org.hbird.parameterarchive.interfaces.ParameterRetriever;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class SimpleMongoParameterRetrieverTest {

	@Autowired
	private ParameterRetriever parameterRetriever;

	private Parameter<Integer> testParameter;

	@Before
	public final void beforeAllTestsSetup() {
		testParameter = new HummingbirdParameter<Integer>("Test.Parameter",
				"testparam",
				"Quick test int parameter",
				"Integer parameter for mongo db testing");
	}

	@Test
	@Ignore // no current embedded mode for mongo db means it has to be running. Solutions are appearing...
	public void test() {
		parameterRetriever.findParamerers(testParameter.getQualifiedName());
	}

	@Test
	@Ignore // Tests require mongo db therefore not unit tests!
	public void testDataRangeRetrieval() {
		DateTime startDate = new DateTime(2012, 1, 1, 1, 1);
		DateTime endDate = new DateTime();
		List<Parameter> actual = parameterRetriever.findParameters(startDate.toDate(), endDate.toDate());
		assertEquals(2, actual.size());
		for(Parameter<Integer> p : actual) {
			System.out.println(p);
		}
	}
}
