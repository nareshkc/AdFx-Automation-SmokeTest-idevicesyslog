package com.weather.SmokeTestcases;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSElement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.weather.Genaral.MoveTo_TestMode;
import com.weather.Genaral.Scroll;
import com.weather.driver.Driver;

public class SmokeTest_C402853_Verifybigbannerad_LSModules  extends Driver{
	@SuppressWarnings("deprecation")

	public void verify_adpresent_onLSModule_page() throws Exception
	{
		//app set to Test mode
		MoveTo_TestMode MTT = new MoveTo_TestMode();
		MTT.testmode();

		String originalContext = Ad.getContext();
		Ad.context("NATIVE_APP");

		//Scroll object
		JavascriptExecutor js = (JavascriptExecutor) Ad ;
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("direction", "down");

		HealthSteps=1;
		ExtentReports reporter = Driver.getInstance();
		logger = reporter.startTest("Verify Health extended page test case").assignCategory("Smoke_Test");
		//ATUReports.add("Launching the app",false);
		logger.log(LogStatus.PASS, "Launching the app");

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

		//ATUReports.add("Scrolling to News Page",false);
		logger.log(LogStatus.PASS, "Scrolling to LS Module Page");

		HealthSteps=HealthSteps+1;
		//int newsloops;
		//IOSElement News = null;

		IOSElement Health = (IOSElement) Ad.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIACollectionView[1]/UIACollectionCell[10]/UIAStaticText[1]"));

		HealthSteps=HealthSteps+1;
		for(int page =1 ; page<=10;page++)
		{
			if(Health.isDisplayed())
			{   
				//Scroll.scrolldown();
				System.out.println("Health page is displayed and tapping on Allergy Tab");

				////ATUReports.add("News page is displayed and tapping on News Image",false);
				logger.log(LogStatus.PASS, "Heallth page is displayed and tapping on Allergy Tab");
				//Scroll.scrolldown();


				//Verify ad on Allergy page

				Thread.sleep(1000);
				//Ad.findElementByName("Allergy").click();
				Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIACollectionView[1]/UIACollectionCell[11]/UIAButton[1]").click();
				//Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIACollectionView[1]/UIACollectionCell[10]/UIAStaticText[4]").click();
				if(Ad.findElementByName("ALLERGIES").isDisplayed())
				{

					//run command for getting logs in idevicesyslog.log
					String[] str ={"/bin/bash", "-c", "/usr/local/bin/idevicesyslog  >>" +properties.getProperty("LogFilePath")};
					Process p = Runtime.getRuntime().exec(str);
					Thread.sleep(5000);


					logger.log(LogStatus.PASS, "Found and Navigate ALLERGIES page");

					try{
						MobileElement Spotlightad =(MobileElement) Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAWebView[1]");
						logger.log(LogStatus.PASS, "Verify Spotlight Ad on ALLERGIES page");
						if(Spotlightad.isDisplayed())
						{   
							System.out.println("ad Size is :"+Spotlightad.getSize());
							System.out.println("Spotlight Ad present on Allergies page");
							logger.log(LogStatus.PASS, "Spotlight Ad present on Allergies page");


						}else{

							System.out.println("Spotlight ad not present on Allergies page");

						}
					}catch(NoSuchElementException e)
					{       HealthSteps=15;
					System.out.println("Spotlight ad not present");
					}
					HealthSteps=4;
					Thread.sleep(5000);

					//					js.executeScript("mobile: scroll", scrollObject);
					//					js.executeScript("mobile: scroll", scrollObject);

					MobileElement el = (MobileElement) Ad.findElementByName("Breathing Comfort Forecast");
					//(MobileElement) Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[5]");
					MobileElement el1 = (MobileElement) Ad.findElementByName("BREATHING");

					TouchAction Act = new TouchAction(Ad);
					Act.longPress(el).moveTo(el1).release().perform();
					MobileElement el2 = (MobileElement) Ad.findElementByName("National Map");
					Act.longPress(el2).moveTo(el1).release().perform();

					HealthSteps=HealthSteps+1;
					MobileElement AdEle =(MobileElement) Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[5]");

					WebDriverWait wait = new WebDriverWait(Ad, 4);
					wait.until(ExpectedConditions.visibilityOf(AdEle));
					if(AdEle.isDisplayed())
					{
						System.out.println("ad Size is :"+AdEle.getSize());
						System.out.println("Ad presented on Allergies page");
						logger.log(LogStatus.PASS, "Ad presented on Allergies page");

					}else
					{
						Assert.fail();
					}
				}
				//Verify USer on Allergy page or on Home page
				try{
					if(Ad.findElementByName("navControl backArrow").isDisplayed())
					{
						Ad.findElementByName("navControl backArrow").click();
					}
				}catch(NoSuchElementException ex)
				{
					System.out.println("User on main page");
				}

				HealthSteps=HealthSteps+2;
				//Verify ad on Cold and Flu page
				//Ad.findElementByName("Cold & Flu").click();
				MobileElement cold ;
				try{
					cold =(MobileElement) Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIACollectionView[1]/UIACollectionCell[11]/UIAButton[2]");
					
					if(cold.isDisplayed()){
						cold.click();
					}else
					{
						Scroll.scrollup();
						System.out.println("scroll up for cold Module");
						cold.click();
					}
				}catch (Exception e){
					System.out.println("cold Module not loacted on the page");
				}
				
				
				if(Ad.findElementByName("COLD AND FLU").isDisplayed())
				{

					//					String[] str1 ={"/bin/bash", "-c", "/usr/local/bin/idevicesyslog  >>" +properties.getProperty("LogFilePath")};
					//					Process p1 = Runtime.getRuntime().exec(str1);
					//					Thread.sleep(5000);

					logger.log(LogStatus.PASS, "Found and Navigate Cold And Flu page");

					//Verify Spotlight ad for Col and FLU module
					try{

						MobileElement Spotlightad =(MobileElement) Ad.findElementByName("ADVERTISEMENT");
						//Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAWebView[1]");
						logger.log(LogStatus.PASS, "Verify Spotlight Ad on Cold and Flu page");
						if(Spotlightad.isDisplayed())
						{   
							System.out.println("ad Size is :"+Spotlightad.getSize());
							System.out.println("Spotlight Ad present on Cold and Flu page");
							logger.log(LogStatus.PASS, "Spotlight Ad present on Cold and Flu page");


						}else{

							System.out.println("Spotlight ad not present on Cold and Flu page");

						}}catch(NoSuchElementException e)
					{       HealthSteps=16;
					System.out.println("Spotlight ad not present");
					}
					HealthSteps=7;


					MobileElement el3 = (MobileElement) Ad.findElementByName("CDC Report");
					//(MobileElement) Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[5]");
					MobileElement el4 = (MobileElement) Ad.findElementByName("COLD AND FLU");

					TouchAction Act = new TouchAction(Ad);
					Act.longPress(el3).moveTo(el4).release().perform();	

					//js.executeScript("mobile: scroll", scrollObject);
					HealthSteps=HealthSteps+1;

					MobileElement AdEle =(MobileElement) Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[4]");

					WebDriverWait wait = new WebDriverWait(Ad, 4);
					wait.until(ExpectedConditions.visibilityOf(AdEle));
					if(AdEle.isDisplayed())
					{
						System.out.println("ad Size is :"+AdEle.getSize());
						System.out.println("Ad presented on Cold And Flu page");
						logger.log(LogStatus.PASS, "Ad presented on Cold And Flu page");


					}else
					{
						Assert.fail();
					}
				}


				break;

			}else
			{

				System.out.println("Health element is not present");

				js.executeScript("mobile: scroll", scrollObject);
				//Scroll.scrolldown();
				
			}

		}
		HealthSteps=0;
		reporter.endTest(logger);
		reporter.flush();

	}

}
