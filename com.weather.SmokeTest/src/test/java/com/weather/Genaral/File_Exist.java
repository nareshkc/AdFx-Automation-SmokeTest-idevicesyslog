package com.weather.Genaral;
import java.io.File;


public class File_Exist {

	public boolean fileexist()
	{
		File f = new File("/Users/aparna/Documents/log.log");
		if(f.exists() && !f.isDirectory()) { 
		   System.out.println("File Exist to run");
		   return true;
		}else
		{
			System.out.println("File not existed yet");
			return false;
		}
	}
}
