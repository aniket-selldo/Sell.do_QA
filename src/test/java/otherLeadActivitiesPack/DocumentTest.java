package otherLeadActivitiesPack;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.adminPages.CreateDocumentsPage;
import com.selldo.POM.adminPages.DocumentsPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;

public class DocumentTest extends BaseTest {
	
	@Test
	public void documentTest() throws Exception {
		String folderName=Random("A",10).toLowerCase();
		
		LoginPage login = new LoginPage(driver);
		login.login(prop("Sales_email"), prop("Password"));
		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);

		adminDashboardPage.clickOnDocument();

		CreateDocumentsPage createDocumentPage = new CreateDocumentsPage(driver);

		createDocumentPage.createNewFolder(folderName);

		createDocumentPage.openFolder(folderName);

		DocumentsPage documentPage = new DocumentsPage(driver);
		String fileName = Random("A",10).toLowerCase();

		documentPage.upload();

		Assert.assertEquals(documentPage.deleteFile(fileName), "Deleting this document would remove it from all other referenced places.\n"
				+ "\n"
				+ "Are you sure ?");
		documentPage.backToFolder();

		Assert.assertEquals(driver.findElement(By.cssSelector("#new_folder_form input[value='Create New Folder']"))
				.getAttribute("value").trim(), "Create New Folder", "Back to Folder Not working");
		Assert.assertEquals(getSuccessMSG(), "Deleted successfully");
	}

}
