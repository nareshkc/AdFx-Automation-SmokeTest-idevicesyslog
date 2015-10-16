package com.weather.SmokeTestcases;

import io.appium.java_client.MobileElement;

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

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import atu.testng.reports.ATUReports;

import com.weather.driver.Driver;
/**
 * 
 * @author Naresh
 *
 */
public class SmokeTest_c334153_Verify_Lotame_onApp_Launch extends Driver {
	public static List<String> container ;
	public static String ids = null;
	@SuppressWarnings("deprecation")
	public void Verify_Lotamecall_onapp_launch() throws InterruptedException, ParseException, IOException
	{
		System.out.println("Case Started");

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

			//				 for (int i=0; i<5)
			ATUReports.add("Verifying the Lotame values(sg) in Feed_1 Call",false);
			if(sb.toString().contains("Requesting ad: /7646/app_iphone_us/display/feed/feed_1")){
				// System.out.println("index of first one ::::"+sb.toString().indexOf("Requesting ad: /7646/app_iphone_us/display/feed/feed_1 with parameters: {"));
				//System.out.println("index of second one ::::"+sb.toString().indexOf("Oct  9 12:43:59 iPod TheWeather[686] <Warning>: Get"));
				String req = sb.toString().substring( sb.toString().lastIndexOf("Requesting ad: /7646/app_iphone_us/display/feed/feed_1 with parameters: {"));
				req = req.substring(req.indexOf("{")+1,req.indexOf("}"));
				String[] arrays = req.split(";");
				System.out.println("Verifing the "+req);
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
					if(entryKeys.getKey().contains("sg"))
					{
						System.out.println("sg values are :" + entryKeys.getValue());
						ATUReports.add("sg values are presented",false);
					}

				}

			}
			br.close();

		} catch (Exception e) {
			e.printStackTrace();
		}



		System.out.println("Verifyings Lotame test case done");
	}
}
