package org.jfree.data.DataUtilitiesTest;

import static org.junit.Assert.*;
import org.junit.*;
import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import java.security.InvalidParameterException;

/**
 * Testing the calculateColumnTest function for DataUtilities class
 * Requires two arguments - data: Values2D and column: integer
 * Returns the total for that column
 * This is a public static method 
 * @author Satyaki Ghosh
 */
public class ColumnTotalTest {
	
	/**
	 * Testing function when the data is null
	 */
	@Test
	public void DataIsNull() { 
		try {
			DataUtilities.calculateColumnTotal(null, 0);		
			fail("When Values2D is null, method should throw exception.");
		}
		catch(Exception err) {
			assertEquals("Wrong Exception type is thrown", NullPointerException.class, err.getClass());
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
				one(values).getRowCount(); 
				will(returnValue(0));
			} 
		});
		
		assertEquals(0, DataUtilities.calculateColumnTotal(values, 0), .000000001d);
	}
	
		
	/**
	 * Testing function when data is valid and column is zero
	 */
	@Test
	public void NonEmptyArrayZeroCol() {
		Mockery mockingContext = new Mockery(); 
		final Values2D values = mockingContext.mock(Values2D.class);
		
		mockingContext.checking(new Expectations() { 
			{
				one(values).getRowCount(); 
				will(returnValue(3));
				
				one(values).getValue(0, 0);
				will(returnValue(1.0));
				
				one(values).getValue(1, 0); 
				will(returnValue(2.0));
				
				one(values).getValue(2, 0); 
				will(returnValue(3.0));				
			} 
		});
		
		assertEquals(6.0, DataUtilities.calculateColumnTotal(values, 0), .000000001d);
	}
	
	/**
	 * Testing function when data is valid and column is negative
	 */
	@Test
	public void NonEmptyArrayNegCol() {
		Mockery mockingContext = new Mockery(); 
		final Values2D values = mockingContext.mock(Values2D.class);
		
		mockingContext.checking(new Expectations() { 
			{
				mockingContext.checking(new Expectations() { 
					{
						one(values).getRowCount(); 
						will(returnValue(3));
						
						one(values).getValue(0, -1);
						will(returnValue(null));
						
						one(values).getValue(1, -1); 
						will(returnValue(null));
						
						one(values).getValue(2, -1); 
						will(returnValue(null));

					} 
				});
			} 
		});
		
		assertEquals(0.0, DataUtilities.calculateColumnTotal(values, -1), .000000001d);
	}
	
	/**
	 * Testing function when data is valid and column is positive
	 */
	@Test
	public void NonEmptyArrayPosCol() {
		Mockery mockingContext = new Mockery(); 
		final Values2D values = mockingContext.mock(Values2D.class);
		
		mockingContext.checking(new Expectations() { 
			{
				mockingContext.checking(new Expectations() { 
					{
						one(values).getRowCount(); 
						will(returnValue(3));
						
						one(values).getValue(0, 1);
						will(returnValue(1.0));
						
						one(values).getValue(1, 1); 
						will(returnValue(2.0));
						
						one(values).getValue(2, 1); 
						will(returnValue(3.0));
					} 
				});
			} 
		});
		
		assertEquals(6.0, DataUtilities.calculateColumnTotal(values, 1), .000000001d);
	}
	
	/**
	 * Testing function when data is valid and column is out of bounds
	 */
	@Test
	public void IndexOutOfBounds() {
		Mockery mockingContext = new Mockery(); 
		final Values2D values = mockingContext.mock(Values2D.class);
		
		mockingContext.checking(new Expectations() { 
			{
				mockingContext.checking(new Expectations() { 
					{
						one(values).getRowCount(); 
						will(returnValue(2));
						
						one(values).getValue(0, 2);
						will(returnValue(null));
						
						one(values).getValue(1, 2); 
						will(returnValue(null));
						
					} 
				});
			} 
		});
				
		assertEquals(0.0, DataUtilities.calculateColumnTotal(values, 2), .000000001d);
	}
}
