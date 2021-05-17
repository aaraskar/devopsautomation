package com.qa.tests;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.testbase.TestBase;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
public class HomePageTest extends TestBase {
	public static HomePage homePage;
	public static LoginPage loginPage;
	public static ExtentReports extentReport;
	public static ExtentTest extentTest;
	Logger log=Logger.getLogger(HomePageTest.class);
	
	@BeforeTest
	public void beforeTestConfig()
	{
		//configureExtentReport(extentReports);  //This fails.Pl Investigate
		
		extentReports=new ExtentReports(System.getProperty("user.dir")+"/test-output/extentReportHomePage.html",true);
		extentReports.addSystemInfo("HostName", "slc14vba");
		extentReports.addSystemInfo("Environment", "QA-Env");
		extentReports.addSystemInfo("Username", "araskar");
		
	}
	@AfterTest
	public void afterTestConfig()
	{
		endExtentReport(extentReports);
	}
	
	@BeforeMethod
	public void beforeMethodConfig()
	{
		setup();
		loginPage=new LoginPage();
		homePage=loginPage.loginToCRM();
	}
	
	@AfterMethod
	public void afterMethodConfig(ITestResult result) throws IOException
	{
		
		tearDown(result,extentTest,driver,extentReports);  //This works
	}
	
	@Test(priority=1)
	public void validateHomePageMenuItems()
	{	extentTest=extentReports.startTest("validateHomePageMenuItems");
		boolean flag=homePage.verifyLeftPannelMenuItems();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=2)
	public void validateLoggedInUserName()
	{	extentTest=extentReports.startTest("validateLoggedInUserName");
		String uName=homePage.verifyLoggedInuserName();
		Assert.assertEquals(uName, "AJR AJ");
	}
	
}
