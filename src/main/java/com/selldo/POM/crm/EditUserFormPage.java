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
		FirstName.clear();
		FirstName.sendKeys(firstname);
	}

	public void changeLastName(String lastname) {
		LastName.clear();
		LastName.sendKeys(lastname);
	}

	public void changePhone(String phone) {
		Phone.clear();
		Phone.sendKeys(phone);
	}

	public void changeEmail(String email) {
		Email.clear();
		Email.sendKeys(email);
	}

	// Selecting Department

	public void changeDepartmentToPresales() {
		selectByVisibleText(DepartmentDropdown, "Pre Sales");
	}

	public void changeDepartmentToSales() {
		selectByVisibleText(DepartmentDropdown, "Sales");
	}

	public void changeDepartmentToPostSales() {
		selectByVisibleText(DepartmentDropdown, "Post Sales");
	}

	// Selecting Role

	public void changeRoleToPresales() {
		selectByVisibleText(RoleDropdown, "Pre Sales");
	}

	public void changeRoleToSales() {
		selectByVisibleText(RoleDropdown, "Sales");
	}

	public void changeRoleToPostSales() {
		selectByVisibleText(RoleDropdown, "Post Sales");
	}

	public void changeRoleToManager() {
		selectByVisibleText(RoleDropdown, "Manager");
	}

	public void changeRoleToAdmin() {
		selectByVisibleText(RoleDropdown, "Admin");
	}

	// Selecting Team

	public void changeTeamByIndex() {
		selectByIndex(TeamDropdown, 1);
	}

	public void changeTeamByText() {
		selectByVisibleText(TeamDropdown, "TeamX");
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
	// TeamDropdown.click();
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
	// ele.click();
	// break;
	// }
	// }
	// }

	public void clickOnSaveButton() {
		SaveButton.click();
	}

}
