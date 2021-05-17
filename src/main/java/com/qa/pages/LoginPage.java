package com.qa.pages;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testbase.TestBase;
import com.qa.utils.DetectBrokenLinksAndImages;
import com.qa.utils.JavaScriptExecutorOperations;
import com.qa.utils.MouseMovements;
import com.qa.utils.Synchronization;

public class LoginPage extends TestBase {
	
	//Define WebElements on LoginPage i.e PageFactory
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement email;
	
	@FindBy(xpath="//span[contains(text(),'Back to top')]")
	private WebElement backToTop;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement password;
	
	@FindBy(xpath="//div[text()='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath="//a[text()='Forgot your password?']")
	private WebElement forgotPasswordLink;
	
	@FindBy(xpath="//a[contains(text(),'Main Item 2')]")
	private WebElement mainItem2;
	
	@FindBy(xpath="//a[contains(text(),'SUB SUB LIST')]")
	private WebElement subSubList;
	
	@FindBy(xpath="//a[contains(text(),'Sub Sub Item 1')]")
	private WebElement subItem1;
	@FindBy(xpath="//button[contains(text(),'Double-Click Me To See Alert')]")
	private WebElement box;
	
	@FindBy(xpath="//span[contains(text(),'right click me')]")
	private WebElement rtButton;
	
	@FindBy(xpath="//span[contains(text(),'Edit')]")
	private WebElement editButton;
	
	@FindBy(xpath="//*[@id='credit2']")
	private WebElement credit2;
	
	@FindBy(xpath="//*[@id='bank']/li")
	private WebElement bank;
	
	@FindBy(xpath="//img[contains(@src,'Jmeter')]")
	private WebElement jmeter;
	
	@FindBy(xpath="//a[contains(text(),'Click Here')]")
	private WebElement clickHere;
	
	@FindBy(xpath="//input[@name='emailid']")
	private WebElement emailID;
	
	@FindBy(xpath="//input[@value='Submit']")
	private WebElement submit;
	
	
	public static LoginPage loginPage;
	Logger log=Logger.getLogger(LoginPage.class);
	
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this); // This will initialize the elements on this page
	}
	//Define Methods on LoginPage
	
	
	public boolean verifyLoginRelatedWebElements()
	{
		if(email.isDisplayed()&&password.isDisplayed()&&loginButton.isDisplayed())
		{
			return true;
		}
		else
			return false;
	}
	
	public HomePage loginToCRM()
	{
		//loginPage=new LoginPage();
		
		//email.sendKeys("ajit.enjoy@gmail.com");
		Synchronization.sendData(driver, email, prop.getProperty("userName"), 10);
		
		//password.sendKeys("97Malibu!@#");
		Synchronization.sendData(driver, password, prop.getProperty("password"), 10);

		//loginButton.click();  
		//OR
		
		//Synchronization.clickOn(driver, loginButton, 10); 
		//OR
		
		
		JavaScriptExecutorOperations.clickElementByJS(loginButton,10);
		return new HomePage();
		
	}
	
	public boolean findBrokenLinksOnLoginPage(String url) throws MalformedURLException, IOException
	{
		int links=DetectBrokenLinksAndImages.findBrokenLinks(url);
		if(links>0)
		return true;
		else
			return false;
	}
	
	public String checkExistenceOfFooterLink()
	{
		String text=JavaScriptExecutorOperations.scrollIntoViewByJS(backToTop);
		return text;
	}
	
	public void openSubMenuUsingMouseHover()
	{
		Actions actions=new Actions(driver);
		Action action=actions.moveToElement(mainItem2).moveToElement(subSubList).
				click(subItem1).
				build();
		action.perform();
		
	}
	
	public String doubleClick() throws InterruptedException
	{
	/*	Actions actions=new Actions(driver);
		Action action=actions.doubleClick(box).build();
		Synchronization.waitForElementToBeClickable(driver, box, 10);
		action.perform();
		Thread.sleep(5000);*/
		MouseMovements.performDoubleClick(box);
		Alert al=driver.switchTo().alert();
		String text=al.getText();
		al.accept();
		return text;
		
	}
	public String rightClick() throws InterruptedException
	{
		MouseMovements.performRightClick(rtButton);
		Synchronization.clickOn(driver, editButton, 10);
		Alert al=driver.switchTo().alert();
		System.out.println("Text is : " + al.getText());
		String text=al.getText();
		al.accept();
		return text;
	}
	
	public String performDragAndDrop()
	{
		log.info("Executing performDragAndDrop method");
		MouseMovements.dragAndDrop(credit2, bank);
		String text=bank.getText();
		System.out.println("Text is: " +text);
		return text;
	}
	
	public void openjmeter()
	{
		driver.switchTo().frame("a077aa5e");
		Synchronization.clickOn(driver, jmeter, 10);
		
	}
	
	public void checkWindowHandle()
	{
		String parentWindow=driver.getWindowHandle();
		Synchronization.clickOn(driver, clickHere, 10);
		//String parentWindow=driver.getWindowHandle();
		Set<String>windowSet =  driver.getWindowHandles();
		Iterator<String>i1=windowSet.iterator();
		while(i1.hasNext())
		{
			String childWindow=i1.next();
			if(!childWindow.equalsIgnoreCase(parentWindow))
			{
				
				driver.switchTo().window(childWindow);
				Synchronization.sendData(driver, emailID, "aa@gmail.com", 10);
				Synchronization.clickOn(driver, submit, 10);
				driver.close();
			}
			
			
		}
		driver.switchTo().window(parentWindow);
		Synchronization.clickOn(driver, clickHere, 10);
		
	
	}
	
	public void sampleTest1()
	{
		System.out.println("sample test1");
	}
	
	public void sampleTest2()
	{
		System.out.println("sample test2");
	}
	
	public void sampleTest3()
	{
		System.out.println("sample test3");
	}
	
	public void sampleTest4()
	{
		System.out.println("sample test4");
	}

}
