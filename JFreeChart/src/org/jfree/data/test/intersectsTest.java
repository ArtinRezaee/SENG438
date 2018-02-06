package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class intersectsTest{
	
	private Range exampleRange;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	@Before
	public void setUp() throws Exception {
		exampleRange = new Range(5.0, 10.0);
	}
	
	@Test
	public void LowerBoundNotCrossingTest() {
		assertFalse("The two ranges cross", this.exampleRange.intersects(1.0, 3.0));
	}
	
	@Test
	public void UpperBoundNotCrossingTest() {
		assertFalse("The two ranges cross", this.exampleRange.intersects(15.0, 20.0));
	}
	
	@Test
	public void LowerBoundCrossingTest() {
		assertTrue("The two ranges do not cross", this.exampleRange.intersects(3.0, 7.0));
	}
	
	@Test
	public void UpperBoundCrossingTest() {
		assertTrue("The two ranges do not cross", this.exampleRange.intersects(7.0, 120.0));
	}
	
	@Test
	public void AllRangeCrossingTest() {
		assertTrue("The two ranges do not cross", this.exampleRange.intersects(5.0, 10.0));
	}
	
	@Test
	public void RangeCrossingInBetweenTest() {
		assertTrue("The two ranges do not cross", this.exampleRange.intersects(8.0, 9.0));
	}
	
	@After
	public void tearDown() throws Exception {
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
}
