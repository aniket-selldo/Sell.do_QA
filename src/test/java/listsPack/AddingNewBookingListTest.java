package listsPack;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.adminPages.BookingListPage;
import com.selldo.POM.adminPages.SettingsPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;

public class AddingNewBookingListTest extends BaseTest {

	@Test
	public void addingNewBookingListTest() throws Exception {
		LoginPage login = new LoginPage(driver);

		login.login(prop("Clinet_Email"), prop("Password"));

		SettingsPage settingsPage = new SettingsPage(driver);

		BookingListPage bookingListPage = new BookingListPage(driver);

		settingsPage.clickOnBookingListTab();

		bookingListPage.clickOnNewBookingSearchCriteriaButton();

		bookingListPage.selectSales();
		bookingListPage.selectPublishers();
		bookingListPage.selectTeams();
		String enterBookingListName = "A" + Random("A", 10).toLowerCase() + " " + DateTime("dd/MM/YYYY");
		bookingListPage.enterBookingListName(enterBookingListName);

		bookingListPage.selectCampaign();
		bookingListPage.selectProject();

		bookingListPage.clickOnSaveButton();

		Thread.sleep(5000);

		System.out.println("Started verification");
		Assert.assertEquals(bookingListPage.getListName(), enterBookingListName, "Not matched");
		System.out.println("Completed verification");

	}

}
