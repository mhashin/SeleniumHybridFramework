package com.freecrm.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.freecrm.util.BrowserOptions;
import com.freecrm.util.ReadPropertyFile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	public WebDriver driver;
	public BrowserOptions browserOptions;
	
	public static ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();
	
	public WebDriver init_driver() {

		if (ReadPropertyFile.get("RunMode").equalsIgnoreCase("local")) {
			startBrowserForLocal();
			System.out.println(ReadPropertyFile.get("RunMode"));
		} else {
			System.out.println("Please set up the run mode properly in TestRunDetails.properties");
		}
		
		getDriver().manage().window().maximize();
		getDriver().get(ReadPropertyFile.get("url"));
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		return getDriver();
	}
	
	public void startBrowserForLocal() {

		String browserName = ReadPropertyFile.get("Browser");
		System.out.println("browser name is : " + browserName);
		try {
			browserOptions = new BrowserOptions();
			if (browserName.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				dr.set(new ChromeDriver(browserOptions.getChromeOptions()));
			} else if (browserName.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				dr.set(new FirefoxDriver(browserOptions.getFFOptions()));
			} else {
				System.out.println(browserName + "is not found, please pass the correct browser....");
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static synchronized WebDriver getDriver() {
		return dr.get();
	}

	
	
}

