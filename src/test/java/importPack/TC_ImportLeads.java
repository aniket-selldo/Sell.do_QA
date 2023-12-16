package importPack;

import org.testng.annotations.Test;

import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.adminPages.ImportPage;
import com.selldo.POM.adminPages.SettingsPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;
import com.selldo.pom.import_Lead.importLead;

public class TC_ImportLeads extends BaseTest {

	@Test
	public void importLeadsTest() throws Exception {
		LoginPage login = new LoginPage(driver);
		importLead importLead = new importLead(driver);

		login.login(prop("Clinet_Email"), prop("Password"));

		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);

		SettingsPage settingsPage = new SettingsPage(driver);

		ImportPage importPage = new ImportPage(driver);

		adminDashboardPage.clickOnSettingIcon();

		settingsPage.clickOnImportTab();

		importPage.clickOnImportLeadsTab();

		importPage.clickOnNewUploadButton();

		importPage.clickOnUploadButton(new LeadXLfileGenerator().leadImport(10));

		importLead.selectCampeign();

		importLead.selectSource();

		importLead.selectSubSource();

		importLead.selectMediumType();

		importLead.selectDepartment();

		importLead.SelectTeam();

		importLead.selectSales();

		importLead.selectProject();

		importLead.selectProjectforSV();

		importLead.clickOnSendNotificationToLead();

		importLead.EnterOwnEmail(randomEmail());
		
		importLead.clickOnContinue();
		
		importLead.clickOnContinueFinal();

	}
}
