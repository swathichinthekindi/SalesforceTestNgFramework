package com.training.tests;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.Utilities.CommonUtilities;
import com.training.base.BaseTest;
import com.training.pages.ContactPage;
import com.training.pages.HomePage;
import com.training.pages.LoginPage;

public class ContactTest extends BaseTest {
	
	WebDriver driver;
	String url;
	String  browser;
	String email;
	String password;
	CommonUtilities common = new CommonUtilities();
	LoginPage login;
	HomePage home;
	ContactPage contact;
	

	@BeforeMethod
	public void beforeMethod() throws Exception {
		url = common.getproperty("url");
		browser = common.getproperty("Browser");
		email = common.getproperty("email");
		password = common.getproperty("password");
		
		driver = getDriver(browser);
		driver.get(url);
		login = new LoginPage(driver);// creating the parameterize constructor here
		home = new HomePage(driver);
		contact = new ContactPage(driver);
	}
	
	
	@Test
	public void CreateNewContactTC25() throws AWTException {
		login.enterIntoEmil(email);
		login.EnterIntoPassword(password);
		login.clickOnLogin();
		contact.clickOnContactTabfromHomepage();
		contact.clickOnContactNewButton();
		contact.EnterLastNameInLAstNameField();
		contact.clickOnAccountNameImagebutton();
		contact.switchtoTheAccountNamewindoow();
		contact.clickOnSave();
		
	}
	
	@Test
	public void CreateNewViewInTheContactPageTC26() {
		login.enterIntoEmil(email);
		login.EnterIntoPassword(password);
		login.clickOnLogin();
		contact.clickOnContactTabfromHomepage();
		contact.clickOnCreateNewView();
		contact.enterviewNameinviewNamefield();
		contact.enterUniqueNameinViewUniqueNamefiled();
		contact.clickOnSaveButton();
		
	}
	
	@Test
	public void CheckRecentlyCreatedContactIntheContactPageTC27() {
		login.enterIntoEmil(email);
		login.EnterIntoPassword(password);
		login.clickOnLogin();
		contact.clickOnContactTabfromHomepage();
		contact.selectRecentlyCreatedFromDropdown();
		
	}
	@Test
	public void CheckMyContactsViewinTheContactPageTC28() {
		login.enterIntoEmil(email);
		login.EnterIntoPassword(password);
		login.clickOnLogin();
		contact.clickOnContactTabfromHomepage();
		contact.clickOnmycontactsfromdropdown();
		
	}
	
	@Test
	public void ViewAContactiIntheContactPageTC29() {
		login.enterIntoEmil(email);
		login.EnterIntoPassword(password);
		login.clickOnLogin();
		contact.clickOnContactTabfromHomepage();
		contact.clickOnContactNameUnderTheNamefield();
		
		
	}
	@Test
	public void checkErrorMessageNewVieContactTC30() {
		login.enterIntoEmil(email);
		login.EnterIntoPassword(password);
		login.clickOnLogin();
		contact.clickOnContactTabfromHomepage();
		contact.clickOnCreateNewViewLInk();
		contact.enterUniqueNameinViewUniqueNamefiled();
		contact.clickOnSaveButton();
		contact.validateErrorMessage();

	}
	
	@Test
	public void ChecktheCancelButtonworksFineinCreateNewViewTC31() {
		login.enterIntoEmil(email);
		login.EnterIntoPassword(password);
		login.clickOnLogin();
		contact.clickOnContactTabfromHomepage();
		contact.clickOnCreateNewViewLInk();
		contact.enterviewNameinviewNamefield();
		contact.enterUniqueNameinViewUniqueNamefiled();
		contact.clickOnCancelButton();
	}
	
	@Test
	public void CheckTheSaveAndNewButtonWorksinNewContactpageTC32() {
		login.enterIntoEmil(email);
		login.EnterIntoPassword(password);
		login.clickOnLogin();
		contact.clickOnContactTabfromHomepage();
		contact.clickOnContactNewButton();
		contact.EnterLastNameInLAstNameField();
		contact.clickOnAccountNameImagebutton();
		contact.switchtoTheAccountNamewindoow1();
		contact.clickOnSaveNewButton();
		contact.validate();
	}
	
		
	
	
	
	
	
	
	
	
	@AfterMethod
	public void teardown() {
		takescreenshort(driver);
		driver.close();
	}
	
	

}


