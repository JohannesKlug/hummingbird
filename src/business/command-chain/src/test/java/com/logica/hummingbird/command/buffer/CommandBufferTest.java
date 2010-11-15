package org.hbird.command.buffer;

import org.apache.camel.CamelContext;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultExchange;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit38.AbstractJUnit38SpringContextTests;

import org.hbird.buffers.CommandBuffer;

@ContextConfiguration (locations={"/CommandBufferTest-context.xml"})
public class CommandBufferTest extends AbstractJUnit38SpringContextTests  {

	@Produce(uri = "direct:Trigger")
    protected ProducerTemplate template;

	@Autowired
	protected CommandBuffer buffer;

	@Autowired
    protected CamelContext context;
	
	@Test
	public void testPopulateBuffer() {
		/** Trigger the loading of command definitions. */
		template.send(new DefaultExchange(context));

		/** Check that the buffer was populated. */
		assertTrue(buffer.getSize() == 4);
	}		
}
