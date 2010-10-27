package com.logica.hummingbird.command.task;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;

import com.logica.hummingbird.interfaces.ITask;

public class DummyTask implements ITask {

	public long deltaTime = 0;
	
	public boolean executeCalled = false;
	
	@Override
	public long deltaTime() {
		return deltaTime;
	}

	@Override
	public void execute(CamelContext context, ProducerTemplate producer) {
		executeCalled = true;
	}
}
