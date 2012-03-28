package org.hbird.core.spacesystemmodel.tmtcgroups;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.hbird.core.commons.tmtc.Parameter;
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
public class TmTcGroupsTest {

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
	
	private HummingbirdParameterGroup source;
	
	private HummingbirdParameterGroup target;

	
	@Before
	public void setUp() {
		source = new HummingbirdParameterGroup("source", "", "", "");
		target = new HummingbirdParameterGroup("target", "", "", "");
		inOrder = inOrder(intParameter, longParameter, floatParameter, doubleParameter, bigDecimalParameter, stringParameter, rawParameter);
	}
	
	public void tearDown() {
		inOrder.verifyNoMoreInteractions();
	}

	
	/**
	 * Test method for {@link org.hbird.core.spacesystemmodel.tmtcgroups.HummingbirdParameterGroup#copyAllParameterValues(org.hbird.core.commons.tmtc.ParameterGroup)}.
	 * @throws Exception 
	 */
	@Test
	public void testCopyAllParameterValues() throws Exception {
		target.addIntegerParameter("int", new HummingbirdParameter<Integer>("int", "", "", ""));
		target.addLongParameter("long", new HummingbirdParameter<Long>("long", "", "", ""));
		// TODO - 27.03.2012 kimmell - not implemented
//		target.addFloatParameter("float", new HummingbirdParameter<Float>("float", "", "", ""));
//		target.addDoubleParameter("double", new HummingbirdParameter<Double>("double", "", "", ""));
//		target.addBigDecimalParameter("bigDecimal", new HummingbirdParameter<BigDecimal>("bigDecimal", "", "", ""));
		target.addStringParameter("string", new HummingbirdParameter<String>("string", "", "", ""));
//		target.addRawParameter("raw", new HummingbirdParameter<Byte[]>("raw", "", "", ""));
		

		int intVal = 100;
		long longVal = 2000L;
		float floatVal = 3.0F;
		double doubleVal = 4.012D;
		BigDecimal bigDecimalVal = new BigDecimal(5000);
		String stringVal = "value";
		Byte[] rawVal = new Byte[] { 0xD, 0xE, 0xA, 0xD, 0xC, 0x0, 0xD, 0xE };
		
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

		assertNull(target.getParameter("int").getValue());
		assertNull(target.getParameter("long").getValue());
		// TODO - 27.03.2012 kimmell - not implemented
//		assertNull(target.getParameter("float").getValue());
//		assertNull(target.getParameter("double").getValue());
//		assertNull(target.getParameter("bigDecimal").getValue());
		assertNull(target.getParameter("string").getValue());
//		assertNull(target.getParameter("raw").getValue());
		
		
		TmTcGroups.copyAllParameterValues(source, target);
		assertEquals(intVal, target.getParameter("int").getValue());
		assertEquals(longVal, target.getParameter("long").getValue());
		// TODO - 27.03.2012 kimmell - not implemented
//		assertEquals(floatVal, target.getParameter("double").getValue());
//		assertEquals(doubleVal, target.getParameter("float").getValue());
//		assertEquals(bigDecimalVal, target.getParameter("bigDecimal").getValue());
		assertEquals(stringVal, target.getParameter("string").getValue());
//		assertEquals(rawVal, target.getParameter("raw").getValue());
	}
	
	/**
	 * Test method for {@link org.hbird.core.spacesystemmodel.tmtcgroups.HummingbirdParameterGroup#copyAllParameterValues(org.hbird.core.commons.tmtc.ParameterGroup)}.
	 * @throws Exception 
	 */
	@Test(expected = RuntimeException.class)
	public void testCopyAllParameterValuesWithException() throws Exception {
		target.addIntegerParameter("int", intParameter);
		TmTcGroups.copyAllParameterValues(source, target);
	}
	
	/**
	 * Test method for {@link org.hbird.core.spacesystemmodel.tmtcgroups.HummingbirdParameterGroup#replaceParameterInGroup(java.lang.String, org.hbird.core.commons.tmtc.Parameter)}.
	 * @throws Exception 
	 */
	@Test
	public void testReplaceParameterInGroupInt() throws Exception {
		target.addIntegerParameter("int", new HummingbirdParameter<Integer>("int", "", "", ""));
		target.addLongParameter("long", new HummingbirdParameter<Long>("long", "", "", ""));
		target.addFloatParameter("float", new HummingbirdParameter<Float>("float", "", "", ""));
		target.addDoubleParameter("double", new HummingbirdParameter<Double>("double", "", "", ""));
		target.addBigDecimalParameter("bigDecimal", new HummingbirdParameter<BigDecimal>("bigDecimal", "", "", ""));
		target.addStringParameter("string", new HummingbirdParameter<String>("string", "", "", ""));
		target.addRawParameter("raw", new HummingbirdParameter<Byte[]>("raw", "", "", ""));
		
		assertNotSame(intParameter, target.getIntegerParameter("int"));
		assertNotSame(intParameter, target.getParameter("int"));
		
		when(intParameter.getQualifiedName()).thenReturn("int");
		TmTcGroups.replaceParameterInGroup(target, "int", intParameter);
		assertEquals(intParameter, target.getIntegerParameter("int"));
		assertEquals(intParameter, target.getParameter("int"));
		inOrder.verify(intParameter, times(1)).getQualifiedName();
	}
	
	/**
	 * Test method for {@link org.hbird.core.spacesystemmodel.tmtcgroups.HummingbirdParameterGroup#replaceParameterInGroup(java.lang.String, org.hbird.core.commons.tmtc.Parameter)}.
	 * @throws Exception 
	 */
	@Test
	public void testReplaceParameterInGroupLong() throws Exception {
		target.addIntegerParameter("int", new HummingbirdParameter<Integer>("int", "", "", ""));
		target.addLongParameter("long", new HummingbirdParameter<Long>("long", "", "", ""));
		target.addFloatParameter("float", new HummingbirdParameter<Float>("float", "", "", ""));
		target.addDoubleParameter("double", new HummingbirdParameter<Double>("double", "", "", ""));
		target.addBigDecimalParameter("bigDecimal", new HummingbirdParameter<BigDecimal>("bigDecimal", "", "", ""));
		target.addStringParameter("string", new HummingbirdParameter<String>("string", "", "", ""));
		target.addRawParameter("raw", new HummingbirdParameter<Byte[]>("raw", "", "", ""));
		
		assertNotSame(longParameter, target.getLongParameter("long"));
		assertNotSame(longParameter, target.getParameter("long"));
		
		when(longParameter.getQualifiedName()).thenReturn("long");
		TmTcGroups.replaceParameterInGroup(target, "long", longParameter);
		assertEquals(longParameter, target.getLongParameter("long"));
		assertEquals(longParameter, target.getParameter("long"));
		inOrder.verify(longParameter, times(1)).getQualifiedName();
	}
	
	/**
	 * Test method for {@link org.hbird.core.spacesystemmodel.tmtcgroups.HummingbirdParameterGroup#replaceParameterInGroup(java.lang.String, org.hbird.core.commons.tmtc.Parameter)}.
	 * @throws Exception 
	 */
	@Test
	public void testReplaceParameterInGroupFloat() throws Exception {
		target.addIntegerParameter("int", new HummingbirdParameter<Integer>("int", "", "", ""));
		target.addLongParameter("long", new HummingbirdParameter<Long>("long", "", "", ""));
		target.addFloatParameter("float", new HummingbirdParameter<Float>("float", "", "", ""));
		target.addDoubleParameter("double", new HummingbirdParameter<Double>("double", "", "", ""));
		target.addBigDecimalParameter("bigDecimal", new HummingbirdParameter<BigDecimal>("bigDecimal", "", "", ""));
		target.addStringParameter("string", new HummingbirdParameter<String>("string", "", "", ""));
		target.addRawParameter("raw", new HummingbirdParameter<Byte[]>("raw", "", "", ""));
		// TODO - 27.03.2012 kimmell - not implemented
//		assertNotSame(floatParameter, target.getFloatParameter("float"));
		assertNotSame(floatParameter, target.getParameter("float"));
		
		when(floatParameter.getQualifiedName()).thenReturn("float");
		TmTcGroups.replaceParameterInGroup(target, "float", floatParameter);
		// TODO - 27.03.2012 kimmell - not implemented
//		assertEquals(floatParameter, target.getFloatParameter("float"));
		assertEquals(floatParameter, target.getParameter("float"));
		inOrder.verify(floatParameter, times(1)).getQualifiedName();
	}

	/**
	 * Test method for {@link org.hbird.core.spacesystemmodel.tmtcgroups.HummingbirdParameterGroup#replaceParameterInGroup(java.lang.String, org.hbird.core.commons.tmtc.Parameter)}.
	 * @throws Exception 
	 */
	@Test
	public void testReplaceParameterInGroupDouble() throws Exception {
		target.addIntegerParameter("int", new HummingbirdParameter<Integer>("int", "", "", ""));
		target.addLongParameter("long", new HummingbirdParameter<Long>("long", "", "", ""));
		target.addFloatParameter("float", new HummingbirdParameter<Float>("float", "", "", ""));
		target.addDoubleParameter("double", new HummingbirdParameter<Double>("double", "", "", ""));
		target.addBigDecimalParameter("bigDecimal", new HummingbirdParameter<BigDecimal>("bigDecimal", "", "", ""));
		target.addStringParameter("string", new HummingbirdParameter<String>("string", "", "", ""));
		target.addRawParameter("raw", new HummingbirdParameter<Byte[]>("raw", "", "", ""));
		
		// TODO - 27.03.2012 kimmell - not implemented
//		assertNotSame(doubleParameter, target.getDoubleParameter("double"));
		assertNotSame(doubleParameter, target.getParameter("double"));
		
		when(doubleParameter.getQualifiedName()).thenReturn("double");
		TmTcGroups.replaceParameterInGroup(target, "double", doubleParameter);
		// TODO - 27.03.2012 kimmell - not implemented
//		assertEquals(doubleParameter, target.getDoubleParameter("double"));
		assertEquals(doubleParameter, target.getParameter("double"));
		inOrder.verify(doubleParameter, times(1)).getQualifiedName();
	}

	/**
	 * Test method for {@link org.hbird.core.spacesystemmodel.tmtcgroups.HummingbirdParameterGroup#replaceParameterInGroup(java.lang.String, org.hbird.core.commons.tmtc.Parameter)}.
	 * @throws Exception 
	 */
	@Test
	public void testReplaceParameterInGroupBigDecimal() throws Exception {
		target.addIntegerParameter("int", new HummingbirdParameter<Integer>("int", "", "", ""));
		target.addLongParameter("long", new HummingbirdParameter<Long>("long", "", "", ""));
		target.addFloatParameter("float", new HummingbirdParameter<Float>("float", "", "", ""));
		target.addDoubleParameter("double", new HummingbirdParameter<Double>("double", "", "", ""));
		target.addBigDecimalParameter("bigDecimal", new HummingbirdParameter<BigDecimal>("bigDecimal", "", "", ""));
		target.addStringParameter("string", new HummingbirdParameter<String>("string", "", "", ""));
		target.addRawParameter("raw", new HummingbirdParameter<Byte[]>("raw", "", "", ""));
		
		// TODO - 27.03.2012 kimmell - not implemented
//		assertNotSame(bigDecimalParameter, target.getBigDecimalParameter("bigDecimal"));
		assertNotSame(bigDecimalParameter, target.getParameter("bigDecimal"));
		
		when(bigDecimalParameter.getQualifiedName()).thenReturn("bigDecimal");
		TmTcGroups.replaceParameterInGroup(target, "bigDecimal", bigDecimalParameter);
		// TODO - 27.03.2012 kimmell - not implemented
//		assertEquals(bigDecimalParameter, target.getBigDecimalParameter("bigDecimal"));
		assertEquals(bigDecimalParameter, target.getParameter("bigDecimal"));
		inOrder.verify(bigDecimalParameter, times(1)).getQualifiedName();
	}
	
	/**
	 * Test method for {@link org.hbird.core.spacesystemmodel.tmtcgroups.HummingbirdParameterGroup#replaceParameterInGroup(java.lang.String, org.hbird.core.commons.tmtc.Parameter)}.
	 * @throws Exception 
	 */
	@Test
	public void testReplaceParameterInGroupString() throws Exception {
		target.addIntegerParameter("int", new HummingbirdParameter<Integer>("int", "", "", ""));
		target.addLongParameter("long", new HummingbirdParameter<Long>("long", "", "", ""));
		target.addFloatParameter("float", new HummingbirdParameter<Float>("float", "", "", ""));
		target.addDoubleParameter("double", new HummingbirdParameter<Double>("double", "", "", ""));
		target.addBigDecimalParameter("bigDecimal", new HummingbirdParameter<BigDecimal>("bigDecimal", "", "", ""));
		target.addStringParameter("string", new HummingbirdParameter<String>("string", "", "", ""));
		target.addRawParameter("raw", new HummingbirdParameter<Byte[]>("raw", "", "", ""));
		
		assertNotSame(stringParameter, target.getStringParameter("string"));
		assertNotSame(stringParameter, target.getParameter("string"));
		
		when(stringParameter.getQualifiedName()).thenReturn("string");
		TmTcGroups.replaceParameterInGroup(target, "string", stringParameter);
		assertEquals(stringParameter, target.getStringParameter("string"));
		assertEquals(stringParameter, target.getParameter("string"));
		inOrder.verify(stringParameter, times(1)).getQualifiedName();
	}

	/**
	 * Test method for {@link org.hbird.core.spacesystemmodel.tmtcgroups.HummingbirdParameterGroup#replaceParameterInGroup(java.lang.String, org.hbird.core.commons.tmtc.Parameter)}.
	 * @throws Exception 
	 */
	@Test
	public void testReplaceParameterInGroupRaw() throws Exception {
		target.addIntegerParameter("int", new HummingbirdParameter<Integer>("int", "", "", ""));
		target.addLongParameter("long", new HummingbirdParameter<Long>("long", "", "", ""));
		target.addFloatParameter("float", new HummingbirdParameter<Float>("float", "", "", ""));
		target.addDoubleParameter("double", new HummingbirdParameter<Double>("double", "", "", ""));
		target.addBigDecimalParameter("bigDecimal", new HummingbirdParameter<BigDecimal>("bigDecimal", "", "", ""));
		target.addStringParameter("string", new HummingbirdParameter<String>("string", "", "", ""));
		target.addRawParameter("raw", new HummingbirdParameter<Byte[]>("raw", "", "", ""));
		
		// TODO - 27.03.2012 kimmell - not implemented
//		assertNotSame(rawParameter, target.getRawParameter("raw"));
		assertNotSame(rawParameter, target.getParameter("raw"));
		
		when(rawParameter.getQualifiedName()).thenReturn("raw");
		TmTcGroups.replaceParameterInGroup(target, "raw", rawParameter);
		// TODO - 27.03.2012 kimmell - not implemented
//		assertEquals(rawParameter, target.getRawParameter("raw"));
		assertEquals(rawParameter, target.getParameter("raw"));
		inOrder.verify(rawParameter, times(1)).getQualifiedName();
	}
}
