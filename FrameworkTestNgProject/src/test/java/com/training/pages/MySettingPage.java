package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.training.base.BasePage;

public class MySettingPage extends BasePage {

	public MySettingPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//a[contains(text(),'My Setting')]")
	WebElement mySetting;
	
	@FindBy(xpath = "(//a[@class='header setupFolder'])[1]")
	WebElement personal;
	
	@FindBy(id ="LoginHistory_font")
	WebElement history;
	
	@FindBy(xpath = "//a[ @href='/servlet/servlet.LoginHistory?id=0055g00000HY7FM']")
	WebElement download;
	
	@FindBy(id="DisplayAndLayout_font")
	WebElement display;
	
	@FindBy(id="CustomizeTabs_font")
	WebElement customize;
	
	@FindBy(xpath ="//select[@id='p4']/option[9]")
	WebElement custom;
	
	//@FindBy(xpath="//option[contains(text(),'Reports')]")
	@FindBy(xpath="//select//option[contains(text(),'Reports')]")
	WebElement report;
	
	@FindBy(id="duel_select_0_right")
	WebElement add;
	
	@FindBy(id="EmailSetup_font")
	WebElement email;
	
	@FindBy(id="EmailSettings_font")
	WebElement myemail;
	
	@FindBy(id="sender_name")
	WebElement emailName;
	
	@FindBy(id="sender_email")
	WebElement emailAddress;
	
	@FindBy(id="auto_bcc1")
	WebElement bccButton;
	
	@FindBy(name="save")
	WebElement clickonSave;
	
	@FindBy(id="CalendarAndReminders_font")
	WebElement calender;
	
	@FindBy(id="Reminders_font")
	WebElement reminder;
	
	@FindBy(id="testbtn")
	WebElement test;
	
	@FindBy(name="dismiss_all")
	WebElement popup;
	public void ClickOnMySettings() {
		clickObj(mySetting,"userDropDownMenu");
		System.out.println("My Setting Page Displayed");
	}
	public void ClickOnPersonalink() {
		waitforElement(10,personal);
		clickObj(personal,"personal link");
	
		
	}
	public void clickonloginHistorylink() {
		clickObj(history,"Login History link");
		
	}
	public void DownloadLoginHistory() {
		clickObj(download,"DownLoad Login History link ");
		System.out.println("Login history is displayed and the data is downloaded in .csv format.");
		
	}
	public void clickonDispayAndLayoutlink() {
		waitforElement(10,personal);
		clickObj(display,"Display & Layout link");
		
	}
	public void customizeMyTabLink() {
		clickObj(customize,"Customize my Tab link");
		
	}



	public void customAppAndSalesforceChatter() {
		clickObj(custom,"CustomApp dropdown link");
		System.out.println("Salesforce chatter selected");
		
	}
	public void reportstab() {
		clickObj(report,"CustomApp dropdown link");
	}
	public void addreport() {
		
		clickObj(add,"report added");
		System.out.println("Reports field is added to Selected Tabs list and also added in the links available in top of salesforce page and sales force chatter page and sales and marketing pages.");
	}
	
	public void ClickOnEmailLink() {
		
		waitforElement(10,email);

		clickObj(email,"Email link");
	}
	public void ClickOnMyemailSettings() {
		clickObj(myemail,"myEmail Setting link");
		
	}
	
	public void provideEmailInformation() {
		emailName.clear();
		emailName.sendKeys("Gopika");
		System.out.println("Enetered the emailName - Goipka");
		emailAddress.clear();
		emailAddress.sendKeys("swathiabc@gmail.com");
		System.out.println("Entered the email Address - swathiabc@gmail.com ");
		bccButton.click();
		clickonSave.click();
		
	}
	public void ClickOnCalender() {
		waitforElement(10,calender);

		clickObj(calender,"Click on Calender");
		
	}
	public void clickOnActivityReminder() {

		clickObj(reminder,"Click on Reminder");
	}
	public void OpenATestRemenderButton() throws InterruptedException {
		waitforElement(20,test);
		clickObj(test,"Open Test Reminder");
		for(String handle:driver.getWindowHandles()) { // window handlers are used for  switch to other window
		driver.switchTo().window(handle);
	
		
		String text = driver.getTitle();
	    System.out.println(text);
		System.out.println("Sample event pop window is dispayed.");
}
	}
	
	public void swtchToPoP() throws InterruptedException {
		Thread.sleep(5000);
		//popup.click();
		Actions action = new Actions(driver);
		action.moveToElement(popup).click().build().perform();
		
		Thread.sleep(5000);
		String parentWindow = driver.getWindowHandle();
		for(String handle : driver.getWindowHandles()) { 
			if(handle != parentWindow) {
				driver.switchTo().window(handle);
			String	expectedUrl1 = driver.getCurrentUrl();
			String	actualUrl1 = "https://ap8.salesforce.com/ui/core/activity/ReminderSettingsPage?setupid=Reminders&retURL=%2Fui%2Fsetup%2FSetup%3Fsetupid%3DCalendarAndReminders";
				
			if(actualUrl1.equalsIgnoreCase(expectedUrl1)) {
					System.out.println("MySettings page is not Lunched");
			}
				else {
					System.out.println("User is on MySettings page");
				}	
			}
		}
	
	}
	
	

}
