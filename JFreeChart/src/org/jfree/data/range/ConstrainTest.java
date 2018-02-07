package org.jfree.data.range;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ConstrainTest{
	
	private Range range;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		range = new Range(0.0, 10.0);
	}
	
	@Test
	public void constrainNumberLowerThanLowerBoundTest() {
		assertEquals("The constrain method does not return the closest value within the range"
				+ "for a number lower than the lower bound.", 0.0, range.constrain(-9991.0),
				.000000001d);
	}
	
	@Test
	public void constrainNumberHigherThanUpperBoundTest() {
		assertEquals("The constrain method does not return the closest value within the range"
				+ "for a number higher than the upper bound.", 10.0, range.constrain(8684.0),
				.000000001d);
	}
	
	@Test
	public void constrainNumberInRangeTest() {
		assertEquals("The constrain method does not return the parameter itself"
				+ " if it is within the range", 8.0, range.constrain(8.0),
				.000000001d);
	}
	
	@Test
	public void constrainUpperBoundaryTest() {
		assertEquals("The constrain method does not return the value of the Upper Bound"
				+ "if it was passed as a parameter.", 10.0, range.constrain(10.0),
				.000000001d);
	}
	
	@Test
	public void constrainLowerBoundaryTest() {
		assertEquals("The constrain method does not return the value of the Lower Bound"
				+ "if it was passed as a parameter.", 0.0, range.constrain(0.0),
				.000000001d);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	

}
