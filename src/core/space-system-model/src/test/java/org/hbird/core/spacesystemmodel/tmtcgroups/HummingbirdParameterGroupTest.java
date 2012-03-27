package org.hbird.core.spacesystemmodel.tmtcgroups;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;
import java.util.Map;

import org.hbird.core.commons.tmtc.Parameter;
import org.hbird.core.commons.tmtc.ParameterGroup;
import org.hbird.core.commons.tmtc.ParameterGroupReport;
import org.hbird.core.commons.tmtc.exceptions.UnknownParameterException;
import org.hbird.core.spacesystemmodel.parameters.HummingbirdParameter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * @author kimmell
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class HummingbirdParameterGroupTest {
	
	private static final String QN = "a.b.c";
	private static final String NAME = "c";
	private static final String DESCRIPTION_LONG = "Long description";
	private static final String DESCRIPTION_SHORT = "Short description";
	
	@Mock
	private Parameter<Integer> intParameter;
	
	@Mock
	private Parameter<Long> longParameter;
	
	@Mock
	private Parameter<Float> floatParameter;

	@Mock
	private Parameter<Double> doubleParameter;

	@Mock
	private Parameter<BigDecimal> bigDecimalParameter;

	@Mock
	private Parameter<String> stringParameter;
	
	@Mock
	private Parameter<Byte[]> rawParameter;

	private InOrder inOrder;

	private HummingbirdParameterGroup group;
	
	@Before
	public void setUp() {
		group = new HummingbirdParameterGroup(QN, NAME, DESCRIPTION_SHORT, DESCRIPTION_LONG);
		inOrder = inOrder(intParameter, longParameter, floatParameter, doubleParameter, bigDecimalParameter, stringParameter, rawParameter);
	}
	
	public void tearDown() {
		inOrder.verifyNoMoreInteractions();
	}
	
	/**
	 * Test method for {@link org.hbird.core.spacesystemmodel.tmtcgroups.HummingbirdParameterGroup#HummingbirdParameterGroup(java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testHummingbirdParameterGroup() {
		testGetName();
		testGetQualifiedName();
		testGetShortDescription();
		testGetLongDescription();
	}

	/**
	 * Test method for {@link org.hbird.core.spacesystemmodel.tmtcgroups.HummingbirdParameterGroup#getName()}.
	 */
	@Test
	public void testGetName() {
		assertEquals(NAME, group.getName());
	}

	/**
	 * Test method for {@link org.hbird.core.spacesystemmodel.tmtcgroups.HummingbirdParameterGroup#getShortDescription()}.
	 */
	@Test
	public void testGetShortDescription() {
		assertEquals(DESCRIPTION_SHORT, group.getShortDescription());
	}

	/**
	 * Test method for {@link org.hbird.core.spacesystemmodel.tmtcgroups.HummingbirdParameterGroup#getLongDescription()}.
	 */
	@Test
	public void testGetLongDescription() {
		assertEquals(DESCRIPTION_LONG, group.getLongDescription());
	}

	/**
	 * Test method for {@link org.hbird.core.spacesystemmodel.tmtcgroups.HummingbirdParameterGroup#setTimeStamp(long)}.
	 */
	@Test
	public void testSetTimeStamp() {
		assertEquals(0L, group.getTimeStamp());
		long now = System.currentTimeMillis();
		group.setTimeStamp(now);
		assertEquals(now, group.getTimeStamp());
	}

	/**
	 * Test method for {@link org.hbird.core.spacesystemmodel.tmtcgroups.HummingbirdParameterGroup#getTimeStamp()}.
	 */
	@Test
	public void testGetTimeStamp() {
		testSetTimeStamp();
	}

	/**
	 * Test method for {@link org.hbird.core.spacesystemmodel.tmtcgroups.HummingbirdParameterGroup#getAllParameters()}.
	 */
	@Test
	public void testGetAllParameters() {
		Map<String, Parameter<?>> params = group.getAllParameters();
		assertNotNull(params);
		assertEquals(0, params.size());
		group.addIntegerParameter("int", intParameter);
		params = group.getAllParameters();
		assertNotNull(params);
		assertEquals(1, params.size());
		assertTrue(params.containsKey("int"));
		assertEquals(intParameter, params.get("int"));
	}

	/**
	 * Test method for {@link org.hbird.core.spacesystemmodel.tmtcgroups.HummingbirdParameterGroup#getIntegerParameters()}.
	 */
	@Test
	public void testGetIntegerParameters() {
		testAddIntegerParameter();
	}

	/**
	 * Test method for {@link org.hbird.core.spacesystemmodel.tmtcgroups.HummingbirdParameterGroup#getLongParameters()}.
	 */
	@Test
	public void testGetLongParameters() {
		testAddLongParameter();
	}

	/**
	 * Test method for {@link org.hbird.core.spacesystemmodel.tmtcgroups.HummingbirdParameterGroup#getFloatParameters()}.
	 */
	@Test
	public void testGetFloatParameters() {
		testAddFloatParameter();
	}

	/**
	 * Test method for {@link org.hbird.core.spacesystemmodel.tmtcgroups.HummingbirdParameterGroup#getDoubleParameters()}.
	 */
	@Test
	public void testGetDoubleParameters() {
		testAddDoubleParameter();
	}

	/**
	 * Test method for {@link org.hbird.core.spacesystemmodel.tmtcgroups.HummingbirdParameterGroup#getBigDecimalParameters()}.
	 */
	@Test
	public void testGetBigDecimalParameters() {
		testAddBigDecimalParameter();
	}

	/**
	 * Test method for {@link org.hbird.core.spacesystemmodel.tmtcgroups.HummingbirdParameterGroup#getStringParameters()}.
	 */
	@Test
	public void testGetStringParameters() {
		testAddStringParameter();
	}

	/**
	 * Test method for {@link org.hbird.core.spacesystemmodel.tmtcgroups.HummingbirdParameterGroup#getRawParameters()}.
	 */
	@Test
	public void testGetRawParameters() {
		testAddRawParameter();
	}

	/**
	 * Test method for {@link org.hbird.core.spacesystemmodel.tmtcgroups.HummingbirdParameterGroup#addIntegerParameter(java.lang.String, org.hbird.core.commons.tmtc.Parameter)}.
	 */
	@Test
	public void testAddIntegerParameter() {
		String name = "int";
		Map<String, Parameter<Integer>> params = group.getIntegerParameters();
		assertNull(params);
		group.addIntegerParameter(name, intParameter);
		params = group.getIntegerParameters();
		assertNotNull(params);
		assertTrue(params.containsKey(name));
		assertEquals(intParameter, params.get(name));
		assertEquals(1, group.getParameterReport().getNumberIntParameters());
		Map<String, Parameter<?>> allParams = group.getAllParameters();
		assertNotNull(allParams);
		assertEquals(1, allParams.size());
		assertEquals(intParameter, allParams.get(name));
	}

	/**
	 * Test method for {@link org.hbird.core.spacesystemmodel.tmtcgroups.HummingbirdParameterGroup#addLongParameter(java.lang.String, org.hbird.core.commons.tmtc.Parameter)}.
	 */
	@Test
	public void testAddLongParameter() {
		String name = "long";
		Map<String, Parameter<Long>> params = group.getLongParameters();
		assertNull(params);
		group.addLongParameter(name, longParameter);
		params = group.getLongParameters();
		assertNotNull(params);
		assertTrue(params.containsKey(name));
		assertEquals(longParameter, params.get(name));
		assertEquals(1, group.getParameterReport().getNumberLongParameters());
		Map<String, Parameter<?>> allParams = group.getAllParameters();
		assertNotNull(allParams);
		assertEquals(1, allParams.size());
		assertEquals(longParameter, allParams.get(name));
	}

	/**
	 * Test method for {@link org.hbird.core.spacesystemmodel.tmtcgroups.HummingbirdParameterGroup#addBigDecimalParameter(java.lang.String, org.hbird.core.commons.tmtc.Parameter)}.
	 */
	@Test
	public void testAddBigDecimalParameter() {
		String name = "BiggestDecimalEver";
		Map<String, Parameter<BigDecimal>> params = group.getBigDecimalParameters();
		assertNull(params);
		group.addBigDecimalParameter(name, bigDecimalParameter);
		params = group.getBigDecimalParameters();
		assertNotNull(params);
		assertTrue(params.containsKey(name));
		assertEquals(bigDecimalParameter, params.get(name));
		assertEquals(1, group.getParameterReport().getNumberBigDecimalParameters());
		Map<String, Parameter<?>> allParams = group.getAllParameters();
		assertNotNull(allParams);
		assertEquals(1, allParams.size());
		assertEquals(bigDecimalParameter, allParams.get(name));
	}

	/**
	 * Test method for {@link org.hbird.core.spacesystemmodel.tmtcgroups.HummingbirdParameterGroup#addFloatParameter(java.lang.String, org.hbird.core.commons.tmtc.Parameter)}.
	 */
	@Test
	public void testAddFloatParameter() {
		String name = "float";
		Map<String, Parameter<Float>> params = group.getFloatParameters();
		assertNull(params);
		group.addFloatParameter(name, floatParameter);
		params = group.getFloatParameters();
		assertNotNull(params);
		assertTrue(params.containsKey(name));
		assertEquals(floatParameter, params.get(name));
		assertEquals(1, group.getParameterReport().getNumberFloatParameters());
		Map<String, Parameter<?>> allParams = group.getAllParameters();
		assertNotNull(allParams);
		assertEquals(1, allParams.size());
		assertEquals(floatParameter, allParams.get(name));
	}

	/**
	 * Test method for {@link org.hbird.core.spacesystemmodel.tmtcgroups.HummingbirdParameterGroup#addDoubleParameter(java.lang.String, org.hbird.core.commons.tmtc.Parameter)}.
	 */
	@Test
	public void testAddDoubleParameter() {
		String name = "double";
		Map<String, Parameter<Double>> params = group.getDoubleParameters();
		assertNull(params);
		group.addDoubleParameter(name, doubleParameter);
		params = group.getDoubleParameters();
		assertNotNull(params);
		assertTrue(params.containsKey(name));
		assertEquals(doubleParameter, params.get(name));
		assertEquals(1, group.getParameterReport().getNumberDoubleParameters());
		Map<String, Parameter<?>> allParams = group.getAllParameters();
		assertNotNull(allParams);
		assertEquals(1, allParams.size());
		assertEquals(doubleParameter, allParams.get(name));
	}

	/**
	 * Test method for {@link org.hbird.core.spacesystemmodel.tmtcgroups.HummingbirdParameterGroup#addStringParameter(java.lang.String, org.hbird.core.commons.tmtc.Parameter)}.
	 */
	@Test
	public void testAddStringParameter() {
		String name = "string";
		Map<String, Parameter<String>> params = group.getStringParameters();
		assertNull(params);
		group.addStringParameter(name, stringParameter);
		params = group.getStringParameters();
		assertNotNull(params);
		assertTrue(params.containsKey(name));
		assertEquals(stringParameter, params.get(name));
		assertEquals(1, group.getParameterReport().getNumberStringParameters());
		Map<String, Parameter<?>> allParams = group.getAllParameters();
		assertNotNull(allParams);
		assertEquals(1, allParams.size());
		assertEquals(stringParameter, allParams.get(name));
	}

	/**
	 * Test method for {@link org.hbird.core.spacesystemmodel.tmtcgroups.HummingbirdParameterGroup#addRawParameter(java.lang.String, org.hbird.core.commons.tmtc.Parameter)}.
	 */
	@Test
	public void testAddRawParameter() {
		String name = "raw";
		Map<String, Parameter<Byte[]>> params = group.getRawParameters();
		assertNull(params);
		group.addRawParameter(name, rawParameter);
		params = group.getRawParameters();
		assertNotNull(params);
		assertTrue(params.containsKey(name));
		assertEquals(rawParameter, params.get(name));
		assertEquals(1, group.getParameterReport().getNumberRawParameters());
		Map<String, Parameter<?>> allParams = group.getAllParameters();
		assertNotNull(allParams);
		assertEquals(1, allParams.size());
		assertEquals(rawParameter, allParams.get(name));
	}

	/**
	 * Test method for {@link org.hbird.core.spacesystemmodel.tmtcgroups.HummingbirdParameterGroup#getParameterReport()}.
	 */
	@Test
	public void testGetParameterReport() {
		ParameterGroupReport report = group.getParameterReport();
		assertNotNull(report);
		assertEquals(0, report.getNumberBigDecimalParameters());
		assertEquals(0, report.getNumberDoubleParameters());
		assertEquals(0, report.getNumberFloatParameters());
		assertEquals(0, report.getNumberIntParameters());
		assertEquals(0, report.getNumberLongParameters());
		assertEquals(0, report.getNumberRawParameters());
		assertEquals(0, report.getNumberStringParameters());
		
		group.addBigDecimalParameter("bigDecimal", bigDecimalParameter);
		group.addLongParameter("long", longParameter);
		report = group.getParameterReport();
		assertNotNull(report);
		assertEquals(1, report.getNumberBigDecimalParameters());
		assertEquals(0, report.getNumberDoubleParameters());
		assertEquals(0, report.getNumberFloatParameters());
		assertEquals(0, report.getNumberIntParameters());
		assertEquals(1, report.getNumberLongParameters());
		assertEquals(0, report.getNumberRawParameters());
		assertEquals(0, report.getNumberStringParameters());
	}

	/**
	 * Test method for {@link org.hbird.core.spacesystemmodel.tmtcgroups.HummingbirdParameterGroup#replaceParameterInGroup(java.lang.String, org.hbird.core.commons.tmtc.Parameter)}.
	 * @throws Exception 
	 */
	@Test
	public void testReplaceParameterInGroupInt() throws Exception {
		group.addIntegerParameter("int", new HummingbirdParameter<Integer>("int", "", "", ""));
		group.addLongParameter("long", new HummingbirdParameter<Long>("long", "", "", ""));
		group.addFloatParameter("float", new HummingbirdParameter<Float>("float", "", "", ""));
		group.addDoubleParameter("double", new HummingbirdParameter<Double>("double", "", "", ""));
		group.addBigDecimalParameter("bigDecimal", new HummingbirdParameter<BigDecimal>("bigDecimal", "", "", ""));
		group.addStringParameter("string", new HummingbirdParameter<String>("string", "", "", ""));
		group.addRawParameter("raw", new HummingbirdParameter<Byte[]>("raw", "", "", ""));
		
		assertNotSame(intParameter, group.getIntegerParameter("int"));
		assertNotSame(intParameter, group.getParameter("int"));
		
		when(intParameter.getQualifiedName()).thenReturn("int");
		group.replaceParameterInGroup("int", intParameter);
		assertEquals(intParameter, group.getIntegerParameter("int"));
		assertEquals(intParameter, group.getParameter("int"));
		inOrder.verify(intParameter, times(1)).getQualifiedName();
	}
	
	/**
	 * Test method for {@link org.hbird.core.spacesystemmodel.tmtcgroups.HummingbirdParameterGroup#replaceParameterInGroup(java.lang.String, org.hbird.core.commons.tmtc.Parameter)}.
	 * @throws Exception 
	 */
	@Test
	public void testReplaceParameterInGroupLong() throws Exception {
		group.addIntegerParameter("int", new HummingbirdParameter<Integer>("int", "", "", ""));
		group.addLongParameter("long", new HummingbirdParameter<Long>("long", "", "", ""));
		group.addFloatParameter("float", new HummingbirdParameter<Float>("float", "", "", ""));
		group.addDoubleParameter("double", new HummingbirdParameter<Double>("double", "", "", ""));
		group.addBigDecimalParameter("bigDecimal", new HummingbirdParameter<BigDecimal>("bigDecimal", "", "", ""));
		group.addStringParameter("string", new HummingbirdParameter<String>("string", "", "", ""));
		group.addRawParameter("raw", new HummingbirdParameter<Byte[]>("raw", "", "", ""));
		
		assertNotSame(longParameter, group.getLongParameter("long"));
		assertNotSame(longParameter, group.getParameter("long"));
		
		when(longParameter.getQualifiedName()).thenReturn("long");
		group.replaceParameterInGroup("long", longParameter);
		assertEquals(longParameter, group.getLongParameter("long"));
		assertEquals(longParameter, group.getParameter("long"));
		inOrder.verify(longParameter, times(1)).getQualifiedName();
	}
	
	/**
	 * Test method for {@link org.hbird.core.spacesystemmodel.tmtcgroups.HummingbirdParameterGroup#replaceParameterInGroup(java.lang.String, org.hbird.core.commons.tmtc.Parameter)}.
	 * @throws Exception 
	 */
	@Test
	public void testReplaceParameterInGroupFloat() throws Exception {
		group.addIntegerParameter("int", new HummingbirdParameter<Integer>("int", "", "", ""));
		group.addLongParameter("long", new HummingbirdParameter<Long>("long", "", "", ""));
		group.addFloatParameter("float", new HummingbirdParameter<Float>("float", "", "", ""));
		group.addDoubleParameter("double", new HummingbirdParameter<Double>("double", "", "", ""));
		group.addBigDecimalParameter("bigDecimal", new HummingbirdParameter<BigDecimal>("bigDecimal", "", "", ""));
		group.addStringParameter("string", new HummingbirdParameter<String>("string", "", "", ""));
		group.addRawParameter("raw", new HummingbirdParameter<Byte[]>("raw", "", "", ""));
		// TODO - 27.03.2012 kimmell - not implemented
//		assertNotSame(floatParameter, group.getFloatParameter("float"));
		assertNotSame(floatParameter, group.getParameter("float"));
		
		when(floatParameter.getQualifiedName()).thenReturn("float");
		group.replaceParameterInGroup("float", floatParameter);
		// TODO - 27.03.2012 kimmell - not implemented
//		assertEquals(floatParameter, group.getFloatParameter("float"));
		assertEquals(floatParameter, group.getParameter("float"));
		inOrder.verify(floatParameter, times(1)).getQualifiedName();
	}

	/**
	 * Test method for {@link org.hbird.core.spacesystemmodel.tmtcgroups.HummingbirdParameterGroup#replaceParameterInGroup(java.lang.String, org.hbird.core.commons.tmtc.Parameter)}.
	 * @throws Exception 
	 */
	@Test
	public void testReplaceParameterInGroupDouble() throws Exception {
		group.addIntegerParameter("int", new HummingbirdParameter<Integer>("int", "", "", ""));
		group.addLongParameter("long", new HummingbirdParameter<Long>("long", "", "", ""));
		group.addFloatParameter("float", new HummingbirdParameter<Float>("float", "", "", ""));
		group.addDoubleParameter("double", new HummingbirdParameter<Double>("double", "", "", ""));
		group.addBigDecimalParameter("bigDecimal", new HummingbirdParameter<BigDecimal>("bigDecimal", "", "", ""));
		group.addStringParameter("string", new HummingbirdParameter<String>("string", "", "", ""));
		group.addRawParameter("raw", new HummingbirdParameter<Byte[]>("raw", "", "", ""));
		
		// TODO - 27.03.2012 kimmell - not implemented
//		assertNotSame(doubleParameter, group.getDoubleParameter("double"));
		assertNotSame(doubleParameter, group.getParameter("double"));
		
		when(doubleParameter.getQualifiedName()).thenReturn("double");
		group.replaceParameterInGroup("double", doubleParameter);
		// TODO - 27.03.2012 kimmell - not implemented
//		assertEquals(doubleParameter, group.getDoubleParameter("double"));
		assertEquals(doubleParameter, group.getParameter("double"));
		inOrder.verify(doubleParameter, times(1)).getQualifiedName();
	}

	/**
	 * Test method for {@link org.hbird.core.spacesystemmodel.tmtcgroups.HummingbirdParameterGroup#replaceParameterInGroup(java.lang.String, org.hbird.core.commons.tmtc.Parameter)}.
	 * @throws Exception 
	 */
	@Test
	public void testReplaceParameterInGroupBigDecimal() throws Exception {
		group.addIntegerParameter("int", new HummingbirdParameter<Integer>("int", "", "", ""));
		group.addLongParameter("long", new HummingbirdParameter<Long>("long", "", "", ""));
		group.addFloatParameter("float", new HummingbirdParameter<Float>("float", "", "", ""));
		group.addDoubleParameter("double", new HummingbirdParameter<Double>("double", "", "", ""));
		group.addBigDecimalParameter("bigDecimal", new HummingbirdParameter<BigDecimal>("bigDecimal", "", "", ""));
		group.addStringParameter("string", new HummingbirdParameter<String>("string", "", "", ""));
		group.addRawParameter("raw", new HummingbirdParameter<Byte[]>("raw", "", "", ""));
		
		// TODO - 27.03.2012 kimmell - not implemented
//		assertNotSame(bigDecimalParameter, group.getBigDecimalParameter("bigDecimal"));
		assertNotSame(bigDecimalParameter, group.getParameter("bigDecimal"));
		
		when(bigDecimalParameter.getQualifiedName()).thenReturn("bigDecimal");
		group.replaceParameterInGroup("bigDecimal", bigDecimalParameter);
		// TODO - 27.03.2012 kimmell - not implemented
//		assertEquals(bigDecimalParameter, group.getBigDecimalParameter("bigDecimal"));
		assertEquals(bigDecimalParameter, group.getParameter("bigDecimal"));
		inOrder.verify(bigDecimalParameter, times(1)).getQualifiedName();
	}
	
	/**
	 * Test method for {@link org.hbird.core.spacesystemmodel.tmtcgroups.HummingbirdParameterGroup#replaceParameterInGroup(java.lang.String, org.hbird.core.commons.tmtc.Parameter)}.
	 * @throws Exception 
	 */
	@Test
	public void testReplaceParameterInGroupString() throws Exception {
		group.addIntegerParameter("int", new HummingbirdParameter<Integer>("int", "", "", ""));
		group.addLongParameter("long", new HummingbirdParameter<Long>("long", "", "", ""));
		group.addFloatParameter("float", new HummingbirdParameter<Float>("float", "", "", ""));
		group.addDoubleParameter("double", new HummingbirdParameter<Double>("double", "", "", ""));
		group.addBigDecimalParameter("bigDecimal", new HummingbirdParameter<BigDecimal>("bigDecimal", "", "", ""));
		group.addStringParameter("string", new HummingbirdParameter<String>("string", "", "", ""));
		group.addRawParameter("raw", new HummingbirdParameter<Byte[]>("raw", "", "", ""));
		
		assertNotSame(stringParameter, group.getStringParameter("string"));
		assertNotSame(stringParameter, group.getParameter("string"));
		
		when(stringParameter.getQualifiedName()).thenReturn("string");
		group.replaceParameterInGroup("string", stringParameter);
		assertEquals(stringParameter, group.getStringParameter("string"));
		assertEquals(stringParameter, group.getParameter("string"));
		inOrder.verify(stringParameter, times(1)).getQualifiedName();
	}

	/**
	 * Test method for {@link org.hbird.core.spacesystemmodel.tmtcgroups.HummingbirdParameterGroup#replaceParameterInGroup(java.lang.String, org.hbird.core.commons.tmtc.Parameter)}.
	 * @throws Exception 
	 */
	@Test
	public void testReplaceParameterInGroupRaw() throws Exception {
		group.addIntegerParameter("int", new HummingbirdParameter<Integer>("int", "", "", ""));
		group.addLongParameter("long", new HummingbirdParameter<Long>("long", "", "", ""));
		group.addFloatParameter("float", new HummingbirdParameter<Float>("float", "", "", ""));
		group.addDoubleParameter("double", new HummingbirdParameter<Double>("double", "", "", ""));
		group.addBigDecimalParameter("bigDecimal", new HummingbirdParameter<BigDecimal>("bigDecimal", "", "", ""));
		group.addStringParameter("string", new HummingbirdParameter<String>("string", "", "", ""));
		group.addRawParameter("raw", new HummingbirdParameter<Byte[]>("raw", "", "", ""));
		
		// TODO - 27.03.2012 kimmell - not implemented
//		assertNotSame(rawParameter, group.getRawParameter("raw"));
		assertNotSame(rawParameter, group.getParameter("raw"));
		
		when(rawParameter.getQualifiedName()).thenReturn("raw");
		group.replaceParameterInGroup("raw", rawParameter);
		// TODO - 27.03.2012 kimmell - not implemented
//		assertEquals(rawParameter, group.getRawParameter("raw"));
		assertEquals(rawParameter, group.getParameter("raw"));
		inOrder.verify(rawParameter, times(1)).getQualifiedName();
	}

	/**
	 * Test method for {@link org.hbird.core.spacesystemmodel.tmtcgroups.HummingbirdParameterGroup#getIntegerParameter(java.lang.String)}.
	 * @throws UnknownParameterException 
	 * @throws Exception 
	 */
	@Test(expected = UnknownParameterException.class)
	public void testGetIntegerParameterNotSet() throws UnknownParameterException {
		group.getIntegerParameter("int");
	}
	
	/**
	 * Test method for {@link org.hbird.core.spacesystemmodel.tmtcgroups.HummingbirdParameterGroup#getIntegerParameter(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testGetIntegerParameter() throws Exception {
		group.addIntegerParameter("int", intParameter);
		assertEquals(intParameter, group.getIntegerParameter("int"));
	}

	/**
	 * Test method for {@link org.hbird.core.spacesystemmodel.tmtcgroups.HummingbirdParameterGroup#getLongParameter(java.lang.String)}.
	 * @throws UnknownParameterException 
	 */
	@Test(expected = UnknownParameterException.class)
	public void testGetLongParameterNotSet() throws UnknownParameterException {
		group.getLongParameter("long");
	}
	
	/**
	 * Test method for {@link org.hbird.core.spacesystemmodel.tmtcgroups.HummingbirdParameterGroup#getLongParameter(java.lang.String)}.
	 * @throws UnknownParameterException 
	 */
	@Test
	public void testGetLongParameter() throws UnknownParameterException {
		group.addLongParameter("long", longParameter);
		assertEquals(longParameter, group.getLongParameter("long"));
	}

	/**
	 * Test method for {@link org.hbird.core.spacesystemmodel.tmtcgroups.HummingbirdParameterGroup#copyAllParameterValues(org.hbird.core.commons.tmtc.ParameterGroup)}.
	 * @throws Exception 
	 */
	@Test
	public void testCopyAllParameterValues() throws Exception {
		group.addIntegerParameter("int", new HummingbirdParameter<Integer>("int", "", "", ""));
		group.addLongParameter("long", new HummingbirdParameter<Long>("long", "", "", ""));
		// TODO - 27.03.2012 kimmell - not implemented
//		group.addFloatParameter("float", new HummingbirdParameter<Float>("float", "", "", ""));
//		group.addDoubleParameter("double", new HummingbirdParameter<Double>("double", "", "", ""));
//		group.addBigDecimalParameter("bigDecimal", new HummingbirdParameter<BigDecimal>("bigDecimal", "", "", ""));
		group.addStringParameter("string", new HummingbirdParameter<String>("string", "", "", ""));
//		group.addRawParameter("raw", new HummingbirdParameter<Byte[]>("raw", "", "", ""));
		

		int intVal = 100;
		long longVal = 2000L;
		float floatVal = 3.0F;
		double doubleVal = 4.012D;
		BigDecimal bigDecimalVal = new BigDecimal(5000);
		String stringVal = "value";
		Byte[] rawVal = new Byte[] { 0xD, 0xE, 0xA, 0xD, 0xC, 0x0, 0xD, 0xE };
		
		ParameterGroup source = new HummingbirdParameterGroup("source", "", "", "");
		source.addIntegerParameter("int", intParameter);
		source.addLongParameter("long", longParameter);
		source.addFloatParameter("float", floatParameter);
		source.addDoubleParameter("double", doubleParameter);
		source.addBigDecimalParameter("bigDecimal", bigDecimalParameter);
		source.addStringParameter("string", stringParameter);
		source.addRawParameter("raw", rawParameter);
		
		when(intParameter.getValue()).thenReturn(intVal);
		when(longParameter.getValue()).thenReturn(longVal);
		when(floatParameter.getValue()).thenReturn(floatVal);
		when(doubleParameter.getValue()).thenReturn(doubleVal);
		when(bigDecimalParameter.getValue()).thenReturn(bigDecimalVal);
		when(stringParameter.getValue()).thenReturn(stringVal);
		when(rawParameter.getValue()).thenReturn(rawVal);

		assertNull(group.getParameter("int").getValue());
		assertNull(group.getParameter("long").getValue());
		// TODO - 27.03.2012 kimmell - not implemented
//		assertNull(group.getParameter("float").getValue());
//		assertNull(group.getParameter("double").getValue());
//		assertNull(group.getParameter("bigDecimal").getValue());
		assertNull(group.getParameter("string").getValue());
//		assertNull(group.getParameter("raw").getValue());
		
		group.copyAllParameterValues(source);
		assertEquals(intVal, group.getParameter("int").getValue());
		assertEquals(longVal, group.getParameter("long").getValue());
		// TODO - 27.03.2012 kimmell - not implemented
//		assertEquals(floatVal, group.getParameter("double").getValue());
//		assertEquals(doubleVal, group.getParameter("float").getValue());
//		assertEquals(bigDecimalVal, group.getParameter("bigDecimal").getValue());
		assertEquals(stringVal, group.getParameter("string").getValue());
//		assertEquals(rawVal, group.getParameter("raw").getValue());
	}

	/**
	 * Test method for {@link org.hbird.core.spacesystemmodel.tmtcgroups.HummingbirdParameterGroup#getParameter(java.lang.String)}.
	 * @throws UnknownParameterException 
	 */
	@Test(expected = UnknownParameterException.class)
	public void testGetParameterNotSet() throws UnknownParameterException {
		group.getParameter("int");
	}
	
	/**
	 * Test method for {@link org.hbird.core.spacesystemmodel.tmtcgroups.HummingbirdParameterGroup#getParameter(java.lang.String)}.
	 * @throws UnknownParameterException 
	 */
	@Test
	public void testGetParameter() throws UnknownParameterException {
		group.addIntegerParameter("int", intParameter);
		assertEquals(intParameter, group.getParameter("int"));
	}

	/**
	 * Test method for {@link org.hbird.core.spacesystemmodel.tmtcgroups.HummingbirdParameterGroup#getQualifiedName()}.
	 */
	@Test
	public void testGetQualifiedName() {
		assertEquals(QN, group.getQualifiedName());
	}

	/**
	 * Test method for {@link org.hbird.core.spacesystemmodel.tmtcgroups.HummingbirdParameterGroup#getFloatParameter(java.lang.String)}.
	 * @throws UnknownParameterException 
	 */
	@Test(expected = UnsupportedOperationException.class)
	public void testGetFloatParameter() throws UnknownParameterException {
		group.getFloatParameter("float");
	}

	/**
	 * Test method for {@link org.hbird.core.spacesystemmodel.tmtcgroups.HummingbirdParameterGroup#getDoubleParameter(java.lang.String)}.
	 * @throws UnknownParameterException 
	 */
	@Test(expected = UnsupportedOperationException.class)
	public void testGetDoubleParameter() throws UnknownParameterException {
		group.getDoubleParameter("double");
	}

	/**
	 * Test method for {@link org.hbird.core.spacesystemmodel.tmtcgroups.HummingbirdParameterGroup#getBigDecimalParameter(java.lang.String)}.
	 * @throws UnknownParameterException 
	 */
	@Test(expected = UnsupportedOperationException.class)
	public void testGetBigDecimalParameter() throws UnknownParameterException {
		group.getBigDecimalParameter("double");
	}

	/**
	 * Test method for {@link org.hbird.core.spacesystemmodel.tmtcgroups.HummingbirdParameterGroup#getStringParameter(java.lang.String)}.
	 * @throws UnknownParameterException 
	 */
	@Test(expected = UnknownParameterException.class)
	public void testGetStringParameterNotSet() throws UnknownParameterException {
		group.getStringParameter("string");
	}
	
	/**
	 * Test method for {@link org.hbird.core.spacesystemmodel.tmtcgroups.HummingbirdParameterGroup#getStringParameter(java.lang.String)}.
	 * @throws UnknownParameterException 
	 */
	@Test
	public void testGetStringParameter() throws UnknownParameterException {
		group.addStringParameter("string", stringParameter);
		assertEquals(stringParameter, group.getStringParameter("string"));
	}

	/**
	 * Test method for {@link org.hbird.core.spacesystemmodel.tmtcgroups.HummingbirdParameterGroup#validateParameterNotNull(org.hbird.core.commons.tmtc.Parameter, java.lang.String)}.
	 * @throws UnknownParameterException 
	 */
	@Test(expected = UnknownParameterException.class)
	public void testValidateParameterNotNullWithNullValue() throws UnknownParameterException {
		group.validateParameterNotNull(null, "int");
	}
	
	/**
	 * Test method for {@link org.hbird.core.spacesystemmodel.tmtcgroups.HummingbirdParameterGroup#validateParameterNotNull(org.hbird.core.commons.tmtc.Parameter, java.lang.String)}.
	 * @throws UnknownParameterException 
	 */
	@Test
	public void testValidateParameterNotNull() throws UnknownParameterException {
		group.validateParameterNotNull(intParameter, "int");
	}
	
	/**
	 * Test method for {@link org.hbird.core.spacesystemmodel.tmtcgroups.HummingbirdParameterGroup#getRawParameter(java.lang.String)}.
	 * @throws UnknownParameterException 
	 */
	@Test(expected = UnsupportedOperationException.class)
	public void testGetRawParameter() throws UnknownParameterException {
		group.getRawParameter("raw");
	}

	/**
	 * Test method for {@link org.hbird.core.spacesystemmodel.tmtcgroups.HummingbirdParameterGroup#toString()}.
	 */
	@Test
	public void testToString() {
		assertNotNull(group.toString());
	}
}
