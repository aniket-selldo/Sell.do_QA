package com.selldo.POM.adminPages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.selldo.Utility.ReusableUtils;

public class NewCampaignFormPage extends ReusableUtils {
	public WebDriver driver;

	public NewCampaignFormPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.CSS, using = "input[name='campaign[name]']")
	private WebElement name;
	@FindBy(how = How.CSS, using = "div.currency2-container.placeholder")
	private WebElement budgetTextBox;
	@FindBy(how = How.ID, using = "campaign_budget")
	private WebElement budget;
	@FindBy(how = How.XPATH, using = "//input[@name='campaign_date_range']")
	private WebElement duration;
	@FindBy(how = How.XPATH, using = "//span[text()='Project']")
	private WebElement project;
	@FindBy(how = How.CSS, using = "#select2-drop ul li:nth-child(1) div")
	private WebElement selectProject;
	@FindBy(how = How.XPATH, using = "//*[@id='select2-drop']/div/input")
	private WebElement enterProjectName;
	@FindBy(how = How.XPATH, using = "//div[@class='select2-drop select2-display-none select2-with-searchbox select2-drop-active select2-drop-above']//ul//li")
	private WebElement project_All;
	@FindBy(how = How.XPATH, using = "//input[@class='select2-input select2-default'][@id='s2id_autogen3']")
	private WebElement teamField;
	@FindBy(how = How.CSS, using = "#select2-drop ul li:nth-child(1) div")
	private WebElement selectTeam;
	@FindBy(how = How.XPATH, using = "//div[@class='select2-drop select2-drop-multi select2-display-none select2-drop-active select2-drop-above']//ul[2]//li")
	private WebElement teamField_All;
	@FindBy(how = How.CSS, using = "#s2id_campaign_sale_ids ul li:nth-child(1) input")
	private WebElement salesField;
	@FindBy(how = How.CSS, using = "div#select2-drop ul:nth-child(2) li:nth-child(1)")
	private WebElement selectSales;
	@FindBy(how = How.XPATH, using = "//div[@class='select2-drop select2-drop-multi select2-display-none select2-drop-active select2-drop-above']//ul[2]//li")
	private WebElement salesField_All;
	@FindBy(how = How.XPATH, using = "//input[@id='s2id_autogen5']")
	private WebElement googleAdwordsAccount;
	@FindBy(how = How.XPATH, using = "//input[@id='s2id_autogen6']")
	private WebElement facebookAdvertsAccount;
	@FindBy(how = How.XPATH, using = "//input[@id='s2id_autogen5']")
	private WebElement googleAdwordsAccounts;
	@FindBy(how = How.XPATH, using = "//ul[@class='select2-results']//li")
	private List<WebElement> googleAdwordsAccounts_All;
	@FindBy(how = How.XPATH, using = "//input[@id='s2id_autogen6']")
	private WebElement facebookAdvertsAccounts;
	@FindBy(how = How.XPATH, using = "//ul[@class='select2-results']//li")
	private List<WebElement> facebookAdvertsAccounts_All;
	@FindBy(how = How.XPATH, using = "//a[text()='Save & Next']")
	private WebElement saveAndNextButton;
	// Tracking Emails
	@FindBy(how = How.XPATH, using = "//span[text()='Tracking Emails']")
	private WebElement trackingEmailsTab;
	@FindBy(how = How.XPATH, using = "//a[text()='Add']")
	private WebElement add_TrackingEmail;
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Campaign Email']")
	private WebElement campaignEmail_TrackingEmail;
	@FindBy(how = How.XPATH, using = "//span[text()='Project']")
	private WebElement project_TrackingEmail;
	@FindBy(how = How.XPATH, using = "//ul[@class='select2-results']//li")
	private List<WebElement> project_TrackingEmail_All;
	@FindBy(how = How.XPATH, using = "//span[text()='Select Source']")
	private WebElement source_TrackingEmail;
	@FindBy(how = How.XPATH, using = "//ul[@class='select2-results']//li")
	private List<WebElement> source_TrackingEmail_All;
	@FindBy(how = How.XPATH, using = "//input[@id='rule_sub_source']")
	private WebElement subSource_TrackingEmail;
	@FindBy(how = How.XPATH, using = "//input[@id='s2id_autogen6']")
	private WebElement team_TrackingEmail;
	@FindBy(how = How.XPATH, using = "//input[@id='s2id_autogen4']")
	private WebElement sales_TrackingEmail;
	@FindBy(how = How.XPATH, using = "//span[text()='Associated virtual number']")
	private WebElement associatedVirtualNumber_TrackingEmail;
	@FindBy(how = How.XPATH, using = "//span[text()='Associated Short code']")
	private WebElement associatedShortCode_TrackingEmail;
	@FindBy(how = How.XPATH, using = "//span[text()='Associated Email parser']")
	private WebElement emailParser_TrackingEmail;
	@FindBy(how = How.XPATH, using = "//a[text()='Save']")
	private WebElement saveButton_TrackingEmail;
	// Tracking Numbers
	@FindBy(how = How.XPATH, using = "//span[text()='Tracking Numbers']")
	private WebElement trackingNumbersTab_TrackingNumber;
	@FindBy(how = How.XPATH, using = "//a[@class='btn btn-outline-primary ml-2'][@id='button_show_untagged_vns']")
	private WebElement showOtherVirtualNumbers_TrackingNumber;// *[@id="button_show_untagged_vns"]
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'tr_vn_')]/td[7]/div/a/i")
	private WebElement actionBar_TrackingNumber;
	@FindBy(how = How.XPATH, using = "//th[text()='Actions']/following::a[@class='action_button dropdown-item'][1]")
	private WebElement addLink_TrackingNumber;
	@FindBy(how = How.XPATH, using = "//a[text()='Save']")
	private WebElement saveButton_TrackingNumber;
	// Input Channels
	@FindBy(how = How.XPATH, using = "//span[text()='Input Channels']")
	private WebElement inputChannelTab;
	@FindBy(how = How.XPATH, using = "//a[text()='Add']")
	private WebElement addButton_InputChannel;
	@FindBy(how = How.XPATH, using = "//select[@id='rule_entity_id']")
	private WebElement apiChannel_InputChannel;
	@FindBy(how = How.XPATH, using = "//a[text()='Save']")
	private WebElement saveButton_InputChannel;
	// SMS Shortcodes
	@FindBy(how = How.XPATH, using = "//span[text()='SMS shortcodes']")
	private WebElement smsShortcodesTab;
	@FindBy(how = How.XPATH, using = "")
	private WebElement alertPopup;
	@FindBy(how = How.XPATH, using = "//button[@id='btn_add_new_rule']")
	private WebElement addDropdown_SmsShortcode;
	@FindBy(how = How.XPATH, using = "//*[@id=\"rules_index_div\"]/div[2]/div[1]/div/ul/li[10]")
	private List<WebElement> add_options_SmsShortcode;
	@FindBy(how = How.XPATH, using = "//a[text()='Save']")
	private WebElement saveButton_SmsShortcode;
	@FindBy(how = How.XPATH, using = "//a[text()='Next']")
	private WebElement nextButton;
	@FindBy(how = How.XPATH, using = "//a[text()='Finish']")
	private WebElement finishButton;
	@FindBy(how = How.XPATH, using = "//input[@id='message']")
	private WebElement messageShortCode;
	@FindBy(how = How.XPATH, using = "//span[text()='Project']")
	private WebElement project_SmsShortCode;
	@FindBy(how = How.XPATH, using = "//*[@id=\"s2id_rule_source\"]/a/span[1]")
	private WebElement source_SmsShortCode;
	@FindBy(how = How.LINK_TEXT, using = "Next")
	private WebElement clickOnNext;
	@FindBy(how = How.XPATH, using = "//*[@id=\"select2-drop\"]/ul/li[24]/div")
	private List<WebElement> project_SmsShortCode_List;
	@FindBy(how = How.XPATH, using = "//*[@id=\"select2-drop\"]/ul/li")
	private List<WebElement> getAllProjectName;
	
	public void clickOnNext() {
		scrollIntoView(clickOnNext);
		waitUntilClickable(clickOnNext).click();
	}

	public void enterCamapignName(String nameObj) {
		waitUntilVisiblity(name).sendKeys(nameObj + generateRandomString());
	}

	public void enterRandomCampaignName(String campaignName) {
		waitUntilVisiblity(name).sendKeys(campaignName + generateRandomString());

	}

	public String generateRandomString() {
		String CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		int RANDOM_STRING_LENGTH = 10;
		StringBuffer randStr = new StringBuffer();
		for (int i = 0; i < RANDOM_STRING_LENGTH; i++) {
			int number = getRandomNumber();
			char ch = CHAR_LIST.charAt(number);
			randStr.append(ch);
		}
		return randStr.toString();
	}

	private int getRandomNumber() {
		String CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		int randomInt = 0;
		Random randomGenerator = new Random();
		randomInt = randomGenerator.nextInt(CHAR_LIST.length());
		if (randomInt - 1 == -1) {
			return randomInt;
		} else {
			return randomInt - 1;
		}
	}

	public void enterBudget(String budgetObj) {
		waitUntilClickable(budgetTextBox).click();
		waitUntilVisiblity(budget).sendKeys(budgetObj);
	}

	public void selectProject(String str) throws IOException {
		waitUntilClickable(project).click();
		wait(1000);
		enterProjectName.sendKeys(str);
		int index = (int) (Math.random() * getAllProjectName.size());
		wait(1000);
		getAllProjectName.get(index).click();;

	}

	public void selectTeam() throws IOException {
		waitUntilClickable(teamField).click();
		waitUntilClickable(selectTeam).click();
	}

	public void selectSales() throws IOException {
		waitUntilClickable(salesField).click();
		waitUntilClickable(selectSales).click();

	}

	public void selectGoogleAdwordsAccount() throws IOException {
		Properties property = new Properties();
		FileInputStream fileInputObj = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//java//Config File//global.properties");
		property.load(fileInputObj);
		waitUntilClickable(googleAdwordsAccounts).click();
		List<WebElement> list = googleAdwordsAccounts_All;
		for (WebElement ele : list) {
			System.out.println("Values " + ele.getAttribute("innerHTML"));
			if (ele.getAttribute("innerHTML")
					.contains(property.getProperty("googleAdwords_creatingCampaign_MandatoryFillTest"))) {
				waitUntilClickable(ele).click();
				System.out.println("Selected");
				break;
			}
		}
	}

	public void selectFacebookAdvertsAccount() throws IOException {
		Properties property = new Properties();
		FileInputStream fileInputObj = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//java//Config File//global.properties");
		property.load(fileInputObj);
		waitUntilClickable(facebookAdvertsAccounts).click();
		List<WebElement> list = facebookAdvertsAccounts_All;
		for (WebElement ele : list) {
			System.out.println("Values " + ele.getAttribute("innerHTML"));
			if (ele.getAttribute("innerHTML")
					.contains(property.getProperty("facebookAdverts_creatingCampaign_MandatoryFillTest"))) {
				waitUntilClickable(ele).click();
				System.out.println("Selected");
				break;
			}
		}
	}

	// ...................Tracking Emails..........................

	public void clickOnTrackingEmailsTab() {
		waitUntilClickable(trackingEmailsTab).click();
	}

	public void clickOnAddButton_TrackingEmail() {
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		waitUntilClickable(add_TrackingEmail).click();
	}

	public void enterTrackingEmailName(String trackingEmail) {
		waitUntilVisiblity(campaignEmail_TrackingEmail).sendKeys(trackingEmail);
	}

	public void selectProject_TrackingEmails() throws IOException {
		Properties property = new Properties();
		FileInputStream fileInputObj = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//java//Config File//global.properties");
		property.load(fileInputObj);
		waitUntilClickable(project_TrackingEmail).click();
		List<WebElement> list = project_TrackingEmail_All;
		for (WebElement ele : list) {
			System.out.println("Values " + ele.getAttribute("innerHTML"));
			if (ele.getAttribute("innerHTML")
					.contains(property.getProperty("project_trackingEmails_creatingCampaign_MandatoryFillTest"))) {
				waitUntilClickable(ele).click();
				System.out.println("Selected");
				break;
			}
		}

	}

	public void selectSource_TrackingEmails() throws IOException {
		Properties property = new Properties();
		FileInputStream fileInputObj = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//java//Config File//global.properties");
		property.load(fileInputObj);
		waitUntilClickable(source_TrackingEmail).click();
		List<WebElement> list = source_TrackingEmail_All;
		for (WebElement ele : list) {
			System.out.println("Values " + ele.getAttribute("innerHTML"));
			if (ele.getAttribute("innerHTML")
					.contains(property.getProperty("source_trackingEmails_creatingCampaign_MandatoryFillTest"))) {
				waitUntilClickable(ele).click();
				System.out.println("Selected");
				break;
			}
		}
	}

	public void enterSubSource_TrackingEmails(String sub) {
		waitUntilVisiblity(subSource_TrackingEmail).sendKeys(sub);
	}

	public void selectTeam_TrackingEmails() throws IOException {
		Properties property = new Properties();
		FileInputStream fileInputObj = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//java//Config File//global.properties");
		property.load(fileInputObj);
		waitUntilClickable(source_TrackingEmail).click();
		List<WebElement> list = source_TrackingEmail_All;
		for (WebElement ele : list) {
			System.out.println("Values " + ele.getAttribute("innerHTML"));
			if (ele.getAttribute("innerHTML")
					.contains(property.getProperty("team_trackingEmails_creatingCampaign_MandatoryFillTest"))) {
				waitUntilClickable(ele).click();
				System.out.println("Selected");
				break;
			}
		}
	}

	public void clickOnSaveButton_TrackingEmails() {
		waitUntilClickable(saveButton_TrackingEmail).click();
	}

	// ...................Tracking Numbers..........................

	public void clickOnTrackingNumbersTab() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		waitUntilClickable(trackingNumbersTab_TrackingNumber).click();
	}

	public void clickOnShowOtherVirtualNumber_TrackingNumbers() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		waitUntilClickable(showOtherVirtualNumbers_TrackingNumber).click();
	}

	public void clickOnActionBar_TrackingNumbers() {
		waitUntilClickable(actionBar_TrackingNumber).click();
	}

	public void clickOnAddLink_TrackingNumbers() {
		waitUntilClickable(addLink_TrackingNumber).click();
	}

	public void clickOnSaveButton_TrackingNumbers() {
		waitUntilClickable(saveButton_TrackingNumber).click();
	}

	// ...................Input Channels..........................

	public void clickOnInputChannelTab() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		waitUntilClickable(inputChannelTab).click();
	}

	public void clickOnAddButton_InputChannel() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		waitUntilClickable(addButton_InputChannel).click();
	}

	public void selectApiChannel() {
		Select oSelect = new Select(apiChannel_InputChannel);
		oSelect.selectByVisibleText("Makaan Mailer");
	}

	public void clickOnSaveButton_InputChannel() {
		waitUntilClickable(saveButton_InputChannel).click();
	}

	// ...................SMS Shortcodes..........................

	public void clickOnSmsShortcodesTab() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		waitUntilClickable(smsShortcodesTab).click();
	}

	// Accepting an alert popup while clicking on the tab
	public void clickAlertPopup() {
		driver.switchTo().alert().accept();
	}

	// Refactored
	public void selectSmsShortcode_SmsShortcode() throws IOException {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		waitUntilClickable(addDropdown_SmsShortcode).click();
		List<WebElement> list = add_options_SmsShortcode;
		for (WebElement ele : list) {
			System.out.println("Values " + ele.getAttribute("innerHTML"));
			if (ele.getAttribute("innerHTML").contains("Send unit to 26266")) {
				waitUntilClickable(ele).click();
				System.out.println("Selected");
			} else {
				System.out.println("Not present");
				break;
			}
		}

	}

	// Entering message
	public void enterMessage(String enter) {
		waitUntilVisiblity(messageShortCode).sendKeys(enter);
	}

	// Selecting Project
	public void selectProject_SmsShortCode() throws IOException {
		/*
		 * project_SmsShortCode).click(); List<WebElement> list =
		 * project_SmsShortCode_List); try { Thread.sleep(1000); } catch
		 * (InterruptedException e) { e.printStackTrace(); } for (WebElement ele : list)
		 * { System.out.println("Values " + ele.getAttribute("innerHTML")); if
		 * (ele.getAttribute("innerHTML").contains("gsd")) { ele).click();
		 * System.out.println("Selected");} else{ System.out.println("Not present");
		 * break; }
		 * 
		 * }
		 */

		Properties property1 = new Properties();
		FileInputStream fileInputObj1 = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//java//Config File//global.properties");
		property1.load(fileInputObj1);
		waitUntilClickable(project_SmsShortCode).click();
		List<WebElement> list = project_SmsShortCode_List;
		for (WebElement ele : list) {
			System.out.println("Values " + ele.getAttribute("innerHTML"));
			if (ele.getAttribute("innerHTML")
					.contains(property1.getProperty("project_trackingEmails_creatingCampaign_MandatoryFillTest"))) {
				waitUntilClickable(ele).click();
				System.out.println("Selected");
				break;
			}
		}

	}

	// Entering Source
//	public void selectSource_SmsShortCode(String source){
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		source_SmsShortCode).sendKeys(source);
//	}
	public void clickOnSaveButton_SmsShortcode() {
		waitUntilClickable(saveButton_SmsShortcode).click();
	}

	public void clickOnNextButton_SmsShortcode() {
		try {
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		waitUntilClickable(nextButton).click();
	}

	public void clickOnFinishButton() {
		try {
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		waitUntilClickable(finishButton).click();
	}

	public void clickOnSaveAndNextButton() {

		waitUntilClickable(saveAndNextButton).click();

	}
}