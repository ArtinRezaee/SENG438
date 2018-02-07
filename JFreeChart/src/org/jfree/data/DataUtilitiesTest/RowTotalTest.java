package org.jfree.data.DataUtilitiesTest;

import static org.junit.Assert.*;
import org.junit.*;
import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import java.security.InvalidParameterException;

public class RowTotalTest {

	@Test(expected = InvalidParameterException.class)
	public void DataIsNull() { 
		DataUtilities.calculateRowTotal(null, 0);		
	} 

	@Test
	public void EmptyArrayZeroCol() {
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
	
	@Test
	public void EmptyArrayNegCol() {
		Mockery mockingContext = new Mockery(); 
		final Values2D values = mockingContext.mock(Values2D.class);
		
		mockingContext.checking(new Expectations() { 
			{
				one(values).getColumnCount(); 
				will(returnValue(0));
			} 
		});
		
		assertEquals(0, DataUtilities.calculateRowTotal(values, -1), .000000001d);
	}
	
	@Test
	public void EmptyArrayPosCol() {
		Mockery mockingContext = new Mockery(); 
		final Values2D values = mockingContext.mock(Values2D.class);
		
		mockingContext.checking(new Expectations() { 
			{
				one(values).getColumnCount(); 
				will(returnValue(0));
			} 
		});
		
		assertEquals(0, DataUtilities.calculateRowTotal(values, 1), .000000001d);
	}
	
	@Test
	public void NonEmptyArrayZeroCol() {
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
	
	@Test
	public void NonEmptyArrayNegCol() {
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
	
	@Test
	public void NonEmptyArrayPosCol() {
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
}
