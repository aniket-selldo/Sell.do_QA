package campaignSetupPack;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.adminPages.AllCampaignPage;
import com.selldo.POM.adminPages.AutomationDashboardPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;

public class DeactivatingAndReactivatingCampaignTest extends BaseTest {

	@Test
	public void deactivatingCampaignTest() throws Exception {

		LoginPage login = new LoginPage(driver);

		login.login(prop("Amura_Admin"), prop("Password"));
		
		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);

		AutomationDashboardPage automationDashboardPage = new AutomationDashboardPage(driver);

		AllCampaignPage allCampaignPage = new AllCampaignPage(driver);

		adminDashboardPage.clickOnWandIcon();

		automationDashboardPage.cickOnCampaignSetUp();

		String campaignName = driver.findElement(By.xpath("//th[text()='name']/following::span[1]"))
				.getAttribute("innerHTML");
		System.out.println("Campaign name-" + campaignName);

		String status = driver.findElement(By.xpath("//th[text()='name']/following::span[3]"))
				.getAttribute("innerHTML");
		System.out.println("Status is-" + status);
		Assert.assertEquals(status, "Active");

		// To Deactivate campaign
		allCampaignPage.deactivateCampaign();
		
		allCampaignPage.clickOnFunnelIcon();

		allCampaignPage.enterCampaignName(campaignName);

		allCampaignPage.clickOnApplyButton();

		String campaignNameAfterSearch = driver.findElement(By.xpath("//th[text()='name']/following::span[1]"))
				.getAttribute("innerHTML");
		System.out.println("Campaign name after search-" + campaignNameAfterSearch);

		Assert.assertEquals(campaignName, campaignNameAfterSearch, "Not matched");

		Assert.assertEquals(
				driver.findElement(By.xpath("//th[text()='name']/following::span[3]")).getAttribute("innerHTML"),
				"Inactive", "Not matched");

		// To Reactivate campaign

		allCampaignPage.reactivateCampaign();

		allCampaignPage.clickOnFunnelIcon();

		allCampaignPage.enterCampaignName(campaignName);

		allCampaignPage.clickOnApplyButton();

		String activeCampaignNameAfterSearch = driver.findElement(By.xpath("//th[text()='name']/following::span[1]"))
				.getAttribute("innerHTML");
		System.out.println("Active campaign name after search-" + activeCampaignNameAfterSearch);

		Assert.assertEquals(activeCampaignNameAfterSearch, campaignName, "Not matched");

		Assert.assertEquals(
				driver.findElement(By.xpath("//th[text()='name']/following::span[3]")).getAttribute("innerHTML"),
				"Active", "Not matched");

	}

}
