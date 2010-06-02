package com.logica.hummingbird.telemetry;

import java.util.BitSet;
import java.util.List;

import com.logica.hummingbird.telemetry.ccsds.CcsdsTmPacket;

public interface TelemetryFrame {

	public abstract List<CcsdsTmPacket> getPackets();

	public abstract void setValue(String field, BitSet value);

}