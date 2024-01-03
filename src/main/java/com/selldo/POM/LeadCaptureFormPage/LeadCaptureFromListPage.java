package com.selldo.POM.LeadCaptureFormPage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selldo.Utility.ReusableUtils;

public class LeadCaptureFromListPage extends ReusableUtils {

	public WebDriver driver;

	public LeadCaptureFromListPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// WebForm List
	@FindBy(how = How.XPATH, using = "//table[@class='table table-responsive']//tr/td[1]")
	private List<WebElement> getAllWebFormName;
	@FindBy(how = How.XPATH, using = "//i[@class='fa fa-ellipsis-v']")
	private List<WebElement> clickOnEditButton;
	@FindBy(how = How.XPATH, using = "//a[@title=\"Edit\"]")
	private List<WebElement> clickOnEditWebForm;
	@FindBy(how = How.XPATH, using = "//table[@class='table table-responsive']//span[@class='badge badge-success']")
	private List<WebElement> ValidateStatus;
	@FindBy(how = How.XPATH, using = "//table[@class='table table-responsive']//td[2]")
	private List<WebElement> ValidateNumberOfFields;
	// Button
	@FindBy(how = How.XPATH, using = "//a[@href='/client/webforms/new']")
	private WebElement clickOnNewLeadCaptureTemplate;
	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-light btn-icon toggle-filters']")
	private WebElement clickOnFilter;
	// Filter
	@FindBy(how = How.XPATH, using = "input[class='btn btn-primary btn-sm']")
	private WebElement clickOnApplyFilter;
	@FindBy(how = How.XPATH, using = "//span[text()='Select the order']")
	private WebElement clickOnOrderBy;
	@FindBy(how = How.XPATH, using = "//div[@class='select2-result-label']")
	private List<WebElement> selectOnOrderBy;// Ascending // Descending
	@FindBy(how = How.XPATH, using = "//span[text()='Search by name']")
	private WebElement clickOnSearchField;
	@FindBy(how = How.XPATH, using = "//div[@id='select2-drop']//input[@class='select2-input']")
	private WebElement EnterLeadCaptureNameForSearch;

	public void clickNewLeadForm() {
		waitUntilClickable(clickOnNewLeadCaptureTemplate).click();
	}

	public void clickOnFilter() {
		waitUntilClickable(clickOnFilter).click();
	}
	
	public String validateStatus(int val) {
		return waitUntilVisiblity(ValidateStatus.get(val)).getText().trim();
	}
	public int validateNumberOfFileds(int val) {
		return Integer.parseInt(waitUntilVisiblity(ValidateNumberOfFields.get(val)).getText().trim().replaceAll("[^0-9]", ""));
	}

}
