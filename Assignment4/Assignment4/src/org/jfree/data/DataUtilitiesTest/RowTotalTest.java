package org.jfree.data.DataUtilitiesTest;

import static org.junit.Assert.*;
import org.junit.*;
import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import java.security.InvalidParameterException;

/**
 * Testing the calculateRowTotal function for DataUtilities class
 * Requires two arguments - data: Values2D and row: integer
 * Returns the total for that row
 * This is a public static method 
 * @author Satyaki Ghosh
 */
public class RowTotalTest {

	/**
	 * Testing function when the data is null
	 */
	@Test
	public void DataIsNull() { 
		try {
			DataUtilities.calculateRowTotal(null, 0);		
			fail("When Values2D is null, method should throw exception.");
		}
		catch(Exception err) {
			assertNotEquals("Wrong type of exception is thrown", InvalidParameterException.class, err.getClass());
		}
	}

	/**
	 * Testing function when data is an empty array
	 */
	@Test
	public void EmptyArray() {
		Mockery mockingContext = new Mockery(); 
		final Values2D values = mockingContext.mock(Values2D.class);
		
		mockingContext.checking(new Expectations() { 
			{
				one(values).getColumnCount(); 
				will(returnValue(0));
			} 
		});
		
		assertEquals(0, DataUtilities.calculateRowTotal(values, 0), .000000001d);
	}
	
	/**
	 * Testing function when data is valid and row is zero
	 */
	@Test
	public void NonEmptyArrayZeroRow() {
		Mockery mockingContext = new Mockery(); 
		final Values2D values = mockingContext.mock(Values2D.class);
		
		mockingContext.checking(new Expectations() { 
			{
				one(values).getColumnCount(); 
				will(returnValue(3));
				
				one(values).getValue(0, 0);
				will(returnValue(1.0));
				
				one(values).getValue(0, 1); 
				will(returnValue(2.0));
				
				one(values).getValue(0, 2); 
				will(returnValue(3.0));

			} 
		});
		
		assertEquals(6.0, DataUtilities.calculateRowTotal(values, 0), .000000001d);
	}
	
	/**
	 * Testing function when data is valid and row is negative
	 */
	@Test
	public void NonEmptyArrayNegRow() {
		Mockery mockingContext = new Mockery(); 
		final Values2D values = mockingContext.mock(Values2D.class);
		
		mockingContext.checking(new Expectations() { 
			{
				mockingContext.checking(new Expectations() { 
					{
						one(values).getColumnCount(); 
						will(returnValue(3));
						
						one(values).getValue(-1, 0);
						will(returnValue(null));
						
						one(values).getValue(-1, 1); 
						will(returnValue(null));
						
						one(values).getValue(-1, 2); 
						will(returnValue(null));

					} 
				});
			} 
		});
		
		assertEquals(0.0, DataUtilities.calculateRowTotal(values, -1), .000000001d);
	}
	
	/**
	 * Testing function when data is valid and row is positive
	 */
	@Test
	public void NonEmptyArrayPosRow() {
		Mockery mockingContext = new Mockery(); 
		final Values2D values = mockingContext.mock(Values2D.class);
		
		mockingContext.checking(new Expectations() { 
			{
				mockingContext.checking(new Expectations() { 
					{
						one(values).getColumnCount(); 
						will(returnValue(3));
						
						one(values).getValue(1, 0);
						will(returnValue(1.0));
						
						one(values).getValue(1, 1); 
						will(returnValue(2.0));
						
						one(values).getValue(1, 2); 
						will(returnValue(3.0));
					} 
				});
			} 
		});
		
		assertEquals(6.0, DataUtilities.calculateRowTotal(values, 1), .000000001d);
	}
	
	/**
	 * Testing function when data is valid and row is out of bounds
	 */
	@Test
	public void IndexOutOfBounds() {
		Mockery mockingContext = new Mockery(); 
		final Values2D values = mockingContext.mock(Values2D.class);
		
		mockingContext.checking(new Expectations() { 
			{
				mockingContext.checking(new Expectations() { 
					{
						one(values).getColumnCount(); 
						will(returnValue(2));
						
						one(values).getValue(2, 0);
						will(returnValue(null));
						
						one(values).getValue(2, 1); 
						will(returnValue(null));						
					} 
				});
			} 
		});
				
		assertEquals(0.0, DataUtilities.calculateRowTotal(values, 2), .000000001d);
	}
}
