package jfree.RangeTest;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;
import java.security.InvalidParameterException;

/**
 * Testing the shift(no zero crossing) function for Range class
 * Requires two arguments - Base: Range and Delta: the amount to shift by
 * Returns a new range 
 * This is a public static method 
 * @author Satyaki Ghosh
 */
public class ShiftWithoutZeroCrossingTest {	
	
	/**
	 * testing shift when the base is null
	 * should throw an error
	 */
	@Test
	public void BaseIsNull() {
		try {
			Range.shift(null, 2);
			fail("When the base is null, shift should return exception.");
		}
		catch(Exception e) {
			assertEquals("Exception thrown should be: ", InvalidParameterException.class, e.getClass());
		}
	}
	
	/**
	 * testing shift delta is positive but doesn't result in crossing zero
	 */
	@Test
	public void NonCrossShiftRight() {	
		assertEquals("Non zero crossing shifting right: ", new Range(7, 12), Range.shift(new Range(5, 10), 2.0));
	}
	
	/**
	 * testing shift when delta is negative but doesn't result in crossing zero
	 */
	@Test
	public void NonCrossShiftLeft() {	
		assertEquals("Non zero crossing shifting left: ", new Range(3, 8), Range.shift(new Range(5, 10), -2.0));
	}
	
	/**
	 * testing shift when delta is positive and the range length is zero
	 */
	@Test
	public void NonCrossShiftRightZeroLength() {	
		assertEquals("Non zero crossing shifting right with length = 1 range: ", new Range(7, 7), Range.shift(new Range(5, 5), 2.0));
	}
	
	/**
	 * testing shift when delta is negative and the range length is zero
	 */
	@Test
	public void NonCrossShiftLeftZeroLength() {	
		assertEquals("Non zero crossing shifting left with length = 1 range: ", new Range(3, 3), Range.shift(new Range(5, 5), -2.0));
	}
	
	/**
	 * testing shift when delta is positive and the range bounds are from negative to positive
	 */
	@Test
	public void NonCrossShiftRightNegPos() {	
		assertEquals("Non zero crossing shifting right with negative to positive range: ", new Range(-3, 7), Range.shift(new Range(-5, 5), 2.0));
	}
	
	/**
	 * testing shift when delta is negative and the range bounds are from negative to positive
	 */
	@Test
	public void NonCrossShiftLeftNegPos() {	
		assertEquals("Non zero crossing shifting left with negative to positive range: ", new Range(-7, 3), Range.shift(new Range(-5, 5), -2.0));
	}
	
	/**
	 * testing shift when delta is positive and it results in the upper bound having to cross zero
	 */
	@Test
	public void OneZeroCrossShiftRight() {	
		assertEquals("Upper bound zero crossing shifting right: ", new Range(-5, 0), Range.shift(new Range(-20, -10), 15));
	}
	
	/**
	 * testing shift when delta is negative and it results in the lower bound having to cross zero
	 */
	@Test
	public void OneZeroCrossShiftLeft() {	
		assertEquals("Lower bound zero crossing shifting left: ", new Range(0, 5), Range.shift(new Range(10, 20), -15));
	}
	
	/**
	 * testing shift when delta is positive and it results in both the bounds having to cross zero
	 */
	@Test
	public void TwoZeroCrossShiftRight() {	
		assertEquals("Both bounds zero crossing shifting right: ", new Range(0, 0), Range.shift(new Range(-20, -10), 50));
	}
	
	/**
	 * testing shift when delta is negative and it results in both the bounds having to cross zero
	 */
	@Test
	public void TwoZeroCrossShiftLeft() {	
		assertEquals("Both bounds zero crossing shifting left: ", new Range(0, 0), Range.shift(new Range(10, 20), -50));
	}

}
