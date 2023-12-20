package importPack;

import java.io.IOException;

import org.testng.annotations.Test;

import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.adminPages.SettingsPage;
import com.selldo.POM.crm.ClientLoginPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;
import com.selldo.pom.import_Lead.SiteVisitXLFileGenerator;
import com.selldo.pom.import_Lead.importLead;

public class TC_importSiteVisit extends BaseTest {

	@Test
	public void importSV() throws IOException {
		LoginPage login = new LoginPage(driver);

		login.login(prop("Admin_id"), prop("Password"));
		ClientLoginPage clientLoginPage = new ClientLoginPage(driver);

		clientLoginPage.clientLogin(prop("Amura_Name"));
		
		importLead importLead = new importLead(driver);

		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);

		SettingsPage settingsPage = new SettingsPage(driver);

		adminDashboardPage.clickOnSettingIcon();

		settingsPage.clickOnImportTab();
		
		importLead.ClickOnSiteVisitImport();
		
		importLead.ClickOnNewUpload();

		String filePath = 	new SiteVisitXLFileGenerator ().FileGeneratorForSiteVisit(10);
		System.out.println(filePath);
		importLead.ClickOnUploadButtonAndSendFile(filePath);
		
		importLead.selectCampeign();
		
		importLead.selectSource();
		
		importLead.selectSubSource();
		
		importLead.EnterOwnEmail("aniket.khandizod@sell.do");
		
		importLead.clickOnContinue();
		
		importLead.clickOnContinueFinal();
		
		deleteFile(filePath);
		
		
	}
}
