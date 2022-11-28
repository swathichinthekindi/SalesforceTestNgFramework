package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.training.base.BasePage;

public class LeadPage extends BasePage {

	public LeadPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[contains(text(),'Lead')]")
	WebElement lead;
	
	@FindBy(id="fcf")
	WebElement leadDropdown; 
	
	@FindBy(xpath="//option[@value='00B5g00000j1Xwg']")
	WebElement unread;
	
	@FindBy(name="go")
	WebElement go;
	
	@FindBy(name="new")
	WebElement newlead;
	
	@FindBy(id="name_lastlea2")
	WebElement lastname;
	
	@FindBy(id="lea3")
	WebElement comName;
	
	@FindBy(name="save")
	WebElement save;
	
	@FindBy(xpath="//h2[normalize-space()='ABCDEF']")
	WebElement validate;
	
	
	
	public void HomePageDisplayed() {
		System.out.println("HOme page is Displayed");
		}
	public void clickleadTabLinkFromHomePage() {
		waitforElement(20,lead);
		clickObj(lead,"Lead");
	//validation ..........		
		String ActualTitle = driver.getTitle();
		System.out.println(ActualTitle);
		//Leads: Home ~ Salesforce - Developer Edition
		}
	public void LinkNavigateToLeadHomePage() {
		System.out.println("Test Pass: Lead Tab Link is  navigate to Leads Home page");
		}
    public void clickOnLeadDropdownlisthandle() {
		waitforElement(20,leadDropdown);
		clickObj(leadDropdown,"LeadDropdownlink");
	String leadDropdownlist =	leadDropdown.getText();
	System.out.println("The list of Lead Dropdown lists are: "+leadDropdownlist);
	System.out.println("Test PAss: Lead DropDown list displayed");
		
	}

	public void clickOntodaysLead() {
		waitforElement(20,leadDropdown);
		clickObj(leadDropdown,"LeadDropdownlink");
		
		
	}

	public void selectMyUnreadLead() {
		waitforElement(20,leadDropdown);
		clickObj(leadDropdown,"LeadDropdownlink");
		clickObj(unread,"My Unread Lead");
		
	}

	public void salesforceLoginPageDisplay() {
		System.out.println("Salesforce LoginPage is Displayed");
		
	}

	public void clickOnGoButton() {
		clickObj(go,"Go link");
		String ActualTitle = driver.getTitle();
		System.out.println(ActualTitle);
     System.out.println("Test Pass: The View Page is Displayed");
		
	}
	public void selectTodaysLeadfromDropdown() {
		waitforElement(20,leadDropdown);
		clickObj(leadDropdown,"LeadDropdownlink");
		Select field = new Select(leadDropdown);
		field.selectByIndex(3);
		clickObj(go,"Go link");
		String ActualTitle = driver.getTitle();
		System.out.println(ActualTitle);
		System.out.println("Test Pass:Today's Lead page is displayed ");
		
	}
	public void clickOnNewbutton() {
		waitforElement(20,newlead);
		clickObj(newlead,"New");
		System.out.println("New Lead creation page should open");
		
	}
	public void EnterTheLastname() {
		waitforElement(20,lastname);
		lastname.sendKeys("ABCDEF");
		

	}
	public void EnterTheCompany() {
		comName.sendKeys("newcompanyABCD");
		clickObj(save,"Save");
		
		System.out.println("Test Pass: new lead should be saved and the newly created lead view page should be opened");

		
	//		 String validate=driver.getTitle();
	//	System.out.println(validate);
		
	}
	
	
	
	

}
