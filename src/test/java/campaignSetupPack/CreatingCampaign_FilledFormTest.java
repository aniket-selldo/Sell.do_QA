package campaignSetupPack;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.adminPages.AllCampaignPage;
import com.selldo.POM.adminPages.AutomationDashboardPage;
import com.selldo.POM.adminPages.NewCampaignFormPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;

public class CreatingCampaign_FilledFormTest extends BaseTest {

	@Test
	public void creatingCampaign_FilledFormTest() throws Exception {

		LoginPage login = new LoginPage(driver);

		login.login(prop("Amura_Admin"), prop("Password"));

		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);

		AutomationDashboardPage automationDashboardPage = new AutomationDashboardPage(driver);

		AllCampaignPage allCampaignPage = new AllCampaignPage(driver);

		NewCampaignFormPage newCampaignFormPage = new NewCampaignFormPage(driver);

		adminDashboardPage.clickOnWandIcon();

		automationDashboardPage.cickOnCampaignSetUp();

		allCampaignPage.clickOnNewCampaignButton();

		String campaignName = Random("A", 10);
		String trackingEmail = randomEmail();

		// For generating random name
		newCampaignFormPage.enterRandomCampaignName(campaignName);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		jse.executeScript("window.scrollBy(0,250)", "");
		newCampaignFormPage.selectProject();
		
		newCampaignFormPage.clickAlertPopup();
		
	//	newCampaignFormPage.selectSales();//This method to select sales is hidden on UI
		newCampaignFormPage.clickOnSaveAndNextButton();

		// Tracking Emails Tab...................................

		newCampaignFormPage.clickOnAddButton_TrackingEmail();

		newCampaignFormPage.enterTrackingEmailName(trackingEmail);

		// newCampaignFormPage.selectProject_TrackingEmails();

		newCampaignFormPage.selectSource_TrackingEmails();

		newCampaignFormPage.enterSubSource_TrackingEmails("Testing");

		newCampaignFormPage.clickOnSaveButton_TrackingEmails();
		
		newCampaignFormPage.clickOnNext();

		// Tracking Numbers Tab.....................................

		newCampaignFormPage.clickOnTrackingNumbersTab();

		newCampaignFormPage.clickOnShowOtherVirtualNumber_TrackingNumbers();

		newCampaignFormPage.clickOnActionBar_TrackingNumbers();

		if (driver.findElement(By.xpath("//th[text()='Actions']/following::a[@class='action_button dropdown-item'][1]"))
				.isDisplayed()) {

			newCampaignFormPage.clickOnAddLink_TrackingNumbers();

			//Thread.sleep(2000);

			newCampaignFormPage.clickOnSaveButton_TrackingNumbers();
		}

		// Input Channels.....................................

		newCampaignFormPage.clickOnInputChannelTab();
		
		newCampaignFormPage.clickOnAddButton_InputChannel();
		
		newCampaignFormPage.selectSource_InputChannel();
		
		newCampaignFormPage.selectSubSource_InputChannel();

		newCampaignFormPage.selectApiChannel();

		newCampaignFormPage.clickOnSaveButton_InputChannel();

		// SMS Shortcodes.....................................

		String message = Random("AN", 6);
		String source = Random("AN", 6);

		newCampaignFormPage.clickOnSmsShortcodesTab();

		newCampaignFormPage.clickAlertPopup();

		newCampaignFormPage.selectSmsShortcode_SmsShortcode();

		// Entering message for SMS
		newCampaignFormPage.enterMessage(message);
		
		//newCampaignFormPage.selectSource_SmsShortCode();

		// Selecting Project
		// Clicking Save button
		newCampaignFormPage.clickOnSaveButton_SmsShortcode();

		newCampaignFormPage.clickOnNextButton_SmsShortcode();
		
		//Thread.sleep(3000);

		campaignName = driver.findElement(By.xpath("//li[@class=\"breadcrumb-item active\"]")).getText();

		newCampaignFormPage.clickOnFinishButton();

		//Thread.sleep(3000);

		// String campaignName_List = driver
		// .findElement(By.xpath("//*[@id=\"campaign_form_container\"]/div[2]/div/ul[1]/li/span")).getText();

		String campaignName_List = driver.findElement(By.cssSelector(
				"div.page-content-wrapper:nth-child(8) div.container-fluid div.row:nth-child(3) div.col-lg-12 div.page-container.index-page-container div.table-filter-container.pt-2 div.row div.col-lg-12.index-table.pl-0.pr-0 table.table.table-responsive tbody:nth-child(2) tr:nth-child(1) td:nth-child(1) > span.td-bold"))
				.getText();

		System.out.println(campaignName);
		System.out.println(campaignName_List);

		Assert.assertEquals(campaignName_List, campaignName, "Not matched");
		System.out.println("Completed verification");

	}
}
