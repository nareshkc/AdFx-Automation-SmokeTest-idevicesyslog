package com.weather.Testcases;



import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.weather.Genaral.DeleteFile;
import com.weather.Genaral.File_Exist;

import org.testng.ITestResult;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumDriver;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.logging.LogAs;
import atu.testng.reports.utils.Steps;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

import com.weather.appium.Capabilities;
import com.weather.appium.Install_the_app;
import com.weather.appium.movingFiles;
import com.weather.driver.Driver;
import com.weather.driver.PropertyFile;
import com.weather.Genaral.Clear_logs;
import com.weather.Genaral.Verify_FlexOverlay;
import com.weather.Genaral.app_Kill_Relaunch;
import com.weather.Genaral.firstRun;
import com.weather.SmokeTestcases.SmokeTest_C334145_factualCall;
import com.weather.SmokeTestcases.SmokeTest_C334146_Hourly;
import com.weather.SmokeTestcases.SmokeTest_C334148_News;
import com.weather.SmokeTestcases.SmokeTest_C334151_10Days;
import com.weather.SmokeTestcases.SmokeTest_C402853_Verifybigbannerad_LSModules;
import com.weather.SmokeTestcases.SmokeTest_C414339_Thirdparty_Beacon;
import com.weather.SmokeTestcases.SmokeTest_c334143_CleanLaunch;
import com.weather.SmokeTestcases.SmokeTest_c334144_Verify_WeatheFX_ApiCall;
import com.weather.SmokeTestcases.SmokeTest_c334147_Map;
import com.weather.SmokeTestcases.SmokeTest_c334150_Verify_onpulltorefresh;
import com.weather.SmokeTestcases.SmokeTest_c334153_Verify_Lotame_onApp_Launch;


@Listeners({ATUReportsListener.class, 
	MethodListener.class })

public class Smoke_Test extends Driver{

	{
	System.setProperty("atu.reporter.config", "./atu.properties"); 
	}
	
	@SuppressWarnings("deprecation")
	@Test 
	public void FirstRun() throws ParseException, IOException, InterruptedException
	{
	

		//Delete the log existed file
		DeleteFile DF = new DeleteFile();
		File_Exist FE = new File_Exist();
		if(FE.fileexist()) {
			DF.deleteFile();

		} else {
			System.out.println("File not exist");
		}
				
		//Install the app
//          Install_the_app install=new Install_the_app();
//          install.install();
//          Thread.sleep(2000);
		
          Capabilities cap = new Capabilities();
		cap.dcap();
		//ATUReports.add("Capabilities are set up and launching the app",false);
		
		
			firstRun FR =new firstRun();
			FR.first_Run();
	}



	//Pull to refresh
	@Test (priority=1, threadPoolSize = 1,invocationCount = 1)
	public void c334150_pulltoRefresh() throws Exception
	{
		//		ExtentReports reporter = Driver.getInstance();
		//		logger = reporter.startTest("Verify pull to refresh test case").assignCategory("Smoke_Test");
		SmokeTest_c334150_Verify_onpulltorefresh c334150 = new SmokeTest_c334150_Verify_onpulltorefresh();
		c334150.Verify_PulltoRefresh();	


	}


	// Facual cal 
	@Test(priority=2, threadPoolSize = 1,invocationCount = 1)
	public void c334145_factualCall_onfreshlaunch() throws Exception{
		//		ExtentReports reporter = Driver.getInstance();
		//		logger = reporter.startTest("Verify Factual Call test case").assignCategory("Smoke_Test");
		SmokeTest_C334145_factualCall c334145 = new SmokeTest_C334145_factualCall();
		c334145.verify_facualcal_onfresh_launch();

	}

	//Weather FX Cal
	@Test(priority=3, threadPoolSize = 1,invocationCount = 1)
	public void c334144_verify_WeatheFX_ApiCall() throws Exception {
		//		ExtentReports reporter = Driver.getInstance();
		//		logger = reporter.startTest("Verify Factual Call test case").assignCategory("Smoke_Test");
		SmokeTest_c334144_Verify_WeatheFX_ApiCall c334144 = new SmokeTest_c334144_Verify_WeatheFX_ApiCall();
		c334144.Verify_WeatherFX_Apicall();


	} 

	//Lotame call
	@Test(priority=4, threadPoolSize = 1,invocationCount = 1)
	public void c334153_lotame_call_verify() throws Exception
	{
		SmokeTest_c334153_Verify_Lotame_onApp_Launch c334153 = new SmokeTest_c334153_Verify_Lotame_onApp_Launch();
		c334153.Verify_Lotamecall_onapp_launch();

	}


	//Clean launch
	@Test(priority=5, threadPoolSize = 1,invocationCount = 1)
	public void c334143_verify_adcals_on_clean_launch() throws Exception {
		SmokeTest_c334143_CleanLaunch c334143 = new SmokeTest_c334143_CleanLaunch();
		c334143.verify_adcals_onclean_launch();
	}

	//Hourly add
	@Test(priority=6, threadPoolSize = 1,invocationCount = 1 )
	public void c334146_Verify_adon_HourlyExtended_page() throws Exception {
		SmokeTest_C334146_Hourly c334146 = new SmokeTest_C334146_Hourly();
		c334146.verify_adpresent_onextendedHourly_page();

	}

	//10 Days page ad
	@Test(priority=7, threadPoolSize = 1,invocationCount = 1)
	public void c334151_Verify_adon_10DaysExtended_page() throws Exception {

		SmokeTest_C334151_10Days c334151 = new SmokeTest_C334151_10Days();
		c334151.verify_adpresent_onextendedTendays_page();

	}
	//	Maps page ad
	@Test(priority=8, threadPoolSize = 1,invocationCount = 1)
	public void c334147_Verify_adon_MapsExtended_page() throws Exception {

		SmokeTest_c334147_Map c334147 = new SmokeTest_c334147_Map();
		c334147.verify_adpresent_onextendedMap_page();

	}
	
	
	
	//News Page ad	
	@Test(priority=9, threadPoolSize = 1,invocationCount = 1)
	public void c334148_Verify_adon_NewsExtended_page() throws Exception {

		SmokeTest_C334148_News c334148 = new SmokeTest_C334148_News();
		c334148.verify_adpresent_onextendedNews_page();

	}
	
	//Health Page ad	
		@Test(priority=10, threadPoolSize = 1,invocationCount = 1)
		public void C402853_Verifybigbannerad_LSModules() throws Exception {

			SmokeTest_C402853_Verifybigbannerad_LSModules C402853 = new SmokeTest_C402853_Verifybigbannerad_LSModules();
			C402853.verify_adpresent_onLSModule_page();

		}
	
	//Thirdparty Beacon
	
	@Test(priority=11, threadPoolSize = 1,invocationCount = 1)
	public void C414339_Thirdparty_Beacon() throws Exception {

		SmokeTest_C414339_Thirdparty_Beacon C414339 = new SmokeTest_C414339_Thirdparty_Beacon();
		C414339.Thirdpart();

	}
	
	


	@SuppressWarnings("deprecation")
	@BeforeClass
	public void beforeClass() throws Exception {

		
		Driver.property();
		PropertyFile.property();
		
		String	iOSVersion = properties.getProperty("platformVersion");

		String deviceName = properties.getProperty("deviceName");

		String buildVersion = properties.getProperty("buildVersion");


		System.out.println(iOSVersion+ deviceName+buildVersion);

		ATUReports.add("Setting IndexPageDescription : ",false);

		ATUReports.indexPageDescription = "<h1>iOS Smoke Test Report </h1>";

		ATUReports.setAuthorInfo("Appium", "Test", "Report");

		ATUReports.currentRunDescription = "<h1>Smoke Tests - Detailed Report with Pie Chart</h1>";
		ATUReports.indexPageDescription = "<h1>iOS Smoke Test Report </h1> <br/> <h2> "+deviceName.toString() +" on iOS Version " +iOSVersion.toString()+ " with build : "+buildVersion.toString()+ "</h2>";
 
	}

	@SuppressWarnings("deprecation")
	@BeforeTest
	public void beforeTest() throws Exception {


	}



	@SuppressWarnings("deprecation")
	@AfterMethod
	public void test (ITestResult result) throws Exception
	{ 

		if(ITestResult.FAILURE == result.getStatus())

		{ 
			SmokeTest_c334150_Verify_onpulltorefresh c334150 = new SmokeTest_c334150_Verify_onpulltorefresh();

			System.out.println("Pull to refresh - Steps Value is ::"+PulltorefreshSteps);

			if(c334150.PulltorefreshSteps==1)
			{
				//ATUReports.add("App not launched / Elements are not present", true);

				logger.log(LogStatus.FAIL, "App not launched / Elements are not present");

			}
			else if(c334150.PulltorefreshSteps==2)
			{
				//ATUReports.add("App not launched / Elements are not present ", true);
				logger.log(LogStatus.FAIL, "App not launched / Elements are not present");

			}
			else if(c334150.PulltorefreshSteps==3)
			{
				//ATUReports.add("Second element not found to relese the pull to refresh ", true);
				logger.log(LogStatus.FAIL, "App not launched / Elements are not present");

			}else if(c334150.PulltorefreshSteps==4||c334150.PulltorefreshSteps==5)
			{
				//ATUReports.add("Log File not found ", true);
				logger.log(LogStatus.FAIL, "App not launched / Elements are not present");

			}else if(c334150.PulltorefreshSteps==6)
			{
				//ATUReports.add("Branded background not found", true);
				////ATUReports.add("Fail", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
				logger.log(LogStatus.FAIL, "Branded background not found");
			}


			Capabilities cap = new Capabilities();
			System.out.println("Capablities - Steps Value is ::"+cap.CapSteps);

			if(cap.CapSteps==1)
			{
				//ATUReports.add("Capabilities are not correct ", true);
				logger.log(LogStatus.FAIL, "Capabilities are not correct");
				////ATUReports.add("Fail", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
			}else if(cap.CapSteps==2)
			{
				//ATUReports.add("A New Session not created / Remote web server is not correct ", true);
				logger.log(LogStatus.FAIL, "A New Session not created / Remote web server is not correct");
				////ATUReports.add("Fail", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
			}else if(cap.CapSteps==3)
			{
				//ATUReports.add("Device not connected / Wrong device details ", true);
				logger.log(LogStatus.FAIL, "Device not connected / Wrong device details");
				////ATUReports.add("Fail", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
			}

			firstRun FR =new firstRun();
			System.out.println("FirstRun - Steps Value is ::"+FR.FRSteps);
			if(FR.FRSteps==1)
			{
				//ATUReports.add("App not launched / Elements are not present", true);
				logger.log(LogStatus.FAIL, "App not launched / Elements are not present");

			}
			else if(FR.FRSteps==2||FR.FRSteps==5 || FR.FRSteps==8)
			{
				//ATUReports.add("+ element is not found ", true);
				logger.log(LogStatus.FAIL, "+ element is not found");

			}
			else if(FR.FRSteps==3||FR.FRSteps ==6)
			{
				//ATUReports.add("Back / Stiings Button is not found ", true);
				logger.log(LogStatus.FAIL, "Back / Stiings Button is not found");

			}else if(FR.FRSteps==4)
			{
				//ATUReports.add("LBS element is not found ", true);
				logger.log(LogStatus.FAIL, "LBS element is not found");

			}else if(FR.FRSteps==7||FR.FRSteps ==9)
			{
				//ATUReports.add("Unable to select and address in the list", true);
				logger.log(LogStatus.FAIL, "Unable to select and address in the list");

			}

			SmokeTest_C334145_factualCall c334145 = new SmokeTest_C334145_factualCall();
			System.out.println("Factual - Steps Value is ::"+c334145.FactSteps);

			if(c334145.FactSteps==1)
			{
				//ATUReports.add("App not launched / Elements are not present ", true);
				logger.log(LogStatus.FAIL, "App not launched / Elements are not present");

			}
			else if(c334145.FactSteps==2)
			{
				//ATUReports.add("App not launched / Elements are not present ", true);
				logger.log(LogStatus.FAIL, "Log File not found");

			}
			else if(c334145.FactSteps==3)
			{
				//ATUReports.add("App not launched / Elements are not present ", true);
				logger.log(LogStatus.FAIL, "faud values are not matched");

			}else if(c334145.FactSteps==4)
			{
				//ATUReports.add("App not launched / Elements are not present ", true);
				logger.log(LogStatus.FAIL, "fgeo values are not matched");

			}


			SmokeTest_c334144_Verify_WeatheFX_ApiCall c334144 = new SmokeTest_c334144_Verify_WeatheFX_ApiCall();
			System.out.println("WFXTG Call - Steps Value is ::"+c334144.WFXSteps);
			if(c334144.WFXSteps==1)
			{
				//ATUReports.add("App not launched / Elements are not present ", true);
				logger.log(LogStatus.FAIL, "App not launched / Elements are not present");

			}
			else if(c334144.WFXSteps==2)
			{
				//ATUReports.add("App not launched / Elements are not present ", true);
				logger.log(LogStatus.FAIL, "Temeperature Element not Found and user not navigate to NOW page");

			}
			else if(c334144.WFXSteps==3)
			{
				//ATUReports.add("App not launched / Elements are not present ", true);
				logger.log(LogStatus.FAIL, "Log file is not found");

			}else if(c334144.WFXSteps==4)
			{
				//ATUReports.add("App not launched / Elements are not present ", true);
				logger.log(LogStatus.FAIL, "WFXTG values are not matched");

			}


			SmokeTest_c334153_Verify_Lotame_onApp_Launch c334153 = new SmokeTest_c334153_Verify_Lotame_onApp_Launch();
			System.out.println("Lotame Call - Steps Value is ::"+c334153.LotameSteps);
			if(c334153.LotameSteps==1)
			{
				//ATUReports.add("App not launched / Elements are not present ", true);
				logger.log(LogStatus.FAIL, "App not launched / Elements are not present");

			}
			else if(c334153.LotameSteps==2)
			{
				//ATUReports.add("App not launched / Elements are not present ", true);
				logger.log(LogStatus.FAIL, "Logfile is not found");

			}
			else if(c334153.LotameSteps==3)
			{
				//ATUReports.add("App not launched / Elements are not present ", true);
				logger.log(LogStatus.FAIL, "SG Values are not found");

			}



			SmokeTest_c334143_CleanLaunch c334143 = new SmokeTest_c334143_CleanLaunch();
			System.out.println("Cleanlaunch Call - Steps Value is ::"+c334143.CleanSteps);
			if(c334143.CleanSteps==1)
			{
				//ATUReports.add("App not launched / Elements are not present ", true);
				logger.log(LogStatus.FAIL, "App not launched / Elements are not present");

			}
			else if(c334143.CleanSteps==2)
			{
				//ATUReports.add("App not launched / Elements are not present ", true);
				logger.log(LogStatus.FAIL, "App Not Launched");

			}else if(c334143.CleanSteps==3)
			{
				//ATUReports.add("App not launched / Elements are not present ", true);
				logger.log(LogStatus.FAIL, "Scree Size not found");

			}
			else if(c334143.CleanSteps==4)
			{
				//ATUReports.add("App not launched / Elements are not present ", true);
				logger.log(LogStatus.FAIL, "Temperature element not found for scroll to Now Page");

			}else if(c334143.CleanSteps==5)
			{
				//ATUReports.add("App not launched / Elements are not present ", true);
				logger.log(LogStatus.FAIL, "Log file not found");

			}else if(c334143.CleanSteps==6)
			{
				//ATUReports.add("App not launched / Elements are not present ", true);
				logger.log(LogStatus.FAIL, "Feed_0 / BB call not present");

			}else if(c334143.CleanSteps==7)
			{
				//ATUReports.add("App not launched / Elements are not present ", true);
				logger.log(LogStatus.FAIL, "Feed call is not present");

			}

			SmokeTest_C334146_Hourly c334146 = new SmokeTest_C334146_Hourly();
			System.out.println("Hourly Call - Steps Value is ::"+c334146.HourlySteps);
			if(c334146.HourlySteps==1)
			{
				//ATUReports.add("App not launched / Elements are not present ", true);
				logger.log(LogStatus.FAIL, "App not launched / Elements are not present");

			}
			else if(c334146.HourlySteps==2)
			{
				//ATUReports.add("App not launched / Elements are not present ", true);
				logger.log(LogStatus.FAIL, "Temperature element not found for scroll to Now Page");

			}else if(c334146.HourlySteps==3)
			{
				//ATUReports.add("App not launched / Elements are not present ", true);
				logger.log(LogStatus.FAIL, "Hourly Element not found");

			}
			else if(c334146.HourlySteps==4)
			{
				//ATUReports.add("App not launched / Elements are not present ", true);
				logger.log(LogStatus.FAIL, "Hourly Extended button not found");

			}else if(c334146.HourlySteps==5)
			{
				//ATUReports.add("App not launched / Elements are not present ", true);
				logger.log(LogStatus.FAIL, "Ad not present on Hourly extended page");

			}else if(c334146.HourlySteps==6)
			{
				//ATUReports.add("App not launched / Elements are not present ", true);
				logger.log(LogStatus.FAIL, "Scrolling not done");

			}


			SmokeTest_C334151_10Days c334151 = new SmokeTest_C334151_10Days();
			System.out.println("10days Call - Steps Value is ::"+c334151.TendaysSteps);
			if(c334151.TendaysSteps==1)
			{
				//ATUReports.add("App not launched / Elements are not present ", true);
				logger.log(LogStatus.FAIL, "App not launched / Elements are not present");

			}
			else if(c334151.TendaysSteps==2)
			{
				//ATUReports.add("App not launched / Elements are not present ", true);
				logger.log(LogStatus.FAIL, "Verifying 10days/Daily page not found");

			}else if(c334151.TendaysSteps==3)
			{
				//ATUReports.add("App not launched / Elements are not present ", true);
				logger.log(LogStatus.FAIL, "10 days/ Daily page extended page not found");

			}
			else if(c334151.TendaysSteps==4)
			{
				//ATUReports.add("App not launched / Elements are not present ", true);
				logger.log(LogStatus.FAIL, "Ad not present on 10Days/ Daily extended page");

			}else if(c334151.TendaysSteps==5)
			{
				//ATUReports.add("App not launched / Elements are not present ", true);
				logger.log(LogStatus.FAIL, "Scrolling not done");

			}


			SmokeTest_c334147_Map c334147 = new SmokeTest_c334147_Map();
			System.out.println("Maps page - Steps Value is ::"+c334147.MapsSteps);
			if(c334147.MapsSteps==1)
			{
				//ATUReports.add("App not launched / Elements are not present ", true);
				logger.log(LogStatus.FAIL, "App not launched / Elements are not present");

			}
			else if(c334147.MapsSteps==2)
			{
				//ATUReports.add("App not launched / Elements are not present ", true);
				logger.log(LogStatus.FAIL, "Verifying Maps page not found");

			}
			else if(c334147.MapsSteps==3)
			{
				logger.log(LogStatus.FAIL, "Verifying Map element not found");

			}else if(c334147.MapsSteps==4)
			{
				//ATUReports.add("App not launched / Elements are not present ", true);
				logger.log(LogStatus.FAIL, "Map extended page not found");

			}
			else if(c334147.MapsSteps==5)
			{
				//ATUReports.add("App not launched / Elements are not present ", true);
				logger.log(LogStatus.FAIL, "Ad not present on Map extended page");

			}else if(c334147.MapsSteps==6)
			{
				//ATUReports.add("App not launched / Elements are not present ", true);
				logger.log(LogStatus.FAIL, "Scrolling not done");

			}
			
			
			SmokeTest_C402853_Verifybigbannerad_LSModules C402853 = new SmokeTest_C402853_Verifybigbannerad_LSModules();
			
			System.out.println("Health page - Steps Value is ::"+C402853.HealthSteps);
			if(C402853.HealthSteps==1)
			{
				//ATUReports.add("App not launched / Elements are not present ", true);
				logger.log(LogStatus.FAIL, "App not launched / Elements are not present");

			}
			else if(C402853.HealthSteps==2)
			{
				//ATUReports.add("App not launched / Elements are not present ", true);
				logger.log(LogStatus.FAIL, "Verifying Health page not found");

			}
			else if(C402853.HealthSteps==3)
			{
				logger.log(LogStatus.FAIL, "Verifying Health Page not found");

			}else if(C402853.HealthSteps==4)
			{
				//ATUReports.add("App not launched / Elements are not present ", true);
				logger.log(LogStatus.FAIL, "Alergry extended page not found");

			}
			else if(C402853.HealthSteps==5)
			{
				//ATUReports.add("App not launched / Elements are not present ", true);
				logger.log(LogStatus.FAIL, "Ad not present on Allergy extended page");

			}else if(C402853.HealthSteps==6 ||C402853.HealthSteps==7)
			{
				//ATUReports.add("App not launched / Elements are not present ", true);
				logger.log(LogStatus.FAIL, "Alergry extended page not found");

			}else if(C402853.HealthSteps==8)
			{
				//ATUReports.add("App not launched / Elements are not present ", true);
				logger.log(LogStatus.FAIL, "Ad not present on Cold And Flu extended page");

			}else if(C402853.HealthSteps==15)
			{
				//ATUReports.add("App not launched / Elements are not present ", true);
				logger.log(LogStatus.FAIL, "Spotlight Ad not present on Allergy extended page");

			}else if(C402853.HealthSteps==16)
			{
				//ATUReports.add("App not launched / Elements are not present ", true);
				logger.log(LogStatus.FAIL, "Spotlight Ad not present on Cold and Flu extended page");

			}

			SmokeTest_C334148_News c334148 = new SmokeTest_C334148_News();
			System.out.println("News page - Steps Value is ::"+c334148.NewsSteps);
			if(c334148.NewsSteps==1)
			{
				//ATUReports.add("App not launched / Elements are not present ", true);
				logger.log(LogStatus.FAIL, "App not launched / Elements are not present");

			}
			else if(c334148.NewsSteps==2)
			{
				//ATUReports.add("Verifying News page not found ", true);
				logger.log(LogStatus.FAIL, "Verifying News page not found");

			}
			else if(c334148.NewsSteps==3||c334148.NewsSteps==4||c334148.NewsSteps==5||c334148.NewsSteps==6||c334148.NewsSteps==7)
			{
				//ATUReports.add("News extended button not found", true);
				logger.log(LogStatus.FAIL, "News extended button not found");

			}else if(c334148.NewsSteps==8)
			{
				//ATUReports.add("Ad not present on News extended page ", true);
				logger.log(LogStatus.FAIL, "Ad not present on News extended page");

			}
			else if(c334148.NewsSteps==9)
			{
				//ATUReports.add("Scrolling not done ", true);
				logger.log(LogStatus.FAIL, "Scrolling not done");

			}

		}
	}


	@SuppressWarnings("deprecation")
	@AfterTest
	public void afterTest() throws FileNotFoundException {
		//Ad.quit();
		reporter.endTest(logger);
		reporter.flush();
		ATUReports.add("Killing the app",false);


	}

	@SuppressWarnings({ "static-access", "deprecation" })
	@AfterSuite
	public void movefiles() throws IOException {
		movingFiles mf = new movingFiles();
		mf.movefiles();
		ATUReports.add("Moving Image and CSS Files.",false);

	}
}
