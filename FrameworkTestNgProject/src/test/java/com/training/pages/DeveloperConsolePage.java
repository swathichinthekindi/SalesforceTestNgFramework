package com.training.pages;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import com.training.base.BasePage;

public class DeveloperConsolePage extends BasePage {

	public DeveloperConsolePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//a[text() = 'Developer Console']")
	WebElement developer;
	
	
////	public void ClickOnDeveloperConsole() {
//		waitforElement(20,developer);
//		clickObj(developer,"Developer link");
//		System.out.println(" Test Pass: Force.com Developer Console window is Opened");
//		
////		for(String handle:driver.getWindowHandles()) { // window handlers are used for  switch to other window
////			driver.switchTo().window(handle);
////	}
////	driver.close();
//		
//		Set<String> getAllWindows=driver.getWindowHandles();
//		String[] window=getAllWindows.toArray(new String[getAllWindows.size()]);
//	driver.switchTo().window(window[1]).close();
//		
//	System.out.println(" Test Pass: Force.com Developer Console window is Closed");
//
//	}
	
	public void DeveloperConsoleWindow() {
		
		waitforElement(20,developer);
		clickObj(developer,"Developer link");
		System.out.println(" Test Pass: Force.com Developer Console window is Opened");
		String parentTitle = driver.getTitle();
		System.out.println(parentTitle);
		String parentwindow = driver.getWindowHandle();
		
		for(String handle:driver.getWindowHandles()) { // window handlers are used for  switch to other window
		driver.switchTo().window(handle);
		}
		String childwindow = driver.getTitle();
		System.out.println(childwindow);
		
		if(childwindow.equalsIgnoreCase("Developer Console")) {
			driver.close();
		}
		driver.switchTo().window(parentwindow);
		System.out.println("Test pass: Developer Console window close");
		String currentwindow = driver.getTitle();
		System.out.println( "Curent window title is : " +currentwindow);
		
	}
}
