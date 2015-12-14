package com.weather.SmokeTestcases;



import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;

import atu.testng.reports.ATUReports;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.weather.driver.Driver;
import com.weather.driver.PropertyFile;
/**
 * 
 * @author Naresh
 *
 */
public class SmokeTest_c334144_Verify_WeatheFX_ApiCall extends Driver{

	public static String wfxtg ;
	public static List<String> wfxcontainer;
	
	public static List<String>  Adwfxdata ;
	public static String wfxids = null;
	public static String Currentlist[] = null;
	
	@SuppressWarnings("deprecation")
	public void Verify_WeatherFX_Apicall() throws ParseException, Exception {
		WFXSteps =1;
		ExtentReports reporter = Driver.getInstance();
		logger = reporter.startTest("Verify WFXTG Call test case").assignCategory("Smoke_Test");
		logger.log(LogStatus.PASS, "Started WFXTG Call Testcase");
		//reading filr from Propery file
		 Driver.property();
			PropertyFile.property();

		System.out.println("Case Started");

		ATUReports.add("Launch the app",false);
		logger.log(LogStatus.PASS, "Launch the app");
		WFXSteps = WFXSteps+1;
		MobileElement el = (MobileElement) Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAStaticText[2]");
		
		el.click();
		//Ad.findElementByName("_aCurTempLabel").click();
		String RightNow = Ad.findElementByName("NOW").getText();
		System.out.println("RightNow Page name is ::"+RightNow);
		ATUReports.add("Verify User on Now page",false);
		logger.log(LogStatus.PASS, "Verify User on Now page");
		//run command for getting logs in idevicesyslog.log
		String[] str ={"/bin/bash", "-c", "/usr/local/bin/idevicesyslog.log  >>"+ properties.getProperty("LogFilePath")};
		Process p = Runtime.getRuntime().exec(str);

		
		WFXSteps = WFXSteps+1;
		BufferedReader r = new BufferedReader(new FileReader(properties.getProperty("LogFilePath")));

		String line = "";
		String allLine = "";
		
		while((line=r.readLine()) != null)
		{
			System.out.println("Sys data is ::"+line);


		}

		String FilePath = properties.getProperty("LogFilePath");

		  Map<String, String> mapkeys = new HashMap<String, String>();

		//  try {
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
				 ATUReports.add("Verify the WFXTG Values in feed_1 Call",false);
				 logger.log(LogStatus.PASS, "Verify the WFXTG Values in feed_1 Call");
//				 for (int i=0; i<5)
				 if(sb.toString().contains("Requesting ad: /7646/app_iphone_us/display/feed/feed_1")){
					// System.out.println("index of first one ::::"+sb.toString().indexOf("Requesting ad: /7646/app_iphone_us/display/feed/feed_1 with parameters: {"));
					 //System.out.println("index of second one ::::"+sb.toString().indexOf("Oct  9 12:43:59 iPod TheWeather[686] <Warning>: Get"));
		      String req = sb.toString().substring( sb.toString().lastIndexOf("Requesting ad: /7646/app_iphone_us/display/feed/feed_1 with parameters: {"));
		      req = req.substring(req.indexOf("{")+1,req.indexOf("}"));
		      String[] arrays = req.split(";");
		      System.out.println("Verifying the "+req);
		      for(String keys : arrays){
		    	  System.out.println(keys);
		    	  if(keys.contains("=")){
		    		  String[] key = keys.split("=");
			    	 // System.out.println(key[0] + "---"+key[1]);
			    	  mapkeys.put(key[0], key[1]);
		    	  }
		    	  
		    	  
		      }
		      for(Entry<String, String> entryKeys : mapkeys.entrySet()){
		    	  //System.out.println("key : "+entryKeys.getKey() + "----"+"value:"+entryKeys.getValue());
		    	  
		    	  if(entryKeys.getKey().contains("wfxtg"))
		    	  {
		    		  System.out.println("wfxtg values are :" + entryKeys.getValue());
		    		  
		    		  // Assert on WFX TG value
		    		  Assert.assertNotNull(entryKeys.getValue());
		    		  
		    		  ATUReports.add("WFXTG values are present in Feed_1 Call",false);
		    		  logger.log(LogStatus.PASS, "WFXTG values are present in Feed_1 Call");
		    	  }
		    		  WFXSteps = WFXSteps+1;
		    		  //Assert.fail();
		    	  
		    	 
		      }
		 
					 }
				 WFXSteps=0;
				 br.close();
				 

//			} catch (Exception e) {
//				e.printStackTrace();
//			}

//				 reporter.endTest(logger);
//					reporter.flush();

		System.out.println("Verification of wfxtg test case done");
		
		reporter.endTest(logger);
		reporter.flush();

	}
	
	
}


