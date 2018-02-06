package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class getLowerBoundTest{
	
	private Range exampleRange;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	@Before
	public void setUp() throws Exception {
		exampleRange = new Range(2.0, 10.0);
	}
	
	@Test
	public void test() {
		Assert.assertEquals("The lower values are not equal", 2.0, this.exampleRange.getLowerBound(),.000000001d);
	}
	
	@After
	public void tearDown() throws Exception {
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	

}
