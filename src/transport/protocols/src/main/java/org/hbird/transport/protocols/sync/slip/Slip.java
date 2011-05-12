package org.hbird.transport.protocols.sync.slip;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.lang.ArrayUtils;
import org.hbird.transport.protocols.sync.ObservableFrameSynchroniser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is an implementation of a SLIP-inspired synchronisation mechanism. When receiving data from a radio interface,
 * the receiver has no means of knowing what part of a data transmission he is currently receiving.
 * 
 * To remedy this, the sender has to introduce known marker bytes into the data stream. These marker bytes may not occur
 * unescaped in the payload data between two markers.
 * 
 */
public class Slip extends ObservableFrameSynchroniser {
	private final static Logger LOG = LoggerFactory.getLogger(Slip.class);

	private final int end, esc, escEnd, escEsc;

	/**
	 * Constructor for a Slip object: pass the agreed-upon characters for end marker, escape marker, escaped end marker
	 * and escaped escape marker.
	 */
	public Slip(final int end, final int esc, final int escEnd, final int escEsc) {
		this.end = end;
		this.esc = esc;
		this.escEnd = escEnd;
		this.escEsc = escEsc;
	}

	// FIXME This method should be put into commons.
	private byte[] convertToByteArray(final int[] input) {
		byte[] outputBytes = ArrayUtils.EMPTY_BYTE_ARRAY;

		for (int i : input) {
			outputBytes = ArrayUtils.add(outputBytes, (byte) (i & 0xFF));
		}

		return outputBytes;
	}

	public byte[] convertToSlip(final byte[] input) {

		/*
		 * For this method, we the byte values of our marker and escape character
		 */
		byte byteEnd = (byte) (end & 0xFF);
		byte byteEsc = (byte) (esc & 0xFF);
		// byte byteEscEnd = (byte) (escEnd & 0xFF);
		// byte byteEscEsc = (byte) (escEsc & 0xFF);

		int[] output = ArrayUtils.EMPTY_INT_ARRAY;

		/*
		 * Add each byte from the input array to the
		 */
		for (byte b : input) {
			if (b == byteEnd) {
				output = ArrayUtils.add(output, escEnd);
			}
			else if (b == byteEsc) {
				output = ArrayUtils.add(output, escEsc);
			}
			output = ArrayUtils.add(output, b);
		}

		output = ArrayUtils.add(output, end);
		// Add a second end to conform to the dutch implementation
		output = ArrayUtils.add(output, end);


		return convertToByteArray(output);
	}

	@Override
	public void readFromStream(final InputStream is) {

		int[] receivedData = ArrayUtils.EMPTY_INT_ARRAY;
		int b;
		boolean endEncountered = false;

		try {
			while ((b = is.read()) != -1) {
				/*
				 * We don't want the escape bytes. We only consider them escape bytes when they are followed by the byte
				 * they are supposed to escape.
				 */
				if (b == escEnd) {
					if ((b = is.read()) == end) {
						// escaped end sequence found, adding 'end'
						receivedData = ArrayUtils.add(receivedData, end);
					}
					else {
						// not an escaped end, adding 'escEnd' and the current byte
						receivedData = ArrayUtils.add(receivedData, escEnd);
						receivedData = ArrayUtils.add(receivedData, (byte) b);
					}

				}
				else if (b == escEsc) {
					if ((b = is.read()) == esc) {
						// escaped esc sequence found, adding 'esc'
						receivedData = ArrayUtils.add(receivedData, esc);
					}
					else {
						if (b == end) {
							if (endEncountered == false) {
								endEncountered = true;
							}
							else {
								endEncountered = false;
								this.setChanged();
								notifyObservers(convertToByteArray(receivedData));
								receivedData = ArrayUtils.EMPTY_INT_ARRAY;
							}
						}
						// not an escaped esc, adding 'escEsc' and the current byte
						receivedData = ArrayUtils.add(receivedData, escEsc);
						receivedData = ArrayUtils.add(receivedData, (byte) b);
					}
				}
				else if (b == end) {
					if (endEncountered == false) {
						endEncountered = true;
					}
					else {
						endEncountered = false;
						this.setChanged();
						notifyObservers(convertToByteArray(receivedData));
						receivedData = ArrayUtils.EMPTY_INT_ARRAY;
					}
				}
				else {
					receivedData = ArrayUtils.add(receivedData, (byte) b);
				}

			}
		}
		catch (IOException e) {
			LOG.error(e.toString());
		}
	}

}
