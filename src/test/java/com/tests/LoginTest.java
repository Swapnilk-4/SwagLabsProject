package com.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.LandingPage;

public class LoginTest {
	WebDriver driver;
	
	@Test
	void loginTest() {
		
		System.setProperty("webdriver.edge.driver",
				"F:\\Tools\\BrowserDrivers\\edgedriver_win64\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		LandingPage landingPage = new LandingPage(driver);
		
		landingPage.userName().sendKeys("standard_user");

		landingPage.password().sendKeys("secret_sauce");

		landingPage.loginButton().click();

		
		HomePage homePage = new HomePage(driver);
		try {
			Assert.assertTrue(homePage.menuButton().isDisplayed());
		} catch(Exception e) {
			Assert.fail();
		}
		
	}
	
	@AfterClass
	void tearDown() {
		driver.close();
	}

}
