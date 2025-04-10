package com.qa.opencart.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.pages.AccountPage;
import com.qa.opencart.pages.ResultsPage;

public class AccountPageTest extends BaseTest {

	@BeforeClass
	public void loginSetup(){
		 accPage = loginPage.dologin(prop.getProperty("username"),prop.getProperty("password"));
		
		
	}
	@Test
	public void productSearchTest() {
		resultPage = accPage.performSearch("macbook");
		}
}
