package com.logica.hummingbird.telemetry;

import java.util.List;
import java.util.Map;

import com.logica.hummingbird.telemetry.ccsds.CcsdsTmPacket;

public interface TelemetryFrame {

	public abstract List<CcsdsTmPacket> getPackets();

}