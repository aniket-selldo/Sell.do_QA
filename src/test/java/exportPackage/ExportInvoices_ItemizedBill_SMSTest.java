package exportPackage;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.adminPages.ExportPage;
import com.selldo.POM.adminPages.SettingsPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;

public class ExportInvoices_ItemizedBill_SMSTest extends BaseTest {

	@Test
	public void exportInvoices_ItemizedBill_SMSTest() throws Exception {

		LoginPage login = new LoginPage(driver);

		login.login(prop("Amura_Admin"), prop("Password"));
		SettingsPage settingsPage = new SettingsPage(driver);

		ExportPage exportPage = new ExportPage(driver);

		settingsPage.clickOnExportab();

		exportPage.clickOnExportInvoicesTab();

		exportPage.selectInvoice("ADPL-23886097720170421 (01/01/2017 - 22/04/2017)");

		exportPage.selectInvoiceType_Sms();

		String emailToWhichExported = prop("Export_Gmail");

		exportPage.enterEmail(emailToWhichExported);
		exportPage.clickOnNextButton();


		exportPage.clickOnExportButton();

		//Thread.sleep(2000);

		exportPage.clickOnExportCrossIcon();
		Assert.assertEquals(getSuccessMSG(),"Export has been scheduled and will be emailed to "  + emailToWhichExported + ".");

		//Thread.sleep(2000);
		
		exportPage.scrollToBottom();

		exportPage.clickOnExportHistoryTab();

		exportPage.clickOnFunnelIcon();

		exportPage.selectCreatedAtDateRange();

		exportPage.selectExportType_ExportItemisedBillSms();

		exportPage.clickOnApplyButton();

		String itemisedBill_Sms = exportPage.getExportLabel();
		System.out.println(itemisedBill_Sms);

		Assert.assertTrue(driver.findElements(By.cssSelector("#export_type")).get(0).getText().contains("Invoices (Sms)"), "Not matched");//Booking Details - Export 1

		exportPage.refreshExport();
		String exportStatus = exportPage.getExportStatus();
		Assert.assertEquals(exportStatus, "completed", "Export is not completed successfully");
		Assert.assertTrue(exportPage.getExportStatus_vlaidateAll());


		String emailInHistory =  exportPage.getEmailAttribute();
		System.out.println(emailInHistory);

		Assert.assertEquals(emailInHistory, emailToWhichExported, "Not matched");

	}

}
