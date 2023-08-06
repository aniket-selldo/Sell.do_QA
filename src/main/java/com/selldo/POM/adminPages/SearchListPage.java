package com.selldo.POM.adminPages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selldo.Utility.ReusableUtils;

public class SearchListPage extends ReusableUtils {
	public WebDriver driver;

	public SearchListPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//a[text()='New List']")
	private WebElement newListButton;
	@FindBy(how = How.XPATH, using = "//input[@id='search_criterium_name']")
	private WebElement name;
	@FindBy(how = How.CSS, using = "#s2id_search_criterium_date_range_field a span:nth-child(1)")
	private WebElement scheduledActivitySpan;
	@FindBy(how = How.XPATH, using = "//ul[@class='select2-results']//li")
	private List<WebElement> scheduledActivity_All;
	@FindBy(how = How.XPATH, using = "//*[@id=\"list-basics\"]/div[2]/div/div[3]/div/div/a")
	private WebElement scheduledActivityRangeSpan;
	@FindBy(how = How.XPATH, using = "//div[@class='daterangepicker dropdown-menu single opensright show-calendar']//tr//td")
	private List<WebElement> scheduledActivityRange_CalendarStartDate;
	@FindBy(how = How.CSS, using = "#s2id_search_criterium_available_for")
	private WebElement purposeSpan;
	@FindBy(how = How.XPATH, using = "//ul[@class='select2-results']//li")
	private List<WebElement> purpose_All;
	@FindBy(how = How.XPATH, using = "//*[@id=\"modal-remote-form-inner\"]/div/div/div[3]/input")
	private WebElement saveButton;
	@FindBy(how = How.XPATH, using = "//th[text()='Actions']/following::i[1]")
	private WebElement actionbar;
	@FindBy(how = How.XPATH, using = "//th[text()='Actions']/following::a[text()='Edit'][1]")
	private WebElement editLink;
	@FindBy(how = How.XPATH, using = "//div[@class='daterangepicker dropdown-menu single opensright show-calendar']//tr//td")
	private List<WebElement> scheduledActivityRange_CalendarEndDate;
	@FindBy(how = How.XPATH, using = "//input[@class='datepicker starts_on input-normal']")
	private WebElement startDate;
	@FindBy(how = How.XPATH, using = "//input[@class='datepicker ends_on input-normal']")
	private WebElement endDate;
	@FindBy(how = How.CSS, using = "button[class='btn btn-sm btn-primary applyBtn']")
	private WebElement applyButton;
	@FindBy(how = How.XPATH, using = "//*[@id=\"s2id_search_criterium_date_range_order\"]/a/span[1]")
	private WebElement order;
	@FindBy(how = How.XPATH, using = "//ul[@class='select2-results']//li")
	private List<WebElement> orderList;
	@FindBy(how = How.XPATH, using = "//th[text()='name']/following::span[1]")
	private WebElement getLestName;
	
	public void clickOnNewListButton() {
		waitUntilClickable(newListButton).click();
	}
	public String getLestName() {
		return waitUntilVisiblity(getLestName).getText().trim();
	}

	public void enterListName(String listName) {
		waitUntilVisiblity(name).sendKeys(listName);
	}

	public void selectScheduledActivity() {
		waitUntilClickable(scheduledActivitySpan).click();
		List<WebElement> list = scheduledActivity_All;
		for (WebElement ele : list) {
			if (ele.getAttribute("innerHTML").contains("Lead received on")) {
				waitUntilClickable(ele).click();
				break;
			}
		}
	}

	// Select the order as it is a mandatory field
	public void selectOrder() {
		waitUntilClickable(order).click();
		List<WebElement> list = orderList;
		for (WebElement ele : list) {
			System.out.println("Values " + ele.getAttribute("innerHTML"));
			if (ele.getAttribute("innerHTML").contains("Ascending")) {
				waitUntilClickable(ele).click();
				System.out.println("Clicked on Lead received on");
				break;
			}
		}
	}

	public void selectScheduledActivityRange() {

		// Click Scheduled activity range field
		waitUntilClickable(scheduledActivityRangeSpan).click();

		// Click Start date field and select the date
		waitUntilClickable(startDate).click();
		List<WebElement> dates = scheduledActivityRange_CalendarStartDate;
		int total_node = dates.size();
		for (int i = 0; i < total_node; i++) {
			String date = dates.get(i).getText();
			if (date.equals("2")) {
				waitUntilClickable(dates.get(i)).click();// Clicking on above selected date
				break;
			}
		}
	
		// Click end date field and select the select date
		waitUntilClickable(endDate).click();
		List<WebElement> dates2 = scheduledActivityRange_CalendarEndDate;
		int total_node2 = dates2.size();
		for (int i = 0; i < total_node2; i++) {
			String date = dates2.get(i).getText();
			if (date.equals("2")) {
				waitUntilClickable(dates2.get(i)).click();// Clicking on above selected date
				break;
			}
		}
		

		// Click Apply button
		waitUntilClickable(applyButton).click();
	}

	public void selectPurpose() {
		WebElement element = purposeSpan;

		// Scroll the page to the element
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView();", element);
		waitUntilClickable(purposeSpan).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		List<WebElement> list = purpose_All;
		for (WebElement ele : list) {
			System.out.println("Values " + ele.getAttribute("innerHTML"));
			if (ele.getAttribute("innerHTML").contains("Export")) {
				waitUntilClickable(ele).click();
				System.out.println("Clicked on Export");
				break;
			}
		}
	}

	public void clickOnSaveButton() {
		waitUntilClickable(saveButton).click();
	}

	public void selectEditLink() {
		waitUntilClickable(actionbar).click();
		waitUntilClickable(editLink).click();
	}

	public void changeScheduledActivity() {
		waitUntilClickable(scheduledActivitySpan).click();
		List<WebElement> list = scheduledActivity_All;
		for (WebElement ele : list) {
			System.out.println("Values " + ele.getAttribute("innerHTML"));
			if (ele.getAttribute("innerHTML").contains("Next scheduled Site visit")) {
				waitUntilClickable(ele).click();
				System.out.println("Clicked on Next scheduled Site visit");
				break;
			}
		}
	}

	public void changePurpose() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", purposeSpan);
		WebElement element = purposeSpan;
		waitUntilClickable(element).click();
		List<WebElement> list = purpose_All;
		for (WebElement ele : list) {
			System.out.println("Values " + ele.getAttribute("innerHTML"));
			if (ele.getAttribute("innerHTML").contains("Sales")) {
				waitUntilClickable(ele).click();
				System.out.println("Clicked on Sales");
				break;
			}
		}
	}

	public void changeListName(String listName) {
		name.clear();
		waitUntilVisiblity(name).sendKeys(listName);
	}
}
