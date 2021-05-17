package com.qa.tests;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DevopsTest  {
	
	Logger log=Logger.getLogger(DevopsTest.class);
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;
	
//	@BeforeTest
//	public static void beforeTestConfig()
//	{
//		//configureExtentReport(extentReports);  //This fails.Pl Investigate
//		
//		extentReports=new ExtentReports(System.getProperty("user.dir")+"/test-output/extentReportLoginPage.html",true);
//		extentReports.addSystemInfo("HostName", "slc14vba");
//		extentReports.addSystemInfo("Environment", "QA-Env");
//		extentReports.addSystemInfo("Username", "araskar");
//		
//	}
	
//	@AfterTest
//	public void afterTestConfig()
//	{
//		endExtentReport(extentReports);  //This works
//		
//		//extentReports.flush();
//		/*
//		 * flush method is used to write all the test logs to the report file and it generates
//		 * the report.If you dont use this method then report will not be generated
//		 */
//		//extentReports.close();
//		/*
//		 * close() method closes the connection with extentreport object and it will close the
//		 * connection with output stream.
//		 */
//	}
	/*public LoginPageTest()
	{
		super();
	}*/
	
	
//	@BeforeMethod
//	public void beforeMethodConfig()
//	{
//		
//		/* Here we perform below tasks
//		 * 1:Initialize the property file in TestBase class through TestBase() constructor
//		 * 2:Initialize the driver configuration and launch the url through initialization() method.
//		 * 3:Initialize the web elements on LoginPage through LoginPage() constructor.
//		 */ 
//		 
//		
//		/*log.info("***Starting the setup***");
//		log.info("***Initializing the property file***");
//		TestBase testBase=new TestBase();//Initializes property file in TestBase.
//		log.info("***Initialization of the property file ended***");*/
//		
//		 /* The other way to initialize propety file in TestBase class is to invoke
//		 * the constructor of TestBase class as mentioned in constructor of LoginPageTest
//		 */
//		 
//		/*log.info("***Initializing the driver configuration and launching the product url***");
//		initialization();//Initializes driver and launches the url.
//		log.info("***Driver configuration initialized***");
//		log.info("***Initializing the web elements on LoginPage***");
//		loginPage=new LoginPage(); //Initializes web elements on LoginPage.
//		log.info("***Web Elements on LoginPage initialized***");
//		*/
//		
//		
//		setup(); // This works
//		loginPage=new LoginPage();
//		
//		
//		
//		
//	}
	
	
	@Test(priority=1)
	public void test1()
	{
		WebDriver driver;
		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Chrome90\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://3.141.38.140:8080/webapp/");
		WebElement el=driver.findElement(By.xpath("//h1[contains(text(),'Rahul')]"));
		String text=el.getText();
		System.out.println(text);
	
	//extentTest=extentReports.startTest("Test1");
	//log.info("***Starting the test case: Test1***");	
		driver.quit();
	}
	
	@Test(priority=2)
	public void test2()
	{
		boolean flag=true;
	
	//extentTest=extentReports.startTest("Test2");
	//log.info("***Starting the test case: Test2***");	
	Assert.assertTrue(flag);
	//log.info("***Ending the test case: test2***");
	}
	
	
//	@AfterMethod
//	public void afterMethodConfig(ITestResult result) throws IOException
//	{
//		
//		tearDown(result,extentTest,driver,extentReports);  //This works
//		
//		/*if(result.getStatus()==ITestResult.FAILURE)
//		{
//			extentTest.log(LogStatus.FAIL, result.getName() + ": FAILED");
//			extentTest.log(LogStatus.FAIL, "Exception is : " +result.getThrowable());
//			String path=getScreenShot(driver,result.getName());
//			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(path));
//		}
//		
//		if(result.getStatus()==ITestResult.SKIP)
//		{
//			extentTest.log(LogStatus.SKIP, result.getName()+" : SKIPPED");
//		}
//		else if(result.getStatus()==ITestResult.SUCCESS)
//		{
//			extentTest.log(LogStatus.PASS, result.getName() + " : PASSED");
//		}
//		extentReports.endTest(extentTest);
//		
//		driver.quit();*/
//	}
}
