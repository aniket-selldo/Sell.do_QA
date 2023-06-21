package WorkFlow;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selldo.Utility.ReusableUtils;

import Enums.WFEvent;

public class WorkFlowPage extends ReusableUtils {
	public WebDriver driver;

	public WorkFlowPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// ===========go into WF=================
	@FindBy(how = How.CSS, using = "#main-menu-automation")
	private WebElement clickOnAutomation;
	@FindBy(how = How.XPATH, using = "//a[@ubts='Workflows']")
	private WebElement clickOnWorkFlow;
	@FindBy(how = How.LINK_TEXT, using = "New Workflow")
	private WebElement clickOnNewWorkFlow;
	@FindBy(how = How.LINK_TEXT, using = "New Workflow Group")
	private WebElement clickOnNewWorkFlowGroup;

	// =============Choose templete in WF========
	@FindBy(how = How.CSS, using = "[placeholder='Workflow title']")
	private WebElement enterWFTitle;
	@FindBy(how = How.CSS, using = "[placeholder='Add a description']")
	private WebElement enterWFDescription;
	@FindBy(how = How.LINK_TEXT, using = "New Workflow Group")
	private WebElement clickOnAddWFGroup;
	@FindBy(how = How.CSS, using = "#select2-drop input")
	private WebElement enterGrupWF;
	@FindBy(how = How.LINK_TEXT, using = "Get Started")
	private WebElement clickOnGetStart;
	@FindBy(how = How.CSS, using = "[placeholder='Search for an event']")
	private WebElement enterTampleteNameForSearch;
	@FindBy(how = How.XPATH, using = "//button[text()='Choose']")
	private WebElement clickOnChooseButton;
	@FindBy(how = How.XPATH, using = "//h3[text()='Add a condition']")
	private WebElement addCondition;
	@FindBy(how = How.XPATH, using = "//h3[text()='Add actions']")
	private WebElement addAction;
	@FindBy(how = How.XPATH, using = "//h3[text()='If the condition succeeds']")
	private WebElement succeedsCondition;
	@FindBy(how = How.XPATH, using = "//h3[text()='If the condition fails']")
	private WebElement failConition;
	@FindBy(how = How.XPATH, using = "//label[@class='form-check-label']")
	private List<WebElement> selectMatchAnyMatchAll;
	@FindBy(how = How.CSS, using = "button[class='btn btn-primary mt10 add-action-btn']")
	private WebElement clickOnAddActionButton;
	@FindBy(how = How.XPATH, using = "//span[text()='Select action']")
	private WebElement clickOnSelectionAction;
	@FindBy(how = How.CSS, using = "#select2-drop input")
	private WebElement enterAction;
	@FindBy(how = How.CSS, using = ".select2-result-sub li[class='select2-results-dept-1 select2-result select2-result-selectable select2-highlighted']")
	private WebElement ClickOnSelection;
	@FindBy(how = How.CSS, using = ".form-control.data.string_val")
	private WebElement enterValue;
	@FindBy(how = How.XPATH, using = "//button[text()='Save all']")
	private WebElement clickOnSaveAllButton;
	// ========== Add Condition================
	@FindBy(how = How.CSS, using = ".select2-container.form-control.predicate")
	private WebElement clickOnSelectCondition;
	@FindBy(how = How.CSS, using = ".select2-result-sub li")
	private List<WebElement> selectCondition;
	@FindBy(how = How.CSS, using = "#select2-drop input")
	private WebElement enterCondition;

	public void goToWF() {
		waitUntilClickable(clickOnAutomation).click();
		waitUntilClickable(clickOnWorkFlow).click();
	}

	public void clickOnNewWF() {
		waitUntilClickable(clickOnNewWorkFlow).click();
	}
	public void clickOnSaveAllButton() {
		wait(1000);
		waitUntilClickable(clickOnSaveAllButton).click();
	}
	public void clickOnAddActionButton() {
		waitUntilClickable(clickOnAddActionButton).click();
	}
	public void enterValue(String str) {
		waitUntilVisiblity(enterValue).sendKeys(str);
	}
	public void enterAction(String str) {
		waitUntilClickable(clickOnSelectionAction).click();
		waitUntilVisiblity(enterAction).sendKeys(str);
		waitUntilVisiblity(ClickOnSelection).click();
		
	}
	public void fillWFForm(String title, String Description) {
		waitUntilVisiblity(enterWFTitle).sendKeys(title);
		waitUntilVisiblity(enterWFDescription).sendKeys(Description);

	}

	public void clickOnGetStart() {
		waitUntilClickable(clickOnGetStart).click();
	}

	public void selectTamplete(WFEvent we) {
		enterTampleteNameForSearch.sendKeys(we.toString().split(" ")[0]);
		wait(1000);
		waitUntilClickable(driver.findElement(By.xpath("(//button[text()='Choose'])[" + we.toInt() + "]"))).click();
	}
	public void selectTamplete(String we) {
		enterTampleteNameForSearch.sendKeys(we.split(" ")[0]);
		wait(1000);
		waitUntilClickable(driver.findElement(By.xpath("(//button[text()='Choose'])[" + we + "]"))).click();
	}
	public void clickOnAddCondition() {
		waitUntilClickable(addCondition).click();
	}

	public void clickOnAddAction() {
		waitUntilClickable(addAction).click();
	}

	public void clickOnSuceessCondition() {
		jsClick(succeedsCondition);
	}

	public void clickOnFailCondition() {
		waitUntilClickable(failConition).click();
	}

	public void selectMatchAnyMatchAll(int choise) {
		waitUntilClickable(selectMatchAnyMatchAll.get(choise)).click();
	}

	public void selectCondition(String str) {
		waitUntilClickable(clickOnSelectCondition).click();
		waitUntilVisiblity(enterCondition).sendKeys(str);
	}

}
