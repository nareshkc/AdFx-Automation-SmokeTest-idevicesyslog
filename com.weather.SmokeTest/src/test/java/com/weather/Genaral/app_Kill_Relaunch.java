package com.weather.Genaral;

import com.weather.driver.Driver;

public class app_Kill_Relaunch extends Driver{
	
	public static void Kill_realaunch() throws Exception
	{
		
		//Close the app
		Ad.closeApp();
		Thread.sleep(2000);
		System.out.println("App closed successfully");
		
		//Relaunch the app
		Ad.launchApp();
		
		System.out.println("App launched successfully");
		Thread.sleep(4000);
		}

}
