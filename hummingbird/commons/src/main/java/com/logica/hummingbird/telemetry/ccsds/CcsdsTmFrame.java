package com.logica.hummingbird.telemetry.ccsds;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

import com.logica.hummingbird.telemetry.FrameHeader;
import com.logica.hummingbird.telemetry.FrameTail;
import com.logica.hummingbird.telemetry.TelemetryFrame;

public class CcsdsTmFrame implements TelemetryFrame {
	
	FrameHeader frameHeader;
	
	/**
	 * List of Telemetry Packets contained by this frame.
	 */
	List<CcsdsTmPacket> packets = new ArrayList<CcsdsTmPacket>();
	
	FrameTail frameTail;

	
//	Map<String, Object> values = new HashMap<String, Object>();

	/* (non-Javadoc)
	 * @see com.logica.hummingbird.ccsds.telemetry.TelemetryFrame#getPackets()
	 */
	public List<CcsdsTmPacket> getPackets() {
		return packets;
	}

	public void setPackets(List<CcsdsTmPacket> packets) {
		this.packets = packets;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CcsdsTmFrame [framTail=");
		builder.append(frameTail);
		builder.append(", frameHeader=");
		builder.append(frameHeader);
		builder.append(", packets=");
		builder.append(packets);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public void setValue(String field, BitSet value) {
		// TODO Auto-generated method stub
		
	}

}
