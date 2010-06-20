package com.logica.hummingbird.telemetry.ccsds;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CcsdsTmFrame {
	/** Logger for this class */
	private final static Logger LOG = LoggerFactory.getLogger(CcsdsTmFrame.class);

	/**
	 * This frames telemetry header.
	 */
	CcsdsTmFrameHeader frameHeader;

	/**
	 * List of Telemetry Packets contained by this frame. Initialised with an initial capacity of 1
	 */
	List<CcsdsTmPacket> packets = new ArrayList<CcsdsTmPacket>(1);

	/**
	 * This frames tail.
	 */
	CcsdsTmFrameTail frameTail;

	public CcsdsTmFrame() {
		super();
	}

	public CcsdsTmFrame(CcsdsTmFrameHeader frameHeader, List<CcsdsTmPacket> packets, CcsdsTmFrameTail frameTail) {
		super();
		this.frameHeader = frameHeader;
		this.packets = packets;
		this.frameTail = frameTail;
	}

	/*
	 * (non-Javadoc)
	 * 
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

		CcsdsTmFrame otherFrame = (CcsdsTmFrame) obj;

		boolean equal = packets.equals(otherFrame.getPackets());

		return equal;
	}

	public void setParameter(CcsdsTmNumberParameter parameter) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException {
		String name = parameter.getName();
		try {
			// Check the frame header for a parameter of this name
			Class<? extends CcsdsTmFrameHeader> headerClass = this.frameHeader.getClass();
			Field field = headerClass.getDeclaredField(name);
			if (field != null) {
				field.set(this.frameHeader, parameter.getValue());
				return;
			}

			// Check the tail for a parameter of this name
			Class<? extends CcsdsTmFrameTail> tailClass = this.frameTail.getClass();
			field = tailClass.getDeclaredField(name);
			if (field != null) {
				field.set(this.frameTail, parameter.getValue());
				return;
			}
		}
		catch (NoSuchFieldException e) {
			LOG.debug(name + " field not found in the header or tail.  Checking packets");
		}

		for (CcsdsTmPacket packet : packets) {

		}

	}

	public void setHeader(CcsdsTmFrameHeader header) {
		this.frameHeader = header;
	}

	public void addPacket(CcsdsTmPacket packet) {
		this.packets.add(packet);
	}

	public void addPackets(List<CcsdsTmPacket> packets) {
		this.packets.addAll(this.packets);
	}

	public void setTail(CcsdsTmFrameTail tail) {
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
