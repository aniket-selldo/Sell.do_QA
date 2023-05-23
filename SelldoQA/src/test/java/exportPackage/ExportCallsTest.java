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

public class ExportCallsTest extends BaseTest {

	@Test
	public void exportCallsTest() throws Exception {

		LoginPage login = new LoginPage(driver);

		login.login(prop.getProperty("superadmin_name") + prop.getProperty("superadmin_email"),
				prop.getProperty("password"));

		ClientLoginPage clientLogin = new ClientLoginPage(driver);

		clientLogin.clientLogin(prop.getProperty("client_name"));
		SettingsPage settingsPage = new SettingsPage(driver);

		ExportPage exportPage = new ExportPage(driver);

		extentTest.get().log(Status.INFO, "Clicking on Export tab.......");
		settingsPage.clickOnExportab();

		extentTest.get().log(Status.INFO, "Clicking on Export Calls tab.......");
		exportPage.clickOnExportCallsTab();

		extentTest.get().log(Status.INFO, "Selecting duration.......");
		exportPage.selectDuration();

		String emailToWhichExported = prop.getProperty("export_email");

		extentTest.get().log(Status.INFO, "Entering Email.......");
		exportPage.enterEmail(emailToWhichExported);
		//extentTest.get().log(Status.INFO, "Clicking on Next Button.......");
		exportPage.clickOnNextButton();

		exportPage.scrollToBottom();
		extentTest.get().log(Status.INFO, "Clicking on Export Button.......");
		exportPage.clickOnExportButton();

		Thread.sleep(2000);

		exportPage.clickOnExportCrossIcon();
		Assert.assertEquals(getSuccessMSG(),"Export has been scheduled and will be emailed to "  + emailToWhichExported + ".");

		Thread.sleep(2000);

		exportPage.scrollToBottom();

		extentTest.get().log(Status.INFO, "Clicking on Export History tab.......");
		exportPage.clickOnExportHistoryTab();

		extentTest.get().log(Status.INFO, "Clicking on Funnel icon.......");
		exportPage.clickOnFunnelIcon();

		extentTest.get().log(Status.INFO, "Selecting Created at date range.......");
		exportPage.selectCreatedAtDateRange();

		extentTest.get().log(Status.INFO, "Selecting Export type as Calls.......");
		exportPage.selectExportType_ExportCalls();

		extentTest.get().log(Status.INFO, "Clicking on Apply button.......");
		exportPage.clickOnApplyButton();

		extentTest.get().log(Status.INFO, "Capturing text of the export at top left corner of list.......");
	
		extentTest.get().log(Status.INFO, "Validating that the latest export is made for Calls.......");
		Assert.assertTrue(driver.findElements(By.cssSelector("#export_type")).get(0).getText().contains("Calls - Export "), "Not matched");//Booking Details - Export 1

		exportPage.refreshExport();
		String exportStatus = exportPage.getExportStatus();

		extentTest.get().log(Status.INFO, "Validating that export completed successfully.......");
		Assert.assertEquals(exportStatus, "completed", "Export is not completed successfully");
		extentTest.get().log(Status.INFO, "Exiting from filter form......");

		extentTest.get().log(Status.INFO, "Capturing email under the export details to which export is made.......");
		String emailInHistory = exportPage.emailIdField.getAttribute("innerHTML").trim();
		System.out.println(emailInHistory);

		extentTest.get().log(Status.INFO,"Validating that the email to which export is made is same as what shown in history.......");
		Assert.assertEquals(emailInHistory, emailToWhichExported, "Not matched");
	}

}
