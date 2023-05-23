package com.selldo.POM.adminPages;

import java.util.List;

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
	@FindBy(how = How.ID, using = "bookings_search_criterium_name")
	private WebElement name;
	@FindBy(how = How.XPATH, using = "//input[@id='s2id_autogen2']")
	private WebElement projectsSpan;
	@FindBy(how = How.CSS, using = "div#select2-drop ul li:nth-child(1) div")
	private WebElement selectDropdownValue;
	@FindBy(how = How.XPATH, using = "//ul[@class='select2-results']//li")
	private List<WebElement> project_All;
	@FindBy(how = How.XPATH, using = "//*[@id=\"s2id_autogen3\"]")
	private WebElement campaignSpan;
	@FindBy(how = How.XPATH, using = "//ul[@class='select2-results']//li")
	private List<WebElement> campaign_All;
	@FindBy(how = How.XPATH, using = "//*[@id=\"s2id_autogen4\"]")
	private WebElement publishersSpan;
	@FindBy(how = How.XPATH, using = "//ul[@class='select2-results']/li")
	private List<WebElement> publishers_All;
	@FindBy(how = How.XPATH, using = "//input[@id='bookings_search_criterium_sub_sources']")
	private WebElement subCampaign;
	@FindBy(how = How.XPATH, using = "//input[@id='s2id_autogen5']")
	private WebElement teamSpan;
	@FindBy(how = How.XPATH, using = "//ul[@class='select2-results']//li")
	private List<WebElement> team_All;
	@FindBy(how = How.XPATH, using = "//input[@id='s2id_autogen6']")
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
	@FindBy(how = How.XPATH, using = "//th[text()='Actions']/following::a[text()='Edit'][1]")
	private WebElement editLink;

	public void clickOnNewBookingSearchCriteriaButton() {
		newBookingSearchCriteriaButton.click();
	}

	public void enterBookingListName(String listName) {
		name.sendKeys(listName);
	}

	public void selectProject() {
		projectsSpan.click();
		selectDropdownValue.click();
	}

	public void selectCampaign() {
		campaignSpan.click();
		selectDropdownValue.click();
	}

	public void selectPublishers() {
		publishersSpan.click();
		selectDropdownValue.click();
	}

	public void selectTeams() {
		teamSpan.click();
		selectDropdownValue.click();
	}

	public void selectSales() {
		// Scroll to bottom of page
		scrollIntoView(salesSpan);
		salesSpan.click();
		selectDropdownValue.click();
	}

	public void selectRefundStatus() {
		refundStatusSpan.click();
		List<WebElement> list = refundStatus_All;
		for (WebElement ele : list) {
			System.out.println("Values " + ele.getAttribute("innerHTML"));
			if (ele.getAttribute("innerHTML").contains("Pending")) {
				ele.click();
				System.out.println("Clicked on Pending");
				break;
			}
		}
	}

	public void selectModeOfRefund() {
		modeOfRefundSpan.click();
		List<WebElement> list = modeOfRefund_All;
		for (WebElement ele : list) {
			System.out.println("Values " + ele.getAttribute("innerHTML"));
			if (ele.getAttribute("innerHTML").contains("RTGS")) {
				ele.click();
				System.out.println("Clicked on RTGS");
				break;
			}
		}
	}

	public void clickOnSaveButton() {
		saveButton.click();
	}

	public void selectEditLink() {
		actionbar.click();
		editLink.click();
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

		name.sendKeys(listName);
	}

	public void changeProject() {
		projectsSpan.click();

		List<WebElement> list = project_All;
		for (WebElement ele : list) {
			System.out.println("Values " + ele.getAttribute("innerHTML"));
			if (ele.getAttribute("innerHTML").contains("jagan")) {
				ele.click();
				System.out.println("Clicked on jagan");
				break;
			}
		}
	}

	public void changeCampaign() {
		waitElementToBeClickable(campaignSpan);
		campaignSpan.click();
		List<WebElement> list = campaign_All;
		for (WebElement ele : list) {
			System.out.println("Values " + ele.getAttribute("innerHTML"));
			if (ele.getAttribute("innerHTML").contains("walkin")) {
				ele.click();
				System.out.println("Clicked on walkin");
			}
		}
	}

	public void changePublishers() {
		publishersSpan.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<WebElement> list = publishers_All;
		for (WebElement ele : list) {
			System.out.println("Values " + ele.getAttribute("innerHTML"));
			if (ele.getAttribute("innerHTML").contains("DNA - Online")) {
				ele.click();
				System.out.println("Clicked on DNA online");
				break;
			}
		}
	}

	public void changeTeams() {
		teamSpan.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<WebElement> list = team_All;
		for (WebElement ele : list) {
			System.out.println("Values " + ele.getAttribute("innerHTML"));
			if (ele.getAttribute("innerHTML").contains("Teamwed")) {
				ele.click();
				System.out.println("Clicked on Teamwed");
				break;
			}
		}
	}

	public void changeSales() {
		// Scroll to bottom of page
		scrollIntoView(salesSpan);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		salesSpan.click();
		List<WebElement> list = sales_All;
		for (WebElement ele : list) {
			System.out.println("Values " + ele.getAttribute("innerHTML"));
			if (ele.getAttribute("innerHTML").contains("Sales Manager")) {
				ele.click();
				System.out.println("Clicked on Sales Manager");
				break;
			}
		}
	}

	public void changeRefundStatus() {
		refundStatusSpan.click();
		List<WebElement> list = refundStatus_All;
		for (WebElement ele : list) {
			System.out.println("Values " + ele.getAttribute("innerHTML"));
			if (ele.getAttribute("innerHTML").contains("Refund Done")) {
				ele.click();
				System.out.println("Clicked on Refund Done");
				break;
			}
		}
	}

	public void changeModeOfRefund() {
		modeOfRefundSpan.click();
		List<WebElement> list = modeOfRefund_All;
		for (WebElement ele : list) {
			System.out.println("Values " + ele.getAttribute("innerHTML"));
			if (ele.getAttribute("innerHTML").contains("Cheque")) {
				ele.click();
				System.out.println("Clicked on Cheque");
				break;
			}
		}
	}

}
