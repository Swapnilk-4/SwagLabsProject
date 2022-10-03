package com.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends Base {
	public static Logger log = LogManager.getLogger(BaseTest.class.getName());
	@BeforeClass
	public void invokeBrowser() {
		super.initialiseBrowser();
		log.info("Browser Launched.");
		super.driver.manage().window().maximize();
		log.info("Browser Maximized.");
	}
	
	@BeforeMethod
	public void launchWebsite() {
		super.driver.get(super.URL);
		log.info("Navigated to " + super.URL);
	}
	
	@AfterClass
	public void tearDown() {
		super.driver.close();
		log.info("Browser Closed.");
	}

}
