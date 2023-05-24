package login;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;

public class SalesManager_LoginTest extends BaseTest {

	@Test
	public void salesManagerLoginTest() throws Exception {

		
		LoginPage login = new LoginPage(driver);

		extentTest.get().log(Status.INFO, "Logging in as Sales Manager.......");
		login.login("aniket.khandizod+m@sell.do",prop.getProperty("password"));
		Thread.sleep(3000);


		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);

		extentTest.get().log(Status.INFO, "Logging out of Selldo......");
		adminDashboardPage.loggingOut();
		Assert.assertEquals(getSuccessMSG2(), "Signed out successfully.", "Signout Unsuccesful");

	}


}
