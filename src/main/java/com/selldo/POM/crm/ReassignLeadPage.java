package com.selldo.POM.crm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selldo.Utility.ReusableUtils;

public class ReassignLeadPage extends ReusableUtils {

	public WebDriver driver;

	public ReassignLeadPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//button[text()='Reassign']/preceding::span[1]")
	private WebElement TeamDropdown;
	@FindBy(how = How.XPATH, using = ".//*[@id='select2-drop']/div/input")
	private WebElement TeamTextField;
	@FindBy(how = How.CSS, using = "#select2-drop > ul > li > div > span")
	private WebElement TeamFromDropdown;
	@FindBy(how = How.XPATH, using = "//span[text()='Select User']")
	private WebElement UserDropdown;
	@FindBy(how = How.XPATH, using = ".//*[@id='select2-drop']/div/input")
	private WebElement UserTextField;
	@FindBy(how = How.CSS, using = "#select2-drop > ul > li > div")
	private WebElement UserFromDropdown;
	@FindBy(how = How.XPATH, using = "//button[text()='Reassign']")
	private WebElement ReassignButton;
	@FindBy(how = How.CSS, using = "#select2-drop > ul li div")
	private WebElement teamsList;

	// Selecting Team of user to which lead is to be reassigned
	public void selectTeam(String teamName) {
		waitUntilClickable(TeamDropdown).click();// Clicking on Team dropdown
		waitUntilVisiblity(TeamTextField).sendKeys(teamName);// Typing team name
		waitUntilClickable(TeamFromDropdown).click();
	}

	// Selecting User to which lead is to be reassigned
	public void selectUser(String userName) {
		waitUntilClickable(UserDropdown).click();// Clicking on User dropdown
		waitUntilVisiblity(UserTextField).sendKeys(userName);// Typing User name
		waitUntilClickable(UserFromDropdown).click();
	}

	// Clicking on Reassign button
	public void clickOnReassignButton() {
		waitUntilClickable(ReassignButton).click();
	}

}
