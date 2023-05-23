package com.selldo.POM.inventory;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selldo.Utility.ReusableUtils;

public class FloorPlansPage extends ReusableUtils {
	public WebDriver driver;

	public FloorPlansPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//a[text()='New Floor Plan']")
	private WebElement newFloorPlanButton;
	@FindBy(how = How.CSS, using = "i.ion-funnel")
	private WebElement funnelIcon;
	@FindBy(how = How.XPATH, using = "//span[text()='Select a Floor Plan']")
	private WebElement floorPlanSpan;
	@FindBy(how = How.XPATH, using = "//*[@id='select2-drop']//div//input")
	private WebElement floorPlanInputField;
	@FindBy(how = How.XPATH, using = "//span[text()='Select a Project']")
	private WebElement projectSpan;
	@FindBy(how = How.XPATH, using = "//*[@id='select2-drop']//div//input")
	private WebElement projectInputField;
	@FindBy(how = How.XPATH, using = "//span[text()='Select a Project Tower']")
	private WebElement projectTowerSpan;
	@FindBy(how = How.XPATH, using = "//*[@id='select2-drop']//div//input")
	private WebElement projectTowerInputField;
	@FindBy(how = How.XPATH, using = "//a[text()='Filter']")
	private WebElement filterButton;
	@FindBy(how = How.XPATH, using = "//a[text()='Clear All']")
	private WebElement clearAllLink;
	@FindBy(how = How.XPATH, using = "//input[@value='Apply']/preceding::i[@class='ion-android-close'][1]")
	private WebElement crossIcon;
	@FindBy(how = How.XPATH, using = "//th[text()='Actions']/following::a[1]")
	private WebElement actionBar;
	@FindBy(how = How.XPATH, using = "//th[text()='Actions']/following::a[text()='Edit'][1]")
	private WebElement editLink;

	public void clickOnNewFloorPlanButton() {
		newFloorPlanButton.click();
	}

	public void clickOnFunnelIcon() {
		funnelIcon.click();
	}

	public void enterFloorPlanName(String floor) throws InterruptedException {
		floorPlanSpan.click();
		floorPlanInputField.sendKeys(floor);
		Thread.sleep(2000);
		floorPlanInputField.sendKeys(Keys.ENTER);
	}

	public void clickOnFilterButton() {
		filterButton.click();
	}

	public void clickOnClearAllLink() {
		clearAllLink.click();
	}

	public void clickOnCrossIcon() {
		crossIcon.click();
	}
}
