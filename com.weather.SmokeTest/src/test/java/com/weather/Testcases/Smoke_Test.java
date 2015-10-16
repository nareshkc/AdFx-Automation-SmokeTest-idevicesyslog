package com.weather.Testcases;



import com.weather.Genaral.DeleteFile;
import com.weather.Genaral.File_Exist;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumDriver;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;

import com.weather.appium.Capabilities;
import com.weather.driver.Driver;
import com.weather.Genaral.Clear_logs;
import com.weather.Genaral.Verify_FlexOverlay;
import com.weather.Genaral.app_Kill_Relaunch;
import com.weather.Genaral.firstRun;
import com.weather.SmokeTestcases.SmokeTest_C334145_factualCall;
import com.weather.SmokeTestcases.SmokeTest_C334146_Hourly;
import com.weather.SmokeTestcases.SmokeTest_C334148_News;
import com.weather.SmokeTestcases.SmokeTest_C334151_10Days;
import com.weather.SmokeTestcases.SmokeTest_c334143_CleanLaunch;
import com.weather.SmokeTestcases.SmokeTest_c334144_Verify_WeatheFX_ApiCall;
import com.weather.SmokeTestcases.SmokeTest_c334147_Map;
import com.weather.SmokeTestcases.SmokeTest_c334150_Verify_onpulltorefresh;
import com.weather.SmokeTestcases.SmokeTest_c334153_Verify_Lotame_onApp_Launch;


@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
	MethodListener.class })

public class Smoke_Test extends Driver{

	{
		System.setProperty("atu.reporter.config", "./atu.properties"); 
	}
	@Test 
	public void FirstRun() throws ParseException, IOException, InterruptedException
	{
		firstRun FR =new firstRun();
		FR.first_Run();


	}
	//Pull to refresh
	@Test (priority=1, threadPoolSize = 1,invocationCount = 1)
	public void c334150_pulltoRefresh() throws ParseException, IOException, InterruptedException
	{

		SmokeTest_c334150_Verify_onpulltorefresh c334150 = new SmokeTest_c334150_Verify_onpulltorefresh();
		c334150.Verify_PulltoRefresh();
	}
//
//	// Facual cal 
//	@Test(priority=2, threadPoolSize = 1,invocationCount = 1)
//	public void c334145_factualCall_onfreshlaunch() throws Exception{
//		SmokeTest_C334145_factualCall c334145 = new SmokeTest_C334145_factualCall();
//		c334145.verify_facualcal_onfresh_launch();
//
//	}
//
//	//Weather FX Cal
//	@Test(priority=3, threadPoolSize = 1,invocationCount = 1)
//	public void c334144_verify_WeatheFX_ApiCal() throws Exception {
//		SmokeTest_c334144_Verify_WeatheFX_ApiCall c334144 = new SmokeTest_c334144_Verify_WeatheFX_ApiCall();
//		c334144.Verify_WeatherFX_Apicall();
//
//	} 
//
//	//			 Lotame call
//	@Test(priority=4, threadPoolSize = 1,invocationCount = 1)
//	public void c334153_lotame_call_verify() throws Exception
//	{
//		SmokeTest_c334153_Verify_Lotame_onApp_Launch c334153 = new SmokeTest_c334153_Verify_Lotame_onApp_Launch();
//		c334153.Verify_Lotamecall_onapp_launch();
//
//	}
//
//
//	//Clean launch
//	@Test(priority=5, threadPoolSize = 1,invocationCount = 1)
//	public void c334143_verify_adcals_on_clean_launch() throws Exception {
//		SmokeTest_c334143_CleanLaunch c334143 = new SmokeTest_c334143_CleanLaunch();
//		c334143.verify_adcals_onclean_launch();
//	}
//
//	//Hourly add
//	@Test(priority=6, threadPoolSize = 1,invocationCount = 1 )
//	public void c334146_Verify_adon_HourlyExtended_page() throws Exception {
//		SmokeTest_C334146_Hourly c334146 = new SmokeTest_C334146_Hourly();
//		c334146.verify_adpresent_onextendedHourly_page();
//
//	}
//
//	//10 Days page ad
//	@Test(priority=7, threadPoolSize = 1,invocationCount = 1)
//	public void c334151_Verify_adon_10DaysExtended_page() throws Exception {
//
//		SmokeTest_C334151_10Days c334151 = new SmokeTest_C334151_10Days();
//		c334151.verify_adpresent_onextendedTendays_page();
//
//	}
//	//	Maps page ad
//	@Test(priority=8, threadPoolSize = 1,invocationCount = 1)
//	public void c334147_Verify_adon_MapsExtended_page() throws Exception {
//
//		SmokeTest_c334147_Map c334147 = new SmokeTest_c334147_Map();
//		c334147.verify_adpresent_onextendedMap_page();
//
//	}
//	//News Page ad	
//	@Test(priority=9, threadPoolSize = 1,invocationCount = 1)
//	public void c334148_Verify_adon_NewsExtended_page() throws Exception {
//
//		SmokeTest_C334148_News c334148 = new SmokeTest_C334148_News();
//		c334148.verify_adpresent_onextendedMap_page();
//
//	}



	//	   


	@SuppressWarnings("deprecation")
	@BeforeClass
	public void beforeClass() throws Exception {
		//     String iOSVersion,deviceName;
		//		
		//		properties.load(this.getClass().getClassLoader().getResourceAsStream("/Users/aparna/Documents/Naresh/com.weather.SmokeTest/DataFile.Properties"));
		//		
		//		iOSVersion = properties.getProperty("platformVersion");
		//		
		//	    deviceName = properties.getProperty("platformVersion");
		//		
		//ATUReports.indexPageDescription = "<h1>iOS Smoke Test Report </h1> <br/> <h2>On "+ deviceName +" with iOS Version" +iOSVersion+"</h2>";

		ATUReports.add("Setting IndexPageDescription : ",false);

		ATUReports.indexPageDescription = "<h1>iOS Smoke Test Report </h1>";

		ATUReports.setAuthorInfo("Appium", "Test", "Report");

		ATUReports.currentRunDescription = "<h1>Smoke Tests - Detailed Report with Pie Chart</h1>";

	}

	@SuppressWarnings("deprecation")
	@BeforeTest
	public void beforeTest() throws Exception {
		Capabilities cap = new Capabilities();
		cap.dcap();
		ATUReports.add("Capabilities are set up and launching the app",false);
		//Delete the log existed file
		DeleteFile DF = new DeleteFile();
		File_Exist FE = new File_Exist();
		if(FE.fileexist()) {
			DF.deleteFile();

		} else {
			System.out.println("File not exist");
		}


		//		app_Kill_Relaunch akr = new app_Kill_Relaunch();
		//		akr.Kill_realaunch();
		//		Verify_FlexOverlay Flex = new Verify_FlexOverlay();
		//		Flex.Verify_Flex();
	}

	@SuppressWarnings("deprecation")
	@AfterTest
	public void afterTest() throws FileNotFoundException {
		//Ad.quit();
		ATUReports.add("Killing the app",false);

	}

}
