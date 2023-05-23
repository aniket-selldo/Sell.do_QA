package com.selldo.POM.adminPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selldo.Utility.ReusableUtils;

public class ManageUsersPage extends ReusableUtils {

	public WebDriver driver;

	public ManageUsersPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//a[text()='New User']")
	private WebElement newUserButton;
	@FindBy(how = How.XPATH, using = "//i[@class='ion-funnel']")
	private WebElement funnelIcon;
	@FindBy(how = How.XPATH, using = "//input[@name='search_params[search_string]']")
	private WebElement searchInputField;
	@FindBy(how = How.XPATH, using = "//input[@type='submit'][@value='Apply']")
	private WebElement applyButton;
	@FindBy(how = How.XPATH, using = "//a[text()='Clear All']")
	private WebElement clearAll;
	@FindBy(how = How.XPATH, using = "//th[text()='Actions']/following::i[1]")
	private WebElement actionBar;
	@FindBy(how = How.XPATH, using = "//th[text()='Actions']/following::a[text()='Edit'][1]")
	private WebElement edit;

	// Locale locale = new Locale(langauge; "en-IND");
	// Faker faker = new Faker(locale);

	/*
	 * //Generate Faker faker = new Faker(); public String firstName=
	 * faker.firstName(); public String lastName= faker.lastName(); public String
	 * phoneNumber = faker.phoneNumber();
	 */

	public void clickOnNewUserButton() {
		newUserButton.click();
	}

	/*
	 * public void searchUser(CharSequence[] phone_SearchObj) {
	 * funnelIcon.click();
	 * searchInputField).sendKeys(phone_SearchObj);
	 * applyButton.click(); }
	 */

	public void searchUser(String emailID) {
		funnelIcon.click();
		searchInputField.sendKeys(emailID);
		applyButton.click();
	}

	public void resettingFilter() {
		funnelIcon.click();
		clearAll.click();
	}

	public void clickOnActionBar() {
		actionBar.click();
	}

	public void selectEdit() {
		actionBar.click();
		edit.click();
	}
}
