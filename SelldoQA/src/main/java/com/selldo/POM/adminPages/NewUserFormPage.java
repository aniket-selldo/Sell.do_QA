package com.selldo.POM.adminPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selldo.Utility.ReusableUtils;

public class NewUserFormPage extends ReusableUtils {
	public WebDriver driver;

	public NewUserFormPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//input[@id='user_first_name']")
	private WebElement firstName;
	@FindBy(how = How.XPATH, using = "//input[@id='user_last_name']")
	private WebElement lastName;
	@FindBy(how = How.XPATH, using = "//input[@class='phone_number form-control user_primary_phone']")
	private WebElement phone;
	@FindBy(how = How.XPATH, using = "//input[@id='user_email']")
	private WebElement email;
	@FindBy(how = How.XPATH, using = "//a[text()='Professional Details']")
	private WebElement professionalDetailsTab;
	@FindBy(how = How.XPATH, using = "//select[@id='user_department']")
	private WebElement departmentDropdown;
	@FindBy(how = How.XPATH, using = "//select[@id='user_role']")
	private WebElement roleDropdown;
	@FindBy(how = How.XPATH, using = "//span[text()='Please Select a Team']")
	private WebElement teamDropdown;
	@FindBy(how = How.XPATH, using = "//span[text()='Select teams']")
	private WebElement managerTeamDropdown;
	@FindBy(how = How.XPATH, using = ".//*[@id='select2-drop']/ul/li[50]/div")
	private WebElement team_dd;
	@FindBy(how = How.XPATH, using = ".//*[@id='select2-drop']/ul/li[2]/div")
	private WebElement SourceFrom_dd;
	@FindBy(how = How.XPATH, using = "//input[@class='btn btn-primary']")
	private WebElement saveButton;

	public void enterFirstName(String firstname) {
		firstName.sendKeys(firstname);
	}

	public void enterLastName(String lastname) {
		lastName.sendKeys(lastname);
	}

	public void enterPhone(String ph) {
		phone.sendKeys(ph);
	}

	public void enterEmail(String em) {
		email.sendKeys(em);
	}

	public void clickOnProfessionalDetailsTab() {
		professionalDetailsTab.click();
	}

	// Methods for Selecting Department

	public void selectDepartment_Presales() {

		selectByVisibleText(departmentDropdown, "Pre Sales");
	}

	public void selectDepartment_Sales() {

		selectByVisibleText(departmentDropdown, "Sales");
	}

	public void selectDepartment_PostSales() {

		selectByVisibleText(departmentDropdown, "Post Sales");
	}

	// Methods for Selecting Role

	public void selectRole_Presales() {

		selectByVisibleText(roleDropdown, "Pre Sales");
	}

	public void selectRole_Sales() {

		selectByVisibleText(roleDropdown, "Sales");
	}

	public void selectRole_PostSales() {

		selectByVisibleText(roleDropdown, "Post Sales");
	}

	public void selectRole_Manager() {

		selectByVisibleText(roleDropdown, "Manager");
	}

	public void selectRole_Admin() {

		selectByVisibleText(roleDropdown, "Admin");
	}

	// Methods for Selecting Team

	public void selectTeamByIndex() {
		selectByIndex(teamDropdown, 1);
	}

	public void selectTeam() {

		teamDropdown.click();
		team_dd.click();
	}

	public void selectTeamForManager() {

		managerTeamDropdown.click();
		team_dd.click();
	}

	public void selectTeamByText() {
		selectByVisibleText(teamDropdown, "Team#1");
	}

	public void clickOnSaveButton() {
		saveButton.click();
	}
}
