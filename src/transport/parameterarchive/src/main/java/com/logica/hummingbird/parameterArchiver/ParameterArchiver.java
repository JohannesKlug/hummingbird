package org.hbird.parameterArchiver;

import javax.sql.DataSource;

import org.apache.camel.Message;
import org.springframework.jdbc.core.JdbcTemplate;

import org.hbird.spacesystemmodel.ContainerFactory;
import org.hbird.spacesystemmodel.parameters.ParameterContainer;
import org.hbird.spacesystemmodel.parameters.behaviours.AbstractFloatBehaviour;
import org.hbird.spacesystemmodel.parameters.behaviours.AbstractIntegerBehaviour;

public class ParameterArchiver {

	private JdbcTemplate jdbcTemplate;

	public ParameterArchiver(ContainerFactory containerFactory, DataSource dataSource) {

		this.jdbcTemplate = new JdbcTemplate(dataSource);

		for (ParameterContainer parameter : containerFactory.getAllParameters().values()) {
			if (parameter.getType().getNumberBehaviour() instanceof AbstractFloatBehaviour) {
				// create float table
				this.jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS " + parameter.getName() + " (onBoardTime BIGINT, filingTime BIGINT, value REAL)");

			}
			else if (parameter.getType().getNumberBehaviour() instanceof AbstractIntegerBehaviour) {
				// create integer table
				this.jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS " + parameter.getName() + " (onBoardTime BIGINT, filingTime BIGINT, value INTEGER)");
			}
			else {
				// TODO Make this fail properly with an exception.
			}

		}

	}

	public void onMessage(Message message) {
		if (message.getHeader("Type") == "TMParameter") {
			store(message);
		}
		else if (message.getHeader("Type") == "RetrievalRequest") {
			retrieve(message);
		}

	}

	public void retrieve(Message message) {

	}

	/**
	 * Takes Camel messages and stores the contained parameter. The following are used: * Header field "Name" for the
	 * parameter name * Header field "Time" for the on-board generation time * Body cast to Number for the actual
	 * parameter value
	 * 
	 * @param message
	 *            The message from which a parameter will be extracted and stored
	 * 
	 * */
	public void store(Message message) {
		storeParameter((String) message.getHeader("Name"), (Long) message.getHeader("Time"), (Number) message.getBody());
	}

	/**
	 * Stores the passed parameter, adding the filing time in a fourth column.
	 * 
	 * @param parameterName
	 *            The parameter's name
	 * @param time
	 *            The parameter's on-board generation time
	 * @param value
	 *            The parameter's value
	 */
	public void storeParameter(String parameterName, long time, Number value) {
		jdbcTemplate.update("insert into " + parameterName + "(onBoardTime, filingTime, value) values (?, ?, ?)", new Object[] { time,
				System.currentTimeMillis(), value });

	}

}
