package com.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testbase.TestBase;
import com.qa.utils.Synchronization;
public class ContactPage extends TestBase {
	
	@FindBy(xpath="//button[contains(text(),'New')]")
	WebElement newButton;
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstName;
	@FindBy(xpath="//input[@name='middle_name']")
	WebElement midName;
	@FindBy(xpath="//input[@name='last_name']")
	WebElement lastName;
	@FindBy(xpath="//button[contains(text(),'Save')]")
	WebElement saveButton;
	
	public ContactPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickNewButton()
	{
		Synchronization.clickOn(driver, newButton, 10);
	}
	
	public void fillNewContactForm(String fName,String lName,String mName) throws InterruptedException
	{
		Synchronization.sendData(driver, firstName, fName, 10);
		Synchronization.sendData(driver, midName, mName, 10);
		Synchronization.sendData(driver, lastName, lName, 10);
		Synchronization.clickOn(driver, saveButton, 10);
		Thread.sleep(5000);
		
	}
	

}
