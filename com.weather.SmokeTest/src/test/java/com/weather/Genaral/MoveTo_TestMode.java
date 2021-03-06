package com.weather.Genaral;

import java.io.IOException;

import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.SessionId;

import com.weather.appium.Capabilities;
import com.weather.driver.Driver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class MoveTo_TestMode extends Driver{
	
	public void testmode() throws Exception
	{
		SessionId sessionid = Ad.getSessionId();
		System.out.println("Session id is ::"+sessionid);
		
		MobileElement el = null;
		Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[1]").click();
		Thread.sleep(1000);
		try{
		 el =(MobileElement) Ad.findElementByName("My Alerts");
		}catch (Exception e){
			 el =(MobileElement) Ad.findElementByName("My Profile");
		}
		MobileElement el1 =(MobileElement) Ad.findElementByName("Units");
		
		TouchAction action1 = new TouchAction(Ad);
		action1.longPress(el1).moveTo(el).release().perform();
		Thread.sleep(1000);
		MobileElement el2=(MobileElement) Ad.findElementByName("About This App");
		el2.click();
		Thread.sleep(1000);
		for(int i=1;i<=10;i++)
		{
			Ad.findElementByName("twc logo").click();
		}
		
		Ad.findElementByName("adSource").click();
		Ad.findElementByName("test").click();
	
		Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[1]").click();
		Ad.findElementByName("Save").click();
		
		Thread.sleep(3000);
		
		//Ad.launchApp();
		//app set to Test mode
		Capabilities cap = new Capabilities();
		cap.dcap();
		Thread.sleep(5000);
		if(!Ad.findElementByClassName("UIASearchBar").isDisplayed()){
		//Select Addresss
		Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAStaticText[1]").click();
		}
		System.out.println("Searching for address");
		try{
		Ad.findElementByClassName("UIASearchBar").click();
		Ad.findElementByClassName("UIASearchBar").sendKeys("08302");

		Thread.sleep(2000);
		Ad.findElementByName("Search").click();
		//Ad.navigate().back();


		Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]/UIAStaticText[1]").click();
		Thread.sleep(3000);    
		System.out.println("Address entered and searched");
		}catch (Exception e){
			System.out.println("Address already presented");
		}
		
		
	}
	
	

}
