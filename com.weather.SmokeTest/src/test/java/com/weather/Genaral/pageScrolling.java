package com.weather.Genaral;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSElement;

import java.util.HashMap;
import java.util.List;

import org.openqa.jetty.html.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;

import com.weather.driver.Driver;

public class pageScrolling extends Driver {
	
	
	public static int pageSize;
	public static void Scroll() {
		
		System.out.println("Scroll starting");
		
		Dimension pagecount = Ad.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[2]")).getSize();
        System.out.println("Page sizes are :: Height "+ pagecount.getHeight() + "page Widthe is ::" + pagecount.getWidth()+ "Page length is ::" + pagecount);
        IOSElement pagenumber = (IOSElement) Ad.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[2]"));
        System.out.println("PageNumber is  :: "+ pagenumber);
        
        IOSElement Screen = (IOSElement) Ad.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]"));

		//is number of cells/rows inside table correct
		List<MobileElement> pages = Screen.findElementsByClassName("UIACollectionView");

		pageSize = pages.size();
		
		System.out.println("page Size is "+ pages.size());
		
		
		System.out.println("Scroll starting");
		
		JavascriptExecutor js = (JavascriptExecutor) Ad ;
		for(int i=1;i<=pages.size();i++)
		{
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("direction", "down");
		js.executeScript("mobile: scroll", scrollObject);

		
		}
		
	}

}
