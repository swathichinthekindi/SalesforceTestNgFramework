package com.training.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import static com.training.Utilities.Constants.USER_DIR;
import static com.training.Utilities.Constants.FILE_SEPARATOR;
import static com.training.Utilities.Constants.APPLICATION_PROPERTIES;
// we need to import these three constants by manually which are (USER_DIR,FILE_SEPARATOR,APPLICATION_PROPERTIES)


public class CommonUtilities {
	
	public String getproperty(String key) throws IOException {
	//	Actual path spath = "C:\\Users\\swath\\eclipse-workspace\\FrameworkTestNgProject\\properties\\application.properties";
	// we are converting to the invisible information by using constants class.	
	//USER_DIR = "C:\\Users\\swath\\eclipse-workspace\\FrameworkTestNgProject
	//FILE_SEPERATOR = \\
	//	APPLICATION_PROPERTIES = properties\\application.properties
		
		//filepath
		String spath = USER_DIR+FILE_SEPARATOR+APPLICATION_PROPERTIES; //taking from the constants class.
		//fileInputStream
		FileInputStream fileinput = new FileInputStream(spath);
		Properties prop = new Properties();
		prop.load(fileinput);
		String value = prop.getProperty(key);
		return value;
		
	}

}
