package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	public LandingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user-name")
	WebElement usernameE;
	
	@FindBy(id="password")
	WebElement passwordE;
	
	@FindBy(id="login-button")
	WebElement loginButtonE;
	
	@FindBy(css=".login_logo")
	WebElement loginLogoE;
	
	public WebElement userName() {
		return usernameE;
	}
	
	public WebElement password() {
		return passwordE;
	}
	
	public WebElement loginButton() {
		return loginButtonE;
	}
	
	public WebElement loginLogo() {
		return loginLogoE;
	}

}
