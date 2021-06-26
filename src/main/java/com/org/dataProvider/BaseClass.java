package com.org.dataProvider;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.org.utils.SeleniumDriver;

public class BaseClass {
	
	public BaseClass(){
		
		WebDriverWait explicitWit = new WebDriverWait(SeleniumDriver.getDriverInstance(), 10);
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(SeleniumDriver.getDriverInstance())
				.withTimeout(Duration.ofMillis(15))
				.pollingEvery(Duration.ofMillis(1))
				.ignoring(Exception.class);
		
	}

}
