package com.selldo.POM.crm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selldo.Utility.ReusableUtils;

public class EditUserFormPage extends ReusableUtils {
	public WebDriver driver;

	public EditUserFormPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//input[@id='user_first_name']")
	private WebElement FirstName;
	@FindBy(how = How.XPATH, using = "//input[@id='user_last_name']")
	private WebElement LastName;
	@FindBy(how = How.XPATH, using = "//input[@class='phone_number form-control user_primary_phone']")
	private WebElement Phone;
	@FindBy(how = How.XPATH, using = "//input[@id='user_email']")
	private WebElement Email;
	@FindBy(how = How.XPATH, using = "//select[@id='user_department']")
	private WebElement DepartmentDropdown;
	@FindBy(how = How.XPATH, using = "//select[@id='user_role']")
	private WebElement RoleDropdown;
	@FindBy(how = How.XPATH, using = "//select[@id='user_team_id']")
	private WebElement TeamDropdown;
	@FindBy(how = How.XPATH, using = "//input[@class='btn btn-primary']")
	private WebElement SaveButton;

	public void changeFirstName(String firstname) {
		waitUntilVisiblity(FirstName).clear();
		waitUntilVisiblity(FirstName).sendKeys(firstname);
	}

	public void changeLastName(String lastname) {
		waitUntilVisiblity(LastName).clear();
		waitUntilVisiblity(LastName).sendKeys(lastname);
	}

	public void changePhone(String phone) {
		System.out.println("Update phone -> "+phone);
		waitUntilVisiblity(Phone).clear();
		waitUntilVisiblity(Phone).sendKeys(phone);
	}

	public void changeEmail(String email) {
		System.out.println("Update Email -> "+email);
		waitUntilVisiblity(Email).clear();
		waitUntilVisiblity(Email).sendKeys(email);
	}

	// Selecting Department

	public void changeDepartmentToPresales() {
		waitUntilVisiblity(DepartmentDropdown);
		selectByVisibleText(DepartmentDropdown, "Pre Sales");
	}

	public void changeDepartmentToSales() {
		selectByVisibleText(waitUntilVisiblity(DepartmentDropdown), "Sales");
	}

	public void changeDepartmentToPostSales() {
		selectByVisibleText(waitUntilVisiblity(DepartmentDropdown), "Post Sales");
	}

	// Selecting Role

	public void changeRoleToPresales() {
		selectByVisibleText(waitUntilVisiblity(RoleDropdown), "Pre Sales");
	}

	public void changeRoleToSales() {
		selectByVisibleText(waitUntilVisiblity(RoleDropdown), "Sales");
	}

	public void changeRoleToPostSales() {
		selectByVisibleText(waitUntilVisiblity(RoleDropdown), "Post Sales");
	}

	public void changeRoleToManager() {
		selectByVisibleText(waitUntilVisiblity(RoleDropdown), "Manager");
	}

	public void changeRoleToAdmin() {
		selectByVisibleText(waitUntilVisiblity(RoleDropdown), "Admin");
	}

	// Selecting Team

	public void changeTeamByIndex() {
		selectByIndex(waitUntilVisiblity(TeamDropdown), 1);
	}

	public void changeTeamByText() {
		selectByVisibleText(waitUntilVisiblity(TeamDropdown), "TeamX");
	}

//	public void selectTeam() {
//		Select select = new Select(TeamDropdown));
//		select.deselectAll();
//		WebElement option = select.getFirstSelectedOption();
//	}

	// public void selectTeam(){
	// Select dropDown = new Select(TeamDropdown));
	// List <WebElement> elementCount = dropDown.getOptions();
	// int itemSize = elementCount.size();
	// for(int i = 0; i < itemSize ; i++){
	// String optionsValue = elementCount.get(i).getText();
	// System.out.println(optionsValue);
	// }
	// }
	//
	// public void selectTeam(){
	// TeamDropdown).click();
	// Select oSelect = new Select(TeamDropdown));
	// for (WebElement ele : oSelect)
	// {
	// System.out.println("Values " + ele.getAttribute("class"));
	//
	// if (ele.getAttribute("class").contains("hidden")) {
	//
	// ele.oSelect.selectByVisibleText("TeamX");}
	//
	// else {
	//
	// ele).click();
	// break;
	// }
	// }
	// }

	public void clickOnSaveButton() {
		waitUntilVisiblity(SaveButton).click();
		driver.get(prop("URL")+"/client/users");
	}

}
