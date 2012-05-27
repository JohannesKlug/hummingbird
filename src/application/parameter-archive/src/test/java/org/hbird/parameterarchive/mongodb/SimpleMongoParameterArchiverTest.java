package org.hbird.parameterarchive.mongodb;

import org.hbird.application.parameterarchive.interfaces.ParameterArchiver;
import org.hbird.core.commons.tmtc.Parameter;
import org.hbird.core.spacesystemmodel.parameters.HummingbirdParameter;
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
public class SimpleMongoParameterArchiverTest {

	@Autowired
	private ParameterArchiver parameterArchiver;

	private Parameter<Integer> testParameter;

	@Before
	public final void beforeAllTestsSetup() {
		testParameter = new HummingbirdParameter<Integer>("Test.Parameter",
				"testparam",
				"Quick test int parameter",
				"Integer parameter for mongo db testing");
		final DateTime RECEIVED_TIME = new DateTime(2012, 2, 2, 2, 2);
		testParameter.setReceivedTime(RECEIVED_TIME.getMillis());
	}

	@Test
	@Ignore // no current embedded mode for mongo db means it has to be running. Solutions are appearing...
	public void test() {
		parameterArchiver.archiveParameter(testParameter);
	}
}
