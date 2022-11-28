package com.training.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import static com.training.Utilities.Constants.USER_DIR;
import static com.training.Utilities.Constants.FILE_SEPARATOR;
import static com.training.Utilities.Constants.SCREEN_PATH ;

public class BaseTest {
	private WebDriver driver;
	
	public WebDriver getDriver( String browser) {
		
		if(browser.equalsIgnoreCase("chrome")) 
		{		
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) 
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} 
		return driver;
	    
	}


public void takescreenshort(WebDriver driver2) {
	
	
	TakesScreenshot screenshot = ((TakesScreenshot)driver); // this takesScreenshot is a Interface so we are doing typeCasting. //this will take screen short
	File scrFile = screenshot.getScreenshotAs(OutputType.FILE);
	// store it in the file, since it is in the driver, so need to transfer this file into the physical location for that we need to crate one file and we need to transfer this screen shot in to that file.
	Date currentDate = new Date();
	String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(currentDate);
	
	
	//String fileseperator = System.getProperty("file.separator");
	//String reportFilePath = System.getProperty("user.dir") +fileseperator+"screenshots"; //user directory from system. 	//System.out.println(reportFilePath); // path will display	//C:\Users\swath\eclipse-workspace\FrameworkTestNgProject
   //	C:\Users\swath\eclipse-workspace\FrameworkTestNgProject\screenshots
	
	
   String reportFilePath =  USER_DIR+FILE_SEPARATOR+SCREEN_PATH;   // taking from the constants class.
    String filename = "Salesforce"+timeStamp+".png";      
	String filepath = reportFilePath +FILE_SEPARATOR+ filename; 	// this is the location we need to transfer. since this file but stored in the string so that we need to make as the file

	//actual filepath = "//C:\Users\swath\eclipse-workspace\FrameworkTestNgProject\\Screenshots\\Salesforce.png"; //salesforce"+timeStamp+".png

	
	File destFile = new File(filepath);	//so here we are converting string file  to the the file, this is the destination file for this screen short.

	try {
		FileUtils.copyFile(scrFile, destFile);// since it throw an exception so we need to do try-catch here.
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
