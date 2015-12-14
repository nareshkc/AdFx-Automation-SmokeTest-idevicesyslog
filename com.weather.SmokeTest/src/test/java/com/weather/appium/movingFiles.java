package com.weather.appium;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;

import com.weather.driver.Driver;
import com.weather.driver.PropertyFile;

public class movingFiles  extends Driver{

	public static void movefiles() throws IOException {
		
		
		Driver.property();
		PropertyFile.property();

		String file1 = properties.getProperty("img1"); //"/Users/aparna/Documents/Naresh/com.weather.SmokeTest/IMG/atu.jpg";
		
		String file2 =  properties.getProperty("img2"); //"/Users/aparna/Documents/Naresh/com.weather.SmokeTest/TestReports/HTML_Design_Files/IMG/atu.jpg";
		
		String file3  = properties.getProperty("css1"); //"/Users/aparna/Documents/Naresh/com.weather.SmokeTest/IMG/design.css";
		
		String file4 =  properties.getProperty("css2"); //"/Users/aparna/Documents/Naresh/com.weather.SmokeTest/TestReports/HTML_Design_Files/CSS/design.css";
		
		File source = new File(file1);
		
		File dest = new File(file2);
		
		File css1 = new File(file3);
		
		File css2 = new File(file4);
		
		long start = System.nanoTime();
		
		long  end  = System.nanoTime();
	
        FileUtils.copyFile(source, dest);
        
		FileUtils.copyFile(css1, css2);
		
		System.out.println("Required files moved to TestReports Folder - For Reporting Purpose");
		
		//System.out.println("Time taken to move a file : "  + (end-start));
		
		//Date time = new Date(System.currentTimeMillis());
		
		//System.out.println("\n Program Ran on " + time );
	
	}

}