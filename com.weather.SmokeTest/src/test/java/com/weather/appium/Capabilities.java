package com.weather.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import atu.testng.reports.ATUReports;

import com.weather.driver.Driver;

public class Capabilities extends Driver {


	@SuppressWarnings("deprecation")
	public void dcap() throws InterruptedException, IOException {

		//		//Appium auto start
		Start_Stop_AppiumServer appiumStart = new Start_Stop_AppiumServer();
		System.out.println("Stopping the appium server");
		appiumStart.stopAppiumServer();
		System.out.println("Appium server is stopped");
		//Thread.sleep(10000);
		System.out.println("Starting the appium server");
		appiumStart.startAppiumServer();
		System.out.println("Appium server is started and running");
		//Thread.sleep(50000);

		// Reading the properties file
		File file = new File("/Users/aparna/Documents/Naresh/com.weather.SmokeTest/DataFile.Properties");

		FileInputStream fileInput = null;

		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties properties = new Properties();

		//load properties file
		try {
			properties.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}

		//String Device1 = "=iPod (8.4) [707cc1d9c294b37fe5e70b7584163a100ae6166f]";
		//Capabilities
		ATUReports.add("Setting the Capabilities of the iOS device and version",false);

		DesiredCapabilities capabilities = new DesiredCapabilities();
		//capabilities.setCapability("appium-version", "1.4.8");
//		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "8.4");
		capabilities.setCapability("platform", "Mac");
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "iOS");
		capabilities.setCapability("device", "iPod");
		capabilities.setCapability("bundleId", "com.weather.TWC");
		capabilities.setCapability("deviceName","="+properties.getProperty("Device1") );
		//capabilities.setCapability("deviceName", "=iPhone 6 (8.4 Simulator) [360B61F0-0EBC-480C-B3A1-F80684FA193E]");
		capabilities.setCapability("forceIphone", true);
		
		//capabilities.setCapability("udid","707cc1d9c294b37fe5e70b7584163a100ae6166f");
		capabilities.setCapability("app", "/Users/aparna/Downloads/TheWeather.ipa");
		capabilities.setCapability("appPackage", "com.weather.Weather");
		capabilities.setCapability("appActivity", "com.weather.Weather.app.SplashScreenActivity");
		capabilities.setCapability("newCommandTimeout", 100000);
		capabilities.setCapability("autoAcceptAlerts",true);
		System.out.println("Capabilities done");
		Thread.sleep(50000);
		 Ad = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		Ad.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		System.out.println("Working fine");
		

		ATUReports.add("Platfom Version is :: "+ properties.getProperty("platformVersion"),false);
		ATUReports.add("Device Name is :: "+ properties.getProperty("deviceName"),false);
		ATUReports.add("Device Name is :: "+ properties.getProperty("udid"),false);
		//Driver found
		System.out.println("Found the Device/Simulator");

		
		System.out.println("Capabilities are launched");

		ATUReports.add("Capabilities are set up and running",false);

	}
}