package com.qa.opencart.DriverFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {
	// public static WebDriver driver;
	public Properties prop;
	public static String highlight;
	public OptionsManager optionsManager;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	public WebDriver browserName(Properties prop) {
		String browserName = prop.getProperty("browser").trim();
		System.out.println("Browser name is : " + browserName);

		highlight = prop.getProperty("highlight");

		optionsManager = new OptionsManager(prop);

		if (browserName.equalsIgnoreCase("chrome")) {
			// driver = new ChromeDriver();
			tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
		} else if (browserName.equalsIgnoreCase("firefox")) {
			// driver = new FirefoxDriver(optionsManager.getFirefoxOptions());
			tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
		} else if (browserName.equalsIgnoreCase("safari")) {
			// driver = new SafariDriver();
			// tlDriver.set(new SafariDriver());
		} else if (browserName.equalsIgnoreCase("edge")) {
			// driver = new EdgeDriver();
			// tlDriver.set(new EdgeDriver());
		} else {
			System.out.println("Please pas the right browser name...." + browserName);
		}

		getDriver().manage().deleteAllCookies();
		//getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url"));
		getDriver().get(prop.getProperty("url"));

		return getDriver();
	}

	// get the local thread copy of the driver
	public synchronized static WebDriver getDriver() {
		return tlDriver.get();
	}

	public Properties initProp() {
		prop = new Properties();
		FileInputStream ip = null;
		// run in cmd
		// mvn clean install -Denv ="prod" (env to run, env is command line argument)
		// mvn clean install (if not given what will be default, otherwise it will be
		// null)

		String envName = System.getProperty("env");
		if (envName == null) {
			System.out.println("Default QA will run");
			try {
				ip = new FileInputStream("./src/test/resources/config/config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {

			try {
				switch (envName.toLowerCase()) {
				case "qa":
					ip = new FileInputStream("./src/test/resources/config/config.properties");
					break;
				case "dev":
					ip = new FileInputStream("./src/test/resources/config/config.properties");
					break;
				case "uat":
					ip = new FileInputStream("./src/test/resources/config/config.properties");
					break;
				case "stage":
					ip = new FileInputStream("./src/test/resources/config/config.properties");
					break;
				case "prod":
					ip = new FileInputStream("./src/test/resources/config/config.properties");
					break;

				default:
					System.out.println("Enter correct environment name.....");
					break;
				}

				// prop.load(ip);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}

	/**
	 * take screenshot
	 */
	public static String getScreenshot() {
		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileHandler.copy(srcFile, destination);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;

	}

}
