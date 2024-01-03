package campaignSetupPack;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.adminPages.AllCampaignPage;
import com.selldo.POM.adminPages.AutomationDashboardPage;
import com.selldo.POM.adminPages.NewCampaignFormPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;

public class CreatingCampaign_MandatoryFillTest extends BaseTest {

	@Test
	public void creatingCampaign_MandatoryFillTest() throws Exception {

		LoginPage login = new LoginPage(driver);

		login.login(prop("Amura_Admin"), prop("Password"));

		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);

		AutomationDashboardPage automationDashboardPage = new AutomationDashboardPage(driver);

		AllCampaignPage allCampaignPage = new AllCampaignPage(driver);

		NewCampaignFormPage newCampaignFormPage = new NewCampaignFormPage(driver);

		adminDashboardPage.clickOnWandIcon();

		automationDashboardPage.cickOnCampaignSetUp();

		allCampaignPage.clickOnNewCampaignButton();

		String campaignName = Random("A", 10);

		newCampaignFormPage.enterCamapignName(campaignName);

		//newCampaignFormPage.selectSales();

		newCampaignFormPage.clickOnSaveAndNextButton();

		newCampaignFormPage.clickOnSmsShortcodesTab();

		newCampaignFormPage.clickOnNextButton_SmsShortcode();

		campaignName = driver.findElement(By.xpath("//li[@class=\"breadcrumb-item active\"]")).getText();

		newCampaignFormPage.clickOnFinishButton();

		String campaignName_List = driver.findElement(By.cssSelector(
				"div.page-content-wrapper:nth-child(8) div.container-fluid div.row:nth-child(3) div.col-lg-12 div.page-container.index-page-container div.table-filter-container.pt-2 div.row div.col-lg-12.index-table.pl-0.pr-0 table.table.table-responsive tbody:nth-child(2) tr:nth-child(1) td:nth-child(1) > span.td-bold"))
				.getText();

		System.out.println(campaignName);
		System.out.println(campaignName_List);

		Assert.assertEquals(campaignName_List, campaignName, "Not matched");

	}

}
