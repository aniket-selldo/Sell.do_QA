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
		waitUntilClickable(projectNameSpan).click();
		waitUntilVisiblity(projectNameInputField).sendKeys(project);
		wait(500);
		waitUntilVisiblity(projectNameInputField).sendKeys(Keys.ENTER);
	}

	public void clickOnAddressLink() {
		waitUntilClickable(addressLink).click();
	}

	public void clickOnVirtualWalkThroughLink() {
		waitUntilClickable(virtualWalkthroughLink).click();
	}

	public void clickOnDetailsLink() {
		waitUntilClickable(detailsLink).click();
	}

	public void clickOnSpecificationAndAmenitiesLink() {
		waitUntilClickable(specificationsAndAmeneties).click();
	}

	public void clickOnEditPriceQuotesAndBrochureLink() {
		waitUntilClickable(editPriceQuotesAndBrochureLink).click();
	}

	public void clickOnUploadImagesLink() {
		waitUntilClickable(uploadImageLink).click();
	}

	public void clickOnPortalIntegrationCodesLink() {
		waitUntilClickable(portalIntegrationCodesLink).click();
	}

	public void clickOnCostTemplateLink() {
		waitUntilClickable(costTemplateLink).click();
	}

	public void clickOnEmailTemplateLink() {
		waitUntilClickable(emailTemplatesLink).click();
	}

	public void clickOnSmsTemplateLink() {
		waitUntilClickable(smsTemplatesLink).click();
	}

	public void clickOnPreviousDemandLettersLink() {
		waitUntilClickable(previousDemandLettersLink).click();
	}

	public void clickOnViewDeveloperLink() {
		waitUntilClickable(viewDeveloperLink).click();
	}

	public void clickOnViewAvailableProjectTowersLink() {
		waitUntilClickable(viewAvailableProjectTowersLink).click();
	}

	public void clickOnViewAvailableFloorPlansLink() {
		waitUntilClickable(viewAvailableFloorPlansLink).click();
	}

	public void clickOnSaveButton() {
		waitUntilClickable(saveButton).click();
	}

}
