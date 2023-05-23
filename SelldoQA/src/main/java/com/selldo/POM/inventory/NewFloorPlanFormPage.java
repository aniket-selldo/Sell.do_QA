package com.selldo.POM.inventory;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selldo.Utility.ReusableUtils;

public class NewFloorPlanFormPage extends ReusableUtils {
	public WebDriver driver;

	public NewFloorPlanFormPage(WebDriver driver) {
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
	@FindBy(how = How.XPATH, using = "//span[text()='Select a Project Tower']")
	private WebElement projectTowerSpan;
	@FindBy(how = How.XPATH, using = "//*[@id='select2-drop']//div//input")
	private WebElement projectTowerInputField;
	@FindBy(how = How.XPATH, using = "//input[@id='unit_configuration_name']")
	private WebElement floorPlanNameInputField;
	@FindBy(how = How.XPATH, using = "//div[@id='s2id_unit_configuration_bedrooms']")
	private WebElement bedrooms;
	@FindBy(how = How.XPATH, using = "//ul[@class='select2-results']//li")
	private List<WebElement> bedrooms_All;
	@FindBy(how = How.XPATH, using = "//div[@id='s2id_unit_configuration_bathrooms']")
	private WebElement bathrooms;
	@FindBy(how = How.XPATH, using = "//ul[@class='select2-results']//li")
	private List<WebElement> bathrooms_All;
	@FindBy(how = How.XPATH, using = "//div[@id='s2id_unit_configuration_category']")
	private WebElement category;
	@FindBy(how = How.XPATH, using = "//ul[@class='select2-results']//li")
	private List<WebElement> category_All;
	@FindBy(how = How.XPATH, using = "//div[@id='s2id_unit_configuration_type']")
	private WebElement type;
	@FindBy(how = How.XPATH, using = "//ul[@class='select2-results']//li")
	private List<WebElement> type_All;
	@FindBy(how = How.XPATH, using = "//input[@id='unit_configuration_carpet']")
	private WebElement carpet;
	@FindBy(how = How.XPATH, using = "//input[@id='unit_configuration_saleable']")
	private WebElement saleable;
	@FindBy(how = How.XPATH, using = "//input[@id='unit_configuration_covered_area']")
	private WebElement coveredArea;
	@FindBy(how = How.XPATH, using = "//input[@name='unit_configuration[terrace_area]']")
	private WebElement terraceArea;
	@FindBy(how = How.CSS, using = "div.currency2-container.placeholder")
	private List<WebElement> baseRatePlaceHolder;
	@FindBy(how = How.ID, using = "unit_configuration_base_rate")
	private WebElement baseRate;
	@FindBy(how = How.XPATH, using = "//input[@type='submit']")
	private WebElement saveButton;

	public void enterDeveloperName(String project) throws InterruptedException {
		developerSpan.click();
		developerInputField.sendKeys(project);
		Thread.sleep(2000);
		developerInputField.sendKeys(Keys.ENTER);
	}

	public void enterProjectName(String project) throws InterruptedException {
		projectSpan.click();
		projectInputField.sendKeys(project);
		Thread.sleep(2000);
		projectInputField.sendKeys(Keys.ENTER);
	}

	public void enterProjectTowerName(String tower) throws InterruptedException {
		projectTowerSpan.click();
		Thread.sleep(2000);
		projectTowerInputField.sendKeys(tower);
		Thread.sleep(2000);
		projectTowerInputField.sendKeys(Keys.ENTER);
	}

	public void enterFloorPlanName(String address) {
		floorPlanNameInputField.sendKeys(address);
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
		carpet.sendKeys(cArea);
	}

	public void enterSaleableArea(String sArea) {
		saleable.sendKeys(sArea);
	}

	public void enterCoveredArea(String covArea) {
		coveredArea.sendKeys(covArea);
		coveredArea.sendKeys(Keys.TAB);
	}

	public void enterTerraceArea(String tArea) {
		terraceArea.sendKeys(tArea);
	}

	public void enterBaseRate(String base) throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(2000);
		baseRatePlaceHolder.get(0).click();
		baseRate.sendKeys(base);
	}

	public void clickOnSaveButton() {
		saveButton.click();
	}

}
