package com.qa.tests;

import java.io.IOException;
import java.net.MalformedURLException;

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
import com.qa.utils.JavaScriptExecutorOperations;
import com.qa.utils.Synchronization;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginPageTest extends TestBase {
	public static LoginPage loginPage;
	public static HomePage homePage;
	Logger log=Logger.getLogger(LoginPageTest.class);
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;
	
	@BeforeTest
	public static void beforeTestConfig()
	{
		//configureExtentReport(extentReports);  //This fails.Pl Investigate
		
		extentReports=new ExtentReports(System.getProperty("user.dir")+"/test-output/extentReportLoginPage.html",true);
		extentReports.addSystemInfo("HostName", "slc14vba");
		extentReports.addSystemInfo("Environment", "QA-Env");
		extentReports.addSystemInfo("Username", "araskar");
		
	}
	
	@AfterTest
	public void afterTestConfig()
	{
		endExtentReport(extentReports);  //This works
		
		//extentReports.flush();
		/*
		 * flush method is used to write all the test logs to the report file and it generates
		 * the report.If you dont use this method then report will not be generated
		 */
		//extentReports.close();
		/*
		 * close() method closes the connection with extentreport object and it will close the
		 * connection with output stream.
		 */
	}
	/*public LoginPageTest()
	{
		super();
	}*/
	
	
	@BeforeMethod
	public void beforeMethodConfig()
	{
		
		/* Here we perform below tasks
		 * 1:Initialize the property file in TestBase class through TestBase() constructor
		 * 2:Initialize the driver configuration and launch the url through initialization() method.
		 * 3:Initialize the web elements on LoginPage through LoginPage() constructor.
		 */ 
		 
		
		/*log.info("***Starting the setup***");
		log.info("***Initializing the property file***");
		TestBase testBase=new TestBase();//Initializes property file in TestBase.
		log.info("***Initialization of the property file ended***");*/
		
		 /* The other way to initialize propety file in TestBase class is to invoke
		 * the constructor of TestBase class as mentioned in constructor of LoginPageTest
		 */
		 
		/*log.info("***Initializing the driver configuration and launching the product url***");
		initialization();//Initializes driver and launches the url.
		log.info("***Driver configuration initialized***");
		log.info("***Initializing the web elements on LoginPage***");
		loginPage=new LoginPage(); //Initializes web elements on LoginPage.
		log.info("***Web Elements on LoginPage initialized***");
		*/
		
		
		setup(); // This works
		loginPage=new LoginPage();
		
		
		
		
	}
	
	
	@Test(priority=1,enabled=false)
	public void validateLoginWebElements()
	{
	extentTest=extentReports.startTest("validateLoginWebElements");
	log.info("***Starting the test case: validateLoginWebElements***");	
	Boolean flag=loginPage.verifyLoginRelatedWebElements();
	Assert.assertTrue(flag);
	log.info("***Ending the test case: validateLoginWebElements***");
	}
	
	
	@Test(priority=2,enabled=false)
	public void validateBrokenLinksOnLoginPage() throws MalformedURLException, IOException
	{
	extentTest=extentReports.startTest("validateBrokenLinksOnLoginPage");
	log.info("***Starting the test case: validateBrokenLinksOnLoginPage***");
	String url=driver.getCurrentUrl();
	Boolean flag=loginPage.findBrokenLinksOnLoginPage(url);
	Assert.assertTrue(!flag,"There are broken links on the LoginPage");
	log.info("***Ending the test case: validateBrokenLinksOnLoginPage***");
	}
	
	@Test(priority=1)
	public void validateLoginToCRM()
	{	
		extentTest=extentReports.startTest("validateLoginToCRM");
		log.info("***Starting the test case: validateLoginToCRM***");
		homePage=loginPage.loginToCRM();
		log.info("***Ending the test case: validateLoginToCRM***");
	}
	
	@Test(priority=4,enabled=false)
	public void refreshBrowser()
	{
		extentTest=extentReports.startTest("refreshBrowser");
		JavaScriptExecutorOperations.refreshBrowserByJS();
	}
	
	@Test(priority=5,enabled=false)
	public void validateLoginPageTitle()
	{	extentTest=extentReports.startTest("validateLoginPageTitle");
		String title=JavaScriptExecutorOperations.getTitleByJS();
		Assert.assertEquals(title, "Cogmento CRM");
	}
	
	@Test(priority=6,enabled=false)
	public void validateScrolling()
	{
		extentTest=extentReports.startTest("validateScrolling");
		JavaScriptExecutorOperations.scrollDownByJS();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JavaScriptExecutorOperations.scrollUPByJS();
	}
	
	
	@Test(enabled=false)
	public void validateFooterLink()
	{	extentTest=extentReports.startTest("validateFooterLink");
		String text=loginPage.checkExistenceOfFooterLink();
		Assert.assertEquals(text, "Back to top");
		
	}
	@Test (enabled=false)
	public void validateOpeningSubMenu()
	{
		extentTest=extentReports.startTest("validateOpeningSubMenu");
		loginPage.openSubMenuUsingMouseHover();
		
	}
	
	@Test (enabled=false)
	public void validateDoubleClick() throws InterruptedException
	{
		extentTest=extentReports.startTest("validateDoubleClick");
		String text=loginPage.doubleClick();
		System.out.println("Text is : " +text);
		Assert.assertEquals("You double clicked me.. Thank You..", text);
	}
	
	@Test (enabled=false)
	public void validateRightClick() throws InterruptedException 
	{
		extentTest=extentReports.startTest("validateRightClick");
		String text=loginPage.rightClick();
		Assert.assertEquals(text, "clicked: edit");
		//String text=loginPage.doubleClick();
		//System.out.println("Text is : " +text);
		//Assert.assertEquals("You double clicked me.. Thank You..", text);
	}
	
	@Test (enabled=false)
	public void validateDragAndDrop() throws InterruptedException 
	{
		extentTest=extentReports.startTest("validateDragAndDrop");
		String text=loginPage.performDragAndDrop();
		
		Assert.assertEquals(text, "BANK");
		
	}
	@Test(enabled=false)
	public void validateSwitchingToFrame()
	{
		extentTest=extentReports.startTest("validateSwitchingToFrame");
		loginPage.openjmeter();
		
	}
	
	@Test(enabled=false,priority=1)
	public void validateWindowHandle()
	{
		extentTest=extentReports.startTest("validateWindowHandle");
		loginPage.checkWindowHandle();
	}

	@Test(priority=2)
	public void test1()
	{
		extentTest=extentReports.startTest("test1");
		loginPage.sampleTest1();
	}
	
	@Test(priority=3)
	public void test2()
	{
		extentTest=extentReports.startTest("test2");
		loginPage.sampleTest2();
		//System.out.println("Executed test2");
	}
	
	@Test(priority=4)
	public void test3()
	{
		extentTest=extentReports.startTest("test3");
		//System.out.println("Executed test3");
		loginPage.sampleTest3();
	}
	
	@Test(enabled=false,priority=5)
	public void test4()
	{
		extentTest=extentReports.startTest("test4");
		loginPage.sampleTest4();
	}
	
	@AfterMethod
	public void afterMethodConfig(ITestResult result) throws IOException
	{
		
		tearDown(result,extentTest,driver,extentReports);  //This works
		
		/*if(result.getStatus()==ITestResult.FAILURE)
		{
			extentTest.log(LogStatus.FAIL, result.getName() + ": FAILED");
			extentTest.log(LogStatus.FAIL, "Exception is : " +result.getThrowable());
			String path=getScreenShot(driver,result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(path));
		}
		
		if(result.getStatus()==ITestResult.SKIP)
		{
			extentTest.log(LogStatus.SKIP, result.getName()+" : SKIPPED");
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			extentTest.log(LogStatus.PASS, result.getName() + " : PASSED");
		}
		extentReports.endTest(extentTest);
		
		driver.quit();*/
	}
}
