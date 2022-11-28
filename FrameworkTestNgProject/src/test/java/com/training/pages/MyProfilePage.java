package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.training.base.BasePage;

public class MyProfilePage extends BasePage {

	public MyProfilePage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//a[contains(text(),'My Profile')]")
	WebElement myprofile;
	
	@FindBy(xpath="(//img[@src='/img/func_icons/util/pencil12.gif'])[1]")
	WebElement edit;
	
	@FindBy(xpath="//a[contains(text(),'About')]")
	WebElement about;
	
	@FindBy(id="contactInfoContentId")
	WebElement iframe;
	
	@FindBy(id ="lastName")
	WebElement lstname;
	
	@FindBy(xpath="//input[@value='Save All']")
	WebElement save;
	
	@FindBy(id="tailBreadcrumbNode")
	WebElement text;	
	
	@FindBy(xpath="//span[text()='Post']")
	WebElement post;
	
	@FindBy(xpath="//iframe[@class='cke_wysiwyg_frame cke_reset']")
	WebElement iframe1;
	
	@FindBy(xpath="//body[@contenteditable='true']")
	WebElement entertext;
	
	@FindBy(xpath="//input[@title='Share' and @type='button']")
	WebElement share;
	
	@FindBy(xpath="(//span[@class='publisherattachtext '])[2]")
	WebElement file;
	
	@FindBy(id ="chatterUploadFileAction")
	WebElement uploadfile;
	
	@FindBy(id ="chatterFile")
	WebElement choosefile;
	
	@FindBy(id = "publishersharebutton")
	WebElement sharebutton;
	
	@FindBy(id = "uploadLink")
	WebElement addphoto;
	
	@FindBy(id = "uploadPhotoContentId")
	WebElement iframe2;
	
	@FindBy(id = "j_id0:uploadFileForm:uploadInputFile")
	WebElement choosefiletoupload;
	
	@FindBy(id = "j_id0:uploadFileForm:uploadBtn")
	WebElement saveimage;
	
	@FindBy(id ="photo")
	WebElement photo;
	
	@FindBy(id = "j_id0:j_id7:save")
	WebElement saveimagebutton;
	public void clickonMyProfile() {
		clickObj(myprofile,"userDropDownMenu");
		System.out.println("Test Pass: User MyPofile Is Displayed");
	}
	
	public void clickOnEditProfile() throws InterruptedException {
		Thread.sleep(5000);
		clickObj(edit,"editProfile");
		System.out.println("Test Pass: Edit Profile PoP up Window Displayed");
		
	}
	
	public void SwitchToIframeofAbout() {
		driver.switchTo().frame(iframe);
	}

	

	public void ClickonAboutButton() {
		clickObj(about,"About Button");
		
	}
	public void EnterLastname(String lastname) {
		lstname.clear();
		enterText(lstname ,lastname,"Username");
		
		System.out.println("Test pass: lastname is displayed");
	}
	
	public void ClickonSaveALl() {
	clickObj(save,"SaveAll Button");
	String lastName = text.getText();
	System.out.println(" UserProfilePage with changed lastname is displayed " +lastName);
		
	}
	
	public void postlink() {
		
		clickObj(post,"click on post");
	}
	public void SwitchToIframeOfPost() {
		driver.switchTo().frame(iframe1);
	}

	
	public void entertextOnPost() {
		entertext.sendKeys("Welcome To the Post");
		
	}
	public void clickOnshareButton() {
		driver.switchTo().defaultContent();
		clickObj(share,"click on ShareButton");
		}
	
	public void clickOnFileButton() {
		clickObj(file,"click on file Button");
	}
	
	public void uploadFileFromTheComputer() {
		clickObj(uploadfile,"click on upload a file from Computer");
	}
	
	public void chooseFile(String selectedfile) {
		enterText(choosefile ,selectedfile,"choosen path");

	}
	
	public void clickOnshare() {
		clickObj(sharebutton,"click on share Button");
		System.out.println("Test pass: Selected file posted");
		
	}
	public void ClickOnAddPhoto() throws InterruptedException {
		Thread.sleep(5000);
		 Actions action = new Actions(driver);
		 action.moveToElement(addphoto).click().build().perform();
	}
	public void SwitchToIframeOfaddphoto() {
		driver.switchTo().frame(iframe2);
	}
	public void chooseFiletouploadphoto(String selectedfile) {
		enterText(choosefiletoupload ,selectedfile,"choosen path");

	}
	
	public void svaeimage() {
		clickObj(saveimage,"click on saveButton");
		
	}
	public void photocrop() throws InterruptedException {
		Thread.sleep(5000);
		Actions crop = new Actions(driver);                 //Crop image .....
		 crop.clickAndHold(photo).moveByOffset(30,50).release().build().perform();
	}

	public void savebutton() {
		
		clickObj(saveimagebutton,"click on saveButton");
		
	}

	public void validation() {
		System.out.println("Test Pass: FirstName LastName' page has the updated LastName.");
		
	}
	
	
}
	

