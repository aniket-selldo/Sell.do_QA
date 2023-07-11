package dashboardBucketsPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.SalesPresalesDashboardPage;
import com.selldo.Utility.BaseTest;

public class MissedCalls_VerificationTest extends BaseTest {

	@Test
	public void missedCalls_VerificationTest() throws Exception {

		LoginPage login = new LoginPage(driver);
		login.login(prop.getProperty("name"), prop.getProperty("password"));

		SalesPresalesDashboardPage salesPresalesDashboard = new SalesPresalesDashboardPage(driver);

		salesPresalesDashboard.refreshDashboardStats();

		Thread.sleep(3000);

		WebElement count_missedCallsBucket = driver
				.findElement(By.cssSelector("div[id='missed-calls'] span[class='title-item-body-count']"));
		String leadCount_missedCallsBucket = count_missedCallsBucket.getText();
		System.out.println(leadCount_missedCallsBucket);

		salesPresalesDashboard.clickOnMissedCallsBucket();

		Thread.sleep(3000);

		WebElement we = driver.findElement(By.cssSelector("#get_leads_count"));
		we.click();
		Thread.sleep(5000);
		String leadCount_MissedCalls = we.getText();
		System.out.println(leadCount_MissedCalls);

		// Get count of leads from string
		String count_MissedCalls = leadCount_MissedCalls.replaceAll("\\D+", "");

		System.out.println("Started verification");
		Assert.assertEquals(leadCount_missedCallsBucket, count_MissedCalls, "Counts are different");
		System.out.println("Completed verification");
	}
}
