package com.hrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.qa.base.TestBase;

public class HomePage extends TestBase {

	// Page Factory
	@FindBy(id = "")
	WebElement dashboardPageLink;

	// Initializing the page objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String doSomething() {
		return "";
	}

}
