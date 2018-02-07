package org.jfree.data.range;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

public class UpperBoundTest {

	@Test
	public void TwoPositive() {
		Range testRange = new Range(5, 10);
		assertEquals("Upper bound should be 10.0", 10.0, testRange.getUpperBound(), .000000001d);
	}
	
	@Test
	public void TwoNegative() {
		Range testRange = new Range(-3, -1);
		assertEquals("Upper bound should be -1.0", -1.0, testRange.getUpperBound(), .000000001d);
	}
	
	@Test
	public void NegAndPositive() {
		Range testRange = new Range(-1, 2);
		assertEquals("Upper bound should be 2.0", 2.0, testRange.getUpperBound(), .000000001d);
	}
	
	@Test
	public void SameNumber() {
		Range testRange = new Range(1, 1);
		assertEquals("Upper bound should be 1.0", 1.0, testRange.getUpperBound(), .000000001d);
	}
	
	@Test
	public void UsingZero() {
		Range testRange = new Range(0, 10);
		assertEquals("Upper bound should be 10.0", 10.0, testRange.getUpperBound(), .000000001d);
	}

}
