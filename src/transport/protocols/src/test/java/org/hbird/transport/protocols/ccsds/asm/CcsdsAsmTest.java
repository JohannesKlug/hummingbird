package org.hbird.transport.protocols.ccsds.asm;

import java.util.Observable;
import java.util.Observer;

import org.junit.Before;


public class CcsdsAsmTest implements Observer {
	
	private CcsdsAsm asm;
	
	@Before
	public void setUp() {
		byte[] asmArray = new byte[] {(byte) 0xff, };
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

}
