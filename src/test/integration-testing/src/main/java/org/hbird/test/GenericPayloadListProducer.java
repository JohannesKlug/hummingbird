package org.hbird.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.hbird.core.commons.data.GenericPayload;

public class GenericPayloadListProducer {

	public static final int LIST_SIZE = 100;

	private List<String> stringList = new ArrayList<String>(LIST_SIZE);
	private List<GenericPayload> genericPayloadList = new ArrayList<GenericPayload>(LIST_SIZE);

	public GenericPayloadListProducer() {
		byte[] bytes = new byte[1024];

		for (int i = 0; i < bytes.length; i++) {
			bytes[i] = (byte) (0xff & i);
		}

		List<String> layoutIds = new ArrayList<String>();
		layoutIds.add("1");
		layoutIds.add("1000");

		for (int i = 0; i < LIST_SIZE; i++) {
			stringList.add("Element #" + i);
			genericPayloadList.add(new GenericPayload(ArrayUtils.clone(bytes), layoutIds, System.currentTimeMillis()));
		}
	}

	public List<String> getStringList() {
		return stringList;
	}

	public List<GenericPayload> getGenericPayloadList() {
		return genericPayloadList;
	}

}
