package otherLeadActivitiesPack;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.SalesPresalesDashboardPage;
import com.selldo.Utility.BaseTest;

public class MarkingOnBreakTest extends BaseTest {

	@Test
	public void markingOnBreakTest() throws Exception {

		LoginPage login = new LoginPage(driver);
		login.login(prop("Sales_email"), prop("Password"));
		SalesPresalesDashboardPage salesPresalesDashboardPage = new SalesPresalesDashboardPage(driver);

		if (!driver.findElement(By.cssSelector("span.status")).getText().trim().equalsIgnoreCase("Available")) {
			System.out.println("In If Condition");
			salesPresalesDashboardPage.availableForCall();
			salesPresalesDashboardPage.pageRefresh();
			Thread.sleep(2000);
		}

		salesPresalesDashboardPage.selectMarkOnBreak();

		salesPresalesDashboardPage.pageRefresh();

		Thread.sleep(2000);

		salesPresalesDashboardPage.validatingOnBreakLink();

		salesPresalesDashboardPage.pageRefresh();

		Thread.sleep(2000);

		salesPresalesDashboardPage.availableForCall();

		salesPresalesDashboardPage.pageRefresh();

		Thread.sleep(2000);

		salesPresalesDashboardPage.validatingAvailableLink();

	}

}
