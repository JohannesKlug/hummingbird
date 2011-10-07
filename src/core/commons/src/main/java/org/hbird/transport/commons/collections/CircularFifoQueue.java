package org.hbird.transport.commons.collections;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import com.google.common.util.concurrent.ForwardingBlockingQueue;

/**
 * 
 * @author Mark Doyle
 * 
 * @param <T>
 */
public class CircularFifoQueue<T> extends ForwardingBlockingQueue<T> {

	private final ArrayBlockingQueue<T> decoratedQueue;

	public CircularFifoQueue(final ArrayBlockingQueue<T> blockingQueue) {
		this.decoratedQueue = blockingQueue;
	}

	@Override
	protected BlockingQueue<T> delegate() {
		return decoratedQueue;
	}

	@Override
	public synchronized void put(final T e) throws InterruptedException {
		// if there is not enough room for the add..
		if (decoratedQueue.remainingCapacity() <= 0) {
			// ..remove the head element
			decoratedQueue.remove();
		}
		// ..and carry out the add
		decoratedQueue.put(e);
	};

}
