package com.qa.utils;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.qa.testbase.TestBase;
public class DetectBrokenLinksAndImages extends TestBase {
	public static List <WebElement> linksAndImagesList;
	public static List <WebElement> activeLinks;
	public static Logger log=Logger.getLogger(com.qa.utils.DetectBrokenLinksAndImages.class);
	
	public static int findBrokenLinks(String url) throws MalformedURLException, IOException
	{
		
		linksAndImagesList=new ArrayList<>();
		activeLinks=new ArrayList<>();
		
		linksAndImagesList=driver.findElements(By.tagName("a"));
		linksAndImagesList.addAll(driver.findElements(By.tagName("img")));
		int brokenLinkCount=0;
		
		for(WebElement we:linksAndImagesList)
		{
			if( (we.getAttribute("href")!=null) && (we.getAttribute("href").startsWith("http")) )
			{
				activeLinks.add(we);
				
			}
			
		}
		
		for(WebElement we:activeLinks)
		{
			
		HttpURLConnection connection=(HttpURLConnection)new URL(we.getAttribute("href")).openConnection();
		connection.connect();
		String message=connection.getResponseMessage();
		int responseCode=connection.getResponseCode();
		
		System.out.println("Link : "+ we.getAttribute("href") + " ResponseMessage : " +message + " ResponseCode : " +responseCode);
		
		log.info("Link : "+ we.getAttribute("href") + " ResponseMessage : " +message + " ResponseCode : " +responseCode);
		
		
		
		if(!message.equalsIgnoreCase("ok"))
		{
			brokenLinkCount++;
		}
		
		}
		return brokenLinkCount;
		
		
	}

}
