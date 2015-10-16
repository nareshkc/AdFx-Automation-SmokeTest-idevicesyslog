package com.weather.SmokeTestcases;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSElement;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import atu.testng.reports.ATUReports;

import com.weather.driver.Driver;
//import com.weather.excel.WriteResultintoExcel;
/**
 * 
 * @author Naresh
 *
 */
public class SmokeTest_C334146_Hourly extends Driver{

	@SuppressWarnings("deprecation")
	public void verify_adpresent_onextendedHourly_page() throws InterruptedException
	{
		//		MobileElement Screen = (MobileElement) Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]");
		//		//is number of cells/rows inside table correct
		//		List<MobileElement> pages = Screen.findElementsByClassName("UIACollectionView");
		//		System.out.println("page Size is "+ pages.size());
		Ad.closeApp();
		Thread.sleep(2000);
		Ad.launchApp();
		Thread.sleep(4000);
		System.out.println("App launched succesfully");

		ATUReports.add("Launching the app",false);

		ATUReports.add("Scrolling to Hourly Page",false);

		IOSElement hrly = (IOSElement) Ad.findElement(By.name("Hourly"));
		System.out.println("Element Name is :: Hourly" );
		//WriteResultintoExcel wResult = new WriteResultintoExcel();
		for(int page =1 ; page<=3;page++)
		{
			if(hrly.isDisplayed())
			{ 
				System.out.println("Hourly page is displyaed and tapping on MORE button");

				ATUReports.add("Hourly page is displyaed and tapping on MORE button",false);

				Ad.findElementByName("MORE").click();
				Boolean loaded = true;

				MobileElement AdEle =(MobileElement) Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]");

				WebDriverWait wait = new WebDriverWait(Ad, 4);
				wait.until(ExpectedConditions.visibilityOf(AdEle));
				//				WebDriverWait wait = new WebDriverWait(Ad, 4);
				//				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]")));

				if(AdEle.isDisplayed())
				{
					//WebDriverWait wait = new WebDriverWait(Ad,7); 
					//wait.until(ExpectedConditions.visibilityOfElementLocated((By.className("UIAImage"))));
					System.out.println("Ad is displayed on Extended Hourly page");

					ATUReports.add("Ad is displayed on Extended Hourly page",false);

				}break;

			}else
			{
				JavascriptExecutor js = (JavascriptExecutor) Ad ;
				HashMap<String, String> scrollObject = new HashMap<String, String>();
				scrollObject.put("direction", "down");
				js.executeScript("mobile: scroll", scrollObject);

			}
		}
	}
}
