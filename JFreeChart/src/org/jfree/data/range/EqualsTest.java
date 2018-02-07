package org.jfree.data.range;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

public class EqualsTest {
	private Range testRange;
	
	@Before
	public void setUp() throws Exception {
		testRange = new Range(50, 100);
	}

	@Test
	public void NotRangeObject() {
		String line = "asdasdas";
		assertEquals("Testing non Range object with Ranget object", false, testRange.equals(line));
	}
		
	@Test
	public void DiffRangeObject() {
		Range test2 = new Range(10, 20);
		assertEquals("Testing two different Range objects", false, testRange.equals(test2));
	}
	
	@Test
	public void SameRangeObject() {
		assertEquals("Testing Range object with itself", true, testRange.equals(testRange));
	}
	
	@Test
	public void DiffLowerBound() {
		assertEquals("Testing two Range objects with same upper bound but different lower bound", false, testRange.equals(new Range(60, 100)));
	}
	
	@Test
	public void DiffUpperBound() {
		assertEquals("Testing two Range objects with same lower bound but different upper bound", false, testRange.equals(new Range(50, 90)));
	}

}
