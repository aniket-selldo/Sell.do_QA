package POM.clientCreationPage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.selldo.Utility.ReusableUtils;

public class createClientPage extends ReusableUtils {

	public WebDriver driver;

	public createClientPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.ID, using = "btn-add-client")
	private WebElement addClientButton;
	@FindBy(how = How.ID, using = "client_first_name")
	private WebElement firstName;
	@FindBy(how = How.ID, using = "client_last_name")
	private WebElement lastName;
	@FindBy(how = How.ID, using = "client_name")
	private WebElement buisnessName;
	@FindBy(how = How.ID, using = "s2id_client_business_type")
	private WebElement buisnessType;
	@FindBy(how = How.CSS, using = ".select2-result-label")
	private WebElement selectbuisnessType;
	@FindBy(how = How.ID, using = "client_short_name")
	private WebElement shortName;
	@FindBy(how = How.ID, using = "client_website")
	private WebElement clientWebsite;
	@FindBy(how = How.ID, using = "client_email")
	private WebElement clientEmail;
	@FindBy(how = How.XPATH, using = "//input[@type='file']")
	private WebElement uploadFile;
	@FindBy(how = How.CSS, using = "input[data-field='client[phone]']")
	private WebElement clientPhone;
	@FindBy(how = How.ID, using = "transactional_sms_mask")
	private WebElement mask;
	@FindBy(how = How.XPATH, using = "//*[text()='Real Estate']")
	private WebElement clickIndustryType;
	@FindBy(how = How.CSS, using = "#select2-drop input")
	private WebElement enterIndustryType;
	@FindBy(how = How.CSS, using = "#select2-drop li")
	private List<WebElement> clickOnIndustryType;
	@FindBy(how = How.ID, using = "client_address_attributes_address1")
	private WebElement clientAddress;
	@FindBy(how = How.ID, using = "client_address_attributes_country")
	private WebElement clientCountry;
	@FindBy(how = How.XPATH, using = "//select[@name='client[address_attributes][state]']")
	private WebElement clientState;
	@FindBy(how = How.ID, using = "client_address_attributes_city")
	private WebElement clientCity;
	@FindBy(how = How.ID, using = "client_address_attributes_zip")
	private WebElement clientZip;
	@FindBy(how = How.ID, using = "user_first_name")
	private WebElement userFirstName;
	@FindBy(how = How.ID, using = "user_last_name")
	private WebElement userLastName;
	@FindBy(how = How.CSS, using = "input[class='form-control phone_number non_form_field unique_phone']")
	private WebElement userPhone;
	@FindBy(how = How.ID, using = "user_email")
	private WebElement userEmail;
	@FindBy(how = How.ID, using = "team_name")
	private WebElement userTeam;
	@FindBy(how = How.ID, using = "//*[text()='Select Vendor']")
	private List<WebElement> vendors;
	@FindBy(how = How.XPATH, using = "(//div[@class='select2-result-label'])[1]")
	private WebElement selectvendor;
	@FindBy(how = How.XPATH, using = "(//span[@class='select2-chosen'])[8]")
	private WebElement selectvendor1;
	@FindBy(how = How.XPATH, using = "(//span[@class='select2-chosen'])[9]")
	private WebElement selectvendor2;
	@FindBy(how = How.XPATH, using = "(//span[@class='select2-chosen'])[10]")
	private WebElement selectvendor3;
	@FindBy(how = How.XPATH, using = "(//span[@class='select2-chosen'])[11]")
	private WebElement selectvendor4;
	@FindBy(how = How.XPATH, using = "(//span[@class='select2-chosen'])[12]")
	private WebElement selectMarketingDomain;
	@FindBy(how = How.CSS, using = "input[class='btn btn-primary']")
	private WebElement clickOnSave;
	// ---------------Prepaid Client------------------
	@FindBy(how = How.ID, using = "client_first_name")
	private WebElement enterFirstName;
	@FindBy(how = How.ID, using = "client_last_name")
	private WebElement enterLastName;
	@FindBy(how = How.ID, using = "client_password")
	private WebElement enterPassword;
	@FindBy(how = How.ID, using = "client_email")
	private WebElement enterEmail;
	@FindBy(how = How.ID, using = "client_phone")
	private WebElement enterMobile;
	@FindBy(how = How.ID, using = "client_name")
	private WebElement enterBuisnessName;
	@FindBy(how = How.XPATH, using = "//span[text()='Developer']")
	private WebElement selectBuisnessType;
	@FindBy(how = How.XPATH, using = "//span[text()='Real Estate']")
	private WebElement selectIndustry;
	@FindBy(how = How.ID, using = "client_website")
	private WebElement enterWebsite;
	@FindBy(how = How.XPATH, using = "//span[text()='Default Custom']")
	private WebElement selectPlan;
	@FindBy(how = How.ID, using = "rc-anchor-container")
	private WebElement tikOnRobot;
	@FindBy(how = How.CSS, using = ".btn.btn-primary.save")
	private WebElement clickOnSignup;
	@FindBy(how = How.CSS, using = ".select2-result-label") // 0-> Deveploper || 1 -> Broker
	private List<WebElement> selectDropdown; // RealEstate , Education, BFSI ,Generic
	@FindBy(how = How.XPATH, using = "//iframe[@title='reCAPTCHA']")
	private WebElement frameSwitch;
	@FindBy(how = How.XPATH, using = "//div[@class='noty_message']")
	private WebElement succesPopup;

	public void clickOnClientButton() {
		Square(addClientButton);
		jsClick(addClientButton);

	}

	public void enterFirstName(String name) {
		waitUntilVisiblity(firstName);
		Square(firstName);
		firstName.sendKeys(random("firstName", "AN", 7));
	}

	public void enterLastName(String name) {
		Square(lastName);
		lastName.sendKeys(name);
	}

	public void enterBuisnessName(String name) {
		Square(buisnessName);
		buisnessName.sendKeys(name);
	}

	public void selectBuisnessType() {
		Square(buisnessType);
		buisnessType.click();
		selectbuisnessType.click();
	}

	public void shortName(String name) {
		Square(shortName);
		shortName.sendKeys(name);
	}

	public void enterClientWebsite(String name) {
		Square(clientWebsite);
		clientWebsite.sendKeys("https://www." + name + ".com");
	}

	public void enterclinetEmail(String name) {
		Square(clientEmail);
		clientEmail.sendKeys("aniket.khandizodC+" + name + "@sell.do");
	}

	public void uploadFile(String fileName) {
		Square(uploadFile);
		uploadFile.sendKeys(System.getProperty("user.dir") + "/DataFile/" + fileName + ".jpg");// nun
	}

	public void enterClientPhone(String number) {
		Square(clientPhone);
		clientPhone.sendKeys("+91 " + "9" + number + "");
	}

	public void enterMask(String Mask) {
		Square(mask);
		mask.sendKeys(Mask);
	}
	public void selectIndustry(int index) {
		Square(clickIndustryType);
		clickIndustryType.click();
		waitUntilVisibilityOfElements(clickOnIndustryType);
		Square(clickOnIndustryType.get(index));
		clickOnIndustryType.get(index).click();
		
	}

	public void enterAddres(String address) {
		Square(clientAddress);
		clientAddress.sendKeys(address);
	}

	public void enterCountry(int country) {
		Square(clientCountry);
		selectByIndex(clientCountry, country);
	}

	public void enterState(int state) {
		Square(clientState);
		selectByIndex(clientState, state);
	}

	public void enterCity(String city) {
		Square(clientCity);
		clientCity.sendKeys(city);
	}

	public void enterZip(int zip) {
		Square(clientZip);
		clientZip.sendKeys(String.valueOf(zip));
	}

	public void enterUserFirstName(String name) {
		Square(userFirstName);
		userFirstName.sendKeys(name);

	}

	public void enterUserLasttName(String name) {
		Square(userLastName);
		userLastName.sendKeys(name);

	}

	public void enterUserPhone(String number) {
		Square(userPhone);
		userPhone.sendKeys("+91 " + "9" + number + "");

	}

	public void enterEmail(String email) {
		Square(userEmail);
		userEmail.sendKeys("aniket.khandizod+U" + email + "@sell.do");

	}

	public void enterUserTeam(String team) {
		Square(userTeam);
		userTeam.sendKeys(team);
		scrollIntoView(driver.findElement(By.cssSelector("[class='btn btn-primary']")));
	}

	public void selectVendores() {
		Square(selectvendor1);
		selectvendor1.click();
		selectvendor.click();
		Square(selectvendor2);
		selectvendor2.click();
		selectvendor.click();
		Square(selectvendor3);
		selectvendor3.click();
		selectvendor.click();
		Square(selectvendor4);
		selectvendor4.click();
		selectvendor.click();
		Square(selectMarketingDomain);
		selectMarketingDomain.click();
		selectvendor.click();
	}

	public String clickOnsave() {
		Square(clickOnSave);
		clickOnSave.click();
		System.out.println(succesPopup.getText());
		return succesPopup.getText();
	}
//--------------------------PrePaid--------------------------------------
	public void landOnPrepidpage() {
		driver.get(getGobalData().getProperty("PrepaidClient"));
	}

	public void enterfirstNamePrePaid(String firstName) {
		Square(enterFirstName);
		enterFirstName.sendKeys(firstName);
	}

	public void enterLastNamePrePaid(String lastName) {
		Square(enterLastName);
		enterLastName.sendKeys(lastName);
	}

	public void enterPasswordPrePaid(String phone) {
		Square(enterPassword);
		enterPassword.sendKeys(phone);
	}

	public void enterEmaillPrePaid(String email) {
		Square(enterEmail);
		enterEmail.sendKeys("" + email + "@sell.do");
	}

	public void enterMobilePrePaid(String mobile) {
		Square(enterMobile);
		enterMobile.sendKeys("+91 " + "9" + mobile + "");
	}

	public void landOnPrepidpagePrePaid(String enterBuisnessNamee) {
		scrollIntoView(enterBuisnessName);
		Square(enterBuisnessName);
		enterBuisnessName.sendKeys(enterBuisnessNamee);
	}

	public void selectBuisnessTypeePrePaid(int index) {
		Square(selectBuisnessType);
		(selectBuisnessType).click();
		(selectDropdown.get(index)).click();

	}

	public void selectIndustryPrePaid(int index) {
		Square(selectIndustry);
		(selectIndustry).click();
		(selectDropdown.get(index)).click();
	}

	public void selectWebsitePrePaid(String email) {
		Square(enterWebsite);
		enterWebsite.sendKeys("https://" + email + ".com");

	}

	public void clickOnSignupPrePaid() {
		frameSwitch(frameSwitch);
		Assert.assertFalse(driver.findElement(By.id("rc-anchor-container")).isDisplayed(),"CAPTCHA is disabled");
		defaultContentSwitch();
		Square(clickOnSignup);
		(clickOnSignup).click();
	}

}
