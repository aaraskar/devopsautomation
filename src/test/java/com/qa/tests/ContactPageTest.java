package com.qa.tests;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.pages.ContactPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.testbase.TestBase;
import com.qa.utils.TestUtil;
import com.relevantcodes.extentreports.ExtentReports;
public class ContactPageTest extends TestBase {
	public static LoginPage loginPage;
	public static HomePage homePage;
	public static ContactPage contactPage;
	
	@BeforeMethod
	public void beforeMethodConfigForContactPage()
	{
		setup();
		loginPage=new LoginPage();
		homePage=loginPage.loginToCRM();
		contactPage=homePage.clickContacts();
		
	}
	
	
	@BeforeTest
	public void beforeTestConfig()
	{
		//configureExtentReport(extentReports);  //This fails.Pl Investigate
		
		extentReports=new ExtentReports(System.getProperty("user.dir")+"/test-output/extentReportContactPage.html",true);
		extentReports.addSystemInfo("HostName", "slc14vba");
		extentReports.addSystemInfo("Environment", "QA-Env");
		extentReports.addSystemInfo("Username", "araskar");
		
	}
	@AfterTest
	public void afterTestConfig()
	{
		endExtentReport(extentReports);
	}
	
	@AfterMethod
	public void afterMethodConfig(ITestResult result) throws IOException
	{
		
		tearDown(result,extentTest,driver,extentReports);  //This works
	}
	
	@DataProvider
	public Object[][] getContactData() throws EncryptedDocumentException, IOException
	{
		Object[][]data=TestUtil.getTestData("contacts");
		return data;
		
	
	}
	
	@Test(dataProvider="getContactData")
	public void validateCreationOfNewContact(String fName,String lName,String mName) throws InterruptedException
	{
		//contactPage=homePage.clickContacts();
		extentTest=extentReports.startTest("validateCreationOfNewContact");
		contactPage.clickNewButton();
		contactPage.fillNewContactForm(fName,lName,mName);
		contactPage=homePage.clickContacts();
		
		
		
		
	}

}
