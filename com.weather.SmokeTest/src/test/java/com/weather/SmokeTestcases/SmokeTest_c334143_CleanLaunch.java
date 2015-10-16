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

import com.weather.driver.Driver;
/**
 * 
 * @author Naresh
 *
 */
public class SmokeTest_c334143_CleanLaunch extends Driver{

	@SuppressWarnings("deprecation")
	public void verify_adcals_onclean_launch() throws InterruptedException, IOException
	{


		//Scroll the app
		//pageScrolling.Scroll();
		String originalContext = Ad.getContext();
		Ad.context("NATIVE_APP");
		ATUReports.add("Launching the app",false);
		
		MobileElement Screen = (MobileElement) Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]");
		//is number of cells/rows inside table correct
		List<MobileElement> pages = Screen.findElementsByClassName("UIACollectionView");
		System.out.println("page Size is "+ pages.size());
		int x = pages.size();
		System.out.println("page size is ::"+ x);
		System.out.println("User on first page::");

		//Scroll JS
		JavascriptExecutor js = (JavascriptExecutor) Ad ;
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("direction", "down");
		//Scrolling to feed_1
		//Ad.findElementByName("_aCurTempLabel").click();
		
		ATUReports.add("Verifying ad calls on the app launch(feed_0,feed_1 to feed_n)",false);

		for(int FeedValue=0;FeedValue<=pages.size();FeedValue++)
		{
			//run command for getting logs in idevicesyslog
			String[] str ={"/bin/bash", "-c", "/usr/local/bin/idevicesyslog  >> /Users/aparna/Documents/syslog.log"};
			Process p = Runtime.getRuntime().exec(str);

			Thread.sleep(5000);
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

				if(FeedValue==0)
				{
					String req1 = sb.toString().substring( sb.toString().lastIndexOf("Network request : https://pubads.g.doubleclick.net/gampad/adx?iu=/7646/app_iphone_us/display/bb"));
					String	req = req1.substring(req1.indexOf("&")+1,req1.indexOf("fltmpc"));
					System.out.println("Request is ::"+req1);
					System.out.println("Request data is ::"+req);
					ATUReports.add("Get the Feed cal data", true);

					
					if(req1.contains("Network request : https://pubads.g.doubleclick.net/gampad/adx?iu=/7646/app_iphone_us/display/bb"))
					{
						System.out.println("Verified Branded Background  Values are present");
						ATUReports.add("BB call is Present", false);
					}else
					{
						System.out.println("Branded Background Call is not presented");
						ATUReports.add("Branded Background Call is not presented",false);
					}

				}else

					//	Getting and taking feed cals from last				
					if(sb.toString().contains("Requesting ad: /7646/app_iphone_us/display/feed/feed_"+FeedValue)){
						// System.out.println("index of first one ::::"+sb.toString().indexOf("Requesting ad: /7646/app_iphone_us/display/feed/feed_1 with parameters: {"));
						//System.out.println("index of second one ::::"+sb.toString().indexOf("Oct  9 12:43:59 iPod TheWeather[686] <Warning>: Get"));
						String req1 = sb.toString().substring( sb.toString().lastIndexOf("Requesting ad: /7646/app_iphone_us/display/feed/feed_"+FeedValue+" with parameters: {"));
						String	req = req1.substring(req1.indexOf("{")+1,req1.indexOf("}"));
						System.out.println("Request is ::"+req1);
						if(req1.contains("/7646/app_iphone_us/display/feed/feed_"+FeedValue))
						{
							System.out.println("Verified Feed_ "+FeedValue+" Values are present");
							ATUReports.add("Verified Feed_ "+FeedValue+" Values are present)",false);
						}
					}


				js.executeScript("mobile: scroll", scrollObject);
				

				System.out.println("Case Ended");
		
			//br.close();

		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}

}
}

