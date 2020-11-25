package com.freecrm.tests;

import org.testng.annotations.Test;

import com.freecrm.basetest.BaseTest;
import com.freecrm.pages.LoginPage;
import com.freecrm.util.ReadPropertyFile;

public class TC01_LoginTest extends BaseTest {
	
	LoginPage loginpage;
	
	@Test
	public void verifyLogin() { 
		
		loginpage=new LoginPage(driver); 
		loginpage.doLogin(ReadPropertyFile.get("username"), ReadPropertyFile.get("password"));
	}
	
	

}
