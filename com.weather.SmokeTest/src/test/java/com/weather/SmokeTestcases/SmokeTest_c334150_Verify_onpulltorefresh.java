package com.weather.SmokeTestcases;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

import com.weather.driver.Driver;
/**
 * 
 * @author Naresh
 *
 */
@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
	MethodListener.class })
public class SmokeTest_c334150_Verify_onpulltorefresh extends Driver{

	@SuppressWarnings("deprecation")
	public void Verify_PulltoRefresh() throws IOException, InterruptedException
	{
		String originalContext = Ad.getContext();
		Ad.context("NATIVE_APP");

		//run command for getting logs in idevicesyslog
		String[] str ={"/bin/bash", "-c", "/usr/local/bin/idevicesyslog  >> /Users/aparna/Documents/syslog.log"};
		Process p = Runtime.getRuntime().exec(str);
		
		ATUReports.add("Launching the app",false);
		//Wait for 20 sec fo element presence
		WebDriverWait wait = new WebDriverWait(Ad, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("_aCurTempLabel")));
		
		ATUReports.add("On CC Screen,Temperature is found", false);
	
		MobileElement el = (MobileElement) Ad.findElementByName("_aCurTempLabel");
		MobileElement el1 = (MobileElement) Ad.findElementByName("_aHiLowLabel");
		//_aHiLowLabel_aWxCheckinButton");
		TouchAction action1 = new TouchAction(Ad);
		action1.longPress(el).moveTo(el1).release().perform();
//		ATUReports.add("Test 1", false);
//		ATUReports.add("p", LogAs.INFO, CaptureScreen(ScreenshotOf.DESKTOP));
//		ATUReports.add("q", LogAs.PASSED, CaptureScreen(ScreenshotOf.BROWSER_PAGE));
//		//ATUReports.add("r", LogAs.FAILED, CaptureScreen(ScreenshotOf.DESKTOP));
//		ATUReports.add("s", LogAs.WARNING, CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		
		System.out.println("Scroll Done");

		ATUReports.add("On CC Screen,Pulling the screen to REFRESH", false);
		
		//Get the BB ad and validate it
		
		//System.out.println("Writing is completed  :" + p.exitValue());
		BufferedReader r = new BufferedReader(new FileReader("/Users/aparna/Documents/syslog.log"));
        
		String line = "";
		String allLine = "";

		while((line=r.readLine()) != null)
		{
			System.out.println("Sys data is ::"+line);
		}

		String FilePath = "/Users/aparna/Documents/syslog.log";
	

		Map<String, String> mapkeys = new HashMap<String, String>();

		try {
			FileInputStream fstream = new FileInputStream(FilePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(
					fstream));
			String strLine;
			// / read log line by line ------ strLine = br.readLines(6, 10); /
			StringBuffer sb = new StringBuffer("");
			while ((strLine = br.readLine()) != null) {
				// parse strLine to obtain what you want /
				//System.out.println (strLine);
				sb.append(strLine);

			}
			
			System.out.println("Sb is  ::"+sb.toString());
			
			

//			if(sb.toString().contains("adx?iu/7646/app_iphone_us/display/bb")){
//				sys
//			}
			
				// System.out.println("index of first one ::::"+sb.toString().indexOf("Requesting ad: /7646/app_iphone_us/display/feed/feed_1 with parameters: {"));
				//System.out.println("index of second one ::::"+sb.toString().indexOf("Oct  9 12:43:59 iPod TheWeather[686] <Warning>: Get"));
					String req1 = sb.toString().substring( sb.toString().lastIndexOf("Network request : https://pubads.g.doubleclick.net/gampad/adx?iu=/7646/app_iphone_us/display/bb"));
					String	req = req1.substring(req1.indexOf("&")+1,req1.indexOf("fltmpc"));
					System.out.println("Request is ::"+req1);
					System.out.println("Request data is ::"+req);
					ATUReports.add("Get the Feed cal  data", true);
					
					if(req1.contains("Network request : https://pubads.g.doubleclick.net/gampad/adx?iu=/7646/app_iphone_us/display/bb"))
					{
						System.out.println("Verified Branded Background call is present");
						  ATUReports.add("Branded Background call is present and verified it's value", false);
					}else
					{
						System.out.println("Branded Background Value is not present");
						 ATUReports.add("Branded Background call is NOT presented", false);
					}


				System.out.println("Case Ended");
			
			br.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private CaptureScreen CaptureScreen(ScreenshotOf desktop) {
		// TODO Auto-generated method stub
		return null;
	}

}


