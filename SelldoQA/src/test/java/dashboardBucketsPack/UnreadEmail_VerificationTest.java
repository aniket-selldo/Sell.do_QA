package dashboardBucketsPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.SalesPresalesDashboardPage;
import com.selldo.Utility.BaseTest;

public class UnreadEmail_VerificationTest extends BaseTest {

	@Test
	public void unreadEmail_VerificationTest() throws Exception {
		LoginPage login = new LoginPage(driver);
		login.login("aniket.khandizod+user033@sell.do", prop.getProperty("password"));
		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);

		SalesPresalesDashboardPage salesPresalesDashboard = new SalesPresalesDashboardPage(driver);

		extentTest.get().log(Status.INFO, "Refreshing the User Dashboard.......");
		salesPresalesDashboard.refreshDashboardStats();

		Thread.sleep(3000);

		extentTest.get().log(Status.INFO, "Getting count of Unread Email bucket......");
		WebElement count_unreadEmailBucket = driver
				.findElement(By.cssSelector("div[id='pending-emails'] span[class='title-item-body-count']"));
		String leadCount_unreadEmailBucket = count_unreadEmailBucket.getText();
		System.out.println(leadCount_unreadEmailBucket);

		extentTest.get().log(Status.INFO, "Going to All Lead List.......");
		salesPresalesDashboard.goToAllLeadsList();

		extentTest.get().log(Status.INFO, "Selecting Pending Emails list......");
		adminDashboardPage.SelectList("Pending Emails");

		Thread.sleep(3000);

		extentTest.get().log(Status.INFO, "Getting count of leads under pending email list......");

		String leadCount_pendingEmail = salesPresalesDashboard.getLeadHash();
		Assert.assertEquals(leadCount_unreadEmailBucket, leadCount_pendingEmail, "Counts are different");
		System.out.println("Completed verification");
	}

}
