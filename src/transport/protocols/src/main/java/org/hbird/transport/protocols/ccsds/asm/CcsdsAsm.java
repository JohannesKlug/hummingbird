package org.hbird.transport.protocols.ccsds.asm;

import java.io.IOException;
import java.io.InputStream;
import java.util.Observable;

import org.apache.commons.lang.ArrayUtils;

public class CcsdsAsm extends Observable {
	
	private static byte[] ASM;
	private int currentByte = 0;
	
	public CcsdsAsm(byte[] asm) {
		ASM = asm;
	}
	
	public void readFromStream(InputStream is) {
		
		int[] receivedData = ArrayUtils.EMPTY_INT_ARRAY;
		int b;
		
		try {
			while ((b = is.read()) != -1 ) {
				ArrayUtils.add(receivedData, b);
				
				if (b == (ASM[currentByte] & 0xFF)) {
					// Received byte is the expected part of the ASM.
					currentByte++;
					if (currentByte == ASM.length) {
						// all ASM bytes have been encountered.
						currentByte = 0;
						
						// remove ASM bytes from received data
						for (byte asmByte : ASM) {
							ArrayUtils.remove(receivedData, receivedData.length-1);
						}
					}
				} else {
					// Received byte not part of the ASM. Reset current byte "pointer".
					currentByte = 0;
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}
	
	// FIXME This mehthod should be put into commons.
	private byte[] convertToByteArray(int[] input) {
		byte[] outputBytes = ArrayUtils.EMPTY_BYTE_ARRAY;
		
		for (int i : input) {
			outputBytes = ArrayUtils.add(outputBytes, (byte) (i & 0xFF) );
		}
		
		return outputBytes;
	}

}
