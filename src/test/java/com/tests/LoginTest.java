package com.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.HomePage;
import com.pages.LandingPage;

public class LoginTest extends BaseTest{
	
	@Test(dataProvider="getLoginData")
	void login(String username, String password, boolean isDataValid) {
		
		LandingPage landingPage = new LandingPage(super.driver);
		landingPage.userName().sendKeys(username);
		log.info("Entered Username = " + username);
		landingPage.password().sendKeys(password);
		log.info("Entered password = " + password);
		landingPage.loginButton().click();
		log.info("Clicked on Login Button");
		
		if(isDataValid) {
			HomePage homePage = new HomePage(driver);
			Assert.assertTrue(homePage.menuButton().isDisplayed());
			log.info("----Login Successful---");
		} else {
			Assert.assertTrue(landingPage.lockedOutError().isDisplayed());
			log.info("----Login Unsuccessful---");
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
	

}
