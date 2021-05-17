package com.qa.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;

import com.qa.utils.WebEventListener;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream fis;
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;
	public static EventFiringWebDriver eventFiringWebdriver;//Declaring WebDriver which throws details of events.
	public static WebEventListener webEventListener;
	//D:\Ecilipse\eclipse-workspace\Selenium_Automation_Framework\src\main\java\com\qa\config\config.properties
	
	public TestBase()
	{
		try {
			fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\config\\config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prop=new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void initialization()
	{
		if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
		{
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\driver86\\chromedriver.exe");
		driver=new ChromeDriver();
		}
		
		if(prop.getProperty("browser").equalsIgnoreCase("firefox"))
		{
		
			System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\FIrefoxdriver\\geckodriver.exe");
			FirefoxOptions firefoxOptions = new FirefoxOptions();
		    firefoxOptions.setCapability("marionette", true);
	        driver = new FirefoxDriver(firefoxOptions);
		}
		
		if(prop.getProperty("browser").equalsIgnoreCase("headless"))
		{
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\driver86\\chromedriver.exe");
		ChromeOptions op=new ChromeOptions();
		op.addArguments("--headless");
		driver=new ChromeDriver(op);
		
		}
		
		
		/*
		 * Below code will give you very good console output. if you dont want that then you can comment
		 * This is the implementation for web event listeners 
		 */
		
	/*	eventFiringWebdriver=new EventFiringWebDriver(driver);
		webEventListener=new WebEventListener();
		eventFiringWebdriver.register(webEventListener);
		driver=eventFiringWebdriver;*/
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(prop.getProperty("pageLoadTimeOut")), TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("ImplicitWait")), TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));  //Free CRM url
		//driver.get(prop.getProperty("amazon"));
		//driver.get("https://demoqa.com/menu/");
		//driver.get("http://demo.guru99.com/test/simple_context_menu.html");
		//driver.get("http://demo.guru99.com/test/drag_drop.html");
		//driver.get("http://demo.guru99.com/test/guru99home/");
		
		//driver.get("http://demo.guru99.com/popup.php"); For window handle
		
	}
	
	public static String getScreenShot(WebDriver driver,String testCaseName) throws IOException
	{
		File srcFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		/*
		 * Above step takes the screen shot and stores in a file
		 * 
		 */
		String date=new SimpleDateFormat("yyyyddmmhhmmss").format(new Date());
		String path=System.getProperty("user.dir")+"/FailedTestsScreenshots/"+testCaseName+date+".png";
		File destFile=new File(path);
		FileUtils.copyFile(srcFile,destFile);
		return path;
	}
	
	public static void configureExtentReport(ExtentReports extentReports)
	{
		extentReports=new ExtentReports(System.getProperty("user.dir")+"/test-output/extentReport.html",true);
		extentReports.addSystemInfo("HostName", "slc14vba");
		extentReports.addSystemInfo("Environment", "QA-Env");
		extentReports.addSystemInfo("Username", "araskar");
	}
	
	public static void endExtentReport(ExtentReports extentReports)
	{
		
		extentReports.flush();
		extentReports.close();
	}
	
	public static void setup()
	{
		TestBase testBase=new TestBase();
		initialization();
	}
	
	public static void tearDown(ITestResult result,ExtentTest extentTest,WebDriver driver,ExtentReports extentReports) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
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
		
		driver.quit();
	}
}
