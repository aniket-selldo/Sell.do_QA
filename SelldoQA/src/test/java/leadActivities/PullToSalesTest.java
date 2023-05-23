package leadActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.crm.ClientLoginPage;
import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.SalesPresalesDashboardPage;
import com.selldo.Utility.BaseTest;

public class PullToSalesTest extends BaseTest {
	private String SalesUser = "AniketSales00";
	private String PreSalesUser = "AniketPreSale00";
	@Test
	public void pullToSalesTest() throws Exception {

		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);
		SalesPresalesDashboardPage salesPresalesDashboard = new SalesPresalesDashboardPage(driver);
		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);
		LoginPage login = new LoginPage(driver);
		ClientLoginPage clientLoginPage = new ClientLoginPage(driver);

		

		login.login(prop.getProperty("superadmin_name") + prop.getProperty("superadmin_email"),
				prop.getProperty("password"));

		clientLoginPage.clientLogin("Aniket Automation");



		//extentTest.get().log(Status.INFO, "Signing in as a sales user to which lead is tobe pulled.......");
		adminDashboardPage.loginAsUser(SalesUser);
		//extentTest.get().log(Status.INFO, "Refreshing the User Dashboard.......");
		salesPresalesDashboard.refreshDashboardStats();

		//extentTest.get().log(Status.INFO, "Getting count of Leads from Pre-sales bucket......");
		
		WebElement count_b = driver.findElement(By.xpath("//div[text()='Site visits created']/parent::div//span"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + 1000 + ")", "");
		Thread.sleep(3000);
		String leadCount_b = count_b.getText();
		System.out.println(leadCount_b);

		//extentTest.get().log(Status.INFO, "Going back to Admin page.......");
		leadProfilePage.backToAdmin();

		//extentTest.get().log(Status.INFO, "Signing in as presales from which lead is to be pulled......");

		adminDashboardPage.loginAsUser(PreSalesUser);// prop.getProperty("signInAs_presales_pullToSalesTest")

		//extentTest.get().log(Status.INFO, "Going to All Lead List.......");
		salesPresalesDashboard.goToAllLeadsList();

		// Thread.sleep(15000);

		//extentTest.get().log(Status.INFO, "Selecting Prospect list......");
		adminDashboardPage.SelectList("Incoming");
		leadProfilePage.clearFilter();
		// getExtTest().log(Status.INFO, "Opening Lead Deatils Page.......");
		salesPresalesDashboard.openLeadDetails(0);
		salesPresalesDashboard.changing_BookedToProspect();
		salesPresalesDashboard.addProjectOnLead();
		Assert.assertEquals(getSuccessMSG(), "Lead updated successfully");

		//extentTest.get().log(Status.INFO, "Getting Lead Id before Pulling from sales.......");
	//	WebElement leadid_b = driver.findElement(By.cssSelector("span[name='lead_id']"));
		String leadId_b = salesPresalesDashboard.getLeadId();
		System.out.println(leadId_b);
		//extentTest.get().log(Status.INFO, "Going back to Admin page.......");
		leadProfilePage.backToAdmin();
		//extentTest.get().log(Status.INFO, "Signing in as sales user.......");//signInAs_sales_pullToSalesTest
		adminDashboardPage.loginAsUser(SalesUser);// prop.getProperty("signInAs_sales_pullToSalesTest")
		
        //extentTest.get().log(Status.INFO, "Searching by lead id.......");
		salesPresalesDashboard.searchLead(leadId_b);
		
		//extentTest.get().log(Status.INFO, "Selecting Pull from more .......");
		leadProfilePage.selectPull();

		//extentTest.get().log(Status.INFO, "Going to All Lead List.......");
		salesPresalesDashboard.goToAllLeadsList();

		//extentTest.get().log(Status.INFO, "Selecting From Presales list.......");
		adminDashboardPage.SelectList("From Pre sales");

		//extentTest.get().log(Status.INFO, "Opening Lead Deatils Page.......");
		salesPresalesDashboard.openLeadDetails(0);

		//extentTest.get().log(Status.INFO, "Getting Lead Id after pulling the lead.......");
		//WebElement leadid_a = driver.findElement(By.cssSelector("span[name='lead_id']"));
		String leadId_a =salesPresalesDashboard.getLeadId();
		System.out.println(leadId_a);

		//extentTest.get().log(Status.INFO, "Validating lead is pulled.......");
		Assert.assertEquals(leadId_b, leadId_a, "Leads are not matching");

		//extentTest.get().log(Status.INFO, "Going to Users Dashboard.......");
		salesPresalesDashboard.selectLeadActions(2);

		//extentTest.get().log(Status.INFO, "Refreshing the User Dashboard.......");
		salesPresalesDashboard.refreshDashboardStats();
		//Thread.sleep(5000);
		//extentTest.get().log(Status.INFO, "Getting count of Lead from Presales......");
		WebElement count_a = driver.findElement(By.cssSelector(
				"#todays-performance-label > div.card-body > div.row.pt-2 > div > div > div:nth-child(5) > div.tile-item-body > span"));
		String leadCount_a = count_a.getText();
		System.out.println(leadCount_a);

		//extentTest.get().log(Status.INFO, "Validating count is not same after lead pull.......");
		Assert.assertNotEquals(leadCount_b, leadCount_a, "Count is same as before pulling lead");
	}

}
