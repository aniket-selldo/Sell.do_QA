package com.selldo.POM.inventory;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selldo.Utility.ReusableUtils;

import Enums.FloorPlanCategory;
import Enums.FloorPlanType;

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
	@FindBy(how = How.CSS, using = "#s2id_unit_configuration_bedrooms")
	private WebElement bedrooms;
	@FindBy(how = How.XPATH, using = "//ul[@class='select2-results']//li")
	private List<WebElement> bedrooms_All;
	@FindBy(how = How.XPATH, using = "//div[@id='s2id_unit_configuration_bathrooms']")
	private WebElement bathrooms;
	@FindBy(how = How.XPATH, using = "//ul[@class='select2-results']//li")
	private List<WebElement> bathrooms_All;
	@FindBy(how = How.XPATH, using = "//div[@id='s2id_unit_configuration_category']")
	private WebElement category;
	@FindBy(how = How.CSS, using = "#select2-drop li")
	private List<WebElement> category_All;
	@FindBy(how = How.XPATH, using = "//div[@id='s2id_unit_configuration_type']")
	private WebElement type;
	@FindBy(how = How.CSS, using = "#select2-drop li")
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
	@FindBy(how = How.CSS, using = "i.ion-cube")
	private WebElement element;
	@FindBy(how = How.LINK_TEXT, using = "Floor Plans")
	private WebElement FloorPlan;
	@FindBy(how = How.CSS, using = "label[class='lead']")
	private WebElement getFloorName;
	@FindBy(how = How.LINK_TEXT, using = "Projects")
	private WebElement Project;

	public String getFloorName() {
		return waitUntilVisiblity(getFloorName).getText().trim();
	}

	public void clickOnFloorPlan() {
		waitUntilVisiblity(element);
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		waitUntilClickable(FloorPlan).click();
	}
	

	public void enterDeveloperName(String project) throws InterruptedException {
		waitUntilClickable(developerSpan).click();
		waitUntilVisiblity(developerInputField).sendKeys(project);
		waitUntilVisiblity(developerInputField).sendKeys(Keys.ENTER);
	}

	public void enterProjectName(String project) throws InterruptedException {
		waitUntilClickable(projectSpan).click();
		waitUntilVisiblity(projectInputField).sendKeys(project);
		waitUntilVisiblity(projectInputField).sendKeys(Keys.ENTER);
	}

	public void enterProjectTowerName(String tower) throws InterruptedException {
		waitUntilClickable(projectTowerSpan).click();
		waitUntilVisiblity(projectTowerInputField).sendKeys(tower);
		waitUntilVisiblity(projectTowerInputField).sendKeys(Keys.ENTER);
	}

	public void enterFloorPlanName(String address) {
		waitUntilVisiblity(floorPlanNameInputField).sendKeys(address);
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
	public void selectCategory(FloorPlanCategory fpt) throws InterruptedException {
		waitUntilClickable(category).click();
		List<WebElement> list = category_All;
		for (WebElement ele : list) {
			System.out.println("Values " + ele.getAttribute("innerHTML"));
			if (ele.getText().equalsIgnoreCase(fpt.toString())) {
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
	public void selectType(FloorPlanType fpt) throws InterruptedException {
		System.out.println(fpt.toString());
		waitUntilClickable(type).click();
		List<WebElement> list = type_All;
		for (WebElement ele : list) {
			System.out.println("Values " + ele.getAttribute("innerHTML"));
			if (ele.getText().equalsIgnoreCase(fpt.toString())) {
				Thread.sleep(1000);
				waitUntilClickable(ele).click();
				System.out.println("Clicked on penthouse");
				break;
			}
		}
	}

	public void enterCarpetArea(String cArea) {
		waitUntilVisiblity(carpet).sendKeys(cArea);
	}

	public void enterSaleableArea(String sArea) {
		waitUntilVisiblity(saleable).sendKeys(sArea);
	}

	public void enterCoveredArea(String covArea) {
		waitUntilVisiblity(coveredArea).sendKeys(covArea);
		waitUntilVisiblity(coveredArea).sendKeys(Keys.TAB);
	}

	public void enterTerraceArea(String tArea) {
		waitUntilVisiblity(terraceArea).sendKeys(tArea);
	}

	public void enterBaseRate(String base) throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		waitUntilClickable(baseRatePlaceHolder.get(0)).click();
		waitUntilVisiblity(baseRate).sendKeys(base);
	}

	public void clickOnSaveButton() {
		waitUntilClickable(saveButton).click();
	}

}
