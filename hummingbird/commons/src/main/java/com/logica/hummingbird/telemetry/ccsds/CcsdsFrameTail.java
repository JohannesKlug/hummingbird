package com.logica.hummingbird.telemetry.ccsds;

import com.logica.hummingbird.telemetry.TelemetryFrameTail;

public class CcsdsFrameTail implements TelemetryFrameTail {

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CcsdsFrameTail [\n\t\n]");
		return builder.toString();
	}

}
