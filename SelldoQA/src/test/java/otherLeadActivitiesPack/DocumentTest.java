package otherLeadActivitiesPack;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.adminPages.CreateDocumentsPage;
import com.selldo.POM.adminPages.DocumentsPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;

public class DocumentTest extends BaseTest {
	
	@Test
	public void documentTest() throws Exception {
		String folderName=prop.getProperty("folderName")+random("","A",10).toLowerCase();
		
		LoginPage login = new LoginPage(driver);
		login.login("aniket.khandizod+pre02@sell.do", "amura@123");
		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);

		extentTest.get().log(Status.INFO, "Clicking on Documents Icon.......");
		adminDashboardPage.clickOnDocument();

		CreateDocumentsPage createDocumentPage = new CreateDocumentsPage(driver);

		// Create Folder
		extentTest.get().log(Status.INFO, "Creating new folder.......");
		createDocumentPage.createNewFolder(folderName);

		extentTest.get().log(Status.INFO, "Opening folder.......");
		createDocumentPage.openFolder(folderName);

		DocumentsPage documentPage = new DocumentsPage(driver);
		String fileName = prop.getProperty("fileName")+random("","A",10).toLowerCase();

		// To Upload File
		extentTest.get().log(Status.INFO, "Uploading New file.......");
		documentPage.upload();

		// Delete File
		extentTest.get().log(Status.INFO, "Deleting File.......");
		// documentPage.deleteFile(fileName);
		Assert.assertEquals(documentPage.deleteFile(fileName), "Deleting this document would remove it from all other referenced places.\n"
				+ "\n"
				+ "Are you sure ?");
		extentTest.get().log(Status.INFO, "Validating Back to Folder Button.......");
		documentPage.backToFolder();

		String expectedText = prop.getProperty("expectedText");
		Assert.assertEquals(driver.findElement(By.cssSelector("#new_folder_form input[value='Create New Folder']"))
				.getAttribute("value").trim(), expectedText, "Back to Folder Not working");
		Assert.assertEquals(getSuccessMSG(), "Deleted successfully");
	}

}
