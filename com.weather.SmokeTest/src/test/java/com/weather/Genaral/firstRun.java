package com.weather.Genaral;

import io.appium.java_client.MobileElement;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.testng.ITestResult;

import atu.testng.reports.ATUReports;

import com.relevantcodes.extentreports.LogStatus;
import com.weather.driver.Driver;
/**
 * 
 * @author Naresh
 *
 */
public class firstRun extends Driver{



	@SuppressWarnings("deprecation")
	public void first_Run() throws InterruptedException
	{
		FRSteps =1;
		String originalContext = Ad.getContext();
		Ad.context("NATIVE_APP");
		ATUReports.add("Launching the app",false);
		logger.log(LogStatus.PASS, "Launching the app");
		MobileElement TempEle =null;

		//verify temp element is present
		try{
			TempEle=(MobileElement) Ad.findElementByClassName("UIASearchBar");

			if(!TempEle.isDisplayed()){
				System.out.println("User On CC page");
			}else

			{

//				//	Ad.findElementByName("topNav plus").click();
//				Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[3]").click();
//				//Ad.findElementByName("topNav settings").click();
//				Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[1]").click();
//				if(Ad.findElementByName("Follow Me Forecast, Weather for your current location").isSelected())
//				{
//					System.out.println("LBS is already enabled");
//
//				}else
//				{
//					Ad.findElementByName("Follow Me Forecast, Weather for your current location").click();
//					System.out.println("LBS is enabled");
//				}
//
//				//				Ad.findElementByName("topNav settings").click();
//				//				Ad.findElementByName("topNav plus").click();
//				Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[1]").click();
//				Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[3]").click();

				TempEle.click();
				TempEle.sendKeys("10016");

				Thread.sleep(2000);
				Ad.findElementByName("Search").click();
				FRSteps = FRSteps+1;
				Thread.sleep(3000);
				List<MobileElement> Areas = Ad.findElementsByName("Search results");
				System.out.println("Areas are ::"+Areas.size());
				
				
				
				Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]").click();
				Thread.sleep(2000);   
				
				
				
				
				FRSteps =FRSteps+1;
				//Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[1]").click();
				
				ATUReports.add("Current Location not found and entering User location", true);
				logger.log(LogStatus.PASS, "Current Location not found and entering User location");
			}


			try{
				MobileElement Address = (MobileElement) Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIACollectionView[1]/UIACollectionCell[3]/UIAStaticText[1]");
				System.out.println("Address is ::"+Address.getText());
				if(!Address.isDisplayed())
				{
					//Click on + icon
					//Ad.findElementByName("topNav plus").click();
					FRSteps = FRSteps+1;
					Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[3]").click();
					Ad.findElementByClassName("UIASearchBar").click();
					Ad.findElementByClassName("UIASearchBar").sendKeys("10016");
					Ad.findElementByName("Search").click();
					FRSteps = FRSteps+1;
					Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]").click();
					ATUReports.add("Current Location not found and entering User location", true);
					logger.log(LogStatus.PASS, "Current Location not found and entering User location");
				}else{
					System.out.println("Address Found ::"+Address.toString());
				}
			}catch(NoSuchElementException e)
			{
				System.out.println("Address is present");

			}

			//}
			reporter.endTest(logger);
			reporter.flush();


		}catch(NoSuchElementException e)
		{
			System.out.println("User On CC page");
			ATUReports.add("User on CC page", false);

		}
		FRSteps=0;
	}
}
