package com.weather.SmokeTestcases;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
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

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.weather.driver.Driver;
import com.weather.driver.PropertyFile;
/**
 * 
 * @author Naresh
 *
 */


//import com.weather.driver.PropertyFile;
@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
	MethodListener.class })

public class SmokeTest_c334150_Verify_onpulltorefresh extends Driver {


	//	ExtentReports reporter = Driver.getInstance();
	//	logger = reporter.startTest("Verify the Pull to Refresh test case").assignCategory("SMOKE TEST");



	@SuppressWarnings("deprecation")
	public void Verify_PulltoRefresh() throws IOException, InterruptedException
	{
		PulltorefreshSteps=1;
		ExtentReports reporter = Driver.getInstance();
		logger = reporter.startTest("Verify pull to refresh test case").assignCategory("Smoke_Test");
		String originalContext = Ad.getContext();
		Ad.context("NATIVE_APP");
		//Read from PropertyFilePath
		Driver.property();
		PropertyFile.property();

		
		System.out.println("enter into pull to refresh");

		ATUReports.add("Launch the app",false);
		logger.log(LogStatus.PASS, "Launch the apping");
		PulltorefreshSteps=PulltorefreshSteps+1;	
		//MobileElement el = null;
		for(int i=1;i<=2;i++)
		{
			MobileElement el = (MobileElement) Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAStaticText["+i+"]");

			System.out.println("Element el is ::"+el.getText());

			if(el.getText().contains(" "))
			{
				System.out.println("Allert present");
			}else
			{
				WebDriverWait wait = new WebDriverWait(Ad, 40);
				wait.until(ExpectedConditions.visibilityOf(el));

				ATUReports.add("On CC Screen,Temperature is found", false);

				logger.log(LogStatus.PASS, "On CC Screen,Temperature is found");

				//MobileElement el = (MobileElement) Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAStaticText[1]");
				//Ad.findElementByName("_aCurTempLabel");
				PulltorefreshSteps=PulltorefreshSteps+1;	
				int el2=i+2;
				MobileElement el1 = (MobileElement) Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAStaticText["+el2+"]");
				//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIACollectionView[1]/UIACollectionCell[1]/UIATableView[1]/UIATableCell[1]
				//Ad.findElementByName("TODAY");
				//Ad.findElementByName("_aHiLowLabel");TODAY
				//_aHiLowLabel_aWxCheckinButton");
				TouchAction action1 = new TouchAction(Ad);
				action1.longPress(el).moveTo(el1).release().perform();

				
				//run command for getting logs in idevicesyslog
				String[] str ={"/bin/bash", "-c", "/usr/local/bin/idevicesyslog  >>"+ properties.getProperty("LogFilePath")};
				//properties.getProperty("LogFilePath")+""};
				Process p = Runtime.getRuntime().exec(str);
				Thread.sleep(2000);

				System.out.println("Scroll Done");

				ATUReports.add("On CC Screen,Pull the screen to REFRESH", false);

				logger.log(LogStatus.PASS, "On CC Screen,Pull the screen to REFRESH");
				break;
			}
		}

		//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAStaticText[2]
		//Wait for 20 sec fo element presence


		//Get the BB ad and validate it

		//System.out.println("Writing is completed  :" + p.exitValue());
		PulltorefreshSteps=PulltorefreshSteps+1;
		BufferedReader r = new BufferedReader(new FileReader(properties.getProperty("LogFilePath")));

		String line = "";
		String allLine = "";

		while((line=r.readLine()) != null)
		{
			System.out.println("Sys data is ::"+line);
		}

		PulltorefreshSteps=PulltorefreshSteps+1;
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
				// parse strLine to obtain what you want /
				//System.out.println (strLine);
				sb.append(strLine);

			}

			System.out.println("Sb is  ::"+sb.toString());

//			if(!sb.toString().contains("/7646/app_iphone_us"))
//			{
//				PulltorefreshSteps=5+1;
//				System.out.println("Log data is not correct");
//				Assert.fail();
//			}

			String req1 = sb.toString().substring( sb.toString().lastIndexOf("Network request : https://pubads.g.doubleclick.net/gampad/adx?iu=/7646/app_iphone_us/display/bb"));
			String	req = req1.substring(req1.indexOf("&")+1,req1.indexOf("fltmpc"));
			System.out.println("Request is ::"+req1);
			System.out.println("Request data is ::"+req);
			ATUReports.add("Get the Feed Call Data", true);

			if(req1.contains("Network request : https://pubads.g.doubleclick.net/gampad/adx?iu=/7646/app_iphone_us/display/bb"))
			{
				System.out.println("Verified Branded Background call is present");
				ATUReports.add("Branded Background call is present and it's value is verified", false);
				logger.log(LogStatus.PASS, "Branded Background call is present and it's value is verified");
			}else
			{
				PulltorefreshSteps=PulltorefreshSteps+1;
				System.out.println("Branded Background Value is not present");
				ATUReports.add("Branded Background call is NOT presented", false);
				logger.log(LogStatus.PASS, "Branded Background call is NOT presented");
				Assert.fail();
			}


			System.out.println("Case Ended");
			PulltorefreshSteps=0;


			br.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		reporter.endTest(logger);
		reporter.flush();


	}


}


