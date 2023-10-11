package dashboardBucketsPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.SalesPresalesDashboardPage;
import com.selldo.Utility.BaseTest;

public class NewEnquiries_VerificationTest extends BaseTest {

	@Test
	public void newEnquiries_VerificationTest() throws Exception {

		LoginPage login = new LoginPage(driver);
		login.login(prop("PreSales_email_amura"), prop("Password"));
		SalesPresalesDashboardPage salesPresalesDashboard = new SalesPresalesDashboardPage(driver);

		salesPresalesDashboard.refreshDashboardStats();

		Thread.sleep(3000);

		String leadCount_b = driver.findElement(By.cssSelector("//div[@id='contact_new_leads']//span")).getText();
		System.out.println(leadCount_b);

		salesPresalesDashboard.clickOnnewEnquiryBucket();

		salesPresalesDashboard.openLeadProfile(1);

		// ............changing stage to prospect from incoming of lead under New
		// Enquiry Bucket...................

		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);

		leadProfilePage.changing_Stage("Prospect");

		Thread.sleep(3000);

		// ..........Going back to dashboard after sending email.......................

		salesPresalesDashboard.selectLeadActions(2);

		salesPresalesDashboard.refreshDashboardStats();

		Thread.sleep(4000);

		WebElement count_a = driver
				.findElement(By.cssSelector("div[id='new-enquires'] span[class='title-item-body-count']"));
		String leadCount_a = count_a.getText();
		System.out.println(leadCount_a);

		SoftAssert assertion = new SoftAssert();

		Assert.assertNotEquals(leadCount_b, leadCount_a, "Count is same as before sending email");

		assertion.assertAll();

	}
}
