package com.hrm.qa.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrm.qa.base.TestBase;

public class LoginPageTest extends TestBase {

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	void openingBrowser() {
		intialization();
		System.out.println("Before method");
	}

	@Test
	void firstTest() {
		System.out.println("First test case");
	}

	@Test
	void secondTest() {
		System.out.println("Second test case");
	}

	@AfterMethod
	void tearDown() {
		closingBrowser();
	}
}
