package com.weather.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.weather.Genaral.DeleteFile;
import com.weather.Genaral.File_Exist;
import com.weather.SmokeTestcases.SmokeTest_c334150_Verify_onpulltorefresh;
import com.weather.driver.Driver;
import com.weather.driver.PropertyFile;

public class Capabilities extends Driver {
	
	@SuppressWarnings("deprecation")
	public void dcap() throws InterruptedException, IOException {
		CapSteps=1;

		ExtentReports reporter = Driver.getInstance();
		logger = reporter.startTest("Starting the appium server and Setting the capabilities").assignCategory("Configurations");
		logger.log(LogStatus.PASS, "Starting the appium server");

		
		//Appium auto start
		Start_Stop_AppiumServer appiumStart = new Start_Stop_AppiumServer();
		System.out.println("Stopping the appium server");
		appiumStart.stopAppiumServer();
		System.out.println("Appium server is stopped");
		//Thread.sleep(10000);
		System.out.println("Starting the appium server");
		appiumStart.startAppiumServer();
		System.out.println("Appium server is started and running");
		//Thread.sleep(50000);
		CapSteps=CapSteps+1;
		//Capabilities
		ATUReports.add("Setting the Capabilities of the iOS device and version",false);
		
		logger.log(LogStatus.PASS, "Appium server is started");

		//Read from PropertyFile
		Driver.property();
		PropertyFile.property();

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("platformVersion", "8.4");
		capabilities.setCapability("platform", "Mac");
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "iOS");
		capabilities.setCapability("device","iPhone");
		capabilities.setCapability("bundleId", "com.weather.TWC");
		capabilities.setCapability("deviceName","="+properties.getProperty("Device1"));
		//"="+properties.getProperty("Device1") );

		//capabilities.setCapability("deviceName", "=iPhone 6 (9.1) [caea71833e3ca5e0adb5070514485bdeb8827951]");
		//=iPhone 6 (9.1) [caea71833e3ca5e0adb5070514485bdeb8827951]");
		//	capabilities.setCapability("deviceName", "iPod");
		//		capabilities.setCapability("udid","="+properties.getProperty("udid"));
		//capabilities.setCapability("app", properties.getProperty("appPath"));
		capabilities.setCapability("appPackage", "com.weather.Weather");
		capabilities.setCapability("appActivity", "com.weather.Weather.app.SplashScreenActivity");
		capabilities.setCapability("newCommandTimeout", 100000);
		capabilities.setCapability("autoAcceptAlerts",true);
		System.out.println("Capabilities done");
		Thread.sleep(50000);
		CapSteps=CapSteps+1;
		Ad = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		Ad.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		System.out.println("Working fine");

		ATUReports.add("Platfom Version is :: "+ properties.getProperty("platformVersion"),false);
		ATUReports.add("Device Name is :: "+ properties.getProperty("deviceName"),false);
		ATUReports.add("UDID of the Device is :: "+ properties.getProperty("udid"),false);

		//System.out.println("logfile is ::"+properties.getProperty("LogFilePath"));
		//Driver found
		CapSteps=CapSteps+1;
		System.out.println("Found the Device/Simulator");


		System.out.println("Capabilities are launched");
		CapSteps=0;
//		ATUReports.add("Capabilities are set up and running",false);
		
		logger.log(LogStatus.PASS, "Capabilites are set and running");
		
//		DeleteFile DF = new DeleteFile();
//		File_Exist FE = new File_Exist();
//		if(FE.fileexist()) {
//			DF.deleteFile();
//
//		} else {
//			System.out.println("File not exist");
//		}

//		
		reporter.endTest(logger);
		reporter.flush();
		System.out.println("Capabilities testcases done");

	}
	
	
}