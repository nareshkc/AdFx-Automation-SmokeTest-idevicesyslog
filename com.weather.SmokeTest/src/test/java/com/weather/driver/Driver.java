package com.weather.driver;

	import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;
import java.util.NoSuchElementException;

	import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;
	

	public class Driver extends PropertyFile {

		//protected static WebDriver driver;
		protected static AppiumDriver Ad ;
		
		
		public static int PulltorefreshSteps;
		public static int CapSteps;
		public static int FRSteps;
		public static int FactSteps;
		public static int WFXSteps;
		public static int LotameSteps;
		public static int CleanSteps;
		public static int HourlySteps;
		public static int TendaysSteps;
		public static int MapsSteps;
		public static int NewsSteps;
		public static int HealthSteps;
		
		protected static ExtentReports reporter;
		protected static ExtentTest logger;
		    
		
		//Get Date
		static Date date = new Date();
		static DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		static String dateString = dateFormat.format(date);
		
		//static int x=1;
		 static String filepath = "/Users/aparna/Documents/Naresh/com.weather.SmokeTest/ExtentReports/SmokeTest_"+dateString+".html";
	    
		public static ExtentReports getInstance() throws IOException {
			
			Driver.property();
			PropertyFile.property();
	    
			if (reporter == null) {
	        
				reporter = new ExtentReports(filepath, false);
	            
	            // Setting the Report Header, Title and Browser Name on Reports
	        	reporter.config()
	                .documentTitle("TestReport_iOS")
	                .reportName("The Weather Channel - iOS Smoke Test Report on build - "+properties.getProperty("buildVersion"))
	                .reportHeadline("iOS Smoke Test Report_Automation Report- TWC");
	          

	        	Map<String, String> sysInfo = new HashMap<String, String>();
	        	sysInfo.put("Device Name", "device");
	        	sysInfo.put("iOS Version", "ios");

	        	reporter.addSystemInfo(sysInfo);
	            
	        	// Setting the DeviceName,Version on Reports
	        	Driver.property();
	    		PropertyFile.property();
	        	reporter
	        	.addSystemInfo("Appium", properties.getProperty("appiumVersion"))
	        	.addSystemInfo("Build Version", properties.getProperty("buildVersion"))
	            .addSystemInfo("Device Name", properties.getProperty("deviceName"))
	            .addSystemInfo("iOS Version",  properties.getProperty("platformVersion"));
	        	
	        }
	        return reporter;
	    }

	}
	
