package com.selldo.POM.crm;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selldo.Utility.ReusableUtils;

public class PushToSalesPage extends ReusableUtils {
	public WebDriver driver;

	public PushToSalesPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.CSS, using = "div[class='select2-container form-control push_to_sales_team amura-select2']")
	private WebElement SelectTeamDropdown;
	@FindBy(how = How.XPATH, using = ".//*[@id='select2-drop']/div/input")
	private WebElement SelectTeamTextField;
	@FindBy(how = How.XPATH, using = ".//*[@id='select2-drop']/ul/li/div")
	private WebElement TeamFromDropdown;
	@FindBy(how = How.XPATH, using = "//span[text()='Select sales']")
	private WebElement SelectUserDropdown;
	@FindBy(how = How.XPATH, using = ".//*[@id='select2-drop']/div/input")
	private WebElement SelectUserTextField;
	@FindBy(how = How.XPATH, using = "//div[@class='select2-result-label']")
	private WebElement UserFromDropdown;
	@FindBy(how = How.XPATH, using = "//button[text()='Push to sales']")
	private WebElement PushButton;

	// Selecting Team of user to which lead is to be pushed
	public void selectTeam(String teamName) throws InterruptedException {
		waitUntilClickable(SelectTeamDropdown).click();
		waitUntilVisiblity(SelectTeamTextField).sendKeys(teamName);// Typing team name
		waitUntilClickable(TeamFromDropdown).click();// Selecting Team from dropdown
	}

	// Selecting User to which lead is to be pushed
	public void selectUser(String userName) throws InterruptedException {
		waitUntilClickable(SelectUserDropdown).click();// Clicking on User dropdown
		waitUntilVisiblity(SelectUserTextField).sendKeys(userName);// Typing team name
		SelectUserTextField.sendKeys(Keys.SPACE);
		waitUntilClickable(UserFromDropdown).click();// Selecting User from dropdown
	}

	// Clicking on Push button
	public void clickOnPushButton() {
		waitUntilClickable(PushButton).click();
	}
}
