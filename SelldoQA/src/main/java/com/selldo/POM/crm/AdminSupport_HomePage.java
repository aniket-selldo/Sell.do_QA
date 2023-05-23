package com.selldo.POM.crm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.selldo.Utility.ReusableUtils;

public class AdminSupport_HomePage extends ReusableUtils {
	public WebDriver driver;

	public AdminSupport_HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//a[@href='/client/users']")
	private WebElement Users;
	@FindBy(how = How.XPATH, using = "//a[@href='/client/teams']")
	private WebElement Teams;
	@FindBy(how = How.XPATH, using = "//*[@class='fa fa-cog fa-lg']")
	private WebElement SettingIcon;
	@FindBy(how = How.XPATH, using = "//a[text()='Sign in']")
	private WebElement SignIn;
	@FindBy(how = How.XPATH, using = "//h4[text()='Login as']/following::span[1]")
	private WebElement LoginAs;
	@FindBy(how = How.XPATH, using = ".//*[@id='select2-drop']/div/input")
	private WebElement LoginAsInputField;
	@FindBy(how = How.XPATH, using = "//div[@class='select2-result-label']")
	private WebElement UserFromDropdown;
	@FindBy(how = How.XPATH, using = "//a[text()='Login']")
	private WebElement LoginButton;
	@FindBy(how = How.XPATH, using = "//a[text()='Logout']")
	private WebElement Logout;
	@FindBy(how = How.CSS, using = "i#user-account-icon")
	private WebElement userAccountIcon;

	// Validating that admin/support manager logged in successfully by comparing
	// page title after login
	public void verifyingClientLogin() {
		SoftAssert assertion = new SoftAssert();
		System.out.println("Started verification");
		Assert.assertEquals(driver.getTitle(), "Sell.Do - Market Smarter. Sell Faster.", "Title Not Matched");
		System.out.println("Completed verification");
		assertion.assertAll();
	}

	/*
	 * // Logging out of the application public void loggingOut() throws
	 * InterruptedException { SettingIcon.click();// Clicking on
	 * Setting icon at // the upper right corner
	 * Logout.click();// Clicking on logout from the // dropdown
	 * }
	 */

	public void loggingOut() throws InterruptedException {
		userAccountIcon.click();
		Logout.click();

	}

	// Clicking on Users link at the header
	public void clickOnUsers() {
		Users.click();
	}

	// Signing in as a User
	public void signInAsUser(String userName) throws InterruptedException {
		SettingIcon.click();// Clicking on Setting icon at
												// the upper right corner
		SignIn.click();// Clicking on Sign in field
		LoginAs.click();
		LoginAsInputField.sendKeys(userName);
		UserFromDropdown.click();
		LoginButton.click();
	}

	public void clickOnTeams() {
		Teams.click();
	}
}