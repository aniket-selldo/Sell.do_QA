package exportPackage;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.adminPages.ExportPage;
import com.selldo.POM.adminPages.SettingsPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;

public class ExportPartnersTest extends BaseTest {

	@Test
	public void exportPartnetsTest() throws Exception {

		LoginPage login = new LoginPage(driver);

		login.login(prop("Amura_Admin"), prop("Password"));

		SettingsPage settingsPage = new SettingsPage(driver);

		ExportPage exportPage = new ExportPage(driver);

		settingsPage.clickOnExportab();

		exportPage.clickOnExportPartnersTab();

		exportPage.selectDuration();

		String emailToWhichExported = prop("Export_Gmail");

		exportPage.enterEmail(emailToWhichExported);
		exportPage.clickOnNextButton();

		exportPage.clickOnExportButton();

		exportPage.clickOnExportCrossIcon();
		Assert.assertEquals(getSuccessMSG(),
				"Export has been scheduled and will be emailed to " + emailToWhichExported + ".");

		exportPage.scrollToBottom();

		exportPage.clickOnExportHistoryTab();

		exportPage.clickOnFunnelIcon();

		exportPage.selectCreatedAtDateRange();

		exportPage.selectExportType_ExportPartners();

		exportPage.clickOnApplyButton();

		String partner = exportPage.getExportLabel();
		System.out.println(partner);

		Assert.assertTrue(driver.findElements(By.cssSelector("#export_type")).get(0).getText()
				.contains("Channel Partners - Export"), "Not matched");// Booking Details - Export 1

		exportPage.refreshExport();
		String exportStatus = exportPage.getExportStatus();
		Assert.assertEquals(exportStatus, "completed", "Export is not completed successfully");
		Assert.assertTrue(exportPage.getExportStatus_vlaidateAll());

		String emailInHistory = exportPage.getEmailAttribute();
		System.out.println(emailInHistory);

		Assert.assertEquals(emailInHistory, emailToWhichExported, "Not matched");

		System.out.println(exportPage.getExportCount());
		System.out.println(exportPage.getFileDisplayedOrNot());
		if (exportPage.getExportCount() > 0 && !exportPage.getFileDisplayedOrNot()) {
			Assert.fail("file not visible after export completed");
		}
	}

}
