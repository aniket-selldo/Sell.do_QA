package listsPack;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.adminPages.SearchListPage;
import com.selldo.POM.adminPages.SettingsPage;
import com.selldo.POM.crm.ClientLoginPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;

public class AddingNewLeadSearchListTest extends BaseTest {

	@Test

	public void addingNewLeadSearchListTest() throws Exception {

		LoginPage login = new LoginPage(driver);

		login.login(prop.getProperty("superadmin_name") + prop.getProperty("superadmin_email"),
				prop.getProperty("password"));
		ClientLoginPage clientLogin = new ClientLoginPage(driver);

		clientLogin.clientLogin("Aniket Automation");// prop.getProperty("Other_client_name")
		SettingsPage settingsPage = new SettingsPage(driver);

		SearchListPage searchListPage = new SearchListPage(driver);

		//test.log(Status.INFO, "Clicking on Search List tab...........");
		settingsPage.clickOnSearchListTab();

		//test.log(Status.INFO, "Clicking on New List button.........");
		searchListPage.clickOnNewListButton();

		String enterBookingListName="Searchlist"+random("enterBookingListName","A",10).toLowerCase() +" "+DateTime("dd MM YYYY");

		//test.log(Status.INFO, "Entering List name....................");
		searchListPage.enterListName(enterBookingListName);

		//test.log(Status.INFO, "Selecting Scheduled Activity..........");
		searchListPage.selectScheduledActivity();

		//test.log(Status.INFO, "Selecting Order......");
		searchListPage.selectOrder();

		//test.log(Status.INFO, "Selecting Scheduled Activity range....");
		searchListPage.selectScheduledActivityRange();

		//test.log(Status.INFO, "Selecting Purpose.....................");
		searchListPage.selectPurpose();

		//test.log(Status.INFO, "Clicking on Save button...............");
		searchListPage.clickOnSaveButton();

		Thread.sleep(2000);

		//test.log(Status.INFO, "Validating lead search list name after adding new lead search list.....");
		System.out.println("Started verification");
		Assert.assertEquals(searchListPage.getLestName(),enterBookingListName, "Not matched");
		System.out.println("Completed verification");
	}
}