package exportPackage;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.adminPages.ExportPage;
import com.selldo.POM.adminPages.SettingsPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;

public class ExportLeadsTest extends BaseTest {

	@Test
	public void exportLeadsTest() throws Exception {

		LoginPage login = new LoginPage(driver);

		login.login(prop("Amura_Admin"), prop("Password"));
		SettingsPage settingsPage = new SettingsPage(driver);

		ExportPage exportPage = new ExportPage(driver);

		settingsPage.clickOnExportab();

		exportPage.clickOnExportLeadsTab();

		exportPage.selectDuration();

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

		exportPage.selectExportType_ExportLeads();

		exportPage.clickOnApplyButton();

		String leads = exportPage.getExportLabel();
		System.out.println(leads);

		//Assert.assertEquals(leads, "Leads - Export 1", "Not matched");
		Assert.assertTrue(driver.findElements(By.cssSelector("#export_type")).get(0).getText().contains("Leads - Export"), "Not matched");//Booking Details - Export 1

		//wait.until(ExpectedConditions.visibilityOfElementLocated(exportPage.exportStatus));
		exportPage.refreshExport();
		String exportStatus = exportPage.getExportStatus();
		Assert.assertEquals(exportStatus, "completed", "Export is not completed successfully");
		Assert.assertTrue(exportPage.getExportStatus_vlaidateAll());

		//exportPage.clickOnFilterCrossIcon();

		String emailInHistory = exportPage.getEmailAttribute();
		System.out.println(emailInHistory);

		Assert.assertEquals(emailInHistory, emailToWhichExported, "Not matched");

	}
}