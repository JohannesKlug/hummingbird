package com.logica.hummingbird.ccsds;

import java.util.ArrayList;
import java.util.List;

public class TmFrame {
    List<TmPacket> packets = new ArrayList<TmPacket>();

	public List<TmPacket> getPackets() {
		return packets;
	}

	public void setPackets(List<TmPacket> packets) {
		this.packets = packets;
	}
}
