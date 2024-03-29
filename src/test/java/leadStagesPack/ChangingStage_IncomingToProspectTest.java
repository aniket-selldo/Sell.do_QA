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

public class ChangingStage_IncomingToProspectTest extends BaseTest {

	@Test
	public void changingStage_IncomingToProspectTest() throws Exception {

		LoginPage login = new LoginPage(driver);
		login.login(prop("Sales_email"), prop("Password"));

		SalesPresalesDashboardPage salesPresalesDashboard = new SalesPresalesDashboardPage(driver);

		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);
		String leadID = "#" + new APIs().createLead(prop("Sales_id")).getSell_do_lead_id();
		//new Update_Lead().UpdateLead_stage(leadID, "booked");
		String leadId = adminDashboardPage.searchLead(leadID);
		String leadIdObj = driver.findElement(By.cssSelector("span[name='lead_id']")).getText().replaceAll("\\s+", "");
		System.out.println(leadIdObj);

		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);

		String LeadStage ="Prospect";
		leadProfilePage.changing_Stage(LeadStage.trim());

		salesPresalesDashboard.selectLeadActions(2);

		salesPresalesDashboard.searchLead(leadId);
		
		Thread.sleep(2000);

		String textDropdownObj = driver.findElement(By.cssSelector("#stage-span")).getText().trim();
		System.out.println(textDropdownObj);

		System.out.println("Started verification");
		Assert.assertEquals(textDropdownObj,LeadStage.trim(), "Not matched");
		System.out.println("Completed verification");

	}
}
