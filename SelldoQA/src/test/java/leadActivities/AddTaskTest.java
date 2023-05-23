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
import com.selldo.POM.crm.TaskPage;
import com.selldo.Utility.BaseTest;

public class AddTaskTest extends BaseTest {
	private static String leadId;
	private static String taskTitle;

	@Test
	public void changingTaskStatusTest() throws Exception {
		LoginPage login = new LoginPage(driver);
		login.login(prop.getProperty("AniketPreSaleUser"), prop.getProperty("password"));
		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);
		adminDashboardPage.searchLead(Integer.parseInt(R('1', '2', '3', '4', '5', '6', '7')), "All Leads");
		leadId = driver.findElement(By.xpath("//span[@name='lead_id']")).getAttribute("innerHTML");
		System.out.println("Lead id >>> " + leadId);

		TaskPage taskPage = new TaskPage(driver);
		taskPage.AddTask();
		taskTitle=taskPage.AddTaskTitle("Automation Task Generation"); /// make test case here
		String taskDescription = prop.getProperty("taskNameDescription");
		taskPage.addTaskDescription(taskDescription + random("taskDescription", "AN", 1000));
		taskPage.clickOnSaveButton();
		Assert.assertEquals("Task saved successfully.", getSuccessMSG());

	}

	@Test(dependsOnMethods = { "changingTaskStatusTest" })
	public void ChangingTaskStatusTest() throws Exception {
		LoginPage login = new LoginPage(driver);
		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);
		TaskPage taskPage = new TaskPage(driver);
		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);

		login.login(prop.getProperty("AniketPreSaleUser"), prop.getProperty("password"));
		adminDashboardPage.searchLead(leadId);
		String exp ="The task '"+taskTitle+"' is assigned to "+leadProfilePage.getUserName()+".";
		taskPage.selectTask();
		taskPage.OptionSelect();
		taskPage.selectTaskStatus("Completed");
		taskPage.clickOnSaveButton();
		String acu =taskPage.getTaskFeedText();System.out.println(acu);
		Assert.assertEquals(exp, acu);
		Assert.assertEquals(getSuccessMSG(), "Task saved successfully.");

	}

}
