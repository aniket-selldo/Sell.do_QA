package leadActivities;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.SalesPresalesDashboardPage;
import com.selldo.Utility.BaseTest;

public class MarkOnDefaultBreakTest extends BaseTest {


	@Test
	public void markingOnBreakTest() throws Exception {


		LoginPage login = new LoginPage(driver);
		login.login(prop.getProperty("nameAA") + "+" + prop.getProperty("user_email_defaultMarkingOnBreakTest"),
				prop.getProperty("password"));

		SalesPresalesDashboardPage salesPresalesDashboardPage = new SalesPresalesDashboardPage(driver);
		Thread.sleep(1000);
		if (!driver.findElement(By.cssSelector("span.status")).getText().contains("Available")) {

			extentTest.get().log(Status.INFO, "check availability of user.......");
			salesPresalesDashboardPage.availableForCall();
			Thread.sleep(1000);
			salesPresalesDashboardPage.pageRefresh();
			Thread.sleep(1000);
		}

		extentTest.get().log(Status.INFO, "Selecting Mark On Break.......");
		salesPresalesDashboardPage.selectMarkOnBreak();

		salesPresalesDashboardPage.pageRefresh();

		Thread.sleep(1000);

		extentTest.get().log(Status.INFO, "Verifying You are on break link.......");
		salesPresalesDashboardPage.validatingOnBreakStatus();

		salesPresalesDashboardPage.pageRefresh();

		Thread.sleep(1000);

		extentTest.get().log(Status.INFO, "Clicking on You are on break link......");
		salesPresalesDashboardPage.availableForCall();

		salesPresalesDashboardPage.pageRefresh();

		Thread.sleep(1000);

		extentTest.get().log(Status.INFO, "Verifying User Available link.......");
		salesPresalesDashboardPage.validatingAvailableLink();

	}

}
