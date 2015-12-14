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
		//MobileElement TempEle = null;

		//verify temp element is present
		//		try{
		//			//TempEle = (MobileElement)   Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAStaticText[1]");
		//
		//			//									Ad.findElementByName("_aCurTempLabel");
		//			//		                             Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAStaticText[1]");
		//
		//			if(!Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAStaticText[1]").isDisplayed())
		//			{
		//				System.out.println("User on CC page");
		//				
		//			}else{



		//Verify Location is found or not
		try
		{
			String text = Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]/UIAStaticText[1]").getText();
			System.out.println("The Text is ::"+text);
			if(text.contains("No Saved Locations"))
			{
				//Verify LBS is on or off
				//Ad.findElementByName("topNav plus").click();
				FRSteps =FRSteps+1;
				Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[4]").click();


				//Click on Settings button
				//Ad.findElementByName("Back").click();
				FRSteps =FRSteps+1;
				Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[1]").click();
				//topNav settings").click();
				//Ad.findElementByClassName("UIAButton").click();
				//			    MobileElement FMF = (MobileElement) Ad.findElementByName("Follow Me Forecast, Weather for your current location");
				//			    FMF.
				FRSteps =FRSteps+1;
				if(Ad.findElementByName("Follow Me Forecast, Weather for your current location").isSelected())
				{
					System.out.println("LBS is already enabled");

				}else
				{
					Ad.findElementByName("Follow Me Forecast, Weather for your current location").click();
					System.out.println("LBS is enabled");
				}
				FRSteps =FRSteps+1;
				//Ad.findElementByName("menu icon").click();
				Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[1]").click();
				//Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[1]").click();

				//Ad.findElementByName("add icon").click();
				//Ad.findElementByName("topNav plus").click();
				FRSteps =FRSteps+1;
				Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[3]").click();

				Ad.findElementByClassName("UIASearchBar").click();
				Ad.findElementByClassName("UIASearchBar").sendKeys("10016");

				Thread.sleep(2000);

				FRSteps = FRSteps+1;
				Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]/UIAStaticText[1]").click();
				ATUReports.add("Current Location not found and entering User location", true);
				logger.log(LogStatus.PASS, "Current Location not found and entering User location");
			}
		}catch(NoSuchElementException e)
		{
			System.out.println("User On CC page");
			ATUReports.add("User on CC page", false);
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
				FRSteps = FRSteps+1;
				Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]/UIAStaticText[1]").click();
				ATUReports.add("Current Location not found and entering User location", true);
				logger.log(LogStatus.PASS, "Current Location not found and entering User location");
			}else{
				System.out.println("Address Found ::"+Address.toString());
			}
		}catch(NoSuchElementException e)
		{
			System.out.println("Address is present");

		}
		FRSteps=0;
		//}
		reporter.endTest(logger);
		reporter.flush();


		//			
		//		}catch (NoSuchElementException e)
		//		{
		//			System.out.println("app launched successfully and user on cc page");
		//		}
	}


}


