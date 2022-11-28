package com.training.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.Utilities.CommonUtilities;
import com.training.base.BaseTest;
import com.training.pages.HomePage;
import com.training.pages.LeadPage;
import com.training.pages.LoginPage;

public class LeadTest extends BaseTest {
	
	WebDriver driver;
	String url;
	String  browser;
	String email;
	String password;
	CommonUtilities common = new CommonUtilities();
	LoginPage login;
	HomePage home;
	LeadPage lead;
	
	
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
		lead = new LeadPage(driver);
	}	
	
	@Test
	public void LeadsTabTC20() {
		login.enterIntoEmil(email);
		login.EnterIntoPassword(password);
		login.clickOnLogin();
		lead.HomePageDisplayed();
		lead.clickleadTabLinkFromHomePage();
		lead.LinkNavigateToLeadHomePage();
		
	}
		
	@Test
	public void leadsSelectViewTC21() {
		login.enterIntoEmil(email);
		login.EnterIntoPassword(password);
		login.clickOnLogin();
		lead.HomePageDisplayed();
		lead.clickleadTabLinkFromHomePage();
		lead.clickOnLeadDropdownlisthandle();
		
		
	}
	@Test
	public void defaultViewTC22() {
		login.enterIntoEmil(email);
		login.EnterIntoPassword(password);
		login.clickOnLogin();
		lead.HomePageDisplayed();
		lead.clickleadTabLinkFromHomePage();
		lead.clickOntodaysLead();
		lead.selectMyUnreadLead();
		home.HomeUserDropdown();
		home.userdroplogout();
		lead.salesforceLoginPageDisplay();
		login.enterIntoEmil(email);
		login.EnterIntoPassword(password);
		login.clickOnLogin();
		lead.clickleadTabLinkFromHomePage();
		lead.clickOnGoButton();	
		
	}
	
	@Test
	public void TodaysLeadTC23() {
		login.enterIntoEmil(email);
		login.EnterIntoPassword(password);
		login.clickOnLogin();
		lead.HomePageDisplayed();
		lead.clickleadTabLinkFromHomePage();
		lead.clickOnLeadDropdownlisthandle();
		lead.selectTodaysLeadfromDropdown();
		
	}
	@Test
	public void CreateNewLeadTC24() {
		login.enterIntoEmil(email);
		login.EnterIntoPassword(password);
		login.clickOnLogin();
		lead.HomePageDisplayed();
		lead.clickleadTabLinkFromHomePage();
		lead.clickOnNewbutton();
		lead.EnterTheLastname();
		lead.EnterTheCompany();
	}
	
	@AfterMethod
	public void teardown() {
		takescreenshort(driver);
		driver.close();
	}
	
}

