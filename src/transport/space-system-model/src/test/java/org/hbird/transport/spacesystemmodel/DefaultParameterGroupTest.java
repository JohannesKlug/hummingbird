package org.hbird.transport.spacesystemmodel;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class DefaultParameterGroupTest {

	@Test
	public final void testDefaultParameterGroupListOfContainers() {
		DefaultParameterGroup testParent = new DefaultParameterGroup("test parent", "shortDescription", "longDescription");
		List<ParameterGroup> parents = new ArrayList<ParameterGroup>();
		parents.add(testParent);
		DefaultParameterGroup testContainer = new DefaultParameterGroup("Test ParameterGroup", "short description", "long description", parents);
		assertEquals(parents.size(), testContainer.getParentParameterGroup().size());
		assertEquals(parents, testContainer.getParentParameterGroup());
	}

}
