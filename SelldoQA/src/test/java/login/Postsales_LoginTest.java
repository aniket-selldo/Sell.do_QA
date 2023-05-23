package login;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;

public class Postsales_LoginTest extends BaseTest {

	@Test
	public void postsalesLoginTest() throws Exception {

		LoginPage login = new LoginPage(driver);

		// getExtTest().log(Status.INFO, "Logging in to postsales user......");
		login.login(prop.getProperty("nameAA") + "+" + prop.getProperty("postsales_email"), prop.getProperty("password"));

		Thread.sleep(3000);

		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);

		// getExtTest().log(Status.INFO, "Logging out of Selldo......");
		adminDashboardPage.loggingOut();
		AssertJUnit.assertEquals(getSuccessMSG2(), "Signed out successfully.","Signout Unsuccesful");

	}

}
