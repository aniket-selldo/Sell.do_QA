package POM.clientCreationPage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selldo.Utility.ReusableUtils;

public class PrepaidClientCreation extends ReusableUtils {

	public WebDriver driver;

	public PrepaidClientCreation(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.CSS, using = "#client_first_name")
	private WebElement enterClientFirstName;
	@FindBy(how = How.CSS, using = "#client_last_name")
	private WebElement enterClientLastName;
	@FindBy(how = How.CSS, using = "#client_password")
	private WebElement enterPassword;
	@FindBy(how = How.CSS, using = "#client_email")
	private WebElement enterClientEmail;
	@FindBy(how = How.CSS, using = "#client_phone")
	private WebElement enterClientPhone;
	@FindBy(how = How.CSS, using = "#client_name")
	private WebElement enterBuisnessName;
	@FindBy(how = How.XPATH, using = "//span[text()='Developer']")
	private WebElement selectBuisnessType;
	@FindBy(how = How.XPATH, using = "//span[text()='Real Estate']")
	private WebElement selectIndustryType;
	@FindBy(how = How.CSS, using = "#select2-drop li")
	private List<WebElement> selectDropdown;
	@FindBy(how = How.CSS, using = "#client_website")
	private WebElement enterClientWebSite;
	@FindBy(how = How.XPATH, using = "//span[text()='Default Custom']")
	private WebElement selectPlan;
	@FindBy(how = How.XPATH, using = "//iframe[@title='reCAPTCHA']")
	private WebElement frame_one;
	@FindBy(how = How.CSS, using = "#rc-imageselect")
	private WebElement imagesSelectionPanal;
	@FindBy(how = How.XPATH, using = "//div[@class='recaptcha-checkbox-border']")
	private WebElement clickOnCkeckBox;
	@FindBy(how = How.CSS, using = "#recaptcha-anchor")
	private WebElement getCAPTCHClassAttribute;
	@FindBy(how = How.CSS, using = ".btn.btn-primary.save")
	private WebElement clickOnSignUp;
	@FindBy(how = How.XPATH, using = "//label[@class='form-check-label']")
	private WebElement clickOnAreYouBroker;
	@FindBy(how = How.CSS, using = "#user_first_name")
	private WebElement user_first_name;
	@FindBy(how = How.CSS, using = "#user_last_name")
	private WebElement user_last_name;
	@FindBy(how = How.CSS, using = "#user_email")
	private WebElement user_email;
	@FindBy(how = How.CSS, using = "#user_phone")
	private WebElement user_phone;
	@FindBy(how = How.XPATH, using = "//input[@value='Save & Continue']")
	private WebElement clickOnSaveAndContinue;
	@FindBy(how = How.CSS, using = "#client_address_country")
	private WebElement selectClient_address_country;
	@FindBy(how = How.CSS, using = "#client_address_address1")
	private WebElement client_address_address1;
	@FindBy(how = How.CSS, using = "#client_address_address2")
	private WebElement client_address_address2;
	@FindBy(how = How.CSS, using = "#client_country_state")
	private WebElement selectClient_country_state;
	@FindBy(how = How.CSS, using = "#client_address_city")
	private WebElement client_address_city;
	@FindBy(how = How.CSS, using = "#client_address_zip")
	private WebElement client_address_zip;
	@FindBy(how = How.CSS, using = "#transactional_sms_mask")
	private WebElement transactional_sms_mask;
	@FindBy(how = How.CSS, using = "#promotional_sms_mask")
	private WebElement promotional_sms_mask;
	@FindBy(how = How.CSS, using = "#client_image")
	private WebElement client_image;
	@FindBy(how = How.XPATH, using = "//h4[text()='Awesome!']")
	private WebElement validateLastPage;
	@FindBy(how = How.LINK_TEXT, using = "Continue")
	private WebElement clickOnContinue;
	@FindBy(how = How.XPATH, using = "(//div[@class='small float-right mr-2 mt-2']/span)[1]")
	private WebElement clinetNameOnUIValidation;

	public void enterClientFirstName(String str) {
		waitUntilVisiblity(enterClientFirstName).sendKeys(str);
	}

	public void enterClientLastName(String str) {
		waitUntilVisiblity(enterClientLastName).sendKeys(str);
	}

	public void enterPassword(String str) {
		waitUntilVisiblity(enterPassword).sendKeys(str);
	}

	public void enterClientEmail(String str) {
		waitUntilVisiblity(enterClientEmail).sendKeys(str);
	}

	public void enterClientPhone(String str) {
		waitUntilVisiblity(enterClientPhone).sendKeys(str);
	}

	public void enterBuisnessName(String str) {
		waitUntilVisiblity(enterBuisnessName).sendKeys(str);
	}

	public void selectBuisnessType(String str) {
		waitUntilClickable(selectBuisnessType).click();
		waitUntilClickable(selectDropdown.stream().filter(S -> S.getText().equalsIgnoreCase(str)).findFirst().get()).click();
	}

	public void selectIndustryType(String str) {
		waitUntilClickable(selectIndustryType).click();
		waitUntilClickable(selectDropdown.stream().filter(S -> S.getText().equalsIgnoreCase(str)).findFirst().get()).click();
	}

	public void enterClientWebSite(String str) {
		waitUntilVisiblity(enterClientWebSite).sendKeys("https://www." + str + ".com");
	}

	public void selectPlan(String str) {
		waitUntilVisiblity(selectPlan).sendKeys(str);
		waitUntilClickable(selectDropdown.stream().filter(S -> S.getText().equalsIgnoreCase(str)).findFirst().get()).click();
	}

	public void clickOnSignUp() {
		waitUntilClickable(clickOnSignUp).click();
	}

	public void clickOnAreYouBroker(boolean flag) {
		if(flag) {
		waitUntilClickable(clickOnAreYouBroker).click();}
	}

	public void switchToCapta() {
		driver.switchTo().frame(frame_one);
		waitUntilClickable(clickOnCkeckBox).click();
		waitUntilAttributeValue(getCAPTCHClassAttribute, "aria-checked", "true", 100);
		driver.switchTo().defaultContent();
	}

	public void user_first_name(String str) {
		waitUntilVisiblity(user_first_name).sendKeys(str);
	}

	public void user_last_name(String str) {
		waitUntilVisiblity(user_last_name).sendKeys(str);
	}

	public void user_email(String str) {
		waitUntilVisiblity(user_email).sendKeys(str);
	}

	public void user_phone(String str) {
		waitUntilVisiblity(user_phone).sendKeys(str);
	}

	public void clickOnSaveAndContinue() {
		wait(6000);
		waitUntilClickable(clickOnSaveAndContinue).click();
	}

	public void client_address_address1(String str) {
		waitUntilVisiblity(client_address_address1,100).sendKeys(str);
	}

	public void client_address_address2(String str) {
		waitUntilVisiblity(client_address_address2).sendKeys(str);
	}

	public void selectClient_address_country() {
		selectByVisibleValue(selectClient_address_country, "India");
	}

	public void selectClient_country_state() {
		selectByVisibleValue(selectClient_country_state, "Maharashtra");
	}

	public void client_address_city(String str) {
		waitUntilVisiblity(client_address_city).sendKeys(str);
	}

	public void client_address_zip(int str) {
		waitUntilVisiblity(client_address_zip).sendKeys(String.valueOf(str));
	}

	public void transactional_sms_mask(String str) {
		waitUntilVisiblity(transactional_sms_mask).sendKeys(str);
	}

	public void promotional_sms_mask(String str) {
		waitUntilVisiblity(promotional_sms_mask).sendKeys(str);
	}

	public void client_image(String str) {
		waitUntilVisiblity(client_image).sendKeys(System.getProperty("user.dir") + "/DataFile/" + str + ".jpg");
	}

	public void clickOnContinue() {
		waitUntilClickable(clickOnContinue,100).click(); // need more time
	}

	public boolean validateClientName(String str) {
		return waitUntilClickable(clinetNameOnUIValidation).getText().equalsIgnoreCase(str);
	}

}
