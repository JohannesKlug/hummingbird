package org.hbird.core.spacesystemmodel.tmtcgroups;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;
import java.util.Map;

import org.hbird.core.commons.tmtc.Parameter;
import org.hbird.core.commons.tmtc.ParameterGroupReport;
import org.hbird.core.commons.tmtc.exceptions.UnknownParameterException;
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
		when(intParameter.getQualifiedName()).thenReturn("int");
		when(longParameter.getQualifiedName()).thenReturn("long");
		when(floatParameter.getQualifiedName()).thenReturn("float");
		when(doubleParameter.getQualifiedName()).thenReturn("double");
		when(bigDecimalParameter.getQualifiedName()).thenReturn("bigDecimal");
		when(stringParameter.getQualifiedName()).thenReturn("string");
		when(rawParameter.getQualifiedName()).thenReturn("raw");
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
		group.addIntegerParameter(intParameter);
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
		group.addIntegerParameter(intParameter);
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
		group.addLongParameter(longParameter);
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
		String name = "bigDecimal";
		Map<String, Parameter<BigDecimal>> params = group.getBigDecimalParameters();
		assertNull(params);
		group.addBigDecimalParameter(bigDecimalParameter);
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
		group.addFloatParameter(floatParameter);
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
		group.addDoubleParameter(doubleParameter);
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
		group.addStringParameter(stringParameter);
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
		group.addRawParameter(rawParameter);
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
		
		group.addBigDecimalParameter(bigDecimalParameter);
		group.addLongParameter(longParameter);
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
		group.addIntegerParameter(intParameter);
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
		group.addLongParameter(longParameter);
		assertEquals(longParameter, group.getLongParameter("long"));
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
		group.addIntegerParameter(intParameter);
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
		group.addStringParameter(stringParameter);
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
	
	/**
	 * Test method for {@link org.hbird.core.spacesystemmodel.tmtcgroups.HummingbirdParameterGroup#validateQualifiedName(String)}.
	 * @throws UnknownParameterException 
	 */
	@Test
	public void testValidateQualifiedName() throws UnknownParameterException {
		group.validateQualifiedName("int");
		group.validateQualifiedName("");
		group.validateQualifiedName(" ");
		group.validateQualifiedName("\n");
		group.validateQualifiedName(" int ");
	}

	/**
	 * Test method for {@link org.hbird.core.spacesystemmodel.tmtcgroups.HummingbirdParameterGroup#validateQualifiedName(String)}.
	 * @throws UnknownParameterException 
	 */
	@Test(expected = NullPointerException.class)
	public void testValidateQualifiedNameNull() throws UnknownParameterException {
		group.validateQualifiedName(null);
	}
}
