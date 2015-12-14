package com.weather.SmokeTestcases;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.weather.Genaral.MoveTo_TestMode;
import com.weather.appium.Capabilities;
import com.weather.driver.Driver;

public class SmokeTest_C414339_Thirdparty_Beacon extends Driver{
	public static List<String> container1 = new ArrayList<String>();
	public static List<String> container = new ArrayList<String>();
	public void Thirdpart()throws IOException, InterruptedException
	{
		System.out.println("Case Started");




//		//app set to Test mode
//		MoveTo_TestMode MTT = new MoveTo_TestMode();
//		MTT.testmode();
//
//		Capabilities cap = new Capabilities();
//		cap.dcap();
//		Thread.sleep(3000);
//		//Select Addresss
//		//Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[3]").click();
//		System.out.println("Searching for address");
//		try{
//		Ad.findElementByClassName("UIASearchBar").click();
//		Ad.findElementByClassName("UIASearchBar").sendKeys("94128");
//
//		Thread.sleep(2000);
//		Ad.findElementByName("Search").click();
//		//Ad.navigate().back();
//
//
//		Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]").click();
//		Thread.sleep(3000);    //UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]
//		System.out.println("Address entered and searched");
//		}catch (Exception e){
//			System.out.println("Address already presented");
//		}
		
		//run command for getting logs in idevicesyslog.log
//		String[] str ={"/bin/bash", "-c", "/usr/local/bin/idevicesyslog  >>" +properties.getProperty("LogFilePath")};
//		Process p = Runtime.getRuntime().exec(str);
//		Thread.sleep(5000);

		//LotameSteps=//LotameSteps+1;
		BufferedReader r = new BufferedReader(new FileReader(properties.getProperty("LogFilePath")));

		String line = "";
		String allLine = "";

		while((line=r.readLine()) != null)
		{
			System.out.println("Sys data is ::"+line);

		}


		String FilePath = properties.getProperty("LogFilePath");;
		//Users/aparna/Desktop/syslog1.log";

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


			//Get sg values form pub ad call
			String [] splitWords=sb.toString().split("Get file cached background:");

			String[] testword=null;
			int count=0;
			String req1 = null ;
			StringBuffer req2= new StringBuffer();

			Map<String, Integer> occurrences = new HashMap<String, Integer>();
			for ( String word : splitWords ) {


				if ( word.contains("creativeId = (null)")||word.contains("[connected]")) {
					System.out.println("Beacon creative Id is Null");
				}else 
				{ 
					count=count+1;
					//	System.out.println("splited word is ::"+word);

					req1 = word.substring(word.indexOf("locationId ="),word.indexOf(">:")+1);
					container.add(req1);
					req2.append(req1);

				}

			}

			//			System.out.println("The container is  ::"+container);
			//			System.out.println("The counts is::"+count);
			//			System.out.println("The stringbuffer is ::"+req2.toString());

			String[] beaconarray=req2.toString().split("<Warning>");
			Map<String, String> mapkeys1 = new HashMap<String, String>();

			for(String beaconword:beaconarray){

				if(beaconword.contains("clickThru = ")){
					//System.out.println("Beacon word is ::"+beaconword);
					String[]beacon=beaconword.split(", ");
					for(String wordbeacon:beacon){
						//System.out.println("word Beacon is ::"+wordbeacon.trim());
						if(wordbeacon.contains("=")){
							String[]key=wordbeacon.split("=");
							mapkeys1.put(key[0], key[1]);
							String creativeid;
							String[]beaconkey = null;
							if(key[0].contains("creativeId")){
								String[]beaconcompare= wordbeacon.split("  ");
								for(String compare:beaconcompare){
									//System.out.println("Compare is::"+compare.toString().trim());
									String beaconlist1 =compare.toString().replace("	 thirdPartyBeacon = 	 thirdPartySurvey = 	 ", ",");
									//System.out.println("beaconlist1 is::"+beaconlist1);
									String[]arraybeacon=beaconlist1.split(",");
									Map<String, String> mapkeys2 = new HashMap<String, String>();
									for(String beaconlist:arraybeacon){

										// System.out.println("beacon list is::"+beaconlist);
										//										
										if(beaconlist.contains("=")){
											beaconkey=beaconlist.split("= ");
											mapkeys2.put(beaconkey[0], beaconkey[1]);
											String url=beaconkey[1].replace("https://adclick.g.doubleclick.net/aclk?sa=L&ai=BAUpy_1xlVqzSI4ydvgTI7IKgCOGb4bQHAAAAEAEg-bO9GzgAWPHrk9SSAmDl6uMDugEJZ2ZwX2ltYWdlyAEJwAIC4AIA6gIjLzc2NDYvdGVzdF9hcHBfaXBob25lX3VzL2Rpc3BsYXkvYmL4AoHSHoADAZADmgiYA6QDqAMB4AQBkAYBoAYf2AcA&num=0&cid=5GhPPdRtv8bng39ADd71eoSf&sig=AOD64_1SU_jn20ztYH_7m32PSaycLhFxDQ&client=ca-pub-1390600138151272&", "");

											//System.out.println("creativeid = "+beaconkey[0]+ "-----url is = "+url.replace("	 image = <UIImage: 0x170287170>", ""));


											if(beaconkey[0].contains("creativeId")){
												System.out.println("CreativeID value is::"+beaconkey[1].replace("	 thirdPartyBeacon", ""));

											}else if(beaconkey[0].contains("clickThru"))
											{

												//String url=beaconkey[1].replace("https://adclick.g.doubleclick.net/aclk?sa=L&ai=BAUpy_1xlVqzSI4ydvgTI7IKgCOGb4bQHAAAAEAEg-bO9GzgAWPHrk9SSAmDl6uMDugEJZ2ZwX2ltYWdlyAEJwAIC4AIA6gIjLzc2NDYvdGVzdF9hcHBfaXBob25lX3VzL2Rpc3BsYXkvYmL4AoHSHoADAZADmgiYA6QDqAMB4AQBkAYBoAYf2AcA&num=0&cid=5GhPPdRtv8bng39ADd71eoSf&sig=AOD64_1SU_jn20ztYH_7m32PSaycLhFxDQ&client=ca-pub-1390600138151272&", "");
												System.out.println("Ad url value is::"+url.replace("	 image = <UIImage: 0x170287170>", ""));
												System.out.println("=====================================================");
											}
										}

									}



								}


							}


						}

					}

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
