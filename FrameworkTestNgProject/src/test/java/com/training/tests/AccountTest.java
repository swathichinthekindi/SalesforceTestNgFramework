package com.training.tests;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.Utilities.CommonUtilities;
import com.training.base.BaseTest;
import com.training.pages.AccountPage;
import com.training.pages.LoginPage;

public class AccountTest extends BaseTest {
	WebDriver driver;
	String url;
	String Browser;
	String email;
	String password;
	String accountName;
	String accountName2;
	CommonUtilities common = new CommonUtilities();
	LoginPage login;
	AccountPage account;

	
	@BeforeMethod
	public void beforeMethod() throws Exception  {
		url = common.getproperty("url");
		Browser = common.getproperty("Browser");
		email = common.getproperty("email");
		password = common.getproperty("password");
		accountName = common.getproperty("accountName");
		accountName2 = common.getproperty("accountName2");
		driver = getDriver(Browser);
		driver.get(url);
		System.out.println("Test Pass: login page opened");
		login = new LoginPage(driver);// creating the parameterize constructor here
		account = new AccountPage(driver);
	}
	
	@Test
	public void CreateAnAccountTC10() throws InterruptedException, AWTException {
		login.enterIntoEmil(email);
		login.EnterIntoPassword(password);
		login.clickOnLogin();
		account.launchedHomePage();
		account.ClickOnAccountlinkOnHomePage();
		account.clickonNewButton();
		account.enterAccountName(accountName);
		account.selectTypeAsTechnologyPatner();
		account.selectCostomerPriority();
		account.clickOnSvae();
	}
	
	@Test
	public void CreatNewViewAccountTC11() throws InterruptedException {
		login.enterIntoEmil(email);
		login.EnterIntoPassword(password);
		login.clickOnLogin();
		account.launchedHomePage();
		account.ClickOnAccountlinkOnHomePage();
		account.clickonCreateNewViewlink();
		account.enterTheviewName();
		account.enteruniqueName();
		account.viewsave();
	}
	/**
	 * @throws InterruptedException 
	 * 
	 */
	@Test
	public void clickOnEditViewTC12() throws InterruptedException {
		login.enterIntoEmil(email);
		login.EnterIntoPassword(password);
		login.clickOnLogin();
		account.launchedHomePage();
		account.ClickOnAccountlinkOnHomePage();
		account.selectViewNameFromDropDown();
		account.clickOnEditlink();
		account.addNewViewName();
		account.enterFiledName();
		account.enterOperatorField();
		account.enterValue();
		account.clickOnSaveButton();
		
	}
	
	@Test
	public void mergeAccountsTC13() throws Exception {
		login.enterIntoEmil(email);
		login.EnterIntoPassword(password);
		login.clickOnLogin();
		account.launchedHomePage();
		account.ClickOnAccountlinkOnHomePage();
		account.clickonNewButton();
		account.enterAccountName(accountName2);
		account.selectTypeAsTechnologyPatner();
		account.selectCostomerPriority();
		account.clickOnSvae();
		account.ClickOnAccountlinkOnHomePage();
		account.clickOnMergeAccount();
		account.findAccount();
		account.selectTwoAccountsToMerge();
		account.clickOnMergeButton();
		
	}
	@Test
	public void createAccountReportTC14() throws InterruptedException {
		login.enterIntoEmil(email);
		login.EnterIntoPassword(password);
		login.clickOnLogin();
		account.launchedHomePage();
		account.ClickOnAccountlinkOnHomePage();
		account.clickonAccountsWithLastActicity30days();
		account.selectreateDataFromDataFeild();
		account.clickOnFromDate();
		account.clickOnTodayDate();
		account.cleartheTodateFeild();
		account.clickOnToDateFeild();

	 //	account.clickOnTdatDateOnToDateFeild();
		//account.clickOnSaveReport();
	}
	
	
	
	@AfterMethod
	public void teardown() {
		takescreenshort(driver);
		driver.close();
	}
		
	
	
	
	
}
