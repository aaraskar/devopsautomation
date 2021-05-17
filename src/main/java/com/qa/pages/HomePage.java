package com.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testbase.TestBase;
import com.qa.utils.Synchronization;
public class HomePage extends TestBase {
	
	//Define Web Elements
	
	@FindBy(xpath="//span[contains(text(),'AJR AJ')]")
	WebElement loggedInUsername;
	
	@FindBy(xpath="//div[contains(text(),'Deals Summary')]")
	WebElement dealLabel;
	
	@FindBy(xpath="//span[contains(text(),'Home')]")
	WebElement home;
	@FindBy(xpath="//span[contains(text(),'Calendar')]")
	WebElement calendar;
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contacts;
	@FindBy(xpath="//span[contains(text(),'Companies')]")
	WebElement companies;
	
	//Initialize WebElements using PageFactory
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Define methods on Home Page
	public String verifyLoggedInuserName()
	{
		return loggedInUsername.getText();
	}
	
	public boolean verifyLeftPannelMenuItems()
	{
		if(home.isDisplayed()&&contacts.isDisplayed()&&calendar.isDisplayed()&&companies.isDisplayed())
			return true;
		else
			return false;
	}
	
	public ContactPage clickContacts()
	{
		Synchronization.clickOn(driver, contacts, 10);
		return new ContactPage();
		
	}
	

}
