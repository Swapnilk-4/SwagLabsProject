package com.base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends Base {
	
	@BeforeClass
	public void invokeBrowser() {
		super.initialiseBrowser();
		super.driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void launchWebsite() {
		super.driver.get(URL);
	}
	
	@AfterClass
	public void tearDown() {
		super.driver.close();
	}

}
