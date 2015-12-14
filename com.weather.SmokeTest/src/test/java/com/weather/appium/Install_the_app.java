package com.weather.appium;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.weather.driver.Driver;

public class Install_the_app extends Driver{

	public void install() throws IOException, InterruptedException
	{
		Thread.sleep(3000);
		String[] str1 ={"/bin/bash", "-c", "/usr/local/bin/ideviceinstaller -l >>" +properties.getProperty("LogFilePath")};
		Process p1 = Runtime.getRuntime().exec(str1);
		BufferedReader r = new BufferedReader(new FileReader(properties.getProperty("LogFilePath")));
		
		String line = "";
		String allLine = "";

		while((line=r.readLine()) != null)
		{
			System.out.println("Sys data is ::"+line);
			if(line.contains("com.weather.TWC")){
				String[] str2 ={"/bin/bash", "-c", "/usr/local/bin/ideviceinstaller -u com.weather.TWC"};
				Process p2 = Runtime.getRuntime().exec(str2);
				System.out.println("App uninstalled in the device and trying to install the app");
				break;
			}
			System.out.println("App not installed in the device and trying to install the app");

		}


		//		String FilePath = properties.getProperty("LogFilePath");
		//
		//		Map<String, String> mapkeys = new HashMap<String, String>();
		//
		//		
		//			FileInputStream fstream = new FileInputStream(FilePath);
		//			BufferedReader br = new BufferedReader(new InputStreamReader(
		//					fstream));
		//			String strLine;
		//			// / read log line by line ------ strLine = br.readLines(6, 10); /
		//			StringBuffer sb = new StringBuffer("");
		//			while ((strLine = br.readLine()) != null) {
		//
		//				sb.append(strLine);
		//
		//			}
		//		System.out.println("Sb is ::"+sb.toString());



		String[] str ={"/bin/bash", "-c", "/usr/local/bin/ideviceinstaller -i" +properties.getProperty("appPath")};
		Process p = Runtime.getRuntime().exec(str);
		
		Thread.sleep(30000);
		System.out.println("App was installed in the device successfully");
	}

}
