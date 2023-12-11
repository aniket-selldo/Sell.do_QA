package com.selldo.POM.adminPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.selldo.Utility.ReusableUtils;

public class EditPartnerFormPage extends ReusableUtils {
	public WebDriver driver;

	public EditPartnerFormPage(WebDriver driver) {
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
	@FindBy(how = How.ID, using = "s2id_channel_partner_contact_salutation")
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
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'_alternate_email')]	")
	private WebElement alternateEmail;
	@FindBy(how = How.XPATH, using = "//*[@id=\"channel_partner_contact_designation\"]")
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
	@FindBy(how = How.CSS, using = "ul[class='select2-results'] li")
	private List<WebElement> propertyType_All;
	@FindBy(how = How.XPATH, using = "//label[text()='Min budget']/following::input[1]")
	private WebElement minBudget;
	@FindBy(how = How.XPATH, using = "//label[text()='Max budget']/following::input[1]")
	private WebElement maxBudget;
	@FindBy(how = How.XPATH, using = "//input[@data-disable-with='Saving']")
	private WebElement saveButton;
	@FindBy(how = How.CSS, using = "#modal-remote-form-inner > div > div > div.modal-header > button > i")
	private WebElement closeForm;
	@FindBy(how = How.XPATH, using = "//span[text()='salutation']")
	private WebElement salutations;
	@FindBy(how = How.CSS, using = "#select2-drop li")
	private List<WebElement> getAllSalutation;

	public void changePartnerName(String partner) {
		waitUntilVisiblity(name).clear();
		waitUntilVisiblity(name).sendKeys(partner);
	}

	public void selectDateOfJoining() {
		waitUntilVisiblity(dateOfJoining).clear();
		List<WebElement> dates = wholeCalender;
		int total_node = dates.size();
		for (int i = 0; i < total_node; i++) {
			String date = dates.get(i).getText();
			if (date.equals("10")) {
				waitUntilClickable(dates.get(i)).click();// Clicking on above selected date
				break;
			}
		}
	}

	public void changeSourceOfRecruitment(String source) {
		waitUntilVisiblity(sourceOfRequirement).clear();
		waitUntilVisiblity(sourceOfRequirement).sendKeys(source);
	}

	public void clickOnContactDetailsTab() {
		waitUntilClickable(contactDetails).click();
	}

	public void changeSalutation() {

		selectByIndex(salutation, 2);
	}
	public void selectSalutation(String salutatio) {
		waitUntilClickable(salutation).click();
		wait(1000);
		waitUntilClickable(
				getAllSalutation.stream().filter(S -> S.getText().equalsIgnoreCase(salutatio)).findFirst().get())
				.click();
	}

	public void changeFirstName(String fName) {
		waitUntilVisiblity(firstName).clear();
		waitUntilVisiblity(firstName).sendKeys(fName);
	}

	public void changeLastName(String lName) {
		waitUntilVisiblity(lastName).clear();
		waitUntilVisiblity(lastName).sendKeys(lName);
	}

	public void changePhone(String phone) {
		WebElement element = phoneField;
		waitUntilVisiblity(element).clear();
		waitUntilVisiblity(element).sendKeys(phone);
	}

	public void changeEmail(String pEmail) throws InterruptedException {
		waitUntilVisiblity(email).clear();
		Thread.sleep(1000);
		WebElement webElement = email;
		waitUntilVisiblity(webElement).sendKeys(pEmail);
	}

	public void changeAlternatePhone(String aPhone) {
		WebElement webElement = alternatePhone;
		waitUntilVisiblity(webElement).clear();
		waitUntilVisiblity(webElement).sendKeys(aPhone);

	}

	public void changeAlternateEmail(String aEmail) {
		waitUntilVisiblity(alternateEmail).clear();
		waitUntilVisiblity(alternateEmail).sendKeys(aEmail);
	}

	public void changeDesignation(String des) {
		waitUntilVisiblity(designation).clear();
		waitUntilVisiblity(designation).sendKeys(des);
	}

	public void changePanNumber(String pan) {
		waitUntilVisiblity(panNumber).sendKeys(pan);
	}

	public void clickOnSpecialization() {
		waitUntilClickable(specialization).click();
	}

	public void changeChannelPartnerType() {
		waitUntilClickable(channelPartnerType).click();
		List<WebElement> list = channelPartnerType_All;
		for (WebElement ele : list) {
			System.out.println("Values " + ele.getAttribute("innerHTML"));
			if (ele.getAttribute("innerHTML").contains("National")) {
				waitUntilClickable(ele).click();
				System.out.println("Clicked on Local");
				break;
			}
		}
	}

	public void changeReraNumber() {
		waitUntilVisiblity(reraNumber).clear();
		waitUntilVisiblity(reraNumber).sendKeys("200123457");
	}

	public void changePropertyType() {
		waitUntilClickable(propertyType).click();
		propertyType.clear();
		wait(2000);
		List<WebElement> list = propertyType_All;
		int index = (int) (Math.random() * propertyType_All.size());
		String str= waitUntilVisiblity(propertyType_All.get(index)).getText().trim();
		for (WebElement ele : list) {
			System.out.println("Values " + ele.getAttribute("innerHTML"));
			if (ele.getAttribute("innerHTML").contains(str)) {
				waitUntilClickable(ele).click();
				System.out.println("Clicked on Studio");
				break;
			}
		}
	}

	public void changeMinBudget(String min) {
		waitUntilVisiblity(minBudget).clear();
		waitUntilVisiblity(minBudget).sendKeys(min);
	}

	public void changeMaxBudget(String max) {
		waitUntilVisiblity(maxBudget).clear();
		waitUntilVisiblity(maxBudget).sendKeys(max);
	}

	public void clickOnSaveButton() {
		waitUntilClickable(saveButton).click();
	}

	public void closeForm() {
		waitUntilClickable(closeForm).click();
	}
}
