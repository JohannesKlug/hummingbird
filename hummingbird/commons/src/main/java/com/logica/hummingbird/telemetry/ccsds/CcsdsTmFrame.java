package com.logica.hummingbird.telemetry.ccsds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.logica.hummingbird.telemetry.TelemetryFrame;

public class CcsdsTmFrame implements TelemetryFrame {
	/**
	 * List of Telemetry Packets contained by this frame.
	 */
	List<CcsdsTmPacket> packets = new ArrayList<CcsdsTmPacket>();

	Map<String, Object> values = new HashMap<String, Object>();

	/* (non-Javadoc)
	 * @see com.logica.hummingbird.ccsds.telemetry.TelemetryFrame#getPackets()
	 */
	public List<CcsdsTmPacket> getPackets() {
		return packets;
	}

	public void setPackets(List<CcsdsTmPacket> packets) {
		this.packets = packets;
	}

	/* (non-Javadoc)
	 * @see com.logica.hummingbird.ccsds.telemetry.TelemetryFrame#getValues()
	 */
	public Map<String, Object> getValues() {
		return values;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TmFrame [packets=");
		builder.append(packets);
		builder.append(", values=");
		builder.append(values);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("frame equals");
		// Check for comparison to self.
		if (this == obj) {
			return true;
		}

		// Check we can actually compare this object to ourselves.
		if (!(obj instanceof CcsdsTmFrame)) {
			return false;
		}
		
	    TelemetryFrame otherFrame = (TelemetryFrame)obj;
	    
	    boolean equal = packets.equals(otherFrame.getPackets());

		return equal;
	}

}
