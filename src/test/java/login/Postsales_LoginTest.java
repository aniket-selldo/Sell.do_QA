package login;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;

public class Postsales_LoginTest extends BaseTest {

	@Test
	public void postsalesLoginTest() throws Exception {

		LoginPage login = new LoginPage(driver);

		login.login(prop("postsales_login"), prop("Password"));

		Thread.sleep(3000);

		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);

		adminDashboardPage.loggingOut();
		Assert.assertEquals(login.getSignoutMassage(), "Signed out successfully", "Signout Unsuccesful");
	}

}
