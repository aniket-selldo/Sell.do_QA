package com.selldo.POM.inventory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selldo.Utility.ReusableUtils;

public class EditProjectTowerFormPage extends ReusableUtils {
	public WebDriver driver;

	public EditProjectTowerFormPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//input[@name='project_tower[name]']")
	private WebElement projectTower;
	@FindBy(how = How.XPATH, using = "//input[@value='Save']")
	private WebElement saveButton;
	@FindBy(how = How.XPATH, using = "//a[text()='Area and Costing']")
	private WebElement areaAndCostingLink;
	@FindBy(how = How.XPATH, using = "//a[text()='Other Details']")
	private WebElement otherDetailsLink;
	@FindBy(how = How.XPATH, using = "//a[text()='Cost template']")
	private WebElement costTemplateLink;
	@FindBy(how = How.XPATH, using = "//a[text()='Payment Schedules']")
	private WebElement paymentScheduleLink;
	@FindBy(how = How.XPATH, using = "//a[text()='Payment Schedules']/following::a[1]")
	private WebElement demandLettersLink;
	@FindBy(how = How.XPATH, using = "//a[text()=' View Available Floor Plans']")
	private WebElement viewAvailableFloorPlansLink;
	@FindBy(how = How.XPATH, using = "//a[text()=' View Available Project Towers']")
	private WebElement viewAvailableProjectTowersLink;
	@FindBy(how = How.XPATH, using = "//a[text()='Add Project Tower']")
	private WebElement addProjectTowersLink;

	public void changeProjectTowerName(String project) throws InterruptedException {
		waitUntilVisiblity(projectTower).clear();
		projectTower.sendKeys(project);
	}

	public void clickOnAreaAndCostingLink() {
		waitUntilClickable(areaAndCostingLink).click();
	}

	public void clickOnOtherDetailsLink() {
		waitUntilClickable(otherDetailsLink).click();
	}

	public void clickOnCostTemplateLink() {
		waitUntilClickable(costTemplateLink).click();
	}

	public void clickOnPaymentScheduleLink() {
		waitUntilClickable(paymentScheduleLink).click();
	}

	public void clickOnDemandLettersLink() {
		waitUntilClickable(demandLettersLink).click();
	}

	public void clickOnViewAvailableFloorPlansLink() {
		waitUntilClickable(viewAvailableFloorPlansLink).click();
	}

	public void clickOnviewAvailableProjectTowersLink() {
		waitUntilClickable(viewAvailableProjectTowersLink).click();
	}

	public void clickOnAddProjectTowersLink() {
		waitUntilClickable(addProjectTowersLink).click();
	}

	public void clickOnSaveButton() {
		waitUntilClickable(saveButton).click();
	}
}
