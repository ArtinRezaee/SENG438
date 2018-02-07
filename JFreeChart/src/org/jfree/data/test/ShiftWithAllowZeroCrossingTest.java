package org.jfree.data.test;

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

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void shiftWithNullBaseTest() {
		try {
			Range.shift(range, 5, false);
		}
		catch(Exception err) {
			assertEquals("Shift did not throw expected error: ", InvalidParameterException.class, err.getClass());
		}
	}

	@Test
	public void shiftWithPositiveDeltaWithoutCrossingZeroAndNotAllowedTest() {
		range = new Range(0, 10);
		range2 = new Range(2, 12);
		assertEquals("After function shift() using positive delta, not allowing zero crossing, and not crossing zero,"
				+ "the range shifts incorrectly to a number other than the delta.",
				range2, Range.shift(range, 2, false));
	}
	
	@Test
	public void shiftWithNegativeDeltaWithoutCrossingZeroAndNotAllowedTest() {
		range = new Range(-1, 0);
		range2 = new Range(-2, -1);
		assertEquals("After function shift() using negative delta, not allowing zero crossing, and not crossing zero,"
				+ "the range shifts incorrectly to a number other than the delta.",
				range2, Range.shift(range, -1, false));
	}
	
	@Test
	public void shiftWithNegativeDeltaWithCrossingZeroAndNotAllowedTest() {
		range = new Range(1, 2);
		range2 = new Range(0, 0);
		assertEquals("After function shift() using negative delta, not allowing zero crossing but crossing zero,"
				+ "the range shifts incorrectly to a number other than the delta and/or bound(s) does not go"
				+ "to zero.",
				range2, Range.shift(range, -2, false));
	}
	
	@Test
	public void shiftWithPositiveDeltaWithCrossingZeroAndNotAllowedTest() {
		range = new Range(-3, -1);
		range2 = new Range(0, 0);
		assertEquals("After function shift() using positive delta, not allowing zero crossing but crossing zero,"
				+ "the range shifts incorrectly to a number other than the delta and/or bound(s) does not go"
				+ " to zero.",
				range2, Range.shift(range, 4, false));
	}
	
	@Test
	public void shiftWithPositiveDeltaWithoutCrossingZeroButAllowedTest() {
		range = new Range(0, 10);
		range2 = new Range(2, 12);
		assertEquals("After function shift() using positive delta, allowing zero crossing but not crossing zero,"
				+ "the range shifts incorrectly to a number other than the delta.",
				range2, Range.shift(range, 2, true));
	}
	
	@Test
	public void shiftWithNegativeDeltaWithoutCrossingZeroButAllowedTest() {
		range = new Range(-1, 0);
		range2 = new Range(-2, -1);
		assertEquals("After function shift() using negative delta, allowing zero crossing but not crossing zero,"
				+ "the range shifts incorrectly to a number other than the delta.",
				range2, Range.shift(range, -1, true));
	}
	
	@Test
	public void shiftWithNegativeDeltaWithCrossingZeroButAllowedTest() {
		range = new Range(1, 2);
		range2 = new Range(-2, -1);
		assertEquals("After function shift() using negative delta, allowing zero crossing and crossing zero,"
				+ "the range shifts incorrectly to a number other than the delta.",
				range2, Range.shift(range, -3, true));
	}
	
	@Test
	public void shiftWithPositiveDeltaWithCrossingZeroButAllowedTest() {
		range = new Range(-3, -1);
		range2 = new Range(1, 3);
		assertEquals("After function shift() using positive delta, allowing zero crossing and crossing zero,"
				+ "the range shifts incorrectly to a number other than the delta.",
				range2, Range.shift(range, 4, true));
	}

}
