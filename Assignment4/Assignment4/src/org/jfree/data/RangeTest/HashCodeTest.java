package org.jfree.data.RangeTest;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.Test;

public class HashCodeTest {

	private Range range, range2;
	
	@Test
	public void hashCodeForOne() {
		range = new Range(0, 10);
		
		int result;
        long temp;
        temp = Double.doubleToLongBits(0);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(10);
        result = 29 * result + (int) (temp ^ (temp >>> 32));
        
		assertEquals("HashCode function returns the wrong hashcode.", result, range.hashCode());
	}
	
	/**
	 * Tests the method hashcode whether two similar ranges will produce the same hashcode
	 */
	@Test
	public void hashcodeForTwoSimilarRangesTest() {
		range = new Range(0, 10);
		range2 = new Range(0, 10);
		
		int result;
        long temp;
        temp = Double.doubleToLongBits(0);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(10);
        result = 29 * result + (int) (temp ^ (temp >>> 32));
        
		assertEquals("Hashcode for two similar ranges are must be the same.", true, range.hashCode() == result && range2.hashCode() == result);
	}
	
	/**
	 * Tests the method hashcode whether two different ranges will produce different hashcode
	 */
	@Test
	public void hashcodeForTwoDifferentRangestest() {
		range = new Range(0, 10);
		range2 = new Range(2, 11);
		
		int result1;
        long temp1;
        temp1 = Double.doubleToLongBits(0);
        result1 = (int) (temp1 ^ (temp1 >>> 32));
        temp1 = Double.doubleToLongBits(10);
        result1 = 29 * result1 + (int) (temp1 ^ (temp1 >>> 32));
        
        int result2;
        long temp2;
        temp2 = Double.doubleToLongBits(2);
        result2 = (int) (temp2 ^ (temp2 >>> 32));
        temp2 = Double.doubleToLongBits(11);
        result2 = 29 * result2 + (int) (temp2 ^ (temp2 >>> 32));
        
		assertEquals("Hashcode for two different ranges must be different.", result1 != result2, 
				range.hashCode() == result1 && range2.hashCode() == result2 && range.hashCode() != range2.hashCode());
	}

}
