package com.org.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.org.page.actions.FunctionLibrary;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumDriver {
	public static WebDriver driver;
	FunctionLibrary FL = new FunctionLibrary();
	public SeleniumDriver(){
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		driver = new ChromeDriver(options);
		
	}
	public static WebDriver getDriverInstance() {
		return driver;
	}
	
}
