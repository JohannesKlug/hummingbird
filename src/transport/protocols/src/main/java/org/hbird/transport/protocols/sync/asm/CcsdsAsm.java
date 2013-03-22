package org.hbird.transport.protocols.sync.asm;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.lang3.ArrayUtils;
import org.hbird.transport.protocols.sync.ObservableFrameSynchroniser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CcsdsAsm extends ObservableFrameSynchroniser {
	private static final Logger LOG = LoggerFactory.getLogger(CcsdsAsm.class);

	private static final int READ_BUFFER = 1024;

	private final byte[] asm;

	/**
	 * Default Constructor using the ASM bit pattern defined in CCSDS 131 (0x1ACFFC1D)
	 */
	public CcsdsAsm() {
		// 1ACFFC1D
		this(new byte[] { (byte) (0x1A & 0xFF), (byte) (0xCF & 0xFF), (byte) (0xFC & 0xFF), (byte) (0x1D & 0xFF) });
	}

	public CcsdsAsm(final byte[] asm) {
		this.asm = ArrayUtils.clone(asm);
	}

	@Override
	public void readFromStream(final InputStream is) {
		byte[] receivedData = ArrayUtils.EMPTY_BYTE_ARRAY;
		byte[] newData = new byte[READ_BUFFER];

		int bytesRead;

		try {
			int asmByte = 0;
			// While there are non-empty bytes on the stream read until newData of size READ_BUFFER is full...
			while ((bytesRead = is.read(newData)) != -1 && bytesRead != 0) {
				// Iterate over each byte
				for (int i = 0; i < bytesRead; i++) {
					// add to received data
					receivedData = ArrayUtils.add(receivedData, newData[i]);

					// If this byte corresponds to the current ASM byte
					if (newData[i] == (asm[asmByte])) {
						// increment the asm byte we are checking next
						asmByte++;

						// if that was the final ASM byte then we have successfully parsed an ASM marker
						if (asmByte == asm.length) {
							// reset the asmByte for the next iteration
							asmByte = 0;

							// remove ASM bytes from received data (they must be at the end of the received data)
							// for (final byte element : asm) {
							for (int x = 1; x <= asm.length; x++) {
								receivedData = ArrayUtils.remove(receivedData, receivedData.length - 1);
							}

							// set the Observable flag to changed and notify listeners.
							this.setChanged();
							notifyObservers(receivedData);
							// empty the received array.
							receivedData = ArrayUtils.EMPTY_BYTE_ARRAY;
						}
					}
					else {
						// Received byte not part of the ASM. Reset current asm byte "pointer" and continue processing
						// the stream.
						asmByte = 0;
					}
				}
			}
		}
		catch (final IOException e) {
			LOG.error(e.toString());
		}

	}

}
