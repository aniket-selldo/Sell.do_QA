package leadStagesPack;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.SalesPresalesDashboardPage;
import com.selldo.Utility.BaseTest;

public class ChangingStage_ProspectToOpportunityTest extends BaseTest {

	@Test
	public void changingStage_ProspectToOpportunityTest() throws Exception {

		LoginPage login = new LoginPage(driver);
		login.login(prop.getProperty("name"), prop.getProperty("password"));
		SalesPresalesDashboardPage salesPresalesDashboard = new SalesPresalesDashboardPage(driver);

		extentTest.get().log(Status.INFO, "Clicking on All Leads.......");
		//salesPresalesDashboard.goToAllLeadsList();
		
		//Thread.sleep(2000);

		extentTest.get().log(Status.INFO, "Selecting Prospect list......");
		//salesPresalesDashboard.SelectList("Prospect");

		extentTest.get().log(Status.INFO, "Opening Lead Details page of a lead under Prospect stage......");
		//salesPresalesDashboard.openLeadDetails();
		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);
		String leadId = adminDashboardPage.searchLead(Integer.parseInt(R('1', '2', '3', '4', '5', '6', '7')),
				"Prospect");
		extentTest.get().log(Status.INFO, "Getting Lead Id whose stage is to be changed.......");
		String leadIdObj = driver.findElement(By.cssSelector("span[name='lead_id']")).getText().replaceAll("\\s+", "");
		System.out.println(leadIdObj);

		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);

		extentTest.get().log(Status.INFO, "Changing stage from Prospect to Opportunity.......");

		leadProfilePage.changing_Stage("Opportunity");

		extentTest.get().log(Status.INFO, "Going to dashboard.......");
		salesPresalesDashboard.selectLeadActions(2);

		//wait.until(ExpectedConditions.presenceOfElementLocated(salesPresalesDashboard.searchField));

		extentTest.get().log(Status.INFO, "Searching lead by Id.......");
		salesPresalesDashboard.searchLead(leadId);
		
		Thread.sleep(2000);

		extentTest.get().log(Status.INFO, "Verifying stage changed from Prospect to Opportunity.......");

		String textDropdownObj = driver.findElement(By.cssSelector("#stage-span")).getText().trim();
		System.out.println(textDropdownObj);

		System.out.println("Started verification");
		Assert.assertEquals(textDropdownObj, "Opportunity", "Not matched");
		System.out.println("Completed verification");
		

	}
}
