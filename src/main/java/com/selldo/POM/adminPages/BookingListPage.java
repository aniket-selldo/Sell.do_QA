package com.selldo.POM.adminPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selldo.Utility.ReusableUtils;

public class BookingListPage extends ReusableUtils {

	public WebDriver driver;

	public BookingListPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[text()='New Booking Search Criteria']")
	private WebElement newBookingSearchCriteriaButton;
	@FindBy(how = How.CSS, using = "#bookings_search_criterium_name")
	private WebElement name;
	@FindBy(how = How.CSS, using = "#s2id_bookings_search_criterium_project_ids")
	private WebElement projectsSpan;
	@FindBy(how = How.CSS, using = "div#select2-drop ul li:nth-child(1) div")
	private WebElement selectDropdownValue;
	@FindBy(how = How.XPATH, using = "//ul[@class='select2-results']//li")
	private List<WebElement> project_All;
	@FindBy(how = How.CSS, using = "#s2id_bookings_search_criterium_campaign_ids")
	private WebElement campaignSpan;
	@FindBy(how = How.XPATH, using = "//ul[@class='select2-results']//li")
	private List<WebElement> campaign_All;
	@FindBy(how = How.CSS, using = "#s2id_bookings_search_criterium_sources")
	private WebElement publishersSpan;
	@FindBy(how = How.XPATH, using = "//ul[@class='select2-results']/li")
	private List<WebElement> publishers_All;
	@FindBy(how = How.XPATH, using = "//input[@id='bookings_search_criterium_sub_sources']")
	private WebElement subCampaign;
	@FindBy(how = How.CSS, using = "#s2id_bookings_search_criterium_team_ids")
	private WebElement teamSpan;
	@FindBy(how = How.XPATH, using = "//ul[@class='select2-results']//li")
	private List<WebElement> team_All;
	@FindBy(how = How.CSS, using = "#s2id_bookings_search_criterium_sales_ids")
	private WebElement salesSpan;
	@FindBy(how = How.XPATH, using = "//ul[@class='select2-results']//li")
	private List<WebElement> sales_All;
	@FindBy(how = How.CSS, using = "#bookings_search_criterium_booking_custom_attributes_refund_status")
	private WebElement refundStatusSpan;
	@FindBy(how = How.XPATH, using = "//ul[@class='select2-results']/li/div")
	private List<WebElement> refundStatus_All;
	@FindBy(how = How.CSS, using = "#bookings_search_criterium_booking_custom_attributes_mode_of_refund")
	private WebElement modeOfRefundSpan;
	@FindBy(how = How.XPATH, using = "//ul[@class='select2-results']/li")
	private List<WebElement> modeOfRefund_All;
	@FindBy(how = How.XPATH, using = "//input[@type='submit']")
	private WebElement saveButton;
	@FindBy(how = How.XPATH, using = "//th[text()='Actions']/following::i[1]")
	private WebElement actionbar;
	@FindBy(how = How.LINK_TEXT, using = "Edit")
	private WebElement editLink;
	@FindBy(how = How.CSS, using = "table tbody tr:nth-child(1) td:nth-child(1)")
	private WebElement getListName;
	public String getListName() {
		return waitUntilClickable(getListName).getText().trim();
	}

	public void clickOnNewBookingSearchCriteriaButton() {
		waitUntilClickable(newBookingSearchCriteriaButton).click();
	}

	public void enterBookingListName(String listName) {
		waitUntilVisiblity(name).sendKeys(listName);
	}

	public void selectProject() {
		waitUntilClickable(projectsSpan).click();
		waitUntilClickable(selectDropdownValue).click();

	}

	public void selectCampaign() {
		waitUntilClickable(campaignSpan).click();
		waitUntilClickable(selectDropdownValue).click();
	}

	public void selectPublishers() {
		waitUntilClickable(publishersSpan).click();
		waitUntilClickable(selectDropdownValue).click();
	}

	public void selectTeams() {
		waitUntilClickable(teamSpan).click();
		waitUntilClickable(selectDropdownValue).click();
	}

	public void selectSales() {
		// Scroll to bottom of page
		scrollIntoView(salesSpan);
		waitUntilClickable(salesSpan).click();;
		waitUntilClickable(selectDropdownValue).click();
	}

	public void selectRefundStatus() {
		waitUntilClickable(refundStatusSpan).click();
		List<WebElement> list = refundStatus_All;
		for (WebElement ele : list) {
			if (ele.getAttribute("innerHTML").contains("Pending")) {
				waitUntilClickable(ele).click();
				break;
			}
		}
	}

	public void selectModeOfRefund() {
		waitUntilClickable(modeOfRefundSpan).click();
		List<WebElement> list = modeOfRefund_All;
		for (WebElement ele : list) {
			if (ele.getAttribute("innerHTML").contains("RTGS")) {
				waitUntilClickable(ele).click();
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
		wait(2000);
	}

	public void changeBookingListName(String listName) {
		moveToElement(name);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		name.clear();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		waitUntilVisiblity(name).sendKeys(listName);
	}

	public void changeProject() {
		waitUntilClickable(projectsSpan).click();

		List<WebElement> list = project_All;
		for (WebElement ele : list) {
			if (ele.getAttribute("innerHTML").contains("jagan")) {
				waitUntilClickable(ele).click();
				break;
			}
		}
	}

	public void changeCampaign() {
		waitUntilClickable(campaignSpan).click();
		List<WebElement> list = campaign_All;
		for (WebElement ele : list) {
			if (ele.getAttribute("innerHTML").contains("walkin")) {
				waitUntilClickable(ele).click();
			}
		}
	}

	public void changePublishers() {
		waitUntilClickable(publishersSpan).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<WebElement> list = publishers_All;
		for (WebElement ele : list) {
			if (ele.getAttribute("innerHTML").contains("DNA - Online")) {
				waitUntilClickable(ele).click();
				break;
			}
		}
	}

	public void changeTeams() {
		waitUntilClickable(teamSpan).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
				waitUntilClickable(driver.findElement(By.cssSelector("#select2-drop"))).click();
				
			
		
	}

	public void changeSales() {
		// Scroll to bottom of page
		scrollIntoView(salesSpan);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		waitUntilClickable(salesSpan).click();
		waitUntilClickable(driver.findElements(By.cssSelector("[class='select2-results-dept-0 select2-result select2-result-selectable']")).get(0)).click();
	}

	public void changeRefundStatus() {
		waitUntilClickable(refundStatusSpan).click();
		List<WebElement> list = refundStatus_All;
		for (WebElement ele : list) {
			if (ele.getAttribute("innerHTML").contains("Refund Done")) {
				waitUntilClickable(ele).click();
				break;
			}
		}
	}

	public void changeModeOfRefund() {
		waitUntilClickable(modeOfRefundSpan).click();
		List<WebElement> list = modeOfRefund_All;
		for (WebElement ele : list) {
			if (ele.getAttribute("innerHTML").contains("Cheque")) {
				waitUntilClickable(ele).click();
				break;
			}
		}
	}

}
