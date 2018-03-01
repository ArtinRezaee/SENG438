package jfree.RangeTest;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Test;

public class GetLengthTest {
	
	private Range range;
	
	/**
	 * Tests the get length method whether it will return the expected value
	 * for any valid ranges
	 */
	@Test
	public void getLengthWithMoreThanOneNumberInRangetest() {
		range = new Range(0, 10);
		assertEquals("The function getLength() did not return the correct length of range.", 10, range.getLength(), .000000001d);
	}
	
	/**
	 * Tests the get length method whether it will return the expected value
	 * for ranges with the same upper and lower boundaries
	 */
	@Test
	public void getLengthWithOneNumberInRangetest() {
		range = new Range(1, 1);
		assertEquals("The function getLength() did not return zero for a range"
				+ "with the same values for the upper and lower bound.", 0, range.getLength(), .000000001d);
	}
}
