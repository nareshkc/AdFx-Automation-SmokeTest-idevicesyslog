package com.weather.Genaral;

import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.ScreenOrientation;

import com.weather.driver.Driver;

public class Verify_FlexOverlay extends Driver {

	public void Verify_Flex()
	{
//		if(Ad.findElementByName("menu").isDisplayed())
//		{
//			System.out.println("Flex is present");
//			
//		}else
//		{
		  //handle could not find your gps alert
		try{
		if(Ad.findElementByName("Could Not Find Your GPS").isDisplayed())
		{
		   Ad.findElementByName("OK").click();
		   Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[4]").click();
		}
		}catch(NoSuchElementException e)
		{
			System.out.println("Element not there");
		}
		
			//Ad.findElementByClassName("UIAButton").click();
			Ad.findElementByClassName("UIAButton").click();
			//Scroll untile the page down
			JavascriptExecutor js = (JavascriptExecutor) Ad ;
			HashMap<String, String> scrollObject = new HashMap<String, String>();
			scrollObject.put("direction", "down");
			js.executeScript("mobile: scroll", scrollObject);
			js.executeScript("mobile: scroll", scrollObject);
			
			//Tap on bottom logo
			//Ad.findElementByName("twc-logo").click();
			Ad.findElementByClassName("UIAImage").click();
			Ad.rotate(ScreenOrientation.LANDSCAPE);
			Ad.findElementByClassName("UIAImage").click();
			Ad.rotate(ScreenOrientation.PORTRAIT);
			//Click on useFlex 
			Ad.findElementByName("useFlex").click();
			if(Ad.findElementByClassName("UIASwitch").isEnabled())
			{
				Ad.findElementByName("Back").click();
			}else
			{
				Ad.findElementByClassName("UIASwitch").click();
				Ad.findElementByName("Back").click();
			}
			
			
			//CLick om useOverlay
			Ad.findElementByName("useOverlay").click();
			if(Ad.findElementByClassName("UIASwitch").isEnabled())
			{
				Ad.findElementByName("Back").click();
			}else
			{
				Ad.findElementByClassName("UIASwitch").click();
				Ad.findElementByName("Back").click();
			}
			
			//Set GPS Spoof
			Ad.findElementByName("gpsSpoof").click();
			if(Ad.findElementByClassName("UIASwitch").isEnabled())
			{
				Ad.findElementByName("Back").click();
			}else
			{
				Ad.findElementByClassName("UIASwitch").click();
				Ad.findElementByClassName("UIATextField").sendKeys("San Francisco");
				
				Ad.findElementByName("Back").click();
			}
			//Set dsxSource 
			
			Ad.findElementByName("dsxSource").click();
			Ad.findElementByName("production").click();
			
			//Set adSource
			Ad.findElementByName("adSource").click();
			Ad.findElementByName("production").click();
			
			//Click on Save Button
			Ad.findElementByName("Save").click();
			
			
			
		//}
		
		Ad.findElementByName("menu").click();
		Ad.findElementByName("📡  Network History").click();
		Ad.findElementByName("Settings").click();
		if(!Ad.findElementByName("Network Debugging").isEnabled())
		{
			Ad.findElementByName("Network Debugging").click();
		}
			
		if(Ad.findElementByName("Enable on Launch").isEnabled())
		{
			Ad.findElementByName("Done").click();
		}else
		{
			Ad.findElementByName("Enable on Launch").click();
			Ad.findElementByName("Done").click();
		}
			
		
	}
	
}
