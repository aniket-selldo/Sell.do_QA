package com.selldo.POM.inventory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selldo.Utility.ReusableUtils;

public class NewDeveloperFormPage extends ReusableUtils {
	public WebDriver driver;

	public NewDeveloperFormPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//span[text()='Developer name']")
	private WebElement developerName;
	@FindBy(how = How.XPATH, using = "//*[@id='select2-drop']//div//input")
	private WebElement developerNameInputField;
	@FindBy(how = How.XPATH, using = "//div[@class='note-editable card-block']")
	private WebElement description;
	@FindBy(how = How.XPATH, using = "//input[@id='developer_address_address1']")
	private WebElement address;
	@FindBy(how = How.XPATH, using = "//input[@id='developer_address_address2']")
	private WebElement street;
	@FindBy(how = How.XPATH, using = "//input[@id='developer_address_city']")
	private WebElement city;
	@FindBy(how = How.CSS, using = "select[name=\"developer[address][state]\"]")
	private WebElement stateDropdown;
	@FindBy(how = How.XPATH, using = "//select[@id='developer_address_country']")
	private WebElement countryDropdown;
	@FindBy(how = How.XPATH, using = "//input[@id='developer_address_zip']")
	private WebElement zip;
	@FindBy(how = How.XPATH, using = "//div[@id='s2id_developer_contact_salutation']")
	private WebElement salutation;
	@FindBy(how = How.XPATH, using = "//input[@id='developer_contact_first_name']")
	private WebElement firstName;
	@FindBy(how = How.XPATH, using = "//input[@id='developer_contact_last_name']")
	private WebElement lastName;
	@FindBy(how = How.XPATH, using = "//label[@for='developer_contact_phone']/following::input[1]")
	private WebElement phone;
	@FindBy(how = How.XPATH, using = "//input[@id='developer_contact_email']")
	private WebElement email;
	@FindBy(how = How.XPATH, using = "//input[@type='submit']")
	private WebElement saveButton;
	@FindBy(how = How.XPATH, using = "//a[text()='All Developers']")
	private WebElement allDevelopersLink;
	@FindBy(how = How.XPATH, using = "//body/div[@id='select2-drop']/ul[1]/li[1]/div[1]")
	private List<WebElement> salutation_textbox;
	@FindBy(how = How.CSS, using = "label[class='lead']")
	private WebElement getDevlopersName;
	@FindBy(how = How.CSS, using = "li[class='breadcrumb-item active']")
	private WebElement getDevlopersName2;
	@FindBy(how = How.XPATH, using = "(//input[@placeholder='Phone'])[1]")
	private WebElement enterPhone;
	@FindBy(how = How.XPATH, using = "(//input[@placeholder='Phone'])[2]")
	private WebElement enterAlterNateNumber;
	@FindBy(how = How.CSS, using = "input#developer_contact_email")
	private WebElement enterEmail;
	@FindBy(how = How.CSS, using = "input#developer_contact_alternate_email")
	private WebElement alternateEmail;
	@FindBy(how = How.CSS, using = "input#developer_contact_designation")
	private WebElement designation;
	@FindBy(how = How.CSS, using = "input#developer_contact_pan")
	private WebElement PAN;
	@FindBy(how = How.XPATH, using = "//tbody/tr/td/a")
	private List<WebElement> getAnyDevloperName;
	
	public String getAnyDevloperName() {
        int index = (int)(Math.random() * getAnyDevloperName.size());
		return waitUntilVisiblity(getAnyDevloperName.get(index)).getText().trim();
	}

	public String getDevlopersName() {
		return waitUntilVisiblity(getDevlopersName).getText().trim();
	}

	public String getDevlopersName2() {
		return waitUntilVisiblity(getDevlopersName2).getText().trim();
	}

	public void enterDeveloperName(String developer) throws InterruptedException {
		waitUntilClickable(developerName).click();
		waitUntilVisiblity(developerNameInputField).sendKeys(developer);
		wait(2000);
		waitUntilVisiblity(developerNameInputField).sendKeys(Keys.ENTER);
	}

	public String generateRandomString() {
		String CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		int RANDOM_STRING_LENGTH = 5;
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

	public void enterDescription(String des) {
		waitUntilVisiblity(description).sendKeys(des);
	}

	public void enterAddress(String add) {
		waitUntilVisiblity(address).sendKeys(add);
	}

	public void enterStreet(String str) {
		waitUntilVisiblity(street).sendKeys(str);
	}

	public void enterCity(String ct) {
		waitUntilVisiblity(city).sendKeys(ct);
	}

	public void selectState(String state) {
		selectByVisibleText(stateDropdown, state);
	}

	public void selectCountry(String country) {
		selectByVisibleText(countryDropdown, country);
	}

	public void enterZip(String zp) {
		waitUntilVisiblity(zip).sendKeys(zp);
	}

	public void selectSalutation() throws IOException {
		
		wait(500);
		Properties property = new Properties();
		FileInputStream fileInputObj = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//java//Config File//global.properties");
		property.load(fileInputObj);
		waitUntilClickable(salutation).click();
		List<WebElement> list = salutation_textbox;
		for (WebElement ele : list) {
			System.out.println("Values " + ele.getAttribute("innerHTML"));
			if (ele.getAttribute("innerHTML").contains(property.getProperty("Select_Salutation"))) {
				waitUntilClickable(ele).click();
				System.out.println("Selected");
				break;
			}
		}

		/*
		 * Select oSelect = new Select(salutation)); oSelect.selectByVisibleText("Ms.");
		 */
	}

	public void enterFirstName(String fName) {
		waitUntilVisiblity(firstName).sendKeys(fName);
	}

	public void enterLastName(String lName) {
		waitUntilVisiblity(lastName).sendKeys(lName);
	}

	public void enterPhoneNumber(String ph) {
		waitUntilVisiblity(phone).sendKeys(ph);
	}

	public void enterEmail(String eml) {
		waitUntilVisiblity(email).sendKeys(eml);
	}

	public void clickOnSaveButton() {
		waitUntilClickable(saveButton).click();
	}

	public void clickOnAllDevelopersLink() {
		waitUntilClickable(allDevelopersLink).click();
	}
	
	public void alternateEmail(String eml) {
		waitUntilVisiblity(alternateEmail).sendKeys(eml);
	}
	public void PAN(String eml) {
		waitUntilVisiblity(PAN).sendKeys(eml);
	}
	public void enterAlternateNumber(String eml) {
		waitUntilVisiblity(enterAlterNateNumber).sendKeys(eml);
	}
	public void designation(String eml) {
		waitUntilVisiblity(designation).sendKeys(eml);
	}

}
