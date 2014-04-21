package com.rationalcoding.combination.test;

import java.util.ArrayList;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rationalcoding.combination.utils.GenerateCombinations;

/**
 * Test to demonstrate combination testing
 * @author yarlagadda
 *
 */
public class CombinationTest {

	@SuppressWarnings("rawtypes")
	@DataProvider(name = "registrationcombination")
	public Object[][] generateData() {
		GenerateCombinations generateCombination = new GenerateCombinations();
		ArrayList<String> browsers = new ArrayList<String>();
		browsers.add("chrome");
		browsers.add("firefox");
		browsers.add("ie");
		ArrayList<String> userids = new ArrayList<String>();
		userids.add("test");
		userids.add("123");
		userids.add("test123");
		userids.add("test_123");
		userids.add("test.123");
		ArrayList<ArrayList> inputs = new ArrayList<ArrayList>();
		inputs.add(browsers);
		inputs.add(userids);
		Object[][] output = generateCombination.generateCombinationsForDataProvider(inputs);
		return output;
	}

	@Test(dataProvider = "registrationcombination")
	public void testUserRegistration(String browser, String userName) throws InterruptedException {
		System.out.println("Testing with userid:" + userName + " on browser " + browser);
		Thread.sleep(1000);
	}
}
