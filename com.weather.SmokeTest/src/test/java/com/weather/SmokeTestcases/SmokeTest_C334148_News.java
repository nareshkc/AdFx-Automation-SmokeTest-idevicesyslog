package com.weather.SmokeTestcases;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSElement;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import atu.testng.reports.ATUReports;

import com.weather.driver.Driver;
/**
 * 
 * @author Naresh
 *
 */
public class SmokeTest_C334148_News extends Driver{
	@SuppressWarnings("deprecation")
	public void verify_adpresent_onextendedMap_page() throws InterruptedException
	{
		
		ATUReports.add("Launching the app",false);
		
		Ad.findElement(By.name("Back")).click();
		Thread.sleep(2000);
		ATUReports.add("Scrolling to News Page",false);
		IOSElement News = (IOSElement) Ad.findElement(By.name("News"));
		System.out.println("Element Name is ::" + "News page");
		for(int page =1 ; page<=3;page++)
		{
			if(News.isDisplayed())
			{   System.out.println("News page is displayed and tapping on News Image");
			
			    ATUReports.add("News page is displayed and tapping on News Image",false);
				Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIACollectionView[1]/UIACollectionCell[13]/UIACollectionView[1]/UIACollectionCell[1]").click();
				
				MobileElement AdEle =(MobileElement) Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]");

				WebDriverWait wait = new WebDriverWait(Ad, 4);
				wait.until(ExpectedConditions.visibilityOf(AdEle));
				if(AdEle.isDisplayed())
				{
					System.out.println("Ad present on Extended News page");
					
					ATUReports.add("Ad is displayed on Extended News page",false);
					//System.out.println("Add size is :: " + Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]").getAttribute("size"));
				}break;

			}else
			{
				System.out.println("News element is not present");
				JavascriptExecutor js = (JavascriptExecutor) Ad ;
				HashMap<String, String> scrollObject = new HashMap<String, String>();
				scrollObject.put("direction", "down");
				js.executeScript("mobile: scroll", scrollObject);
			}
		}
	}
}
