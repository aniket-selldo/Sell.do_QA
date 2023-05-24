package otherLeadActivitiesPack;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

public class MergingTwoLeadsFromDiffStagesTest extends BaseTest {

	@Test

	public void mergingTwoLeadsFromDiffStagesTest() throws Exception {
		LoginPage login = new LoginPage(driver);
		login.login(
				prop.getProperty("name") + "+"
						,
				prop.getProperty("password"));



		Thread.sleep(3000);

		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);

		SalesPresalesDashboardPage salesPresalesDashboard = new SalesPresalesDashboardPage(driver);

		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);

		adminDashboardPage.searchLead(Integer.parseInt(R('1', '2', '3', '4', '5', '6')), "Prospect");


		WebElement Lead1 = driver.findElement(By.cssSelector("span[name='lead_id']"));
		//String leadtext1 = Lead1.getText().replaceAll("\\s+", "");
		String leadtext1 = (Lead1.getText().replaceAll("\\s+", "").substring(1))+"#";
		System.out.println(leadtext1);

		//getExtTest().log(Status.INFO, "Going to All Lead List.......");
		salesPresalesDashboard.goToAllLeadsList();

		//getExtTest().log(Status.INFO, "Selecting Opportunity list......");
		adminDashboardPage.SelectList("Opportunity");

		//getExtTest().log(Status.INFO, "Opening Lead Deatils Page.......");
		salesPresalesDashboard.openLeadDetails(1);

		//getExtTest().log(Status.INFO, "Selecting Merge Leads from more.......");
		leadProfilePage.selectMergeLeads();

		MergeLeadsPage mergeLeadsPage = new MergeLeadsPage(driver);

		//getExtTest().log(Status.INFO, "Searching lead to be merged.......");
		mergeLeadsPage.searchingLeadToBeMerged(leadtext1);

		Thread.sleep(2000);

		//getExtTest().log(Status.INFO, "Clicking on Merge This Button.......");
		mergeLeadsPage.clickOnMergeThisButton();

		//getExtTest().log(Status.INFO, "Writing some notes.......");
		mergeLeadsPage.enteringSomeNotes(property.getProperty("note_mergingTwoLeadsFromDiffStagesTest"));

		//getExtTest().log(Status.INFO, "Clicking on Merge Leads Button.......");
		mergeLeadsPage.clickOnMergeLeadsButton();

		Thread.sleep(3000);

		salesPresalesDashboard.searchLead(leadtext1);
		Thread.sleep(2000);
		 
		//getExtTest().log(Status.INFO, "Validating that stage of second lead changed to unqualified..............");
		SoftAssert assertion = new SoftAssert();
		System.out.println("Started verification");
		AssertJUnit.assertEquals(driver
				.findElement(By.cssSelector("div.dropdown.stage.float-left.mr-1 button span[data-title=\"label\"]"))
				.getText().trim(), "Unqualified", "Merged lead not found under unqualified list");
		System.out.println("Completed verification");
		assertion.assertAll();

	}

}
