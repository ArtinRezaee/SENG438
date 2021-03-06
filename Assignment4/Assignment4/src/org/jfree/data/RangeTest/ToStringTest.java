package org.jfree.data.RangeTest;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;

public class ToStringTest{

	private Range exampleRange;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	/**
	 * Creates a range for each test
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		exampleRange = new Range(2.0, 10.0);
	}
	
	/**
	 * Test if the correct string representation of the range is returned. 
	 */
	@Test
	public void toStringTest() {
		assertEquals("The two stings are not equal", "Range[2.0,10.0]" , this.exampleRange.toString());
	}
	
	@After
	public void tearDown() throws Exception {
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	

}
