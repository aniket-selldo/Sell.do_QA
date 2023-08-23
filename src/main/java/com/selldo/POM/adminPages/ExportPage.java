package com.selldo.POM.adminPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selldo.Utility.ReusableUtils;

public class ExportPage extends ReusableUtils {
	public WebDriver driver;

	public ExportPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//span[text()='Export Leads']")
	private WebElement exportLeadsTab;
	@FindBy(how = How.XPATH, using = "//span[text()='Export Tasks']")
	private WebElement exportTasksTab;
	@FindBy(how = How.XPATH, using = "//span[text()='Export Users']")
	private WebElement exportUsersTab;
	@FindBy(how = How.XPATH, using = "//span[text()='Export User Logs']")
	private WebElement exportUserLogsTab;
	@FindBy(how = How.XPATH, using = "//span[text()='Export Virtual Numbers']")
	private WebElement exportVirtualNumbersTab;
	@FindBy(how = How.XPATH, using = "//span[text()='Export Booking Details']")
	private WebElement exportBookingsTab;
	@FindBy(how = How.XPATH, using = "//span[text()='Export Campaigns']")
	private WebElement exportCampaignsTab;
	@FindBy(how = How.XPATH, using = "//span[text()='Export Invoices']")
	private WebElement exportInvoicesTab;
	@FindBy(how = How.XPATH, using = "//span[text()='Export Calls']")
	private WebElement exportCallsTab;
	@FindBy(how = How.XPATH, using = "//span[text()='Export Site Visits']")
	private WebElement exportSiteVisitsTab;
	@FindBy(how = How.XPATH, using = "//span[text()='Export Followups']")
	private WebElement exportFollowupsTab;
	@FindBy(how = How.XPATH, using = "//span[text()='Export Partners']")
	private WebElement exportPartnersTab;
	@FindBy(how = How.XPATH, using = "//span[text()='Export Project Units']")
	private WebElement exportProjectUnitsTab;
	@FindBy(how = How.XPATH, using = "//span[text()='Export Lead Projects']")
	private WebElement exportProjectsTab;
	@FindBy(how = How.XPATH, using = "//input[@name='created_at']")
	private WebElement duration;
	@FindBy(how = How.CSS, using = "li.select2-search-field input")
	private List<WebElement> role;
	@FindBy(how = How.XPATH, using = "//span[text()='Project']")
	private WebElement projectField;
	@FindBy(how = How.XPATH, using = "//input[@class='select2-input']/following::ul[@class='select2-results']//li[3]")
	private WebElement project_dd;
	@FindBy(how = How.XPATH, using = "//div[@class='card card-body mb-3'][1]//tr[3]//td[4]/span")
	public WebElement exportStatus;
	@FindBy(how = How.XPATH, using = "//div[@class='card card-body mb-3'][1]//tr//td[4]/span")
	public List<WebElement> getAllexportStatus;
	@FindBy(how = How.XPATH, using = "//div[@class='card card-body mb-3'][1]//tr[2]//td[2]/span")
	public WebElement exportCount;
	@FindBy(how = How.XPATH, using = "//div[@class='card card-body mb-3'][1]//tr[3]//td[4]/a")
	public WebElement exportFile;
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Completed')]")
	private WebElement userLogExportStatus;
	@FindBy(how = How.XPATH, using = "//div[@class='ranges']//ul//li")
	private List<WebElement> calenderRange_ExportLead;
	@FindBy(how = How.XPATH, using = "//div[@id='select2-drop']//ul//li")
	private List<WebElement> roleDropDown;
	@FindBy(how = How.XPATH, using = "//input[contains(@id,'s2id_autogen4')]")
	private WebElement email;
	@FindBy(how = How.XPATH, using = ".//*[@id='select2-drop']/ul/li[1]/div")
	private WebElement selectEmail;
	@FindBy(how = How.XPATH, using = "//label[text()='Campaign']/following::input[1]")
	private WebElement campaignSpan;
	@FindBy(how = How.CSS, using = "#select2-drop ul li:nth-child(1) div")
	private WebElement selectcampaign;
	@FindBy(how = How.XPATH, using = "//ul[@class='select2-results']//li")
	private WebElement campaign_All;
	@FindBy(how = How.XPATH, using = "//span[text()='invoice']")
	private WebElement invoicesSpan;
	@FindBy(how = How.CSS, using = "#select2-drop ul li:nth-child(1) div")
	private WebElement selectInvoice;
	@FindBy(how = How.XPATH, using = "//ul[@class='select2-results']//li")
	private List<WebElement> invoice_All;
	@FindBy(how = How.XPATH, using = "//span[text()='Type']")
	private WebElement invoiceTypeSpan;
	@FindBy(how = How.XPATH, using = "//ul[@class='select2-results']//li")
	private List<WebElement> invoiceType_All;
	@FindBy(how = How.CSS, using = "#btn-export")
	private WebElement exportButton;
	@FindBy(how = How.XPATH, using = "//input[@value='Next >>']")
	private WebElement NextButton;
	@FindBy(how = How.XPATH, using = "//span[text()='Export History']")
	private WebElement exportHistoryTab;
	@FindBy(how = How.XPATH, using = "//i[@class='ion-funnel']")
	private WebElement funnelIcon;
	@FindBy(how = How.XPATH, using = "//input[@name='filters[created_at]']")
	private WebElement createdAtField;
	@FindBy(how = How.XPATH, using = "//div[@class='daterangepicker dropdown-menu opensleft']//ul//li")
	private List<WebElement> createdAtField_All;
	@FindBy(how = How.XPATH, using = "//label[text()='Export Type']/following::span[1]")
	private WebElement exportTypeSpan;
	@FindBy(how = How.XPATH, using = "//ul[@class='select2-results']//li")
	private List<WebElement> exportTypeSpan_All;
	@FindBy(how = How.XPATH, using = "//input[@value='Apply']")
	private WebElement applyButton;
	@FindBy(how = How.XPATH, using = "//a[text()='Clear All']")
	private WebElement clearAllLink;
	@FindBy(how = How.XPATH, using = "//button[@class='close']//i[@class='ion-android-close']")
	private WebElement crossExportIcon;
	@FindBy(how = How.XPATH, using = "//input[@value='Apply']/preceding::i[@class='ion-android-close'][1]")
	private WebElement crossFilterIcon;
	@FindBy(how = How.XPATH, using = "//a[text()='Home']/following::b[1]")
	private WebElement clickToExpandLink;
	@FindBy(how = How.CSS, using = "div#select2-drop ul li:nth-child(17)")
	private WebElement selectProject;
	@FindBy(how = How.CSS, using = "h6#export_type")
	public List<WebElement> exportLabel;
	@FindBy(how = How.CSS, using = "div.table-filter-container.pt-2 table tbody tr:nth-child(2) td:nth-child(6) span")
	public WebElement emailIdField;

	public String getEmailAttribute() {
		return Square(emailIdField).getText().trim();
	}

	public boolean getFileDisplayedOrNot() {
		try {
			boolean b = exportFile.isDisplayed();
			Square(exportFile);
			return b;
		} catch (Exception e) {
			// e.printStackTrace();
			return false;
		}

	}

	public int getExportCount() {
		return Integer.parseInt(Square(exportCount).getText().trim());
	}

	public String getExportLabel() {
		return Square(exportLabel.get(0)).getText().trim();
	}

	public String getExportStatus() {
		waitUntilVisiblity(exportStatus);
		try {
			waitUntilVisiblity(exportStatus);
			return Square(exportStatus).getText().trim();
		} catch (Exception e) {
			return "";
		}
	}
	public boolean getExportStatus_vlaidateAll() {
		long count =getAllexportStatus.stream().filter(S->S.getText().trim().equalsIgnoreCase("completed")).count();
		if(count>=1) {
			return true;
		}
		else return false;
	}

	public void clickOnExportLeadsTab() {
		waitUntilClickable(exportLeadsTab);
		exportLeadsTab.click();
	}

	public void clickOnExportTasksTab() {
		waitUntilClickable(exportTasksTab);
		exportTasksTab.click();
	}

	public void clickOnExportUsersTab() {
		waitUntilClickable(exportUsersTab);
		exportUsersTab.click();
	}

	public void clickOnExportUserLogsTab() {
		waitUntilClickable(exportUserLogsTab);
		exportUserLogsTab.click();
	}

	public void clickOnExportVirtualNumbersTab() {
		waitUntilClickable(exportVirtualNumbersTab);
		exportVirtualNumbersTab.click();
	}

	public void clickOnExportBookingsTab() {
		// scrollIntoView(exportBookingsTab);
		waitUntilClickable(exportBookingsTab);
		exportBookingsTab.click();
	}

	public void clickOnExportCampaignsTab() {
		waitUntilClickable(exportCampaignsTab);
		exportCampaignsTab.click();
	}

	public void clickOnExportInvoicesTab() {
		waitUntilClickable(exportInvoicesTab);
		exportInvoicesTab.click();
	}

	public void clickOnExportCallsTab() {
		waitUntilClickable(exportCallsTab);
		exportCallsTab.click();
	}

	public void clickOnExportSiteVisitsTab() {
		waitUntilClickable(exportSiteVisitsTab);
		exportSiteVisitsTab.click();
	}

	public void clickOnExportFollowupsTab() {
		// scrollIntoView(exportFollowupsTab);
		waitUntilClickable(exportFollowupsTab);
		exportFollowupsTab.click();
	}

	public void clickOnExportChannelPartnersTab() {
		waitUntilClickable(exportFollowupsTab);
		exportFollowupsTab.click();
	}

	public void clickOnExportHistoryTab() {
		scrollIntoView(exportHistoryTab);
		waitUntilClickable(exportHistoryTab);
		wait(200);
		exportHistoryTab.click();
	}

	public void clickOnExportPartnersTab() {
		waitUntilClickable(exportPartnersTab);
		exportPartnersTab.click();
	}

	public void clickOnExportProjectUnitsTab() {
		waitUntilClickable(exportProjectUnitsTab);
		exportProjectUnitsTab.click();
	}

	public void clickOnExportProjectsTab() {
		waitUntilClickable(exportProjectsTab);
		exportProjectsTab.click();
	}

	public void selectDuration() {
		waitUntilClickable(duration);
		duration.click();
		wait(100);
		List<WebElement> list = calenderRange_ExportLead;
		for (WebElement ele : list)
		{
			if (ele.getAttribute("innerHTML").contains("Last 7 Days")) {
				waitUntilClickable(ele);
				wait(100);
				ele.click();
				break;
			}
		}
	}

	public void selectRole() {
		waitUntilClickable(role.get(0));
		role.get(0).click();
		waitUntilVisibilityOfElements(roleDropDown);
		List<WebElement> list = roleDropDown;
		for (WebElement ele : list)

		{
			if (ele.getAttribute("innerHTML").contains("Sales")) {
				waitUntilClickable(ele);
				ele.click();
				break;
			}
		}
	}

	public void enterEmail(String em) {
		waitUntilVisiblity(email);
		email.sendKeys(em);
		waitUntilClickable(selectEmail);
		selectEmail.click();
	}

	public void selectInvoice(String em) {
		waitUntilClickable(invoicesSpan);
		invoicesSpan.click();
		waitUntilClickable(selectInvoice);
		selectInvoice.click();
	}

	public void selectInvoice() {
		waitUntilClickable(invoicesSpan);
		invoicesSpan.click();
		waitUntilVisibilityOfElements(invoice_All);
		List<WebElement> list = invoice_All;
		for (WebElement ele : list) {
			if (ele.getAttribute("innerHTML").contains("ADPL-23886097720170421 (01/01/2017 - 22/04/2017)")) {
				waitUntilClickable(ele);
				ele.click();
				break;
			}
		}
	}

	public void selectInvoiceType_MarketingActivity() {
		waitUntilClickable(invoiceTypeSpan);
		invoiceTypeSpan.click();
		waitUntilVisibilityOfElements(invoiceType_All);
		List<WebElement> list = invoiceType_All;
		for (WebElement ele : list) {
			if (ele.getAttribute("innerHTML").contains("Marketing Activity")) {
				waitUntilClickable(ele);
				ele.click();
				break;
			}
		}
	}

	public void selectInvoiceType_Sms() {
		waitUntilClickable(invoiceTypeSpan);
		invoiceTypeSpan.click();
		waitUntilVisibilityOfElements(invoiceType_All);
		List<WebElement> list = invoiceType_All;
		for (WebElement ele : list) {
			if (ele.getAttribute("innerHTML").contains("Sms")) {
				waitUntilClickable(ele);
				ele.click();
				break;
			}
		}
	}

	public void selectInvoiceType_Email() {
		waitUntilClickable(invoiceTypeSpan);
		invoiceTypeSpan.click();
		waitUntilVisibilityOfElements(invoiceType_All);
		List<WebElement> list = invoiceType_All;
		for (WebElement ele : list) {
			if (ele.getAttribute("innerHTML").contains("Email")) {
				waitUntilClickable(ele);
				ele.click();
				break;
			}
		}
	}

	public void selectInvoiceType_Call() {
		waitUntilClickable(invoiceTypeSpan);
		invoiceTypeSpan.click();
		waitUntilVisibilityOfElements(invoiceType_All);
		List<WebElement> list = invoiceType_All;
		for (WebElement ele : list) {
			if (ele.getAttribute("innerHTML").contains("Call")) {
				waitUntilClickable(ele);
				ele.click();
				break;
			}
		}
	}

	public void clickOnExportButton() {
		scrollIntoView(exportButton);
		wait(100);
		waitUntilClickable(exportButton);
		exportButton.click();

	}

	public void clickOnNextButton() {
		scrollIntoView(NextButton);
		waitUntilClickable(NextButton);
		NextButton.click();

	}

	public void clickOnFunnelIcon() {
		waitUntilClickable(funnelIcon);
		funnelIcon.click();
	}

	public void selectCreatedAtDateRange() {
		waitUntilClickable(createdAtField);
		createdAtField.click();
		waitUntilVisibilityOfElements(createdAtField_All);
		List<WebElement> list = createdAtField_All;
		for (WebElement ele : list)

		{
			if (ele.getAttribute("innerHTML").contains("Today")) {
				waitUntilClickable(ele);
				ele.click();
				break;
			}
		}
	}

	public void selectExportType_ExportLeads() {
		waitUntilClickable(exportTypeSpan);
		exportTypeSpan.click();
		waitUntilVisibilityOfElements(exportTypeSpan_All);
		List<WebElement> list = exportTypeSpan_All;
		for (WebElement ele : list) {
			if (ele.getAttribute("innerHTML").contains("Leads")) {
				waitUntilClickable(ele);
				ele.click();
				break;
			}
		}
	}

	public void selectExportType_ExportTasks() {
		waitUntilClickable(exportTypeSpan);
		exportTypeSpan.click();
		waitUntilVisibilityOfElements(exportTypeSpan_All);
		List<WebElement> list = exportTypeSpan_All;
		for (WebElement ele : list) {
			if (ele.getAttribute("innerHTML").contains("Tasks")) {
				waitUntilClickable(ele);
				ele.click();
				break;
			}
		}
	}

	public void selectExportType_ExportUsers() {
		waitUntilClickable(exportTypeSpan);
		exportTypeSpan.click();
		waitUntilVisibilityOfElements(exportTypeSpan_All);
		List<WebElement> list = exportTypeSpan_All;
		for (WebElement ele : list) {
			if (ele.getAttribute("innerHTML").contains("Users")) {
				waitUntilClickable(ele);
				ele.click();
				break;
			}
		}
	}

	public void selectExportType_ExportUserLogs() {
		waitUntilClickable(exportTypeSpan);
		exportTypeSpan.click();
		waitUntilVisibilityOfElements(exportTypeSpan_All);
		List<WebElement> list = exportTypeSpan_All;
		for (WebElement ele : list) {
			if (ele.getAttribute("innerHTML").contains("User Logs")) {
				waitUntilClickable(ele);
				ele.click();
				break;
			}
		}
	}

	public void selectExportType_ExportCalls() {
		waitUntilClickable(exportTypeSpan);
		exportTypeSpan.click();
		waitUntilVisibilityOfElements(exportTypeSpan_All);
		List<WebElement> list = exportTypeSpan_All;
		for (WebElement ele : list) {
			if (ele.getAttribute("innerHTML").contains("Calls")) {
				waitUntilClickable(ele);
				ele.click();
				break;
			}
		}
	}

	public void selectExportType_ExportSiteVisits() {
		waitUntilClickable(exportTypeSpan);
		exportTypeSpan.click();
		waitUntilVisibilityOfElements(exportTypeSpan_All);
		List<WebElement> list = exportTypeSpan_All;
		for (WebElement ele : list) {
			if (ele.getAttribute("innerHTML").contains("Site visit")) {
				waitUntilClickable(ele);
				ele.click();
				break;
			}
		}
	}

	public void selectExportType_ExportFollowups() {
		waitUntilClickable(exportTypeSpan);
		exportTypeSpan.click();
		waitUntilVisibilityOfElements(exportTypeSpan_All);
		List<WebElement> list = exportTypeSpan_All;
		for (WebElement ele : list) {
			if (ele.getAttribute("innerHTML").contains("Followups")) {
				waitUntilClickable(ele);
				ele.click();
				break;
			}
		}
	}

	public void selectExportType_ExportBookings() {
		waitUntilClickable(exportTypeSpan);
		exportTypeSpan.click();
		waitUntilVisibilityOfElements(exportTypeSpan_All);
		List<WebElement> list = exportTypeSpan_All;
		for (WebElement ele : list) {
			if (ele.getAttribute("innerHTML").contains("Booking Detail")) {
				waitUntilClickable(ele);
				ele.click();
				break;
			}
		}
	}

	public void selectExportType_ExportVirtualNumbers() {
		waitUntilClickable(exportTypeSpan);
		exportTypeSpan.click();
		waitUntilVisibilityOfElements(exportTypeSpan_All);
		List<WebElement> list = exportTypeSpan_All;
		for (WebElement ele : list) {
			if (ele.getAttribute("innerHTML").contains("VirtualNumbers")) {
				waitUntilClickable(ele);
				ele.click();
				break;
			}
		}
	}

	public void selectExportType_ExportItemisedBillSms() {
		waitUntilClickable(exportTypeSpan);
		exportTypeSpan.click();
		waitUntilVisibilityOfElements(exportTypeSpan_All);
		List<WebElement> list = exportTypeSpan_All;
		for (WebElement ele : list) {
			if (ele.getAttribute("innerHTML").contains("Itemized Bill(Sms)")) {
				waitUntilClickable(ele);
				ele.click();
				break;
			}
		}
	}

	public void selectExportType_ExportItemisedBillEmail() {
		waitUntilClickable(exportTypeSpan);
		exportTypeSpan.click();
		waitUntilVisibilityOfElements(exportTypeSpan_All);
		List<WebElement> list = exportTypeSpan_All;
		for (WebElement ele : list) {
			if (ele.getAttribute("innerHTML").contains("Itemized Bill(Email)")) {
				waitUntilClickable(ele);
				ele.click();
				break;
			}
		}
	}

	public void selectExportType_ExportItemisedBillCall() {
		waitUntilClickable(exportTypeSpan);
		exportTypeSpan.click();
		waitUntilVisibilityOfElements(exportTypeSpan_All);
		List<WebElement> list = exportTypeSpan_All;
		for (WebElement ele : list) {
			if (ele.getAttribute("innerHTML").contains("Itemized Bill(Call)")) {
				waitUntilClickable(ele);
				ele.click();
				break;
			}
		}
	}

	public void selectExportType_ExportItemisedBillMarketingActivity() {
		waitUntilClickable(exportTypeSpan);
		exportTypeSpan.click();
		waitUntilVisibilityOfElements(exportTypeSpan_All);
		List<WebElement> list = exportTypeSpan_All;
		for (WebElement ele : list) {
			if (ele.getAttribute("innerHTML").contains("Itemized Bill(Marketing Activity)")) {
				waitUntilClickable(ele);
				ele.click();
				break;
			}
		}
	}

	public void selectExportType_ExportCampaigns() {
		waitUntilClickable(exportTypeSpan);
		exportTypeSpan.click();
		waitUntilVisibilityOfElements(exportTypeSpan_All);
		List<WebElement> list = exportTypeSpan_All;
		for (WebElement ele : list) {
			if (ele.getAttribute("innerHTML").contains("Campaign/SRD")) {

				waitUntilClickable(ele);
				ele.click();
				break;
			}
		}
	}

	public void selectExportType_ExportPartners() {
		waitUntilClickable(exportTypeSpan);
		exportTypeSpan.click();
		waitUntilVisibilityOfElements(exportTypeSpan_All);
		List<WebElement> list = exportTypeSpan_All;
		for (WebElement ele : list) {
			if (ele.getAttribute("innerHTML").contains("Channel Partner")) {
				waitUntilClickable(ele);
				ele.click();
				break;
			}
		}
	}

	public void selectExportType_ExportProjectUnits() {
		waitUntilClickable(exportTypeSpan);
		exportTypeSpan.click();
		waitUntilVisibilityOfElements(exportTypeSpan_All);
		List<WebElement> list = exportTypeSpan_All;
		for (WebElement ele : list) {
			if (ele.getAttribute("innerHTML").contains("Project Unit")) {
				waitUntilClickable(ele);
				ele.click();
				break;
			}
		}
	}

	public void selectExportType_ExportProjects() {
		waitUntilClickable(exportTypeSpan);
		exportTypeSpan.click();
		waitUntilVisibilityOfElements(exportTypeSpan_All);
		List<WebElement> list = exportTypeSpan_All;
		for (WebElement ele : list) {
			if (ele.getAttribute("innerHTML").contains("Projects")) {
				waitUntilClickable(ele);
				// selectProject.click();
				ele.click();
				break;
			}
		}
	}

	public void scrollToBottom() {

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public void selectCampaign() {
		waitUntilClickable(campaignSpan);
		campaignSpan.click();
		waitUntilClickable(selectcampaign);
		selectcampaign.click();

	}

	public void clickOnApplyButton() {
		waitUntilClickable(applyButton);
		applyButton.click();
	}

	public void clickOnFilterCrossIcon() {
		waitUntilClickable(crossFilterIcon);
		crossFilterIcon.click();
	}

	public void refreshExport() {
		try {
			WebElement we = driver.findElement(By.cssSelector(".refresh_link.pull-right"));
			if (we.isDisplayed()) {
				boolean flag = we.isDisplayed();
				while (flag) {
					wait(2000);
					jsClick(we);
					wait(1000);
					try {
						flag = driver.findElement(By.cssSelector(".refresh_link.pull-right")).isDisplayed();
					} catch (Exception e) {
						refresh();
						break;
					}
				}
			} else {
				wait(5000);
				refresh();
			}
		} catch (Exception e) {
			wait(5000);
			refresh();
		}

	}

	public void clickOnExportCrossIcon() {

		// This is used to select the cross icon to close the model

		// jsClick(crossExportIcon);
		try {
			wait(1000);
			// waitUntilClickable(crossExportIcon);
			crossExportIcon.click();
		} catch (Exception e) {
		}

		// crossExportIcon.click();
	}

	public void clickOnClickToExpandLink() {
		waitUntilClickable(clickToExpandLink);
		clickToExpandLink.click();
	}

	public void selectProject() {
		waitUntilClickable(projectField);
		projectField.click();
		waitUntilClickable(project_dd);
		project_dd.click();
	}

}
