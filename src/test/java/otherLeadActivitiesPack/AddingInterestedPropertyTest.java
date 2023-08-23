package otherLeadActivitiesPack;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.SalesPresalesDashboardPage;
import com.selldo.Utility.BaseTest;

public class AddingInterestedPropertyTest extends BaseTest {

	@Test
	public void addingInterestedPropertyTest() throws Exception {
		LoginPage login = new LoginPage(driver);
		login.login(prop("Sales_email"), prop("Password"));

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);

		SalesPresalesDashboardPage salesPresalesDashboard = new SalesPresalesDashboardPage(driver);

		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);

		salesPresalesDashboard.goToAllLeadsList();

		adminDashboardPage.SelectList("Incoming");

		salesPresalesDashboard.openLeadDetails(2);

		jse.executeScript("window.scrollBy(0,600)", "");

		String projectName = leadProfilePage.selectProject(0);

		System.out.println(projectName);

		leadProfilePage.clickOnAddButton();

		leadProfilePage.clickFeedTab();

		String text = driver.findElement(By.cssSelector(
				"#tab-activity > div.activities_list > div:nth-child(1) > div > div.card > div > div > div > span:nth-child(1)"))
				.getText().trim();

		Assert.assertEquals("Lead showed interest in " + projectName + "", text);
	}

}
