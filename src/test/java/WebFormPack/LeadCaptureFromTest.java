package WebFormPack;

import org.testng.annotations.Test;

import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.adminPages.AutomationDashboardPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;

public class LeadCaptureFromTest extends BaseTest {

	@Test
	public void ValidateLeadGeneration() {
		LoginPage login = new LoginPage(driver);

		login.login(prop("Amura_Admin"), prop("Password"));

		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);

		adminDashboardPage.clickOnWandIcon();

		AutomationDashboardPage automationDashboardPage = new AutomationDashboardPage(driver);

		automationDashboardPage.clickLeadCaptureFroms();

	}

}
