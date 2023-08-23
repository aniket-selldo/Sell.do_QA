package otherLeadActivitiesPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.MergeLeadsPage;
import com.selldo.POM.crm.SalesPresalesDashboardPage;
import com.selldo.Utility.BaseTest;

import API.APIs;
import API.Update_Lead;

public class MergingTwoLeadsFromSameStagesTest extends BaseTest {

	@Test
	public void mergingTwoLeadsFromSameStagesTest() throws Exception {LoginPage login = new LoginPage(driver);
	login.login(prop("Sales_email"), prop("Password"));

	Thread.sleep(3000);

	AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);

	SalesPresalesDashboardPage salesPresalesDashboard = new SalesPresalesDashboardPage(driver);

	LeadProfilePage leadProfilePage = new LeadProfilePage(driver);

	String leadID = "#" + new APIs().createLead(prop("Sales_id")).getSell_do_lead_id();
	new Update_Lead().LeadStageChnage(leadID,"incoming");

	adminDashboardPage.searchLead(leadID);

	WebElement Lead1 = driver.findElement(By.cssSelector("span[name='lead_id']"));
	String leadtext1 = (Lead1.getText().replaceAll("\\s+", "").substring(1)) + "#";
	System.out.println(leadtext1);

	salesPresalesDashboard.goToAllLeadsList();

	String leadID2 = "#" + new APIs().createLead(prop("Sales_id")).getSell_do_lead_id();
	new Update_Lead().LeadStageChnage(leadID2, "incoming");
	adminDashboardPage.searchLead(leadID2);
	
	leadProfilePage.selectMergeLeads();

	MergeLeadsPage mergeLeadsPage = new MergeLeadsPage(driver);

	mergeLeadsPage.searchingLeadToBeMerged(leadtext1);

	Thread.sleep(2000);

	mergeLeadsPage.clickOnMergeThisButton();

	mergeLeadsPage.enteringSomeNotes(Random("AN", 100));

	mergeLeadsPage.clickOnMergeLeadsButton();

	Thread.sleep(3000);

	salesPresalesDashboard.searchLead(leadtext1);
	Thread.sleep(2000);

	System.out.println("Started verification");
	Thread.sleep(2000);
	driver.navigate().refresh();
	System.out.println(">>>> " + salesPresalesDashboard.getCurretLeadStatus());
	Assert.assertEquals(salesPresalesDashboard.getCurretLeadStatus(), "unqualified",
			"Merged lead not found under unqualified list");
	System.out.println("Completed verification");}

}