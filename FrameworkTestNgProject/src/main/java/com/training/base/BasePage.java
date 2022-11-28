package com.training.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	
     
	protected WebDriver driver;
    //method for the driver
	public BasePage(WebDriver driver) {
		this.driver = driver;
	        PageFactory.initElements(driver,this); //initializing all the elements to the driver it means associating all the elements and methods to this particular driver.for all the related pages of elements driver access will provided by writing the code in this BasePage   
		
	}
	// method for the wait for the element whenever need just call this method
	public void waitforElement(int time,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	  // Entering the text value in the textBox
	  // obj --->object
	  // textval ---> to be Entered
	 // objName --->object name
	   
	public void enterText(WebElement obj, String textval, String objName) {
		if(obj.isDisplayed())
		{
			obj.sendKeys(textval);
			System.out.println("Test Pass: "+textval + " value is enterd in " +objName + " field");
		}else
		{
		
			System.out.println("Test fail: "+objName +" feild does not exist please check application ");
	}

}
	//Click objects ---->Buttons
	 public void clickObj(WebElement obj, String objName) {
		 if(obj.isDisplayed())
		 {
			 obj.click();
			 System.out.println("Test pass: "+objName+ " button is clicked");
		 }
	 }
	 
	 //select checkbox
	 public void checkBox(WebElement obj, String objName) {
		 if(obj.isDisplayed()) 
		 {   if(obj.isSelected()) {
			 System.out.println("Test pass: "+objName +" is already selected");
		 }else
		 {
			 obj.click();
			 System.out.println("Test pass: "+objName +" is selected");
	 }}
	 else 
	 {
		System.out.println("Test fail: "+objName +" is not present please check application"); 
	 }
	 }
}
		 
	 
	

