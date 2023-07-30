package inventory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.crm.ClientLoginPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.inventory.DevelopersPage;
import com.selldo.Utility.BaseTest;

public class SearchingDeveloperTest extends BaseTest {

	@Test
	public void searchingDeveloperTest() throws Exception {

		LoginPage login = new LoginPage(driver);

		login.login(prop.getProperty("id"), prop.getProperty("password"));

		ClientLoginPage clientLogin = new ClientLoginPage(driver);

		clientLogin.clientLogin(prop.getProperty("Client"));

		Thread.sleep(3000);

		DevelopersPage developersPage = new DevelopersPage(driver);

		WebElement element = driver.findElement(By.cssSelector("i.ion-cube"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		driver.findElement(By.linkText("Developers")).click();

		String developerName = developersPage.getAnyDevloperName();
		developersPage.clickOnFunnelIcon();

		developersPage.enterDeveloperName(developerName);

		developersPage.clickOnApplyButton();

		Assert.assertEquals(driver.findElement(By.xpath("//a[text()='All Developers']/following::label[1]")).getText(),
				developerName, "Not matched");

	}

}
