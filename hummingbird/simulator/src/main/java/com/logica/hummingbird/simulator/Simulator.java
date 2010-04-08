package com.logica.hummingbird.simulator;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.DefaultExchange;
import org.apache.camel.impl.DefaultMessage;
import org.apache.camel.impl.DefaultProducerTemplate;

import com.logica.hummingbird.simulator.waveforms.Waveform;

public class Simulator implements Runnable {
	
	private Endpoint endpoint;
	private DefaultProducerTemplate template;
	private CamelContext context;
	private List<Waveform> waveforms;
	
	private boolean run;
	
	private long messageInterval = 1000;
	
	public Simulator(Endpoint endpoint)  {
		this.endpoint = endpoint;
		this.context = new DefaultCamelContext();
		this.template = new DefaultProducerTemplate(context, endpoint);
		this.waveforms = new ArrayList<Waveform>();
	}
	
	public void setMessageInterval(long messageInterval) {
		this.messageInterval = messageInterval;
	}
	
	public void addWaveform(Waveform waveform) {
		waveforms.add(waveform);
	}
	
	public Message nextMessage(double value) {
		Message message = new DefaultMessage();
		message.setHeader("Header field", "value");
		message.setBody(value);
		return message;
		
	}
	
	public Exchange nextExchange(double value) {
		Exchange exchange = new DefaultExchange(context);
		exchange.setOut(nextMessage(value));
		return exchange;
	}
	
	public void sendMessage(double value) {
		template.send(nextExchange(value));
	}
	

	public void stopSimulator() {
		run = false;
	}

	public void run() {
		run = true;
		while (run) {
			
			for (Waveform waveform : waveforms) {
				for (int i = 0; i< waveform.getReadings(); i++) {
					
					// TODO Passing the value down to nextMessage() is ugly. Refactor?
					sendMessage(waveform.nextValue());
				}
			}

			try {
				Thread.sleep(messageInterval);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
