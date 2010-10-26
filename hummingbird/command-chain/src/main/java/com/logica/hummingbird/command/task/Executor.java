package com.logica.hummingbird.command.task;

import java.util.Date;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;

import com.logica.hummingbird.interfaces.ITask;
import com.logica.hummingbird.jmshelper.HeaderFields;

public class Executor {

	/** Queue for the task schedule. */
	protected ProducerTemplate producer = null;

	protected CamelContext context = null;
	
	public Executor(CamelContext context, ProducerTemplate producer) {
		super();
		this.producer = producer;
		this.context = context;
	}

	public void receive(Exchange arg0) {

		/** Get the task. */
		ITask task = (ITask) arg0.getIn().getBody();

		/** Wait until the execution time. */
		Date now = new Date();
		long executionTime = (Long) arg0.getIn().getHeader(HeaderFields.TASK_EXECUTIONTIME);
		
		if (executionTime > now.getTime()) {
			try {
				Thread.sleep(executionTime - now.getTime());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} 

		task.execute(context, producer);
	}
	
}
