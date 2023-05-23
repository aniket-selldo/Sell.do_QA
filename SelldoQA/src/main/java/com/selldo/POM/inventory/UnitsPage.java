package com.selldo.POM.inventory;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selldo.Utility.ReusableUtils;

public class UnitsPage extends ReusableUtils {

	public WebDriver driver;

	public UnitsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//a[text()='New Unit']")
	private WebElement newUnitButton;
	@FindBy(how = How.XPATH, using = "//th[text()='Actions']/following::a[1]")
	private WebElement actionBar;
	@FindBy(how = How.XPATH, using = "//th[text()='Actions']/following::a[text()='Edit'][1]")
	private WebElement editLink;
	@FindBy(how = How.CSS, using = "i.ion-funnel")
	private WebElement funnelIcon;
	@FindBy(how = How.XPATH, using = "//span[text()='Select Unit']")
	private WebElement unit;
	@FindBy(how = How.XPATH, using = "//*[@id='select2-drop']//div//input")
	private WebElement unitInputField;
	@FindBy(how = How.XPATH, using = "//span[text()='Select a Developer']")
	private WebElement developer;
	@FindBy(how = How.XPATH, using = "//*[@id='select2-drop']//div//input")
	private WebElement developerInputField;
	@FindBy(how = How.XPATH, using = "//span[text()='Select a Project']")
	private WebElement project;
	@FindBy(how = How.XPATH, using = "//*[@id='select2-drop']//div//input")
	private WebElement projectInputField;
	@FindBy(how = How.XPATH, using = "//span[text()='Select a Project Tower']")
	private WebElement projectTower;
	@FindBy(how = How.XPATH, using = "//*[@id='select2-drop']//div//input")
	private WebElement projectTowerField;
	@FindBy(how = How.XPATH, using = "//span[text()='Select a Floor Plan']")
	private WebElement floorPlan;
	@FindBy(how = How.XPATH, using = "//*[@id='select2-drop']//div//input")
	private WebElement floorPlanInputField;
	@FindBy(how = How.XPATH, using = "//a[text()='Apply']")
	private WebElement applyButton;
	@FindBy(how = How.XPATH, using = "//a[text()='Clear All']")
	private WebElement clearAllLink;
	@FindBy(how = How.XPATH, using = "//input[@value='Apply']/preceding::i[@class='ion-android-close'][1]")
	private WebElement crossIcon;

	public void clickOnNewUnitButton() {
		newUnitButton.click();
	}

	public void clickOnFunnelIcon() {
		funnelIcon.click();
	}

	public void enterUnitName(String unt) throws InterruptedException {
		unit.click();
		unitInputField.sendKeys(unt);
		Thread.sleep(2000);
		unitInputField.sendKeys(Keys.ENTER);
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
