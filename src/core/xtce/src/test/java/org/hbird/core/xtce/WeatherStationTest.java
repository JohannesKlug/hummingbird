package org.hbird.core.xtce;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.net.URL;
import java.util.Map;

import org.hbird.core.commons.tmtc.Parameter;
import org.hbird.core.spacesystemmodel.SpaceSystemModel;
import org.hbird.core.spacesystemmodel.encoding.Encoding;
import org.hbird.core.spacesystemmodel.encoding.Encoding.BinaryRepresentation;
import org.junit.Before;
import org.junit.Test;

/**
 * @author kimmell
 *
 */
public class WeatherStationTest {

	private static final String SSM_URL = "WeatherStation.xml";

	private SpaceSystemModel ssm;

	@Before
	public void setUp() {
		URL url = WeatherStationTest.class.getResource(SSM_URL);
		ssm = new XtceSpaceSystemModelFactory(url.getPath()).createSpaceSystemModel();
		assertNotNull(ssm);
	}

	@Test
	public void testSpaceModel() {
		assertEquals("WeatherStation", ssm.getName());

		verifyParameters(ssm.getAllPayloadParameters());
		verifyEncodings(ssm.getEncodings());
	}

	/**
	 *
	 */
	private void verifyParameters(final Map<String, Parameter<?>> params) {
		assertEquals(6, params.size());
		Parameter<?> temperature = params.get("WeatherStation.tm.Temperature");
		assertNotNull(temperature);
		assertNull(temperature.getValue());
		assertNull(temperature.getShortDescription());
		assertNull(temperature.getLongDescription());
		assertEquals("WeatherStation.tm.Temperature", temperature.getQualifiedName());
		assertEquals("Temperature", temperature.getName());

		Parameter<?> windSpeed = params.get("WeatherStation.tm.WindSpeed");
		assertNotNull(windSpeed);
		assertNull(windSpeed.getValue());
		assertNull(windSpeed.getShortDescription());
		assertNull(windSpeed.getLongDescription());
		assertEquals("WeatherStation.tm.WindSpeed", windSpeed.getQualifiedName());
		assertEquals("WindSpeed", windSpeed.getName());

		Parameter<?> windDirection = params.get("WeatherStation.tm.WindDirection");
		assertNotNull(windDirection);
		assertNull(windDirection.getValue());
		assertNull(windDirection.getShortDescription());
		assertNull(windDirection.getLongDescription());
		assertEquals("WeatherStation.tm.WindDirection", windDirection.getQualifiedName());
		assertEquals("WindDirection", windDirection.getName());

		Parameter<?> stationName = params.get("WeatherStation.tm.StationName");
		assertNotNull(stationName);
		assertNull(stationName.getValue());
		assertNull(stationName.getShortDescription());
		assertNull(stationName.getLongDescription());
		assertEquals("WeatherStation.tm.StationName", stationName.getQualifiedName());
		assertEquals("StationName", stationName.getName());

		Parameter<?> timestamp = params.get("WeatherStation.tm.Timestamp");
		assertNotNull(timestamp);
		assertNull(timestamp.getValue());
		assertNull(timestamp.getShortDescription());
		assertNull(timestamp.getLongDescription());
		assertEquals("WeatherStation.tm.Timestamp", timestamp.getQualifiedName());
		assertEquals("Timestamp", timestamp.getName());

		Parameter<?> image = params.get("WeatherStation.tm.Image");
		assertNotNull(image);
		assertNull(image.getValue());
		assertNull(image.getShortDescription());
		assertNull(image.getLongDescription());
		assertEquals("WeatherStation.tm.Image", image.getQualifiedName());
		assertEquals("Image", image.getName());
}

	private void verifyEncodings(final Map<String, Encoding> encodings) {
		assertEquals(6, encodings.size());

		Encoding temperatureEncoding = encodings.get("WeatherStation.tm.Temperature");
		assertNotNull(temperatureEncoding);
		assertEquals(32, temperatureEncoding.getSizeInBits());
		assertEquals(BinaryRepresentation.unsigned, temperatureEncoding.getBinaryRepresentation());

		Encoding windSpeedEncoding = encodings.get("WeatherStation.tm.WindSpeed");
		assertNotNull(windSpeedEncoding);
		assertEquals(32, windSpeedEncoding.getSizeInBits());
		assertEquals(BinaryRepresentation.unsigned, windSpeedEncoding.getBinaryRepresentation());

		Encoding windDirectionEncoding = encodings.get("WeatherStation.tm.WindDirection");
		assertNotNull(windDirectionEncoding);
		assertEquals(32, windDirectionEncoding.getSizeInBits());
		assertEquals(BinaryRepresentation.unsigned, windDirectionEncoding.getBinaryRepresentation());

		Encoding stationNameEncoding = encodings.get("WeatherStation.tm.StationName");
		assertNotNull(stationNameEncoding);
		assertEquals(0, stationNameEncoding.getSizeInBits());
		assertEquals(BinaryRepresentation.UTF8, stationNameEncoding.getBinaryRepresentation());

		Encoding timestampEncoding = encodings.get("WeatherStation.tm.Timestamp");
		assertNotNull(timestampEncoding);
		assertEquals(64, timestampEncoding.getSizeInBits());
		assertEquals(BinaryRepresentation.unsigned, timestampEncoding.getBinaryRepresentation());

		Encoding imageEncoding = encodings.get("WeatherStation.tm.Image");
		assertNotNull(imageEncoding);
		assertNull(imageEncoding.getBinaryRepresentation());
		assertEquals(0, imageEncoding.getSizeInBits());
	}
}
