package com.freecrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.freecrm.base.BasePage;
import com.freecrm.util.ElementUtil;

public class HomePage extends BasePage {

    ElementUtil util;
	
    By usernameText=By.xpath("//div[@id='top-header-menu']/child::div[@class='right menu']/descendant::span[text()='Hashin PK']");
    By contactsNavlink=By.xpath("//a[@class='item']/child::span[text()='Contacts']");
    
    public HomePage(WebDriver driver) {
		this.driver=driver;
		util=new ElementUtil(driver); 
	}
    
    public String verifyUserNameText() {
		util.waitForElementToBeVisible(usernameText);
		return util.getText(usernameText);
	}
	
    public String verifyPageTitle() {
		return util.getPageTitle();
	}
	public void clickContactsLink() {
		util.waitForElementToBeVisible(contactsNavlink);
		util.doClick(contactsNavlink);
	}
	
	
    

}
