package org.jfree.data.range;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;
import java.security.InvalidParameterException;

public class ShiftTest1 {	
	
	@Test
	public void BaseIsNull() {
		try {
			Range.shift(null, 2);
		}
		catch(Exception err) {
			assertEquals("Shift did not throw expected error: ", InvalidParameterException.class, err.getClass());
		}
	}
	
	@Test
	public void NonCrossShiftRight() {	
		assertEquals("Non zero crossing shifting right: ", new Range(7, 12), Range.shift(new Range(5, 10), 2.0));
	}
	
	@Test
	public void NonCrossShiftLeft() {	
		assertEquals("Non zero crossing shifting left: ", new Range(3, 8), Range.shift(new Range(5, 10), -2.0));
	}
	
	@Test
	public void NonCrossShiftRightZeroLength() {	
		assertEquals("Non zero crossing shifting right with length = 1 range: ", new Range(7, 7), Range.shift(new Range(5, 5), 2.0));
	}
	
	@Test
	public void NonCrossShiftLeftZeroLength() {	
		assertEquals("Non zero crossing shifting left with length = 1 range: ", new Range(3, 3), Range.shift(new Range(5, 5), -2.0));
	}
	
	@Test
	public void NonCrossShiftRightNegPos() {	
		assertEquals("Non zero crossing shifting right with negative to positive range: ", new Range(-3, 8), Range.shift(new Range(-5, 5), 2.0));
	}
	
	@Test
	public void NonCrossShiftLeftNegPos() {	
		assertEquals("Non zero crossing shifting left with negative to positive range: ", new Range(-7, 3), Range.shift(new Range(-5, 5), -2.0));
	}
	
	@Test
	public void OneZeroCrossShiftRight() {	
		assertEquals("Upper bound zero crossing shifting right: ", new Range(-5, 0), Range.shift(new Range(-20, -10), 15));
	}
	
	@Test
	public void OneZeroCrossShiftLeft() {	
		assertEquals("Lower bound zero crossing shifting left: ", new Range(0, 5), Range.shift(new Range(10, 20), -15));
	}
	
	@Test
	public void TwoZeroCrossShiftRight() {	
		assertEquals("Both bounds zero crossing shifting right: ", new Range(0, 0), Range.shift(new Range(-20, -10), 50));
	}
	
	@Test
	public void TwoZeroCrossShiftLeft() {	
		assertEquals("Both bounds zero crossing shifting left: ", new Range(0, 0), Range.shift(new Range(10, 20), -50));
	}

}