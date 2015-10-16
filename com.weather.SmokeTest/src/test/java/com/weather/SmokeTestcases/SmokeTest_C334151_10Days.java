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
public class SmokeTest_C334151_10Days extends Driver{


	@SuppressWarnings("deprecation")
	public void verify_adpresent_onextendedTendays_page() throws InterruptedException
	{
		//Thread.sleep(1000);
		ATUReports.add("Launching the app",false);
		Ad.findElement(By.name("Back")).click();
		Thread.sleep(2000);
		ATUReports.add("Scrolling to 10 Days page",false);
		IOSElement Tendays = (IOSElement) Ad.findElement(By.name("10 Day"));
		System.out.println("Element Name is ::" + "10 Days Page");
		for(int page =1 ; page<=3;page++)
		{
			if(Tendays.isDisplayed())	
			{ 
				System.out.println("10Days page is displayed and tapping on EXTENDED FORECAST button");
				ATUReports.add("10Days page is displayed and tapping on EXTENDED FORECAST button",false);
				//Thread.sleep(1000);
				Ad.findElement(By.name("WEEKEND FORECAST")).click();
				MobileElement AdEle =(MobileElement) Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]");
				
				WebDriverWait wait = new WebDriverWait(Ad, 4);
				wait.until(ExpectedConditions.visibilityOf(AdEle));
				if(AdEle.isDisplayed())
				{
					System.out.println("Ad present on Extended 10 Days page");
					ATUReports.add("Ad is displayed on Extended 10 Days page",false);
					//System.out.println("Add size is :: " + Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]").getAttribute("size"));
				}break;

			}else
			{
				System.out.println("10Days page is not present");
				JavascriptExecutor js = (JavascriptExecutor) Ad ;
				HashMap<String, String> scrollObject = new HashMap<String, String>();
				scrollObject.put("direction", "down");
				js.executeScript("mobile: scroll", scrollObject);
			}
		}
	}
}
