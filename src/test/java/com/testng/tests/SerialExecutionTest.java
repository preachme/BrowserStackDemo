package com.testng.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.org.dataProvider.ConfigReader;
import com.org.page.actions.FunctionLibrary;
import com.org.page.locators.HomePage;
import com.org.page.locators.ScreenshotPage;
import com.org.utils.SeleniumDriver;

public class SerialExecutionTest {
	
	WebDriver driver;
	SeleniumDriver sd = new SeleniumDriver();
	ConfigReader configReader = new ConfigReader();
	ScreenshotPage screenshotPage = new ScreenshotPage(SeleniumDriver.getDriverInstance());
	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	@BeforeTest
	public void setUp(){
	
		if(configReader.getWindowMaximize().equalsIgnoreCase("true")){
			SeleniumDriver.getDriverInstance().manage().window().maximize();
		}
	}
	 
	
	@Test(priority=1)
	public void ScreenshotVerificationTest() throws Exception{
		
		//SignInPage
		FunctionLibrary.launchURL(configReader.getValue("baseurl"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ScreenshotPage.emailField));
		FunctionLibrary.enterText(driver.findElement(ScreenshotPage.emailField), configReader.getValue("username"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ScreenshotPage.passwordField));
		FunctionLibrary.enterText(driver.findElement(ScreenshotPage.passwordField), configReader.getValue("password"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ScreenshotPage.signInButton));
		FunctionLibrary.clickOnButton(driver.findElement(ScreenshotPage.signInButton));
		
		//Now on HomePage
		wait.until(ExpectedConditions.visibilityOfElementLocated(HomePage.urlTextField));
		FunctionLibrary.enterText(driver.findElement(HomePage.urlTextField), configReader.getValue("testurl"));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(HomePage.removeSelectionsElement));   //click on cross button
		FunctionLibrary.clickOnButton(driver.findElement(HomePage.removeSelectionsElement));
		wait.until(ExpectedConditions.visibilityOfElementLocated(HomePage.generateButton));
		FunctionLibrary.clickOnButton(driver.findElement(HomePage.generateButton));
		
	}
    
    
    
    @AfterTest
    public void close(){
    	
    	SeleniumDriver.getDriverInstance().close();
    }
}