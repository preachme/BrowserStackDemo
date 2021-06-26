package com.org.page.actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import com.org.utils.SeleniumDriver;

public class FunctionLibrary {
	
	public static void launchURL(String url){
		SeleniumDriver.getDriverInstance().get(url);
	}
	
	public static void enterText(WebElement webElement, String text){
		webElement.sendKeys(text);
	}
	
	
	public static void clickOnButton(WebElement webElement){
		
		try{
			webElement.click();
		}
		catch (Exception e) {
			
			JavascriptExecutor js = (JavascriptExecutor)SeleniumDriver.getDriverInstance();
			js.executeScript("arguments[0].click();", webElement);
		}
		
	}
	
	public static void clearText(WebElement webElement) {
		webElement.clear();
	}
}
