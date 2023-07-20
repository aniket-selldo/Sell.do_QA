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

public class ExportVirtualNumbersTest extends BaseTest {

	@Test
	public void exportVirtualNumbersTest() throws Exception {

		LoginPage login = new LoginPage(driver);

		login.login(prop.getProperty("superadmin_name") + prop.getProperty("superadmin_email"),
				prop.getProperty("password"));

		ClientLoginPage clientLogin = new ClientLoginPage(driver);

		clientLogin.clientLogin(prop.getProperty("client_name"));
		SettingsPage settingsPage = new SettingsPage(driver);

		ExportPage exportPage = new ExportPage(driver);

		settingsPage.clickOnExportab();

		exportPage.clickOnExportVirtualNumbersTab();

		exportPage.selectDuration();

		String emailToWhichExported = prop.getProperty("export_email");

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

		exportPage.selectExportType_ExportVirtualNumbers();

		exportPage.clickOnApplyButton();
		Assert.assertTrue(
				driver.findElements(By.cssSelector("#export_type")).get(0).getText().contains("Virtual Numbers - Export"),
				"Not matched");
		exportPage.refreshExport();
		String exportStatus = exportPage.getExportStatus();

		Assert.assertEquals(exportStatus, "completed", "Export is not completed successfully");

		String emailInHistory = exportPage.getEmailAttribute();
		System.out.println(emailInHistory);

		Assert.assertEquals(emailInHistory, emailToWhichExported, "Not matched");
		if (exportPage.getExportCount() > 0 && !exportPage.getFileDisplayedOrNot()) {
			Assert.fail("file not visible after export completed");
		}
	}

}
