package org.hbird.transport.xtce;

import java.net.URL;

import org.hbird.transport.xtce.XtceModelFactory;
import org.junit.Before;
import org.junit.Test;

public class XtceTest {

	private XtceModelFactory xtceFactory = null;

	@Before
	public void setUp() throws Exception {
		URL spacesystemmodelFilename = this.getClass().getResource("/humsat.xml");
		xtceFactory = new XtceModelFactory(spacesystemmodelFilename.getPath());
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
