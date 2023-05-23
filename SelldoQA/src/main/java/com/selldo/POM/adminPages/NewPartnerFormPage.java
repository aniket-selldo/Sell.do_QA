package com.selldo.POM.adminPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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
	@FindBy(how = How.ID, using = "channel_partner_contact_salutation")
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

	public void enterPartnerName(String partner) {
		name.sendKeys(partner);
	}

	public void selectDateOfJoining() {
		dateOfJoining.click();
		List<WebElement> dates = wholeCalender;
		int total_node = dates.size();
		for (int i = 0; i < total_node; i++) {
			String date = dates.get(i).getText();
			if (date.equals("9")) {
				dates.get(i).click();// Clicking on above selected date
				break;
			}
		}
	}

	public void enterSourceOfRecruitment(String source) {
		sourceOfRequirement.sendKeys(source);
	}

	public void clickOnContactDetailsTab() {
		contactDetails.click();
	}

	public void selectSalutation() {
		Select oSelect = new Select(salutation);
		oSelect.selectByIndex(1);
	}

	public void enterFirstName(String fName) {
		firstName.sendKeys(fName);
	}

	public void enterLastName(String lName) {
		lastName.sendKeys(lName);
	}

	public void enterPhone(String phone) {
		phoneField.sendKeys(phone);
	}

	public void enterEmail(String pEmail) {
		email.sendKeys(pEmail);
	}

	public void enterAlternatePhone(String aPhone) {
		alternatePhone.sendKeys(aPhone);
	}

	public void enterAlternateEmail(String aEmail) {
		alternateEmail.sendKeys(aEmail);
	}

	public void enterDesignation(String des) {
		designation.sendKeys(des);
	}

	public void enterPanNumber(String pan) {
		panNumber.sendKeys(pan);
	}

	public void clickOnSpecialization() {
		specialization.click();
	}

	public void selectChannelPartnerType() {
		channelPartnerType.click();
		List<WebElement> list = channelPartnerType_All;
		for (WebElement ele : list) {
			System.out.println("Values " + ele.getAttribute("innerHTML"));
			if (ele.getAttribute("innerHTML").contains("Local")) {
				ele.click();
				System.out.println("Clicked on Local");
				break;
			}
		}
	}

	public void enterReraNumber() {
		reraNumber.sendKeys("123456");
	}

	public void selectPropertyType() {
		propertyType.click();
		List<WebElement> list = propertyType_All;
		for (WebElement ele : list) {
			System.out.println("Values " + ele.getAttribute("innerHTML"));
			if (ele.getAttribute("innerHTML").contains("Studio")) {
				ele.click();
				System.out.println("Clicked on Studio");
				break;
			}
		}
	}

	public void enterMinBudget(String min) {
		minBudget.sendKeys(min);
	}

	public void enterMaxBudget(String max) {
		maxBudget.sendKeys(max);
	}

	public void clickOnSaveButton() {
		saveButton.click();
	}

}
