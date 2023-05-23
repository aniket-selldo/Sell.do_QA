package com.selldo.POM.crm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selldo.Utility.ReusableUtils;

public class MergeLeadsPage extends ReusableUtils {
	public WebDriver driver;

	public MergeLeadsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Enter lead_id#/email/phone']")
	private WebElement SearchField;
	@FindBy(how = How.XPATH, using = "//span[text()='Search Leads']")
	private WebElement SearchLeadsButton;
	@FindBy(how = How.XPATH, using = ".//*[@id='merge_leads_form']/div/div/div[3]/button[1]")
	private WebElement CloseButton;
	@FindBy(how = How.XPATH, using = "//a[text()='Merge this']	")
	private WebElement MergeThisLink;
	@FindBy(how = How.XPATH, using = "//label[text()='Please add notes as you merge these leads?']/following::textarea[1]")
	private WebElement AddNote;
	@FindBy(how = How.XPATH, using = "//button[text()='Merge leads']")
	private WebElement MergeLeadsButton;

	public void searchingLeadToBeMerged(String lead_m) throws InterruptedException {
		SearchField.sendKeys(lead_m);
		Thread.sleep(2000);
		SearchLeadsButton.click();
	}

	public void clickOnMergeThisButton() {
		MergeThisLink.click();
	}

	public void enteringSomeNotes(String note) {
		AddNote.sendKeys(note);
	}

	public void clickOnMergeLeadsButton() {
		MergeLeadsButton.click();
	}

	public void clickOnCloseButton() {
		CloseButton.click();
	}

}
