package com.qa.utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.testbase.TestBase;
public class Synchronization extends TestBase {
	public static WebDriverWait wait;
	
	public static void clickOn(WebDriver driver, WebElement element, int timeOut)
	{
		wait=new WebDriverWait(driver,timeOut);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		
	}
	
	
	public static void waitForElementToBeClickable(WebDriver driver, WebElement element, int timeOut)
	{
		wait=new WebDriverWait(driver,timeOut);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		//element.click();
		
	}
	
	public static void sendData(WebDriver driver, WebElement element,String value, int timeOut)
	{
		wait=new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}

	public static void verifyText(WebDriver driver, WebElement element,String value, int timeOut)
	{
		wait=new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
}
