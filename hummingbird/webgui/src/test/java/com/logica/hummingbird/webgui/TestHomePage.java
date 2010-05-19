package com.logica.hummingbird.webgui;

import junit.framework.TestCase;
import org.apache.wicket.util.tester.WicketTester;

import com.logica.hummingbird.webgui.ParameterDisplay;
import com.logica.hummingbird.webgui.WicketApplication;

/**
 * Simple test using the WicketTester
 */
public class TestHomePage extends TestCase
{
	private WicketTester tester;

	@Override
	public void setUp()
	{
		tester = new WicketTester(new WicketApplication());
	}

	public void testRenderMyPage()
	{
		//start and render the test page
		tester.startPage(ParameterDisplay.class);

		//assert rendered page class
		tester.assertRenderedPage(ParameterDisplay.class);

		//assert rendered label component
		tester.assertLabel("message", "Parameters received so far:");
	}
}
