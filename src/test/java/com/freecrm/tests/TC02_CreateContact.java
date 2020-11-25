package com.freecrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.freecrm.basetest.BaseTest;
import com.freecrm.pages.ContactPage;
import com.freecrm.pages.HomePage;
import com.freecrm.pages.LoginPage;
import com.freecrm.util.DataProviders;
import com.freecrm.util.ReadPropertyFile;
import com.freecrm.util.TestUtil;


public class TC02_CreateContact extends BaseTest{
	
	LoginPage loginpage;
	HomePage homepage;
	ContactPage contactpage;
	
	@Test(priority=1,dataProvider="createContact",dataProviderClass=DataProviders.class)
	public void verifyCreateNewContact(String fName,String lName) {
	
		loginpage=new LoginPage(driver);
		contactpage=new ContactPage(driver);
		homepage=loginpage.doLogin(ReadPropertyFile.get("username"), ReadPropertyFile.get("password"));
		homepage.clickContactsLink();
		contactpage.clickNew();
		contactpage.enterFirstName(fName);
		contactpage.enterLastName(lName);
		contactpage.clickSave();
		
	}
	
	@Test(priority=2)
	public void checkContactIsCreated() {
		homepage.clickContactsLink();
		boolean contact=contactpage.verifyContactIsCreated(TestUtil.contactName());
		Assert.assertTrue(contact);
		
		
	}


}
