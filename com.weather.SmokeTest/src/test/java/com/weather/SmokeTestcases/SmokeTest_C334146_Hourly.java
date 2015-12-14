package com.weather.SmokeTestcases;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSElement;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import atu.testng.reports.ATUReports;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.weather.Genaral.app_Kill_Relaunch;
import com.weather.driver.Driver;
//import com.weather.excel.WriteResultintoExcel;
/**
 * 
 * @author Naresh
 *
 */
public class SmokeTest_C334146_Hourly extends Driver{

	@SuppressWarnings("deprecation")
	public void verify_adpresent_onextendedHourly_page() throws Exception{
		
		HourlySteps=1;
		ExtentReports reporter = Driver.getInstance();
		logger = reporter.startTest("Verify Hourly Extened page test case").assignCategory("Smoke_Test");
	
		//app kill and relaunch the app
				app_Kill_Relaunch.Kill_realaunch();
	

		ATUReports.add("Launch the app",false);
		logger.log(LogStatus.PASS, "Launch the app");

		ATUReports.add("Scroll to Hourly Page",false);
		logger.log(LogStatus.PASS, "Scroll to Hourly Page");
		
		HourlySteps=HourlySteps+1;
		
		MobileElement el = (MobileElement) Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAStaticText[2]");
		el.click();
		HourlySteps=HourlySteps+1;
		System.out.println("Element Name is :: Hourly" );
		MobileElement hrly = (MobileElement) Ad.findElement(By.name("PRECIP"));
		
		//WriteResultintoExcel wResult = new WriteResultintoExcel();
		for(int page =1 ; page<=3;page++)
		{
			if(hrly.isDisplayed())
			{ 
				System.out.println("Verify that Hourly page is displayed and taps on 48 Hours button");

				ATUReports.add("Verify that Hourly page is displayed and tap on 48 Hours button",false);
				logger.log(LogStatus.PASS, "Verify that Hourly page is displayed and tap on 48 Hours button");
				HourlySteps=HourlySteps+1;
				Ad.findElementByName(" 48 Hours").click();
				 
				Boolean loaded = true;
				HourlySteps=HourlySteps+1;
				MobileElement AdEle =(MobileElement) Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]");
						//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]");

				
				WebDriverWait wait = new WebDriverWait(Ad, 4);
				wait.until(ExpectedConditions.visibilityOf(AdEle));
			
				if(AdEle.isDisplayed())
				{
					
					System.out.println("Ad is displayed on Extended Hourly page");

					ATUReports.add("Ad is displayed on Extended Hourly page",false);
					logger.log(LogStatus.PASS, "Ad is displayed on Extended Hourly pag");
					//Ad.findElement(By.name("navControl backArrow")).click();
					//Thread.sleep(1000);

				}break;

			}else
			{
				HourlySteps=HourlySteps+1;
				JavascriptExecutor js = (JavascriptExecutor) Ad ;
				HashMap<String, String> scrollObject = new HashMap<String, String>();
				scrollObject.put("direction", "down");
				js.executeScript("mobile: scroll", scrollObject);

			}
		}
		HourlySteps=0;
		reporter.endTest(logger);
		reporter.flush();
	}
}
