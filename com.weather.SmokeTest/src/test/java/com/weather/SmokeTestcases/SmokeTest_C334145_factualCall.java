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

import atu.testng.reports.ATUReports;

import com.weather.driver.Driver;
/**
 * 
 * @author Naresh
 *
 */
public class SmokeTest_C334145_factualCall extends Driver {

	@SuppressWarnings("deprecation")
	public void verify_facualcal_onfresh_launch() throws InterruptedException, IOException
	{

		ATUReports.add("Launching the app",false);
		//run command for getting logs in idevicesyslog.log
		String[] str ={"/bin/bash", "-c", "/usr/local/bin/idevicesyslog.log  >> /Users/aparna/Documents/syslog.log"};
		Process p = Runtime.getRuntime().exec(str);



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
			ATUReports.add("Verifying the Factual values(FAUD,FGEO) in Feed_1 Call",false);
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
					Assert.assertNotNull(faudValue);

					System.out.println("faud values are :" + faudValue);
					
						System.out.println("FAUD value is presented");
						ATUReports.add("FAUD value is presented",false);
					


					}

					//Verify Fgeo Value
					String fgeoValue;
					if(entryKeys.getKey().contains("fgeo"))
					{   
						fgeoValue = entryKeys.getValue();
					Assert.assertNotNull(fgeoValue);

					System.out.println("fgeo vaues are :" + fgeoValue);
					
						System.out.println("FGEO value is presented");
						ATUReports.add("FGEO value is presented",false);

					

					}



				}

			}
			br.close();

		} catch (Exception e) {
			e.printStackTrace();
		}



		System.out.println("Verification of FactualCall test case done");
	}
}
