package com.weather.SmokeTestcases;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSElement;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import atu.testng.reports.ATUReports;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.weather.Genaral.Scroll;
import com.weather.driver.Driver;
/**
 * 
 * @author Naresh
 *
 */
public class SmokeTest_C334148_News extends Driver{
	@SuppressWarnings("deprecation")
	public void verify_adpresent_onextendedNews_page() throws InterruptedException, IOException
	{
		
		String originalContext = Ad.getContext();
		Ad.context("NATIVE_APP");
		
		NewsSteps=1;
		ExtentReports reporter = Driver.getInstance();
		logger = reporter.startTest("Verify NEWS extended page test case").assignCategory("Smoke_Test");
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

		ATUReports.add("Scroll to News Page",false);
		logger.log(LogStatus.PASS, "Scroll to News Page");
		
		NewsSteps=NewsSteps+1;
		//int newsloops;
		//IOSElement News = null;
		
		IOSElement News = (IOSElement) Ad.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIACollectionView[1]/UIACollectionCell[13]"));
				//Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIACollectionView[1]/UIACollectionCell[13]/UIACollectionView[1]/UIACollectionCell[1]/UIAStaticText[1]");
				//Ad.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIACollectionView[1]/UIACollectionCell["+newsloops+"]"));
		System.out.println("News element text is ::"+News.getText());
		System.out.println("News  is ::"+News.getAttribute("name"));
		System.out.println("News  is ::"+News);
		System.out.println("News  is ::"+News.getTagName());
		System.out.println("Element Name is ::" + "News page");
		
		
		NewsSteps=NewsSteps+1;
		for(int page =1 ; page<=4;page++)
		{
			if(News.isDisplayed())
			{   
				
				System.out.println("Verify that News page is displayed and tap on News Image");

			ATUReports.add("Verify that News page is displayed and tap on News Image",false);
			logger.log(LogStatus.PASS, "Verify that News page is displayed and tap on News Image");
			//Scroll.scrolldown();
			
			System.out.println("Scroll Done:Verifying text view");
			List <MobileElement> list =	Ad.findElementsByClassName("UIAStaticText");
//			 for(MobileElement el : list) {
//			       System.out.println("Mobileelement is::"+el.getText());
//			    
//			    }
			System.out.println("List Size is ::"+list.size()); 
			 
			for(int i =12;i<=14;i++)
			{
				System.out.println("i value is ::"+i);
			try{
			Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIACollectionView[1]/UIACollectionCell["+i+"]/UIACollectionView[1]/UIACollectionCell[1]/UIAStaticText[1]").click();
			//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIACollectionView[1]/UIACollectionCell[14]/UIACollectionView[1]/UIACollectionCell[1]/UIAStaticText[1]").click();
			//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIACollectionView[1]/UIACollectionCell[14]/UIACollectionView[1]/UIACollectionCell[1]/UIAStaticText[1]").click();
			//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIACollectionView[1]/UIACollectionCell[12]/UIACollectionView[1]/UIACollectionCell[1]/UIAStaticText[1]
			break;
			}catch (NoSuchElementException e)
			{
				System.out.println("Element not Found");
			}
			}
			NewsSteps=NewsSteps+1;
			MobileElement AdEle =(MobileElement) Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]");

			WebDriverWait wait = new WebDriverWait(Ad, 4);
			wait.until(ExpectedConditions.visibilityOf(AdEle));
			if(AdEle.isDisplayed())
			{
				
				System.out.println("Ad present on Extended News page");

				ATUReports.add("Ad is displayed on Extended News page",false);
				logger.log(LogStatus.PASS, "Ad is displayed on Extended News page");
				Ad.findElement(By.name("navControl backArrow")).click();
				Thread.sleep(1000);
				//System.out.println("Add size is :: " + Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]").getAttribute("size"));
			}break;

			}else
			{
				NewsSteps=NewsSteps+1;
				System.out.println("News element is not present");
				JavascriptExecutor js = (JavascriptExecutor) Ad ;
				HashMap<String, String> scrollObject = new HashMap<String, String>();
				scrollObject.put("direction", "down");
				js.executeScript("mobile: scroll", scrollObject);
			}
		}
		NewsSteps=0;
//		reporter.endTest(logger);
//		reporter.flush();
	}
}
