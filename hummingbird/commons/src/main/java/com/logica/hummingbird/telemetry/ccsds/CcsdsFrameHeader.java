package com.logica.hummingbird.telemetry.ccsds;

import java.util.BitSet;

import com.logica.hummingbird.telemetry.TelemetryFrameHeader;


/**
 * 
 * @author Mark Doyle
 * @author Johannes Klug
 *
 */
public class CcsdsFrameHeader implements TelemetryFrameHeader {
	
	CcsdsFrameHeader secondaryHeader = null;

	public final static String FRAME_VERSION_NUM = "CCSDS_FVERSION";
	public final static String SPACECRAFT_ID = "CCSDS_SC_ID";
	public final static String VIRTUAL_CHANNEL_ID = "CCSDS_TF_VC";
	public final static String OPERATION_CONTROL_FIELD_FLAG = "CCSDS_OP_CTRL";
	public final static String MASTER_CHANNELFRAME_COUNT = "CCSDS_MS_CNT";
	public final static String VIRTUAL_CHANNELFRAME_COUNT = "CCSDS_VC_CNT";
	public final static String TRANSFER_FRAME_SECONDARY_HEADER_FLAG= "CCSDS_TF_SECH";
	public final static String SYNC_FLAG = "CCSDS_TF_SYNC";
	public final static String PACKET_ORDER_FLAG ="CCSDS_TF_ORDER";
	public final static String SECOND_LENGTH_ID = "CCSDS_TF_SEGM";
	public final static String FIRST_HEADER_POINTER = "CCSDS_TF_FH";
	public final static String TRANSFER_FRAME_SECONDARY_HEADER_VERSION_NUM = "CCSDS_TF_HV";
	public final static String TRANSFER_FRAME_SECONDARY_HEADER_LENGTH = "CCSDS_TF_HL";

	private BitSet frameVersionNum;
	private BitSet spaceCraftId;
	private BitSet virtualChannelId;
	private BitSet operationControlFieldFlag;
	private BitSet masterChannelFrameCount;
	private BitSet virtualChannelFrameCount;
	private BitSet transferFrameSecondaryHeaderFlag;
	private BitSet syncFlag;
	private BitSet packetOrderFlag;
	private BitSet secondLengthId;
	private BitSet firstHeaderPointer;
	private BitSet transferFrameSecondaryHeaderVersionNum;
	private BitSet transferFrameSecondaryHeaderLength;
	
	/**
	 * 
	 */
	public CcsdsFrameHeader() {
		// TODO Auto-generated constructor stub
	}

	
	//----------------------------------------------------------
	// Getter and setters.  No trespassing.
	//----------------------------------------------------------
	public CcsdsFrameHeader getSecondaryHeader() {
		return secondaryHeader;
	}

	public void setSecondaryHeader(CcsdsFrameHeader secondaryHeader) {
		this.secondaryHeader = secondaryHeader;
	}

	public BitSet getFrameVersionNum() {
		return frameVersionNum;
	}

	public void setFrameVersionNum(BitSet frameVersionNum) {
		this.frameVersionNum = frameVersionNum;
	}

	public BitSet getSpaceCraftId() {
		return spaceCraftId;
	}

	public void setSpaceCraftId(BitSet spaceCraftId) {
		this.spaceCraftId = spaceCraftId;
	}

	public BitSet getVirtualChannelId() {
		return virtualChannelId;
	}

	public void setVirtualChannelId(BitSet virtualChannelId) {
		this.virtualChannelId = virtualChannelId;
	}

	public BitSet getOperationControlFieldFlag() {
		return operationControlFieldFlag;
	}

	public void setOperationControlFieldFlag(BitSet operationControlFieldFlag) {
		this.operationControlFieldFlag = operationControlFieldFlag;
	}

	public BitSet getMasterChannelFrameCount() {
		return masterChannelFrameCount;
	}

	public void setMasterChannelFrameCount(BitSet masterChannelFrameCount) {
		this.masterChannelFrameCount = masterChannelFrameCount;
	}

	public BitSet getVirtualChannelFrameCount() {
		return virtualChannelFrameCount;
	}

	public void setVirtualChannelFrameCount(BitSet virtualChannelFrameCount) {
		this.virtualChannelFrameCount = virtualChannelFrameCount;
	}

	public BitSet getTransferFrameSecondaryHeaderFlag() {
		return transferFrameSecondaryHeaderFlag;
	}

	public void setTransferFrameSecondaryHeaderFlag(BitSet transferFrameSecondaryHeaderFlag) {
		this.transferFrameSecondaryHeaderFlag = transferFrameSecondaryHeaderFlag;
	}

	public BitSet getSyncFlag() {
		return syncFlag;
	}

	public void setSyncFlag(BitSet syncFlag) {
		this.syncFlag = syncFlag;
	}

	public BitSet getPacketOrderFlag() {
		return packetOrderFlag;
	}

	public void setPacketOrderFlag(BitSet packetOrderFlag) {
		this.packetOrderFlag = packetOrderFlag;
	}

	public BitSet getSecondLengthId() {
		return secondLengthId;
	}

	public void setSecondLengthId(BitSet secondLengthId) {
		this.secondLengthId = secondLengthId;
	}

	public BitSet getFirstHeaderPointer() {
		return firstHeaderPointer;
	}

	public void setFirstHeaderPointer(BitSet firstHeaderPointer) {
		this.firstHeaderPointer = firstHeaderPointer;
	}

	public BitSet getTransferFrameSecondaryHeaderVersionNum() {
		return transferFrameSecondaryHeaderVersionNum;
	}

	public void setTransferFrameSecondaryHeaderVersionNum(BitSet transferFrameSecondaryHeaderVersionNum) {
		this.transferFrameSecondaryHeaderVersionNum = transferFrameSecondaryHeaderVersionNum;
	}

	public BitSet getTransferFrameSecondaryHeaderLength() {
		return transferFrameSecondaryHeaderLength;
	}

	public void setTransferFrameSecondaryHeaderLength(BitSet transferFrameSecondaryHeaderLength) {
		this.transferFrameSecondaryHeaderLength = transferFrameSecondaryHeaderLength;
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





}
