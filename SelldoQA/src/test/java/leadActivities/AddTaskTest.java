package leadActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.SalesPresalesDashboardPage;
import com.selldo.POM.crm.TaskPage;
import com.selldo.Utility.BaseTest;

import API.APIs;

public class AddTaskTest extends BaseTest {
	private static String leadId;
	private static String taskTitle;

	@Test
	public void changingTaskStatusTest() throws Exception {
		LoginPage login = new LoginPage(driver);
		login.login(prop("Sales_email"), prop("Password"));
		SalesPresalesDashboardPage salesPresalesDashboard = new SalesPresalesDashboardPage(driver);
		salesPresalesDashboard.searchLead("#"+new APIs().createLead(prop("Clinet_API_Res"),prop("Sales_id")).getSell_do_lead_id());
		leadId = driver.findElement(By.xpath("//span[@name='lead_id']")).getAttribute("innerHTML");
		System.out.println("Lead id >>> " + leadId);

		TaskPage taskPage = new TaskPage(driver);
		taskPage.AddTask();
		taskTitle=taskPage.AddTaskTitle("Automation Task Generation"); /// make test case here
		taskPage.addTaskDescription( Random( "AN", 1000));
		taskPage.clickOnSaveButton();
		driver.findElement(By.xpath("//button[text()='close']")).click();
		Thread.sleep(1000);
		Assert.assertEquals("Task saved successfully.", getSuccessMSG());

	}

	@Test(dependsOnMethods = { "changingTaskStatusTest" })
	public void ChangingTaskStatusTest() throws Exception {
		LoginPage login = new LoginPage(driver);
		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);
		TaskPage taskPage = new TaskPage(driver);
		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);

		login.login(prop("Sales_email"), prop("Password"));
		adminDashboardPage.searchLead(leadId);
		String exp ="The task '"+taskTitle+"' is assigned to "+leadProfilePage.getUserName()+".";
		taskPage.selectTask();
		taskPage.OptionSelect();
		taskPage.selectTaskStatus("Completed");
		taskPage.clickOnSaveButton();
		String acu =taskPage.getTaskFeedText();System.out.println(acu);
		Assert.assertEquals(exp, acu);

	}
//	public static void main(String[] args) {
//		new APIs().createLead("05982fc554c597db3bd1db3a4e6fb9b9","64521f80b0834520de89a2c3").getSell_do_lead_id();
//	}

}
