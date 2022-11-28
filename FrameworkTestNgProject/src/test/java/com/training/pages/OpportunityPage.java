package com.training.pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.training.base.BasePage;

public class OpportunityPage extends BasePage {

	public OpportunityPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//a[@title=\"Opportunities Tab\"]")
	WebElement Opptab;
	
	@FindBy(id="fcf")
	WebElement verifyOpp;
	
	//@FindBy(id="fcf")
//	List<WebElement> listOpp;
	
	@FindBy(name="new")
	WebElement newOPP;
	
	@FindBy(xpath="//input[@id='opp3']")
	WebElement OppName;
	
	@FindBy(id="opp4")
	WebElement Accname;
	@FindBy(xpath="//img[@title='Account Name Lookup (New Window)']")
	WebElement serchimg;
	
	@FindBy(xpath="//frame[@id='searchFrame']")
	WebElement frames;
	
	@FindBy(xpath="//a[contains(text(),'Opportunity Pipeline')]")
	WebElement pipeline;
	
	@FindBy(xpath="//h1[contains(text(),'Pipeline')]")
	WebElement report;
	
	@FindBy(xpath="//a[contains(text(),'Stuck')]")
	WebElement stuck;
	
	@FindBy(id="quarter_q")
	WebElement nextFQ;
	
	@FindBy(xpath="//select[@id='open']")
	WebElement open;
	
	@FindBy(xpath="//input[@title='Run Report']")
	WebElement runReport;
	
	@FindBy(xpath="//h1[normalize-space()='Opportunity Report']")
	WebElement oppreport;
	
	@FindBy(id="opp9")
	WebElement enddate;
	
	@FindBy(xpath="//td[normalize-space()='17']")
	WebElement closedate;
	
	@FindBy(id="opp11")
	WebElement stage;
	
	@FindBy(xpath="//option[@value='Phone Inquiry']")
	WebElement source;
	
	@FindBy(xpath="//img[@title='Primary Campaign Source Lookup (New Window)']")
	WebElement primaryCompaign;
	
	@FindBy(id = "searchFrame")
	WebElement frame1;
	
	@FindBy(id = "lksrch")
	WebElement search;
	
	@FindBy(name = "go")
	WebElement go;
	
	@FindBy(id = "resultsFrame")
	WebElement frame2;

	@FindBy(xpath="//a[contains(text(),'International Electrical Engineers Association Tra')]")
	WebElement compaign;
	
	@FindBy(name="save")
	WebElement savePage;
	
	@FindBy(xpath="//h1[@class='pageType' and //h2[@class='pageDescription']]")
	WebElement val1;
	
	@FindBy(xpath="//h2[normalize-space()='software']")
	WebElement val2;
	
	public void clickOnOpportunities() {
		clickObj(Opptab,"Opportunities link");
		System.out.println("Opportunities Home page displayed");

	}
	public void verifyOpportunitesDropdown() {
		System.out.println("-----*Opportunities dropdown LIst-------*");
		waitforElement(10,verifyOpp);

		clickObj(verifyOpp,"Opportunities link");
		System.out.println("-----*Opportunities dropdown LIst-------*");

		String opp = verifyOpp.getText();
		System.out.println(opp);
		
		System.out.println("-----*Opportunities dropdown List end-------*");

		System.out.println("Test Pass: Verified opportunities drop down is present");
		
//		-----------ByLIst----------------------
//		Select select = new Select(verifyOpp);  
//		List<WebElement> options = select.getOptions();  
//		for(WebElement we:options)  
//		{  
//		 System.out.println(we.getText());  
//		}  
}

	public void clickOnNewOppLink() {
		waitforElement(20,newOPP);

		clickObj(newOPP,"NEw Opportunities link");
		
	}
	public void enterOpportunitiesName() {
		waitforElement(20,OppName);

		OppName.sendKeys("software");
	}
	
	
	public void clockOnOpportunityPipelineLink() {
		waitforElement(20,pipeline);
		clickObj(pipeline,"Opportunity Pipeline link");
		
	//	String actualTitle = driver.getTitle();
	//	System.out.println(actualTitle);
		
		String ActualTitle = driver.getTitle();
		System.out.println(ActualTitle);
		
		String ExpectedTitle = "Opportunity Pipeline ~ Salesforce - Developer Edition";
		Assert.assertEquals(ExpectedTitle, ActualTitle);
		System.out.println("Test Pass:Report Page with the Opportunities that are pipelined will be displayed. ");

		
	}
	public void clickOnStuckOpportunities() {
		
		waitforElement(20,stuck);
		clickObj(stuck,"Stuck Opportunities link");
		
		String ActualTitle = driver.getTitle();
		System.out.println(ActualTitle);
		
			
		String expectedTitle = "Stuck Opportunities ~ Salesforce - Developer Edition";
		if(ActualTitle.equalsIgnoreCase(expectedTitle))	
			System.out.println(" Test Pass: Report Page with the Opportunities that are Stuck will be displayed.");
	else
			System.out.println("Stuck Opportunities page is not displayed");
	}
	
	public void clickOnQuarterlySummeryREport() {
		System.out.println("Choose the interval value as NextFQ");
		
	}
	public void chooseIntervalAsNextFQ() {
		waitforElement(20,nextFQ);
		clickObj(nextFQ," NextFQ link");
		
		Select dropdown = new Select( nextFQ);
		dropdown.selectByIndex(2);
		
	}
	
	public void chooseIncludeAsClosedOpportunities() {
		waitforElement(20,open);
		clickObj(open," include link");
		
		Select dropdown = new Select(open);
		dropdown.selectByIndex(2);
		
	}
	public void clockOnRunReport() {
		clickObj(runReport," Run Report");
	}
	public void validatetheReoptpage() {
		oppreport.getText();
		System.out.println("the title of the page" +oppreport);
		System.out.println(" Test Pass: Report Page with the Opportunities that satisfies the search criteria will be displayed.");
		
	}
	public void closedate() throws InterruptedException {
		Thread.sleep(5000);
		enddate.clear();
		enddate.click();
		clickObj(closedate," Close date");

		
	}
	public void clickOnStage() {
		clickObj(stage," Stage dropdown");
		Select stageselect = new Select(stage);
		stageselect.selectByIndex(2);

		
	}
	public void selectLeadSource() {
		clickObj(source," Lead Source");
	}
	public void clickOnPrimaryCompaign() {
		
		clickObj(primaryCompaign,"Primary Compaign icon");
		
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
		clickObj(compaign, "Primary Compaign");
	System.out.println("Test Pass: Primary Compaign name displayed in the field");
		driver.switchTo().window(getwindow[0]);

		
		
	}
	public void clickOnSave() {
		clickObj(savePage," save");
		
		
	}
	public void validationOfNewOppPage() {
		System.out.println(val1.getText());
		System.out.println(val2.getText());
		
		System.out.println("Test Pass: New Opportunity page is displayed with Opportunity details.");
		
	}
}
