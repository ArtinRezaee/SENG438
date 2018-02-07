package org.jfree.data.range;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

public class CombineTest {

	@Test
	public void Range1isNull() {
		assertEquals("The combined Ranges of [null] and [1,2] should be [1,2]", new Range(1, 2), Range.combine(null, new Range(1, 2)));
	}
	
	@Test
	public void Range2isNull() {	
		assertEquals("The combined Ranges of [1,2] and [null] should be [1,2]", new Range(1, 2), Range.combine(new Range(1, 2), null));
	}
	
	@Test
	public void BothRangesNull() {	
		assertEquals("The combined Ranges of [null] and [null] should be [null]", null, Range.combine(null, null));
	}
	
	@Test
	public void RangesAreContinous() {	
		try {
			assertEquals("The combined Ranges of [0,2] and [2,3] should be [2,3]", new Range(0, 3), Range.combine(new Range(0, 2), new Range(2, 3)));
		}
		catch(Exception err) {
			fail("Assert failed with error: " + err.getMessage());
		}
	}
	
	@Test
	public void RangesAreNotContinous() {
		try {
			assertEquals("The combined Ranges of [0,2] and [10,20] should be [0,20]", new Range(0, 20), Range.combine(new Range(0, 2), new Range(10, 20)));	
		}
		catch(Exception err) {
			fail("Assert failed with error: " + err.getMessage());
		}
	}
}
