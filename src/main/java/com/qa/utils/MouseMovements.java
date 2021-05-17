package com.qa.utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.qa.testbase.TestBase;
public class MouseMovements extends TestBase {
	
	public static void performDoubleClick(WebElement element) throws InterruptedException
	{
		
		Actions actions=new Actions(driver);
		Action action=actions.doubleClick(element).build();
		Synchronization.waitForElementToBeClickable(driver, element, 10);
		action.perform();
		//Thread.sleep(5000);
	}

	
	public static void performRightClick(WebElement element) throws InterruptedException 
	{
		
		Actions actions=new Actions(driver);
		Action action=actions.contextClick(element).build();
		Synchronization.waitForElementToBeClickable(driver, element, 10);
		action.perform();
		//Thread.sleep(5000);
	}
	
	public static void dragAndDrop(WebElement from, WebElement to)
	{
		Actions actions=new Actions(driver);
		Action action=actions.dragAndDrop(from, to).build();
		action.perform();
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
