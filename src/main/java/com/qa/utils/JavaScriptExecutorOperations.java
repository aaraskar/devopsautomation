package com.qa.utils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.testbase.TestBase;

public class JavaScriptExecutorOperations extends TestBase {
	public static WebDriverWait wait;
	public static JavascriptExecutor js;
	
	
	public static void clickElementByJS(WebElement element,int timeOut)
	{	
		wait=new WebDriverWait(driver,timeOut);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();", element);
		
	}
	public static void refreshBrowserByJS()
	{
		
		js=((JavascriptExecutor)driver);
		js.executeScript("history.go(0)");
	}

	public static String getTitleByJS()
	{
		js=((JavascriptExecutor)driver);
		String title=js.executeScript("return document.title;").toString();
		return title;
	}
	
	public static String getPageTextByJS()
	{
		js=((JavascriptExecutor)driver);
		String pageText=js.executeScript("return document.documentElement.innerText;").toString();
		return pageText;
	}
	
	public static void scrollDownByJS()
	{
		js=((JavascriptExecutor)driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	public static void scrollUPByJS()
	{
		js=((JavascriptExecutor)driver);
		js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
	}
	
	public static String scrollIntoViewByJS(WebElement element)
	{
		js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		return element.getText();
	}
}
