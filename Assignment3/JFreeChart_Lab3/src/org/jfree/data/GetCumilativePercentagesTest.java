package org.jfree.data;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import junit.framework.Assert;

public class GetCumilativePercentagesTest{
	
	/**
	 * Test if a null parameter will result the method to fail
	 */
	@Test
	public void nullCumalativePercentageTest() {
		try {
			DataUtilities.getCumulativePercentages(null);
			fail("Cannot pass in null as a variable");
		}catch(Exception e) {
			assertTrue("Null is allowed as an argument", true);
		}
	}
	
	/**
	 * Test if a null parameter will cause the method to throw and InvalidPrameterException
	 */
	@Test
	public void nullCumilativePercentageExceptionTest() {
		try {
			DataUtilities.getCumulativePercentages(null);
			fail("Method does not throw and InvalidParameterException error");
		}catch(Exception e) {
			assertEquals("Exceptions are not equal", InvalidParameterException.class, e.getClass());
		}

	}
	
	/**
	 * Test if the correct cumulative percentage of an all positive KeyedValues is returned 
	 */
	@Test
	public void AllPositiveCumilativePercentageTest() {
		Mockery mockingContext1 = new Mockery(); 
		final KeyedValues keyvals = mockingContext1.mock(KeyedValues.class);
		mockingContext1.checking(new Expectations() { 
			{
				atLeast(1).of(keyvals).getItemCount();
				will(returnValue(3));
				
				atLeast(1).of(keyvals).getKey(0);
				will(returnValue(0));
				
				atLeast(1).of(keyvals).getValue(0);
				will(returnValue(1));
				
				atLeast(1).of(keyvals).getKey(1);
				will(returnValue(1));
				
				atLeast(1).of(keyvals).getValue(1);
				will(returnValue(2));
				
				atLeast(1).of(keyvals).getKey(2);
				will(returnValue(3));
				
				atLeast(1).of(keyvals).getValue(2);
				will(returnValue(3));
				
			} 
		});
		
		Mockery mockingContext2 = new Mockery();
		final KeyedValues result = mockingContext2.mock(KeyedValues.class);
		mockingContext2.checking(new Expectations() {
			{
				atLeast(1).of(result).getItemCount(); 
				will(returnValue(3));
			
				atLeast(1).of(result).getKey(0);
				will(returnValue(0));
				
				atLeast(1).of(result).getValue(0);
				will(returnValue(0.166));
				
				atLeast(1).of(result).getKey(1);
				will(returnValue(1));
				
				atLeast(1).of(result).getValue(1);
				will(returnValue(0.500));
				
				atLeast(1).of(result).getKey(2);
				will(returnValue(2));
				
				atLeast(1).of(result).getValue(2);
				will(returnValue(1.0));
			} 
		});
		
		assertTrue("Objects are not equal", DataUtilities.getCumulativePercentages(keyvals).equals(result));
	}
	
	
	/**
	 * Test if the correct cumulative percentage of KeyedValues with both positive and negative values is returned
	 */
	@Test
	public void MixedCumilativePercentageTest() {
		Mockery mockingContext1 = new Mockery(); 
		final KeyedValues keyvals = mockingContext1.mock(KeyedValues.class);
		mockingContext1.checking(new Expectations() { 
			{
				atLeast(1).of(keyvals).getItemCount();
				will(returnValue(3));
				
				atLeast(1).of(keyvals).getKey(0);
				will(returnValue(0));
				
				atLeast(1).of(keyvals).getValue(0);
				will(returnValue(-1));
				
				atLeast(1).of(keyvals).getKey(1);
				will(returnValue(1));
				
				atLeast(1).of(keyvals).getValue(1);
				will(returnValue(2));
				
				atLeast(1).of(keyvals).getKey(2);
				will(returnValue(3));
				
				atLeast(1).of(keyvals).getValue(2);
				will(returnValue(3));
				
			} 
		});
		
		Mockery mockingContext2 = new Mockery();
		final KeyedValues result = mockingContext2.mock(KeyedValues.class);
		mockingContext2.checking(new Expectations() {
			{
				atLeast(1).of(result).getItemCount(); 
				will(returnValue(3));
			
				atLeast(1).of(result).getKey(0);
				will(returnValue(0));
				
				atLeast(1).of(result).getValue(0);
				will(returnValue(-0.250));
				
				atLeast(1).of(result).getKey(1);
				will(returnValue(1));
				
				atLeast(1).of(result).getValue(1);
				will(returnValue(0.250));
				
				atLeast(1).of(result).getKey(2);
				will(returnValue(2));
				
				atLeast(1).of(result).getValue(2);
				will(returnValue(1.0));
			} 
		});
		
		assertTrue("Objects are not equal", DataUtilities.getCumulativePercentages(keyvals).equals(result));
	}

}
