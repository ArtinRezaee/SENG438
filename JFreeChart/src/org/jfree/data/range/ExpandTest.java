package org.jfree.data.range;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.Test;

public class ExpandTest {
	
	private Range range, range2;

	/**
	 * Tests the expand method whether a null parameter will throw
	 * an IllegalArgumentException
	 */
	@Test
	public void expandNullRangeTest() {
		try {
			Range.expand(null, 0.25, 0.50);
			fail("The expand method did not throw an IllegalArgumentException");
		}
		catch(Exception e) {
			assertEquals("The expand method did not throw an IllegalArgumentException",
					IllegalArgumentException.class, e.getClass());
		}
	}
	
	/**
	 * Tests the expand method whether it will accept a negative lower margin parameter
	 */
	@Test
	public void expandNegativeLowerMarginTest() {
		range = new Range(2, 6);
		range2 = new Range(3, 8);
		assertEquals("After expand() using a negative lower margin, the lower bound did not shift right.",
				Range.expand(range, -0.25, 0.50), range2);
	}
	
	/**
	 * Tests the expand method whether it will accept a negative upper margin parameter
	 */
	@Test
	public void expandNegativeUpperMarginTest() {
		range = new Range(2, 6);
		range2 = new Range(-1, 5.20);
		assertEquals("After expand() using a negative upper margin, the upper bound did not shift left.",
				Range.expand(range, 0.75, -0.20), range2);
	}
	
	/**
	 * Tests the expand method whether it will accept a positive lower and upper margins
	 * for its parameters
	 */
	@Test
	public void expandPositiveMarginsTest() {
		range = new Range(2, 6);
		range2 = new Range(1, 8);
		assertEquals("After expand() using a both positive margins, the upper bound did not shift right"
				+ "and the lower bound did not shift left.",
				Range.expand(range, 0.25, 0.50), range2);
	}
	
	/**
	 * Tests the expand method whether it will accept a zero value for its lower and upper margins
	 */
	@Test
	public void expandUsingZeroMarginsTest() {
		range = new Range(2, 6);
		range2 = new Range(2, 6);
		assertEquals("After expand() using 0 for both margins, range did not stay the same.",
				Range.expand(range, 0, 0), range2);
	}
	

}
