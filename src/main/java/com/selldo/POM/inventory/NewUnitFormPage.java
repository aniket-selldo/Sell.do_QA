package com.selldo.POM.inventory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selldo.Utility.ReusableUtils;

import Enums.Project;

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
	@FindBy(how = How.CSS, using = "#project_unit_name")
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
	private List<WebElement> bathrooms_All;
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
	@FindBy(how = How.CSS, using = "#s2id_project_unit_unit_configuration_id")
	private WebElement UnitConfig;
	@FindBy(how = How.XPATH, using = "//td[@scope='col'][2]//a") // td[@scope="col"][2]/span/text()[2]
	private List<WebElement> allUnitName;
	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-light btn-icon toggle-filters']")
	private WebElement clickOnFilter;
	@FindBy(how = How.XPATH, using = "//span[text()='Select Unit']")
	private WebElement clickOnUnit;
	@FindBy(how = How.XPATH, using = "//*[@id='select2-drop']/div/input")
	private WebElement enterUnitName;
	@FindBy(how = How.CSS, using = "li[class='select2-results-dept-0 select2-result select2-result-selectable select2-highlighted']")
	private WebElement isNamePresent;

	public boolean checkUnitIsCreated(String str) {
		return allUnitName.contains(str);
	}

	public boolean FindUnit(String str) {
		WebElement element = driver.findElement(By.cssSelector("i.ion-cube"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		driver.findElement(By.linkText("Units")).click();

		jsClick(clickOnFilter);
		waitUntilClickable(clickOnUnit).click();
		wait(1000);
		(enterUnitName).click();
		enterUnitName.sendKeys(str);
		return waitUntilVisiblity(isNamePresent).getText().split("-")[0].trim().equalsIgnoreCase(str);

	}

	public void enterDeveloperName(String project) throws InterruptedException {
		waitUntilClickable(developer).click();
		waitUntilVisiblity(developerInputField).sendKeys(project);
		wait(1000);
		waitUntilVisiblity(developerInputField).sendKeys(Keys.ENTER);
	}

	public void enterUnitConfiguration(String project) throws InterruptedException {
		waitUntilClickable(UnitConfig).click();
		waitUntilVisiblity(developerInputField).sendKeys(project);
		wait(1000);
		waitUntilVisiblity(developerInputField).sendKeys(Keys.ENTER);
	}

	public void enterDeveloperName(Project project) throws InterruptedException {
		waitUntilClickable(developer).click();
		waitUntilVisiblity(developerInputField).sendKeys(project.toString());
		wait(1000);
		waitUntilVisiblity(developerInputField).sendKeys(Keys.ENTER);
	}

	public void enterProjectName(Project pro) throws InterruptedException {
		waitUntilClickable(project).click();
		waitUntilVisiblity(projectInputField).sendKeys(pro.getName().replaceAll("[^A-Za-z0-9]", " "));
		wait(1000);
		waitUntilVisiblity(projectInputField).sendKeys(Keys.ENTER);
	}
	public void enterProjectName(String pro) throws InterruptedException {
		waitUntilClickable(project).click();
		waitUntilVisiblity(projectInputField).sendKeys(pro.replaceAll("[^A-Za-z0-9]", " "));
		wait(1000);
		waitUntilVisiblity(projectInputField).sendKeys(Keys.ENTER);
	}

	public void enterProjectTowerName(String tower) throws InterruptedException {
		waitUntilClickable(projectTower).click();
		// Thread.sleep(2000);
		waitUntilVisiblity(projectTowerField).sendKeys(tower);
		wait(1000);
		waitUntilVisiblity(projectTowerField).sendKeys(Keys.ENTER);
	}

	public void enterFloorPlanName(String tower) throws InterruptedException {
		waitUntilClickable(unitConfiguration).click();
		waitUntilVisiblity(unitConfigurationInputField).sendKeys(tower);
		wait(1000);
		waitUntilVisiblity(unitConfigurationInputField).sendKeys(Keys.ENTER);
	}

	public void enterUnitName(String ut) {
		waitUntilVisiblity(nameInputField).sendKeys(ut);
	}

	public void enterNumberOfFloors(String cArea) {
		floorInputField.clear();
		waitUntilVisiblity(floorInputField).sendKeys(cArea);
		wait(1000);
		waitUntilVisiblity(floorInputField).sendKeys(Keys.ENTER);
	}

	public void selectNumberOfBedrooms() throws InterruptedException {
		waitUntilClickable(bedrooms).click();
		List<WebElement> list = bedrooms_All;
		for (WebElement ele : list) {
			System.out.println("Values " + ele.getAttribute("innerHTML"));
			if (ele.getAttribute("innerHTML").contains("3")) {
				Thread.sleep(1000);
				waitUntilClickable(ele).click();
				System.out.println("Clicked on 3");
				break;
			}
		}
	}

	public void selectNumberOfBathrooms() throws InterruptedException {
		waitUntilClickable(bathrooms).click();
		List<WebElement> list = bathrooms_All;
		for (WebElement ele : list) {
			System.out.println("Values " + ele.getAttribute("innerHTML"));
			if (ele.getAttribute("innerHTML").contains("3")) {
				Thread.sleep(1000);
				waitUntilClickable(ele).click();
				System.out.println("Clicked on 3");
				break;
			}
		}
	}

	public void selectCategory() throws InterruptedException {
		waitUntilClickable(category).click();
		List<WebElement> list = category_All;
		for (WebElement ele : list) {
			System.out.println("Values " + ele.getAttribute("innerHTML"));
			if (ele.getAttribute("innerHTML").contains("facing")) {
				Thread.sleep(1000);
				waitUntilClickable(ele).click();
				System.out.println("Clicked on facing");
				break;
			}
		}
	}

	public void selectType() throws InterruptedException {
		waitUntilClickable(type).click();
		List<WebElement> list = type_All;
		for (WebElement ele : list) {
			System.out.println("Values " + ele.getAttribute("innerHTML"));
			if (ele.getAttribute("innerHTML").contains("penthouse")) {
				Thread.sleep(1000);
				waitUntilClickable(ele).click();
				System.out.println("Clicked on penthouse");
				break;
			}
		}
	}

	public void enterCarpetArea(String cArea) {
		waitUntilVisiblity(carpetArea).sendKeys(cArea);
	}

	public void enterSaleableArea(String sArea) {
		waitUntilVisiblity(saleableArea).sendKeys(sArea);
	}

	/*
	 * public void enterBaseRate(String base) { baseRateInputField).sendKeys(base);
	 * }
	 */

	public void enterUnitBaseRate(String base) throws Exception {
		waitUntilClickable(baseRatePlaceHolder.get(0)).click();
		waitUntilVisiblity(baseRateInputField).sendKeys(base);
	}

	public void clickOnSaveButton() {
		waitUntilClickable(saveButton).click();
	}

}
