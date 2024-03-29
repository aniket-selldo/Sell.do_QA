package com.selldo.POM.adminPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selldo.Utility.ReusableUtils;

public class NewPartnerFormPage extends ReusableUtils {
	public WebDriver driver;

	public NewPartnerFormPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.ID, using = "channel_partner_name")
	private WebElement name;
	@FindBy(how = How.ID, using = "channel_partner_date_of_joining")
	private WebElement dateOfJoining;
	@FindBy(how = How.XPATH, using = "//div[@class='datepicker datepicker-dropdown dropdown-menu datepicker-orient-left datepicker-orient-top']//tr//td")
	private List<WebElement> wholeCalender;
	@FindBy(how = How.ID, using = "channel_partner_source_of_recruitment")
	private WebElement sourceOfRequirement;
	@FindBy(how = How.XPATH, using = "//a[@href='#channel-partner-contact']")
	private WebElement contactDetails;
	@FindBy(how = How.XPATH, using = "//span[text()='salutation']")
	private WebElement salutation;
	@FindBy(how = How.ID, using = "channel_partner_contact_first_name")
	private WebElement firstName;
	@FindBy(how = How.ID, using = "channel_partner_contact_last_name")
	private WebElement lastName;
	@FindBy(how = How.XPATH, using = "//label[@for='channel_partner_contact_phone']/following::input[1]")
	private WebElement phoneField;
	@FindBy(how = How.XPATH, using = "//label[@for='channel_partner_contact_email']/following::input[1]")
	private WebElement email;
	@FindBy(how = How.XPATH, using = "//label[text()='Alternate phone']/following::input[1]")
	private WebElement alternatePhone;
	@FindBy(how = How.XPATH, using = "//label[text()='Alternate email']/following::input[1]")
	private WebElement alternateEmail;
	@FindBy(how = How.XPATH, using = "//input[@id='channel_partner_contact_designation']")
	private WebElement designation;
	@FindBy(how = How.XPATH, using = "//input[@id='channel_partner_contact_pan']")
	private WebElement panNumber;
	@FindBy(how = How.XPATH, using = "//a[@href='#channel-partner-specialization']")
	private WebElement specialization;
	@FindBy(how = How.XPATH, using = "//label[text()='Channel partner type']/following::span[1]")
	private WebElement channelPartnerType;
	@FindBy(how = How.XPATH, using = "//ul[@class='select2-results']//li//div")
	private List<WebElement> channelPartnerType_All;
	@FindBy(how = How.XPATH, using = "//input[@name='channel_partner[rera_number]']")
	private WebElement reraNumber;
	@FindBy(how = How.XPATH, using = "//label[text()='Property type']/following::input[1]")
	private WebElement propertyType;
	@FindBy(how = How.XPATH, using = "//ul[@class='select2-results']//li//div")
	private List<WebElement> propertyType_All;
	@FindBy(how = How.XPATH, using = "//label[text()='Min budget']/following::input[1]")
	private WebElement minBudget;
	@FindBy(how = How.XPATH, using = "//label[text()='Max budget']/following::input[1]")
	private WebElement maxBudget;
	@FindBy(how = How.XPATH, using = "//input[@data-disable-with='Saving']")
	private WebElement saveButton;
	@FindBy(how = How.CSS, using = "#channel_partner_address_address1")
	private WebElement EnterAddress;
	@FindBy(how = How.CSS, using = "#channel_partner_address_address2")
	private WebElement EnterStreet;
	@FindBy(how = How.CSS, using = "#channel_partner_address_country")
	private WebElement selectCountry;
	@FindBy(how = How.CSS, using = "#crs_state")
	private WebElement selectState;
	@FindBy(how = How.CSS, using = "#channel_partner_address_city")
	private WebElement enterCity;
	@FindBy(how = How.CSS, using = "#channel_partner_address_zip")
	private WebElement enterZip;
	@FindBy(how = How.CSS, using = "#select2-drop li")
	private List<WebElement> getAllSalutation;

	public void enterPartnerName(String partner) {
		waitUntilVisiblity(name).sendKeys(partner);
	}

	public void selectDateOfJoining() {
		waitUntilClickable(dateOfJoining).click();
		List<WebElement> dates = wholeCalender;
		int total_node = dates.size();
		for (int i = 0; i < total_node; i++) {
			String date = dates.get(i).getText();
			if (date.equals("9")) {
				waitUntilClickable(dates.get(i)).click();// Clicking on above selected date
				break;
			}
		}
	}

	public void enterSourceOfRecruitment(String source) {
		waitUntilVisiblity(sourceOfRequirement).sendKeys(source);
	}

	public void clickOnContactDetailsTab() {
		waitUntilClickable(contactDetails).click();
		wait(3000);
	}

	public void selectSalutation(String salutatio) {
		waitUntilClickable(salutation).click();
		wait(1000);
		waitUntilClickable(
				getAllSalutation.stream().filter(S -> S.getText().equalsIgnoreCase(salutatio)).findFirst().get())
				.click();
	}

	public void enterFirstName(String fName) {
		waitUntilVisiblity(firstName).sendKeys(fName);
	}

	public void enterLastName(String lName) {
		waitUntilVisiblity(lastName).sendKeys(lName);
	}

	public void enterPhone(String phone) {
		waitUntilVisiblity(phoneField).sendKeys(phone);
	}

	public void enterEmail(String pEmail) {
		waitUntilVisiblity(email).sendKeys(pEmail);
	}

	public void enterAlternatePhone(String aPhone) {
		waitUntilVisiblity(alternatePhone).sendKeys(aPhone);
	}

	public void enterAlternateEmail(String aEmail) {
		waitUntilVisiblity(alternateEmail).sendKeys(aEmail);
	}

	public void enterDesignation(String des) {
		waitUntilVisiblity(designation).sendKeys(des);
	}

	public void enterPanNumber(String pan) {
		waitUntilVisiblity(panNumber).sendKeys(pan);
	}

	public void enterAddress(String address) {
		waitUntilVisiblity(EnterAddress).sendKeys(address);
	}

	public void enterStreet(String street) {
		waitUntilVisiblity(EnterStreet).sendKeys(street);
	}
	public void entercity(String city) {
		waitUntilVisiblity(enterCity).sendKeys(city);
	}

	public void selectCountry(String country) {
		selectByVisibleText(selectCountry, country);
	}

	public void selectState(String state) {
		selectByVisibleText(selectState, state);
	}

	public void enterZip(String zip) {
		waitUntilVisiblity(enterZip).sendKeys(zip);
	}

	public void clickOnSpecialization() {
		scrollIntoViewUp(specialization);
		wait(1000);
		waitUntilClickable(specialization).click();
	}

	public void selectChannelPartnerType() {
		waitUntilClickable(channelPartnerType).click();
		List<WebElement> list = channelPartnerType_All;
		for (WebElement ele : list) {
			System.out.println("Values " + ele.getAttribute("innerHTML"));
			if (ele.getAttribute("innerHTML").contains("Local")) {
				waitUntilClickable(ele).click();
				System.out.println("Clicked on Local");
				break;
			}
		}
	}

	public void enterReraNumber() {
		waitUntilVisiblity(reraNumber).sendKeys("123456");
	}

	public void selectPropertyType() {
		waitUntilClickable(propertyType).click();
		List<WebElement> list = propertyType_All;
		for (WebElement ele : list) {
			System.out.println("Values " + ele.getAttribute("innerHTML"));
			if (ele.getAttribute("innerHTML").contains("Studio")) {
				waitUntilClickable(ele).click();
				System.out.println("Clicked on Studio");
				break;
			}
		}
	}

	public void enterMinBudget(String min) {
		waitUntilVisiblity(minBudget).sendKeys(min);
	}

	public void enterMaxBudget(String max) {
		waitUntilVisiblity(maxBudget).sendKeys(max);
	}

	public void clickOnSaveButton() {
		wait(3000);
		scrollIntoView(saveButton);
		waitUntilClickable(saveButton).click();
		waitUntilInvisibility(saveButton);
	}

}
