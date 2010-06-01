package com.logica.hummingbird.ccsds.telemetry;

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

	/* (non-Javadoc)
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
	
	
}
