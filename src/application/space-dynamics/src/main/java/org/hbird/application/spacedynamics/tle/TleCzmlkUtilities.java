package org.hbird.application.spacedynamics.tle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.orekit.errors.OrekitException;
import org.orekit.frames.Frame;
import org.orekit.frames.FramesFactory;
import org.orekit.propagation.analytical.tle.TLE;
import org.orekit.propagation.analytical.tle.TLEPropagator;
import org.orekit.time.AbsoluteDate;
import org.orekit.time.TimeScalesFactory;
import org.orekit.utils.PVCoordinates;

public class TleCzmlkUtilities {

	private static final int SAT_NAME_LINE_ORDINAL = 0;

	public static final String createCzmlFromTleFile(File tleFile, String... satNames) throws IOException, OrekitException {
		String czml = null;

		BufferedReader bufRead = new BufferedReader(new FileReader(tleFile));

		int count = 0;
		String line = null;

		while ((line = bufRead.readLine()) != null) {
			int ordinal = count++ % 3;
			if (ordinal == SAT_NAME_LINE_ORDINAL) {
				String satName = line.trim();
				String tleLine1 = line = bufRead.readLine();
				String tleLine2 = line = bufRead.readLine();

				TLE tle = new TLE(tleLine1, tleLine2);

				Frame frame = FramesFactory.getEME2000();
				TLEPropagator proper = TLEPropagator.selectExtrapolator(tle);

				DateTime nowUtc = DateTime.now(DateTimeZone.UTC);
				DateTime endProp = nowUtc.plusMinutes(10);

				AbsoluteDate start = new AbsoluteDate(nowUtc.toDate(), TimeScalesFactory.getUTC());
				AbsoluteDate end = new AbsoluteDate(endProp.toDate(), TimeScalesFactory.getUTC());

				proper.propagate(start, end);

				PVCoordinates coords = proper.getPVCoordinates(start);
				PVCoordinates coordsEnd = proper.getPVCoordinates(end);

				if (satName.contains("STRAND")) {
					Vector3D pos = coords.getPosition();
					Vector3D endPos = coordsEnd.getPosition();
					System.out.println(pos.getX() + ", " + pos.getY() + ", " + pos.getZ());
					System.out.println(endPos.getX() + ", " + endPos.getY() + ", " + endPos.getZ());
				}
				count += 2;
			}
		}

		bufRead.close();

		return czml;
	}
}
