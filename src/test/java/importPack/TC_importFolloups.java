package importPack;

import org.testng.annotations.Test;

import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.adminPages.ImportPage;
import com.selldo.POM.adminPages.SettingsPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;
import com.selldo.pom.import_Lead.importLead;

public class TC_importFolloups extends BaseTest {
	
	@Test
	public void importFollowups() {
		
		LoginPage login = new LoginPage(driver);
		importLead importLead = new importLead(driver);

		login.login(prop("Amura_Admin"), prop("Password"));

		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);

		SettingsPage settingsPage = new SettingsPage(driver);

		ImportPage importPage = new ImportPage(driver);

		adminDashboardPage.clickOnSettingIcon();

		settingsPage.clickOnImportTab();
	}
	
	
}
