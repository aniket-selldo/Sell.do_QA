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
	@FindBy(how = How.CSS, using = "#select2-drop li[class='select2-results-dept-0 select2-result select2-result-selectable']")
	private List<WebElement> sales_All;
	@FindBy(how = How.XPATH, using = "//label[text()='Pre Sales']/following::input[1]")
	private WebElement presalesSpan;
	@FindBy(how = How.CSS, using = "#select2-drop li[class='select2-results-dept-0 select2-result select2-result-selectable']")
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
	@FindBy(how = How.LINK_TEXT, using = "Projects")
	private WebElement Project;
	@FindBy(how = How.CSS, using = "i.ion-cube")
	private WebElement element;
	@FindBy(how = How.CSS, using = "label[class='lead']")
	private WebElement getProjectName;
	
	public String getProjectName() {
		return waitUntilVisiblity(getProjectName).getText().trim();
	}

	public void clickOnProject() {
		waitUntilVisiblity(element);
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		waitUntilClickable(Project).click();
	}

	public void enterProjectName(String project) throws InterruptedException {

		waitUntilClickable(projectNameSpan).click();
		waitUntilVisiblity(projectNameInputField).sendKeys(project);
		waitUntilVisiblity(projectNameInputField).sendKeys(Keys.ENTER);
	}

	public void enterDeveloperName(String project) throws InterruptedException {
		waitUntilClickable(developerSpan).click();
		waitUntilVisiblity(developerInputField).sendKeys(project);
		waitUntilVisiblity(developerInputField).sendKeys(Keys.ENTER);
	}

	public void enterDescription(String des) {
		waitUntilVisiblity(descriptionTextArea).sendKeys(des);
	}

	public void selectSales() throws InterruptedException {
		waitUntilClickable(salesSpan).click();
		waitUntilClickable(sales_All.get(0)).click();		
	}

	public void selectPresales() throws InterruptedException {
		waitUntilClickable(presalesSpan).click();
		waitUntilClickable(presales_All.get(0)).click();	
	}

	public void selectPostsales() throws InterruptedException {
		waitUntilClickable(postsalesSpan).click();
		List<WebElement> list = postsales_All;
		for (WebElement ele : list) {
			System.out.println("Values " + ele.getAttribute("innerHTML"));
			if (ele.getAttribute("innerHTML").contains("Srinath Post Sales")) {
				Thread.sleep(1000);
				waitUntilClickable(ele).click();
				System.out.println("Clicked on Srinath Post Sales");
				break;
			}
		}
	}

	public void selectPossessionDate() throws Exception {
		scrollIntoView(salesSpan);
		waitUntilClickable(possession).click();
		waitUntilClickable(selectToday).click();
	}

	public void selectProjectType() throws InterruptedException {
		waitUntilClickable(projectTypeSpan).click();
		jsClick(projectType_All.get(0));
		projectType_All.get(0).click();
	}
	

	public void enterLocality(String loc) {
		waitUntilVisiblity(localityInputField).sendKeys(loc);
	}

	public void enterLatitude(String lat) {
		waitUntilVisiblity(latitudeInptField).sendKeys(lat);
	}

	public void enterLongitude(String lon) {
		waitUntilVisiblity(longitudeInputField).sendKeys(lon);
	}

	public void enterAddress(String address) {
		waitUntilVisiblity(addressInputField).sendKeys(address);
	}

	public void enterStreet(String street) {
		waitUntilVisiblity(streetInputField).sendKeys(street);
	}

	public void enterCity(String city) {
		waitUntilVisiblity(cityInputField).sendKeys(city);
	}

	public void selectState(String state) {
		selectByVisibleText(stateDropdown, state);
	}

	public void selectCountry(String country) {
		selectByVisibleText(countryDropdown, country);
	}

	public void enterZip(String zp) {
		waitUntilVisiblity(zipInputField).sendKeys(zp);
	}

	public void clickOnSaveButton() {
		waitUntilClickable(saveButton).click();
	}

	public void clickOnAllProjectsLink() {
		waitUntilClickable(allProjectsLink).click();
	}
}
