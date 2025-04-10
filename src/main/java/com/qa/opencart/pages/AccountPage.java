package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;
import com.qa.opencart.utils.TimeUtil;

import org.openqa.selenium.WebDriver;

public class AccountPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	public AccountPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);

	}
	//1. >Locaters
	private By search = By.name("search");
	private By searchIcon = By.cssSelector("div#search button");
	private By logoutLink = By.linkText("Logout");
	private By accSecHeaders = By.cssSelector("div#content h2");
	
	public boolean isSearchExist() {
		return eleUtil.waitForElementVisible(search, TimeUtil.DEFAULT_TIME_OUT).isDisplayed();
	}
	
	public ResultsPage performSearch(String productName) {
		System.out.println("Product searched: "+ productName);
		if(isSearchExist()) {
			eleUtil.doSendKeys(search, productName);
			eleUtil.doActionsClick(searchIcon);
		}
		
		return new ResultsPage();
	
	}

	
	
}
