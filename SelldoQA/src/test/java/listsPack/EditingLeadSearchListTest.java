package listsPack;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.selldo.POM.adminPages.SearchListPage;
import com.selldo.POM.adminPages.SettingsPage;
import com.selldo.POM.crm.ClientLoginPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;

public class EditingLeadSearchListTest extends BaseTest {


	@Test

	public void editingLeadSearchListTest() throws Exception {
		LoginPage login = new LoginPage(driver);

		login.login(prop.getProperty("superadmin_name") + prop.getProperty("superadmin_email"),
				prop.getProperty("password"));
		ClientLoginPage clientLogin = new ClientLoginPage(driver);

		clientLogin.clientLogin("Aniket Automation");

		SettingsPage settingsPage = new SettingsPage(driver);

		SearchListPage SearchListPage = new SearchListPage(driver);


		//test.log(Status.INFO, "Clicking on Search List tab...........");
		settingsPage.clickOnSearchListTab();

		//test.log(Status.INFO, "Selecting Edit link from action bar...........");
		SearchListPage.selectEditLink();

		Thread.sleep(2000);

		String listName = "Searchlist Name Change " +DateTime("DD MM YYYY");

		//test.log(Status.INFO, "Changing List name....................");
		SearchListPage.changeListName(listName);

		//test.log(Status.INFO, "Selecting Scheduled Activity..........");
		SearchListPage.changeScheduledActivity();

		////test.log(Status.INFO, "Selecting Purpose.....................");
		//SearchListPage.changePurpose();

		//test.log(Status.INFO, "Clicking on Save button...............");
		SearchListPage.clickOnSaveButton();

		Thread.sleep(2000);

		//test.log(Status.INFO, "Validating lead search list name after editing new lead search list.....");
		System.out.println("Started verification");

		driver.findElement(By.xpath("//th[text()='name']/following::span[1]")).getAttribute("innerHTML").contentEquals(listName);
		System.out.println("Completed verification");

	}

}
