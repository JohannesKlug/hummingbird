package org.hbird.application.spacedynamics.tle;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.junit.BeforeClass;
import org.junit.Test;
import org.orekit.data.DataProvidersManager;
import org.orekit.data.ZipJarCrawler;
import org.orekit.errors.OrekitException;

public class TleCzmlUtilitiesTest {

	@BeforeClass
	public static final void setupOrekit() {
		URL url = TleCzmlUtilitiesTest.class.getResource("/orekit-data.zip");
		DataProvidersManager.getInstance().addProvider(new ZipJarCrawler(new File(url.getPath())));
	}

	@Test
	public void testCreateCzmlFromTleFile() throws IOException, OrekitException {
		URL url = getClass().getResource("cubesatTle.txt");
		File testDataFile = new File(url.getPath());

		TleCzmlkUtilities.createCzmlFromTleFile(testDataFile, "blah");
	}

}
