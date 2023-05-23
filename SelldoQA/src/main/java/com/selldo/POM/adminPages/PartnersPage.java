package com.selldo.POM.adminPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selldo.Utility.ReusableUtils;

public class PartnersPage extends ReusableUtils {
	public WebDriver driver;

	public PartnersPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//span[text()='manage partners']")
	private WebElement managePartners;
	@FindBy(how = How.XPATH, using = "//a[text()='New Partner']")
	private WebElement newPartner;
	@FindBy(how = How.XPATH, using = "//i[@class='ion-funnel']")
	private WebElement funnelIcon;
	@FindBy(how = How.ID, using = "search")
	private WebElement searchField;
	@FindBy(how = How.XPATH, using = "//input[@type='submit']")
	private WebElement applyButton;
	@FindBy(how = How.XPATH, using = "//a[text()='Clear All']")
	private WebElement clearAllLink;
	@FindBy(how = How.XPATH, using = "//th[text()='Actions']/following::a[1]")
	private WebElement actionBar;
	@FindBy(how = How.XPATH, using = "//th[text()='Actions']/following::a[text()='Edit'][1]")
	private WebElement edit;
	@FindBy(how = How.CSS, using = "div.index-filters.full-height.col-lg-3 .ion-android-close")
	private WebElement closeFilter;

	public void clickOnManagePartnerstTab() {
		managePartners.click();
	}

	public void clickOnNewPartnerButton() {
		newPartner.click();
	}

	public void searchPartner(String partner) throws Exception {
		Thread.sleep(1000);
		funnelIcon.click();
		searchField.clear();
		searchField.sendKeys(partner);
		applyButton.click();
		// closeFilter.click();

	}

	public void clearFilter() {
		clearAllLink.click();
	}

	public void selectEdit() {
		actionBar.click();
		edit.click();
	}

}
