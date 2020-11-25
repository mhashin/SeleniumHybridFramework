package com.freecrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.freecrm.base.BasePage;
import com.freecrm.util.ElementUtil;


public class LoginPage extends BasePage {
	
	ElementUtil util;
	
	By userName=By.name("email");
	By password=By.name("password");
	By login=By.xpath("//div[text()='Login']");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		util=new ElementUtil(driver);
	}
	
	public void enterUserName(String user) {
		util.doSendKeys(userName,user );
	}
	
	public void enterPassword(String pwd) {
		util.doSendKeys(password, pwd);
	}
	
	public void clickLogin() {
		util.doClick(login);
	}
	
	public HomePage doLogin(String user,String pwd) {
		
		enterUserName(user);
		enterPassword(pwd);
		clickLogin();
		return new HomePage(driver);
	}

}
