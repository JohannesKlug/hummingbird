package org.hbird.transport.protocols.kiss;

public final class KissConstants {

	/** Frame end */
	public static final byte FEND = (byte) 0xC0;

	/** Frame escape */
	public static final byte FESC = (byte) 0xDB;

	/** Transposed frame end */
	public static final byte TFEND = (byte) 0xDC;

	/** Transposed frame escape */
	public static final byte TFESC = (byte) 0xDD;

	/**
	 * The id of the data frame TNC type. The rest of the frame is data to be sent on the HDLC channel. Default port 0.
	 * You must edit at the nibble level to send data to a different port.
	 */
	public static final byte DATA_FRAME = (byte) 0x00;

	/**
	 * The next byte is the transmitter keyup delay in 10 ms units. The default start-up value is 50 (i.e., 500 ms).
	 */
	public static final byte TX_DELAY = (byte) 1;

	/**
	 * The next byte is the persistence parameter, p, scaled to the range 0 - 255 with the following formula: P = p *
	 * 256 - 1
	 * 
	 * The default value is P = 63 (i.e., p = 0.25).
	 */
	public static final byte P = (byte) 2;

	/**
	 * The next byte is the slot interval in 10 ms units. The default is 10 (i.e., 100ms).
	 */
	public static final byte SLOT_TIME = (byte) 3;

	/**
	 * The next byte is the time to hold up the TX after the FCS has been sent, in 10 ms units. This command is
	 * obsolete, and is included here only for compatibility with some existing implementations.
	 */
	public static final byte TX_TAIL = (byte) 4;

	/**
	 * The next byte is 0 for half duplex, nonzero for full duplex. The default is 0 (i.e., half duplex).
	 */
	public static final byte FULL_DUPLEX = (byte) 5;

	/**
	 * Specific for each TNC. In the TNC-1, this command sets the modem speed. Other implementations may use this
	 * function for other hardware-specific functions.
	 */
	public static final byte SET_HARDWARE = (byte) 6;

	/**
	 * Exit KISS and return control to a higher-level program. This is useful only when KISS is incorporated into the
	 * TNC along with other applications.
	 */
	public static final byte RETURN = (byte) 0x0F;

	private KissConstants() {
		// Constants class, utility.
	}

}
