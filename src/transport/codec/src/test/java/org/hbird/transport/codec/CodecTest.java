package org.hbird.transport.codec;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class CodecTest {
	
	private long performanceTestRuns = Integer.MAX_VALUE/1000;
	
	@Test
	public void intFromBytes() {
		byte[] anArray = {(byte) 0x2A, (byte) 0xAA, (byte) 0xAA, (byte) 0xAA};
		int expected = 715827882;
		
		int result = Codec.bigEndianIntFromBytes(anArray);
		
		assertEquals(expected, result);
	}
	
	@Test
	public void stringFromBytes() {
		byte[] anArray = {(byte) '\u0048', (byte) '\u0062', (byte) '\u0069', (byte) '\u0072', (byte) '\u0064' };
		String expected = "Hbird";
		
		String result = Codec.stringFromBytes(anArray);
		
		assertEquals(expected, result);
	}
	
	@Test
	public void anythingFromIntAsBytes() throws Exception {
		byte[] anArray = {(byte) 0x2A, (byte) 0xAA, (byte) 0xAA, (byte) 0xAA};
		int expected = 715827882;
		
		int result = (Integer) Codec.anythingFromBytes(anArray, Encoding.INT);
		
		assertEquals(expected, result);
	}
	
	@Test
	public void anythingFromStringAsBytes() throws Exception {
		
		byte[] anArray = {(byte) '\u0048', (byte) '\u0062', (byte) '\u0069', (byte) '\u0072', (byte) '\u0064' };
		String expected = "Hbird";
		
		String result = (String) Codec.anythingFromBytes(anArray, Encoding.STRING);
		
		assertEquals(expected, result);
	}
	
	@Test
	public void performanceInt() {
		byte[] anArray = {(byte) 0x2A, (byte) 0xAA, (byte) 0xAA, (byte) 0xAA};
		int expected = 715827882;
		
		int result = 0;
		long startTime = System.currentTimeMillis();
		for (long i=0; i<performanceTestRuns; i++) {
			result = Codec.bigEndianIntFromBytes(anArray);
		}
		long time = System.currentTimeMillis() - startTime;
		System.out.println("Specific function call decoded " + performanceTestRuns/time/1000 + " million ints per second");
		
		assertEquals(expected, result);
	}
	
	@Test
	public void performanceAnythingInt() throws Exception {
		byte[] anArray = {(byte) 0x2A, (byte) 0xAA, (byte) 0xAA, (byte) 0xAA};
		int expected = 715827882;
		
		int result = 0;
		long startTime = System.currentTimeMillis();
		for (long i=0; i<performanceTestRuns; i++) {
			result = (Integer) Codec.anythingFromBytes(anArray, Encoding.INT);
		}
		long time = System.currentTimeMillis() - startTime;
		System.out.println("Anything function call decoded " + performanceTestRuns/time/1000 + " million ints per second");
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testMany() throws Exception {
		
		byte[] anArray = {(byte) 0x2A, (byte) 0xAA, (byte) 0xAA, (byte) 0xAA,
				(byte) '\u0048', (byte) '\u0062', (byte) '\u0069', (byte) '\u0072', (byte) '\u0064'
				};
		
		ParameterEncoding p0 = new ParameterEncoding("Number", Encoding.INT, 0, 4);
		ParameterEncoding p1 = new ParameterEncoding("Name", Encoding.STRING, 4, 5);
		
		List<ParameterEncoding> parameters = new ArrayList<ParameterEncoding>();
		parameters.add(p0);
		parameters.add(p1);
		
		Map<String,Object> results = Codec.decodeMany(anArray, parameters);
		
		int expectedNumber = 715827882;
		String expectedString = "Hbird";
		
		assertEquals(expectedNumber, results.get("Number"));
		assertEquals(expectedString, results.get("Name"));
		
	}
	
	@Test
	public void extractSubArrayTest() throws Exception {
//		assertEquals(1,Codec.extractSubArray(new byte[1],0,1).length);
//		assertEquals(1,Codec.extractSubArray(new byte[1],0,8).length);
//		assertEquals(2,Codec.extractSubArray(new byte[2],0,9).length);
//		assertEquals(2,Codec.extractSubArray(new byte[2],0,16).length);
//		assertEquals(3,Codec.extractSubArray(new byte[3],0,17).length);
		
		byte[] singleFF = new byte[]{(byte)(0xFF)};
		assertEquals(0xFF, Codec.extractSubArray(singleFF, 0, 8)[0] & 0xFF);
		assertEquals(0x01, Codec.extractSubArray(singleFF, 0, 1)[0] & 0xFF);
		assertEquals(0x01, Codec.extractSubArray(singleFF, 1, 1)[0] & 0xFF);
		assertEquals(0x01, Codec.extractSubArray(singleFF, 2, 1)[0] & 0xFF);
		assertEquals(0x01, Codec.extractSubArray(singleFF, 7, 1)[0] & 0xFF);
	}
	
	@Test(expected=Exception.class)
	public void testExtractEmptyBytes() throws Exception {
		assertEquals(0,Codec.extractSubArray(new byte[0],0,0).length);
	}
	
	@Test(expected=Exception.class)
	public void testExtractNullBytes() throws Exception {
		assertEquals(0,Codec.extractSubArray(null,0,0).length);
	}
	
	@Test(expected=Exception.class)
	public void testExtractLengthMismatch() throws Exception {
		assertEquals(2,Codec.extractSubArray(new byte[1],0,9).length);
		assertEquals(3,Codec.extractSubArray(new byte[2],0,17).length);
		assertEquals(3,Codec.extractSubArray(new byte[4],31,2).length);
	}
	
	@Test(expected=Exception.class)
	public void testInvalidBitLengthZero() throws Exception {
		assertEquals(0,Codec.extractSubArray(new byte[1],0,0).length);
	}
	
	@Test(expected=Exception.class)
	public void testInvalidBitLengthNegative() throws Exception {
		assertEquals(0,Codec.extractSubArray(new byte[1],0,Integer.MIN_VALUE).length);
	}
	
	@Test(expected=Exception.class)
	public void testInvalidBitLengthPositive() throws Exception {
		assertEquals(0,Codec.extractSubArray(new byte[1],0,Integer.MAX_VALUE).length);
	}
	

}
