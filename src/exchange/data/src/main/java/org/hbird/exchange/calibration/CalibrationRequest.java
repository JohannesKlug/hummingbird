package org.hbird.exchange.calibration;

import org.hbird.exchange.type.Named;


/**
 * A calibration request. The request contains a script in some scripting language. The
 * script may by itself contact the underlying transport layer, using for example
 * stomp (http://stomp.codehaus.org/). The script can thus by itself request and 
 * receive data for the processing.
 * 
 * The format of the script is defined by the the 'format' attribute. This can be 
 * used to create the script execution engine and run the script.
 *
 */
public class CalibrationRequest extends Named {

	/** The unique UID */
	private static final long serialVersionUID = 1638200113394259171L;

	
	/**
	 * Constructor.
	 * 
	 * @param name The name of the script.
	 * @param description A description of the script.
	 * @param script The actual script.
	 * @param format The name of the script format, such as 'JavaScript'
	 */
	public CalibrationRequest(String name, String description, String script, String format) {
		super(name, description);
		this.script = script;
		this.format = format;
	}	

	/**
	 * Constructor, for a JavaScript (default format).
	 * 
	 * @param name The name of the script.
	 * @param description A description of the script.
	 * @param script The 'JavaScript' script.
	 */
	public CalibrationRequest(String name, String description, String script) {
		super(name, description);
		this.script = script;
	}	

	/** The actual script to be used. */
	protected String script;
	
	/** The format of the script. Default value is 'JavaScript'. */
	protected String format = "JavaScript";


	/**
	 * Getter of the script.
	 * 
	 * @return The script
	 */
	public String getScript() {
		return script;
	}

	/**
	 * Getter of the format.
	 * 
	 * @return The format
	 */
	public String getFormat() {
		return format;
	}
}
