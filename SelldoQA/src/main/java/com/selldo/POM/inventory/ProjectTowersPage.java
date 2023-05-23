package com.selldo.POM.inventory;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selldo.Utility.ReusableUtils;

public class ProjectTowersPage extends ReusableUtils {

	public WebDriver driver;

	public ProjectTowersPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//a[text()='New Tower']")
	private WebElement newTower;
	@FindBy(how = How.XPATH, using = "//th[text()='Actions']/following::a[2]")
	private WebElement actionBar;
	@FindBy(how = How.XPATH, using = "//th[text()='Actions']/following::a[text()='Edit'][1]")
	private WebElement editLink;
	@FindBy(how = How.XPATH, using = "//i[@class='ion-funnel']")
	private WebElement funnelIcon;
	@FindBy(how = How.XPATH, using = "//span[text()='Select a Project Tower']")
	private WebElement projectTowerSpan;
	@FindBy(how = How.XPATH, using = "//*[@id='select2-drop']//div//input")
	private WebElement projectTowerInputField;
	@FindBy(how = How.XPATH, using = "//span[text()='Select a Project']")
	private WebElement projectSpan;
	@FindBy(how = How.XPATH, using = "//*[@id='select2-drop']//div//input")
	private WebElement projectInputField;
	@FindBy(how = How.XPATH, using = "//a[text()='Apply']")
	private WebElement applyButton;
	@FindBy(how = How.XPATH, using = "//a[text()='Clear All']")
	private WebElement clearAllLink;
	@FindBy(how = How.XPATH, using = "//input[@value='Apply']/preceding::i[@class='ion-android-close'][1]")
	private WebElement crossIcon;

	public void clickOnNewTower() {
		newTower.click();
	}

	public void clickOnFunnelIcon() {
		funnelIcon.click();
	}

	public void enterProjectTowerName(String tower) throws InterruptedException {
		projectTowerSpan.click();
		projectTowerInputField.sendKeys(tower);
		Thread.sleep(2000);
		projectTowerInputField.sendKeys(Keys.ENTER);
	}

	public void clickOnApplyButton() {
		applyButton.click();
	}

	public void clickOnClearAllLink() {
		clearAllLink.click();
	}

	public void clickOnCrossIcon() {
		crossIcon.click();
	}
}
