package com.selldo.POM.inventory;

import java.util.List;

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
	@FindBy(how = How.XPATH, using = "//table[@class='table table-responsive']/tbody/tr/td[1]")
	private List<WebElement> getAllDevloperName;

	public String  getAnyFloorPlanName() {
		 int index = (int)(Math.random() * getAllDevloperName.size());
			return waitUntilVisiblity(getAllDevloperName.get(index)).getText().trim();
	}

	public void clickOnNewFloorPlanButton() {
		waitUntilClickable(newFloorPlanButton).click();
	}

	public void clickOnFunnelIcon() {
		waitUntilClickable(funnelIcon).click();
	}

	public void enterFloorPlanName(String floor) throws InterruptedException {
		waitUntilClickable(floorPlanSpan).click();
		waitUntilVisiblity(floorPlanInputField).sendKeys(floor);
		waitUntilVisiblity(floorPlanInputField).sendKeys(Keys.ENTER);
	}

	public void clickOnFilterButton() {
		waitUntilClickable(filterButton).click();
	}

	public void clickOnClearAllLink() {
		waitUntilClickable(clearAllLink).click();
	}

	public void clickOnCrossIcon() {
		waitUntilClickable(crossIcon).click();
	}
}
