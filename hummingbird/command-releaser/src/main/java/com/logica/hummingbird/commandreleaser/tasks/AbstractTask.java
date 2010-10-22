package com.logica.hummingbird.commandreleaser.tasks;

import org.apache.camel.ConsumerTemplate;
import org.apache.camel.ProducerTemplate;

public abstract class AbstractTask {

	protected ProducerTemplate producerTemplate = null;
	protected ConsumerTemplate consumerTemplate = null;
	
	protected long executionTime = 0;
}
