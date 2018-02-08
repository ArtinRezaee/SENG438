package jfree.RangeTest;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

public class ConstrainTest{
	
	private Range range;
	
	@Before
	public void setUp() throws Exception {
		range = new Range(0.0, 10.0);
	}
	
	/**
	 * Tests the method constrain whether a number lower than the lower bound of the range will return the
	 * the closest value of the range
	 */
	@Test
	public void constrainNumberLowerThanLowerBoundTest() {
		assertEquals("The constrain method does not return the closest value within the range"
				+ "for a number lower than the lower bound.", 0.0, range.constrain(-9991.0),
				.000000001d);
	}
	
	/**
	 * Tests the method constrain whether a number higher than the upper bound of the range will return
	 * the closest value of the range if passed as a parameter
	 */
	@Test
	public void constrainNumberHigherThanUpperBoundTest() {
		assertEquals("The constrain method does not return the closest value within the range"
				+ "for a number higher than the upper bound.", 10.0, range.constrain(8684.0),
				.000000001d);
	}
	
	/**
	 * Tests the method constrain whether a number within the range returns the parameter passed in
	 */
	@Test
	public void constrainNumberInRangeTest() {
		assertEquals("The constrain method does not return the parameter itself"
				+ " if it is within the range", 8.0, range.constrain(8.0),
				.000000001d);
	}
	
	/**
	 * Tests the method constrain whether the upper boundary value passed as the parameter
	 * will return itself
	 */
	@Test
	public void constrainUpperBoundaryTest() {
		assertEquals("The constrain method does not return the value of the Upper Bound"
				+ "if it was passed as a parameter.", 10.0, range.constrain(10.0),
				.000000001d);
	}
	
	/**
	 * Tests the method constrain whether the lower boundary value passed as the parameter
	 * will return itself
	 */
	@Test
	public void constrainLowerBoundaryTest() {
		assertEquals("The constrain method does not return the value of the Lower Bound"
				+ "if it was passed as a parameter.", 0.0, range.constrain(0.0),
				.000000001d);
	}

	

}
