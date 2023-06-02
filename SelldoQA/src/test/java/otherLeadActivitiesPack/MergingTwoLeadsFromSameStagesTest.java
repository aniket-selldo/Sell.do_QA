package otherLeadActivitiesPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.MergeLeadsPage;
import com.selldo.POM.crm.SalesPresalesDashboardPage;
import com.selldo.Utility.BaseTest;

public class MergingTwoLeadsFromSameStagesTest extends BaseTest {

	@Test

	public void mergingTwoLeadsFromSameStagesTest() throws Exception {
		LoginPage login = new LoginPage(driver);
		login.login("aniket.khandizod+pre02@sell.do", "amura@123");
		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);

		SalesPresalesDashboardPage salesPresalesDashboard = new SalesPresalesDashboardPage(driver);

		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);

		extentTest.get().log(Status.INFO, "Going to All Lead List.......");
		salesPresalesDashboard.goToAllLeadsList();

		Thread.sleep(2000);

		extentTest.get().log(Status.INFO, "Selecting Prospect list......");
		adminDashboardPage.SelectList("Incoming");
		adminDashboardPage.clearFilter();
		extentTest.get().log(Status.INFO, "Opening Lead Deatils Page.......");
		salesPresalesDashboard.openLeadDetails(Integer.parseInt(R('0','1','2','3','4','5','6','7')));

		WebElement Lead1 = driver.findElement(By.cssSelector("span[name='lead_id']"));
		String leadtext1 = (Lead1.getText().replaceAll("\\s+", "").substring(1)) + "#";

		System.out.println(leadtext1);

		extentTest.get().log(Status.INFO, "Going to All Lead List.......");
		salesPresalesDashboard.goToAllLeadsList();

		extentTest.get().log(Status.INFO, "Selecting Prospect list......");
		adminDashboardPage.SelectList("Prospect");
		adminDashboardPage.clearFilter();
		extentTest.get().log(Status.INFO, "Opening Lead Deatils Page.......");
		salesPresalesDashboard.openLeadDetails(Integer.parseInt(R('0','1','2','3','4','5','6','7')));

		extentTest.get().log(Status.INFO, "Selecting Merge Leads from more.......");
		leadProfilePage.selectMergeLeads();

		MergeLeadsPage mergeLeadsPage = new MergeLeadsPage(driver);

		extentTest.get().log(Status.INFO, "Searching lead to be merged.......");
		mergeLeadsPage.searchingLeadToBeMerged(leadtext1);

		Thread.sleep(2000);

		extentTest.get().log(Status.INFO, "Clicking on Merge This Button.......");
		mergeLeadsPage.clickOnMergeThisButton();

		extentTest.get().log(Status.INFO, "Writing some notes.......");
		mergeLeadsPage.enteringSomeNotes("Note Added By Automation "+random("","A",1000));

		extentTest.get().log(Status.INFO, "Clicking on Merge Leads Button.......");
		mergeLeadsPage.clickOnMergeLeadsButton();

		Thread.sleep(3000);

		salesPresalesDashboard.searchLead(leadtext1);
		Thread.sleep(2000);
		extentTest.get().log(Status.INFO, "Validating that stage of second lead changed to unqualified..............");
		System.out.println("Started verification");
		Assert.assertEquals(leadProfilePage.getLeadStage() , "Unqualified", "Merged lead not found under unqualified list");
		System.out.println("Completed verification");

	}

}