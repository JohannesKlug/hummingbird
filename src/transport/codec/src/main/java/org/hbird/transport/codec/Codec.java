package org.hbird.transport.codec;

public class Codec implements Runnable {
	
	public static String INT = "INT";
	public static String STRING = "STRING";

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
	
	public static Object anythingFromBytes(byte[] bytes, String encoding) throws Exception {
		if (encoding == INT) {
			return bigEndianIntFromBytes(bytes);
		} else if (encoding == STRING) {
			return stringFromBytes(bytes);
		} else {
			throw new Exception("Argh! I can't decode '" + encoding + "'.");
		}
		
	}
}
