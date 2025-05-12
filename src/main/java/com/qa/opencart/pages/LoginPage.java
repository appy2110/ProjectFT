
package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.log4j.*;
import org.apache.log4j.PropertyConfigurator;

import com.aventstack.extentreports.model.Log;
import com.qa.opencart.utils.AppConstants;
import com.qa.opencart.utils.ElementUtil;
import com.qa.opencart.utils.TimeUtil;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	// 1. private By locators:
	
	//page factory
//	@FindBy(id="input-email")
//	private By emailId;
	
	
	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By forgotPwdLink = By.linkText("Forgotten Password");
	private By registerLink = By.linkText("Register");
	//log.info("jjjhgj");
	//private static Logger logger = LogManager.getLogger(LoginPage.class);
	
	
	

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		PageFactory.initElements(driver, this);

	}
	@Step("login with username : and password: ")
	public AccountPage dologin(String un, String pw) {

		System.out.println("login huakya?");
		eleUtil.waitForElementVisible(emailId, TimeUtil.DEFAULT_TIME_OUT).sendKeys(un);
		eleUtil.doSendKeys(password, pw);
		eleUtil.doClick(loginBtn);
		System.out.println("yes bro");
		

		return new AccountPage(driver);
	}
	@Step("lverifying login page title")
	public String getTitle() {
		return eleUtil.waitForTitleIs(AppConstants.LOGIN_PAGE_TITLE,10);
	}
	@Step("Verifying Forgot Password Link")
	public boolean forgetPassowrdLinkDisplayed(){
		return eleUtil.doIsDisplayed(forgotPwdLink);
	}

}
