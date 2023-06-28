package dashboardBucketsPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.SalesPresalesDashboardPage;
import com.selldo.Utility.BaseTest;

public class NewEnquiries_VerificationTest extends BaseTest {

	@Test

	public void newEnquiries_VerificationTest() throws Exception {

		LoginPage login = new LoginPage(driver);
		login.login("aniket.khandizod+user033@sell.do", prop.getProperty("password"));
		SalesPresalesDashboardPage salesPresalesDashboard = new SalesPresalesDashboardPage(driver);

		extentTest.get().log(Status.INFO, "Refreshing the User Dashboard.......");
		salesPresalesDashboard.refreshDashboardStats();

		Thread.sleep(3000);

		extentTest.get().log(Status.INFO, "Getting count of New Enquiry bucket......");
		String leadCount_b = driver.findElement(By.cssSelector("#new-enquires div:nth-child(2)")).getText();
		System.out.println(leadCount_b);

		extentTest.get().log(Status.INFO, "Clicking on New Enquiry bucket.......");
		salesPresalesDashboard.clickOnnewEnquiryBucket();

		extentTest.get().log(Status.INFO, "Opening Lead Deatils Page.......");
		salesPresalesDashboard.openLeadProfile(1);

		// ............changing stage to prospect from incoming of lead under New Enquiry Bucket...................

		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);

		extentTest.get().log(Status.INFO, "Changing stage from Incoming to Prospect.......");

		leadProfilePage.changing_Stage("Prospect");

		Thread.sleep(3000);

		// ..........Going back to dashboard after sending email.......................

		extentTest.get().log(Status.INFO, "Going back to dashboard......");
		salesPresalesDashboard.selectLeadActions(2);

		extentTest.get().log(Status.INFO, "Refreshing the User Dashboard.......");
		salesPresalesDashboard.refreshDashboardStats();

		Thread.sleep(4000);

		extentTest.get().log(Status.INFO, "Getting count of New Enquiry bucket after sending email......");
		WebElement count_a = driver.findElement(By.cssSelector("div[id='new-enquires'] span[class='title-item-body-count']"));
		String leadCount_a = count_a.getText();
		System.out.println(leadCount_a);

		SoftAssert assertion = new SoftAssert();

		extentTest.get().log(Status.INFO,
				"Validating count is not same after sending email to a lead from New Enquiry bucket......");
		Assert.assertNotEquals(leadCount_b, leadCount_a, "Count is same as before sending email");

		assertion.assertAll();

	}
}
