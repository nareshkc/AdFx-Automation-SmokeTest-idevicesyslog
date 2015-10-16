package com.weather.Genaral;

import io.appium.java_client.MobileElement;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;

import atu.testng.reports.ATUReports;

import com.weather.driver.Driver;

public class firstRun extends Driver{

	@SuppressWarnings("deprecation")
	public void first_Run() throws InterruptedException
	{
		String originalContext = Ad.getContext();
		Ad.context("NATIVE_APP");
		ATUReports.add("Launching the app",false);

		try
		{
			// Get a handle to the open alert, prompt or confirmation
			//		Alert alert = Ad.switchTo().alert();
			//		System.out.println("Alert is :"+alert.getText());
			//		alert.accept();

			Ad.findElement(By.name("OK")).click();
			ATUReports.add("Alert is present and clicking on accept button", false);

		}   // try
		catch (NoAlertPresentException Ex)
		{
			System.out.println("Alert is not appeared");
			ATUReports.add("Alert is not presented ", false);

		}   catch (NoSuchElementException Ex)
		{  
			System.out.println("Element is not present");
			ATUReports.add("Element is not present handled through Try catch ", false);
		}  
		
		
		//Enable LBS
		
		ATUReports.add("Launching the app",false);
		
		//Verify Location is found or not
		try
		{
			String text = Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]/UIAStaticText[1]").getText();
			System.out.println("The Text is ::"+text);
			
			if(text.contains("No Saved Locations"))
			{
				//Verify LBS is on of of
			    Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[4]").click();
			    Ad.findElementByClassName("UIAButton").click();
//			    MobileElement FMF = (MobileElement) Ad.findElementByName("Follow Me Forecast, Weather for your current location");
//			    FMF.
			    
			    if(Ad.findElementByName("Follow Me Forecast, Weather for your current location").isSelected())
			    {
			    	System.out.println("LBS is already enabled");
			    	
			    }else
			    {
			    	Ad.findElementByName("Follow Me Forecast, Weather for your current location").click();
			    	System.out.println("LBS is enabled");
			    }
				
			    //Ad.findElementByName("menu icon").click();
			    Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[1]").click();
			    //Ad.findElementByName("add icon").click();
			  Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[4]").click();
			    
				Ad.findElementByClassName("UIASearchBar").click();
				Ad.findElementByClassName("UIASearchBar").sendKeys("10016");

				Thread.sleep(2000);

				Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]/UIAStaticText[1]").click();
				ATUReports.add("Current Location not found and entering User location", true);
			}
		}catch(NoSuchElementException e)
		{
			System.out.println("Element not found");
			ATUReports.add("Element not fount", false);
		}
		
		try{
			MobileElement Address = (MobileElement) Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIACollectionView[1]/UIACollectionCell[3]/UIAStaticText[1]");
			System.out.println("Address is ::"+Address.getText());
			if(!Address.isDisplayed())
			{
				//Click on + icon
				Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[4]").click();
				Ad.findElementByClassName("UIASearchBar").click();
				Ad.findElementByClassName("UIASearchBar").sendKeys("10016");
				Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]/UIAStaticText[1]").click();
				ATUReports.add("Current Location not found and entering User location", true);
			}else{
				System.out.println("Address Found ::"+Address.toString());
			}
		}catch(NoSuchElementException e)
		{
			System.out.println("Address is present");
		}
		
	}   
}


