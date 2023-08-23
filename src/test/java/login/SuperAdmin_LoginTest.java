package login;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.crm.AdminSupport_HomePage;
import com.selldo.POM.crm.ClientLoginPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;

public class SuperAdmin_LoginTest extends BaseTest {

	@Test

	public void superAdmin_LoginTest() throws Exception {

		LoginPage login = new LoginPage(driver);

		login.login(prop("Admin_id"), prop("Password"));
		ClientLoginPage clientLoginPage = new ClientLoginPage(driver);

		clientLoginPage.clientLogin(prop("Client_Name"));

		AdminSupport_HomePage ashp = new AdminSupport_HomePage(driver);

		Thread.sleep(3000);

		ashp.verifyingClientLogin();

		ashp.loggingOut();

		Assert.assertEquals(login.getSignoutMassage(), "Signed out successfully", "Signout Unsuccesful");

	}
}
