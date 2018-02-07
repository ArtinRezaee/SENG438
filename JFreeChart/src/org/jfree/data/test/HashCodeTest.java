package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;
import org.junit.Test;

public class HashCodeTest {

	private Range range, range2;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void hashcodeForTwoSimilarRangesTest() {
		range = new Range(0, 10);
		range2 = new Range(0, 10);
		assertEquals("Hashcode for two similar ranges are not the same.", range2.hashCode(), range.hashCode());
	}
	
	@Test
	public void hashcodeForTwoDifferentRangestest() {
		range = new Range(0, 10);
		range2 = new Range(2, 11);
		assertFalse("Hashcode for two different ranges are the same.", range.hashCode() == range2.hashCode());
	}

}
