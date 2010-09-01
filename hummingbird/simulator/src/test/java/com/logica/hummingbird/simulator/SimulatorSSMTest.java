package com.logica.hummingbird.simulator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.logica.hummingbird.spacesystemmodel.parameters.Parameter;
import com.logica.hummingbird.spacesystemmodel.testsupport.MockParameterContainerModel;

public class SimulatorSSMTest {
	
	SimulatorSSM sim;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		sim = new SimulatorSSM(new MockParameterContainerModel(), MockParameterContainerModel.TM_PACKET_ALIAS);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Ignore
	@Test
	public void testGetAllParameters() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testGetContainerRestrictions() {
		Map<Parameter, List<String>> restrictions = sim.getAllParameterRestrictions();
		assertEquals(restrictions.size(), 1);
		assertEquals(restrictions.get(sim.ssmFactory.getParameter(MockParameterContainerModel.PAYLOAD_APID_ALIAS)).size(), 3);
	}
	
	@Test
	public void testgetPackets() {
		sim.getPackets();
	}

}
