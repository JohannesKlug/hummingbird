package com.logica.hummingbird.validation.packet;

import com.logica.hummingbird.validation.TmPacketDummy;

public interface IPacketRule {
	public void check(TmPacketDummy packet);
	public boolean rule(TmPacketDummy parameter);

}
