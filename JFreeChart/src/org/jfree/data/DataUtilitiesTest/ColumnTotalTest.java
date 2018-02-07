package org.jfree.data.DataUtilitiesTest;

import static org.junit.Assert.*;
import org.junit.*;
import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import java.security.InvalidParameterException;

public class ColumnTotalTest {
	
	@Test(expected = InvalidParameterException.class)
	public void DataIsNull() { 
		DataUtilities.calculateColumnTotal(null, 0);		
	} 

	@Test
	public void EmptyArrayZeroCol() {
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
	
	@Test
	public void EmptyArrayNegCol() {
		Mockery mockingContext = new Mockery(); 
		final Values2D values = mockingContext.mock(Values2D.class);
		
		mockingContext.checking(new Expectations() { 
			{
				one(values).getRowCount(); 
				will(returnValue(0));
			} 
		});
		
		assertEquals(0, DataUtilities.calculateColumnTotal(values, -1), .000000001d);
	}
	
	@Test
	public void EmptyArrayPosCol() {
		Mockery mockingContext = new Mockery(); 
		final Values2D values = mockingContext.mock(Values2D.class);
		
		mockingContext.checking(new Expectations() { 
			{
				one(values).getRowCount(); 
				will(returnValue(0));
			} 
		});
		
		assertEquals(0, DataUtilities.calculateColumnTotal(values, 1), .000000001d);
	}
	
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
}
