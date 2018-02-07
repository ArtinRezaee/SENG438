package org.jfree.data.test;

import static org.junit.Assert.*;

import org.junit.*;
import org.jfree.data.Range;
import org.junit.Test;

public class GetLengthTest {
	
	private Range range;

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
	public void getLengthWithMoreThanOneNumberInRangetest() {
		range = new Range(0, 10);
		assertEquals("The function getLength() did not return the correct length of range.", 10, range.getLength(), .000000001d);
	}
	
	@Test
	public void getLengthWithOneNumberInRangetest() {
		range = new Range(1, 1);
		assertEquals("The function getLength() did not return zero for a range"
				+ "with the same values for the upper and lower bound.", 0, range.getLength(), .000000001d);
	}
}
