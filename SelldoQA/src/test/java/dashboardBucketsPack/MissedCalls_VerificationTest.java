package dashboardBucketsPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.SalesPresalesDashboardPage;
import com.selldo.Utility.BaseTest;

public class MissedCalls_VerificationTest extends BaseTest {

	@Test
	public void missedCalls_VerificationTest() throws Exception {

		LoginPage login = new LoginPage(driver);
		login.login(prop.getProperty("name"), prop.getProperty("password"));

		SalesPresalesDashboardPage salesPresalesDashboard = new SalesPresalesDashboardPage(driver);

		extentTest.get().log(Status.INFO, "Refreshing the User Dashboard.......");
		salesPresalesDashboard.refreshDashboardStats();

		Thread.sleep(3000);

		extentTest.get().log(Status.INFO, "Getting count of Missed Calls bucket......");
		WebElement count_missedCallsBucket = driver
				.findElement(By.cssSelector("div[id='missed-calls'] span[class='title-item-body-count']"));
		String leadCount_missedCallsBucket = count_missedCallsBucket.getText();
		System.out.println(leadCount_missedCallsBucket);

		extentTest.get().log(Status.INFO, "Clicking on Missed Calls bucket......");
		salesPresalesDashboard.clickOnMissedCallsBucket();

		Thread.sleep(3000);

		extentTest.get().log(Status.INFO, "Getting count of leads under Missed Calls list......");
		WebElement we = driver.findElement(By.cssSelector("#get_leads_count"));
		we.click();
		Thread.sleep(5000);
		String leadCount_MissedCalls = we.getText();
		System.out.println(leadCount_MissedCalls);

		// Get count of leads from string
		String count_MissedCalls = leadCount_MissedCalls.replaceAll("\\D+", "");

		extentTest.get().log(Status.INFO,
				"Validating that the count of Missed Calls bucket is same as that of the count of leads under Missed Calls list.......");
		System.out.println("Started verification");
		Assert.assertEquals(leadCount_missedCallsBucket, count_MissedCalls, "Counts are different");
		System.out.println("Completed verification");
	}
}
