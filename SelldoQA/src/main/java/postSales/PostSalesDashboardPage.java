package postSales;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selldo.Utility.ReusableUtils;

public class PostSalesDashboardPage extends ReusableUtils {

	public WebDriver driver;

	public PostSalesDashboardPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.CSS, using = "#select2-drop > div > input")
	private WebElement searchTextBox;
	@FindBy(how = How.XPATH, using = "//span[text()='Search...']")
	private WebElement searchField;
	@FindBy(how = How.XPATH, using = "//i[@class='ion-edit mr-0']")
	private WebElement editIcon;
	@FindBy(how = How.XPATH, using = "//a[@class='nav-link'][contains(text(),'Onkar Gosavi')]")
	private WebElement primaryApplicant;
	@FindBy(how = How.XPATH, using = "//i[@class='ion-refresh refresh-post-sales-dashboard']")
	private WebElement refreshIcon;
	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-primary submit_form']")
	private WebElement closeButton;
	// ........ Booking Details Bucket .........
	@FindBy(how = How.XPATH, using = "//div[text()='Confirmed Booking Details']/following::span[1]")
	private WebElement confirmedBookingsBucket;
	@FindBy(how = How.XPATH, using = "//div[text()='Tentative Booking Details']/following::span[1]")
	private WebElement tentativeBookingsBucket;
	@FindBy(how = How.XPATH, using = "//div[text()='Cancelled Booking Details']/following::span[1]")
	private WebElement cancelledBookingsBucket;
	// ........ Demand Letters Bucket .........
	@FindBy(how = How.XPATH, using = "//div[text()='Draft']/following::span[1]")
	private WebElement draftDemandLetterBucket;
	@FindBy(how = How.XPATH, using = "//div[text()='Delivered']/following::span[1]")
	private WebElement deliveredDemandLetterBucket;
	@FindBy(how = How.XPATH, using = "//div[text()='Partially Paid']/following::span[1]")
	private WebElement partiallyPaidDemandLetterBucket;
	@FindBy(how = How.XPATH, using = "//div[text()='Paid']/following::span[1]")
	private WebElement paidDemandLetterBucket;
	@FindBy(how = How.XPATH, using = "//div[text()='Due']/following::span[1]")
	private WebElement dueDemandLetterBucket;
	// ........ Receipts Bucket .........
	@FindBy(how = How.XPATH, using = "//div[text()='Clearance Pending']/following::span[1]")
	private WebElement clearancePendingReceiptBucket;
	@FindBy(how = How.XPATH, using = "//div[text()='Successful']/following::span[1]")
	private WebElement successfulReceiptBucket;
	@FindBy(how = How.XPATH, using = "//div[text()='Failed']/following::span[1]")
	private WebElement failedReceiptBucket;
	@FindBy(how = How.XPATH, using = "//div[text()='Available for Refund']/following::span[1]")
	private WebElement availableForRefundReceiptBucket;
	@FindBy(how = How.XPATH, using = "//div[text()='Refunded']/following::span[1]")
	private WebElement refundedReceiptBucket;
	// ........ Missed FollowUps Bucket .........
	@FindBy(how = How.XPATH, using = "//div[text()='missed followups']")
	private WebElement missedFollowups;
	@FindBy(how = How.XPATH, using = "//div[@class='dashboard-right-pane col-sm-3 col-md-3 col-lg-3 full-height']//div[3]//div[1]//div[1]//div[3]//h4")
	private WebElement missedFollowUps;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Open Tasks')]")
	private WebElement openTasksLink;
	@FindBy(how = How.XPATH, using = "//a[@class='table-action-btn dropdown-toggle btn btn-light btn-sm']")
	private WebElement actionBar;
	@FindBy(how = How.XPATH, using = "//button[@class='dropdown-item booking-details-view link']")
	private WebElement details;
	@FindBy(how = How.XPATH, using = "//a[contains(@class,'followup')]")
	private WebElement followupLink;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Home')]")
	private WebElement homeButton;

//	GetTestData getTestData = new GetTestData();

	// To Search Lead
	public void searchLead(String lead) throws Exception {
			Thread.sleep(2000);
			searchField.click();
			Thread.sleep(2000);
			WebElement webElement = searchTextBox;
			webElement.sendKeys(lead);
			Thread.sleep(4000);
			webElement.sendKeys(Keys.ENTER);// Clicking enter
		}

	public void clickOnEditIcon() {
			
			editIcon.click();
			
			// To click the primary applicant tab
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("arguments[0].scrollIntoView(false);",primaryApplicant);
		    primaryApplicant.click();
		 
		}

	public void clickOnCloseButton() {
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("arguments[0].scrollIntoView(false);",closeButton);
			closeButton.click();
		}

	public void refreshDashboardStats() {
		refreshIcon.click();
	}

	public void clickOnConfirmedBookingsBucket() {
		confirmedBookingsBucket.click();
	}

	public void clickOnTentativeBookingsBucket() {
		tentativeBookingsBucket.click();
	}

	public void clickOnCancelledBookingsBucket() {
		cancelledBookingsBucket.click();
	}

	public void clickOnDraftDemandLetterBucket() {
		draftDemandLetterBucket.click();
	}

	public void clickOnDeliveredDemandLetterBucket() {
		deliveredDemandLetterBucket.click();
	}

	public void clickOnPartiallyPaidBucket() {
		partiallyPaidDemandLetterBucket.click();
	}

	public void clickOnPaidDemandLetterBucket() {
		paidDemandLetterBucket.click();
	}

	public void clickOnDueDemandLetterBucket() {
		dueDemandLetterBucket.click();
	}

	public void clickOnClearancePendingReceiptBucket() {
		clearancePendingReceiptBucket.click();
	}

	public void clickOnSuccessfulReceiptBucket() {
		successfulReceiptBucket.click();
	}

	public void clickOnFailedReceiptBucket() {
		failedReceiptBucket.click();
	}

	public void clickOnAvailableForRefundReceiptBucket() {
		availableForRefundReceiptBucket.click();
	}

	public void clickOnRefundedReceiptBucket() {
		refundedReceiptBucket.click();
	}

	public void clickOnMissedFollowupBucket() {
		openTasksLink.click();
		missedFollowups.click();
	}

	public void openLeadProfile() throws Exception {
		Thread.sleep(3000);
		actionBar.click();

		details.click();

	}

	public void followupLink() {
		followupLink.click();
	}

	public void clickOnHomeButton() {
		homeButton.click();
	}
}
