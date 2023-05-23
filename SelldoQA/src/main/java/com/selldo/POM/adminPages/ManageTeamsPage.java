package com.selldo.POM.adminPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selldo.Utility.ReusableUtils;

public class ManageTeamsPage extends ReusableUtils {
	public WebDriver driver;

	public ManageTeamsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//a[text()='New Team']")
	private WebElement newTeamLink;
	@FindBy(how = How.XPATH, using = "//th[text()='Actions']/following::i[1]")
	private WebElement actionBar;
	@FindBy(how = How.XPATH, using = "//th[text()='Actions']/following::a[text()='Edit'][1]")
	private WebElement edit;
	@FindBy(how = How.XPATH, using = "//i[@class='ion-funnel']")
	private WebElement funnelIcon;
	@FindBy(how = How.XPATH, using = "//input[@name='team_filters[search_string]']")
	private WebElement searchInputField;
	@FindBy(how = How.XPATH, using = "//input[@type='submit'][@value='Apply']")
	private WebElement applyButton;

	public void clickOnNewTeam() {
		newTeamLink.click();
	}

	public void clickOnActionBar() {
		actionBar.click();
	}

	public void clickOnEdit() {
		edit.click();
	}

	public void searchTeam(String teamName) {
		funnelIcon.click();
		searchInputField.sendKeys(teamName);
		applyButton.click();
	}

}
