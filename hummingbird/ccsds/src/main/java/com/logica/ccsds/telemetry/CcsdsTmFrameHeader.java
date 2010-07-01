package com.logica.ccsds.telemetry;

import java.util.BitSet;

/**
 * 
 * @author Mark Doyle
 * @author Johannes Klug
 * 
 */
public class CcsdsTmFrameHeader {

	CcsdsTmFrameHeader secondaryHeader = null;

	public final static String FRAME_VERSION_NUM = "CCSDS_FVERSION";
	public final static String SPACECRAFT_ID = "CCSDS_SC_ID";
	public final static String VIRTUAL_CHANNEL_ID = "CCSDS_TF_VC";
	public final static String OPERATION_CONTROL_FIELD_FLAG = "CCSDS_OP_CTRL";
	public final static String MASTER_CHANNELFRAME_COUNT = "CCSDS_MS_CNT";
	public final static String VIRTUAL_CHANNELFRAME_COUNT = "CCSDS_VC_CNT";
	public final static String TRANSFER_FRAME_SECONDARY_HEADER_FLAG = "CCSDS_TF_SECH";
	public final static String SYNC_FLAG = "CCSDS_TF_SYNC";
	public final static String PACKET_ORDER_FLAG = "CCSDS_TF_ORDER";
	public final static String SECOND_LENGTH_ID = "CCSDS_TF_SEGM";
	public final static String FIRST_HEADER_POINTER = "CCSDS_TF_FH";
	public final static String TRANSFER_FRAME_SECONDARY_HEADER_VERSION_NUM = "CCSDS_TF_HV";
	public final static String TRANSFER_FRAME_SECONDARY_HEADER_LENGTH = "CCSDS_TF_HL";

	protected int frameVersionNum;
	protected int spaceCraftId;
	protected int virtualChannelId;
	protected boolean operationControlFieldFlag;
	protected int masterChannelFrameCount;
	protected int virtualChannelFrameCount;
	protected boolean transferFrameSecondaryHeaderFlag;
	protected boolean syncFlag;
	protected boolean packetOrderFlag;
	protected int secondLengthId;
	protected int firstHeaderPointer;
	protected int transferFrameSecondaryHeaderVersionNum;
	protected int transferFrameSecondaryHeaderLength;

	/**
	 * 
	 */
	public CcsdsTmFrameHeader() {
		// TODO Auto-generated constructor stub
	}

	// ----------------------------------------------------------
	// Getter and setters. No trespassing.
	// ----------------------------------------------------------
	public int getFrameVersionNum() {
		return frameVersionNum;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CcsdsFrameHeader [\n\tfirstHeaderPointer = ");
		builder.append(firstHeaderPointer);
		builder.append("\n\tframeVersionNum = ");
		builder.append(frameVersionNum);
		builder.append("\n\tmasterChannelFrameCount = ");
		builder.append(masterChannelFrameCount);
		builder.append("\n\toperationControlFieldFlag = ");
		builder.append(operationControlFieldFlag);
		builder.append("\n\tpacketOrderFlag = ");
		builder.append(packetOrderFlag);
		builder.append("\n\tsecondLengthId = ");
		builder.append(secondLengthId);
		builder.append("\n\tsecondaryHeader = ");
		builder.append(secondaryHeader);
		builder.append("\n\tspaceCraftId = ");
		builder.append(spaceCraftId);
		builder.append("\n\tsyncFlag = ");
		builder.append(syncFlag);
		builder.append("\n\ttransferFrameSecondaryHeaderFlag = ");
		builder.append(transferFrameSecondaryHeaderFlag);
		builder.append("\n\ttransferFrameSecondaryHeaderLength = ");
		builder.append(transferFrameSecondaryHeaderLength);
		builder.append("\n\ttransferFrameSecondaryHeaderVersionNum = ");
		builder.append(transferFrameSecondaryHeaderVersionNum);
		builder.append("\n\tvirtualChannelFrameCount = ");
		builder.append(virtualChannelFrameCount);
		builder.append("\n\tvirtualChannelId = ");
		builder.append(virtualChannelId);
		builder.append("\n]");
		return builder.toString();
	}

	/**
	 * @return the secondaryHeader
	 */
	public CcsdsTmFrameHeader getSecondaryHeader() {
		return secondaryHeader;
	}

	/**
	 * @return the spaceCraftId
	 */
	public int getSpaceCraftId() {
		return spaceCraftId;
	}

	/**
	 * @return the virtualChannelId
	 */
	public int getVirtualChannelId() {
		return virtualChannelId;
	}

	/**
	 * @return the operationControlFieldFlag
	 */
	public boolean isOperationControlFieldFlag() {
		return operationControlFieldFlag;
	}

	/**
	 * @return the masterChannelFrameCount
	 */
	public int getMasterChannelFrameCount() {
		return masterChannelFrameCount;
	}

	/**
	 * @return the virtualChannelFrameCount
	 */
	public int getVirtualChannelFrameCount() {
		return virtualChannelFrameCount;
	}

	/**
	 * @return the transferFrameSecondaryHeaderFlag
	 */
	public boolean isTransferFrameSecondaryHeaderFlag() {
		return transferFrameSecondaryHeaderFlag;
	}

	/**
	 * @return the syncFlag
	 */
	public boolean isSyncFlag() {
		return syncFlag;
	}

	/**
	 * @return the packetOrderFlag
	 */
	public boolean isPacketOrderFlag() {
		return packetOrderFlag;
	}

	/**
	 * @return the secondLengthId
	 */
	public int getSecondLengthId() {
		return secondLengthId;
	}

	/**
	 * @return the firstHeaderPointer
	 */
	public int getFirstHeaderPointer() {
		return firstHeaderPointer;
	}

	/**
	 * @return the transferFrameSecondaryHeaderVersionNum
	 */
	public int getTransferFrameSecondaryHeaderVersionNum() {
		return transferFrameSecondaryHeaderVersionNum;
	}

	/**
	 * @return the transferFrameSecondaryHeaderLength
	 */
	public int getTransferFrameSecondaryHeaderLength() {
		return transferFrameSecondaryHeaderLength;
	}

}
