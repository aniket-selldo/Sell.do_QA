package com.selldo.POM.inventory;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selldo.Utility.ReusableUtils;

public class NewProjectTowerFormPage extends ReusableUtils {
	public WebDriver driver;

	public NewProjectTowerFormPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//input[@id='project_tower_name']")
	private WebElement towerNameInputField;
	@FindBy(how = How.XPATH, using = "//span[text()='Project Name']")
	private WebElement projectSpan;
	@FindBy(how = How.XPATH, using = "//*[@id='select2-drop']//div//input")
	private WebElement projectInputField;
	@FindBy(how = How.XPATH, using = "//input[@id='project_tower_total_floors']")
	private WebElement totalFloorsInputField;
	@FindBy(how = How.XPATH, using = "//input[@value='Save']")
	private WebElement saveButton;

	public void enterProjectTowerName(String pTower) {
		towerNameInputField.sendKeys(pTower);
	}

	public void enterProjectName(String project) throws InterruptedException {
		projectSpan.click();
		projectInputField.sendKeys(project);
		Thread.sleep(2000);
		projectInputField.sendKeys(Keys.ENTER);
	}

	public void enterTotalFloorsNumber(String floorNumber) {
		totalFloorsInputField.sendKeys(floorNumber);
	}

	public void clickOnSaveButton() {
		saveButton.click();
	}
}
