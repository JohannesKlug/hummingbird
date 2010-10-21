package com.logica.hummingbird.protocols.slip;

import java.io.IOException;
import java.io.InputStream;
import java.util.Observable;

import org.apache.commons.lang.ArrayUtils;

/**
 * This is an implementation of a SLIP-inspired synchronisation mechanism.
 * When receiving data from a radio interface, the receiver has no means of 
 * knowing what part of a data transmission he is currently receiving.
 * 
 * To remedy this, the sender has to introduce known marker bytes into the 
 * data stream. These marker bytes may not occur unescaped in the payload 
 * data between two markers.
 * 
 */
public class Slip extends Observable {
	
	private byte end, esc, escEnd, escEsc;
	
	/**
	 *  Constructor for a Slip object: pass the agreed-upon characters for 
	 *  end marker, escape marker, escaped end marker and escaped escape marker.  
	 */
	public Slip(byte end, byte esc, byte escEnd, byte escEsc) {
		this.end = end;
		this.esc = esc;
		this.escEnd = escEnd;
		this.escEsc = escEsc;
	}
	
	public byte[] convertToSlip(byte[] input) {
		byte[] output = ArrayUtils.EMPTY_BYTE_ARRAY;
		
		/*
		 * Add each byte from the input array to the
		 */
		for (byte b : input) {
			if (b == end) {
				output = ArrayUtils.add(output, escEnd);
			} else if (b == esc) {
				output = ArrayUtils.add(output, escEsc);
			}
			output = ArrayUtils.add(output, b);
		}
		
		output = ArrayUtils.add(output, end);
		return output;
	}
	
	public void readFromStream(InputStream is) {
		
		byte[] receivedData = ArrayUtils.EMPTY_BYTE_ARRAY;
		int b;
		
		try {
			while ((b = is.read()) != -1 ) {
				
				/* 
				 * We don't want the escape bytes.
				 * We only consider them escape bytes when they are followed
				 * by the byte they are supposed to escape.
				 */ 
				if (b == escEnd) {
					if ((b = is.read()) == end) {
						// escaped end sequence found, adding 'end'
						receivedData = ArrayUtils.add(receivedData, end);
					} else {
						// not an escaped end, adding 'escEnd' and the current byte
						receivedData = ArrayUtils.add(receivedData, escEnd);
						receivedData = ArrayUtils.add(receivedData, (byte) b);
					}

				} else if (b == escEsc) {
					if ((b = is.read()) == esc) {
						// escaped esc sequence found, adding 'esc'
						receivedData = ArrayUtils.add(receivedData, esc);
					} else {
						if (b == end) {
							notifyObservers(receivedData);
							receivedData = ArrayUtils.EMPTY_BYTE_ARRAY;
						}
						// not an escaped esc, adding 'escEsc' and the current byte
						receivedData = ArrayUtils.add(receivedData, escEsc);
						receivedData = ArrayUtils.add(receivedData, (byte) b);
					}
				} else if (b == end) {
					notifyObservers(receivedData);
					receivedData = ArrayUtils.EMPTY_BYTE_ARRAY;
				} else {
					receivedData = ArrayUtils.add(receivedData, (byte) b);
				}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
