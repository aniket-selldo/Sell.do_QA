package com.selldo.POM.crm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selldo.Utility.ReusableUtils;

public class ClientLoginPage extends ReusableUtils {
	public WebDriver driver;

	public ClientLoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//*[@class='select2-chosen']")
	private WebElement SelectAClientField;
	@FindBy(how = How.XPATH, using = ".//*[@id='select2-drop']/div/input")
	private WebElement SelectAClientFieldInput;
	@FindBy(how = How.XPATH, using = ".//*[@id='select2-drop']/ul/li[1]/div")
	private WebElement ClientName;
	@FindBy(how = How.ID, using = "search_clients")
	private WebElement SearchButton;
	@FindBy(how = How.XPATH, using = "//a[@title='Login as client']")
	private WebElement Login;
	@FindBy(how = How.XPATH, using = "//a[text()='Add a Client']")
	private WebElement CreateClientButton;
	@FindBy(how = How.XPATH, using = "//a[@href='/users/logout']")
	private WebElement Logout;
	@FindBy(how = How.XPATH, using = "//a[text()='Clients']")
	private WebElement Clients;
	@FindBy(how = How.CSS, using = "i.fa.fa-ellipsis-v")
	private WebElement ActionBar;
	@FindBy(how = How.CSS, using = "i#user-account-icon")
	private WebElement userAccount;

	public void clientLogin(String clientName) {

		// Clicking on Select a Client Field
		waitUntilClickable(SelectAClientField, 50).click();
		System.out.println("Clicking on Select a Client Field >>> " + clientName);

		// Thread.sleep(3000);

		// Typing Client name in Select a Client Field
		waitUntilVisiblity(SelectAClientFieldInput).sendKeys(clientName);
		System.out.println("Typing Client name in Select a Client Field");

		// Thread.sleep(3000);

		// Selecting Client name from dropdown
		waitUntilClickable(ClientName).click();
		System.out.println("Selecting Client name from dropdown");

		// Thread.sleep(3000);

		// Clicking on Search button
		waitUntilClickable(SearchButton).click();
		System.out.println("Clicking on Search button");

		// Thread.sleep(3000);

		// Clicking on action bar
		// ActionBar.click();

		// Clicking on Login link
		waitUntilClickable(Login).click();
		System.out.println("Clicking on Login link");
	}

	public void clickOnCreateClientButton() {
		waitUntilClickable(CreateClientButton).click();
	}

	public void clickOnClientsLink() {
		waitUntilClickable(Clients).click();
	}

	public void superAdminlogout() {
		waitUntilClickable(Logout).click();

	}

	public void logout() {
		wait(1000);
		waitUntilClickable(userAccount, 0).click();
		wait(1000);
		waitUntilClickable(Logout, 0).click();
	}
}
