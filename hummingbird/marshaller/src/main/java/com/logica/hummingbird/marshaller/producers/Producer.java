package com.logica.hummingbird.marshaller.producers;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;

import com.logica.hummingbird.marshaller.IContainerFactory;

public abstract class Producer implements IProducer {

DefaultCamelContext context = new DefaultCamelContext();
	
	protected ProducerTemplate producerTemplate = context.createProducerTemplate();

	private Map<String,Object> headers = new HashMap<String, Object>();
	
	private IContainerFactory containerFactory;

	private Object body;
	
	public Producer(IContainerFactory containerFactory) {
		this.containerFactory = containerFactory;
		System.out.println(this.getClass() + " constructor called.");
	}
	

	@Override
	public void updated(String field, BitSet value) {
		body = value;	

	}

	@Override
	public void updated(String field, int value) {
		headers.put(field, value);

	}

	@Override
	public void updated(String field, String value) {
		headers.put(field, value);

	}

	@Override
	public void updated(String field, double value) {
		headers.put(field, value);

	}
	
	@Override
	public void completed() {
		producerTemplate.sendBodyAndHeaders(body, headers);
		
	}

}
