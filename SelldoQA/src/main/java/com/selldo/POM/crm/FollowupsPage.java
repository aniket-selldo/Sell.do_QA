package com.selldo.POM.crm;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selldo.Utility.ReusableUtils;

public class FollowupsPage extends ReusableUtils {

	public WebDriver driver;

	public FollowupsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.CSS, using = "input[name='scheduled_date']")
	private WebElement ScheduleOnDateField;
	@FindBy(how = How.CSS, using = "		")
	private WebElement ScheduleOnTimeField;
	@FindBy(how = How.CSS, using = "div.datepicker-days > table > tbody > tr > td.active.day")
	private WebElement selectToday;
	@FindBy(how = How.CSS, using = "#s2id_autogen26 > a > span.select2-chosen")
	private WebElement FollowupType;
	@FindBy(how = How.CSS, using = "#select2-drop ul li:nth-child(1)")
	private WebElement callFollowup;
	@FindBy(how = How.CSS, using = "#select2-drop ul li:nth-child(2)")
	private WebElement emailFollowup;
	@FindBy(how = How.CSS, using = "[placeholder=\"Subject\"]")
	private WebElement subjectText;
	@FindBy(how = How.CSS, using = "[placeholder=\"Notes / Agenda\"]")
	private WebElement noteText;
	@FindBy(how = How.XPATH, using = "//button[text()='Schedule Followup']")
	private WebElement ScheduleFollowupButton;
	@FindBy(how = How.CSS, using = "button.close.text-white.lead-index")
	private WebElement closeButton;
	@FindBy(how = How.CSS, using = "div.select2-container.form-control.cancellation_reason a span")
	private WebElement CancellationReasonDropdown;
	@FindBy(how = How.CSS, using = "#select2-drop > ul > li:nth-child(1) > div")
	private WebElement cancellationReason;
	@FindBy(how = How.CSS, using = "textarea[placeholder=\"Notes\"]")
	private WebElement cancelNoteText;
	@FindBy(how = How.XPATH, using = "//button[text()='Cancel Followup']")
	private WebElement cancelFollowupButton;
	@FindBy(how = How.XPATH, using = "//button[text()=' Ignore & Schedule ']")
	private WebElement ignoreAndScheduleButton;
	@FindBy(how = How.XPATH, using = "//button[text()='Cancel']")
	private WebElement cancelFollowupForPostSalesButton;
	@FindBy(how = How.XPATH, using = "//button[contains(@class,'btn btn-primary submit_form')]")
	private WebElement ScheduleFollowupButtonForPostSales;
	@FindBy(how = How.XPATH, using = "//div[@class='select2-container form-control']")
	private WebElement followupBy;
	@FindBy(how = How.CSS, using = ".navigation.clearfix.todays_stat_show_lead")
	private List<WebElement> getAllFollowupFromActivityDB;
	
	public boolean validateIDInActivity(String id) {
		boolean flag = false;
		for (WebElement webElement : getAllFollowupFromActivityDB) {
			if(webElement.getText().replaceAll("[^0-9]+", "").trim().equalsIgnoreCase(id.trim())) {
				flag=true;
			}
		}
		return flag;
	}
	
	// Selecting current date from calendar
	public void selectDate() throws Exception {
		//wait(500);
		waitUntilClickable(ScheduleOnDateField).click();
		waitUntilClickable(selectToday).click();
	}

	public String getFeedText() {
		wait(2000);
		return waitUntilVisiblity(driver.findElement(By.cssSelector(
				"#tab-activity > div.activities_list > div:nth-child(1) div.card div:nth-child(1) > div.col-lg-11"))
				).getText().split(",")[0].trim();
	}
	// Clicking on Schedule On Time field
	public void clickOnScheduleOnTimeField() {
		waitUntilClickable(ScheduleOnTimeField).click();
	}

	// Selecting type of follow up either call/email

	public void selectFollowupType(String type) {
		waitUntilClickable(FollowupType).click();
		if (type.equalsIgnoreCase("Call")) {
			waitUntilClickable(callFollowup).click();
		} else {
			waitUntilClickable(emailFollowup).click();
		}

	}

	// adding Subject
	public void addSubject(String subject) {
		waitUntilVisiblity(noteText).sendKeys(subject);

	}

	// adding Notes
	public void addingNotes(String notes) {
		waitUntilVisiblity(subjectText).sendKeys(notes);

	}

	// Clicking on Schedule Followup button
	public String clickOnScheduleFollowupButton() {
		jsClick(ScheduleFollowupButton);
		return waitUntilVisiblity(followupBy).getText().toLowerCase().trim();
	}
	public void clickOnScheduleFollowupButton2() {
		jsClick(ScheduleFollowupButton);
	}
	public void clickOnScheduleFollowupButon() {
		jsClick(ScheduleFollowupButton);
	}
	public void clickOnIgnoreAndSchedule() {
		wait(1000);
		scrollIntoView(ignoreAndScheduleButton);
		jsClick(ignoreAndScheduleButton);
	}

	// Closing Follow up Page
	public void closeWindow() {
		waitUntilClickable(closeButton).click();

	}

	// Clicking on Cancellation Reason drop down
	public void clickCancellationReasonDropdown() throws Exception {
		// Thread.sleep(4000);
		waitUntilClickable(CancellationReasonDropdown).click();
	}

	// Selecting Cancellation Reason as Incorrect follow up date
	public void selectCancellationReason() {
		waitUntilClickable(cancellationReason).click();
	}

	// adding Cancellation Notes
	public void cancelNotes(String textNotes) {
		waitUntilVisiblity(cancelNoteText).sendKeys(textNotes);

	}

	// Clicking on Cancel Follow up button
	public void clickCancelFollowupButton() {
		waitUntilClickable(cancelFollowupButton).click();
	}

	// Clicking on Schedule Followup button for post sales
	public void clickOnScheduleFollowupButtonForPostSales() {
		waitUntilClickable(ScheduleFollowupButtonForPostSales).click();
	}

	// Clicking on Cancel Follow up button PostSales
	public void clickCancelFollowupForPostSalesButton() {
		waitUntilClickable(cancelFollowupForPostSalesButton).click();
	}

}
