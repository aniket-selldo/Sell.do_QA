package com.selldo.POM.inventory;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selldo.Utility.ReusableUtils;

public class NewUnitFormPage extends ReusableUtils {

	public WebDriver driver;

	public NewUnitFormPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

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
	private WebElement unitConfiguration;
	@FindBy(how = How.XPATH, using = "//*[@id='select2-drop']//div//input")
	private WebElement unitConfigurationInputField;
	@FindBy(how = How.XPATH, using = "//input[@id='project_unit_name']")
	private WebElement nameInputField;
	@FindBy(how = How.XPATH, using = "//input[@id='project_unit_floor']")
	private WebElement floorInputField;
	@FindBy(how = How.CSS, using = "div.currency2-container.placeholder")
	private List<WebElement> baseRatePlaceHolder;
	@FindBy(how = How.ID, using = "project_unit_base_rate")
	private WebElement baseRateInputField;
	@FindBy(how = How.XPATH, using = "//input[@id='project_unit_base_price']")
	private WebElement basePriceInputField;
	@FindBy(how = How.XPATH, using = "//div[@id='s2id_project_unit_bedrooms']")
	private WebElement bedrooms;
	@FindBy(how = How.XPATH, using = "//ul[@class='select2-results']//li")
	private List<WebElement> bedrooms_All;
	@FindBy(how = How.XPATH, using = "//div[@id='s2id_project_unit_bathrooms']")
	private WebElement bathrooms;
	@FindBy(how = How.XPATH, using = "//ul[@class='select2-results']//li")
	private List< WebElement> bathrooms_All;
	@FindBy(how = How.XPATH, using = "//div[@id='s2id_project_unit_category']")
	private WebElement category;
	@FindBy(how = How.XPATH, using = "//ul[@class='select2-results']//li")
	private List<WebElement> category_All;
	@FindBy(how = How.XPATH, using = "//div[@id='s2id_project_unit_type']")
	private WebElement type;
	@FindBy(how = How.XPATH, using = "//ul[@class='select2-results']//li")
	private List<WebElement> type_All;
	@FindBy(how = How.XPATH, using = "//input[@id='project_unit_saleable']")
	private WebElement saleableArea;
	@FindBy(how = How.XPATH, using = "//input[@id='project_unit_carpet']")
	private WebElement carpetArea;
	@FindBy(how = How.XPATH, using = "//input[@type='submit']")
	private WebElement saveButton;

	public void enterDeveloperName(String project) throws InterruptedException {
		developer.click();
		developerInputField.sendKeys(project);
		Thread.sleep(2000);
		developerInputField.sendKeys(Keys.ENTER);
	}

	public void enterProjectName(String pro) throws InterruptedException {
		project.click();
		projectInputField.sendKeys(pro);
		Thread.sleep(2000);
		projectInputField.sendKeys(Keys.ENTER);
	}

	public void enterProjectTowerName(String tower) throws InterruptedException {
		projectTower.click();
		// Thread.sleep(2000);
		projectTowerField.sendKeys(tower);
		Thread.sleep(2000);
		projectTowerField.sendKeys(Keys.ENTER);
	}

	public void enterFloorPlanName(String tower) throws InterruptedException {
		unitConfiguration.click();
		unitConfigurationInputField.sendKeys(tower);
		Thread.sleep(2000);
		unitConfigurationInputField.sendKeys(Keys.ENTER);
	}

	public void enterUnitName(String ut) {
		nameInputField.sendKeys(ut);
	}

	public void enterNumberOfFloors(String cArea) {
		floorInputField.clear();
		floorInputField.sendKeys(cArea);
		floorInputField.sendKeys(Keys.ENTER);
	}

	public void selectNumberOfBedrooms() throws InterruptedException {
		bedrooms.click();
		List<WebElement> list = bedrooms_All;
		for (WebElement ele : list) {
			System.out.println("Values " + ele.getAttribute("innerHTML"));
			if (ele.getAttribute("innerHTML").contains("3")) {
				Thread.sleep(1000);
				ele.click();
				System.out.println("Clicked on 3");
				break;
			}
		}
	}

	public void selectNumberOfBathrooms() throws InterruptedException {
		bathrooms.click();
		List<WebElement> list = bathrooms_All;
		for (WebElement ele : list) {
			System.out.println("Values " + ele.getAttribute("innerHTML"));
			if (ele.getAttribute("innerHTML").contains("3")) {
				Thread.sleep(1000);
				ele.click();
				System.out.println("Clicked on 3");
				break;
			}
		}
	}

	public void selectCategory() throws InterruptedException {
		category.click();
		List<WebElement> list = category_All;
		for (WebElement ele : list) {
			System.out.println("Values " + ele.getAttribute("innerHTML"));
			if (ele.getAttribute("innerHTML").contains("facing")) {
				Thread.sleep(1000);
				ele.click();
				System.out.println("Clicked on facing");
				break;
			}
		}
	}

	public void selectType() throws InterruptedException {
		type.click();
		List<WebElement> list = type_All;
		for (WebElement ele : list) {
			System.out.println("Values " + ele.getAttribute("innerHTML"));
			if (ele.getAttribute("innerHTML").contains("penthouse")) {
				Thread.sleep(1000);
				ele.click();
				System.out.println("Clicked on penthouse");
				break;
			}
		}
	}

	public void enterCarpetArea(String cArea) {
		carpetArea.sendKeys(cArea);
	}

	public void enterSaleableArea(String sArea) {
		saleableArea.sendKeys(sArea);
	}

	/*
	 * public void enterBaseRate(String base) { baseRateInputField.sendKeys(base); }
	 */

	public void enterUnitBaseRate(String base) throws Exception {
		baseRatePlaceHolder.get(0).click();
		baseRateInputField.sendKeys(base);
	}

	public void clickOnSaveButton() {
		saveButton.click();
	}

}
