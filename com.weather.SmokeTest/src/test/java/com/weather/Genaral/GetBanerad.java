package com.weather.Genaral;

import org.openqa.selenium.By;

import com.weather.driver.Driver;

public class GetBanerad extends Driver{

	public void getadcal(){
	//click on Flex menu
			Ad.findElement(By.xpath("//UIAApplication[1]/UIAWindow[4]/UIAButton[1]")).click();


			//Click on Network option for getting network traffic
			Ad.findElement(By.xpath("//UIAApplication[1]/UIAWindow[3]/UIATableView[1]/UIATableCell[1]")).click();


			//click on search and search for pubad call
			Ad.findElement(By.xpath("//UIAApplication[1]/UIAWindow[3]/UIATableView[1]/UIASearchBar[1]")).click();

			Ad.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIATableView[1]/UIASearchBar[1]")).sendKeys("Pubads");
			Ad.findElement(By.name("Search")).click();
			
			
			//click on first ad call
			Ad.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")).click();
			
			
			//get Cust_Param value
			String cust_param = Ad.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIATableView[1]/UIATableCell[26]")).getText();
			System.out.println("Cust_Param Value is :" + cust_param);		
			
			
}
}