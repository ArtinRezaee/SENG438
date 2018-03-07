package org.jfree.data.RangeTest;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.Test;

public class HashCodeTest {

	private Range range, range2;
	
	/**
	 * Tests the method hashcode whether two similar ranges will produce the same hashcode
	 */
	@Test
	public void hashcodeForTwoSimilarRangesTest() {
		range = new Range(0, 10);
		range2 = new Range(0, 10);
		assertEquals("Hashcode for two similar ranges are not the same.", range2.hashCode(), range.hashCode());
	}
	
	/**
	 * Tests the method hashcode whether two different ranges will produce different hashcode
	 */
	@Test
	public void hashcodeForTwoDifferentRangestest() {
		range = new Range(0, 10);
		range2 = new Range(2, 11);
		assertFalse("Hashcode for two different ranges are the same.", range.hashCode() == range2.hashCode());
	}

}
