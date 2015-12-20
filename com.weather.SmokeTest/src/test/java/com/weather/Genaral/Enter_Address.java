package com.weather.Genaral;

import org.openqa.selenium.NoSuchElementException;

import io.appium.java_client.MobileElement;
import atu.testng.reports.ATUReports;

import com.relevantcodes.extentreports.LogStatus;
import com.weather.driver.Driver;

public class Enter_Address extends Driver{

	public void address() throws InterruptedException{
		
		String originalContext = Ad.getContext();
		Ad.context("NATIVE_APP");
//		ATUReports.add("Launching the app",false);
//		logger.log(LogStatus.PASS, "Launching the app");
		MobileElement TempEle =null;

		//verify temp element is present
		try{
			TempEle=(MobileElement) Ad.findElementByClassName("UIASearchBar");

			if(!TempEle.isDisplayed()){
				System.out.println("User On CC page");
			}else{
				TempEle.click();
				TempEle.sendKeys("10016");

				Thread.sleep(2000);
				Ad.findElementByName("Search").click();
				FRSteps = FRSteps+1;
				Thread.sleep(2000);
				Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]").click();
				Thread.sleep(2000);
			}
	}catch(NoSuchElementException e)
		{
		System.out.println("User On CC page");
		ATUReports.add("User on CC page", false);

	}
	}
	
}
