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

public class ChangingStage_UnqualifiedToProspectTest extends BaseTest {
	
	@Test

	public void changingStage_UnqualifiedToProspectTest() throws Exception {

		LoginPage login = new LoginPage(driver);
		login.login(prop.getProperty("name"), prop.getProperty("password"));
		SalesPresalesDashboardPage salesPresalesDashboard = new SalesPresalesDashboardPage(driver);

		extentTest.get().log(Status.INFO, "Clicking on All Leads.......");
		//salesPresalesDashboard.goToAllLeadsList();

		extentTest.get().log(Status.INFO, "Selecting Unqualified list......");
		//salesPresalesDashboard.SelectList("Unqualified");

		extentTest.get().log(Status.INFO, "Opening Lead Details page of a lead under Unqualified stage......");
		//salesPresalesDashboard.openLeadDetails();
		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);
		String leadId = adminDashboardPage.searchLead(Integer.parseInt(R('1', '2', '3', '4', '5', '6', '7')),
				"All Leads");
		extentTest.get().log(Status.INFO, "Getting Lead Id whose stage is to be changed.......");
		String leadIdObj = driver.findElement(By.cssSelector("span[name='lead_id']")).getText().replaceAll("\\s+", "");
		System.out.println(leadIdObj);

		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);

		extentTest.get().log(Status.INFO, "Changing stage from Unqualified to Prospect.......");
		leadProfilePage.changing_Stage("Prospect");


		extentTest.get().log(Status.INFO, "Going to dashboard.......");
		salesPresalesDashboard.selectLeadActions(2);
		
		extentTest.get().log(Status.INFO, "Searching lead by Id.......");
		salesPresalesDashboard.searchLead(leadId);
		
		Thread.sleep(3000);

		extentTest.get().log(Status.INFO, "Verifying stage changed from Unqualified to Prospect.......");
		String textDropdownObj = driver.findElement(By.cssSelector("#stage-span")).getText().trim();
		System.out.println(textDropdownObj);

		System.out.println("Started verification");
		Assert.assertEquals(textDropdownObj, "Prospect", "Not matched");
		System.out.println("Completed verification");

	}
}
