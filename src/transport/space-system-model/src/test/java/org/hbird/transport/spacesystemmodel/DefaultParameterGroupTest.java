package org.hbird.transport.spacesystemmodel;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class DefaultParameterGroupTest {

	@Test
	public final void testDefaultParameterGroupListOfContainers() {
		HummingbirdParameterGroup testParent = new HummingbirdParameterGroup("test parent", "shortDescription", "longDescription");
		List<ParameterGroup> parents = new ArrayList<ParameterGroup>();
		parents.add(testParent);
		HummingbirdParameterGroup testContainer = new HummingbirdParameterGroup("Test ParameterGroup", "short description", "long description", parents);
		assertEquals(parents.size(), testContainer.getParentParameterGroup().size());
		assertEquals(parents, testContainer.getParentParameterGroup());
	}

}
