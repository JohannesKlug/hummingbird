package org.hbird.core.commons.collections;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

import org.hbird.core.commons.collections.CircularFifoQueue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CircularFifoQueueTest {

	private CircularFifoQueue<Integer> queue;
	private static List<Integer> testNumbers;

	@BeforeClass
	public static void setUpTestData() throws Exception {
		testNumbers = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			testNumbers.add(i);
		}
	}

	@Before
	public void setUp() throws Exception {
		queue = new CircularFifoQueue<Integer>(new ArrayBlockingQueue<Integer>(10, true));
	}

	@Test
	public void testPutT() throws InterruptedException {
		for (int i : testNumbers) {
			queue.put(i);
		}

		assertEquals("Queue should have 10 elements", testNumbers.size(), queue.size());
		assertEquals("Queue head should be 0, i.e, first element in the test data list", testNumbers.get(0), queue.peek());

		queue.put(555);

		assertEquals("Queue should have 10 elements", testNumbers.size(), queue.size());
		assertEquals("Queue head should be 1, i.e, second element in the test data list", testNumbers.get(1), queue.peek());

		Iterator<Integer> it = queue.iterator();
		int count = 1;
		while (it.hasNext()) {
			Integer x = it.next();
			if (count != 10) {
				assertEquals("Queue should match up with test data", testNumbers.get(count), x);
			}
			else {
				assertEquals("Queue should match up with test data", new Integer(555), x);
			}
			count++;
		}

	}
}
