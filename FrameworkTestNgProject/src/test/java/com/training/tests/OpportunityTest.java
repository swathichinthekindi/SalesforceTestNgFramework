package com.training.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.Utilities.CommonUtilities;
import com.training.base.BaseTest;
import com.training.pages.ContactPage;
import com.training.pages.HomePage;
import com.training.pages.LoginPage;
import com.training.pages.OpportunityPage;


public class OpportunityTest extends BaseTest {
	WebDriver driver;
	String url;
	String  browser;
	String email;
	String password;
	CommonUtilities common = new CommonUtilities();
	LoginPage login;
	HomePage home;
	OpportunityPage opp;
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
        opp = new OpportunityPage(driver);
        contact = new ContactPage(driver);
}
	
	@Test
	public void OpportunityDropDownsTC15() {
		login.enterIntoEmil(email);
		login.EnterIntoPassword(password);
		login.clickOnLogin();
		opp.clickOnOpportunities();
		opp.verifyOpportunitesDropdown();
	}
	
	@Test
	public void CreateNewOpportinitiesTC16() throws InterruptedException {
		login.enterIntoEmil(email);
		login.EnterIntoPassword(password);
		login.clickOnLogin();
		opp.clickOnOpportunities();
		opp.clickOnNewOppLink();
		opp.enterOpportunitiesName();
		contact.clickOnAccountNameImagebutton();
		contact.switchtoTheAccountNamewindoow();
		opp.closedate();
		opp.clickOnStage();
		opp.selectLeadSource();
		opp.clickOnPrimaryCompaign();
		opp.clickOnSave();
		opp.validationOfNewOppPage();
		
		
	}
	
	@Test
	public void TestOpportunityPipelineReportTC17() {
		login.enterIntoEmil(email);
		login.EnterIntoPassword(password);
		login.clickOnLogin();
		opp.clickOnOpportunities();
		opp.clockOnOpportunityPipelineLink();
		
	}
	
	@Test
	public void TestStuckOpportunitiesReportTC18() {
		login.enterIntoEmil(email);
		login.EnterIntoPassword(password);
		login.clickOnLogin();
		opp.clickOnOpportunities();
		opp.clickOnStuckOpportunities();
		
		
	}
	
	@Test
	public void TestQuarterlySummaryReportTC19() {
		login.enterIntoEmil(email);
		login.EnterIntoPassword(password);
		login.clickOnLogin();
		opp.clickOnOpportunities();
		opp.clickOnQuarterlySummeryREport();
		opp.chooseIntervalAsNextFQ();
		opp.chooseIncludeAsClosedOpportunities();
		opp.clockOnRunReport();
		opp.validatetheReoptpage();
	}
	
	@AfterMethod
	public void teardown() {
		takescreenshort(driver);
		driver.close();
	}
	
	
	
}
