package com.selldo.POM.inventory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selldo.Utility.ReusableUtils;

public class EditUnitPage extends ReusableUtils {
	public WebDriver driver;

	public EditUnitPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//input[@name='project_unit[name]']")
	private WebElement unitName;
	@FindBy(how = How.XPATH, using = "//input[@type='submit']")
	private WebElement saveButton;
	@FindBy(how = How.XPATH, using = "//a[text()='Details']")
	private WebElement detailsLink;
	@FindBy(how = How.XPATH, using = "//a[text()='Area and Costing']")
	private WebElement areaAndCostingLink;
	@FindBy(how = How.XPATH, using = "//a[text()='Extras']")
	private WebElement extrasLink;
	@FindBy(how = How.XPATH, using = "//a[text()='Cost template']")
	private WebElement costTemplateLink;
	@FindBy(how = How.XPATH, using = "//a[text()='View Floor Plan']")
	private WebElement viewFloorPlanLink;
	@FindBy(how = How.XPATH, using = "//a[text()='View Floor Plan']/following::a[2]")
	private WebElement allUnitsLink;
	@FindBy(how = How.XPATH, using = "//a[@href='/client/project_units/new']")
	private WebElement addUnitLink;

	public void changeUnitName(String project) throws InterruptedException {
		unitName.clear();
		unitName.sendKeys(project);
	}

	public void clickOnDetailsLink() {
		detailsLink.click();
	}

	public void clickOnAreaAndCostingLink() {
		areaAndCostingLink.click();
	}

	public void clickOnExtrasLink() {
		extrasLink.click();
	}

	public void clickOnCostTemplateLink() {
		costTemplateLink.click();
	}

	public void clickOnViewFloorPlanLink() {
		viewFloorPlanLink.click();
	}

	public void clickOnAllUnitsLink() {
		allUnitsLink.click();
	}

	public void clickOnAddUnitLink() {
		addUnitLink.click();
	}

	public void clickOnSaveButton() {
		saveButton.click();
	}

}
