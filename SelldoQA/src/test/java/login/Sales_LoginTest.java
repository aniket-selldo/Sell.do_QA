package login;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;

public class Sales_LoginTest extends BaseTest {

	@Test
	public void salesLoginTest() throws Exception {

		LoginPage login = new LoginPage(driver);

		extentTest.get().log(Status.INFO, "Logging in to Sales User.......");
		login.login(prop.getProperty("nameAA") + "+" + prop.getProperty("sales_email"), prop.getProperty("password"));

		Thread.sleep(3000);

		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);

		extentTest.get().log(Status.INFO, "Logging out of Selldo......");
		adminDashboardPage.loggingOut();
		AssertJUnit.assertEquals(getSuccessMSG2(), "Signed out successfully.", "Signout Unsuccesful");

	}

}
