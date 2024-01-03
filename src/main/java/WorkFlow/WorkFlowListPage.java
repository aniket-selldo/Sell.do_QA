package WorkFlow;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.selldo.Utility.ReusableUtils;

public class WorkFlowListPage extends ReusableUtils {
	public WebDriver driver;
	int rowNumOfWorkFlows = 0;

	public WorkFlowListPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Filter
	@FindBy(how = How.CSS, using = "button[class='btn btn-light btn-icon toggle-filters']")
	private WebElement clickOnFilter;
	@FindBy(how = How.XPATH, using = "//a[text()='Clear All']")
	private WebElement clickOnClearAll;
	@FindBy(how = How.XPATH, using = "//input[@class='btn btn-primary btn-sm']")
	private WebElement clickOnApply;
	@FindBy(how = How.CSS, using = "#s2id_search_params_is_active")
	private WebElement ClickOnSelectWFStatus;
	@FindBy(how = How.XPATH, using = "//div[@class='select2-result-label']")
	private List<WebElement> SelectWFStatus;
	@FindBy(how = How.XPATH, using = "//div[@class='dropdown-menu dropdown-menu-right show'] //button")
	private WebElement clickOnActivateButton;
	@FindBy(how = How.CSS, using = "#search_params_name")
	private WebElement SearchWorkFlow;
	// Actions
	@FindBy(how = How.XPATH, using = "//a[@id='btn-drip-actions']")
	private List<WebElement> clickOnActionButton;
	@FindBy(how = How.XPATH, using = "//a[@title='Details']")
	private List<WebElement> clickOnActionButton_Details;
	@FindBy(how = How.XPATH, using = "//a[@title='Edit']")
	private List<WebElement> clickOnActionButton_Edit;
	@FindBy(how = How.XPATH, using = "//button[@class='dropdown-item toggle_active text-success']")
	private List<WebElement> clickOnActionButton_Active;
	@FindBy(how = How.XPATH, using = "//button[@class='dropdown-item toggle_active text-danger']")
	private List<WebElement> clickOnActionButton_Inactive;
	// Pick Random WF Name from list
	@FindBy(how = How.XPATH, using = "//table[@class='table table-responsive']//td[1]")
	private List<WebElement> WorkflowList;

	public void clearFilter() {
		waitUntilClickable(clickOnFilter).click();
		waitUntilClickable(clickOnClearAll).click();
	}

	public void Activate_OR_Deactivate_WorkFlow(String str) {
		waitUntilClickable(
				driver.findElement(By.xpath("//td[text()='" + str + "']/parent::tr//a[@id='btn-drip-actions']")))
				.click();
		waitUntilClickable(clickOnActivateButton).click();
	}

	public void displayAllActiveWF() {
		waitUntilClickable(clickOnFilter).click();
		waitUntilVisiblity(SearchWorkFlow).clear();
		waitUntilClickable(ClickOnSelectWFStatus).click();
		waitUntilClickable(SelectWFStatus.stream().filter(S -> S.getText().startsWith("Active")).findFirst().get())
				.click();
		scrollIntoViewUp(clickOnApply);
		waitUntilClickable(clickOnApply).click();
	}

	public void displayAllInactiveWF() {
		jsClick(clickOnFilter);
		waitUntilVisiblity(SearchWorkFlow).clear();
		(ClickOnSelectWFStatus).click();;
		(SelectWFStatus.stream().filter(S -> S.getText().startsWith("Inactive")).findFirst().get()).click();
		scrollIntoViewUp(clickOnApply);
		jsClick(clickOnApply);
	}

	// Search Workflow
	public void SearchWorkFlow(String str) {
		waitUntilClickable(clickOnFilter).click();
		waitUntilVisiblity(SearchWorkFlow).sendKeys(str);
		waitUntilClickable(clickOnApply).click();
	}

	// Actions without String
	public void Details_Action_WorkFlow() {
		waitUntilClickable(clickOnActionButton.get(rowNumOfWorkFlows)).click();
		jsClick(clickOnActionButton_Details.get(rowNumOfWorkFlows));
	}

	public void Edit_Action_WorkFlow() {
		waitUntilClickable(clickOnActionButton.get(rowNumOfWorkFlows)).click();
		jsClick(clickOnActionButton_Edit.get(rowNumOfWorkFlows));

	}

	public void Activate_Action_WorkFlow() {
		waitUntilClickable(clickOnActionButton.get(rowNumOfWorkFlows)).click();
		jsClick(clickOnActionButton_Active.get(rowNumOfWorkFlows));
		getSuccessMSG();

	}

	public void Deactivate_Action_WorkFlow() {
		waitUntilClickable(clickOnActionButton.get(rowNumOfWorkFlows)).click();
		jsClick(clickOnActionButton_Inactive.get(rowNumOfWorkFlows));

	}

	// Actions With String
	public void Details_Action_WorkFlow(String str) {
		waitUntilVisiblity(driver
				.findElement(By.xpath("(//td[text()='" + str.trim() + "'])[1]/parent::tr//a[@id='btn-drip-actions']")))
				.click();
		waitUntilClickable(clickOnActionButton_Details.get(rowNumOfWorkFlows)).click();
	}

	public void Edit_Action_WorkFlow(String str) {
		waitUntilVisiblity(driver
				.findElement(By.xpath("(//td[text()='" + str.trim() + "'])[1]/parent::tr//a[@id='btn-drip-actions']")))
				.click();
		waitUntilClickable(clickOnActionButton_Edit.get(rowNumOfWorkFlows)).click();

	}

	public void Activate_Action_WorkFlow(String str) {
		waitUntilVisiblity(driver
				.findElement(By.xpath("(//td[text()='" + str.trim() + "'])[1]/parent::tr//a[@id='btn-drip-actions']")))
				.click();
		waitUntilClickable(clickOnActionButton_Active.get(rowNumOfWorkFlows)).click();
		String strs = getSuccessMSG();
		Assert.assertEquals(strs, "Workflow activated");

	}

	public void Deactivate_Action_WorkFlow(String str) {
		waitUntilVisiblity(driver
				.findElement(By.xpath("(//td[text()='" + str.trim() + "'])[1]/parent::tr//a[@id='btn-drip-actions']")))
				.click();
		waitUntilClickable(clickOnActionButton_Inactive.get(rowNumOfWorkFlows)).click();
		String strs = getSuccessMSG();
		Assert.assertEquals(strs, "Workflow deactivated");
	}

	// Status Validateion
	public String WorkFlowStatus(String str) {
		return waitUntilVisiblity(
				driver.findElement(By.xpath("(//td[text()='" + str.trim() + "'])[1]/following-sibling::td[3]")))
				.getText();
	}

	// Pick Any random Workflow Name
	public String RandomWorkflowNameFromList() {
		int val = getRandomNumber(0, waitUntilVisibilityOfElements(WorkflowList).size());
		//this.rowNumOfWorkFlows=val;
		return waitUntilVisiblity(WorkflowList.get(val)).getText().trim();
	}
	public String FirstWorkflowNameFromList() {
		//this.rowNumOfWorkFlows=val;
		return waitUntilVisiblity(WorkflowList.get(0)).getText().trim();
	}
}
