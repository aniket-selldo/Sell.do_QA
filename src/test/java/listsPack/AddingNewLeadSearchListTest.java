package listsPack;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.adminPages.SearchListPage;
import com.selldo.POM.adminPages.SettingsPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;

public class AddingNewLeadSearchListTest extends BaseTest {

	@Test
	public void addingNewLeadSearchListTest() throws Exception {

		LoginPage login = new LoginPage(driver);

		login.login(prop("Clinet_Email"), prop("Password"));

		SettingsPage settingsPage = new SettingsPage(driver);

		SearchListPage searchListPage = new SearchListPage(driver);

		settingsPage.clickOnSearchListTab();

		searchListPage.clickOnNewListButton();

		String enterBookingListName = "Searchlist" + Random("A", 10).toLowerCase() + " "
				+ DateTime("dd MM YYYY");

		searchListPage.enterListName(enterBookingListName);

		searchListPage.selectScheduledActivity();

		searchListPage.selectOrder();

		searchListPage.selectScheduledActivityRange();

		searchListPage.selectPurpose();

		searchListPage.clickOnSaveButton();

		Thread.sleep(2000);

		System.out.println("Started verification");
		Assert.assertEquals(searchListPage.getLestName(), enterBookingListName, "Not matched");
		System.out.println("Completed verification");
	}
}