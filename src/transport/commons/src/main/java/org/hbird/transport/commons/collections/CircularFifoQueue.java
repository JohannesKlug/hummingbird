package org.hbird.transport.commons.collections;

import java.util.concurrent.BlockingQueue;

import com.google.common.util.concurrent.ForwardingBlockingQueue;

public class CircularFifoQueue<T> extends ForwardingBlockingQueue<T> {

	private final BlockingQueue<T> decoratedQueue;
	private final long capacity;

	public CircularFifoQueue(final long capacity, final BlockingQueue<T> blockingQueue) {
		this.decoratedQueue = blockingQueue;
		this.capacity = capacity;
	}

	@Override
	protected BlockingQueue<T> delegate() {
		return decoratedQueue;
	}


	@Override
	public synchronized void put(final T e) throws InterruptedException {
		if (decoratedQueue.remainingCapacity() <= 0) {
			decoratedQueue.remove();
		}
		decoratedQueue.put(e);
	};

}
