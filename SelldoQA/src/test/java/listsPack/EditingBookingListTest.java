package listsPack;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.selldo.POM.adminPages.BookingListPage;
import com.selldo.POM.adminPages.SettingsPage;
import com.selldo.POM.crm.ClientLoginPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;

public class EditingBookingListTest extends BaseTest {

	@Test

	public void editingBookingListTest() throws Exception {

		LoginPage login = new LoginPage(driver);

		login.login(prop.getProperty("superadmin_name") + prop.getProperty("superadmin_email"),
				prop.getProperty("password"));
		ClientLoginPage clientLogin = new ClientLoginPage(driver);

		clientLogin.clientLogin("Aniket Automation");
		SettingsPage settingsPage = new SettingsPage(driver);

		BookingListPage bookingListPage = new BookingListPage(driver);

		SoftAssert assertion = new SoftAssert();

		//test.log(Status.INFO, "Clicking on Search List tab...........");
		settingsPage.clickOnBookingListTab();

		//test.log(Status.INFO, "Selecting edit link from action bar........");
		bookingListPage.selectEditLink();

		String bookingListName = "Namechange"+random("","A",10).toLowerCase()+DateTime("dd/mm/yyyy");

		//test.log(Status.INFO, "Entering List name....................");
		bookingListPage.changeBookingListName(bookingListName);

		//test.log(Status.INFO, "Changing Publishers.....................");
		bookingListPage.changePublishers();

		//test.log(Status.INFO, "Changing Team.....................");
		bookingListPage.changeTeams();

		//test.log(Status.INFO, "Changing Sales.....................");
		bookingListPage.changeSales();

		//test.log(Status.INFO, "Clicking on Save button...............");
		bookingListPage.clickOnSaveButton();

		Thread.sleep(2000);

		//test.log(Status.INFO, "Validating Booking list name after editing new Booking list.....");
		System.out.println("Started verification");
		Assert.assertEquals(bookingListPage.getListName(), bookingListName, "Not matched");
		System.out.println("Completed verification");

	}

}
