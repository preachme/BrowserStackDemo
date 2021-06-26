package com.org.page.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.org.utils.SeleniumDriver;

public class ScreenshotPage {

	WebDriver driver;
	
	
	@FindBy(xpath="//a[contains(text(), 'Sign in')]")
	static public By signInButton;
	
	@FindBy(xpath="//input[@id='user_password']")
	static public By emailField;
	
	@FindBy(xpath="//input[@id='user_password']")
	static public By passwordField;
	
	@FindBy(xpath="//input[@id='user_submit']")
	static public By submitButton;

    public ScreenshotPage(WebDriver driver){
    	
    	this.driver = SeleniumDriver.getDriverInstance(); 
        PageFactory.initElements(driver, this);

    }

}
