package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.driverFactory.DriverFactory;
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

	@BeforeTest
	public void setup() {

		System.out.println("out2 there is");
		df = new DriverFactory();
		prop = df.initProp();
		driver = df.browserName(prop);
		loginPage = new LoginPage(driver);

	}

	@AfterTest
	public void tearDown() {

		System.out.println("over there is");

	}
}
