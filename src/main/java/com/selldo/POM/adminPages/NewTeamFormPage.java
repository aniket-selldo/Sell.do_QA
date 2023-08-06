package com.selldo.POM.adminPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selldo.Utility.ReusableUtils;

public class NewTeamFormPage extends ReusableUtils {
	public WebDriver driver;

	public NewTeamFormPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.ID, using = "team_name")
	private WebElement nameInputField;
	@FindBy(how = How.ID, using = "team_location")
	private WebElement locationInputField;
	@FindBy(how = How.XPATH, using = "//span[text()='Select Team Hierarchy']")
	private WebElement teamHierarchySpan;
	@FindBy(how = How.XPATH, using = "//*[@id='select2-drop']/div/input")
	private WebElement teamHierarchyInputField;
	@FindBy(how = How.XPATH, using = "//div[@class='select2-result-label']")
	private WebElement teamHierarchy_dd;
	@FindBy(how = How.ID, using = "s2id_autogen9")
	private WebElement teamAccessibleInputField;
	@FindBy(how = How.XPATH, using = "//div[@class='select2-result-label']")
	private WebElement teamAccessible_dd;
	@FindBy(how = How.XPATH, using = "//input[@name='commit'][@value='Save']")
	private WebElement saveButton;

	public void enterTeamName(String teamname) {
		nameInputField.sendKeys(teamname);
	}

	public void enterLocation(String location) {
		locationInputField.sendKeys(location);
	}

	public void selectTeamHierarchy() {
		teamHierarchySpan.click();
		teamHierarchy_dd.click();
	}

	public void selectAccessibleTeams() {
		teamAccessibleInputField.click();
		teamAccessible_dd.click();
	}

	public void clickOnSaveButton() {
		saveButton.click();
	}
}
