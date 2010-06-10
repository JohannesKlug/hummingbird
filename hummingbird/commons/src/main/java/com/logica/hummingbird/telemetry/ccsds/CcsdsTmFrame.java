package com.logica.hummingbird.telemetry.ccsds;

import java.util.ArrayList;
import java.util.List;

import com.logica.hummingbird.telemetry.TelemetryFrame;
import com.logica.hummingbird.telemetry.TelemetryFrameHeader;
import com.logica.hummingbird.telemetry.TelemetryFrameTail;
import com.logica.hummingbird.telemetry.TelemetryPacket;

public class CcsdsTmFrame implements TelemetryFrame {
	
	/**
	 * This frames telemetry header.
	 */
	TelemetryFrameHeader frameHeader;
	
	/**
	 * List of Telemetry Packets contained by this frame.
	 * Initialised with an initial capacity of 1
	 */
	List<TelemetryPacket> packets = new ArrayList<TelemetryPacket>(1);
	
	/**
	 * This frames tail.
	 */
	TelemetryFrameTail frameTail;
	
	public CcsdsTmFrame() {
		super();
	}

	public CcsdsTmFrame(TelemetryFrameHeader frameHeader, List<TelemetryPacket> packets, TelemetryFrameTail frameTail) {
		super();
		this.frameHeader = frameHeader;
		this.packets = packets;
		this.frameTail = frameTail;
	}


	/* (non-Javadoc)
	 * @see com.logica.hummingbird.ccsds.telemetry.TelemetryFrame#getPackets()
	 */
	public List<TelemetryPacket> getPackets() {
		return packets;
	}

	public void setPackets(List<TelemetryPacket> packets) {
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
	public void setHeader(TelemetryFrameHeader header) {
		this.frameHeader = header;
	}

	@Override
	public void addPacket(TelemetryPacket packet) {
		this.packets.add(packet);
	}

	@Override
	public void addPackets(List<TelemetryPacket> packets) {
		this.packets.addAll(this.packets);
	}

	@Override
	public void setTail(TelemetryFrameTail tail) {
		this.frameTail = tail;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CcsdsTmFrame [\n\tframeHeader = ");
		builder.append(frameHeader);
		builder.append("\n\tpackets = ");
		builder.append(packets);
		builder.append("\n\tframeTail = ");
		builder.append(frameTail);
		builder.append("\n]");
		return builder.toString();
	}

}
