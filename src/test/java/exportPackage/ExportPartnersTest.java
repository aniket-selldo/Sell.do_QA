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

public class ExportPartnersTest extends BaseTest {

	@Test
	public void exportPartnetsTest() throws Exception {

		LoginPage login = new LoginPage(driver);

		login.login(prop.getProperty("superadmin_name") + prop.getProperty("superadmin_email"),
				prop.getProperty("password"));

		ClientLoginPage clientLogin = new ClientLoginPage(driver);

		clientLogin.clientLogin(prop.getProperty("client_name"));
		SettingsPage settingsPage = new SettingsPage(driver);

		ExportPage exportPage = new ExportPage(driver);

		settingsPage.clickOnExportab();

		exportPage.clickOnExportPartnersTab();

		exportPage.selectDuration();

		String emailToWhichExported = prop.getProperty("export_email");

		exportPage.enterEmail(emailToWhichExported);
		exportPage.clickOnNextButton();

		exportPage.clickOnExportButton();

		// Thread.sleep(2000);

		exportPage.clickOnExportCrossIcon();
		Assert.assertEquals(getSuccessMSG(),
				"Export has been scheduled and will be emailed to " + emailToWhichExported + ".");

		// Thread.sleep(2000);

		exportPage.scrollToBottom();

		exportPage.clickOnExportHistoryTab();

		exportPage.clickOnFunnelIcon();

		exportPage.selectCreatedAtDateRange();

		exportPage.selectExportType_ExportPartners();

		exportPage.clickOnApplyButton();

		String partner = exportPage.getExportLabel();
		System.out.println(partner);

		// Assert.assertEquals(partner, "Channel Partner - Export 1", "Not matched");
		Assert.assertTrue(driver.findElements(By.cssSelector("#export_type")).get(0).getText()
				.contains("Channel Partners - Export"), "Not matched");// Booking Details - Export 1

		// wait.until(ExpectedConditions.visibilityOfElementLocated(exportPage.exportStatus));
		exportPage.refreshExport();
		String exportStatus = exportPage.getExportStatus();
		Assert.assertEquals(exportStatus, "completed", "Export is not completed successfully");

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
