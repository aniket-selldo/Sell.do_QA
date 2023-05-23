package otherLeadActivitiesPack;

import org.openqa.selenium.By;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.adminPages.CreateDocumentsPage;
import com.selldo.POM.adminPages.DocumentsPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;

public class DocumentTest extends BaseTest {
	/*
	 * final static Logger logger = Logger.getLogger(DocumentTest.class);
	 * 
	 * @BeforeTest
	 * 
	 * public void sales_presalesLogin() throws Exception {
	 * 
	 * mysetUp();
	 * 
	 * driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 * 
	 * LoginPage login = new LoginPage(driver);
	 * 
	 * logger.info("Logging in to client page.......");
	 * 
	 * Properties p = new Properties(); FileInputStream fileInputObj = new
	 * FileInputStream( System.getProperty("user.dir") +
	 * "//src//main//java//Config File//global.properties"); p.load(fileInputObj);
	 * 
	 * login.login(p.getProperty("superadmin_name") +
	 * p.getProperty("superadmin_email"), p.getProperty("password"));
	 * 
	 * ClientLoginPage clientLogin = new ClientLoginPage(driver);
	 * 
	 * logger.info("Logging in to Admin/Support Home Page......");
	 * clientLogin.clientLogin(p.getProperty("client_name"));
	 * 
	 * }
	 */
	@Test

	public void searchingFileTest() throws Exception {
		/*
		 * Properties p = new Properties(); FileInputStream fileInputObj = new
		 * FileInputStream( System.getProperty("user.dir") +
		 * "//src//main//java//Config File//global.properties"); p.load(fileInputObj);
		 * 
		 * test = extent.createTest("DocumentTest"); setExtentTest(test);
		 */
		LoginPage login = new LoginPage(driver);
		login.login(prop.getProperty("preSales"), prop.getProperty("password"));
		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);

		extentTest.get().log(Status.INFO, "Clicking on Documents Icon.......");
		adminDashboardPage.clickOnDocument();

		CreateDocumentsPage createDocumentPage = new CreateDocumentsPage(driver);

		// Create Folder
		extentTest.get().log(Status.INFO, "Creating new folder.......");
		createDocumentPage.createNewFolder(prop.getProperty("folderName"));

		extentTest.get().log(Status.INFO, "Opening folder.......");
		createDocumentPage.openFolder(prop.getProperty("folderName"));

		DocumentsPage documentPage = new DocumentsPage(driver);
		String fileName = prop.getProperty("fileName");

		// To Upload File
		extentTest.get().log(Status.INFO, "Uploading New file.......");
		documentPage.upload();

		// Delete File
		extentTest.get().log(Status.INFO, "Deleting File.......");
		// documentPage.deleteFile(fileName);
		AssertJUnit.assertEquals(documentPage.deleteFile(fileName), "Deleting this document would remove it from all other referenced places.\n"
				+ "\n"
				+ "Are you sure ?");
		extentTest.get().log(Status.INFO, "Validating Back to Folder Button.......");
		documentPage.backToFolder();

		String expectedText = prop.getProperty("expectedText");
		AssertJUnit.assertEquals(driver.findElement(By.cssSelector("#new_folder_form input[value='Create New Folder']"))
				.getAttribute("value").trim(), expectedText, "Back to Folder Not working");
		AssertJUnit.assertEquals(getSuccessMSG(), "Deleted successfully");
	}

}
