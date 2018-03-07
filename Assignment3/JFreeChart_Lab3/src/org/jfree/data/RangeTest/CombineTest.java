package org.jfree.data.RangeTest;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

/**
 * Testing the combine function for Range class
 * Requires two arguments - two Ranges i.e. Range 1 and Range 2
 * Returns a new range 
 * This is a public static method 
 * @author Satyaki Ghosh
 */
public class CombineTest {

	/**
	 * Testing combine function when Range 1 is null 
	 */
	@Test
	public void Range1isNull() {
		assertEquals("The combined Ranges of [null] and [1,2] should be [1,2]", new Range(1, 2), Range.combine(null, new Range(1, 2)));
	}
	
	/**
	 * Testing combine function when Range 2 is null 
	 */
	@Test
	public void Range2isNull() {	
		assertEquals("The combined Ranges of [1,2] and [null] should be [1,2]", new Range(1, 2), Range.combine(new Range(1, 2), null));
	}
	
	/**
	 * Testing combine function when Range 1 and Range 2 are both null 
	 */
	@Test
	public void BothRangesNull() {	
		assertEquals("The combined Ranges of [null] and [null] should be [null]", null, Range.combine(null, null));
	}
	
	/**
	 * Testing combine function when Range 1 and Range 2 are continuous
	 * This functions is NOT supposed to throw errors, but it does
	 * This is a error in the JAR and not our code, please check the Range class that is provided   
	 */
	@Test
	public void RangesAreContinous() {
		try {
			assertEquals("The combined Ranges of [0,2] and [2,3] should be [0,3]", new Range(0, 3), Range.combine(new Range(0, 2), new Range(2, 3)));		
		}
		catch(Exception e) {
			fail("Method should not throw error, but completed with " + e.getClass() + e.getMessage());
		}
	}
	
	/**
	 * Testing combine function when Range 1 and Range 2 are not continuous
	 * This functions is NOT supposed to throw errors, but it does
	 * This is a error in the JAR and not our code, please check the Range class that is provided   
	 */
	@Test
	public void RangesAreNotContinous() {	
		try {
			assertEquals("The combined Ranges of [0,2] and [10,20] should be [0,20]", new Range(0, 20), Range.combine(new Range(0, 2), new Range(10, 20)));	
		}
		catch(Exception e) {
			fail("Method should not throw error, but completed with " + e.getClass() + e.getMessage());
		}
	}
}
