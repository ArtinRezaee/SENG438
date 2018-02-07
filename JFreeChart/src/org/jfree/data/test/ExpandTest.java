package org.jfree.data.test;

import static org.junit.Assert.*;
import java.security.InvalidParameterException;
import org.jfree.data.Range;
import org.junit.*;
import org.junit.Test;

public class ExpandTest {
	
	private Range range, range2;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}


	@Before
	public void setUp() throws Exception {
	}



	@Test(expected = IllegalArgumentException.class)
	public void expandNullRangeTest() {
		range = null;
		Range.expand(null, 0.25, 0.50);
	}
	
	@Test
	public void expandNegativeLowerMarginTest() {
		range = new Range(2, 6);
		range2 = new Range(3, 8);
		assertEquals("After expand() using a negative lower margin, the lower bound did not shift right.",
				Range.expand(range, -0.25, 0.50), range2);
	}
	
	@Test
	public void expandNegativeUpperMarginTest() {
		range = new Range(2, 6);
		range2 = new Range(1, 4);
		assertEquals("After expand() using a negative upper margin, the upper bound did not shift left.",
				Range.expand(range, 0.75, -0.20), range2);
	}
	
	@Test
	public void expandPositiveMarginsTest() {
		range = new Range(2, 6);
		range2 = new Range(1, 8);
		assertEquals("After expand() using a both positive margins, the upper bound did not shift right"
				+ "and the lower bound did not shift left.",
				Range.expand(range, 0.25, 0.50), range2);
	}
	
	@Test
	public void expandUsingZeroMarginsTest() {
		range = new Range(2, 6);
		range2 = new Range(2, 6);
		assertEquals("After expand() using 0 for both margins, range did not stay the same.",
				Range.expand(range, 0, 0), range2);
	}
	
	@After
	public void tearDown() throws Exception {
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	

}
