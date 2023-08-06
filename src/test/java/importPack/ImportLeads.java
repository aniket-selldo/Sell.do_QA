package importPack;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.adminPages.ImportPage;
import com.selldo.POM.adminPages.SettingsPage;
import com.selldo.POM.crm.ClientLoginPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;

public class ImportLeads extends BaseTest {
//aa
	/*
	 * final static Logger logger = Logger.getLogger(ExportBookingsTest.class);
	 * 
	 * // Description:
	 * 
	 * @BeforeTest
	 * 
	 * public void sales_presalesLogin() throws Exception {
	 * 
	 * mysetUp();
	 * 
	 * driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 * 
	 * Properties property = new Properties(); FileInputStream fileInputObj = new
	 * FileInputStream( System.getProperty("user.dir") +
	 * "//src//main//java//Config File//global.properties");
	 * property.load(fileInputObj);
	 * 
	 * LoginPage login = new LoginPage(driver);
	 * 
	 * logger.info("Logging in to Support page.......");
	 * login.login(property.getProperty("name") + "+" +
	 * property.getProperty("support_email"), property.getProperty("password"));
	 * 
	 * ClientLoginPage clientLogin = new ClientLoginPage(driver);
	 * 
	 * logger.info("Logging in to Admin/Support Home Page......");
	 * clientLogin.clientLogin(property.getProperty("test_client_name"));
	 * 
	 * }
	 * 
	 * // @AfterTest
	 * 
	 * public void endingTest() throws Exception {
	 * 
	 * Thread.sleep(3000);
	 * 
	 * AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);
	 * 
	 * logger.info("Logging out of Selldo......"); adminDashboardPage.loggingOut();
	 * 
	 * logger.info("Closing Browser......"); driver.close(); }
	 */
	@Test

	public void exportLeadsTest() throws Exception {
		/*
		 * test = extent.createTest("importLeadsTest"); setExtentTest(test);
		 * 
		 * Properties property = new Properties(); FileInputStream fileInputObj = new
		 * FileInputStream( System.getProperty("user.dir") +
		 * "//src//main//java//Config File//global.properties");
		 * property.load(fileInputObj);
		 */
		LoginPage login = new LoginPage(driver);

		login.login(prop.getProperty("superadmin_name") + prop.getProperty("superadmin_email"),
				prop.getProperty("password"));

		ClientLoginPage clientLogin = new ClientLoginPage(driver);

		clientLogin.clientLogin(prop.getProperty("client_name"));
		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);

		SettingsPage settingsPage = new SettingsPage(driver);

		ImportPage importPage = new ImportPage(driver);

		//getExtTest().log(Status.INFO, "Clicking on Settings Icon.......");
		adminDashboardPage.clickOnSettingIcon();

		SoftAssert assertion = new SoftAssert();

		//getExtTest().log(Status.INFO, "Clicking on Import tab.......");
		settingsPage.clickOnImportTab();

		//getExtTest().log(Status.INFO, "Clicking on Import Leads tab.......");
		importPage.clickOnImportLeadsTab();

		//getExtTest().log(Status.INFO, "Clicking on New Upload button.......");
		importPage.clickOnNewUploadButton();

		//getExtTest().log(Status.INFO, "Clicking on Upload button.......");
		importPage.clickOnUploadButton("/home/aniket/Documents/uploadLeads.xls");
//importPage.clickOnUploadButton(projectPath+"/bulkCreate.xls");
		//getExtTest().log(Status.INFO, "selecting campaign.......");
		importPage.selectCampaign();

		String emailId = prop.getProperty("import_email");
		importPage.enterEmail(emailId);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

		//getExtTest().log(Status.INFO, "Selecting fields under Bulk parsed file section......");
		importPage.enterName();
		importPage.enterLeadEmail();
		//importPage.enterSalesId();
		//importPage.enterStage();

		//getExtTest().log(Status.INFO, "Clicking on Continue button......");
		importPage.clickOnContinueButton();

		String expectedMessage = prop.getProperty("success_message");
		//getExtTest().log(Status.INFO, "Validating Good to proceed message......");
		AssertJUnit.assertEquals(importPage.sucessMessage.getText(), expectedMessage, "Not matched");

		//getExtTest().log(Status.INFO, "Clicking on Continue button......");
		importPage.clickOnContinue();

		//getExtTest().log(Status.INFO, "Accepting javascript alert......");
		Alert alert = driver.switchTo().alert();
		alert.accept();

		importPage.pageRefresh();

		String expectedStatus = prop.getProperty("import_status");
		//getExtTest().log(Status.INFO, "Validating import status......");
		AssertJUnit.assertEquals(importPage.importStatus.getText(), expectedStatus, "Not matched");

		String expectedUserName = prop.getProperty("userName");
		//getExtTest().log(Status.INFO, "Validating Assigned to user name......");
		AssertJUnit.assertEquals(importPage.assignedTo.getText(), expectedUserName, "Not matched");

		String uploadData = importPage.leadUploadCount.getText();
		System.out.println(uploadData);

		assertion.assertAll();
	}

}
