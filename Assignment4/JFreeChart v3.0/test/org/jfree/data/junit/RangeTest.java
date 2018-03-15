package org.jfree.data.junit;

import org.jfree.data.*;
import junit.framework.TestCase;

public class RangeTest extends TestCase 
{
	public void setUp()
	{
		testRange = new Range(1, 2);
	}
	
	public void tearDown()
	{
		testRange = null;
	}
	
	public void testNonIntersectLower()
	{
		assertFalse(testRange.intersects(-1, 0));
	}
	

	public void testIntersectSubsumes()
	{
		assertTrue(testRange.intersects(-1, 3));
	}
	
	public void testIntersectSubsumed()
	{
		assertTrue(testRange.intersects(1.2, 1.8));
	}


	public void testNonIntersectUpper()
	{
		assertFalse(testRange.intersects(3, 4));
	}
	
	private Range testRange;
}
