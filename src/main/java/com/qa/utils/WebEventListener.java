package com.qa.utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.log4testng.Logger;

import com.qa.testbase.TestBase;
public class WebEventListener extends TestBase implements WebDriverEventListener {

	Logger log=Logger.getLogger(WebEventListener.class);
	@Override
	public void afterAlertAccept(WebDriver arg0) {
		System.out.println("Alert accepted");
		
	}

	@Override
	public void afterAlertDismiss(WebDriver arg0) {
		System.out.println("Alert dismissed");
		
	}

	@Override
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterClickOn(WebElement element, WebDriver arg1) {
		System.out.println("Clicked on element: " +element.toString());
		log.info("Clicked on element: " +element.toString());
		
	}

	@Override
	public void afterFindBy(By xpath, WebElement arg1, WebDriver arg2) {
		System.out.println("Found element by : " +xpath);
		log.info("Found element by : " +xpath);
		
	}

	@Override
	public void afterNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateTo(String url, WebDriver arg1) {
		System.out.println("Navigated to : " +url);
		log.info("Navigated to : " +url);
		
	}

	@Override
	public void afterScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver arg1) {
		System.out.println("Trying to click on : " +element.toString());
		log.info("Trying to click on : " +element.toString());
		
	}

	@Override
	public void beforeFindBy(By xpath, WebElement arg1, WebDriver arg2) {
		System.out.println("Trying to find element by : " +xpath);
		log.info("Trying to find element by : " +xpath);
		
	}

	@Override
	public void beforeNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onException(Throwable arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

}
