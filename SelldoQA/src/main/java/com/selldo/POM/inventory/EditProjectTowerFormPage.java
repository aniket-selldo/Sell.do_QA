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
		projectTower.clear();
		projectTower.sendKeys(project);
	}

	public void clickOnAreaAndCostingLink() {
		areaAndCostingLink.click();
	}

	public void clickOnOtherDetailsLink() {
		otherDetailsLink.click();
	}

	public void clickOnCostTemplateLink() {
		costTemplateLink.click();
	}

	public void clickOnPaymentScheduleLink() {
		paymentScheduleLink.click();
	}

	public void clickOnDemandLettersLink() {
		demandLettersLink.click();
	}

	public void clickOnViewAvailableFloorPlansLink() {
		viewAvailableFloorPlansLink.click();
	}

	public void clickOnviewAvailableProjectTowersLink() {
		viewAvailableProjectTowersLink.click();
	}

	public void clickOnAddProjectTowersLink() {
		addProjectTowersLink.click();
	}

	public void clickOnSaveButton() {
		saveButton.click();
	}
}
