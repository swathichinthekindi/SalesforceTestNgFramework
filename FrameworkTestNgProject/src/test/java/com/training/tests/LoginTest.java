package com.training.tests;

import java.io.IOException;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.w3c.dom.DOMConfiguration;

import com.training.Utilities.CommonUtilities;
import com.training.Utilities.ExcelUtils;
import com.training.base.BaseTest;
import com.training.log.Log;
import com.training.pages.HomePage;
import com.training.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest extends BaseTest{
	 WebDriver driver;
	String url;
	String Browser;
	String email;
	String password;
	String wrongUN;
	String wrongPwd;
	CommonUtilities common = new CommonUtilities();
	LoginPage login;
	HomePage home;

	
	@BeforeMethod
	public void beforeMethod() throws Exception  {
		DOMConfigurator.configure("log4j.xml");

		url = common.getproperty("url");
		Browser = common.getproperty("Browser");
		email = common.getproperty("email");
		password = common.getproperty("password");
		 wrongUN = common.getproperty("wrongUN");
		 wrongPwd = common.getproperty("wrongpwd");
		

		driver = getDriver(Browser);
		Log.info("Url of the aplication" +url);
		driver.get(url);
		System.out.println("Test Pass: login page opened");
		login = new LoginPage(driver);// creating the parameterize constructor here
		home = new HomePage(driver);
		Log.startTestCase("Test1");

	}
	
@Test(enabled = false)	
public void loginErrorMessageTc1() {
	
		login.enterIntoEmil(email);
		login.clearPassword();
		login.clickOnLogin();
		login.errorMessage();
		

}

@Test(dataProvider = "login")
public void LogintoSalesforceTC2(String Username, String Password) {
	Log.info("Starting the TestCase");
	Log.info("Username Entered" +Username);
	Log.info("Password Entered" +Password);
	
	
	login.enterIntoEmil(Username);
	login.EnterIntoPassword(Password);
	Log.info("Entered Password Successfully");
	login.clickOnLogin();
	Log.info("Ending the TestCAse login with Valid username");
	home.HomeUserDropdown();

}

@Test(enabled = false)
public void CheckRememberMeTC3() {
	login.enterIntoEmil(email);
	login.EnterIntoPassword(password);
	login.SelectCheckbox();
	login.clickOnLogin();
	home.HomeUserDropdown();
	home.userdroplogout();
    login.validateUsername();
}
@Test(enabled = false)
public void testForgotPasswordTC4A() {
	login.enterIntoEmil(email);
	login.ForgotPassword();
	login.provideUsername(email);
	login.clickContinuebutton();
	login.checkyourResetMessage();
	
}

//@Test(dataProvider="Wornglogin")

public void validatelogginErrorMessageTC4B(String wrngUsername, String wrngPassword) {
	login.enterIntoEmil(wrngUsername);
	login.EnterIntoPassword(wrngPassword);
	login.clickOnLogin();
	login.wronglogin();
	
}

@DataProvider
public Object[][] login() throws IOException{
  Object[][] logintestArray =  ExcelUtils.getTableArray("C:\\Users\\swath\\Downloads\\ExelSheetfile.xlsx", "Login", 1);
return logintestArray;
}

@DataProvider
public Object[][] Wornglogin() throws IOException{
  Object[][] logintestArray =  ExcelUtils.getTableArray("C:\\Users\\swath\\Downloads\\ExelSheetfile.xlsx", "Login", 2);
return logintestArray;
}



@AfterMethod
public void teardown() {
	Log.endTestCase("Test1");
	takescreenshort(driver);
	driver.close();
}



}
