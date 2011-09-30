package org.hbird.transport.codec;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

public class Codec implements Runnable {
	
    public void run() {
        for (long i=Long.MIN_VALUE; i<Long.MAX_VALUE; i++) {
        	long dummy = i;
        	if (dummy == 1) {
        		dummy = 1;
        	}
        }
    }

    public static void main(String args[]) {
    	// 8-core test. Works :) 800% CPU usage.
        (new Thread(new Codec())).start();
        (new Thread(new Codec())).start();
        (new Thread(new Codec())).start();
        (new Thread(new Codec())).start();
        (new Thread(new Codec())).start();
        (new Thread(new Codec())).start();
        (new Thread(new Codec())).start();
        (new Thread(new Codec())).start();
    }

	public static int bigEndianIntFromBytes(byte[] bytes) {
		int result;
		result = (bytes[0]&0xFF) << 24;
		result += (bytes[1]&0xFF) << 16;
		result += (bytes[2]&0xFF) << 8;
		result += (bytes[3]&0xFF);
		return result;
	}
	
	public static String stringFromBytes(byte[] bytes) {
		return new String(bytes);
	}
	
	public static Object anythingFromBytes(byte[] bytes, Encoding encoding) throws Exception {
		if (encoding == Encoding.INT) {
			return bigEndianIntFromBytes(bytes);
		} else if (encoding == Encoding.STRING) {
			return stringFromBytes(bytes);
		} else {
			throw new Exception("Argh! I can't decode '" + encoding + "'.");
		}
		
	}
	
	public static Map<String,Object> decodeMany(byte[] bytes, List<ParameterEncoding> parameters) throws Exception {
		Map<String, Object> results = new HashMap<String, Object>();
		
		for (ParameterEncoding parameter : parameters) {
			Object result = anythingFromBytes(ArrayUtils.subarray(bytes, parameter.offset, parameter.offset+parameter.length), parameter.encoding);
			results.put(parameter.name, result);
		}
		
		return results;
	}
	
	public static byte[] extractSubArray(byte[] bytes, int bitOffset, int bitLength) throws Exception {
		if ((bytes == null) || (bytes.length == 0)) {
			throw new Exception("Cannot work without an input byte array!");
		}
		if (((bitOffset+bitLength)) > bytes.length*8) {
			throw new Exception("Cannot decode a parameter of length " + bitLength + " starting at position " + bitOffset + " when the input byte array is only " + bytes.length + " bytes in length." );
		}
		if (bitLength < 1) {
			throw new Exception("Cannot extract a parameter of length" + bitLength + ", try a length of 1 or greater." );
		}
		byte[] result = new byte[(int)bitLength/8 + ((bitLength%8 == 0) ? 0 :1)];
		// assuming Big Endian byte order
		
		// rightmost byte
		int rightmostByteIndex = (bitOffset+bitLength)/8 - ((bitLength%8 == 0) ? 1 :0);
		
		// amount of shifts
		int shift = (8 -(bitOffset + bitLength) % 8) % 8;
		System.out.println("shift: " + shift);
		
		// mask must set all bits to 1 which aren't shifted
//		int mask = (0xFF >> shift) << shift;
		int mask = ((int)Math.pow(2, bitLength) - 1) << shift;
		
		
		System.out.println("mask: " + mask);
		System.out.println("result.length: " + result.length);
		for (int i = result.length -1; i>=0; i--) {
//			System.out.println("i: " + i);
			int currentInputByte = rightmostByteIndex-result.length+i+1;
//			System.out.println("currentInputByte: " + currentInputByte);
			result[i] = (byte) ((bytes[currentInputByte] & mask) >> shift);
		}
		
		return result;
		
	}
}
