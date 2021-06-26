package com.org.page.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.org.utils.SeleniumDriver;

public class HomePage {

	WebDriver driver;
	
	
	@FindBy(xpath="//input[@id='screenshots']")
	static public By urlTextField;
	
	@FindBy(xpath="//a[@id='btnSnapshot-screenshots']")
	static public By generateButton;
	
	@FindBy(xpath="//span[@id='spClear']//img")
	static public By removeSelectionsElement;

    public HomePage(WebDriver driver){
    	
    	this.driver = SeleniumDriver.getDriverInstance(); 
        PageFactory.initElements(driver, this);

    }

}
