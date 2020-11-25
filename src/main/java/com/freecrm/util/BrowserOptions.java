package com.freecrm.util;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserOptions {
	
	public ChromeOptions co;
	public FirefoxOptions ff;
	
	

	public ChromeOptions getChromeOptions(){
		co = new ChromeOptions();
		if(Boolean.parseBoolean(ReadPropertyFile.get("headless"))) co.addArguments("--headless");
		if(Boolean.parseBoolean(ReadPropertyFile.get("incognito"))) co.addArguments("--incognito");
		return co;
	}
	
	public FirefoxOptions getFFOptions() {
		
		ff=new FirefoxOptions();
		return ff;
	}
	

}
