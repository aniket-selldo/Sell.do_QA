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
	@FindBy(how = How.XPATH, using = "//th[text()='Actions']/following::i[7]")
	private WebElement actionBar;
	@FindBy(how = How.XPATH, using = "//div[@class='dropdown extended show']//a[text()='Edit']")
	private WebElement edit;
	@FindBy(how = How.CSS, using = "#s2id_search_params_status")
	private WebElement ClickOnActiveInactiveFilter;
	@FindBy(how = How.CSS, using = "#s2id_search_params_status .select2-search-choice-close")
	private WebElement clickToAblolish;
	@FindBy(how = How.XPATH, using = "//table[@class='table table-responsive']//td[4]/span")
	private WebElement getUserStatus;
	@FindBy(how = How.XPATH, using = "(//span[@class='td-bold'])[1]")
	private WebElement getUserNameFromList;
	@FindBy(how = How.XPATH, using = "//th[text()='name']/following::span[1]")
	private WebElement getUserNameFromUserList;

	public String getUserNameFromUserList() {
		return waitUntilVisiblity(getUserNameFromUserList).getAttribute("innerHTML").trim();
	}
	
	public String getUserStatus() {
		return waitUntilVisiblity(getUserStatus).getText().trim();
	}

	public String getUserNameFromList() {
		return waitUntilVisiblity(getUserNameFromList).getText().trim();
	}

	// Locale locale = new Locale(langauge; "en-IND");
	// Faker faker = new Faker(locale);

	/*
	 * //Generate Faker faker = new Faker(); public String firstName=
	 * faker.firstName(); public String lastName= faker.lastName(); public String
	 * phoneNumber = faker.phoneNumber();
	 */

	public void clickOnNewUserButton() {
		waitUntilClickable(newUserButton).click();
	}

	/*
	 * public void searchUser(CharSequence[] phone_SearchObj) { funnelIcon.click();
	 * searchInputField).sendKeys(phone_SearchObj); applyButton.click(); }
	 */

	public void searchUser2(String emailID) {
		wait(5000);
		waitUntilClickable(funnelIcon).click();
		waitUntilVisiblity(searchInputField).sendKeys(emailID);
		waitUntilClickable(clickToAblolish).click();
		waitUntilClickable(applyButton).click();
	}

	public void searchUser(String emailID) {
		waitUntilClickable(funnelIcon).click();
		waitUntilVisiblity(searchInputField).sendKeys(emailID);
		waitUntilClickable(applyButton).click();
	}

	public void resettingFilter() {
		waitUntilClickable(funnelIcon).click();
		waitUntilClickable(clearAll).click();
	}

	public void clickOnActionBar() {
		waitUntilClickable(actionBar).click();
	}

	public void selectEdit() {
		waitUntilClickable(actionBar).click();
		waitUntilClickable(edit).click();
	}
}
