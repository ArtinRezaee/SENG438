package org.jfree.data.RangeTest;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

/**
 * Testing the getUpperBound function for Range class
 * Requires an existing Range object
 * Returns the upper bound value of the range
 * This is a public method
 * @author Satyaki Ghosh
 */
public class UpperBoundTest {

	/**
	 * testing the upper bound value of a range with positive bounds
	 */
	@Test
	public void TwoPositive() {
		assertEquals("Upper bound should be 10.0", 10.0, new Range(5, 10).getUpperBound(), .000000001d);
	}
	
	/**
	 * testing the upper bound value of a range with negative bounds
	 */
	@Test
	public void TwoNegative() {
		assertEquals("Upper bound should be -1.0", -1.0, new Range(-3, -1).getUpperBound(), .000000001d);
	}
	
	/**
	 * testing the upper bound value of a range with negative - positive bounds
	 */
	@Test
	public void NegAndPositive() {
		assertEquals("Upper bound should be 2.0", 2.0, new Range(-1, 2).getUpperBound(), .000000001d);
	}
	
	/**
	 * testing the upper bound value of a range with the same bound i.e. length 1
	 */
	@Test
	public void SameNumber() {
		assertEquals("Upper bound should be 1.0", 1.0, new Range(1, 1).getUpperBound(), .000000001d);
	}
}
