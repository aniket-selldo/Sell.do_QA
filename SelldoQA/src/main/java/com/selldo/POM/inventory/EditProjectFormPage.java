package com.selldo.POM.inventory;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selldo.Utility.ReusableUtils;

public class EditProjectFormPage extends ReusableUtils {
	public WebDriver driver;

	public EditProjectFormPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//label[@for='project_project_name']/following::span[1]")
	private WebElement projectNameSpan;
	@FindBy(how = How.XPATH, using = "//*[@id='select2-drop']//div//input")
	private WebElement projectNameInputField;
	@FindBy(how = How.XPATH, using = "//input[@type='submit']")
	private WebElement saveButton;
	@FindBy(how = How.XPATH, using = "//a[text()='Address']")
	private WebElement addressLink;
	@FindBy(how = How.XPATH, using = "//a[text()='Virtual Walkthrough']")
	private WebElement virtualWalkthroughLink;
	@FindBy(how = How.XPATH, using = "//a[text()='Details']")
	private WebElement detailsLink;
	@FindBy(how = How.XPATH, using = "//a[text()='Specifications and amenities']")
	private WebElement specificationsAndAmeneties;
	@FindBy(how = How.XPATH, using = "//a[text()='Edit price quote and brochure']")
	private WebElement editPriceQuotesAndBrochureLink;
	@FindBy(how = How.XPATH, using = "//a[text()='Upload Images']")
	private WebElement uploadImageLink;
	@FindBy(how = How.XPATH, using = "//a[text()='Portal Integration Codes']")
	private WebElement portalIntegrationCodesLink;
	@FindBy(how = How.XPATH, using = "//a[text()='Cost template']")
	private WebElement costTemplateLink;
	@FindBy(how = How.XPATH, using = "//a[text()='Email Templates']")
	private WebElement emailTemplatesLink;
	@FindBy(how = How.XPATH, using = "//a[text()='Sms Templates']")
	private WebElement smsTemplatesLink;
	@FindBy(how = How.XPATH, using = "//a[text()='Previous demand letters']")
	private WebElement previousDemandLettersLink;
	@FindBy(how = How.XPATH, using = "//a[text()='View Developer']")
	private WebElement viewDeveloperLink;
	@FindBy(how = How.XPATH, using = "//a[text()='View Available Project Towers']")
	private WebElement viewAvailableProjectTowersLink;
	@FindBy(how = How.XPATH, using = "//a[text()='View Available Floor Plans']")
	private WebElement viewAvailableFloorPlansLink;

	public void changeProjectName(String project) throws InterruptedException {
		projectNameSpan.click();
		projectNameInputField.sendKeys(project);
		Thread.sleep(2000);
		projectNameInputField.sendKeys(Keys.ENTER);
	}

	public void clickOnAddressLink() {
		addressLink.click();
	}

	public void clickOnVirtualWalkThroughLink() {
		virtualWalkthroughLink.click();
	}

	public void clickOnDetailsLink() {
		detailsLink.click();
	}

	public void clickOnSpecificationAndAmenitiesLink() {
		specificationsAndAmeneties.click();
	}

	public void clickOnEditPriceQuotesAndBrochureLink() {
		editPriceQuotesAndBrochureLink.click();
	}

	public void clickOnUploadImagesLink() {
		uploadImageLink.click();
	}

	public void clickOnPortalIntegrationCodesLink() {
		portalIntegrationCodesLink.click();
	}

	public void clickOnCostTemplateLink() {
		costTemplateLink.click();
	}

	public void clickOnEmailTemplateLink() {
		emailTemplatesLink.click();
	}

	public void clickOnSmsTemplateLink() {
		smsTemplatesLink.click();
	}

	public void clickOnPreviousDemandLettersLink() {
		previousDemandLettersLink.click();
	}

	public void clickOnViewDeveloperLink() {
		viewDeveloperLink.click();
	}

	public void clickOnViewAvailableProjectTowersLink() {
		viewAvailableProjectTowersLink.click();
	}

	public void clickOnViewAvailableFloorPlansLink() {
		viewAvailableFloorPlansLink.click();
	}

	public void clickOnSaveButton() {
		saveButton.click();
	}

}
