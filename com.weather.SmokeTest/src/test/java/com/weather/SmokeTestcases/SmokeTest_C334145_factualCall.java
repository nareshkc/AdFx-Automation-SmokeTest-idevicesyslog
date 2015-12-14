package com.weather.SmokeTestcases;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import io.appium.java_client.MobileElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
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
public class SmokeTest_C334145_factualCall extends Driver {

	@SuppressWarnings("deprecation")
	public void verify_facualcal_onfresh_launch() throws InterruptedException, IOException
	{
		FactSteps=1;
		ExtentReports reporter = Driver.getInstance();
		logger = reporter.startTest("Verify Factual Call test case").assignCategory("Smoke_Test");
		logger.log(LogStatus.PASS, "Started Factual Call Testcase");
		//reading filr from Propery file
		 Driver.property();
			PropertyFile.property();

		ATUReports.add("Launch the app",false);
		logger.log(LogStatus.PASS, "Launch the app");
		//run command for getting logs in idevicesyslog.log
		String[] str ={"/bin/bash", "-c", "/usr/local/bin/idevicesyslog.log  >>"+ properties.getProperty("LogFilePath")};
		Process p = Runtime.getRuntime().exec(str);


		FactSteps=FactSteps+1;
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

				// parse strLine to obtain what you want /
				//System.out.println (strLine);
				sb.append(strLine);

			}
			ATUReports.add("Verify the Factual values(FAUD,FGEO) in Feed_1 Call",false);
			logger.log(LogStatus.PASS, "Verify the Factual values(FAUD,FGEO) in Feed_1 Call");
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
					//Verify Faud Value
					String faudValue ;

					if(entryKeys.getKey().contains("faud"))
					{ 
						faudValue = entryKeys.getValue();
						FactSteps=FactSteps+1;
					Assert.assertNotNull(faudValue);

					System.out.println("faud values are :" + faudValue);
					
						System.out.println("FAUD value is present");
						ATUReports.add("FAUD value is present",false);
						logger.log(LogStatus.PASS, "FAUD value is present");
					


					}

					//Verify Fgeo Value
					String fgeoValue;
					if(entryKeys.getKey().contains("fgeo"))
					{   
						fgeoValue = entryKeys.getValue();
						FactSteps=FactSteps+1;
					Assert.assertNotNull(fgeoValue);

					System.out.println("fgeo vaues are :" + fgeoValue);
					
						System.out.println("FGEO value is present");
						ATUReports.add("FGEO value is present",false);
						logger.log(LogStatus.PASS, "FGEO value is present");

					

					}



				}

			}
			FactSteps=0;
			br.close();
//			reporter.endTest(logger);
//			reporter.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}



		System.out.println("Verification of FactualCall test case done");
		
		reporter.endTest(logger);
		reporter.flush();
	}
	
	
	
}
