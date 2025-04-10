package com.qa.opencart.pages;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.AppConstants;
import com.qa.opencart.utils.ElementUtil;
import com.qa.opencart.utils.TimeUtil;

public class LoginPage{

	private WebDriver driver;
	private ElementUtil eleUtil;
	// 1. private By locators:
		private By emailId = By.id("input-email");
		private By password = By.id("input-password");
		private By loginBtn = By.xpath("//input[@value='Login']");
		private By forgotPwdLink = By.linkText("Forgotten Password");
		private By registerLink = By.linkText("Register");

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		
		
	}

	public AccountPage dologin(String un,String pw) {
		
		System.out.println("login huakya?");
		eleUtil.waitForElementVisible(emailId,TimeUtil.DEFAULT_TIME_OUT).sendKeys(un);;
		eleUtil.doSendKeys(password,pw);
		eleUtil.doClick(loginBtn);
		System.out.println("yes bro");
		
		return new AccountPage(driver);
		
		
		
		

	}
	
}
