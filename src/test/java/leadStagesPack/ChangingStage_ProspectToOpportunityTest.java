package leadStagesPack;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.SalesPresalesDashboardPage;
import com.selldo.Utility.BaseTest;

import API.APIs;
import API.Update_Lead;

public class ChangingStage_ProspectToOpportunityTest extends BaseTest {

	@Test
	public void changingStage_ProspectToOpportunityTest() throws Exception {

		LoginPage login = new LoginPage(driver);
		login.login(prop("Sales_email"), prop("Password"));
		SalesPresalesDashboardPage salesPresalesDashboard = new SalesPresalesDashboardPage(driver);

		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);
		String leadID = "#" + new APIs().createLead(prop("Sales_id")).getSell_do_lead_id();
		new Update_Lead().LeadStageChnage(leadID, "prospect");

		String leadId = adminDashboardPage.searchLead(leadID);
		String leadIdObj = driver.findElement(By.cssSelector("span[name='lead_id']")).getText().replaceAll("\\s+", "");
		System.out.println(leadIdObj);

		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);

		leadProfilePage.changing_Stage("Opportunity");

		salesPresalesDashboard.selectLeadActions(2);

		salesPresalesDashboard.searchLead(leadId);

		String textDropdownObj = driver.findElement(By.cssSelector("#stage-span")).getText().trim();
		System.out.println(textDropdownObj);

		System.out.println("Started verification");
		Assert.assertEquals(textDropdownObj, "Opportunity", "Not matched");
		System.out.println("Completed verification");

	}
}
