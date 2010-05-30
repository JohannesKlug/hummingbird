package com.logica.hummingbird.ccsds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TmFrame {
    List<TmPacket> packets = new ArrayList<TmPacket>();

    Map<String, Object> values = new HashMap<String, Object>();
    
	public List<TmPacket> getPackets() {
		return packets;
	}

	public void setPackets(List<TmPacket> packets) {
		this.packets = packets;
	}
	
	public Map<String, Object> getValues() {
		return values;
	}
}
