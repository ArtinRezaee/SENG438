package org.jfree.data.Tester;

import java.util.List;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import org.jfree.data.DataUtilitiesTest.*;
import org.jfree.data.RangeTest.*;

/**
 * Class that runs all the tests
 * can be run using the bat file called 'ExecuteThisFile.bat'
 * @author Satyaki Ghosh
 */
public class TestSuite {	
	public static void main(String[] args) {
		
		JUnitCore core = new JUnitCore();
		
		Result results = core.run(CentralValueTest.class,
				CombineTest.class,
				ConstrainTest.class,
				ContainsTest.class,
				EqualsTest.class,
				ExpandTest.class,
				ExpandToIncludeTest.class,
				GetLengthTest.class,
				HashCodeTest.class,
				IntersectsTest.class,
				LowerBoundTest.class,
				ShiftWithAllowZeroCrossingTest.class,
				ShiftWithoutZeroCrossingTest.class,
				ToStringTest.class,
				UpperBoundTest.class,
				ColumnTotalTest.class,
				CreateNumberArray2DTest.class,
				CreateNumberArrayTest.class,
				GetCumilativePercentagesTest.class,
				RowTotalTest.class);
		
		System.out.print("Total Tests: " + results.getRunCount());
		System.out.print(", Passed: " + (results.getRunCount() - results.getFailureCount()));
		System.out.println(", Failed: " + results.getFailureCount() + "\n\n");
		
		List<Failure> list = results.getFailures();
		
		for(int i = 0; i < list.size(); i++)
			System.out.println(list.get(i).toString() + "\n\n");
		
		System.out.print("Total Tests: " + results.getRunCount());
		System.out.print(", Passed: " + (results.getRunCount() - results.getFailureCount()));
		System.out.println(", Failed: " + results.getFailureCount());
//		JUnitCore.main("jfree.RangeTest.CentralValueTest", 
//				"jfree.RangeTest.CombineTest",
//				"jfree.RangeTest.ConstrainTest",
//				"jfree.RangeTest.ContainsTest",
//				"jfree.RangeTest.EqualsTest",
//				"jfree.RangeTest.ExpandTest",
//				"jfree.RangeTest.ExpandToIncludeTest",
//				"jfree.RangeTest.GetLengthTest",
//				"jfree.RangeTest.HashCodeTest",
//				"jfree.RangeTest.IntersectsTest",
//				"jfree.RangeTest.LowerBoundTest",
//				"jfree.RangeTest.ShiftWithAllowZeroCrossingTest",
//				"jfree.RangeTest.ShiftWithoutZeroCrossingTest",
//				"jfree.RangeTest.ToStringTest",
//				"jfree.RangeTest.UpperBoundTest",
//				"jfree.DataUtilitiesTest.ColumnTotalTest",
//				"jfree.DataUtilitiesTest.CreateNumberArray2DTest",
//				"jfree.DataUtilitiesTest.CreateNumberArrayTest",
//				"jfree.DataUtilitiesTest.GetCumilativePercentagesTest",
//				"jfree.DataUtilitiesTest.RowTotalTest"
//				);
		
	}
}
