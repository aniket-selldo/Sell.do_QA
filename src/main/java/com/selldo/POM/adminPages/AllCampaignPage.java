package com.selldo.POM.adminPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selldo.Utility.ReusableUtils;

public class AllCampaignPage extends ReusableUtils {

	public WebDriver driver;

	public AllCampaignPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//a[@id='btn-new-campaign']")
	private WebElement newCampaignButton;
	@FindBy(how = How.XPATH, using = "//i[@class='ion-funnel']")
	private WebElement funnelIcon;
	@FindBy(how = How.XPATH, using = "//input[@name='search_params[search_string]']")
	private WebElement searchCampaignField;
	@FindBy(how = How.XPATH, using = "//span[text()='Select Status']")
	private WebElement selectStatusField;
	@FindBy(how = How.XPATH, using = "")
	private WebElement inactive;
	@FindBy(how = How.XPATH, using = "//input[@name='commit']")
	private WebElement applyButton;
	@FindBy(how = How.XPATH, using = "//a[text()='Clear All']")
	private WebElement clearAllLink;
	@FindBy(how = How.XPATH, using = "//th[text()='Actions']/following::a[@id='btn-actions'][1]")
	private WebElement actionBar;
	@FindBy(how = How.XPATH, using = "//th[text()='Actions']/following::a[text()='URLs'][1]")
	private WebElement urls;
	@FindBy(how = How.XPATH, using = "//th[text()='Actions']/following::a[@class='deactivate_link dropdown-item'][1]")
	private WebElement deactivateCampaign;
	@FindBy(how = How.CSS, using = "div.dropdown-menu.dropdown-menu-right.show .reactivate_link.dropdown-item")
	private WebElement reactivateCampaign;
	@FindBy(how = How.XPATH, using = "//th[text()='Actions']/following::a[@title='View Campaign Report'][1]")
	private WebElement viewCampaignReport;
	@FindBy(how = How.XPATH, using = "//a[@class='next page-link']/preceding::a[1]")
	private WebElement linkTo2ndLastPage;
	// ROI Configuration
	@FindBy(how = How.XPATH, using = "//th[text()='Actions']/following::a[@title='ROI configurations'][1]")
	private WebElement roiConfiguration;
	@FindBy(how = How.XPATH, using = "//a[text()='Add New Configuration']")
	private WebElement addNewConfigurationButton;
	@FindBy(how = How.XPATH, using = "//span[text()='Select Source']")
	private WebElement source_NewRoiConfig;
	@FindBy(how = How.CSS, using = "body > div.select2-drop.select2-display-none.select2-with-searchbox.select2-drop-active > ul")
	private WebElement sourcedd_NewRoiConfig;
	@FindBy(how = How.XPATH, using = "//label[text()='Sub source']/following::input[1]")
	private WebElement subSource_NewRoiConfig;
	@FindBy(how = How.CSS, using = "#s2id_autogen7")
	private WebElement subSource_EditRoiConfig;
	@FindBy(how = How.XPATH, using = "//a[@class='select2-search-choice-close'][1]")
	private WebElement closeSubSource_NewRoiConfig;
	@FindBy(how = How.CSS, using = "#select2-drop > ul > li:nth-child(2) > div")
	private WebElement subSource_dd_NewRoiConfig;
	@FindBy(how = How.CSS, using = "#roi_config_expected_cpl")
	private List<WebElement> expectedCpl_NewRoiConfig;
	@FindBy(how = How.XPATH, using = "//*[@id=\"roi_config_amount_spend\"]")
	private List<WebElement> amountSpent_NewRoiConfig;
	@FindBy(how = How.XPATH, using = "//label[text()='Start date']/following::input[1]")
	private List<WebElement> startDate_NewRoiConfig;
	@FindBy(how = How.XPATH, using = "//div[@class='datepicker datepicker-dropdown dropdown-menu datepicker-orient-left datepicker-orient-bottom']//tr//td")
	private List<WebElement> wholeCalender_StartDate_NewRoiConfig;
	@FindBy(how = How.XPATH, using = "//label[text()='End date']/following::input[1]")
	private List<WebElement> endDate_NewRoiConfig;
	@FindBy(how = How.XPATH, using = "//div[@class='datepicker datepicker-dropdown dropdown-menu datepicker-orient-left datepicker-orient-bottom']//tr//td")
	private List<WebElement> wholeCalender_EndDate_NewRoiConfig;
	@FindBy(how = How.XPATH, using = "//input[@type='submit']")
	private List<WebElement> saveButton_NewRoiConfig;
	@FindBy(how = How.XPATH, using = "//th[text()='Actions']/following::a[1]")
	private WebElement actionBar_NewRoiConfig;
	@FindBy(how = How.XPATH, using = "//th[text()='Actions']/following::a[@class='dropdown-item edit_roi_link']")
	private WebElement edit_NewRoiConfig;
	@FindBy(how = How.XPATH, using = "//th[text()='Actions']/following::a[text()='Delete'][1]")
	private WebElement delete_NewRoiConfig;

	public void clickOnNewCampaignButton() {
		waitUntilClickable(newCampaignButton).click();
	}

	public void clickOnFunnelIcon() {
		waitUntilClickable(funnelIcon).click();
	}

	public void enterCampaignName(String campaignName) {
		waitUntilVisiblity(searchCampaignField).sendKeys(campaignName);
	}

	public void clickOnApplyButton() {
		waitUntilClickable(applyButton).click();
	}

	public void deactivateCampaign() {
		waitUntilClickable(actionBar).click();
		waitUntilClickable(deactivateCampaign).click();
		wait(2000);
		waitUntilAlertVisible(driver).accept();
	}

	public void reactivateCampaign() {
		waitUntilClickable(actionBar).click();
		waitUntilClickable(reactivateCampaign).click();
		wait(2000);
		waitUntilAlertVisible(driver).accept();
	}

	public void selectRoiConfigution() {
		waitUntilClickable(actionBar).click();
		waitUntilClickable(roiConfiguration).click();
	}

	public void clickOnClearAllLink() {
		waitUntilClickable(clearAllLink).click();
	}

	public void goingTo2ndLastPage() {
		waitUntilClickable(linkTo2ndLastPage).click();
	}

	// .................Adding new ROI Config.................

	public void clickOnAddNewConfigButton() {
		waitUntilClickable(addNewConfigurationButton).click();
	}

	public void selectSource() {
		waitUntilClickable(source_NewRoiConfig).click();
		waitUntilClickable(sourcedd_NewRoiConfig).click();
	}

	public void selectSubSource() {
		waitUntilClickable(subSource_NewRoiConfig).click();
		waitUntilClickable(subSource_dd_NewRoiConfig).click();
	}

	public void enterExpectedCpl(String expCpl) {
		expectedCpl_NewRoiConfig.clear();
		waitUntilVisiblity(expectedCpl_NewRoiConfig.get(0)).sendKeys(expCpl);
	}

	public void enterAmountSpent(String amount) {
		amountSpent_NewRoiConfig.clear();
		waitUntilVisiblity(amountSpent_NewRoiConfig.get(0)).sendKeys(amount);
	}

	public void selectStartDate() throws Exception {
		Thread.sleep(2000);
		waitUntilClickable(startDate_NewRoiConfig.get(0)).click();
		List<WebElement> dates = wholeCalender_StartDate_NewRoiConfig;
		int total_node = dates.size();
		for (int i = 0; i < total_node; i++) {
			String date = dates.get(i).getText();
			if (date.equals("2")) {
				waitUntilClickable(dates.get(i)).click();// Clicking on above selected date
				break;
			}
		}
	}

	public void selectEndDate() throws Exception {
		Thread.sleep(2000);
		waitUntilClickable(endDate_NewRoiConfig.get(0)).click();
		List<WebElement> dates = wholeCalender_EndDate_NewRoiConfig;
		int total_node = dates.size();
		for (int i = 0; i < total_node; i++) {
			String date = dates.get(i).getText();
			if (date.equals("12")) {
				waitUntilClickable(dates.get(i)).click();// Clicking on above selected date
				break;
			}
		}
	}

	public void clickOnSaveButton() {
		waitUntilClickable(saveButton_NewRoiConfig.get(0)).click();
	}

	// .................Editing the ROI Config...............

	public void changeSubSource() throws Exception {
		waitUntilClickable(closeSubSource_NewRoiConfig).click();
		waitUntilClickable(subSource_EditRoiConfig).click();
		waitUntilClickable(subSource_dd_NewRoiConfig).click();
	}

	public void changeExpectedCpl(String expCpl) {
		boolean isEnable;
		isEnable = expectedCpl_NewRoiConfig.get(0).isEnabled();
		System.out.println(isEnable);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int size = expectedCpl_NewRoiConfig.size();
		expectedCpl_NewRoiConfig.get(size - 1).clear();
		expectedCpl_NewRoiConfig.get(size - 1).sendKeys(expCpl);
	}

	public void changeAmountSpent(String amount) {
		boolean isEnable;
		isEnable = amountSpent_NewRoiConfig.get(0).isEnabled();
		System.out.println(isEnable);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Here size -1 need to used to get the element as the element is no visible
		int size = amountSpent_NewRoiConfig.size();
		amountSpent_NewRoiConfig.get(size - 1).clear();
		waitUntilVisiblity(amountSpent_NewRoiConfig.get(size - 1)).sendKeys(amount);

	}

	public void changeStartDate() throws Exception {
		Thread.sleep(2000);
		int size = startDate_NewRoiConfig.size();
		waitUntilClickable(startDate_NewRoiConfig.get(size - 1)).click();
		int size2 = wholeCalender_StartDate_NewRoiConfig.size();
		List<WebElement> dates = wholeCalender_StartDate_NewRoiConfig;
		int total_node = dates.size();
		for (int i = 0; i < total_node; i++) {
			String date = dates.get(i).getText();
			if (date.equals("5")) {
				waitUntilClickable(dates.get(i)).click();// Clicking on above selected date
				break;
			}
		}
	}

	public void changeEndDate() throws Exception {
		Thread.sleep(2000);
		int size = endDate_NewRoiConfig.size();
		waitUntilClickable(endDate_NewRoiConfig.get(size - 1)).click();
		List<WebElement> dates = wholeCalender_EndDate_NewRoiConfig;
		int total_node = dates.size();
		for (int i = 0; i < total_node; i++) {
			String date = dates.get(i).getText();
			if (date.equals("10")) {
				waitUntilClickable(dates.get(i)).click();// Clicking on above selected date
				break;
			}
		}
	}

	public void saveEditConfig() {
		int size = saveButton_NewRoiConfig.size();
		waitUntilClickable(saveButton_NewRoiConfig.get(size - 1)).click();
	}

	public void selectEdit_NewRoiConfig() {
		waitUntilClickable(actionBar_NewRoiConfig).click();
		waitUntilClickable(edit_NewRoiConfig).click();
	}

	public void selectDelete_NewRoiConfig() {
		waitUntilClickable(actionBar_NewRoiConfig).click();
		waitUntilClickable(delete_NewRoiConfig).click();
	}
}
