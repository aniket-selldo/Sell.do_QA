package com.selldo.POM.adminPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selldo.Utility.ReusableUtils;

public class EditTeamFormPage extends ReusableUtils {

	public WebDriver driver;

	public EditTeamFormPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//input[@id='team_name']")
	private WebElement nameInputField;
	@FindBy(how = How.XPATH, using = "//input[@id='team_location']")
	private WebElement locationInputField;
	@FindBy(how = How.ID, using = "s2id_autogen9")
	private WebElement teamAccessibleInputField;
	@FindBy(how = How.XPATH, using = "//div[@class='select2-result-label']")
	private WebElement teamAccessible_dd;
	@FindBy(how = How.XPATH, using = "//input[@name='commit'][@value='Save']")
	private WebElement saveButton;

	public void changeTeamName(String teamname) {
		nameInputField.clear();
		nameInputField.sendKeys(teamname);
	}

	public void changeLocation(String location) {
		locationInputField.clear();
		locationInputField.sendKeys(location);
	}

	public void clickOnSaveButton() {
		saveButton.click();
	}
}
