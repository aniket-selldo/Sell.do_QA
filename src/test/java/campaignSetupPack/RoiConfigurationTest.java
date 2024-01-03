package campaignSetupPack;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.adminPages.AllCampaignPage;
import com.selldo.POM.adminPages.AutomationDashboardPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;

public class RoiConfigurationTest extends BaseTest {

// ROI Config not working
	@Test
	public void addingNewRoiConfigurationTest() throws Exception {
		
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

		Assert.assertEquals(
				driver.findElement(By.xpath("//th[text()='name']/following::span[3]")).getAttribute("innerHTML"),
				"Active", "Not matched");

		allCampaignPage.selectRoiConfigution();

		allCampaignPage.clickOnAddNewConfigButton();

		allCampaignPage.selectSource();

		allCampaignPage.selectSubSource();

		allCampaignPage.enterExpectedCpl("500000");

		allCampaignPage.enterAmountSpent("400000");

		allCampaignPage.selectStartDate();

		allCampaignPage.selectEndDate();

		allCampaignPage.clickOnSaveButton();

	}

	@Test(priority = 2)
	public void editingRoiConfigurationTest() throws Exception {

		AllCampaignPage allCampaignPage = new AllCampaignPage(driver);

		Thread.sleep(2000);

		allCampaignPage.selectEdit_NewRoiConfig();

		allCampaignPage.changeExpectedCpl("700000");

		allCampaignPage.changeAmountSpent("600000");

		allCampaignPage.changeStartDate();

		allCampaignPage.changeEndDate();

		allCampaignPage.saveEditConfig();

	}

	@Test(priority = 3)

	public void deletingRoiConfigurationTest() throws Exception {

		AllCampaignPage allCampaignPage = new AllCampaignPage(driver);

		Thread.sleep(2000);

		allCampaignPage.selectDelete_NewRoiConfig();

		driver.switchTo().alert().accept();
	}

}
