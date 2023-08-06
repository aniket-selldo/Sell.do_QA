package com.selldo.POM.inventory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selldo.Utility.ReusableUtils;

public class EditFloorPlanPage extends ReusableUtils {
	public WebDriver driver;

	public EditFloorPlanPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//span[text()='Select a Developer']")
	private WebElement developerSpan;
	@FindBy(how = How.XPATH, using = "//*[@id='select2-drop']//div//input")
	private WebElement developerInputField;
	@FindBy(how = How.XPATH, using = "//span[text()='Select a Project']")
	private WebElement projectSpan;
	@FindBy(how = How.XPATH, using = "//*[@id='select2-drop']//div//input")
	private WebElement projectInputField;
	@FindBy(how = How.XPATH, using = "Select a Project Tower")
	private WebElement projectTowerSpan;
	@FindBy(how = How.XPATH, using = "//*[@id='select2-drop']//div//input")
	private WebElement projectTowerInputField;
	@FindBy(how = How.XPATH, using = "//input[@id='unit_configuration_name']")
	private WebElement floorPlanNameInputField;
	@FindBy(how = How.XPATH, using = "//label[@for='s2id_autogen5']/following::a[1]")
	private WebElement bedrooms;
	@FindBy(how = How.XPATH, using = "//ul[@class='select2-results']//li")
	private WebElement bedrooms_All;
	@FindBy(how = How.XPATH, using = "//label[@for='s2id_autogen6']/following::a[1]")
	private WebElement bathrooms;
	@FindBy(how = How.XPATH, using = "//ul[@class='select2-results']//li")
	private WebElement bathrooms_All;
	@FindBy(how = How.XPATH, using = "//input[@type='submit']")
	private WebElement saveButton;
	@FindBy(how = How.XPATH, using = "//a[text()='Area and Costing']")
	private WebElement areaAndCostingLink;
	@FindBy(how = How.XPATH, using = "//a[text()='Extras']")
	private WebElement extrasLink;
	@FindBy(how = How.XPATH, using = "//a[text()='Floorplan Images']")
	private WebElement floorPlanImagesLink;
	@FindBy(how = How.XPATH, using = "//a[text()='Price Quotes and Brochures']")
	private WebElement priceQuotesAndBrochureLink;
	@FindBy(how = How.XPATH, using = "//a[text()='Regions']")
	private WebElement regionsLink;
	@FindBy(how = How.XPATH, using = "//a[text()='Cost template']")
	private WebElement costTemplateLink;
	@FindBy(how = How.XPATH, using = "//a[text()='View Available Project Units']")
	private WebElement viewUnitsLink;
	@FindBy(how = How.XPATH, using = "//a[text()='Add Unit']")
	private WebElement addUnitLink;
	@FindBy(how = How.XPATH, using = "//a[text()='All Floor Plans']")
	private WebElement allFloorPlans;
	@FindBy(how = How.XPATH, using = "//a[text()='Add Floor Plan']")
	private WebElement addFloorPlan;
	@FindBy(how = How.XPATH, using = "//table[@class='table table-responsive']/tbody/tr/td[1]")
	private List<WebElement> getAllFloorPlanName;
	
	public String  getAllFloorPlanName() {
		return getAllFloorPlanName.stream().findAny().get().getText();
	}

	public void changeProjectTowerName(String project) throws InterruptedException {
		waitUntilVisiblity(floorPlanNameInputField).clear();
		waitUntilVisiblity(floorPlanNameInputField).sendKeys(project);
	}

	public void clickOnAreaAndCostingLink() {
		waitUntilClickable(areaAndCostingLink).click();
	}

	public void clickOnExtrasLink() {
		waitUntilClickable(extrasLink).click();
	}

	public void clickOnFloorPlanImagesLink() {
		waitUntilClickable(floorPlanImagesLink).click();
	}

	public void clickOnPriceQuotesAndBrochureLink() {
		waitUntilClickable(priceQuotesAndBrochureLink).click();
	}

	public void clickOnRegionsLink() {
		waitUntilClickable(regionsLink).click();
	}

	public void clickOnCostTemplateLink() {
		waitUntilClickable(costTemplateLink).click();
	}

	public void clickOnViewUnitsLink() {
		waitUntilClickable(viewUnitsLink).click();
	}

	public void clickOnAddUnitLink() {
		waitUntilClickable(addUnitLink).click();
	}

	public void clickOnAllFloorPlans() {
		waitUntilClickable(allFloorPlans).click();
	}

	public void clickOnAddFloorPlan() {
		scrollHeight() ;
		waitUntilClickable(addFloorPlan).click();
	}

	public void clickOnSaveButton() {
		waitUntilClickable(saveButton).click();
	}
}
