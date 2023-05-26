package com.selldo.POM.crm;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.selldo.Utility.ReusableUtils;

public class SalesPresalesDashboardPage extends ReusableUtils {

	public WebDriver driver;

	public SalesPresalesDashboardPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
//
	@FindBy(how = How.CSS, using = "i.ion-ios-people")
	private WebElement leadsIcon;
	@FindBy(how = How.XPATH, using = "//a[normalize-space()='All Leads']")
	private WebElement allLeadsLink;
	@FindBy(how = How.CSS, using = "i.ion-cube")
	private WebElement inventoryCubeIcon;
	@FindBy(how = How.XPATH, using = "//button[text()='Save As']")
	private WebElement saveAsButton;
	@FindBy(how = How.CSS, using = "#s2id_autogen2 > a > span.select2-chosen")
	private WebElement listField;
	@FindBy(how = How.CSS, using = "#select2-drop > div > input")
	private WebElement listSearch;
	@FindBy(how = How.XPATH, using = "//button[@class='btn dropdown-toggle btn-sm btn-outline-primary']")
	private WebElement stageDropdown;
	@FindBy(how = How.XPATH, using = "//div[@class='dropdown-menu type show']")
	private List<WebElement> stageDropdown_All;
	@FindBy(how = How.CSS, using = "#save_stage_and_status_lead_profile")
	private WebElement saveButton;
	@FindBy(how = How.XPATH, using = "//i[@class='fa fa-ellipsis-v']")
	private WebElement actionBar_Lead1;
	@FindBy(how = How.CSS, using = "#leads-container > tbody > tr:nth-child(2) > td.text-right > div > a")
	private WebElement actionBar_Lead2;
	@FindBy(how = How.XPATH, using = "//a[contains(@class,'tab')]")
	private List<WebElement> actionBar;
	@FindBy(how = How.XPATH, using = "//button[text()='Preview']")
	private WebElement preview;
	@FindBy(how = How.XPATH, using = "//button[text()='View Profile']")
	private WebElement viewProfileButton;
	@FindBy(how = How.CSS, using = "div.dropdown-menu.dropdown-menu-right.show button.dropdown-item.goto_details")
	private WebElement details;
	@FindBy(how = How.XPATH, using = "//span[text()='Search...']")
	public WebElement searchField;
	@FindBy(how = How.XPATH, using = "//div[@id='new-enquires']//div[@class='tile-item-body text-success']")
	private WebElement newEnquiryBucket;
	@FindBy(how = How.XPATH, using = "//div[@id='reengaged-leads']//div[@class='tile-item-body text-success']")
	private WebElement reengagedLeadsBucket;
	@FindBy(how = How.XPATH, using = "//div[@id='missed-calls']//div[@class='tile-item-body text-danger']")
	private WebElement missedCallsBucket;
	@FindBy(how = How.XPATH, using = "//div[@id='nfa-leads']//div[@class='tile-item-body text-danger']")
	private WebElement nFABucket;
	@FindBy(how = How.CSS, using = "i#user-account-icon")
	private WebElement userAccountIcon;
	@FindBy(how = How.CSS, using = "span.status")
	private WebElement availableLink;
	@FindBy(how = How.XPATH, using = "//a[text()='Edit Profile']")
	private WebElement editProfile;
	@FindBy(how = How.XPATH, using = "//h5[text()='Edit User']/following::i[1]")
	private WebElement crossIcon_EditProfile;
	@FindBy(how = How.XPATH, using = "//input[@value='Save']")
	private WebElement saveButton_EditProfile;
	@FindBy(how = How.CSS, using = "div.dropdown-menu.dropdown-menu-right.call-center-availability-dropdown.show a:nth-child(2)")
	private WebElement markOnBreak;
	@FindBy(how = How.CSS, using = "span.status")
	private WebElement onBreakLink;
	@FindBy(how = How.CSS, using = "div.dropdown-menu.dropdown-menu-right.call-center-availability-dropdown.show a:nth-child(1)")
	private WebElement markOnlineLink;
	@FindBy(how = How.CSS, using = "#select2-drop > div > input")
	private WebElement searchTextBox;
	@FindBy(how = How.CSS, using = "i.ion-refresh.refresh-sales-dashboard")
	private WebElement refreshIcon;
	@FindBy(how = How.XPATH, using = "//span[text()='missed Followups']/following::div[1]")
	private WebElement missedFollowups;
	@FindBy(how = How.XPATH, using = "//a[@href='#open_tasks']")
	private WebElement openTasksLink;
	@FindBy(how = How.XPATH, using = "//span[text()='missed Site visits']/following::div[1]")
	private WebElement missedSiteVisits;
	@FindBy(how = How.CSS, using = "#dropdownMenuButton")
	private WebElement filterIcon;
	@FindBy(how = How.CSS, using = "div.dropdown-menu.dropdown-menu-right.show a:nth-child(2)")
	private WebElement siteVisitFilter;
	@FindBy(how = How.CSS, using = "div.dropdown-menu.dropdown-menu-right.show a:nth-child(3)")
	private WebElement followupFilter;
	@FindBy(how = How.CSS, using = "div[class='select2-container form-control select2 clean-select2 lead-list']")
	private WebElement clickOnList;
	@FindBy(how = How.CSS, using = "li[class='select2-results-dept-0 select2-result select2-result-selectable']")
	private List<WebElement> SelectSearchList;
	@FindBy(how = How.CSS, using = "#todays-performance-label > div.card-body > div.row.pt-2 > div > div > div:nth-child(5) > div.tile-item-body > span")
	private WebElement getPushToSalesCount;
	@FindBy(how = How.CSS, using = "span[name='lead_id']")
	private WebElement getLeadId;
	@FindBy(how = How.LINK_TEXT, using = "Add Project")
	private WebElement ClickOnAddProject;
	@FindBy(how = How.CSS, using = "#s2id_btn-add-interested-project")
	private WebElement ClickOnAddProjectSearchFiled;
	@FindBy(how = How.CSS, using = "li[class='select2-results-dept-0 select2-result select2-result-selectable']")
	private List<WebElement> SelectProject;
	@FindBy(how = How.CSS, using = "#add_interested_property_lead_profile")
	private WebElement ClickOnAddProjectButton;
	@FindBy(how = How.CSS, using = "div.dropdown.stage.float-left.mr-1 button span[data-title='label']")
	private WebElement getCurretLeadStatus;
	
	
	public String getCurretLeadStatus() {
		return waitUntilVisiblity(getCurretLeadStatus).getText().trim().toLowerCase();
	}
	public void addProjectOnLead() {
		scrollIntoView(ClickOnAddProject);
		waitUntilClickable(ClickOnAddProject).click();
		waitUntilClickable(ClickOnAddProjectSearchFiled).click();
		waitUntilClickable(SelectProject.get(0)).click();
		waitUntilClickable(ClickOnAddProjectButton).click();
	}
	public String getLeadId() {
		return waitUntilVisiblity(getLeadId).getText().trim();
	}
	
	// To Search Lead
	public void searchLead(String lead) throws InterruptedException {
		waitUntilClickable(searchField).click();
		waitUntilVisiblity(searchTextBox);
		WebElement webElement = searchTextBox;
		webElement.sendKeys(lead);
		Thread.sleep(1000);
		webElement.sendKeys(Keys.ENTER);// Clicking enter
	}
	
	public int getPushToSalesCount() {
		return Integer.parseInt(waitUntilVisiblity(getPushToSalesCount).getText().trim());
	}

	public String onBreakLinkText() {

		return waitUntilVisiblity(onBreakLink).getText().trim();
	}

	public String availableLinkText() {

		return waitUntilVisiblity(availableLink).getText().trim();
	}

	public void clickOnSaveAsButton() {
		waitUntilClickable(saveAsButton).click();
	}

	// To Select values from Lead Management Drop down
	public void selectLeadActions(int value) throws Exception {

		moveToElement(leadsIcon);
		waitUntilClickable(driver.findElement(By.cssSelector(
				"body > div.main-nav-container > div.sub-navigation-bar > div:nth-child(1) > div:nth-child(" + value
						+ ") > a")))
				.click();
	}

	public void goToAllLeadsList() {

		moveToElement(leadsIcon);
		waitUntilClickable(allLeadsLink).click();
		;
	}

	public void openLeadProfile(int any) {
		waitUntilClickable(actionBar.get(any)).click();
		waitUntilClickable(preview).click();
		waitUntilClickable(viewProfileButton).click();
	}

	public void openLeadDetails(int any) {
		wait(1000);
		waitUntilClickable(actionBar.get(any)).click();
		waitUntilClickable(details).click();

	}

	public void openLeadDetails2() throws Exception {
		waitUntilClickable(actionBar_Lead2).click();
		waitUntilClickable(details).click();

	}

	public void refreshDashboardStats() {
		waitUntilClickable(refreshIcon).click();
		wait(3000);
		try {
			jsClick(refreshIcon);
			wait(3000);
		} catch (Exception e) {
		}
		
	}

	public void clickOnnewEnquiryBucket() {
		waitUntilClickable(newEnquiryBucket).click();
	}

	public void clickOnReengagedLeadsBucket() {
		waitUntilClickable(reengagedLeadsBucket).click();
	}

	public void clickOnMissedCallsBucket() {
		waitUntilClickable(missedCallsBucket).click();
	}

	public void clickOnNFAbucket() {
		waitUntilClickable(nFABucket).click();
	}

	public void selectMarkOnBreak() {
		waitUntilClickable(availableLink).click();
		waitUntilClickable(markOnBreak).click();
	}

	public void validatingOnBreakLink() {
		System.out.println("Started verification");
		String expected = "You are on break";
		Assert.assertTrue(onBreakLinkText().contains(expected), "Not matched");
		System.out.println("Completed verification");
	}

	public void validatingOnBreakStatus() {
		System.out.println("Started verification");
		String expected = "You are on break";
		Assert.assertTrue(onBreakLinkText().contains(expected), "Not matched");
		System.out.println("Completed verification");
	}

	public void validatingAvailableLink() {
		System.out.println("Started verification");
		String expected = "Available";
		Assert.assertTrue(availableLinkText().contains(expected), "Not matched");
		System.out.println("Completed verification");
	}

	// Clicking on Mark Online Link
	public void availableForCall() {
		waitUntilClickable(onBreakLink).click();
		wait(2000);
		waitUntilClickable(markOnlineLink).click();
	}

	public void SelectList(String reassign) throws Exception {
		waitUntilClickable(listField).click();
		waitUntilVisiblity(listSearch).sendKeys(reassign);
		(listSearch).sendKeys(Keys.ENTER);
	}

	public void SelectList01(String reassign) throws Exception {
		waitUntilClickable(clickOnList).click();
		for (WebElement webElement : SelectSearchList) {
			if (webElement.getText().trim().equalsIgnoreCase(reassign)) {
				waitUntilClickable(webElement).click();
				break;
			}
		}
	}

	public void changing_BookedToProspect() throws InterruptedException {
		waitUntilClickable(stageDropdown).click();

		List<WebElement> list = stageDropdown_All;
		for (WebElement ele : list) {
			if (ele.getAttribute("innerHTML").contains("Prospect")) {
				waitUntilClickable(ele).click();
				break;
			}
		}
		waitUntilClickable(saveButton).click();
	}

	public void editUserProfile() {
		waitUntilClickable(userAccountIcon).click();
		waitUntilClickable(editProfile).click();
	}

	public void closeEditProfile() {
		waitUntilClickable(saveButton_EditProfile).click();
	}

	public void clickOnMissedSitevisitBucket() {
		waitUntilClickable(openTasksLink).click();
		waitUntilClickable(missedSiteVisits).click();

	}

	public void clickOnMissedFollowupBucket() {
		waitUntilClickable(openTasksLink).click();
		waitUntilClickable(missedFollowups).click();
	}

	public void applySitevisitFilter() {
		waitUntilClickable(filterIcon).click();
		waitUntilClickable(siteVisitFilter).click();
	}

	public void applyFollowupFilter() {
		waitUntilClickable(filterIcon).click();
		waitUntilClickable(followupFilter).click();
	}

	public void pageRefresh() {
		wait(1000);
		driver.navigate().refresh();
	}

}
