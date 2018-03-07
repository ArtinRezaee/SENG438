package org.jfree.data;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

/**
 * Testing the getCentralValue function for Range class
 * Requires an existing Range object
 * Returns the central(median) value of the range
 * This is a public method
 * @author Satyaki Ghosh
 */
public class CentralValueTest {

	/**
	 * testing the central value of a range with positive bounds
	 */
	@Test
	public void TwoPositive() {
		assertEquals("Central value should be 7.5", 7.5,  new Range(5, 10).getCentralValue(), .000000001d);
	}
	
	/**
	 * testing the central value of a range with negative bounds
	 */
	@Test
	public void TwoNegative() {
		assertEquals("Central value should be -2.0", -2.0, new Range(-3, -1).getCentralValue(), .000000001d);
	}
	
	/**
	 * testing the central value of a range with negative - positive bounds
	 */
	@Test
	public void NegAndPositive() {
		assertEquals("Central value should be 0.5", 0.5, new Range(-1, 2).getCentralValue(), .000000001d);
	}
	
	/**
	 * testing the central value of a range with the same bound i.e. length 1
	 */
	@Test
	public void SameNumber() {
		assertEquals("Central value should be 1.0", 1.0, new Range(1, 1).getCentralValue(), .000000001d);
	}
}
