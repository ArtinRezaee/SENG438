package org.jfree.data.DataUtilitiesTest;

import static org.junit.Assert.*;

import java.lang.IllegalArgumentException;

import org.jfree.data.DataUtilities;
import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.annotation.*;
import java.security.InvalidParameterException;

public class CreateNumberArrayTest {
	
	private DataUtilities dataUtility;
	double [] doubleArray, doubleArray2 = {3.0, 2.0, 1.0, 4.5};
	Number [] numberArray, numberArray2 = {3.0, 2.0, 1.0, 4.5};

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
	
	@Test (expected = InvalidParameterException.class)
	public void createNumberArrayWithNullTest() {
		numberArray = DataUtilities.createNumberArray(null);	
	}
	
	
	@Test 
	public void createNumberArrayWithValidDoubleArrayTest() {
		numberArray = DataUtilities.createNumberArray(doubleArray2);
		assertArrayEquals("The number array created by the function does not have the same "
				+ "numbers as the double array", numberArray2, numberArray);
	}


}
