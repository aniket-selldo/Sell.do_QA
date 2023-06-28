package com.selldo.POM.inventory;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selldo.Utility.ReusableUtils;

public class EditDeveloperFormPage extends ReusableUtils {
	public WebDriver driver;

	public EditDeveloperFormPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.CSS, using = "#s2id_developer_name span[class='select2-chosen']")
	private WebElement developerNameSpan;
	@FindBy(how = How.XPATH, using = "//*[@id='select2-drop']//div//input")
	private WebElement developerNameInputField;
	@FindBy(how = How.XPATH, using = "//input[@type='submit']")
	private WebElement saveButton;
	@FindBy(how = How.XPATH, using = "//a[text()='Address']")
	private WebElement address;
	@FindBy(how = How.XPATH, using = "//a[text()='Contacts']")
	private WebElement contacts;
	@FindBy(how = How.XPATH, using = "//a[text()='Custom Fields']")
	private WebElement customFields;
	@FindBy(how = How.XPATH, using = "//a[text()='All developers']")
	private WebElement allDevelopers;
	@FindBy(how = How.XPATH, using = "//a[text()='Add developer']")
	private WebElement addDeveloper;

	public void changeDeveloperName(String developer) throws InterruptedException {
		waitUntilClickable(developerNameSpan).click();
		waitUntilVisiblity(developerNameInputField).sendKeys(developer);
		waitUntilVisiblity(developerNameInputField).sendKeys(Keys.ENTER);
	}

	public void clickOnAddressLink() {
		waitUntilClickable(address).click();
	}

	public void clickOnContactsLink() {
		waitUntilClickable(contacts).click();
	}

	public void clickOnCustomFields() {
		waitUntilClickable(customFields).click();
	}

	public void clickOnAllDevelopers() {
		waitUntilClickable(allDevelopers).click();
	}

	public void clickOnAddDeveloper() {
		waitUntilClickable(addDeveloper).click();
	}

	public void clickOnSaveButton() {
		waitUntilClickable(saveButton).click();
	}

}
