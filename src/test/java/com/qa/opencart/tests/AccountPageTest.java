package com.qa.opencart.tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.pages.AccountPage;
import com.qa.opencart.pages.ResultsPage;
import com.qa.opencart.utils.AppConstants;
import com.qa.opencart.utils.JavaScriptUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
@Epic("Epic02")
//@Listeners(ITestNGListener.class)
public class AccountPageTest extends BaseTest {
	
	
	@Description("Account page before login test")
	
	@BeforeClass
	//@Parameters("browser")
	public void loginSetup(){
		 accPage = loginPage.dologin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@DataProvider
	public Object[][] getProductName() {
		return new Object[][] {
			{"Macbook"},
			{"iMac"},
			{"Samsung"},
			{"Arpit"},
			{"Sony"}
			
		};
	}
	
	//TDD
	
	
	@Description("search the product test")
	@Severity(SeverityLevel.CRITICAL)
	@Test(dataProvider = "getProductName", invocationCount = 5)
	public void productSearchTest(String productName) {
		resultPage = accPage.performSearch(productName);
		}
	@Test
	@Description("check account page title")
	@Severity(SeverityLevel.TRIVIAL)
	public void accPageTitleTest() {
		String accPageTitle = accPage.getAccPageTitle();
		System.out.println("Account Page Title Test" + accPageTitle);
		Assert.assertEquals(accPageTitle, AppConstants.ACCOUNTS_PAGE_TITLE);
	}
	@Test
	@Description("check account page url Contains")
	@Severity(SeverityLevel.TRIVIAL)
	public void accPageUrl() {
		String accPageUrl = accPage.getAccPageUrl();
		System.out.println("Account Page Title Test" + accPageUrl);
		Assert.assertEquals(accPageUrl, AppConstants.ACCOUNTS_PAGE_FRACTION_URL);
		
	}
}
