package org.hbird.transport.protocols.sync.asm;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.lang.ArrayUtils;
import org.hbird.transport.protocols.sync.ObservableFrameSynchroniser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CcsdsAsm extends ObservableFrameSynchroniser {
	private final static Logger LOG = LoggerFactory.getLogger(CcsdsAsm.class);

	private final byte[] asm;
	private int currentByte = 0;

	// Default Constructor using the ASM bit pattern defined in CCSDS 131.
	public CcsdsAsm() {
		// 1ACFFC1D
		this(new byte[] { (byte) (0x1A & 0xFF), (byte) (0xCF & 0xFF), (byte) (0xFC & 0xFF), (byte) (0x1D & 0xFF) });
	}

	public CcsdsAsm(final byte[] asm) {
		this.asm = ArrayUtils.clone(asm);
	}

	// FIXME This method should be put into commons.
	private byte[] convertToByteArray(final int[] input) {
		byte[] outputBytes = ArrayUtils.EMPTY_BYTE_ARRAY;

		for (final int i : input) {
			outputBytes = ArrayUtils.add(outputBytes, (byte) (i & 0xFF));
		}

		return outputBytes;
	}

	@Override
	public void readFromStream(final InputStream is) {

		int[] receivedData = ArrayUtils.EMPTY_INT_ARRAY;
		int b;

		try {
			while ((b = is.read()) != -1) {
				receivedData = ArrayUtils.add(receivedData, b);

				if (b == (asm[currentByte] & 0xFF)) {
					// Received byte is the expected part of the ASM.
					currentByte++;
					if (currentByte == asm.length) {
						// all ASM bytes have been encountered.

						currentByte = 0;

						// remove ASM bytes from received data
						for (final byte element : asm) {
							receivedData = ArrayUtils.remove(receivedData, receivedData.length - 1);
						}

						this.setChanged();
						notifyObservers(convertToByteArray(receivedData));
						receivedData = ArrayUtils.EMPTY_INT_ARRAY;
					}
				}
				else {
					// Received byte not part of the ASM. Reset current byte "pointer".
					currentByte = 0;
				}

			}
		}
		catch (final IOException e) {
			LOG.error(e.toString());
		}

	}

}
