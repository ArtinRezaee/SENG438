package org.jfree.data.range;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class IntersectsTest{
	
	private Range exampleRange;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	/**
	 * sets up a range of 5-10 for each test
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		exampleRange = new Range(5.0, 10.0);
	}
	
	/**
	 * Test if the a false value is returned when a range which is less than the original range is checked for intersection
	 */
	@Test
	public void LowerBoundNotCrossingTest() {
		assertFalse("The two ranges cross", this.exampleRange.intersects(1.0, 3.0));
	}
	
	
	/**
	 * Checks if a false value is returned when a range which is greater than the original range is checked for intersection
	 */
	@Test
	public void UpperBoundNotCrossingTest() {
		assertFalse("The two ranges cross", this.exampleRange.intersects(15.0, 20.0));
	}
	
	/**
	 * Checks if a true value is returned when a range cross the lower bound of the original range
	 */
	@Test
	public void LowerBoundCrossingTest() {
		assertTrue("The two ranges do not cross", this.exampleRange.intersects(3.0, 7.0));
	}
	
	/**
	 * Checks if a true value is returned when a range cross the upper bound of the original range 
	 */
	@Test
	public void UpperBoundCrossingTest() {
		assertTrue("The two ranges do not cross", this.exampleRange.intersects(7.0, 120.0));
	}
	
	/**
	 * Checks if a true value is returned when the range is exactly the same as the original range
	 */
	@Test
	public void AllRangeCrossingTest() {
		assertTrue("The two ranges do not cross", this.exampleRange.intersects(5.0, 10.0));
	}
	
	/**
	 * Checks if a true value is returned when a range is in between the original range
	 */
	@Test
	public void RangeCrossingInBetweenTest() {
		assertTrue("The two ranges do not cross", this.exampleRange.intersects(8.0, 9.0));
	}
	
	@After
	public void tearDown() throws Exception {
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
}
