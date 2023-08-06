package listsPack;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.selldo.POM.adminPages.BookingListPage;
import com.selldo.POM.adminPages.SettingsPage;
import com.selldo.POM.crm.ClientLoginPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;

public class AddingNewBookingListTest extends BaseTest {

	@Test
	public void addingNewBookingListTest() throws Exception {
		LoginPage login = new LoginPage(driver);

		login.login(prop.getProperty("superadmin_name") + prop.getProperty("superadmin_email"),
				prop.getProperty("password"));
		ClientLoginPage clientLogin = new ClientLoginPage(driver);

		clientLogin.clientLogin("Aniket Automation");// prop.getProperty("Other_client_name")
		SettingsPage settingsPage = new SettingsPage(driver);

		BookingListPage bookingListPage = new BookingListPage(driver);

		extentTest.get().log(Status.INFO, "Clicking on Search List tab...........");
		settingsPage.clickOnBookingListTab();

		extentTest.get().log(Status.INFO, "Clicking on New Booking Search Criteria button.........");
		bookingListPage.clickOnNewBookingSearchCriteriaButton();

		String bookingListName = prop.getProperty("listName_AddingNewBookingListTest");
		extentTest.get().log(Status.INFO, "Selecting Sales.....................");
		bookingListPage.selectSales();
		extentTest.get().log(Status.INFO, "Selecting Publishers.....................");
		bookingListPage.selectPublishers();
		extentTest.get().log(Status.INFO, "Selecting Team.....................");
		bookingListPage.selectTeams();
		extentTest.get().log(Status.INFO, "Entering List name....................");
		String enterBookingListName=bookingListName+random("enterBookingListName","A",10).toLowerCase() +" "+DateTime("dd/MM/YYYY");
		bookingListPage.enterBookingListName(enterBookingListName);

	
		extentTest.get().log(Status.INFO, "Selecting Campaign....");
		bookingListPage.selectCampaign();
		extentTest.get().log(Status.INFO, "Selecting Project..........");
		bookingListPage.selectProject();

		extentTest.get().log(Status.INFO, "Clicking on Save button...............");
		bookingListPage.clickOnSaveButton();

		Thread.sleep(5000);

		extentTest.get().log(Status.INFO, "Validating Booking list name after adding new Booking  list.....");
		System.out.println("Started verification");
		Assert.assertEquals( bookingListPage.getListName() , enterBookingListName, "Not matched");
		System.out.println("Completed verification");

	}

}
