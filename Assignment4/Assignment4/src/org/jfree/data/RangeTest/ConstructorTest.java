package org.jfree.data.RangeTest;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jfree.data.Range;
import org.junit.*;

/**
 * Testing the constructor function for Range class
 * @author Satyaki Ghosh
 */
public class ConstructorTest {
	
	/**
	 * Testing constructor when lower bound is greater than higher bound
	 */
	@Test()
	public void LowerGreaterThanHigher() { 
		try {
			Range range = new Range(10.0, 5.0);
			fail("IllegalArgumentException not thrown.");
		}
		catch(Exception err) {
			boolean test1 = err.getClass() == IllegalArgumentException.class;
			boolean test2 = err.getMessage().equals("Range(double, double): require lower (10.0) <= upper (5.0).");
			
			if(!test1)
				fail("Incorrect Exception thrown. Expected: IllegalArgumentException, Actual: " + err.getClass());
			else if(!test2)
				fail("Incorrect Exception message. Expected: Range(double, double): require lower (10.0) <= upper (5.0), Actual: " + err.getMessage());
			else
				return;
		}
	} 
	
	/**
	 * Testing constructor when higher bound is greater than lower bound
	 */
	@Test
	public void HigherGreaterThanLower() { 
		Range range = new Range(5.0, 10.0);
	} 
	
	/**
	 * Testing constructor when higher bound lower bound are equal
	 */
	@Test
	public void BoundsAreTheSame() { 
		Range range = new Range(5.0, 5.0);
	} 
}
