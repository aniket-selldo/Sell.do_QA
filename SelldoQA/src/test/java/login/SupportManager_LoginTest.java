package login;

import org.openqa.selenium.By;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.selldo.POM.crm.AdminSupport_HomePage;
import com.selldo.POM.crm.ClientLoginPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;

public class SupportManager_LoginTest extends BaseTest {


	@Test

	public void supportManager_LoginTest() throws Exception {

		LoginPage login = new LoginPage(driver);

		extentTest.get().log(Status.INFO, "Logging in as Support Manager.......");
		login.login(prop.getProperty("support_manager_email"), prop.getProperty("password"));

		ClientLoginPage clientLoginPage = new ClientLoginPage(driver);

		AdminSupport_HomePage ashp = new AdminSupport_HomePage(driver);


		if (!driver.findElements(By.cssSelector("#main-menu-support-dashboard > a > i")).isEmpty()) {

			extentTest.get().log(Status.INFO, "Logout and again login.......");
			ashp.loggingOut();

			extentTest.get().log(Status.INFO, "Logging in to Support Home Page......");
			login.login(prop.getProperty("support_manager_email"), prop.getProperty("password"));

		} else {

			extentTest.get().log(Status.INFO, "Logging in to Support Home Page......");

		}
		clientLoginPage.clientLogin(prop.getProperty("v2_client_name"));
		Thread.sleep(3000);
		extentTest.get().log(Status.INFO, "Verifying that client login is successfull.......");
		ashp.verifyingClientLogin();
		extentTest.get().log(Status.INFO, "Logging out of Selldo......");
		ashp.loggingOut();
		AssertJUnit.assertEquals(getSuccessMSG2(), "Signed out successfully.", "Signout Unsuccesful");

	}



}
