package com.selldo.POM.crm;

import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.Utility.ReusableUtils;

public class LeadProfilePage extends ReusableUtils {
	public WebDriver driver;

	public LeadProfilePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.CSS, using = "#add_note_navigation_lead_profile")
	private WebElement addANote;
	@FindBy(how = How.XPATH, using = "//textarea[@name='content']")
	private WebElement addNote_Textarea;
	@FindBy(how = How.XPATH, using = "//button[text()='Save Note']")
	private WebElement saveNoteButton;
	@FindBy(how = How.CSS, using = "span[name='lead_id']")
	private WebElement leadid;
	@FindBy(how = How.ID, using = "call-dropdown")
	private WebElement call;
	@FindBy(how = How.XPATH, using = "//a[contains(@id,'email-dropdown')]")
	private WebElement email;
	@FindBy(how = How.CSS, using = "#compose_email_lead_profile")
	private WebElement ComposeEmail;
	@FindBy(how = How.CSS, using = "[id$='sms_lead_profile']")
	private WebElement SMS;
	@FindBy(how = How.XPATH, using = "//i[@class='ion-android-calendar mr-2']")
	private WebElement meeting;
	@FindBy(how = How.ID, using = "activity_tabs_more_lead_profile")
	private WebElement more;// change
	@FindBy(how = How.CSS, using = "#lead_reassign_lead_profile")
	private WebElement reassign;
	@FindBy(how = How.XPATH, using = "//a[@class='nav-link lead-schedule-followup']")
	private WebElement followup;
	@FindBy(how = How.CSS, using = "a[title='Push to sales']")
	private WebElement push;
	@FindBy(how = How.CSS, using = ".nav-link.active.lead_pull_to_sales")
	private WebElement pull;
	@FindBy(how = How.CSS, using = "#lead_booking_forms_lead_profile")
	private WebElement bookings;
	@FindBy(how = How.ID, using = "lead_site_visit_lead_profile")
	private WebElement conductedSiteVisit;
	@FindBy(how = How.CSS, using = "#lead_schedule_site_visit_lead_profile")
	private WebElement siteVisit;
	@FindBy(how = How.CSS, using = "#lead_merge_lead_profile")
	private WebElement mergeLeads;
	@FindBy(how = How.CSS, using = "#offline_call_form_lead_profile")
	private WebElement logOflineCall;
	@FindBy(how = How.XPATH, using = "//a[text()='Activity'][@href='#tab-activity']")
	private WebElement activityTab;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Feed')][@id='Feed_lead_profile']")
	private WebElement feedTab;
	@FindBy(how = How.CSS, using = "[class='activities_list'] [class='float-right']")
	private List<WebElement> actionBar_Sitevisit;
	@FindBy(how = How.CSS, using = "ul.dropdown-menu.dropdown-menu-right.show li a")
	private List<WebElement> actionBar_Options;
	@FindBy(how = How.CSS, using = "#tab-activity > div.activities_list > div:nth-child(1) > div > div.card > div > div:nth-child(1) > div.col-lg-1 > div > div > a")
	private WebElement actionBar_Followup;
	@FindBy(how = How.CSS, using = "a.nav-link.lead-schedule-followup")
	public WebElement followupLink;
	@FindBy(how = How.CSS, using = "#user-account-icon")
	private WebElement userIcon;
	@FindBy(how = How.CSS, using = "[data-method=\"delete\"]")
	private WebElement logout;
	@FindBy(how = How.XPATH, using = "//a[text()='Back to admin']")
	private WebElement backToAdmin;
	@FindBy(how = How.XPATH, using = "//div[@class='timeline-item activity notes']//span[1]") // chanve
																								// //li[@class='nav-item
	private WebElement noteTExtInActivity;
	@FindBy(how = How.CSS, using = "div[class='col-sm-12 activity-responsive-tabs col-lg-5 pr-0'] #activity_tabs_more_lead_profile")
	// dropdown
	// responsive-tabs-dropdown
	// show']
	private WebElement more_d;
	@FindBy(how = How.CSS, using = "#SiteVisit_lead_profile")
	private WebElement sitevisit_d;
	@FindBy(how = How.XPATH, using = "//div[@class='col-lg-1']")
	private WebElement sitevisit_d_actionbar;
	@FindBy(how = How.XPATH, using = "//a[text()='Confirm']")
	private WebElement sitevisit_confirm;
	@FindBy(how = How.XPATH, using = "//span[text()='Campaign Responses']/preceding::a[text()='Send Brochure'][1]")
	private WebElement brochure;
	@FindBy(how = How.XPATH, using = "//a[text()='Send Quick Quote']")
	private WebElement sendQuickQuote;
	@FindBy(how = How.XPATH, using = "//i[@class='ion-edit ml-2']")
	private WebElement editIcon;
	@FindBy(how = How.XPATH, using = "//a[text()='Followups'][@href='#tab-activity']")
	private WebElement followup_d;
	@FindBy(how = How.CSS, using = "#tab-activity > div.activities_list > div:nth-child(1) > div > div.card > div > div:nth-child(1) > div.col-lg-1 > div > div > a")
	private WebElement followup_d_actionbar;
	@FindBy(how = How.XPATH, using = "//span[text()='Email']")
	private WebElement email_FollowupActivity;
	@FindBy(how = How.CSS, using = "#Email_lead_profile")
	private WebElement email_d;
	// By call_d =
	// @FindBy(how = How.XPATH, using
	// ="//*[@id=\"activity_container\"]/div/div[1]/div[1]/nav/li[3]/a") private
	// WebElement ;
	@FindBy(how = How.CSS, using = "#Call_lead_profile")
	private WebElement call_d;
	@FindBy(how = How.CSS, using = "[id^=Sm]")
	private WebElement sms_d;
	@FindBy(how = How.XPATH, using = "//span[text()='Sub filter']")
	private WebElement subfilter_Sitevisit;
	@FindBy(how = How.XPATH, using = "//ul[@class='dropdown-menu dropdown-menu-right type show']//li")
	private List<WebElement> subfilter_Sitevisit_All;
	@FindBy(how = How.XPATH, using = "//a[@class='nav-link'][@data-value='Email']")
	private WebElement email_Activity;
	@FindBy(how = How.CSS, using = "#tab-activity > div.activities_list > div:nth-child(1) > div > div.card > div > div:nth-child(3) > div:nth-child(2) > span")
	private WebElement emailStatusInFeed;

	// Stage
	@FindBy(how = How.XPATH, using = "//button[@class='btn dropdown-toggle btn-sm btn-outline-primary']")
	private WebElement stageDropdown;

	@FindBy(how = How.XPATH, using = "//a[@class='dropdown-item lead_stage']")
	private List<WebElement> stageDropdown_All;

	@FindBy(how = How.XPATH, using = "//a[text()='Save']")
	private WebElement saveButton;

	// Why was this customer Lost? popup appeared when stage changed to Lost
	@FindBy(how = How.XPATH, using = "//label[text()='Select reason']/following::select")
	private WebElement selectReasonDropdown;
	@FindBy(how = How.XPATH, using = "//button[text()='Save changes']")
	private WebElement saveChangesButton;

	// Add a Product
	@FindBy(how = How.XPATH, using = "//a[@id='add-product']")
	private WebElement addaProductButton;
	@FindBy(how = How.XPATH, using = "//div[@id='select2-drop']//li")
	private List<WebElement> addProjectsField;
	@FindBy(how = How.CSS, using = "#s2id_btn-add-interested-project") // div[@id='s2id_autogen10']//ul[@class='select2-choices']
	private WebElement addProjectsField1;
	@FindBy(how = How.XPATH, using = "//div[@id='s2id_autogen10']//ul[@class='select2-choices']")
	private WebElement addProjectsField2;
	// div[@id='s2id_autogen10']//input[@class='select2-input select2-default']

	@FindBy(how = How.CSS, using = "ul.select2-results li:nth-child(3)")
	private WebElement addfirstProject;
	@FindBy(how = How.CSS, using = "ul.select2-choices li:nth-child(1) div")
	private WebElement projectSelected;
	@FindBy(how = How.XPATH, using = "//button[text()='Add']")
	private WebElement addButton;

	@FindBy(how = How.XPATH, using = "//span[text()='Campaign Responses']/preceding::a[@class='btn btn-light']")
	private WebElement actionBar_addProject;
	@FindBy(how = How.XPATH, using = "//ul[@class='dropdown-menu dropdown-menu-right show']//li")
	private List<WebElement> actionBar_addProject_dd;

	// Add Inventory
	@FindBy(how = How.XPATH, using = "//i[@class='ion-funnel']")
	private WebElement funnelIcon_addInventory;
	@FindBy(how = How.XPATH, using = "//a[text()='Units'][@class='nav-link new_resale_div']")
	private WebElement unitsTab;
	@FindBy(how = How.XPATH, using = "//th[text()='Actions']/following::i[@class='fa fa-ellipsis-v'][1]")
	private WebElement actionBar_Unit;
	@FindBy(how = How.XPATH, using = "//th[text()='Actions']/following::button[text()='Details'][1]")
	private WebElement details_actionBar_Unit;

	// Inventory details
	@FindBy(how = How.XPATH, using = "//*[@id='right_pane']/div/div/div[1]/div/div/div[2]/div[2]/div[1]/div[1]/a")
	private WebElement addButton_inventoryDetails;
	@FindBy(how = How.XPATH, using = "//div[@class='dropdown-menu dropdown-menu-right show']//a")
	private List<WebElement> addButton_inventoryDetails_All;

	// .........Booking Details.........
	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-default close_profile_form']")
	private WebElement closeButton_Bookingdetails;
	@FindBy(how = How.XPATH, using = "//*[@id=\"s2id_autogen58\"]/a/span[2]")
	private WebElement enterUnit;
	@FindBy(how = How.XPATH, using = "//*[@id=\"select2-drop\"]/ul/li[1]")
	private WebElement selectUnit;
	@FindBy(how = How.XPATH, using = "//*[@id=\"center_pane_container\"]/div/div/div/div[1]/div[2]/div/div/button/i")
	private WebElement filters;
	@FindBy(how = How.CSS, using = "button[class='btn btn-light btn-icon toggle-filters']")
	private WebElement changeFileter;
	@FindBy(how = How.CSS, using = "a[class='clear-all-filters btn btn-link small']")
	private WebElement clearFilters;
	@FindBy(how = How.XPATH, using = "//*[@id=\"leads-list\"]/div/div/div/div[2]/div/div[2]/div/div/button")
	private WebElement applyButton;
	@FindBy(how = How.XPATH, using = "//*[@id=\"s2id_autogen53\"]")
	private WebElement projectFilter;
	@FindBy(how = How.XPATH, using = "//*[@id=\"select2-drop\"]/ul/li[2]")
	private WebElement projectSelect;
	@FindBy(how = How.XPATH, using = "//*[@id=\"s2id_autogen51\"]")
	private WebElement status;
	@FindBy(how = How.XPATH, using = "//*[@id=\"select2-drop\"]/ul/li[1]/div")
	private WebElement statusSelect;
	@FindBy(how = How.XPATH, using = "//*[@id=\"s2id_autogen57\"]")
	private WebElement tower;
	@FindBy(how = How.XPATH, using = "//*[@id=\"select2-drop\"]/ul/li")
	private WebElement towerSelect;
	@FindBy(how = How.XPATH, using = "//*[@id=\"leads-list\"]/div/div/div/div[2]/div/div[1]/div/span/a/i")
	private WebElement closeFilter;
	@FindBy(how = How.XPATH, using = "//span[text()='Campaign Responses']/preceding::a[@class='float-right small pt-2 open_form']")
	private WebElement addAProduct;
	@FindBy(how = How.XPATH, using = "//input[@class='select2-input select2-default']")
	private List<WebElement> enterProduct;
	@FindBy(how = How.XPATH, using = "//button[@class='w-100 btn btn-primary add_interested_property']")
	private WebElement clickAdd;
	@FindBy(how = How.CSS, using = "#leads-overview > div:nth-child(1) > div:nth-child(2) > div.alert.alert-info > div:nth-child(1)")
	private WebElement noAccessMessageText;
	@FindBy(how = How.CSS, using = ".ion-edit.ml-2")
	private WebElement clickOnEditLeadProfile;
	@FindBy(how = How.XPATH, using = "//input[@name='primary_phone_ph_number']")
	private WebElement EnterNumber;
	@FindBy(how = How.NAME, using = "primary_email_email")
	private WebElement EnterEmail;
	@FindBy(how = How.CSS, using = ".remove_link")
	private List<WebElement> ClickOnTrashButton;
	@FindBy(how = How.XPATH, using = "//button[@class='pull-right btn btn-primary save btn-sm lead_submit']")
	private WebElement ClickOnSave;
	@FindBy(how = How.XPATH, using = "(//span[@class='float-right small text-muted'])[1]")
	private WebElement getFeedTextCall;
	@FindBy(how = How.XPATH, using = "(//div[@class='timeline-item activity calls']//span)[1]")
	private WebElement callText;
	@FindBy(how = How.XPATH, using = "//label[text()='Owner']/parent::div//span")
	private WebElement UserName;
	@FindBy(how = How.CSS, using = "li[class='select2-results-dept-0 select2-result select2-result-selectable']")
	private List<WebElement> cancleFollowupResons;
	@FindBy(how = How.CSS, using = "div[class='select2-container form-control cancellation_reason']")
	private WebElement clickCancleFollowupResons;
	@FindBy(how = How.CSS, using = "textarea[name='cancellation_note']")
	private WebElement CancleFollowupNote;
	@FindBy(how = How.CSS, using = "button[data-text='cancel_followup']")
	private WebElement ClickOnCancleFollowup;
	@FindBy(how = How.CSS, using = "#view_notes")
	private WebElement clickOnViewNotesOfSiteVisit;
	@FindBy(how = How.XPATH, using = "//div[@class='small']//div[@class='collapse show']")
	private WebElement getNoteTextOfSiteVisit;
	@FindBy(how = How.CSS, using = "div.dropdown.stage.float-left.mr-1 button span[data-title='label']")
	private WebElement getLeadStage;
	@FindBy(how = How.NAME, using = "lead_id")
	private WebElement getLeadId;
	@FindBy(how = How.NAME, using = "first_name")
	private WebElement getLeadName;
	@FindBy(how = How.XPATH, using = "//div[@class='alert alert-danger' and text()='Followup has been scheduled already. You can cancel it.']")
	private WebElement ValidateFollowupScedule;
	@FindBy(how = How.XPATH, using = "//div[@class='select2-container form-control cancellation_reason']")
	private WebElement ClickOnCancellationReson;
	@FindBy(how = How.CSS, using = "#select2-drop li")
	private List<WebElement> SelectCancelationReson;
	@FindBy(how = How.XPATH, using = "//textarea[@name='cancellation_note']")
	private WebElement EnterCancellationReson;
	@FindBy(how = How.XPATH, using = "//button[text()='Cancel Followup']")
	private WebElement clickOnCancleFollowupButton;
	
	
	public String getLeadStage() {
		for (int i = 0; i < 50; i++) {
			if(waitUntilVisiblity(getLeadStage).getText().trim().equalsIgnoreCase("Prospect")) {
				wait(1000);
				refresh();
			}
			else {
				break;
			}
		}
		
		return waitUntilVisiblity(getLeadStage).getText().trim();
	}
	public String getLeadID() {
		return waitUntilVisiblity(getLeadId).getText().trim();
	}
	public String getLeadName() {
		return waitUntilVisiblity(getLeadName).getText().trim();
	}
	public String getEmailStatus() {
		return waitUntilVisiblity(emailStatusInFeed).getText().trim();
	}
	public String noAccessMessageText() {
		return waitUntilVisiblity(noAccessMessageText).getText().trim();
	}
	

	public String clickOnFollowupNote() {
		waitUntilClickable(clickOnViewNotesOfSiteVisit).click();
		return waitUntilVisiblity(getNoteTextOfSiteVisit).getText().trim();
	}

	public String getUserName() {
		return waitUntilVisiblity(UserName).getText().trim();
	}

	public String projectName() {
		return waitUntilVisiblity(projectSelected).getText().trim();
	}

	public String getFeedTextCall() {
		return waitUntilVisiblity(getFeedTextCall).getText().trim();
	}

	public void clickOnAddButton() {
		waitUntilClickable(addButton).click();
	}

	public void clickOnFollowup() {
		waitUntilClickable(more).click();
		waitUntilClickable(followup).click();
	}

	public void followupLink() {
		waitUntilClickable(more).click();
		waitUntilClickable(followupLink).click();
		try {
			wait(1000);
			if (ValidateFollowupScedule.isDisplayed()) {
				waitUntilClickable(ClickOnCancellationReson).click();
				wait(1000);
				waitUntilClickable(SelectCancelationReson.get(0)).click();
				waitUntilVisiblity(EnterCancellationReson).sendKeys("Automation");
				waitUntilClickable(clickOnCancleFollowupButton).click();
				waitUntilClickable(more).click();
				waitUntilClickable(followupLink).click();
				wait(5000);
			}
		} catch (Exception e) {
			
		}

	}

	public String ifFollowupShedule() {
		wait(1000);
		try {
			boolean flag = waitUntilVisiblity(driver
					.findElement(By.xpath("//div[text()='Followup has been scheduled already. You can cancel it.']")))
					.isDisplayed();
			if (flag) {
				waitUntilClickable(clickCancleFollowupResons).click();
				waitUntilVisibilityOfElements(cancleFollowupResons).get(0).click();
				waitUntilVisiblity(CancleFollowupNote).sendKeys("Cancle FollowUp By Automation");
				jsClick(ClickOnCancleFollowup);
				String msg = getSuccessMSG();
				waitUntilClickable(more).click();
				waitUntilClickable(followupLink).click();
				return msg;
			}
		} catch (Exception e) {
		}
		return "Followup Not shedule Before";
	}

	public String cancleFollowup() {
		wait(1000);
		try {
			boolean flag = waitUntilVisiblity(driver
					.findElement(By.xpath("//div[text()='Followup has been scheduled already. You can cancel it.']")))
					.isDisplayed();
			if (flag) {
				waitUntilClickable(clickCancleFollowupResons).click();
				waitUntilVisibilityOfElements(cancleFollowupResons).get(0).click();
				waitUntilVisiblity(CancleFollowupNote).sendKeys("Cancle FollowUp By Automation");
				jsClick(ClickOnCancleFollowup);
				String msg = getSuccessMSG();
				return msg;
			}
		} catch (Exception e) {
		}
		return "Followup Not shedule Before";
	}

	// ................Methods for Scheduling Site visit....................

	public void clickOnMeetingLink() {
		waitUntilClickable(more).click();
		waitUntilClickable(siteVisit).click();
	}

	public void selectReschedule() {
		waitUntilClickable(actionBar_Sitevisit.get(0)).click();
		waitUntilVisibilityOfElements(actionBar_Options);
		List<WebElement> list = actionBar_Options;
		for (WebElement ele : list) {
			if (ele.getAttribute("innerHTML").contains("Reschedule")) {
				waitUntilClickable(ele).click();
				break;
			}
		}
	}

	public void selectMarkAsConducted() {
		wait(3000);
		waitUntilClickable(actionBar_Sitevisit.get(0)).click();
		waitUntilVisibilityOfElements(actionBar_Options);
		List<WebElement> list = actionBar_Options;
		for (WebElement ele : list) {
			if (ele.getText().trim().contains("Mark as conducted")) {
				wait(1000);
				waitUntilClickable(ele).click();
				break;
			}
		}
	}

	public void selectMarkDidNotVisit() {
		waitUntilClickable(actionBar_Sitevisit.get(0)).click();
		List<WebElement> list = waitUntilVisibilityOfElements(actionBar_Options);
		for (WebElement ele : list) {
			if (ele.getAttribute("innerHTML").contains("Mark did not visit")) {
				waitUntilClickable(ele).click();
				break;
			}
		}
	}

	public void selectMarkNotInterested() {
		waitUntilClickable(actionBar_Sitevisit.get(0)).click();
		List<WebElement> list = waitUntilVisibilityOfElements(actionBar_Options);
		for (WebElement ele : list) {
			if (ele.getAttribute("innerHTML").contains("Mark not interested")) {
				waitUntilClickable(ele).click();
				break;
			}
		}
	}

	public void selectConfirm() throws Exception {
		waitUntilClickable(actionBar_Sitevisit.get(0)).click();
		List<WebElement> list = waitUntilVisibilityOfElements(actionBar_Options);
		for (WebElement ele : list) {
			if (ele.getAttribute("innerHTML").contains("Confirm")) {
				waitUntilClickable(ele).click();
				break;
			}
		}
	}

	public void selectCancelFollowup() {
		waitUntilClickable(actionBar_Followup).click();
		List<WebElement> list = waitUntilVisibilityOfElements(actionBar_Options);
		for (WebElement ele : list) {
			if (ele.getAttribute("innerHTML").contains("Cancel Followup")) {
				waitUntilClickable(ele).click();
				break;
			}
		}
	}

	public void selectActivity(int tabNumber) {
		waitUntilClickable(driver
				.findElement(By.cssSelector("#activity_container > div > nav > li:nth-child(" + tabNumber + ") > a")));
		waitUntilClickable(driver
				.findElement(By.cssSelector("#activity_container > div > nav > li:nth-child(" + tabNumber + ") > a")))
				.click();
	}

	public void userLogout() {
		waitUntilClickable(userIcon).click();
		waitUntilClickable(logout).click();

	}

	public void backToAdmin() throws Exception {
		waitUntilClickable(userIcon).click();
		waitUntilClickable(userIcon).click();
		waitUntilClickable(backToAdmin).click();

	}

	public void clickOnEmailLink() {
		waitUntilClickable(email).click();
		waitUntilClickable(ComposeEmail).click();
	}

	public boolean clickOnSmsLink() throws NumberFormatException, InterruptedException {
		wait(2000);
		Boolean b = SMS.isDisplayed();
		for (int i = 0; i <= 10; i++) {
			if (b == false) {
				driver.navigate().back();
				AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);
				adminDashboardPage.searchLead(Integer.parseInt(R('0','1', '2', '3', '4', '5', '6', '7', '8', '9')),
						"All Leads");
			}
			if (b == true) {
				break;
			}
		}
		waitUntilClickable(SMS).click();
		return true;
	}

	// .........................Methods for adding a Note.......................

	public void clickOnAddANoteLink() {
		waitUntilClickable(addANote).click();
	}

	public void enterNote(String note) {
		waitUntilVisiblity(addNote_Textarea).sendKeys(note);
	}

	public void clickOnsaveNoteButton() {
		waitUntilClickable(saveNoteButton).click();

	}

	public String getNoteText() {
		return waitUntilVisiblity(noteTExtInActivity).getText().trim();
	}

	// ......................Methods for Activities Details......................

	public void clickSitvisit_d() {
		waitUntilClickable(more_d).click();
		waitUntilClickable(sitevisit_d).click();
	}

	public void openEmailActivities() {
		waitUntilClickable(more_d).click();
		waitUntilClickable(email_Activity).click();

	}

	public void selectPending_Sitevisit() throws InterruptedException {
		waitUntilClickable(subfilter_Sitevisit).click();
		List<WebElement> list = subfilter_Sitevisit_All;
		for (WebElement ele : list) {
			if (ele.getAttribute("innerHTML").contains("Pending")) {
				waitUntilClickable(ele).click();
				break;
			}
		}
	}

	public void clickFollowup_d() {
		waitUntilClickable(more_d).click();
		waitUntilClickable(followup_d).click();
	}

	public void clickOnCall_d() {
		scrollIntoViewUp(more_d);
		waitUntilClickable(more_d).click();
		wait(1000);
		scrollBy(200);
		waitUntilClickable(call_d).click();
	}

	public void clickEmail_d() {
		jsClick(more_d);
		jsClick(email_d);
	}

	public void clickSms_d() {
		waitUntilClickable(more_d).click();
		waitUntilClickable(sms_d).click();
	}

	public void clickActivityTab() {
		waitUntilClickable(activityTab).click();
	}

	public void clickFeedTab() {
		scrollIntoViewUp(more_d);
		waitUntilClickable(more_d).click();
		scrollIntoViewUp(feedTab);
		waitUntilClickable(feedTab).click();
	}

	public void clickOnActionBar() {
		waitUntilClickable(followup_d_actionbar).click();
	}

	public void clickOnEmail_FollowupActivity() {
		waitUntilClickable(email_FollowupActivity).click();
	}

	public void selectPush() {
		scrollIntoViewUp(more);
		wait(500);
		waitUntilClickable(more).click();
		waitUntilClickable(push).click();
	}

	public void selectPull() throws Exception {
		waitUntilClickable(pull).click();
	}

	public void selectReassign() {
		waitUntilClickable(more).click();
		waitUntilClickable(reassign).click();
	}

	public void selectConductedSiteVisit() {
		waitUntilClickable(more).click();
		waitUntilClickable(conductedSiteVisit).click();
	}

	public void selectSiteVisit() {
		waitUntilClickable(more).click();
		waitUntilClickable(siteVisit).click();
	}

	public void selectMergeLeads() {
		waitUntilClickable(more).click();
		waitUntilClickable(mergeLeads).click();
	}

	public void clickOnBrochure() {
		waitUntilClickable(brochure).click();
	}

	public String getLeadId() {
		return waitUntilVisiblity(leadid).getText().trim();
	}
	public String getLeadIdWithotHash() {
		return waitUntilVisiblity(leadid).getText().trim().replaceAll("[^a-zA-Z0-9]", " ");
	}
	public void clickOnSendQuickQuote() {
		waitUntilClickable(sendQuickQuote).click();
	}

	// ...........Method for stage change..............

	public void changing_Stage(String stageName) throws InterruptedException {
		waitUntilClickable(stageDropdown).click();
		List<WebElement> list = stageDropdown_All;

		for (WebElement ele : list) {
			if (ele.getText().trim().equalsIgnoreCase(stageName)) {
				waitUntilVisiblity(ele);
				wait(1000);
				ele.click();
				break;
			}
		}
		wait(1000);
		jsClick(saveButton);
	}

	public void selectReasonForLostOrUnqualified() {
		driver.findElement(By.cssSelector("#s2id_select-reason")).click();
		wait(1000);
		WebElement ele = waitUntilVisiblity(
				driver.findElement(By.xpath("//div[@id='select2-drop']//div[@class='select2-search']")));
		System.out.println(ele.getText());
		wait(1000);
		waitUntilVisibilityOfElements(driver.findElements(By.cssSelector("li[class*='select2-result'] "))).get(0)
				.click();
		waitUntilClickable(saveChangesButton).click();
	}
	// ........Methods for adding project on lead................

	public void addingProject() throws InterruptedException {
		waitUntilClickable(addaProductButton).click();
		waitUntilClickable(addProjectsField.get(2)).click();
		waitUntilClickable(addfirstProject).click();

	}

	public void selectProject(String str) throws InterruptedException {
		scrollIntoView(addaProductButton);
		scrollBy(-100);
		waitUntilClickable(addaProductButton).click();
		waitUntilClickable(addProjectsField1).click();
		List<WebElement> list = addProjectsField;
		for (WebElement ele : list) {
			System.out.println("Values " + ele.getAttribute("innerHTML"));
			if (ele.getText().trim().equalsIgnoreCase(str)) {
				waitUntilClickable(ele).click();
				break;
			}
		}
	}

	public String selectProject(int num) throws InterruptedException {
		scrollIntoView(addaProductButton);
		scrollBy(-100);
		waitUntilClickable(addaProductButton).click();
		waitUntilClickable(addProjectsField1).click();
		wait(1000);
		String projectName = addProjectsField.get(num).getText().trim();
		(addProjectsField.get(num)).click();
		return projectName;
	}

	public void addingInventory() throws InterruptedException {
		waitUntilClickable(actionBar_addProject);
		actionBar_addProject.click();
		List<WebElement> list = actionBar_addProject_dd;
		for (WebElement ele : list) {
			if (ele.getAttribute("innerHTML").contains("add_inventory_property")) {
				waitUntilClickable(ele).click();
				break;
			}
		}
	}

	public void selectingUnit() throws InterruptedException {
		waitUntilClickable(actionBar_Unit).click();
		waitUntilClickable(details_actionBar_Unit).click();
	}

	public void bookingUnit() throws InterruptedException {
		waitUntilClickable(addButton_inventoryDetails).click();
		List<WebElement> list = addButton_inventoryDetails_All;
		for (WebElement ele : list) {
			if (ele.getAttribute("innerHTML").contains("Booked")) {
				waitUntilClickable(ele).click();
				break;
			}
		}
	}

	public void selectBookings() {
		scrollBy(-450);
		waitUntilClickable(more).click();
		waitUntilClickable(bookings).click();
	}

	public void searchAndSelectProjectUnit() {
		Actions actions = new Actions(driver);
		waitUntilVisiblity(enterUnit);
		actions.moveToElement(enterUnit);
		actions.click().perform();
		actions.sendKeys("ps unit 75").perform();
		waitUntilClickable(selectUnit).click();
	}

	public void selectLogOfflineCalls() {
		waitUntilClickable(more).click();
		waitUntilClickable(logOflineCall).click();
	}

	public void addPhoneNumber() {
		jsClick(clickOnEditLeadProfile);
		waitUntilVisiblity(EnterNumber).sendKeys("+91 " + "12345" + RandomStringUtils.randomNumeric(5));
		jsClick(ClickOnSave);

		try {
			for (int i = 0; i < ClickOnTrashButton.size(); i++) {
				jsClick(ClickOnTrashButton.get(i));
			}
			jsClick(ClickOnSave);
		} catch (Exception e) {
		}
	}
	public void addEmail() {
		jsClick(clickOnEditLeadProfile);
		waitUntilVisiblity(EnterEmail).clear();;
		EnterEmail.sendKeys(randomEmail());
		jsClick(ClickOnSave);

		try {
			for (int i = 0; i < ClickOnTrashButton.size(); i++) {
				jsClick(ClickOnTrashButton.get(i));
			}
			jsClick(ClickOnSave);
		} catch (Exception e) {
		}
	}
	public String callText() {

		return waitUntilVisiblity(callText).getText().trim();

	}

	public void clickOnCloseButton_Bookingdetails() {
		waitUntilClickable(closeButton_Bookingdetails).click();
	}

	public void clickOnEditIcon() {
		waitUntilClickable(editIcon).click();
	}

	public void clearFilter() {

		waitUntilClickable(changeFileter).click();		
		waitUntilClickable(clearFilters).click();;
	}

	public void changeFilters() {
		Actions actions = new Actions(driver);
		waitUntilVisiblity(filters);
		actions.moveToElement(filters);
		actions.click().perform();
		waitUntilClickable(clearFilters);
		actions.moveToElement(clearFilters);
		actions.click().perform();
		waitUntilClickable(applyButton);
		actions.moveToElement(applyButton).click().perform();
		waitUntilClickable(projectFilter);
		actions.moveToElement(projectFilter);
		actions.click();
		actions.sendKeys("Project Secure");
		actions.build().perform();
		actions.moveToElement(projectSelect).click().perform();
		// Status filter
		waitUntilClickable(status);
		actions.moveToElement(status).click().perform();
		waitUntilClickable(statusSelect);
		actions.moveToElement(statusSelect).click().perform();

		// Tower filter
		waitUntilClickable(tower);
		actions.moveToElement(tower).click();
		actions.sendKeys("Inventory1");
		actions.build().perform();
		waitUntilClickable(towerSelect);
		actions.moveToElement(towerSelect).click().perform();
		// Click Apply button
		waitUntilClickable(applyButton);
		actions.moveToElement(applyButton).click().perform();
		scrollBy(-300);
		waitUntilClickable(closeFilter);
		// Close the filter popup
		actions.moveToElement(closeFilter).click().perform();

	}

	public void addAProduct() {
		waitUntilClickable(addAProduct);
		addAProduct.click();
		List<WebElement> list = enterProduct;
		for (WebElement ele : list) {
			if (ele.getAttribute("innerHTML").contains("Testing")) {
				waitUntilClickable(ele).click();
				break;
			}
		}
		waitUntilClickable(clickAdd).click();
	}
}
