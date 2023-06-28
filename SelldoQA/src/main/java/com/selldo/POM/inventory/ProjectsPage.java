package com.selldo.POM.inventory;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selldo.Utility.ReusableUtils;

public class ProjectsPage extends ReusableUtils {

	public WebDriver driver;

	public ProjectsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//a[text()='New Project']")
	private WebElement newProjectButton;
	@FindBy(how = How.XPATH, using = "//th[text()='Actions']/following::a[1]")
	private WebElement actionBar;
	@FindBy(how = How.XPATH, using = "//th[text()='Actions']/following::a[text()='Edit'][1]")
	private WebElement editLink;
	@FindBy(how = How.CSS, using = "i.ion-funnel")
	private WebElement funnelIcon;
	@FindBy(how = How.XPATH, using = "//label[text()='Project']/following::span[1]")
	private WebElement projectSpan;
	@FindBy(how = How.XPATH, using = "//*[@id='select2-drop']//div//input")
	private WebElement projectInputField;
	@FindBy(how = How.XPATH, using = "//span[text()='Select a Developer']")
	private WebElement developerSpan;
	@FindBy(how = How.XPATH, using = "//*[@id='select2-drop']//div//input")
	private WebElement developerInputField;
	@FindBy(how = How.XPATH, using = "//span[text()='Construction Status']")
	private WebElement constructionStatus;
	@FindBy(how = How.XPATH, using = "//*[@id='select2-drop']//div//input")
	private WebElement constructionStatusTextField;
	@FindBy(how = How.XPATH, using = "//span[text()='Project Type']")
	private WebElement typeSpan;
	@FindBy(how = How.XPATH, using = "//ul[@class='select2-results']//li")
	private WebElement type_All;
	@FindBy(how = How.XPATH, using = "//label[text()='Status']/following::span[1]")
	private WebElement status;
	@FindBy(how = How.XPATH, using = "//ul[@class='select2-results']//li")
	private WebElement status_All;
	@FindBy(how = How.XPATH, using = "//a[text()='Filter']")
	private WebElement filterButton;
	@FindBy(how = How.XPATH, using = "//a[text()='Clear All']")
	private WebElement clearAllLink;
	@FindBy(how = How.XPATH, using = "//input[@value='Apply']/preceding::i[@class='ion-android-close'][1]")
	private WebElement crossIcon;
	@FindBy(how = How.XPATH, using = "//table[@class='table table-responsive']/tbody/tr/td[1]")
	private List<WebElement> getAllDevloperName;

	public String  getAnyProjectName() {
		return getAllDevloperName.stream().findAny().get().getText();
	}

	public void clickOnNewProjectButton() {
		waitUntilClickable(newProjectButton).click();
	}

	public void clickOnFunnelIcon() {
		waitUntilClickable(funnelIcon).click();
	}

	public void enterProjectName(String pro) throws InterruptedException {
		waitUntilClickable(projectSpan).click();
		waitUntilVisiblity(projectInputField).sendKeys(pro);
		Thread.sleep(2000);
		waitUntilVisiblity(projectInputField).sendKeys(Keys.ENTER);
	}

	public void clickOnFilterButton() {
		waitUntilClickable(filterButton).click();
	}

	public void clickOnClearAllLink() {
		waitUntilClickable(clearAllLink).click();
	}

	public void clickOnCrossIcon() {
		waitUntilClickable(crossIcon).click();
	}

}
