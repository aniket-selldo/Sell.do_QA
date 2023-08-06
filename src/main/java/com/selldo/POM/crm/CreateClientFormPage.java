package com.selldo.POM.crm;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.selldo.Utility.GetTestData;
import com.selldo.Utility.ReusableUtils;

public class CreateClientFormPage extends ReusableUtils {

	public WebDriver driver;

	public CreateClientFormPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	// Client Details

	@FindBy(how = How.ID, using = "client_first_name")
	private WebElement clientFirstNameField;
	@FindBy(how = How.ID, using = "client_last_name")
	private WebElement clientLastNameField;
	@FindBy(how = How.CSS, using = "[data-field=\"client[phone]\"]")
	private WebElement clientPhoneNumber;
	@FindBy(how = How.XPATH, using = "//input[@id='client_name']")
	private WebElement BusinessNameField;
	@FindBy(how = How.XPATH, using = "//input[@id='client_short_name']")
	private WebElement ShortNameField;
	@FindBy(how = How.XPATH, using = "//input[@name='client[website]']")
	private WebElement WebsiteField;
	@FindBy(how = How.XPATH, using = "//input[@id='client_email']")
	private WebElement EmailField_CD;
	@FindBy(how = How.XPATH, using = "//input[@name='client[email_domain]']")
	private WebElement EmailDomainField;
	@FindBy(how = How.XPATH, using = "//input[@id='client_setup_charges']")
	private WebElement SetUpChargesField;
	// By UploadLogoButton = @FindBy(how = How.XPATH, using
	// ="//input[@id='client_image']") private WebElement ;
	@FindBy(how = How.CSS, using = "input#client_image")
	private WebElement UploadLogoButton;
	@FindBy(how = How.XPATH, using = "//h3[text()='Client details']/following::input[8]")
	private WebElement PhoneField_CD;
	@FindBy(how = How.XPATH, using = "//body/div[@class='wrapper']/div[@id='content']/form[@id='client_form']/div[@class='panel panel-default']/div[@class='panel-body']/div[@class='row']/div[@class='col-md-6 col-sm-12']/div[1]/div[1]/input[1]")
	private WebElement clientPhone;
	@FindBy(how = How.XPATH, using = "//span[text()='Choose City For Indian PRI(Landline)']")
	private WebElement CityForIndianPRIDropdown;
	@FindBy(how = How.XPATH, using = ".//*[@id='select2-drop']/div/input")
	private WebElement CityForIndianPRIField;
	@FindBy(how = How.XPATH, using = ".//*[@id='select2-drop']/ul/li/div")
	private WebElement CityForIndianPRI_dd;
	@FindBy(how = How.XPATH, using = "//label[text()='Indian PRI (Landline)']/following::span[1]")
	private WebElement IndianPRIDropdown;
	@FindBy(how = How.XPATH, using = ".//*[@id='select2-drop']/div/input")
	private WebElement IndianPRIField;
	@FindBy(how = How.XPATH, using = ".//*[@id='select2-drop']/ul/li[1]/div")
	private WebElement IndianPRI_dd;
	@FindBy(how = How.XPATH, using = "//label[text()='Circle for Indian Mobile Number']/following::span[1]")
	private WebElement CircleForIndianMobileNumberDropdown;
	@FindBy(how = How.XPATH, using = ".//*[@id='select2-drop']/div/input")
	private WebElement CircleForIndianMobileNumberField;
	@FindBy(how = How.XPATH, using = ".//*[@id='select2-drop']/ul/li/div")
	private WebElement CircleForIndianMobileNumber_dd;
	@FindBy(how = How.XPATH, using = "//label[text()='Indian Mobile Numbers']/following::span[1]")
	private WebElement IndianMobileNumbersDropdown;
	@FindBy(how = How.XPATH, using = ".//*[@id='select2-drop']/div/input")
	private WebElement IndianMobileNumberField;
	@FindBy(how = How.XPATH, using = "//input[@id='transactional_sms_mask']")
	private WebElement SMSMaskField;
	@FindBy(how = How.XPATH, using = "")
	private WebElement PhoneMaskField;
	@FindBy(how = How.ID, using = "s2id_autogen6")
	private WebElement VirtualNumbersField;
	@FindBy(how = How.XPATH, using = ".//*[@id='select2-drop']/ul/li/div/span")
	private WebElement VirtualNumber_dd;
	@FindBy(how = How.XPATH, using = "//select[@id='client_time_zone']")
	private WebElement TimeZoneDropdown_CD;
	@FindBy(how = How.XPATH, using = "//input[@id='client_contract_end_date']")
	private WebElement ContractDate;
	@FindBy(how = How.XPATH, using = "//div[@class='datepicker datepicker-dropdown dropdown-menu datepicker-orient-left datepicker-orient-bottom']")
	private WebElement WholeCalender;

	// Client Address

	@FindBy(how = How.XPATH, using = "//input[@id='client_address_attributes_address1']")
	private WebElement Address1Field;
	@FindBy(how = How.XPATH, using = "//input[@id='client_address_attributes_address2']")
	private WebElement Address2Field;
	@FindBy(how = How.XPATH, using = "//input[@id='client_address_attributes_city']")
	private WebElement CityField;
	@FindBy(how = How.XPATH, using = "//select[@name='client[address_attributes][state]']")
	private WebElement StateField;
	@FindBy(how = How.XPATH, using = "//select[@id='client_address_attributes_country']")
	private WebElement CountryDropdown;
	@FindBy(how = How.XPATH, using = ".//*[@id='select2-drop']/div/input")
	private WebElement CountryField;
	@FindBy(how = How.XPATH, using = ".//*[@id='select2-drop']/ul/li[1]/div")
	private WebElement Country_dd;
	@FindBy(how = How.XPATH, using = "//input[@id='client_address_attributes_zip']")
	private WebElement ZipField;

	// Mixpanel Setting

	@FindBy(how = How.ID, using = "show_mix_panel_setting")
	private WebElement MixpanelSettingCheckbox;
	@FindBy(how = How.ID, using = "client_mixpanel_api_key")
	private WebElement ApiKeyField;
	@FindBy(how = How.ID, using = "client_mixpanel_token")
	private WebElement TokenField;
	@FindBy(how = How.ID, using = "client_mixpanel_secret")
	private WebElement SecretField;
	@FindBy(how = How.ID, using = "client_mixpanel_enable_profiles")
	private WebElement EnableProfilesCheckbox;

	// User Details

	@FindBy(how = How.XPATH, using = "//input[@id='user_first_name']")
	private WebElement FirstNameField;
	@FindBy(how = How.XPATH, using = "//input[@id='user_last_name']")
	private WebElement LastNameField;
	@FindBy(how = How.XPATH, using = "//input[@class='form-control phone_number non_form_field unique_phone']")
	private WebElement PhoneField_UD;
	@FindBy(how = How.XPATH, using = "//input[@class='form-control phone_number unique_phone']")
	private WebElement SecondaryPhoneField;
	@FindBy(how = How.XPATH, using = "//select[@id='user_time_zone']")
	private WebElement TimeZoneDropdown_UD;
	@FindBy(how = How.XPATH, using = "//input[@id='user_email']")
	private WebElement EmailField_UD;
	@FindBy(how = How.XPATH, using = "//input[@id='team_name']")
	private WebElement TeamField;

	// Social Urls

	@FindBy(how = How.XPATH, using = "//input[@id='client_social_urls_facebook']")
	private WebElement FacebookField;
	@FindBy(how = How.XPATH, using = "//input[@id='client_social_urls_twitter']")
	private WebElement TwitterField;
	@FindBy(how = How.XPATH, using = "//input[@id='client_social_urls_google_plus']")
	private WebElement GooglePlusField;
	@FindBy(how = How.ID, using = "client_social_urls_linked_in")
	private WebElement LinkedInField;
	@FindBy(how = How.ID, using = "client_social_urls_youtube")
	private WebElement YoutubeField;
	@FindBy(how = How.ID, using = "client_social_urls_instagram")
	private WebElement InstagramField;

	// Vendor Configurations

	@FindBy(how = How.XPATH, using = "//label[text()='Promotional Email']/following::span[1]")
	private WebElement PromotionalEmailDropdown;
	@FindBy(how = How.XPATH, using = ".//*[@id='select2-drop']/ul/li/div")
	private WebElement PromotionalEmail_dd;
	@FindBy(how = How.XPATH, using = "//label[text()='Promotional Sms']/following::span[1]")
	private WebElement PromotionalSMSdropdown;
	@FindBy(how = How.XPATH, using = ".//*[@id='select2-drop']/ul/li/div")
	private WebElement PromotionalSMS_dd;
	@FindBy(how = How.XPATH, using = "//label[text()='Transactional Email']/following::span[1]")
	private WebElement TransactionalEmailDropdown;
	@FindBy(how = How.XPATH, using = ".//*[@id='select2-drop']/ul/li/div")
	private WebElement TransactionalEmail_dd;
	@FindBy(how = How.XPATH, using = "//label[text()='Transactional Sms']/following::span[1]")
	private WebElement TransactionalSMSdropdown;
	@FindBy(how = How.XPATH, using = ".//*[@id='select2-drop']/ul/li/div")
	private WebElement TransactionalSMS_dd;

	@FindBy(how = How.XPATH, using = "//span[text()='Select domain']")
	private WebElement MarketingDomainDropdown;
	@FindBy(how = How.XPATH, using = ".//*[@id='select2-drop']/ul/li[1]/div")
	private WebElement MarketingDomain_dd;
	@FindBy(how = How.XPATH, using = "//input[@name='commit']")
	private WebElement SaveButton;

	// Required Fields
	@FindBy(how = How.XPATH, using = "//label[text()='Business Name']/following::span[1]")
	private WebElement BusinessNameRequiredMessage;
	@FindBy(how = How.XPATH, using = "//label[text()='Short name']/following::span[2]")
	private WebElement ShortNameRequiredMessage;
	@FindBy(how = How.XPATH, using = "//label[text()='Website']/following::span[1]")
	private WebElement WebsiteFieldRequiredMessage;
	@FindBy(how = How.XPATH, using = "//label[text()='Email']/following::span[1]")
	private WebElement EmailFieldRequiredMessage;
	@FindBy(how = How.XPATH, using = "//label[text()='Email domain']/following::span[2]")
	private WebElement EmailDomainRequiredMessage;
	@FindBy(how = How.XPATH, using = "//label[text()='Upload Logo: ']/following::span[1]")
	private WebElement UploadLogoRequiredMessage;
	@FindBy(how = How.XPATH, using = "//label[text()='City for Indian PRI (Landline)']/preceding::span[1]")
	private WebElement ClientPhoneRequiredMessage;
	@FindBy(how = How.XPATH, using = "//label[text()='City for Indian PRI (Landline)']/following::span[3]")
	private WebElement CityForIndianPRIRequiredMessage;
	@FindBy(how = How.XPATH, using = "//label[text()='Indian PRI (Landline)']/following::span[3]")
	private WebElement IndianPRIRequiredMessage;
	@FindBy(how = How.XPATH, using = "//input[@id='transactional_sms_mask']")
	private WebElement SMSmaskFieldRequiredMessage;
	@FindBy(how = How.XPATH, using = "//input[@id='client_address_attributes_address1']/following::span[1]")
	private WebElement AddressFieldRequiredMessage;
	@FindBy(how = How.XPATH, using = "//input[@id='client_address_attributes_city']/following::span[1]")
	private WebElement CityFieldRequiredMessage;
	@FindBy(how = How.XPATH, using = "//select[@name='client[address_attributes][state]']/following::span[1]")
	private WebElement StateDropdownRequiredMessage;
	@FindBy(how = How.XPATH, using = "//select[@name='client[address_attributes][country]']/following::span[1]")
	private WebElement CountryDropdownRequiredMessage;
	@FindBy(how = How.XPATH, using = "//input[@id='client_address_attributes_zip']/following::span[1]")
	private WebElement ZipFieldRequiredMessage;
	@FindBy(how = How.XPATH, using = "//input[@id='user_first_name']/following::span[1]")
	private WebElement FirstNameRequiredMessage;
	@FindBy(how = How.XPATH, using = "//input[@id='user_last_name']/following::span[1]")
	private WebElement LastNameRequiredMessage;
	@FindBy(how = How.XPATH, using = "//input[@id='user_email']/following::span[1]")
	private WebElement UserEmailRequiredMessage;
	@FindBy(how = How.XPATH, using = "//input[@id='team_name']/following::span[1]")
	private WebElement TeamFieldRequiredMessage;
	@FindBy(how = How.XPATH, using = "//input[@id='client_domains']/following::span[1]")
	private WebElement MarketingDomainRequiredMessage;
	@FindBy(how = How.XPATH, using = "//*[@id='client_form']/div[6]/div[2]/div[3]/div/div/p")
	private WebElement DomainMessage;
	@FindBy(how = How.XPATH, using = "//input[@type='file']")
	private WebElement elem;
	@FindBy(how = How.XPATH, using = "//span[text()='Business Type']")
	private WebElement clickOnBuisnessType;
	@FindBy(how = How.CSS, using = "#select2-drop li")
	private List<WebElement> selectBuisnessType;
	@FindBy(how = How.XPATH, using = "//a[text()='Add a Client']")
	private WebElement CreateClientButton;

	// Error messaage
	@FindBy(how = How.XPATH, using = "//span[text()='This field is required.']")
	private List<WebElement> getAllReuireFieldMessage;
	@FindBy(how = How.CSS, using = ".form-group.has-error label")
	private List<WebElement> getAllReuirefiledName;

	public void getAllReuireFieldMessage() {
		waitUntilVisibilityOfElements(getAllReuireFieldMessage).stream().map(S -> S.getText().trim())
				.forEach(System.out::println);
	}

	public void getAllReuirefiledName() {
		char a = '"';
		waitUntilVisibilityOfElements(getAllReuirefiledName).stream().map(S -> S.getText().trim())
				.forEach(S -> System.out.print(a + "" + S + "" + a + ","));
	}

	public boolean requireFiledValidationBySize() {
		return (getAllReuireFieldMessage.size() == getAllReuirefiledName.size()) && getAllReuirefiledName.size() == 19;
	}

	public boolean reqFiledValidationByName() {
		List<String> list2 = Arrays.asList("FIRST NAME", "LAST NAME", "BUSINESS NAME", "BUSINESS TYPE", "SHORT NAME",
				"WEBSITE", "EMAIL", "UPLOAD LOGO:", "PHONE", "TRANSACTIONAL SMS MASK", "ADDRESS", "COUNTRY", "STATE",
				"CITY", "ZIP", "FIRST NAME", "TEAM", "LAST NAME", "EMAIL");
		List<String> list1 = getAllReuirefiledName.stream().map(WebElement::getText).collect(Collectors.toList());

		return compareLists(list1, list2);
	}

	private static <T> boolean compareLists(List<T> list1, List<T> list2) {
		if (list1 == null && list2 == null) {
			return true;
		}
		if (list1 == null || list2 == null || list1.size() != list2.size()) {
			return false;
		}
		return list1.equals(list2);
	}

	GetTestData getTestData = new GetTestData();

	// -------Filling Client Details--------

	public String getDomainMessage() {
		return waitUntilVisiblity(DomainMessage).getText().trim();
	}

	public void selectBuisnessType() {
		waitUntilClickable(clickOnBuisnessType).click();
		waitUntilClickable(selectBuisnessType.get(0)).click();
	}

	public void enterClientFirstName() {
		String clientFirstNameObj = getTestData.firstName;
		waitUntilVisiblity(clientFirstNameField).sendKeys(clientFirstNameObj);
	}

	public void enterClientLastName() {
		String clientLastNameObj = getTestData.lastName;
		waitUntilVisiblity(clientLastNameField).sendKeys(clientLastNameObj);
	}

	public void enterClientPhoneNumber() {
		String clientPhoneObj = " " + getTestData.phoneNumber;
		waitUntilVisiblity(clientPhoneNumber).sendKeys(randomPhone());
	}

	public void enterFirstName(String firstname) {
		waitUntilVisiblity(FirstNameField).sendKeys(firstname);
	}

	public void enterLastName(String lastname) {
		waitUntilVisiblity(LastNameField).sendKeys(lastname);
	}

	public void enterBusinessName(String businessName) {
		// String businessName = getTestData.location;
		waitUntilVisiblity(BusinessNameField).sendKeys(businessName);
	}

	public void enterShortName(String shortName) {
		waitUntilVisiblity(ShortNameField).sendKeys(shortName);
	}

	public void enterClientWebsite(String businessName) {
		waitUntilVisiblity(WebsiteField).sendKeys("http://www." + businessName + "auto.com");
	}

	public void enterClientEmail() {
		waitUntilVisiblity(EmailField_CD).sendKeys(randomEmail());
	}

	public void enterEmailDomain(String email) {
		waitUntilVisiblity(EmailDomainField).sendKeys(email);
	}

	public void enterSetUpCharge(String setup) {
		waitUntilVisiblity(SetUpChargesField).sendKeys(setup);
	}

	public void uploadFile() throws InterruptedException, AWTException {

		String claimZIP = System.getProperty("user.dir") + "/DataFile/" + "google-new-logo.png";

		// Mention the path of file to do the upload
		waitUntilVisiblity(elem).sendKeys(claimZIP);

	}

	public void enterClientPhoneNumber(String phone) {
		waitUntilVisiblity(PhoneField_CD).sendKeys(phone);
	}

	public void addClientPhoneNumber() {

		String phoneNum = " " + getTestData.phoneNumber;
		waitUntilVisiblity(clientPhone).sendKeys(phoneNum);
	}

	public void selectCityForIndianPRI(String pri) {
		waitUntilClickable(CityForIndianPRIDropdown).click();
		waitUntilVisiblity(CityForIndianPRIField).sendKeys(pri);
		waitUntilClickable(CityForIndianPRI_dd).click();
	}

	public void selectIndianPRInumber() {
		waitUntilClickable(IndianPRIDropdown).click();
		waitUntilClickable(IndianPRI_dd).click();
	}

	public void enterSMSmask(String sms) {
		waitUntilVisiblity(SMSMaskField).sendKeys(sms);
	}

	public void enterPhonemask(String sms) {
		waitUntilVisiblity(SMSMaskField).sendKeys(sms);
	}

	public void enterVirtualNumber(String vnum) {
		waitUntilVisiblity(VirtualNumbersField).sendKeys(vnum);
		waitUntilClickable(VirtualNumber_dd).click();
	}

	public void selectTimeZone_CD() {
		selectByIndex(StateField, 1);
	}

	public void clickOnUploadButton() {
		waitUntilClickable(UploadLogoButton).click();

	}

	// -----------Filling Client Address----------------

	public void enterAddress_M(String address1, String city, String zip, String country) {
		waitUntilVisiblity(Address1Field).sendKeys(address1);
		waitUntilVisiblity(CityField).sendKeys(city);

		selectByVisibleText(CountryDropdown, country);

		selectByVisibleText(StateField, "Maharashtra");
		waitUntilVisiblity(ZipField).sendKeys(zip);
	}

	public void enterAddress_NM(String address1, String address2, String city, String country, String zip) {
		waitUntilVisiblity(Address1Field).sendKeys(address1);
		waitUntilVisiblity(Address2Field).sendKeys(address2);
		waitUntilVisiblity(CityField).sendKeys(city);
		selectByVisibleText(CountryDropdown, country);
		Select oSelect = new Select(StateField);
		oSelect.selectByVisibleText("Maharashtra");
		waitUntilVisiblity(ZipField).sendKeys(zip);
	}

	// --------------Mix Panel Setting-------------------

	public void settingMixpanel(String api, String token, String secret) throws InterruptedException {
		waitUntilClickable(MixpanelSettingCheckbox).click();
		Thread.sleep(2000);
		waitUntilVisiblity(ApiKeyField).sendKeys(api);
		waitUntilVisiblity(TokenField).sendKeys(token);
		waitUntilVisiblity(SecretField).sendKeys(secret);
	}

	// --------------Filling User Details----------------

	public void enterFirstName() {
		String adminFirstNameObj = getTestData.firstName;
		waitUntilVisiblity(FirstNameField).sendKeys(adminFirstNameObj);
	}

	public void enterLastName() {
		String adminLastNameObj = getTestData.lastName;
		waitUntilVisiblity(LastNameField).sendKeys(adminLastNameObj);
	}

	public void enterUserPhoneNumber() {
		waitUntilVisiblity(PhoneField_UD).sendKeys(randomPhone());

	}

	public void enterUserEmail() {
		waitUntilVisiblity(EmailField_UD).sendKeys(randomEmail());
	}

	public void enterUsersTeam() {
		String team = getTestData.team;
		waitUntilVisiblity(TeamField).sendKeys(team);
	}

	public void selectPromotionalEmail() {
		waitUntilClickable(PromotionalEmailDropdown).click();
		waitUntilClickable(PromotionalEmail_dd).click();
	}

	public void vendorConfiguration() {
		waitUntilClickable(PromotionalEmailDropdown).click();
		waitUntilClickable(PromotionalEmail_dd).click();
		waitUntilClickable(PromotionalSMSdropdown).click();
		waitUntilClickable(PromotionalSMS_dd).click();
		waitUntilClickable(TransactionalEmailDropdown).click();
		waitUntilClickable(TransactionalEmail_dd).click();
		waitUntilClickable(TransactionalSMSdropdown).click();
		waitUntilClickable(TransactionalSMS_dd).click();
	}

	public void selectMarketingDomain() {
		waitUntilClickable(MarketingDomainDropdown).click();
		waitUntilClickable(MarketingDomain_dd).click();
	}

	public void clickOnSaveButton() {
		waitUntilClickable(SaveButton).click();
		waitUntilVisiblity(CreateClientButton, 100);
	}

	public void clickOnSaveButonWithoutWait() {
		waitUntilClickable(SaveButton).click();
	}

	public String getBusinessNameRequiredMessage() {
		String businessNameRequiredMessage = waitUntilVisiblity(BusinessNameRequiredMessage).getText().trim();
		return businessNameRequiredMessage;
	}

	public String getShortNameRequiredMessage() {
		String shortNameRequiredMessage = waitUntilVisiblity(ShortNameRequiredMessage).getText().trim();
		return shortNameRequiredMessage;
	}

	public String getWebsiteFieldRequiredMessage() {
		String websiteFieldRequiredMessage = waitUntilVisiblity(WebsiteFieldRequiredMessage).getText().trim();
		return websiteFieldRequiredMessage;
	}

	public String getEmailFieldRequiredMessage() {
		String emailFieldRequiredMessage = waitUntilVisiblity(EmailFieldRequiredMessage).getText().trim();
		return emailFieldRequiredMessage;
	}

	public String getEmailDomainRequiredMessage() {
		String emailDomainRequiredMessage = waitUntilVisiblity(EmailDomainRequiredMessage).getText().trim();
		return emailDomainRequiredMessage;
	}

	public String getUploadLogoRequiredMessage() {
		String uploadLogoRequiredMessage = waitUntilVisiblity(UploadLogoRequiredMessage).getText().trim();
		return uploadLogoRequiredMessage;
	}

	public String getClientPhoneRequiredMessage() {
		String clientPhoneRequiredMessage = waitUntilVisiblity(ClientPhoneRequiredMessage).getText().trim();
		return clientPhoneRequiredMessage;
	}

//	public String getCityForIndianPRIRequiredMessage() {
//		String cityForIndianPRIRequiredMessage = waitUntilVisiblity(CityForIndianPRIRequiredMessage).getText().trim();
//		return cityForIndianPRIRequiredMessage;
//	}

	public String getIndianPRIRequiredMessage() {
		String indianPRIRequiredMessageRequiredMessage = waitUntilVisiblity(IndianPRIRequiredMessage).getText().trim();
		return indianPRIRequiredMessageRequiredMessage;
	}

	public String getSMSmaskFieldRequiredMessage() {
		String smsMaskFieldRequiredMessage = waitUntilVisiblity(SMSmaskFieldRequiredMessage).getText().trim();
		return smsMaskFieldRequiredMessage;
	}

	public String getAddressFieldRequiredMessage() {
		String addressFieldRequiredMessage = waitUntilVisiblity(AddressFieldRequiredMessage).getText().trim();
		return addressFieldRequiredMessage;
	}

	public String getCityFieldRequiredMessage() {
		String cityFiledRequiredMessage = waitUntilVisiblity(CityFieldRequiredMessage).getText().trim();
		return cityFiledRequiredMessage;
	}

	public String getStateDropdownRequiredMessage() {
		String stateDropdownRequiredMessage = waitUntilVisiblity(StateDropdownRequiredMessage).getText().trim();
		return stateDropdownRequiredMessage;
	}

	public String getCountryDropdownRequiredMessage() {
		String countryDropdownRequiredMessage = waitUntilVisiblity(CountryDropdownRequiredMessage).getText().trim();
		return countryDropdownRequiredMessage;
	}

	public String getZipFieldRequiredMessage() {
		String zipFieldRequiredMessage = waitUntilVisiblity(ZipFieldRequiredMessage).getText().trim();
		return zipFieldRequiredMessage;
	}

	public String getFirstNameRequiredMessage() {
		String firstNameRequiredMessage = waitUntilVisiblity(FirstNameRequiredMessage).getText().trim();
		return firstNameRequiredMessage;
	}

	public String getLastNameRequiredMessage() {
		String lastNameRequiredMessage = waitUntilVisiblity(LastNameRequiredMessage).getText().trim();
		return lastNameRequiredMessage;
	}

	public String getUserEmailRequiredMessage() {
		String userEmailRequiredMessage = waitUntilVisiblity(UserEmailRequiredMessage).getText().trim();
		return userEmailRequiredMessage;
	}

	public String getTeamFieldRequiredMessage() {
		String teamFieldRequiredMessage = waitUntilVisiblity(TeamFieldRequiredMessage).getText().trim();
		return teamFieldRequiredMessage;
	}

	public String getMarketingDomainRequiredMessage() {
		String marketingDomainRequiredMessage = waitUntilVisiblity(MarketingDomainRequiredMessage).getText().trim();
		return marketingDomainRequiredMessage;
	}

}
