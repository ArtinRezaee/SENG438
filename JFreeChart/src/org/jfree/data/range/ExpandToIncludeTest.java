package org.jfree.data.range;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.Range;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;

public class ExpandToIncludeTest{

	private Range exampleRange;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	@Before
	public void setUp() throws Exception {
		exampleRange = new Range(2.0, 10.0);
	}
	
	@Test
	public void ExpandToIncludeNumberLessThanLowerBoundTest() {
		assertEquals("The returned object is not equal to what was expected ", new Range(1.0,10.0), Range.expandToInclude(this.exampleRange, 1.0));
	}
	
	@Test
	public void ExpandToIncludeNumberMoreThanUpperBoundTest() {
		assertEquals("The returned object is not equal to what was expected ", new Range(2.0,100.0), Range.expandToInclude(this.exampleRange, 100.0));
	}
	
	@Test
	public void ExpandToIncludeNumberAlreadyInRangeTest() {
		assertEquals("Number is not included in this range ", this.exampleRange, Range.expandToInclude(this.exampleRange, 5.0));
	}
	
	@Test
	public void RangeIsNullTest() {
		assertEquals("Ranges are not equal", new Range(5.0,5.0), Range.expandToInclude(null, 5.0));
	}
	

}