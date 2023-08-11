package listsPack;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.adminPages.BookingListPage;
import com.selldo.POM.adminPages.SettingsPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;

public class EditingBookingListTest extends BaseTest {

	@Test
	public void editingBookingListTest() throws Exception {

		LoginPage login = new LoginPage(driver);

		login.login(prop("Clinet_Email"), prop("Password"));

		SettingsPage settingsPage = new SettingsPage(driver);

		BookingListPage bookingListPage = new BookingListPage(driver);

		settingsPage.clickOnBookingListTab();

		bookingListPage.selectEditLink(3);

		String bookingListName = "Namechange" + Random("A", 10).toLowerCase() + DateTime("dd/mm/yyyy");

		bookingListPage.changeBookingListName(bookingListName);

		bookingListPage.changePublishers();

		bookingListPage.changeTeams();

		bookingListPage.changeSales();

		bookingListPage.clickOnSaveButton();

		System.out.println("Started verification");
		
		Assert.assertEquals(bookingListPage.getListName(), bookingListName, "Not matched");
		System.out.println("Completed verification");

	}

}
