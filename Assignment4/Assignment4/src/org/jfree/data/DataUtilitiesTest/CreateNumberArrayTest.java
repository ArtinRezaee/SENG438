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

	double [] doubleArray, doubleArray2 = {3.0, 2.0, 1.0, 4.5};
	Number [] numberArray, numberArray2 = {3.0, 2.0, 1.0, 4.5};
	
	/**
	 * Tests whether the create number array method will throw an InvalidParameterException
	 *  when null is given for its parameter which is not an array of double
	 */
	@Test
	public void createNumberArrayWithNullTest() {
		try {
			numberArray = DataUtilities.createNumberArray(null);
			fail("Cannot pass null as a paramter");
		}
		catch(Exception e) {
			assertEquals("Null does not throw "
					+ "an InvalidParameterException",InvalidParameterException.class,e.getClass());
		}
	}
	
	/**
	 * Tests whether the create number array method will create a Number array 
	 * with the same values when passing in a parameter that
	 * is an array of double
	 */
	@Test 
	public void createNumberArrayWithValidDoubleArrayTest() {
		numberArray = DataUtilities.createNumberArray(doubleArray2);
		assertArrayEquals("The number array created by the function does not have the same "
				+ "numbers as the double array", numberArray2, numberArray);
	}


}
