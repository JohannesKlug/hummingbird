package com.logica.hummingbird.tasks;

import java.io.Serializable;

import org.apache.camel.ConsumerTemplate;
import org.apache.camel.ProducerTemplate;

import com.logica.hummingbird.interfaces.ITask;

public abstract class AbstractTask implements ITask, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected ProducerTemplate producerTemplate = null;
	protected ConsumerTemplate consumerTemplate = null;
	
	protected long executionTime = 0;
	
	public AbstractTask(long executionTime) {
		this.executionTime = executionTime;
	}
	
	public long deltaTime() {
		return executionTime;
	}
}
