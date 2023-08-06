package exportPackage;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.selldo.POM.adminPages.ExportPage;
import com.selldo.POM.adminPages.SettingsPage;
import com.selldo.POM.crm.ClientLoginPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;

public class ExportInvoices_ItemizedBill_MarketingActivityTest extends BaseTest {

	@Test
	public void exportInvoices_ItemizedBill_MarketingActivityTest() throws Exception {

		LoginPage login = new LoginPage(driver);

		login.login(prop.getProperty("superadmin_name") + prop.getProperty("superadmin_email"),
				prop.getProperty("password"));

		ClientLoginPage clientLogin = new ClientLoginPage(driver);

		clientLogin.clientLogin(prop.getProperty("client_name"));
		SettingsPage settingsPage = new SettingsPage(driver);

		ExportPage exportPage = new ExportPage(driver);

		settingsPage.clickOnExportab();

		exportPage.clickOnExportInvoicesTab();

		exportPage.selectInvoice("ADPL-23886097720170421 (01/01/2017-22/04/2017)");

		exportPage.selectInvoiceType_MarketingActivity();

		String emailToWhichExported = prop.getProperty("export_email");

		exportPage.enterEmail(emailToWhichExported);
		exportPage.clickOnNextButton();

		exportPage.clickOnExportButton();

		Thread.sleep(2000);

		exportPage.clickOnExportCrossIcon();
		Assert.assertEquals(getSuccessMSG(),
				"Export has been scheduled and will be emailed to " + emailToWhichExported + ".");

		Thread.sleep(2000);

		exportPage.scrollToBottom();

		exportPage.clickOnExportHistoryTab();

		exportPage.clickOnFunnelIcon();

		exportPage.selectCreatedAtDateRange();

		exportPage.selectExportType_ExportItemisedBillMarketingActivity();

		exportPage.clickOnApplyButton();

		String itemisedBill_MarketingActivity = exportPage.getExportLabel();
		System.out.println(itemisedBill_MarketingActivity);

		Assert.assertTrue(driver.findElements(By.cssSelector("#export_type")).get(0).getText()
				.contains("Invoices (Marketing Activity)"), "Not matched");// Booking Details - Export 1

		exportPage.refreshExport();
		String exportStatus = exportPage.getExportStatus();
		Assert.assertEquals(exportStatus, "completed", "Export is not completed successfully");

		String emailInHistory = exportPage.getEmailAttribute();
		System.out.println(emailInHistory);

		Assert.assertEquals(emailInHistory, emailToWhichExported, "Not matched");
		System.out.println(exportPage.getExportCount());
		System.out.println(exportPage.getFileDisplayedOrNot());
		if (exportPage.getExportCount() > 0 && exportPage.getFileDisplayedOrNot()) {
			Assert.fail("file not visible after export completed");
		}

	}

}
