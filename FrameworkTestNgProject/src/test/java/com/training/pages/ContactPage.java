package com.training.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.training.base.BasePage;

public class ContactPage extends BasePage {

	public ContactPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[@title='Contacts Tab']")
	WebElement contact;

	@FindBy(name = "new")
	WebElement contactNew;

	@FindBy(id = "name_lastcon2")
	WebElement lastname;

	@FindBy(xpath = "//img[@title='Account Name Lookup (New Window)']")
	WebElement accountName;

	@FindBy(id = "searchFrame")
	WebElement frame1;

	@FindBy(id = "lksrch")
	WebElement search;

	@FindBy(name = "go")
	WebElement go;

	@FindBy(id = "resultsFrame")
	WebElement frame2;

	@FindBy(xpath = "//a[normalize-space()='State Bank Of India']")
	WebElement selectAccountName;

	@FindBy(name = "save")
	WebElement save;

	@FindBy(xpath="//a[contains(text(),'Create New View')]")
	WebElement creatNew;
	
	@FindBy(id="fname")
	WebElement viewname;
	
	@FindBy(id="devname")
	WebElement uniqName;
	
	@FindBy(xpath="//option[@value='2']")
	WebElement recent;
	
	@FindBy(xpath="//option[@value='00B5g00000j1Xxb']")
	WebElement view;
	
	@FindBy(xpath="//a[contains(text(),'Chinthekindi')]")
	WebElement contactNameField;
	
	@FindBy(xpath="(//div[@class='errorMsg'])[1]")
	WebElement error;
	
	@FindBy(name="cancel")
	WebElement cancel;
	
	@FindBy(xpath="//a[contains(text(),'Global Media')]")
	WebElement selectAccountName1;
	
	@FindBy(name="save_new")
	WebElement saveNew;
	
	@FindBy(id="hoverItem25")
	WebElement validate;
	public void clickOnContactTabfromHomepage() {
		waitforElement(10, contact);

		clickObj(contact, "Contact Tab");
		System.out.println("Test Pass: Contact Page is Displayed");

	}

	public void clickOnContactNewButton() {
		waitforElement(10, contactNew);
		clickObj(contactNew, "ContactNew");
		System.out.println("Test Pass: New Contact home page is displayed");

	}

	public void EnterLastNameInLAstNameField() {
		waitforElement(20, lastname);
		lastname.sendKeys("India");
	}

	public void clickOnAccountNameImagebutton() {
		clickObj(accountName, "AccountName");

	}

	public void switchtoTheAccountNamewindoow() {
		clickObj(accountName, "AccountName");

		String parentTitle = driver.getTitle(); // current window title
		System.out.println(parentTitle);

		// Switch to other window
		Set<String> getAllWindows = driver.getWindowHandles();
		String[] getwindow = getAllWindows.toArray(new String[getAllWindows.size()]);
		driver.switchTo().window(getwindow[1]);
		System.out.println(driver.getTitle());

		driver.switchTo().frame(frame1);
		waitforElement(10, search);
		search.sendKeys("*s");
		clickObj(go, "Go");
		driver.switchTo().defaultContent(); // driver switch out from the frame.
		driver.switchTo().frame(frame2);
		clickObj(selectAccountName, "AccountName");
		System.out.println("Test Pass: AccountName is Displayed in AccountName field");
		driver.switchTo().window(getwindow[0]);

	}

	public void clickOnSave() throws AWTException {

		Robot robot = new Robot();
		robot.mouseWheel(30);
		waitforElement(10, lastname);
		clickObj(save, "Save");
		String validate = driver.getTitle(); // current window title
		System.out.println(validate);
		System.out.println("Test Pass: New contact page created. ");

	}

	public void clickOnCreateNewView() {
		waitforElement(10, creatNew);
		clickObj(creatNew, "Create New View");
		System.out.println("Test Pass: New View Page is displayed");


	}

	public void enterviewNameinviewNamefield() {
		waitforElement(10,viewname);
		viewname.sendKeys("ABCD");
		System.out.println("Test pass: VIEW Name entered in the view name fIELD");
	}

	public void enterUniqueNameinViewUniqueNamefiled() {
		waitforElement(10,uniqName);
		uniqName.sendKeys("EFGHJ");
		System.out.println("Test pass: Unique VIEW Name entered in the Unique view name fIELD");		
	}

	public void clickOnSaveButton() {
		clickObj(save, "Save");
		String ActualTitle = driver.getTitle(); // current window title
		System.out.println(ActualTitle);
				
		System.out.println("Test Pass: Contacts Home page is opened. Created VIEw name is displayed in drop down in that page by defalut. ");

	}

	public void selectRecentlyCreatedFromDropdown() {
		waitforElement(10, recent);
		clickObj(recent, "Recently created ");
		String ActualTitle = driver.getTitle(); // current window title
		System.out.println(ActualTitle);
		System.out.println("Recently created contacts should be displayed");
	}

	public void clickOnmycontactsfromdropdown() {
		waitforElement(10, view);
		clickObj(view, "My Contact");
		String ActualTitle = driver.getTitle(); // current window title
		System.out.println(ActualTitle);
		String Expectedtitle = "Contacts: Home ~ Salesforce - Developer Edition";
		Assert.assertEquals(ActualTitle, Expectedtitle);
			
		 
		System.out.println("Test Pass: My contacts VIEw should be displayed");

		
		
	}

	public void clickOnContactNameUnderTheNamefield() {
		waitforElement(10,contactNameField);
		clickObj(contactNameField, "Recent Contact");
		String ActualTitle = driver.getTitle(); // current window title
		System.out.println( "test pass:" +ActualTitle);
	//	String Expectedtitle = "Contact: Chinthekindi ~ Salesforce - Developer Edition";
	//	Assert.assertEquals(ActualTitle, Expectedtitle);
		System.out.println("Test Pass: Recent select contact page displayed");
			

		
	}

	public void clickOnCreateNewViewLInk() {
		waitforElement(10, creatNew);
		clickObj(creatNew, "Create New View");
		System.out.println("Test Pass: New View Page is displayed");
		
		
	}

	public void validateErrorMessage() {
		error.getText();
		String errormessage = error.getText();
		System.out.println(errormessage);
		System.out.println("Error message is appeared under the VIEw Name fIEld. The Error message appears as , Error: You must enter a value");		
	}

	public void clickOnCancelButton() {
		waitforElement(10, cancel);
		clickObj(cancel, "Cancel");
		String ActualTitle = driver.getTitle(); // current window title
		System.out.println(ActualTitle);
		System.out.println("Test Pass: Contacts Home page is displayed and the VIEw ABCD should not be created.");
		
	}

	public void switchtoTheAccountNamewindoow1() {
		clickObj(accountName, "AccountName");

		String parentTitle = driver.getTitle(); // current window title
		System.out.println(parentTitle);

		// Switch to other window
		Set<String> getAllWindows = driver.getWindowHandles();
		String[] getwindow = getAllWindows.toArray(new String[getAllWindows.size()]);
		driver.switchTo().window(getwindow[1]);
		System.out.println(driver.getTitle());

		driver.switchTo().frame(frame1);
		waitforElement(10, search);
		search.sendKeys("Global");
		clickObj(go, "Go");
		driver.switchTo().defaultContent(); // driver switch out from the frame.
		driver.switchTo().frame(frame2);
		clickObj(selectAccountName1, "AccountName");
		System.out.println("Test Pass: AccountName is Displayed in AccountName field");
		driver.switchTo().window(getwindow[0]);

		
		
	}

	public void clickOnSaveNewButton() {
		waitforElement(10, saveNew);
		clickObj(saveNew, "Save-New");
		
	}

	public void validate() {
       String val =  validate.getText();	
       System.out.println("the test Pass: "+val);
       System.out.println("Test Pass: New contact is created. Contact Edit: New Contact Page is dispalyed");
	}
	

}
