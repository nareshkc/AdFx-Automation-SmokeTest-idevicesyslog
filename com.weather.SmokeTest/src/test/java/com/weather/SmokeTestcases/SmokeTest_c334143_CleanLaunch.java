package com.weather.SmokeTestcases;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSElement;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import atu.testng.reports.ATUReports;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.weather.Genaral.Scroll;
import com.weather.Genaral.app_Kill_Relaunch;
import com.weather.driver.Driver;
import com.weather.driver.PropertyFile;
/**
 * 
 * @author Naresh
 *
 */
public class SmokeTest_c334143_CleanLaunch extends Driver{

	@SuppressWarnings("deprecation")
	public void verify_adcals_onclean_launch() throws Exception
	{
		CleanSteps=1;
		ExtentReports reporter = Driver.getInstance();
		logger = reporter.startTest("Verify Clean launch test case").assignCategory("Smoke_Test");
		//app kill and relaunch the app
		app_Kill_Relaunch.Kill_realaunch();
		//reading filr from Propery file
		Driver.property();
		PropertyFile.property();


		//Scroll the app
		//pageScrolling.Scroll();
		String originalContext = Ad.getContext();
		Ad.context("NATIVE_APP");
		CleanSteps=CleanSteps+1;
		ATUReports.add("Launch the app",false);
		logger.log(LogStatus.PASS, "Launch the app");
		CleanSteps=CleanSteps+1;
		MobileElement Screen = (MobileElement) Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]");
		//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIACollectionView[1]");
		//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]");
		//is number of cells/rows inside table correct
		List<MobileElement> pages = Screen.findElementsByClassName("UIACollectionView");
		System.out.println("page Size is "+ pages.size());
		int x = pages.size();
		System.out.println("page size is ::"+ x);
		System.out.println("User on first page::");

		CleanSteps=CleanSteps+1;
		//Scrolling to feed_1
		//		for(int i=1;i<=2;i++)
		//		{
		//			MobileElement el = (MobileElement) Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAStaticText["+i+"]");
		//		   
		//			System.out.println("Element el is ::"+el.getText());
		//			
		//		    if(el.getText().contains(" "))
		//		    {
		//		    	System.out.println("Allert present");
		//		    }else
		//		    {
		//		    	el.click();
		//		    	break;
		//		    }
		//		}

		MobileElement el = (MobileElement) Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAStaticText[2]");

		el.click();
		ATUReports.add("Verify ad calls on the app launch(feed_0,feed_1 to feed_n)",false);
		logger.log(LogStatus.PASS, "Verifying ad calls on the app launch(feed_0,feed_1 to feed_n");


		for(int FeedValue=0;FeedValue<=pages.size()+1;FeedValue++)
		{


			Scroll.scrolldown();
			System.out.println("Scroll done");

			//run command for getting logs in idevicesyslog
			String[] str ={"/bin/bash", "-c", "/usr/local/bin/idevicesyslog  >>" +properties.getProperty("LogFilePath")};
			Process p = Runtime.getRuntime().exec(str);

			Thread.sleep(5000);
			//System.out.println("Writing is completed  :" + p.exitValue());
			CleanSteps=CleanSteps+1;
			BufferedReader r = new BufferedReader(new FileReader(properties.getProperty("LogFilePath")));

			String line = "";
			String allLine = "";

			while((line=r.readLine()) != null)
			{
				System.out.println("Sys data is ::"+line);
			}

			String FilePath = properties.getProperty("LogFilePath");

			Map<String, String> mapkeys = new HashMap<String, String>();

			try {
				FileInputStream fstream = new FileInputStream(FilePath);
				BufferedReader br = new BufferedReader(new InputStreamReader(
						fstream));
				String strLine;
				// / read log line by line ------ strLine = br.readLines(6, 10); /
				StringBuffer sb = new StringBuffer("");
				while ((strLine = br.readLine()) != null) {

					sb.append(strLine);

				}

				//verify Feed_0 Vlaues
				if(FeedValue==0)
				{
					String req1 = sb.toString().substring( sb.toString().lastIndexOf("Network request : https://pubads.g.doubleclick.net/gampad/adx?iu=/7646/app_iphone_us/display/bb"));
					String	req = req1.substring(req1.indexOf("&")+1,req1.indexOf("fltmpc"));
					System.out.println("Request is ::"+req1);
					System.out.println("Request data is ::"+req);
					ATUReports.add("Get the Feed call data", true);


					if(req1.contains("Network request : https://pubads.g.doubleclick.net/gampad/adx?iu=/7646/app_iphone_us/display/bb"))
					{
						System.out.println("Verify Branded Background  Values are present");
						ATUReports.add("BB call is Present", false);
						logger.log(LogStatus.PASS, "BB call is Present");
					}else
					{
						CleanSteps=CleanSteps+1;
						System.out.println("Branded Background Call is not present");
						ATUReports.add("Branded Background Call is not present",false);
					}

				}else
					//	Getting and taking feed cals from last				
					if(sb.toString().contains("Requesting ad: /7646/app_iphone_us/display/feed/feed_"+FeedValue)){
						String req1 = sb.toString().substring( sb.toString().lastIndexOf("Requesting ad: /7646/app_iphone_us/display/feed/feed_"+FeedValue+" with parameters: {"));
						String	req = req1.substring(req1.indexOf("{")+1,req1.indexOf("}"));
						System.out.println("Request is ::"+req1);
						if(req1.contains("/7646/app_iphone_us/display/feed/feed_"+FeedValue))
						{
							System.out.println("Verify Feed_ "+FeedValue+" Values are present");
							ATUReports.add("Verify Feed_ "+FeedValue+" Values are present",false);
							//logger.log(LogStatus.PASS, "Verified Feed_ "+FeedValue+" Values are present");
						}else{
							CleanSteps=CleanSteps+1;
							System.out.println("Verify Feed_ "+FeedValue+" Values are not present");
							Assert.fail();
						}

					}


				//Scroll.scrolldown()
				System.out.println("Case Ended");
				CleanSteps=0;
				//br.close();

			} catch (Exception e) {
				e.printStackTrace();

			}


		}
		logger.log(LogStatus.PASS, "Verify all Feed Values are present");

		reporter.endTest(logger);
		reporter.flush();
		//		
	}
}








