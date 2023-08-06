package com.selldo.POM.inventory;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selldo.Utility.ReusableUtils;

import Enums.Project;

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
	@FindBy(how = How.LINK_TEXT, using = "Project Towers")
	private WebElement clickOnProjectTower;
	@FindBy(how = How.CSS, using = "i.ion-cube")
	private WebElement element;
	@FindBy(how = How.XPATH, using = "//a[text()='All Project Towers']/following::label[1]")
	private WebElement getProjectName;
	@FindBy(how = How.CSS, using = "#select2-drop li")
	private List<WebElement> selectFromDropdown;
	
	public String getProjectName() {
		return waitUntilVisiblity(getProjectName).getText().trim();
	}

	public void clickOnProjectTower() {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		waitUntilClickable(clickOnProjectTower).click();
	}

	public void enterProjectTowerName(String pTower) {
		waitUntilVisiblity(towerNameInputField).sendKeys(pTower);
	}

	public void enterProjectName(Project project) throws InterruptedException {
		waitUntilClickable(projectSpan).click();
		System.out.println(project.getName().replaceAll("[^A-Za-z0-9]", " ").trim());
		waitUntilVisiblity(projectInputField).sendKeys(project.getName().replaceAll("[^A-Za-z0-9]", " ").trim());
		wait(1000);
		waitUntilVisiblity(projectInputField).sendKeys(Keys.ENTER);
		
	}

	public void enterTotalFloorsNumber(String floorNumber) {
		waitUntilVisiblity(totalFloorsInputField).sendKeys(floorNumber);
	}

	public void clickOnSaveButton() {
		waitUntilClickable(saveButton).click();
	}
}
