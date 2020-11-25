package com.freecrm.basetest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

import com.freecrm.base.BasePage;

public class BaseTest {

	public WebDriver driver;
	public BasePage basepage;
	
	@BeforeTest
	public void setUp() {
		
		try {
			basepage=new BasePage();
			driver=basepage.init_driver();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
