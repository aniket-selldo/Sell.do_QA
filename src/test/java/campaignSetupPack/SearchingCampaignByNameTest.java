package campaignSetupPack;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.adminPages.AllCampaignPage;
import com.selldo.POM.adminPages.AutomationDashboardPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;

public class SearchingCampaignByNameTest extends BaseTest {

	@Test
	public void searchingCampaignByNameTest() throws Exception {

		LoginPage login = new LoginPage(driver);

		login.login(prop("Amura_Admin"), prop("Password"));

		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);

		AutomationDashboardPage automationDashboardPage = new AutomationDashboardPage(driver);

		AllCampaignPage allCampaignPage = new AllCampaignPage(driver);

		adminDashboardPage.clickOnWandIcon();

		automationDashboardPage.cickOnCampaignSetUp();

		String campaignNameToBeSearched = driver
				.findElement(By.cssSelector("table > tbody > tr:nth-child(1) > td:nth-child(1) > span"))
				.getAttribute("innerHTML");
		System.out.println("Campaign name to be searched-" + campaignNameToBeSearched);

		allCampaignPage.clickOnFunnelIcon();

		allCampaignPage.enterCampaignName(campaignNameToBeSearched);

		allCampaignPage.clickOnApplyButton();

		String campaignNameAfterSearch = driver
				.findElement(By.cssSelector("table > tbody > tr:nth-child(1) > td:nth-child(1) > span"))
				.getAttribute("innerHTML");
		System.out.println("Campaign name after search-" + campaignNameAfterSearch);

		Assert.assertEquals(campaignNameToBeSearched, campaignNameAfterSearch, "Not matched");

	}

}
