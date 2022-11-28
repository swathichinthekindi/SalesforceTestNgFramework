package com.training.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.training.base.BasePage;

public class AccountPage extends BasePage{

	public AccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "(//a[text() = 'Accounts'])[1]")
	WebElement account;
	
	@FindBy(name="new")
	WebElement newaccount;
	
	@FindBy(id="acc2")
	WebElement accountname;
	
	@FindBy(xpath="//select/option[@value='Technology Partner']")
	WebElement type;
	
	@FindBy(xpath="//select/option[@value='High']")
	WebElement customer;
	
	@FindBy(name="save")
	WebElement savebutton;
	
	@FindBy(xpath = "//a[text()='Create New View']")
	WebElement newView;
	
	@FindBy(id="fname")
	WebElement viewname;
	
	@FindBy(id="devname")
	WebElement unique;
	
	@FindBy(name="save")
	WebElement viewsave;
	
	@FindBy(id="fcf")
	WebElement editview;

	@FindBy(xpath = "//a[text()='Edit']")
	WebElement editbutton;
	
	@FindBy(id="fname")
	WebElement newviewName;
	
	@FindBy(id="fcol1")
	WebElement feild;
	
	@FindBy(id="fop1")
	WebElement operatorfeild;
	
	@FindBy(id="fval1")
	WebElement value;
	
	@FindBy(name="save")
	WebElement clicksave;
	
	@FindBy(xpath="//a[text()='Merge Accounts']")
	WebElement mergeAccounts;
	
	@FindBy(id="srch")
	WebElement findaccount;
	
	@FindBy(xpath="(//input[@title='Find Accounts'])[2]")
	WebElement find;
	
	@FindBy(id="cid0")
	WebElement checkbox1;
	
	@FindBy(id="cid1")
	WebElement checkbox2;
	
	@FindBy(id="cid2")
	WebElement checkbox3;
	
	@FindBy(name="goNext")
	WebElement savemerge;
	
		
	//@FindBy(xpath="(//input[@name='save'])[2]")
	@FindBy(xpath="//div[@class='pbBottomButtons']/input[@name='save']")
	//*[@id="stageForm"]/div[@class='bWizardBlock tertiaryPalette']//input[@value=' Merge ']
	//@FindBy(xpath="//*[@id=\"stageForm\"]/div[@class='bWizardBlock tertiaryPalette']//input[@value=' Merge ']")
//	List<WebElement>  Merge;
	WebElement Merge;
	
	@FindBy(xpath="//a[normalize-space()='Accounts with last activity > 30 days']")
	WebElement report;
	
	
	@FindBy(xpath="//input[@id='ext-gen20']")
	WebElement datafeild;
	
	@FindBy(xpath="//div[contains(text(),'Created Date')]")
	WebElement createDate;
	
	@FindBy(id="ext-gen152")
	WebElement fromdate;
	
	@FindBy(xpath="//span[contains(text(),'16')]")
	WebElement todayDate;
	
	@FindBy(id="ext-comp-1045")
	WebElement clearTofeild;
	
	@FindBy(id="ext-gen154")
	WebElement clickToFeild;
	
	//@FindBy(id="ext-gen297")
	//@FindBy(xpath="//a[@id='ext-gen297']")
	@FindBy(id="ext-comp-1113")
	WebElement nextMonth;
	
	@FindBy(xpath="//a[contains(text(),'Dec')]")
	WebElement dec;
	
	@FindBy(xpath="//button[normalize-space()='OK']")
	WebElement ok;
	//@FindBy(xpath="(//span[contains(text(),'15')])[2]")
	
	//@FindBy(xpath="td[class='x-date-active x-date-selected'] span")
	@FindBy(xpath="/html[1]/body[1]/div[17]/ul[1]/li[1]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[3]/td[6]/a[1]/em[1]/span[1]")
	WebElement ToDatefeild;
	
	@FindBy(id="ext-gen49")
	WebElement savereport;
	
	@FindBy(id="saveReportDlg_reportNameField")
	WebElement reportname;
	
	@FindBy(id="saveReportDlg_DeveloperName")
	WebElement uniqname;
	
	@FindBy(id="ext-gen330")
	WebElement saveandRunreport;
	
	public void launchedHomePage() {
		System.out.println("Test pass: SalesForce login page is launched and application home page is logged in with correct username.");
	}

	public void ClickOnAccountlinkOnHomePage() {
		clickObj(account,"Account");
		System.out.println("---*Account Page Displayed*----");
	}

	public void clickonNewButton() {
		waitforElement(10,newaccount);

		clickObj(newaccount,"New");
		
	}

	public void enterAccountName(String actname) throws InterruptedException {
		Thread.sleep(5000);
		enterText(accountname,actname,"AccountName");
	}

	public void selectTypeAsTechnologyPatner() {
		clickObj(type,"Technology patner");

	}

	public void selectCostomerPriority() throws AWTException, InterruptedException {
		Robot robot = new Robot();
		 Thread.sleep(5000);
	      robot.mouseWheel(20);  // this is for scrolling the screen down function.
		clickObj(customer,"Customer Priority");

	}

	public void clickOnSvae() {
		clickObj(savebutton,"Save");
		System.out.println("------*New account page is displayed with account details*-----");

		
	}
	
	public void clickonCreateNewViewlink() {
	   waitforElement(10,newaccount);

		clickObj(newView,"NewView");

		
	}

	public void enterTheviewName() throws InterruptedException {
		Thread.sleep(5000);
		viewname.sendKeys("Gopika");
	}

	public void enteruniqueName() {
		unique.sendKeys("special");
		
	}

	public void viewsave() {
		clickObj(viewsave,"viewSave");
		System.out.println("---*Newely added View should  displayed in the account view list---*");
		
	}

	public void selectViewNameFromDropDown() {
		   waitforElement(10,editview );

		Select editviewuser = new Select(editview);
		editviewuser.selectByIndex(1);
		
	}

	public void clickOnEditlink() {
		clickObj(editbutton,"edit");
		System.out.println("Test Pass: Viewname Edit Page Displayed.");

	}

	public void addNewViewName() throws InterruptedException {
      Thread.sleep(5000);
		newviewName.clear();
		newviewName.sendKeys("Swathi");
	}

	public void enterFiledName() {
		
		  waitforElement(10,feild );

			Select field = new Select(feild);
			field.selectByIndex(1);
			
			
			
		
	}

	public void enterOperatorField() {
		Select operator = new Select(operatorfeild);
		operator.selectByIndex(4);
		
	}

	public void enterValue() {
		value.sendKeys("a");
		
	}

	public void clickOnSaveButton() {
		clickObj(clicksave,"save");
		

		
	}
	
	

	public void clickOnMergeAccount() {
		waitforElement(10,newaccount);

		clickObj(mergeAccounts,"MergeAccount");
		
	}

	public void findAccount() {
         findaccount.sendKeys("sa");	
         clickObj(find,"findAccount");
 		
	}

	public void selectTwoAccountsToMerge() throws InterruptedException {
      Thread.sleep(5000);
		checkBox(checkbox1, "firstCheckBox");
		checkBox(checkbox2, "secondCheckBox");
		//checkbox3.click();
		clickObj(savemerge,"Save");
		
		
	}

	

	//public void clickOnMergeButton() throws Exception {
//	
//		Thread.sleep(5000);
//		List mergeElements = Merge;
//		for(int i=0; i<= mergeElements.size(); i++) {
//		Robot robot = new Robot();
		//Dimension i = driver.manage().window().getSize(); 
	//	System.out.println("Dimension x and y :"+i.getWidth()+" "+i.getHeight()); 
		//clickObj(Merge,"mergebutton");
		//	Merge.get(0).click();
		
	  //    robot.mouseMove(1051, 798); //mouseMove(x-axis, y-axis);

		public void clickOnMergeButton() throws Exception {	
		//	Robot robot = new Robot();	
		Thread.sleep(5000);
	//	Dimension i = driver.manage().window().getSize(); 
	//	System.out.println("Dimension x and y :"+i.getWidth()+" "+i.getHeight()); 
		clickObj(Merge,"mergebutton");
		driver.switchTo().alert().accept(); //popup window acceptance.

		 
		 
		
	}

		public void clickonAccountsWithLastActicity30days() {
			  waitforElement(20,report );

			clickObj(report,"report Area");		
			System.out.println("Unsaved Repoet page is diaplayed");
		}

		public void selectreateDataFromDataFeild() throws InterruptedException {
		Thread.sleep(5000);
			clickObj(datafeild,"datafeild");
		clickObj(createDate,"datafeild");	     
			
		}

		public void clickOnFromDate() {

			clickObj(fromdate,"FRomDate");
		}

		public void clickOnTodayDate() {
			clickObj(todayDate,"todayDate");			
		}

		public void cleartheTodateFeild() {
			clearTofeild.clear();
			
		}

		public void clickOnToDateFeild() throws InterruptedException {
			
			clickObj(clickToFeild,"toDateFeild");
			clickObj(nextMonth,"nextmonth");   // click on next month
			Thread.sleep(5000);
			dec.click();
			ok.click();
			System.out.println("month selected");
			clickObj(ToDatefeild,"toDateFeild");
			System.out.println("List of accounts qualified is displayed");
			
		}

//	//	public void clickOnTdatDateOnToDateFeild() throws InterruptedException {
//               Thread.sleep(5000);
//			clickObj(ToDatefeild,"toDateFeild");
//			System.out.println("List of accounts qualified is displayed");
//		}

		public void clickOnSaveReport() {
			clickObj(savereport,"SaveReport");
			reportname.clear();
			reportname.sendKeys("HelloAccount");
			uniqname.clear();
			uniqname.sendKeys("Report");
			 waitforElement(30,saveandRunreport);
			clickObj(saveandRunreport,"SaveAndRunReport");
			
			
		}	
		
         
}
	
	


