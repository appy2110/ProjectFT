package com.qa.opencart.driverFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
public WebDriver driver;
public Properties prop;
public static String highlight;

public WebDriver browserName(Properties prop) {
	String browser = prop.getProperty("browser").trim();
	if(browser.equalsIgnoreCase("chrome")) {
		driver = new ChromeDriver();
	}
	else if(browser.equalsIgnoreCase("firefox")) {
		driver = new ChromeDriver();
	}
	else if(browser.equalsIgnoreCase("safari")) {
		driver = new ChromeDriver();
	}
	else {
		System.out.println("Enter Correct browser name");
	}
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.get(prop.getProperty("url"));
	highlight = prop.getProperty("highlight");
	return driver;
}

public Properties initProp() {
	prop = new Properties();
	try {
		FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
		prop.load(ip);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return prop;
}

}
