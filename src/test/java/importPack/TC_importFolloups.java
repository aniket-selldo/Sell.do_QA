package importPack;

import java.io.IOException;

import org.testng.annotations.Test;

import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.adminPages.SettingsPage;
import com.selldo.POM.crm.ClientLoginPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;
import com.selldo.pom.import_Lead.FollowupXLfileGenerator;
import com.selldo.pom.import_Lead.importLead;

public class TC_importFolloups extends BaseTest {

	@Test
	public void importFollowups() throws IOException, InterruptedException {
		LoginPage login = new LoginPage(driver);

		login.login(prop("Admin_id"), prop("Password"));
		ClientLoginPage clientLoginPage = new ClientLoginPage(driver);

		clientLoginPage.clientLogin(prop("Amura_Name"));

		importLead importLead = new importLead(driver);

		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);

		SettingsPage settingsPage = new SettingsPage(driver);

		adminDashboardPage.clickOnSettingIcon();

		settingsPage.clickOnImportTab();

		importLead.ClickOnFollowupIMport();

		importLead.ClickOnNewUpload();

		String filePath = new FollowupXLfileGenerator().fileGenerate("Full");
		System.out.println(filePath);
		importLead.ClickOnUploadButtonAndSendFile(filePath);

		importLead.EnterOwnEmail();

		importLead.clickOnContinue();

		importLead.clickOnContinueFinal();

//		
//		XLUtilsHSSF xl = new XLUtilsHSSF(filePath);
//		String leadId=xl.getCellData("Sheet1", 1, 0);
//		
//		adminDashboardPage.searchLead("#"+leadId);
		deleteFile(filePath);

	}

}
