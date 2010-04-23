package com.logica.hummingbird.xtce;

import org.junit.Before;
import org.junit.Test;

public class XtceTest {

	XtceModelFactory xtceFactory;

	@Before
	public void setUp() throws Exception {
		xtceFactory = new XtceModelFactory("src/main/resources/humsat.xml");
//		xtceFactory.setSpacesystemmodelFilename("src/main/resources/humsat.xml");
	}

	@Test
	public void TestContainers() throws Exception {

//		xtceFactory.initialise();
		System.out.println(xtceFactory.getAllParameters());

		System.out.println("TMFrameHeader: " + xtceFactory.getContainer("TMFrameHeader").getSubContainers());
		System.out.println("TMFrameTail: " + xtceFactory.getContainer("TMFrameTail").getSubContainers());

		System.out.println("Parameters: " + xtceFactory.getAllParameters().values());

	}

}
