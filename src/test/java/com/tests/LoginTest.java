package com.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.LandingPage;

public class LoginTest {
	WebDriver driver;
	
	@Test(dataProvider="getLoginData")
	void login(String username, String password, boolean isDataValid) {
		
		System.setProperty("webdriver.edge.driver",
				"F:\\Tools\\BrowserDrivers\\edgedriver_win64\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		LandingPage landingPage = new LandingPage(driver);
		
		landingPage.userName().sendKeys(username);

		landingPage.password().sendKeys(password);

		landingPage.loginButton().click();
		
		if(isDataValid) {
			HomePage homePage = new HomePage(driver);
			Assert.assertTrue(homePage.menuButton().isDisplayed());
		} else {
			Assert.assertTrue(landingPage.lockedOutError().isDisplayed());
		}
	}
	
	@DataProvider
	Object[][] getLoginData() {
		Object[][] data = {
				{"standard_user","secret_sauce", true},
				{"locked_out_user","secret_sauce", false},
				{"problem_user","secret_sauce", true},
				{"performance_glitch_user","secret_sauce", true}
		};
		return data;
	}
	
	@AfterMethod
	void tearDown() {
		driver.close();
	}

}
