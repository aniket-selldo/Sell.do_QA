package otherLeadActivitiesPack;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.SalesPresalesDashboardPage;
import com.selldo.Utility.BaseTest;

public class MarkingOnBreakTest extends BaseTest {


	@Test
	public void markingOnBreakTest() throws Exception {


		LoginPage login = new LoginPage(driver);
		login.login("aniket.khandizod+po@sell.do", "amura@123");
		SalesPresalesDashboardPage salesPresalesDashboardPage = new SalesPresalesDashboardPage(driver);

		if (!driver.findElement(By.cssSelector("span.status")).getText().trim().equalsIgnoreCase("Available")) {
			System.out.println("In If Condition");
			extentTest.get().log(Status.INFO, "check availability of user.......");
			salesPresalesDashboardPage.availableForCall();
			salesPresalesDashboardPage.pageRefresh();
			Thread.sleep(2000);
		}

		extentTest.get().log(Status.INFO, "Selecting Mark On Break.......");
		salesPresalesDashboardPage.selectMarkOnBreak();

		salesPresalesDashboardPage.pageRefresh();

		Thread.sleep(2000);

		extentTest.get().log(Status.INFO, "Verifying You are on break link.......");
		salesPresalesDashboardPage.validatingOnBreakLink();

		salesPresalesDashboardPage.pageRefresh();

		Thread.sleep(2000);

		extentTest.get().log(Status.INFO, "Clicking on You are on break link......");
		salesPresalesDashboardPage.availableForCall();

		salesPresalesDashboardPage.pageRefresh();

		Thread.sleep(2000);

		extentTest.get().log(Status.INFO, "Verifying User Available link.......");
		salesPresalesDashboardPage.validatingAvailableLink();

	}

}
