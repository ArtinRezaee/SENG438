package org.jfree.data.DataUtilitiesTest;

import static org.junit.Assert.*;
import org.junit.*;
import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;

public class MockTest {
	
	@Test
	public void calculateColumnTotalForTwoValues() { 
		Mockery mockingContext = new Mockery(); 
		final Values2D values = mockingContext.mock(Values2D.class);
		
		mockingContext.checking(new Expectations() { 
			{
				one(values).getRowCount(); 
				will(returnValue(3));
				
				one(values).getValue(0, 0);
				will(returnValue(8.5));
				
				one(values).getValue(1, 0); 
				will(returnValue(2.5));
				
				one(values).getValue(2, 0); 
				will(returnValue(2.5));
			} 
		});
		
		// exercise 
		double result = DataUtilities.calculateColumnTotal(values, 0);
		
		
		// verify
		assertEquals(result, 133, .000000001d);
	} 

}
