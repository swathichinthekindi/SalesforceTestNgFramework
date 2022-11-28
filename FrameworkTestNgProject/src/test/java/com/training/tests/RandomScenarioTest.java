package com.training.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.Utilities.CommonUtilities;
import com.training.base.BaseTest;
import com.training.log.Log;
import com.training.pages.ContactPage;
import com.training.pages.HomePage;
import com.training.pages.LoginPage;
import com.training.pages.MyProfilePage;

public class RandomScenarioTest extends BaseTest {
	
	WebDriver driver;
	String url;
	String  browser;
	String email;
	String password;
	String lastname;
	CommonUtilities common = new CommonUtilities();
	LoginPage login;
	HomePage home;
	ContactPage contact;
	MyProfilePage myprofile;

	@BeforeMethod
	public void beforeMethod() throws Exception {
		url = common.getproperty("url");
		browser = common.getproperty("Browser");
		email = common.getproperty("email");
		password = common.getproperty("password");
		lastname =common.getproperty("lastname");
		
		driver = getDriver(browser);
		driver.get(url);
		login = new LoginPage(driver);// creating the parameterize constructor here
		home = new HomePage(driver);
		contact = new ContactPage(driver);
		myprofile = new MyProfilePage(driver);
}
	
	@Test
	public void VerifyIftheFirstnameAndLastnameofTheLoggedInUserIsDisplayTC33() throws InterruptedException {
		login.enterIntoEmil(email);
		login.EnterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnHomeTAb();
	}
	
	@Test
	public void VerifyTheEditedLastnameIsUpdatedAtVariousPlacesTC34() throws InterruptedException {
		login.enterIntoEmil(email);
		login.EnterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnHomeTabButton();
		home.clickOntheLinkOfFirstAndLastname();
		myprofile.clickonMyProfile();
		myprofile.clickOnEditProfile();
    	myprofile.SwitchToIframeofAbout();
		myprofile.ClickonAboutButton();
		myprofile.EnterLastname(lastname);
		myprofile.ClickonSaveALl();
		myprofile.validation();			
	}
	
	@Test
	public void VerifyTheTabCustomizationTC35() throws InterruptedException {
		login.enterIntoEmil(email);
		login.EnterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnPlusTab();
		home.clickOnCustomizeMyTab();
		home.removeAnyTab();
		home.clickOnSave();
		home.tabValidation();
		home.HomeUserDropdown();
		home.ClickOnLogout();
		login.enterIntoEmil(email);
		login.EnterIntoPassword(password);
		login.clickOnLogin();
				
	}
	@Test
	public void BlockingnEventInTheCalenderTC36() throws InterruptedException {
		login.enterIntoEmil(email);
		login.EnterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnHometabAndCurrentDateLink();
		home.clickon8PMlink();
		home.clickOnSubjectComboIcon();
		home.clickOnSaveButton();
		home.validationCalender();
		
		
	}
	@Test
	public void BlockingaAneEventInTheCalenderWithWeeklyRecurranceTC37() throws InterruptedException {
		login.enterIntoEmil(email);
		login.EnterIntoPassword(password);
		login.clickOnLogin();
		home.clickOnHometabAndCurrentDateLink();
		home.clickOn4Pmlink();
		home.clickOnSubjectComboIconEndTime();
		home.checkRecurrence();
		home.selectWeeklyRadioButton();
		home.selectEndDate();
		home.clickOnSaveButton();
		home.clickOnMonthViewButton();
		home.validation();

		
	}
	@AfterMethod
	public void teardown() {
		takescreenshort(driver);
		driver.close();
	}
}