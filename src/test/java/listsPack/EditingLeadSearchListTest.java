package listsPack;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.selldo.POM.adminPages.SearchListPage;
import com.selldo.POM.adminPages.SettingsPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;

public class EditingLeadSearchListTest extends BaseTest {

	@Test
	public void editingLeadSearchListTest() throws Exception {
		LoginPage login = new LoginPage(driver);

		login.login(prop("Clinet_Email"), prop("Password"));

		SettingsPage settingsPage = new SettingsPage(driver);

		SearchListPage SearchListPage = new SearchListPage(driver);

		settingsPage.clickOnSearchListTab();

		SearchListPage.selectEditLink();

		String listName = "Searchlist Name Change " + DateTime("DD MM YYYY");

		SearchListPage.changeListName(listName);

		SearchListPage.changeScheduledActivity();

		SearchListPage.clickOnSaveButton();

		System.out.println("Started verification");

		driver.findElement(By.xpath("//th[text()='name']/following::span[1]")).getAttribute("innerHTML")
				.contentEquals(listName);
		System.out.println("Completed verification");

	}

}
