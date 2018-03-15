package org.jfree.data.RangeTest;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ShiftWithAllowZeroCrossingTest {
	
	private Range range, range2;
	
	/**
	 * Tests the shift method whether a null parameter passed in will throw an
	 * InvalidParameterException
	 */
	@Test
	public void shiftWithNullBaseTest() {
		try {
			Range.shift(null, 5, false);
			fail("The shift method should have thrown an InvalidParameterException");
		}
		catch(Exception e) {
			assertEquals("Wrong type of exception was thrown", 
					NullPointerException.class, e.getClass());
		}
	}
	
	/**
	 * Tests the shift method whether a positive delta parameter will shift
	 * the range boundaries as expected
	 */
	@Test
	public void shiftWithPositiveDeltaWithoutCrossingZeroAndNotAllowedTest() {
		range = new Range(0, 10);
		range2 = new Range(2, 12);
		assertEquals("After function shift() using positive delta, not allowing zero crossing, and not crossing zero,"
				+ "the range shifts incorrectly to a number other than the delta.",
				range2, Range.shift(range, 2, false));
	}
	
	/**
	 * Tests the shift method whether a negative delta parameter will shift
	 * the range boundaries as expected
	 */
	@Test
	public void shiftWithNegativeDeltaWithoutCrossingZeroAndNotAllowedTest() {
		range = new Range(-1, 0);
		range2 = new Range(-2, -1);
		assertEquals("After function shift() using negative delta, not allowing zero crossing, and not crossing zero,"
				+ "the range shifts incorrectly to a number other than the delta.",
				range2, Range.shift(range, -1, false));
	}
	
	/**
	 * Tests the shift method whether a negative delta parameter will shift
	 * the range boundaries as expected after crossing zero when it is
	 * not allowed
	 */
	@Test
	public void shiftWithNegativeDeltaWithCrossingZeroAndNotAllowedTest() {
		range = new Range(1, 2);
		range2 = new Range(0, 0);
		assertEquals("After function shift() using negative delta, not allowing zero crossing but crossing zero,"
				+ "the range shifts incorrectly to a number other than the delta and/or bound(s) does not go"
				+ "to zero.",
				range2, Range.shift(range, -2, false));
	}
	
	/**
	 * Tests the shift method whether a positive delta parameter will shift
	 * the range boundaries as expected after crossing zero when it is
	 * not allowed
	 */
	@Test
	public void shiftWithPositiveDeltaWithCrossingZeroAndNotAllowedTest() {
		range = new Range(-3, -1);
		range2 = new Range(0, 0);
		assertEquals("After function shift() using positive delta, not allowing zero crossing but crossing zero,"
				+ "the range shifts incorrectly to a number other than the delta and/or bound(s) does not go"
				+ " to zero.",
				range2, Range.shift(range, 4, false));
	}
	
	/**
	 * Tests the shift method whether a positive delta parameter will shift
	 * the range boundaries as expected without crossing zero when it is
	 * allowed
	 */
	@Test
	public void shiftWithPositiveDeltaWithoutCrossingZeroButAllowedTest() {
		range = new Range(0, 10);
		range2 = new Range(2, 12);
		assertEquals("After function shift() using positive delta, allowing zero crossing but not crossing zero,"
				+ "the range shifts incorrectly to a number other than the delta.",
				range2, Range.shift(range, 2, true));
	}
	
	/**
	 * Tests the shift method whether a negative delta parameter will shift
	 * the range boundaries as expected without crossing zero when it is
	 * allowed
	 */
	@Test
	public void shiftWithNegativeDeltaWithoutCrossingZeroButAllowedTest() {
		range = new Range(-1, 0);
		range2 = new Range(-2, -1);
		assertEquals("After function shift() using negative delta, allowing zero crossing but not crossing zero,"
				+ "the range shifts incorrectly to a number other than the delta.",
				range2, Range.shift(range, -1, true));
	}
	
	/**
	 * Tests the shift method whether a negative delta parameter will shift
	 * the range boundaries as expected after crossing zero when it is
	 * allowed
	 */
	@Test
	public void shiftWithNegativeDeltaWithCrossingZeroButAllowedTest() {
		range = new Range(1, 2);
		range2 = new Range(-2, -1);
		assertEquals("After function shift() using negative delta, allowing zero crossing and crossing zero,"
				+ "the range shifts incorrectly to a number other than the delta.",
				range2, Range.shift(range, -3, true));
	}
	
	/**
	 * Tests the shift method whether a positive delta parameter will shift
	 * the range boundaries as expected after crossing zero when it is
	 * allowed
	 */
	@Test
	public void shiftWithPositiveDeltaWithCrossingZeroButAllowedTest() {
		range = new Range(-3, -1);
		range2 = new Range(1, 3);
		assertEquals("After function shift() using positive delta, allowing zero crossing and crossing zero,"
				+ "the range shifts incorrectly to a number other than the delta.",
				range2, Range.shift(range, 4, true));
	}

}
