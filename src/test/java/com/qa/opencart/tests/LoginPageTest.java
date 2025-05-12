package com.qa.opencart.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.utils.AppConstants;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

//import io.qameta.allure.Epic;
//@Epic(value = "ityit")
public class LoginPageTest extends BaseTest {
	
	@Severity(SeverityLevel.BLOCKER)
	//@Listeners
	@Test
	public void loginTest() {
		loginPage.dologin(prop.getProperty("username"),prop.getProperty("password"));
		//String x = "go";
		System.out.println("out there is");
		Assert.assertEquals("go","go","not amtched re.....");
		
	}
	@Test
	public void isforgottenPassworkLinkExist() {
		assertTrue(loginPage.forgetPassowrdLinkDisplayed(), "no its not existing");
	}
	
	@Test
	public void loginPageTitleTest() {
		assertEquals(AppConstants.LOGIN_PAGE_TITLE,loginPage.getTitle(), "no its not matching");
	}
}
