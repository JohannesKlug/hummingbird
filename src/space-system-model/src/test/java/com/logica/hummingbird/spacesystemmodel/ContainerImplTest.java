package com.logica.hummingbird.spacesystemmodel;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class ContainerImplTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public final void testContainerImplStringStringStringListOfContainer() {
		ContainerImpl testParent = new ContainerImpl("test parent", "shortDescription", "longDescription");
		List<Container> parents = new ArrayList<Container>();
		parents.add(testParent);
		ContainerImpl testContainer = new ContainerImpl("Test Container", "short description", "long description", parents);
		assertEquals(parents.size(), testContainer.getParents().size());
		assertEquals(parents, testContainer.getParents());
	}

	@Test
	@Ignore
	public final void testGetRawValue() {
	}

}
