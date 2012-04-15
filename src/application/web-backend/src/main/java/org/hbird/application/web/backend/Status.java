package org.hbird.application.web.backend;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.msgpack.MessagePack;
import org.msgpack.packer.Packer;

@Path("/status")
public class Status {

	@GET
	@Produces("application/x-msgpack")
	public byte[] getStatus() throws IOException {

		MessagePack msgpack = new MessagePack();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		Packer packer = msgpack.createPacker(out);

		packer.write("I'm doing fine, thank you very much.");

		// Serialize values of primitive types
		packer.write(true); // boolean value
		packer.write(10); // int value
		packer.write(10.5); // double value
		//
		// // Serialize objects of primitive wrapper types
		// packer.write(Boolean.TRUE);
		// packer.write(new Integer(10));
		// packer.write(new Double(10.5));
		//
		// // Serialize various types of arrays
		// packer.write(new int[] { 1, 2, 3, 4 });
		// packer.write(new Double[] { 10.5, 20.5 });
		// packer.write(new String[] { "msg", "pack", "for", "java" });
		// packer.write(new byte[] { 0x30, 0x31, 0x32 }); // byte array
		//
		// // Serialize various types of other reference values
		// packer.write("MesagePack"); // String object
		// packer.write(ByteBuffer.wrap(new byte[] { 0x30, 0x31, 0x32 })); //
		// ByteBuffer object
		// packer.write(BigInteger.ONE); // BigInteger object
		//
		//
		// Deserialization
		//
		byte[] bytes = out.toByteArray();
		return bytes;
	}
	
	@Path("/status/messagesProcessed")
	@GET
	@Produces("text/plain")
	public long getNumberOfMessagesProcessed() { 
		return 1977;
	}
	
	
}
