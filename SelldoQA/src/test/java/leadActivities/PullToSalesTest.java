package leadActivities;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.SalesPresalesDashboardPage;
import com.selldo.Utility.BaseTest;

import API.CreateLead_POST;
import API.GetAllProjectIDAndName;
import API.GetLeadID;
import API.UpdateLead_Project_Stage;

public class PullToSalesTest extends BaseTest {

	@Test
	public void pullToSalesTest() throws Exception {

		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);
		SalesPresalesDashboardPage salesPresalesDashboard = new SalesPresalesDashboardPage(driver);
		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);
		LoginPage login = new LoginPage(driver);

		login.login(prop("Sales_email"), prop("Password"));
		salesPresalesDashboard.refreshDashboardStats();

		WebElement count_b = driver.findElement(By.xpath("//div[text()='Site visits created']/parent::div//span"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + 1000 + ")", "");
		Thread.sleep(3000);
		String leadCount_b = count_b.getText();
		System.out.println(leadCount_b);

		logout();
		login.login(prop("PreSales_email"), prop("Password"));// prop.getProperty("signInAs_presales_pullToSalesTest")

		ArrayList<String> ary = GetAllProjectIDAndName.getAllProjectID(prop("Clinet_API_Full"), prop("Client_id"));

		String leadCRMID = CreateLead_POST.createLeadByAPI(prop("Clinet_API_Res"), prop("PreSales_id"));
		String leadId_b = GetLeadID.getLeadId(prop("Clinet_API_Full"), prop("Client_id"), leadCRMID);

		UpdateLead_Project_Stage.updateProjectAndStage(prop("Clinet_API_Full"), prop("Client_id"), leadId_b, "prospect",
				ary);

		System.out.println(leadCRMID);
		logout();
		login.login(prop("Sales_email"), prop("Password"));// prop.getProperty("signInAs_sales_pullToSalesTest")

		salesPresalesDashboard.searchLead(leadCRMID);

		leadProfilePage.selectPull();

		salesPresalesDashboard.goToAllLeadsList();

		adminDashboardPage.SelectList("From Pre sales");

		salesPresalesDashboard.openLeadDetails(0);

		String leadId_a = salesPresalesDashboard.getLeadId();
		System.out.println(leadId_a);

		Assert.assertEquals(leadCRMID, leadId_a.replaceAll(" ", ""), "Leads are not matching");

		salesPresalesDashboard.selectLeadActions(2);

		salesPresalesDashboard.refreshDashboardStats();
		WebElement count_a = driver.findElement(By.cssSelector(
				"#todays-performance-label > div.card-body > div.row.pt-2 > div > div > div:nth-child(5) > div.tile-item-body > span"));
		String leadCount_a = count_a.getText();
		System.out.println(leadCount_a);

		Assert.assertNotEquals(leadCount_b, leadCount_a, "Count is same as before pulling lead");
	}

}
