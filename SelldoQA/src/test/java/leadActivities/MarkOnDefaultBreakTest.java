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
		login.login(prop("Sales_email"), prop("Password"));

		int wait = 1934;
		SalesPresalesDashboardPage salesPresalesDashboardPage = new SalesPresalesDashboardPage(driver);
		Thread.sleep(wait);
		if (!driver.findElement(By.cssSelector("span.status")).getText().contains("Available")) {

			salesPresalesDashboardPage.availableForCall();
			Thread.sleep(wait);
			salesPresalesDashboardPage.pageRefresh();
			Thread.sleep(wait);
		}

		salesPresalesDashboardPage.selectMarkOnBreak();

		salesPresalesDashboardPage.pageRefresh();

		Thread.sleep(wait);

		salesPresalesDashboardPage.validatingOnBreakStatus();

		salesPresalesDashboardPage.pageRefresh();

		Thread.sleep(wait);

		salesPresalesDashboardPage.availableForCall();

		salesPresalesDashboardPage.pageRefresh();

		Thread.sleep(wait);

		salesPresalesDashboardPage.validatingAvailableLink();

	}

}
