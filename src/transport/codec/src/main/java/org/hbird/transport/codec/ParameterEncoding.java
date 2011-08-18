package org.hbird.transport.codec;

public class ParameterEncoding {
	public String name;
	public Encoding encoding;
	public int offset;
	public int length;
	
	public ParameterEncoding(String name, Encoding encoding, int offset, int length) {
		this.name = name;
		this.encoding = encoding;
		this.offset = offset;
		this.length = length;
	}

}
