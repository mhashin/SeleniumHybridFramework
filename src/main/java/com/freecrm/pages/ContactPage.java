package com.freecrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.freecrm.base.BasePage;
import com.freecrm.util.ElementUtil;
import com.freecrm.util.TestUtil;


public class ContactPage extends BasePage {
	
    ElementUtil util;
    TestUtil tUtil;
	
	By btn_createContactNew=By.xpath("//a[@href='/contacts/new']");
	By txt_firstName=By.name("first_name");
	By txt_last_Name=By.name("last_name");
	By btn_save=By.xpath("//button[text()='Save']");
    By chkbox_contact=By.xpath("//td[text()='Test user01']/ancestor::tr/descendant::div[@class='ui fitted read-only checkbox']");
	By contactName=By.xpath("//td[contains(text(),'Test Userten')]//ancestor::table[contains(@class,'custom-grid table')]");
	

	public ContactPage(WebDriver driver)  {
		this.driver=driver;
		util=new ElementUtil(driver);
		tUtil=new TestUtil();
	}
	
	
	
	public void clickNew() {
		util.waitForElementToBeVisible(btn_createContactNew);
		util.doClick(btn_createContactNew);
		tUtil.log.info("click on create contact button");
	}
	
	public void enterFirstName(String fName) {
		util.waitForElementToBeVisible(txt_firstName);
		util.doSendKeys(txt_firstName, fName);
		tUtil.log.info("Enter the first name ::"+fName);
	}
	
	
	public void enterLastName(String lName) {
		util.doSendKeys(txt_last_Name, lName);
		tUtil.log.info("Enter the last name ::"+lName);
	}
	
	public void clickSave() {
		util.doClick(btn_save);
		tUtil.log.info("click on Save");
	}
	
	public void checkbox() {
		util.waitForElementToBeVisible(chkbox_contact);
		util.doClick(chkbox_contact);
	}
	
	public boolean verifyContactIsCreated(String contact) {
		util.waitForElementToBeVisible(btn_createContactNew);
		return driver.findElement(By.xpath("//td[contains(text(),'"+contact+"')]//ancestor::table[contains(@class,'custom-grid table')]")).isDisplayed();
		
	}

}
