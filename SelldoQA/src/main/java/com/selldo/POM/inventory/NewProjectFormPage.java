package com.selldo.POM.inventory;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selldo.Utility.ReusableUtils;

public class NewProjectFormPage extends ReusableUtils {
	public WebDriver driver;

	public NewProjectFormPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//label[@for='project_project_name']/following::span[1]")
	private WebElement projectNameSpan;
	@FindBy(how = How.XPATH, using = "//*[@id='select2-drop']//div//input")
	private WebElement projectNameInputField;
	@FindBy(how = How.XPATH, using = "//span[text()='Developer']")
	private WebElement developerSpan;
	@FindBy(how = How.XPATH, using = "//*[@id='select2-drop']//div//input")
	private WebElement developerInputField;
	@FindBy(how = How.XPATH, using = "//div[@class='note-editable card-block']")
	private WebElement descriptionTextArea;
	@FindBy(how = How.XPATH, using = "//label[text()='Sales']/following::input[1]")
	private WebElement salesSpan;
	@FindBy(how = How.XPATH, using = "//ul[@class='select2-results']//li")
	private List<WebElement> sales_All;
	@FindBy(how = How.XPATH, using = "//label[text()='Pre Sales']/following::input[1]")
	private WebElement presalesSpan;
	@FindBy(how = How.XPATH, using = "//ul[@class='select2-results']//li")
	private List<WebElement> presales_All;
	@FindBy(how = How.XPATH, using = "//label[@for='project_project_post_sales']/following::input[1]")
	private WebElement postsalesSpan;
	@FindBy(how = How.XPATH, using = "//ul[@class='select2-results']//li")
	private List<WebElement> postsales_All;
	@FindBy(how = How.XPATH, using = "//input[@id='project_possession']")
	private WebElement possession;
	@FindBy(how = How.CSS, using = "div.datepicker.datepicker-dropdown.dropdown-menu.datepicker-orient-left.datepicker-orient-top tbody tr td")
	private WebElement possession_All;
	@FindBy(how = How.CSS, using = "#s2id_project_type > a > span.select2-chosen")
	private WebElement projectTypeSpan;
	@FindBy(how = How.XPATH, using = "//ul[@class='select2-results']//li")
	private List<WebElement> projectType_All;
	@FindBy(how = How.XPATH, using = "//input[@name='project[micro_market]']")
	private WebElement localityInputField;
	@FindBy(how = How.XPATH, using = "//input[@name='project[lat]']")
	private WebElement latitudeInptField;
	@FindBy(how = How.XPATH, using = "//input[@name='project[lng]']")
	private WebElement longitudeInputField;
	@FindBy(how = How.XPATH, using = "//input[@id='project_address_attributes_address1']")
	private WebElement addressInputField;
	@FindBy(how = How.XPATH, using = "//input[@id='project_address_attributes_address2']")
	private WebElement streetInputField;
	@FindBy(how = How.XPATH, using = "//input[@id='project_address_attributes_city']")
	private WebElement cityInputField;
	@FindBy(how = How.CSS, using = "select[name=\"project[address_attributes][state]\"]")
	private WebElement stateDropdown;
	@FindBy(how = How.XPATH, using = "//select[@id='project_address_attributes_country']")
	private WebElement countryDropdown;
	@FindBy(how = How.XPATH, using = "//input[@id='project_address_attributes_zip']")
	private WebElement zipInputField;
	@FindBy(how = How.XPATH, using = "//input[@type='submit']")
	private WebElement saveButton;
	@FindBy(how = How.XPATH, using = "//a[text()='All Projects']")
	private WebElement allProjectsLink;
	@FindBy(how = How.CSS, using = "div.datepicker-days > table > tbody > tr > td.active.day")
	private WebElement selectToday;

	public void enterProjectName(String project) throws InterruptedException {

		projectNameSpan.click();
		projectNameInputField.sendKeys(project);
		Thread.sleep(2000);
		projectNameInputField.sendKeys(Keys.ENTER);
	}

	public void enterDeveloperName(String project) throws InterruptedException {
		developerSpan.click();
		developerInputField.sendKeys(project);
		Thread.sleep(2000);
		developerInputField.sendKeys(Keys.ENTER);
	}

	public void enterDescription(String des) {
		descriptionTextArea.sendKeys(des);
	}

	public void selectSales() throws InterruptedException {
		salesSpan.click();
		List<WebElement> list = sales_All;
		for (WebElement ele : list) {
			System.out.println("Values " + ele.getAttribute("innerHTML"));
			if (ele.getAttribute("innerHTML").contains("Tanmay Ghawate")) {
				Thread.sleep(1000);
				ele.click();
				System.out.println("Clicked on Tanmay Ghawate");
				break;
			}
		}
	}

	public void selectPresales() throws InterruptedException {
		presalesSpan.click();
		List<WebElement> list = presales_All;
		for (WebElement ele : list) {
			System.out.println("Values " + ele.getAttribute("innerHTML"));
			if (ele.getAttribute("innerHTML").contains("Bhushan Authankar")) {
				Thread.sleep(1000);
				ele.click();
				System.out.println("Clicked on Bhushan Authankar");
				break;
			}
		}
	}

	public void selectPostsales() throws InterruptedException {
		postsalesSpan.click();
		List<WebElement> list = postsales_All;
		for (WebElement ele : list) {
			System.out.println("Values " + ele.getAttribute("innerHTML"));
			if (ele.getAttribute("innerHTML").contains("Srinath Post Sales")) {
				Thread.sleep(1000);
				ele.click();
				System.out.println("Clicked on Srinath Post Sales");
				break;
			}
		}
	}

	public void selectPossessionDate() throws Exception {
		Thread.sleep(3000);
		possession.click();
		selectToday.click();
	}

	public void selectProjectType() throws InterruptedException {
		projectTypeSpan.click();
		List<WebElement> list = projectType_All;
		for (WebElement ele : list) {
			System.out.println("Values " + ele.getAttribute("innerHTML"));
			if (ele.getAttribute("innerHTML").contains("apartments")) {
				Thread.sleep(1000);
				ele.click();
				System.out.println("Clicked on apartments");
				break;
			}
		}
	}

	public void enterLocality(String loc) {
		localityInputField.sendKeys(loc);
	}

	public void enterLatitude(String lat) {
		latitudeInptField.sendKeys(lat);
	}

	public void enterLongitude(String lon) {
		longitudeInputField.sendKeys(lon);
	}

	public void enterAddress(String address) {
		addressInputField.sendKeys(address);
	}

	public void enterStreet(String street) {
		streetInputField.sendKeys(street);
	}

	public void enterCity(String city) {
		cityInputField.sendKeys(city);
	}

	public void selectState(String state) {
		selectByVisibleText(stateDropdown, state);
	}

	public void selectCountry(String country) {
		selectByVisibleText(countryDropdown, country);
	}

	public void enterZip(String zp) {
		zipInputField.sendKeys(zp);
	}

	public void clickOnSaveButton() {
		saveButton.click();
	}

	public void clickOnAllProjectsLink() {
		allProjectsLink.click();
	}
}
