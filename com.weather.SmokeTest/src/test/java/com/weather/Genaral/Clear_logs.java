package com.weather.Genaral;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Clear_logs {

	public void clearlogs() throws FileNotFoundException
	{
		//Clear the data from log file
		PrintWriter writer = new PrintWriter("/Users/aparna/Documents/sys1.log");
		writer.print("");
		writer.close();
	}
	
}
