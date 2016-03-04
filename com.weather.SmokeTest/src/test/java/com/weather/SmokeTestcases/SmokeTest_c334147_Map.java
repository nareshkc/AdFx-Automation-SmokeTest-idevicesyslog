package com.weather.SmokeTestcases;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSElement;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
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
public class SmokeTest_c334147_Map extends Driver{

	@SuppressWarnings("deprecation")
	public void verify_adpresent_onextendedMap_page() throws InterruptedException, IOException
	{
		
		MapsSteps=1;
		ExtentReports reporter = Driver.getInstance();
		logger = reporter.startTest("Verify Maps extended page test case").assignCategory("Smoke_Test");
		ATUReports.add("Launch the app",false);
		logger.log(LogStatus.PASS, "Launch the app");
		//Verify usr on main page
		try{
		if(Ad.findElementByName("navControl backArrow").isDisplayed())
		{
			Ad.findElementByName("navControl backArrow").click();
		}
		}catch(NoSuchElementException ex)
		{
			System.out.println("User on main page");
		}
		
		ATUReports.add("Scroll to Maps Page",false);
		logger.log(LogStatus.PASS, "Scroll to Maps Page");
		MapsSteps=MapsSteps+1;
		System.out.println("searching for map");
		Thread.sleep(2000);
		MobileElement Map = (MobileElement) Ad.findElement(By.name("map play"));
		System.out.println("Element Name is ::" + "Maps Page");
		for(int page =1 ; page<=8;page++)
		{
			
			if(Map.isDisplayed())
			{
				MapsSteps=MapsSteps+1;
				if(!Ad.findElementByName("map play").isDisplayed())
						//Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIACollectionView[1]/UIACollectionCell[8]/UIAButton[1]").isDisplayed())
				{
				System.out.println("Map element is not present");
				ATUReports.add("Map page is not present and scrolling again",false);
				logger.log(LogStatus.PASS, "Map page is not present and scrolling again");
				JavascriptExecutor js = (JavascriptExecutor) Ad ;
				HashMap<String, String> scrollObject = new HashMap<String, String>();
				scrollObject.put("direction", "down");
				js.executeScript("mobile: scroll", scrollObject);
				}
				//Ad.findElementByName("map play").click();
				System.out.println("Verify that Maps page is displayed and tap on Map button");
				
				ATUReports.add("Verify that Maps page is displayed and tap on Map button",false);
				logger.log(LogStatus.PASS, "Verify that Maps page is displayed and tap on Map button");
				MapsSteps=MapsSteps+1;
				//Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIACollectionView[1]/UIACollectionCell[8]/UIAButton[1]").click();
				Ad.findElementByName("map play").click();
				MapsSteps=MapsSteps+1;
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
					    
					    	System.out.println("Ad present on Extended Map page");
					    	System.out.println("Ad sizes are matched");
							ATUReports.add("Ad is displayed on Extended Map page",false);
							logger.log(LogStatus.PASS, "Ad is displayed on Extended Map page");
					    }else
					    {
					    	TendaysSteps=5+1;
					    	System.out.println("Ad present but sizes are not matched");
					    	Assert.fail();
					    }
					
					System.out.println("Ad present on Extended Map page");
					ATUReports.add("Ad present on Extended Map page",false);
					logger.log(LogStatus.PASS, "Ad present on Extended Map page");
					//Ad.findElement(By.name("navControl backArrow")).click();
					//Thread.sleep(1000);
					//System.out.println("Add size is :: " + Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]").getAttribute("size"));
				}break;

			}else
			{
				MapsSteps=MapsSteps+1;
				System.out.println("Map element is not present");
				JavascriptExecutor js = (JavascriptExecutor) Ad ;
				HashMap<String, String> scrollObject = new HashMap<String, String>();
				scrollObject.put("direction", "down");
				js.executeScript("mobile: scroll", scrollObject);
			}
		}
		MapsSteps=0;
		reporter.endTest(logger);
		reporter.flush();
	}

}
