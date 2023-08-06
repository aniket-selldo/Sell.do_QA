package login;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.selldo.POM.crm.AdminSupport_HomePage;
import com.selldo.POM.crm.ClientLoginPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;

public class SuperAdmin_LoginTest extends BaseTest {

	@Test

	public void superAdmin_LoginTest() throws Exception {

		LoginPage login = new LoginPage(driver);

		extentTest.get().log(Status.INFO, "Loggin as Super admin page......");
		login.login(prop.getProperty("superadmin_name") + prop.getProperty("superadmin_email"),
				prop.getProperty("password"));
		ClientLoginPage clientLoginPage = new ClientLoginPage(driver);

		extentTest.get().log(Status.INFO, "Logging in to Admin Home Page......");
		clientLoginPage.clientLogin(prop.getProperty("v2_client_name"));

		AdminSupport_HomePage ashp = new AdminSupport_HomePage(driver);

		Thread.sleep(3000);

		extentTest.get().log(Status.INFO, "Verifying that client login is successfull.......");
		ashp.verifyingClientLogin();

		extentTest.get().log(Status.INFO, "Logging out of Selldo......");
		ashp.loggingOut();

		AssertJUnit.assertEquals(getSuccessMSG2(), "Signed out successfully.", "Signout Unsuccesful");

	}
}
