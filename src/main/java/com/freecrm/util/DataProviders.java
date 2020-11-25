package com.freecrm.util;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="createContact")
	public Object[][] getContactTestData(){
		
		Object[][] data=TestUtil.getTestData("createContact");
		return data;
	}


}
