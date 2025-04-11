package com.qa.opencart.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

//import io.qameta.allure.Epic;
//@Epic(value = "ityit")
public class LoginPageTest extends BaseTest {
	
	
	@Test
	public void loginTest() {
		loginPage.dologin(prop.getProperty("username"),prop.getProperty("password"));
		//String x = "go";
		System.out.println("out there is");
		Assert.assertEquals("go","go","not amtched re.....");
		
	}
}
