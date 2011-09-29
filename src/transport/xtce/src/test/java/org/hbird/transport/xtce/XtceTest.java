package org.hbird.transport.xtce;

import java.net.URL;

import org.hbird.transport.xtce.XtceSpaceSystemModel;
import org.junit.Before;
import org.junit.Test;

public class XtceTest {

	private XtceSpaceSystemModel xtceFactory = null;

	@Before
	public void setUp() throws Exception {
		URL spacesystemmodelFilename = this.getClass().getResource("/humsat.xml");
		xtceFactory = new XtceSpaceSystemModel(spacesystemmodelFilename.getPath());
	}

	@Test
	public void TestContainers() throws Exception {

//		xtceFactory.initialise();
		System.out.println(xtceFactory.getAllParameters());

		System.out.println("TMFrameHeader: " + xtceFactory.getParameterGroup("TMFrameHeader").getSubParameterGroups());
		System.out.println("TMFrameTail: " + xtceFactory.getParameterGroup("TMFrameTail").getSubParameterGroups());

		System.out.println("Parameters: " + xtceFactory.getAllParameters().values());

	}

}
