package org.hbird.business.timecorrelation;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

import javax.script.ScriptEngine;
import javax.script.ScriptException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.util.ResourceUtils;

public class ScriptEngineOverlordTest {

	ScriptEngineOverlord scriptOverlord;
	private static File helloWorldPythonScript;
	private static File helloWorldRubyScript;

	// Setup -----------------------

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		helloWorldPythonScript = ResourceUtils.getFile(ScriptEngineOverlordTest.class.getResource("./helloWorld.py"));
		helloWorldRubyScript = ResourceUtils.getFile(ScriptEngineOverlordTest.class.getResource("./helloWorld.rb"));
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		scriptOverlord = new ScriptEngineOverlord();
	}

	@After
	public void tearDown() throws Exception {
	}


	// Tests -----------------------

	// JPython not in Maven yet - ignoring for the time being.
	@Ignore
	@Test
	public void testLoadPythonScriptEngine() throws FileNotFoundException, ScriptException {
		ScriptEngine engine = scriptOverlord.loadScriptEngine("python");
		assertNotNull("engine is null", engine);

		Reader script = new FileReader(helloWorldPythonScript);

		engine.eval(script);
	}

	@Test
	public void testLoadRubyScriptEngine() throws FileNotFoundException, ScriptException {
		ScriptEngine engine = scriptOverlord.loadScriptEngine("ruby");
		assertNotNull("engine is null", engine);

		Reader script = new FileReader(helloWorldRubyScript);

		engine.eval(script);
	}

}
