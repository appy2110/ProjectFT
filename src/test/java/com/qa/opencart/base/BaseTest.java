package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.DriverFactory.DriverFactory;
import com.qa.opencart.pages.AccountPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ResultsPage;

public class BaseTest {

	DriverFactory df;
	WebDriver driver;
	protected LoginPage loginPage;
	protected AccountPage accPage;
	protected ResultsPage resultPage;
	protected Properties prop;

	protected SoftAssert softAssert;

	@BeforeTest
	public void setup() {

		System.out.println("out there is");
		df = new DriverFactory();
		prop = df.initProp();
		driver = df.browserName(prop);
		loginPage = new LoginPage(driver);

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
		System.out.println("over there is");

	}
}
