package login;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.crm.AdminSupport_HomePage;
import com.selldo.POM.crm.ClientLoginPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;

public class SupportManager_LoginTest extends BaseTest {

	@Test

	public void supportManager_LoginTest() throws Exception {

		LoginPage login = new LoginPage(driver);

		login.login(prop("SM"), prop("Password"));

		ClientLoginPage clientLoginPage = new ClientLoginPage(driver);

		AdminSupport_HomePage ashp = new AdminSupport_HomePage(driver);

		if (!driver.findElements(By.cssSelector("#main-menu-support-dashboard > a > i")).isEmpty()) {

			ashp.loggingOut();

			login.login(prop("SM"), prop("Password"));

		} else {

		}
		clientLoginPage.clientLogin(prop("Client_Name"));
		Thread.sleep(3000);
		ashp.verifyingClientLogin();
		ashp.loggingOut();
		Assert.assertEquals(login.getSignoutMassage(), "Signed out successfully", "Signout Unsuccesful");

	}

}
