package com.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Base {
	
	public WebDriver driver;
	public String URL = "https://www.saucedemo.com/";

	public void initialiseBrowser() {
		System.setProperty("webdriver.edge.driver",
				"F:\\Tools\\BrowserDrivers\\edgedriver_win64\\msedgedriver.exe");
		this.driver = new EdgeDriver();
	}
	
}
