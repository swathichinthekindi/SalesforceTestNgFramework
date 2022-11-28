package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.training.base.BasePage;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
		super(driver);          //we need the driver for BasePage also, for this we are using super, when you make it super, that will call parent class method i.e 'BasePage'
	}
	
	
	@FindBy(id="username")
     WebElement email;
	
	@FindBy(xpath= "//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='Login']")
	WebElement login;
	
	@FindBy(xpath="//div[@id='error']")
	WebElement Error;
	
	
	@FindBy(id="rememberUn")
	WebElement checkbox;
	
	@FindBy(xpath="//span[@id='idcard-identity']")
	WebElement validate;
	
	@FindBy(id="forgot_password_link")
	WebElement forgotPwd;
	
	@FindBy(id="un")
	WebElement enterUsername;
	
	@FindBy(id="continue")
	WebElement button;
		
	@FindBy(xpath="//h1[contains(text(),'Check Your Email')]")
	WebElement check;
	
	@FindBy(id="error")
	WebElement errormessage;
	public void enterIntoEmil(String strEmail) {
		waitforElement(10,email);
		enterText(email,strEmail,"UserName");
	}
	
	public void clearPassword() {
		password.clear();
		System.out.println("Test pass: Password feild Empty");
			
	}
	public void clickOnLogin() {
		clickObj(login,"Login");
		
		 String actualTitle = driver.getTitle();
			//driver.manage().window().maximize();
			String expectedTitle = "Home Page ~ Salesforce - Developer Edition";
			if(actualTitle.equalsIgnoreCase(expectedTitle))
				System.out.println("Home page is logged with correct Username");
			else
				System.out.println("home page is not Lunched");
			
	}
	public void errorMessage() {
		String errormsg = Error.getText();
		System.out.println("Test pass:error Message is : " +errormsg);
	}
	
	public void EnterIntoPassword(String strPwd) {
		enterText(password,strPwd,"Password");
	}
	
	
	
	public void SelectCheckbox() {
		checkBox(checkbox,"checkboxButton");
	}
	
	
	public void validateUsername() {
		waitforElement(20,validate);

		String Actualvalue = validate.getText();
		String Expectedvalue = "selenium@123.com";
		
		if(Actualvalue.equalsIgnoreCase(Expectedvalue)) {
			System.out.println("Valid UserName displayed");
			
		}
	else
		{
		
			System.out.println("Invalid UserName Displayed");
	}
		
}
	
	public void ForgotPassword() {
		waitforElement(20,password);

		clickObj(forgotPwd,"password");
		
	}
	
	public void provideUsername(String username) {
		enterText(enterUsername ,username,"Username");
	}
	
	public void clickContinuebutton() {
		clickObj(button,"clickbutton");
		
	}
	
	public void checkyourResetMessage() {
		String message = check.getText();
		System.out.println("Test pass: The paaword reset  Message page is : " +message);
		
	}
	
	public void wronglogin() {
		String errortext = errormessage.getText();
		System.out.println("Test pass:error Message is : " +errortext);
		
	}
	
	
	
	
	
	
	
	
	

}
