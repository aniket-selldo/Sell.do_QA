package com.selldo.POM.adminPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selldo.Utility.ReusableUtils;

public class SettingsPage extends ReusableUtils {

	public WebDriver driver;

	public SettingsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//span[text()='user management']")
	private WebElement userManagement;
	@FindBy(how = How.XPATH, using = "//span[text()='partners']")
	private WebElement partners;
	@FindBy(how = How.XPATH, using = "//span[text()='manage partners']")
	private WebElement managePartners;
	@FindBy(how = How.XPATH, using = "//span[text()='export']")
	private WebElement export;
	@FindBy(how = How.XPATH, using = "//span[text()='import']")
	private WebElement importTab;
	@FindBy(how = How.XPATH, using = "//span[text()='search lists']")
	private WebElement searchList;
	@FindBy(how = How.XPATH, using = "//span[text()='Booking lists']")
	private WebElement bookingList;

	public void clickOnUserManagementTab() {
		userManagement.click();
	}

	public void clickOnPartnersTab() {
		partners.click();
	}

	public void clickOnManagePartnersTab() {
		managePartners.click();
	}

	public void clickOnExportab() {
		export.click();
	}

	public void clickOnImportTab() {
		importTab.click();
	}

	public void clickOnSearchListTab() {
		searchList.click();
	}

	public void clickOnBookingListTab() {
		bookingList.click();
	}
}
