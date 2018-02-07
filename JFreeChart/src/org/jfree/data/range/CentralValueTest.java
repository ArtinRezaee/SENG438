package org.jfree.data.range;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

public class CentralValueTest {

	@Test
	public void TwoPositive() {
		Range testRange = new Range(5, 10);
		assertEquals("Central value should be 7.5", 7.5, testRange.getCentralValue(), .000000001d);
	}
	
	@Test
	public void TwoNegative() {
		Range testRange = new Range(-3, -1);
		assertEquals("Central value should be -2.0", -2.0, testRange.getCentralValue(), .000000001d);
	}
	
	@Test
	public void NegAndPositive() {
		Range testRange = new Range(-1, 2);
		assertEquals("Central value should be 0.5", 0.5, testRange.getCentralValue(), .000000001d);
	}
	
	@Test
	public void SameNumber() {
		Range testRange = new Range(1, 1);
		assertEquals("Central value should be 1.0", 1.0, testRange.getCentralValue(), .000000001d);
	}
	
	@Test
	public void UsingZero() {
		Range testRange = new Range(0, 10);
		assertEquals("Central value should be 5.0", 5.0, testRange.getCentralValue(), .000000001d);
	}
}
