package com.training.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.Utilities.CommonUtilities;
import com.training.base.BaseTest;
import com.training.pages.DeveloperConsolePage;
import com.training.pages.HomePage;
import com.training.pages.LoginPage;
import com.training.pages.MyProfilePage;
import com.training.pages.MySettingPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomeTest extends BaseTest {
	
	WebDriver driver;
	String url;
	String  browser;
	String email;
	String password;
	String lastname;
	String selectfile;
	CommonUtilities common = new CommonUtilities();
	LoginPage login;
	HomePage home;
	MyProfilePage myprofile;
	MySettingPage mySetting;
	DeveloperConsolePage developer;
	@BeforeMethod
	public void beforeMethod() throws Exception {
		url = common.getproperty("url");
		browser = common.getproperty("Browser");
		email = common.getproperty("email");
		password = common.getproperty("password");
		lastname =common.getproperty("lastname");
		selectfile = common.getproperty("selectfile");
		driver = getDriver(browser);
		driver.get(url);
		login = new LoginPage(driver);// creating the parameterize constructor here
		home = new HomePage(driver);
		myprofile = new MyProfilePage(driver);
		mySetting = new MySettingPage(driver);
		developer = new DeveloperConsolePage(driver);
		
	}
	@Test
	public void usernameDropdownTC5() {
		login.enterIntoEmil(email);
		login.EnterIntoPassword(password);
		login.clickOnLogin();
		home.HomeUserDropdown();
		home.userDropDownMenulist();
		
	}
	
	@Test
	public void myProfilefromUserDropDownTC6() throws InterruptedException  {
		login.enterIntoEmil(email);
		login.EnterIntoPassword(password);
		login.clickOnLogin();
		home.HomeUserDropdown();
		home.userDropDownMenulist();
		myprofile.clickonMyProfile();
		myprofile.clickOnEditProfile();
    	myprofile.SwitchToIframeofAbout();
		myprofile.ClickonAboutButton();
		myprofile.EnterLastname(lastname);
		myprofile.ClickonSaveALl();
		myprofile.postlink();
		myprofile.SwitchToIframeOfPost();
		myprofile.entertextOnPost();
		myprofile.clickOnshareButton();
		myprofile.clickOnFileButton();
		myprofile.uploadFileFromTheComputer();
		myprofile.chooseFile(selectfile);
		myprofile.clickOnshare() ;
		myprofile.ClickOnAddPhoto();
		myprofile.SwitchToIframeOfaddphoto();
		myprofile.chooseFiletouploadphoto(selectfile);
		myprofile.svaeimage();
		myprofile.photocrop();
		myprofile.savebutton();
	}
	
	
	@Test
	public void MySettingfromUserMenuDropdownTC7() throws InterruptedException {
		login.enterIntoEmil(email);
		login.EnterIntoPassword(password);
		login.clickOnLogin();
		home.HomeUserDropdown();
		home.userDropDownMenulist();
		mySetting.ClickOnMySettings();
		mySetting.ClickOnPersonalink();
		mySetting.clickonloginHistorylink();
		mySetting.DownloadLoginHistory();
		mySetting.clickonDispayAndLayoutlink();
		mySetting.customizeMyTabLink();
		mySetting.customAppAndSalesforceChatter();
		mySetting.reportstab();
		mySetting.addreport();
		mySetting.ClickOnEmailLink();
		mySetting.ClickOnMyemailSettings();
		mySetting.provideEmailInformation();
		mySetting.ClickOnCalender();
		mySetting.clickOnActivityReminder();
		mySetting.OpenATestRemenderButton();
		mySetting.swtchToPoP();
	} 
	@Test
	public void DeveloperConsolFromUserMenuDropDownTC8() {
		login.enterIntoEmil(email);
		login.EnterIntoPassword(password);
		login.clickOnLogin();
		home.HomeUserDropdown();
		home.userDropDownMenulist();
		//developer.ClickOnDeveloperConsole();
		developer.DeveloperConsoleWindow();
		
	
	}	
	
	@Test
	public void  LogoutFromserMenuDropDownTC9() {
		login.enterIntoEmil(email);
		login.EnterIntoPassword(password);
		login.clickOnLogin();
		home.HomeUserDropdown();
		home.userDropDownMenulist();
		home.ClickOnLogout();
	//	home.validatesalesforcepage();
		

		
		
	
	}
	
	@AfterMethod
	public void teardown() {
		takescreenshort(driver);
		driver.close();
	}
	

	
	
	
	
	

}
