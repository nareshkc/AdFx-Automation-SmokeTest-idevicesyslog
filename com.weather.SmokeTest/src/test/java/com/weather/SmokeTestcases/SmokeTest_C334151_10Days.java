package com.weather.SmokeTestcases;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSElement;

import java.io.IOException;
import java.util.HashMap;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import atu.testng.reports.ATUReports;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.weather.driver.Driver;
/**
 * 
 * @author Naresh
 *
 */
public class SmokeTest_C334151_10Days extends Driver{


	@SuppressWarnings("deprecation")
	public void verify_adpresent_onextendedTendays_page() throws InterruptedException, IOException
	{
		TendaysSteps=1;
		ExtentReports reporter = Driver.getInstance();
		logger = reporter.startTest("Verify 10days extended page test case").assignCategory("Smoke_Test");
		String originalContext = Ad.getContext();
		Ad.context("NATIVE_APP");

		//Thread.sleep(1000);
		ATUReports.add("Launch the app",false);
		logger.log(LogStatus.PASS, "Launch the app");
		//Verify user on main page
				try{
				if(Ad.findElement(By.name("navControl backArrow")).isDisplayed())
				{
					Ad.findElementByName("navControl backArrow").click();
				}
				}catch(NoSuchElementException e)
				{
					System.out.println("User on main page");
				}

		ATUReports.add("Scroll to Daily page",false);
		logger.log(LogStatus.PASS, "Scroll to Daily page");
		
		TendaysSteps=TendaysSteps+1;
		
		IOSElement Tendays = (IOSElement) Ad.findElement(By.name("15 Days"));
		System.out.println("Element Name is ::" + "Daily Page");
		for(int page =1 ; page<=4;page++)
		{
			if(Tendays.isDisplayed())	
			{ 
				TendaysSteps=TendaysSteps+1;
				System.out.println("Verify that Daily page is displayed and tap on 15 Days button");
				ATUReports.add("Verify that Daily page is displayed and tap on 15 Days  button",false);
				logger.log(LogStatus.PASS, "Verify that Daily page is displayed and tap on 15 Days  button");
				//Thread.sleep(1000);
				Thread.sleep(1000);
				
				System.out.println("Extended Present");
				try{
					Ad.findElement(By.name("15 Days")).click();
					//Ad.findElement(By.name("EXTENDED FORECAST")).click();
				}catch(NoSuchElementException e)
				{
					//Ad.findElement(By.name("WEEKEND FORECAST")).click();
					Ad.findElement(By.name("15 Days")).click();
				}

				TendaysSteps=TendaysSteps+1;
				MobileElement AdEle =(MobileElement) Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]");

				WebDriverWait wait = new WebDriverWait(Ad, 4);
				wait.until(ExpectedConditions.visibilityOf(AdEle));
				int x =320;
				int y =50;
				
				
				if(AdEle.isDisplayed())
				{
					Dimension ActualSize = AdEle.getSize();
					System.out.println("Size of the ad is ::"+ActualSize);
					System.out.println("Height of the ad is ::"+ActualSize.getHeight());
					System.out.println("Width of the ad is ::"+ActualSize.getWidth());
					    if(ActualSize.getHeight() == y && ActualSize.getWidth()==x){
					    
					    	System.out.println("Ad present on Extended 10 Days page");
					    	System.out.println("Ad sizes are matched");
							ATUReports.add("Ad is displayed on Extended 10 Days page",false);
							logger.log(LogStatus.PASS, "Ad is displayed on Extended 10 Days page");
					    }else
					    {
					    	TendaysSteps=5+1;
					    	System.out.println("Ad present but sizes are not matched");
					    	Assert.fail();
					    }
					
					
					System.out.println("Ad present on Extended 10 Days page");
					ATUReports.add("Ad is displayed on Extended 10 Days page",false);
					logger.log(LogStatus.PASS, "Ad is displayed on Extended 10 Days page");
					//Ad.findElement(By.name("navControl backArrow")).click();
				//	Thread.sleep(1000);
					//System.out.println("Add size is :: " + Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]").getAttribute("size"));
				}break;

			}else
			{
				TendaysSteps=TendaysSteps+1;
				System.out.println("10Day page is not present");
				JavascriptExecutor js = (JavascriptExecutor) Ad ;
				HashMap<String, String> scrollObject = new HashMap<String, String>();
				scrollObject.put("direction", "down");
				js.executeScript("mobile: scroll", scrollObject);
			}
		}
		TendaysSteps=0;
		reporter.endTest(logger);
		reporter.flush();
	}
}
