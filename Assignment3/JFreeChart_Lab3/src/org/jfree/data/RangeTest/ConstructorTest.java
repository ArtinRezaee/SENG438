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
	 * Testing function lower is greater than higher
	 */
	@Test(expected = IllegalArgumentException.class)
	public void LowerGreaterThanHigher() { 
		Range range = new Range(10.0, 5.0);
	} 
	
	/**
	 * Testing function higher is greater than lower
	 */
	@Test
	public void HigherGreaterThanLower() { 
		Range range = new Range(5.0, 10.0);
	} 
	
	/**
	 * Testing function lower and higher are equal
	 */
	@Test
	public void BoundsAreTheSame() { 
		Range range = new Range(5.0, 5.0);
	} 
}
