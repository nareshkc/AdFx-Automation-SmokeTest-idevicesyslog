package com.weather.Genaral;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSElement;

import java.util.List;

import org.openqa.selenium.By;

import com.weather.driver.Driver;

public class Test extends Driver{

	public void verify_adcals_onclean_launch() throws InterruptedException
	{
		//Scroll the app
		//pageScrolling.Scroll();

		IOSElement Screen = (IOSElement) Ad.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]"));
		//is number of cells/rows inside table correct
		List<MobileElement> pages = Screen.findElementsByClassName("UIACollectionView");

		System.out.println("page Size is "+ pages.size());
		int x = pages.size();
		System.out.println("page size is ::"+ x);
		System.out.println("User on first page::");
		//click on Flex menu
		Ad.findElement(By.xpath("//UIAApplication[1]/UIAWindow[4]/UIAButton[1]")).click();
		//Click on Network option for getting network traffic
		Ad.findElement(By.xpath("//UIAApplication[1]/UIAWindow[3]/UIATableView[1]/UIATableCell[1]")).click();
		//click on search and search for pubad call
		Ad.findElement(By.xpath("//UIAApplication[1]/UIAWindow[3]/UIATableView[1]/UIASearchBar[1]")).click();
		Ad.getKeyboard();
		Ad.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIATableView[1]/UIASearchBar[1]")).sendKeys("pubad");
		Ad.findElement(By.name("Search")).click();
		//find total pub ad cells
		//first view in UICatalog is a table
		IOSElement table = (IOSElement) Ad.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIATableView[1]"));
		//is number of cells/rows inside table correct
		List<MobileElement> row = table.findElementsByClassName("UIATableCell");
		System.out.println("Row Size is "+ row.size());
		//String adcalname = Ad.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")).getText();
		String Cust_param;
		String iu_param;


		for(int i=1;i<=row.size();i++)
		{
			String adcalname = Ad.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")).getText();
			
			//Verify BrandedBackground call
			if(adcalname!=null && adcalname.contains("adx?iu"))
			{
				Ad.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")).click();
				//Verify iu Param
				iu_param = Ad.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIATableView[1]/UIATableCell[35]/UIAStaticText[1]")).getText();
				System.out.println("iu_param is ::"+ iu_param);
				if(iu_param.contains("bb")){
					System.out.println("BrandedBackground call is present");
				}else
				{
					System.out.println("There is no Branded Background call is present");
				}  
			}
			System.out.println("adcalname is :: "+ adcalname);
		}
		
		
		
		
	}
}
