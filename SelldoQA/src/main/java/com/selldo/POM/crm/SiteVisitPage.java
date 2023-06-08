package com.selldo.POM.crm;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selldo.Utility.ReusableUtils;

public class SiteVisitPage extends ReusableUtils {

	public WebDriver driver;

	public SiteVisitPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// ...................Schedule Site visit form .........................

	@FindBy(how = How.XPATH, using = "(//span[text()='Select Project'])[1]")
	private WebElement projectSpan;
	@FindBy(how = How.XPATH, using = "//div[@id='select2-drop']//ul[@class='select2-results']")
	private WebElement project_dd;
	@FindBy(how = How.NAME, using = "scheduled_date")
	private WebElement scheduleOnDate;
	@FindBy(how = How.XPATH, using = "//input[@name='conducted_date']")
	private WebElement conductedOnDate;
	@FindBy(how = How.XPATH, using = "//div[@class='datepicker-days']//td[@class='day']")
	private List<WebElement> wholeCalender;
	@FindBy(how = How.CSS, using = "div.datepicker-days > table > tbody > tr > td.active.day")
	private WebElement selectToday;
	@FindBy(how = How.XPATH, using = "//label[text()='Schedule on (date & time)']/following::span[2]")
	private WebElement scheduleOnTime;
	@FindBy(how = How.XPATH, using = "//button[normalize-space()='Schedule Site visit']")
	private WebElement scheduleSiteVisitButton;
	@FindBy(how = How.XPATH, using = "//label[text()='Site visit Confirmation']/following::span[1]")
	public WebElement siteVisitConfirmation;
	@FindBy(how = How.CSS, using = "#select2-drop > div > input")
	private WebElement tentative_dd;
	@FindBy(how = How.XPATH, using = "//button[text()=' Ignore & Schedule ']")
	private WebElement ignoreAndScheduleButton;
	@FindBy(how = How.XPATH, using = "//textarea[@class='form-control notes']")
	private WebElement siteVisitNotes_addConducted;
	@FindBy(how = How.XPATH, using = "(//div[@id='form_container']//button)[6]")
	private WebElement addPreviouslyConductedSiteVisitButton;
	@FindBy(how = How.XPATH, using = "//*[contains(@class,'small text-muted f')]")
	private WebElement activityStatus;
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Site visit type')]/parent::div//a")
	private WebElement clickOnSiteVisitType;
	@FindBy(how = How.XPATH, using = "//li[contains(@class,'select2-re')]")
	private List<WebElement> selectSiteVisitType;

	// ...................Reschedule Site visit form........................

	@FindBy(how = How.XPATH, using = "//button[text()='Reschedule']")
	private WebElement rescheduleButton;

	// ....................Mark Site visit Conducted.........................

	@FindBy(how = How.XPATH, using = "//label[text()='Conducted on (date & time)']/following::input[1]")
	private WebElement scheduleOnDate_ConductedOn;
	@FindBy(how = How.XPATH, using = "//div[@class='datepicker datepicker-dropdown dropdown-menu datepicker-orient-left datepicker-orient-top']//tr//td")
	private List<WebElement> calender;
	@FindBy(how = How.XPATH, using = "//textarea[@name='notes']")
	private WebElement conductedNotes;
	@FindBy(how = How.XPATH, using = "//a[text()='Mark as conducted']")
	private WebElement markAsConductedButton;

	// ......................Mark Did Not Visit.................................

	@FindBy(how = How.XPATH, using = "//label[text()='Site visit notes']/following::textarea")
	private WebElement didNotVisitNotes;
	@FindBy(how = How.XPATH, using = "//button[text()='Did not visit']")
	private WebElement didNotVisitButton;

	// ......................Mark Not Interested................................

	@FindBy(how = How.XPATH, using = "//label[text()='Site visit notes']/following::textarea")
	private WebElement notInterestedNotes;
	@FindBy(how = How.XPATH, using = "//button[text()='Mark not interested']")
	private WebElement markNotInterestedButton;

	@FindBy(how = How.XPATH, using = "//button[starts-with(@class,'btn btn-primary bt')]")
	private WebElement confirmButton;
	@FindBy(how = How.XPATH, using = "//td[@class='active day']")
	private WebElement SiteVisitConfirmDate;
	@FindBy(how = How.CSS, using = "[class='btn btn-primary btn-sm pull-right schedule_site_visit']")
	private WebElement clickOnSaveButton;
	
	/*
	 * WebDriver driver = null; WebDriverWait wait;
	 * 
	 * public DocumentsPage(WebDriver driver) {
	 * 
	 * this.driver = driver; wait = new WebDriverWait(driver, 8); }
	 */

	public void clickOnSaveButton() {
		jsClick(clickOnSaveButton);
	}
	public void selectProject() {
		waitUntilClickable(projectSpan).click();
		wait(300);
		waitUntilClickable(project_dd);
		project_dd.click();
	}

	public int sitevisitScheduleDate() throws Exception {
		waitUntilClickable(scheduleOnDate);
		wait(2000);
		scheduleOnDate.click();
		wait(2000);
		List<WebElement> dates = wholeCalender;
		int total_node = dates.size();
		String date="";
		for (int i = 0; i < total_node; i++) {
			 date = dates.get(i).getText();
			if (date.equals("6")) {
				waitUntilClickable(dates.get(i)).click();// Clicking on above selected date
				break;
			}
		}
		return Integer.parseInt(date);
	}

	public void selectDate() throws Exception {
		waitUntilClickable(scheduleOnDate).click();
		waitUntilClickable(selectToday).click();
	}

	public void clickOnScheduleSiteVisitButton() {
		waitUntilClickable(scheduleSiteVisitButton).click();
	}

	public void clickOnConfirmButton() throws Exception {
//		WebElement ele = driver.findElement(By.xpath("//div[@class='noty_message']"));
//		waitUntilInvisibility(ele);
		jsClick(confirmButton);
	}

	public void clickOnIgnoreAndSchedule() {
		scrollIntoView(ignoreAndScheduleButton);
		wait(1000);
		waitUntilClickable(ignoreAndScheduleButton).click();
	}

	// ...................Methods for Reschedule............................

	public void sitevisitRescheduleDate() throws InterruptedException {
		waitUntilClickable(scheduleOnDate).click();
		wait(1000);
		List<WebElement> dates = wholeCalender;
		int total_node = dates.size();
		for (int i = 0; i < total_node; i++) {
			String date = dates.get(i).getText();
			if (date.equals("28")) {
				waitUntilClickable(dates.get(i)).click();// Clicking on above selected date
				break;
			}
		}
	}

	public void clickOnRescheduleButton() throws Exception {
		scrollIntoView(rescheduleButton);
		waitUntilClickable(rescheduleButton);
		wait(3000);
		rescheduleButton.click();
	}

	// .................Methods for Mark As Conducted.......................

	public void sitevisitConductedOnDate() throws Exception {
		waitUntilClickable(scheduleOnDate_ConductedOn).click();
		List<WebElement> dates = calender;
		int total_node = dates.size();
		for (int i = 0; i < total_node; i++) {
			String date = dates.get(i).getText();
			if (date.equals("10")) {
				wait(1000);
				waitUntilClickable(dates.get(i)).click();// Clicking on above selected date
				break;
			}
		}
	}
	public void sitevisitConductedOnDate2() {
		waitUntilClickable(scheduleOnDate_ConductedOn).click();
		waitUntilClickable(SiteVisitConfirmDate).click();
	}

	public void enterNotesForConductedSiteVisit(String notes) {
		waitUntilVisiblity(conductedNotes).sendKeys(notes);
	}

	public void clickOnMarkAsConductedButton() throws Exception {
		waitUntilClickable(markAsConductedButton).click();
	}
	
	// ..................Methods for Mark Did Not Visit........................

	public void enterNotesForDidNotVisit(String notes) {
		waitUntilVisiblity(didNotVisitNotes).sendKeys(notes);
	}

	public void clickOnDidNotVisitButton() throws Exception {

		waitUntilClickable(didNotVisitButton).click();
	}

	// ..................Methods for Mark Not Interested.......................

	public void enterNotesForNotInterested(String notes) throws Exception {
		waitUntilVisiblity(notInterestedNotes).sendKeys(notes);
	}

	public void clickOnMarkNotInterestedButton() throws Exception {
		waitUntilClickable(markNotInterestedButton).click();
	}

	// ........................Selecting
	// Tentative................................

	public void selectTentative() {
		// scrollIntoView(siteVisitConfirmation);
		// scrollBy(2000);
		// scrollAction(driver.findElement(By.xpath("//label[text()='Teams']")),siteVisitConfirmation);
		scrollIntoView(driver.findElement(By.xpath("//label[text()='Teams']")));
//		scrollIntoViewUp(siteVisitConfirmation);
//		wait(1000);
//		waitUntilClickable(siteVisitConfirmation);
//		wait(1000);
		wait(1000);
		waitUntilClickable(siteVisitConfirmation).click();
		waitUntilVisiblity(tentative_dd).sendKeys("Tentative");
		tentative_dd.sendKeys(Keys.ENTER);

	}

	// ...........Methods for adding conducted site visit..................
	public void sitevisitConductedDate(int dt) throws Exception {
		Thread.sleep(2000);
		waitUntilClickable(conductedOnDate).click();
		List<WebElement> dates = wholeCalender;
		int total_node = dates.size();
		for (int i = 0; i < total_node; i++) {
			String date = dates.get(i).getText();
			if (date.equalsIgnoreCase(String.valueOf(dt))) {
				waitUntilClickable(dates.get(i)).click();// Clicking on above selected date
				break;
			}
		}
	}

	public void sitevisitConductedDate(String dt) throws Exception {

		WebElement day = driver
				.findElement(By.xpath("//input[@name='conducted_date']/parent::div//select[contains(@class,'day')]"));
		WebElement month = driver
				.findElement(By.xpath("//input[@name='conducted_date']/parent::div//select[contains(@class,'month')]"));
		WebElement year = driver
				.findElement(By.xpath("//input[@name='conducted_date']/parent::div//select[contains(@class,'year')]"));

		int days = Integer.parseInt(date("d")) - 2;

		selectByVisibleValue(day, dt);
		selectByVisibleValue(month, date("M"));
		selectByVisibleValue(year, String.valueOf(Integer.parseInt(date("y")) - 1));

		driver.findElement(By.cssSelector("input[name*='conducted_t']")).click();
		WebElement hr = driver.findElement(By.xpath(".//input[@class='bootstrap-timepicker-hour']"));
		WebElement min = driver.findElement(By.xpath(".//input[@class='bootstrap-timepicker-minute']"));
		WebElement AMPM = driver.findElement(By.xpath(".//input[@class='bootstrap-timepicker-meridian']"));
		waitUntilVisiblity(hr).clear();
		hr.sendKeys(String.valueOf(Integer.valueOf(date("h")) - 1));
		waitUntilVisiblity(min).clear();
		min.sendKeys(String.valueOf(Integer.valueOf(date("m"))));
		waitUntilVisiblity(AMPM).clear();
		AMPM.sendKeys("AM");
	}

	public String selectSiteVisitType(String inpute) {
		waitUntilClickable(clickOnSiteVisitType).click();
		waitUntilVisibilityOfElements(selectSiteVisitType);
		Iterator<WebElement> it = selectSiteVisitType.iterator();
		while (it.hasNext()) {
			WebElement comp = it.next();
			if (comp.getText().trim().equalsIgnoreCase(inpute)) {
				waitUntilClickable(comp).click();
				break;
			}
		}
		return inpute;
	}

	public void addNotes(String notes) {
		scrollIntoView(siteVisitNotes_addConducted);
		waitUntilVisiblity(siteVisitNotes_addConducted).sendKeys(notes);
	}

	public void clickOnAddPreviouslyConductedSvButton() {
		waitUntilClickable(addPreviouslyConductedSiteVisitButton).click();

	}

	public String trackActivity() {
		return waitUntilVisiblity(activityStatus).getText();
	}

}
