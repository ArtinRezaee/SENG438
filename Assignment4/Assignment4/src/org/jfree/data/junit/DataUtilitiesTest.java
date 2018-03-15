package org.jfree.data.junit;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.junit.*;
import org.jfree.data.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class DataUtilitiesTest
{
	@Before
	public void setUp()
	{
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
		values = testValues;
		
		testValues.addValue(1, 0, 0);
		testValues.addValue(4, 1, 0);
	}
	
	@After
	public void tearDown()
	{
		values = null;
	}
	
	@Test(expected = NullPointerException.class)
	public void testNullDataColumnTotal()
	{
			assertEquals(0.0, DataUtilities.calculateColumnTotal(null, 0), 0.0000001d);

	}
	
	@Test
	public void testValidDataAndColumnColumnTotal()
	{
		assertEquals(5.0, DataUtilities.calculateColumnTotal(values, 0), 0.0000001d);
	}
	
	@Test
	public void testValidDataInvalidColumnColumnTotal()
	{
		try {
			DataUtilities.calculateColumnTotal(values, 1);
			fail("When coloumn data is incorrect, method should throw an exception");
		}catch(Exception err) {
			assertEquals("The Exception was not correct", IndexOutOfBoundsException.class, err.getClass());
		}
	}
	
	private Values2D values;
}
