package org.jfree.data.range;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

/**
 * Testing the equals function for Range class
 * Requires an existing Range object and another Range object to be used as an argument
 * Returns a boolean
 * This is a public method
 * @author Satyaki Ghosh
 */
public class EqualsTest {
	private Range testRange;
	
	/**
	 * create a range object with range 50 to 100
	 */
	@Before
	public void setUp() throws Exception {
		testRange = new Range(50, 100);
	}
	
	/**
	 * testing if a non Range object is equal to a Range object
	 */
	@Test
	public void NotRangeObject() {
		assertEquals("Testing non Range object with Ranget object", false, testRange.equals("asdasdas"));
	}
	
	/**
	 * testing if two different Range objects with different ranges are equal
	 */
	@Test
	public void DiffRangeObject1() {
		assertEquals("Testing two different Range objects", false, testRange.equals(new Range(10, 20)));
	}
	
	/**
	 * testing if two different Range objects with the same ranges are equal
	 */
	@Test
	public void DiffRangeObject2() {
		assertEquals("Testing two different Range objects", true, testRange.equals(new Range(50, 100)));
	}
	
	/**
	 * testing if the same range object is equal to itself
	 */
	@Test
	public void SameRangeObject() {
		assertEquals("Testing Range object with itself", true, testRange.equals(testRange));
	}
	
	/**
	 * testing if two range objects with the same upper bound but different lower bound are equal
	 */
	@Test
	public void DiffLowerBound() {
		assertEquals("Testing two Range objects with same upper bound but different lower bound", false, testRange.equals(new Range(60, 100)));
	}
	
	/**
	 * testing if two range objects with the same lower bound but different upper bound are equal
	 */
	@Test
	public void DiffUpperBound() {
		assertEquals("Testing two Range objects with same lower bound but different upper bound", false, testRange.equals(new Range(50, 90)));
	}

}
