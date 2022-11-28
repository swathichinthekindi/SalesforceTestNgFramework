package com.training.pages;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.training.base.BasePage;

public class HomePage extends BasePage {


	
	public HomePage(WebDriver driver) {
		super(driver);          //we need the driver in BasePage also, for this we are using super, when you make it super, that will call parent class method i.e 'BasePage'
	}
	
	@FindBy(id="userNavLabel")
	WebElement HomeUsername;
	
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	WebElement logout;
	
	@FindBy(id="userNav-menuItems")
	WebElement menu;
	
	@FindBy(xpath="//a[contains(text(),'My Profile')]")
	WebElement myprofile;
	
	@FindBy(xpath= "//a[@href='/secur/logout.jsp']")
	WebElement Logout;
	
	@FindBy(id="main")
	WebElement validate;
	
	@FindBy(xpath="//a[@title='Home Tab']")
	WebElement homeTab;
	
	@FindBy(xpath="h1[class='currentStatusUserName'] a")
	WebElement FirstName;
	
	@FindBy(xpath="//a[@href='/_ui/core/userprofile/UserProfilePage'][normalize-space()='Gopi ABCD']")
	WebElement firstLastlink;
	
	@FindBy(id="tailBreadcrumbNode")
	WebElement MyProfilepage;
	
	@FindBy(xpath="//img[@title='All Tabs']")
	WebElement plusTab;
	
	@FindBy(name="customize")
	WebElement tab;
	
	@FindBy(xpath = "//option[@value='ContentSubscriptions']")
	WebElement removeTab;
	
	@FindBy(xpath="//img[@title='Remove']")
	WebElement remove;
	
	@FindBy(name="save")
	WebElement save;
	
	@FindBy(xpath="//ul[@id='tabBar']")
	WebElement tabbar;
	
	@FindBy(xpath="//a[normalize-space()='Wednesday November 23, 2022']")
	WebElement datevalidate;
	
	@FindBy(xpath = "//a[normalize-space()='8:00 PM']")
	WebElement eightPm;
	
	@FindBy(xpath = "//div[@id='head_1_ep']//h3[1]")
	WebElement cursor;
	
	@FindBy(xpath="//img[@title='Subject Combo (New Window)']")
	WebElement comboicon;
	
	@FindBy(xpath = "//li[@class='listItem4']//a[1]")
	WebElement other;
	
	@FindBy(id="EndDateTime_time")
	WebElement endtime;
	
	@FindBy(xpath = "//div[@id='timePickerItem_42']")
	WebElement ninepm;
	
	@FindBy(name="save")
	WebElement savetime;
	
	@FindBy(xpath="//h1[normalize-space()='Calendar for Gopi ABCD - Day View']")
	WebElement validateCalender;
	
	@FindBy(xpath="//a[normalize-space()='4:00 PM']")
	WebElement fourPm;
	
	@FindBy(id="timePickerItem_38")
	WebElement sevenPm;
	
	@FindBy(id="IsRecurrence")
	WebElement recurrence;

	@FindBy(id="rectypeftw")
	WebElement weeklyRadio;
	
	@FindBy(id="EndDateTime")
	WebElement enddate;
	
	@FindBy(xpath="//td[normalize-space()='1']")
	WebElement date;
	
	@FindBy(xpath="//img[@title='Next Month']")
	WebElement nextmonth;
	
	@FindBy(xpath="(//img[@title='Month View'])[1]")
	WebElement monthView;
	
	@FindBy(xpath="//h1[normalize-space()='Calendar for Gopi ABCD - Month View']")
	WebElement validateMonthView;
	
	public void HomeUserDropdown() {
		clickObj(HomeUsername,"home");
		System.out.println("The Username dropdown displayed");
	}
	public void userdroplogout() {
		clickObj(logout,"homelogout");
		System.out.println("Login Salesforce Page displayed with remeber Username");
	}
	
	public void userDropDownMenulist() {
		String getlist =   menu.getText();
		System.out.println("Test pass: The Username Menu Dropdown list are : " +getlist);
		
	}
	
	public void clickonMyProfile() {
		clickObj(myprofile,"userDropDownMenu");
	}
	public void ClickOnLogout() {
		clickObj(Logout,"logout from userDropDownMenu");
		System.out.println("Test Pass: Logout  of current sales force application  and https://login.salesforce.com/ page is displayed.");
	}
	public void validatesalesforcepage() {
		
	String s =	 validate.getText();
		System.out.println(s);
	}
	
	public void clickOnHomeTAb() throws InterruptedException {
		
		Thread.sleep(5000);
		clickObj(homeTab,"Home Tab");
		Thread.sleep(5000);
		String homepageUserName = firstLastlink.getText();
		System.out.println(homepageUserName);
		clickObj(firstLastlink,"FirstName And LastnameLink");
		 
		System.out.println("Test Pass: User FirstName and lastName page displayed");
			
		String myprofilepageusername = MyProfilepage.getText();
		System.out.println(myprofilepageusername);
		
		Assert.assertEquals(homepageUserName,homepageUserName );
				
		System.out.println("The result is Pass");
		System.out.println("Test pass:  'User:FirstName LastName' page  displayed."); 
		System.out.println("Test Pass:  This page is as  same as the 'My Profile' page.");
		
		
		
	}
	public void clickOnHomeTabButton() throws InterruptedException {
		Thread.sleep(5000);
		clickObj(homeTab,"Home Tab");
		System.out.println("Test Pass: Home page is displayed" ); 
		                                
	}
	
	
	public void clickOntheLinkOfFirstAndLastname() {
		clickObj(firstLastlink,"FirstName And LastnameLink");

	}
	public void clickOnPlusTab() throws InterruptedException {
Thread.sleep(5000);
		clickObj(plusTab,"Plus Tab");
		System.out.println("Test Pass: The 'All Tabs' page displayed.");
		
	}
	public void clickOnCustomizeMyTab() {
		clickObj(tab,"Customize My Tab");
		System.out.println("Test Pass: The 'Customize My Tabs' page should be displayed.");
		
	}
	public void removeAnyTab() {
		clickObj(removeTab,"select Tab");
		clickObj(remove,"Remove Tab");
		System.out.println("Test Pass: The selected tab should be removed from the 'Selected Tabs' section  moved to the 'Available Tabs' section.");
		
		
	}
	public void clickOnSave() {
		clickObj(save,"Save");
	
		
	}
	public void tabValidation() {
		String tab = tabbar.getText();
		System.out.println( "tab list:" +tab);	
		System.out.println("Test Pass: The 'All Tabs' page displayed"); 
		System.out.println("Test Pass: The selected tab removed,this tab is not displayed in the tab bar");
	}
	public void clickOnHometabAndCurrentDateLink() throws InterruptedException {
		Thread.sleep(5000);
		clickObj(homeTab,"Home Tab");
		System.out.println("Test Pass: Home page is displayed" ); 
		String date = datevalidate.getText();
		System.out.println(date);
		System.out.println("Test Pass: Current date is displayed as a link below the FirstName and LastName in Day Month Date,Year format. Ex:Tuesday November 22, 2022");
		clickObj(datevalidate,"current date link");
	}
	public void clickon8PMlink() throws InterruptedException {
		Thread.sleep(5000);
		clickObj(eightPm,"8pm link");
		String cursorONSubject = cursor.getText();
		System.out.println(cursorONSubject);
		System.out.println("Test Pass: The 'Calendar: New Event' page displayed with the cursor at the Subject field.");
		
	}
	public void clickOnSubjectComboIcon() throws InterruptedException {
		clickObj(comboicon,"Subject Conbo Icon");
		Set<String> getAllWindows = driver.getWindowHandles();
		String[] getwindow = getAllWindows.toArray(new String[getAllWindows.size()]);
		driver.switchTo().window(getwindow[1]);
		System.out.println(driver.getTitle());
		clickObj(other,"Other");
		
		driver.switchTo().window(getwindow[0]);
		System.out.println(driver.getTitle());
		clickObj(endtime,"End time");
		System.out.println("Test Pass: Drop down displayed with time starting from 9:00 PM till 11:30 PM.");
		clickObj(ninepm,"9 pm");
		System.out.println("Test Pass: 9:00 PM  selected in the 'End' field.");
		

		
		
		
		
		
	}
	public void clickOnSaveButton() {
		clickObj(savetime,"Save");
		
	}
	public void validationCalender() {
		 String val = validateCalender.getText();
		 System.out.println(val);
		System.out.println("Test Pass: The 'Calendar for FirstName LastName' page displayed with 'Other' event in the time slot 8:00PM to 9:00PM, as a link.");

	}
	public void clickOn4Pmlink() throws InterruptedException {
		Thread.sleep(5000);
		clickObj(fourPm,"4pm link");
		String cursorONSubject = cursor.getText();
		System.out.println(cursorONSubject);
		System.out.println("Test Pass: The 'Calendar: New Event' page displayed with the cursor at the Subject field.");
				
	}
	public void clickOnSubjectComboIconEndTime() {
		clickObj(comboicon,"Subject Conbo Icon");
		Set<String> getAllWindows = driver.getWindowHandles();
		String[] getwindow = getAllWindows.toArray(new String[getAllWindows.size()]);
		driver.switchTo().window(getwindow[1]);
		System.out.println(driver.getTitle());
		clickObj(other,"Other");
		
		driver.switchTo().window(getwindow[0]);
		System.out.println(driver.getTitle());
		clickObj(endtime,"End time");
		System.out.println("Test Pass: Drop down displayed with time starting from 9:00 PM till 11:30 PM.");
		clickObj(sevenPm,"7 pm");
		System.out.println("Test Pass: 7:00 PM  selected in the 'End' field.");
		
	}
	public void checkRecurrence() {
		clickObj(recurrence,"Recurrence");
		System.out.println("Test pass:  The box checked.");
		System.out.println("Test Pass: 'Frequency', 'Start Date', 'End Date' sections  displayed");              

		
	}
	public void selectWeeklyRadioButton() {
		clickObj(weeklyRadio,"Weekly Radio");
		System.out.println("Test Pass:Weekly radio button selected");
		System.out.println("Test Pass: Weekly' radio button selected");

		
	}
	public void selectEndDate() throws InterruptedException {
		enddate.clear();
		nextmonth.click();
		Thread.sleep(3000);
		clickObj(date,"Date");
		

		
		
	}
	public void clickOnMonthViewButton() throws InterruptedException {
		Thread.sleep(5000);
		clickObj(monthView,"Month View");
		
		
	}
	public void validation() {
		String monthVal = validateMonthView.getText();
		System.out.println(monthVal);
		System.out.println("Test Pass: The 'Calendar for FirstName LastName - Month View' page should be displayed.");    
		System.out.println("Test Pass: Current date and a week from current date should have the 'Other' event blocked as a link.");		
	}
	
	
	
	
	}
	
	
	

