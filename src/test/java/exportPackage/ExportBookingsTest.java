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

public class ExportBookingsTest extends BaseTest {

	@Test
	public void exportBookingsTest() throws Exception {
		LoginPage login = new LoginPage(driver);

		login.login(prop("Admin_id"), prop("Password"));

		ClientLoginPage clientLogin = new ClientLoginPage(driver);

		clientLogin.clientLogin(prop.getProperty("client_name"));

		SettingsPage settingsPage = new SettingsPage(driver);

		ExportPage exportPage = new ExportPage(driver);

		settingsPage.clickOnExportab();

		exportPage.clickOnExportBookingsTab();

		exportPage.selectDuration();

		String emailToWhichExported = prop.getProperty("export_email");

		exportPage.enterEmail(emailToWhichExported);

		exportPage.clickOnNextButton();

		exportPage.scrollToBottom();

		exportPage.clickOnExportButton();

		// Thread.sleep(2000);

		exportPage.clickOnExportCrossIcon();
		Assert.assertEquals(getSuccessMSG(),
				"Export has been scheduled and will be emailed to " + emailToWhichExported + ".");
		Thread.sleep(2000);

		exportPage.scrollToBottom();

		exportPage.clickOnExportHistoryTab();

		exportPage.clickOnFunnelIcon();

		exportPage.selectCreatedAtDateRange();

		exportPage.selectExportType_ExportBookings();

		exportPage.clickOnApplyButton();

		System.out.println(driver.findElements(By.cssSelector("#export_type")).get(0).getText());
		System.out.println(
				driver.findElements(By.cssSelector("#export_type")).get(0).getText().contains("Bookings - Export "));

		String booking = exportPage.exportLabel.get(0).getAttribute("innerHTML");
		System.out.println(booking);

		Assert.assertTrue(
				driver.findElements(By.cssSelector("#export_type")).get(0).getText().contains("Bookings - Export "),
				"Not matched");// Booking Details - Export 1

		// wait.until(ExpectedConditions.visibilityOfElementLocated(exportPage.exportStatus));
		exportPage.refreshExport();

		String exportStatus = exportPage.getExportStatus();

		// exportPage.refreshExport();
		Assert.assertEquals(exportStatus, "completed", "Export is not completed successfully");

		// exportPage.clickOnFilterCrossIcon();

		String emailInHistory = exportPage.getEmailAttribute();
		System.out.println(emailInHistory);

		// Thread.sleep(3000);

		Assert.assertEquals(emailInHistory, emailToWhichExported, "Not matched");
		if (exportPage.getExportCount() > 0 && !exportPage.getFileDisplayedOrNot()) {
			Assert.fail("file not visible after export completed");
		}
	}

}
