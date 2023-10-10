package importPack;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.adminPages.ImportPage;
import com.selldo.POM.adminPages.SettingsPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;
import com.selldo.Utility.XLUtilsHSSF;

public class ImportLeads extends BaseTest {

	@Test
	public void exportLeadsTest() throws Exception {
		LoginPage login = new LoginPage(driver);

		login.login(prop("Clinet_Email"), prop("Password"));

		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);

		SettingsPage settingsPage = new SettingsPage(driver);

		ImportPage importPage = new ImportPage(driver);

		adminDashboardPage.clickOnSettingIcon();

		SoftAssert assertion = new SoftAssert();

		settingsPage.clickOnImportTab();

		importPage.clickOnImportLeadsTab();

		importPage.clickOnNewUploadButton();

		importPage.clickOnUploadButton(CretaeImportFile());

		importPage.selectCampaign();

		String emailId = prop("Email");
		importPage.enterEmail(emailId);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

		importPage.enterName();
		importPage.enterLeadEmail();
		// importPage.enterSalesId();
		// importPage.enterStage();

		importPage.clickOnContinueButton();

		String expectedMessage = "PASS";
		AssertJUnit.assertEquals(importPage.sucessMessage.getText(), expectedMessage, "Not matched");

		importPage.clickOnContinue();

		Alert alert = driver.switchTo().alert();
		alert.accept();

		importPage.pageRefresh();

		String expectedStatus = "PASS";
		AssertJUnit.assertEquals(importPage.importStatus.getText(), expectedStatus, "Not matched");

		String expectedUserName = "PASS";
		Assert.assertEquals(importPage.assignedTo.getText(), expectedUserName, "Not matched");

		String uploadData = importPage.leadUploadCount.getText();
		System.out.println(uploadData);

		assertion.assertAll();
	}

	public String CretaeImportFile() {
		String path = System.getProperty("user.dir") + "/DataFile/Lead import.xls";
		XLUtilsHSSF XLUtils = new XLUtilsHSSF(path);
		try {
			XLUtils.setCellData("Sheet1", 1, 0, randomEmail().trim());
			XLUtils.setCellData("Sheet1", 2, 0, randomEmail().trim());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}

}
