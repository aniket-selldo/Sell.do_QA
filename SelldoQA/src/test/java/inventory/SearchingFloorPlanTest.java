package inventory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.crm.ClientLoginPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.inventory.FloorPlansPage;
import com.selldo.Utility.BaseTest;

public class SearchingFloorPlanTest extends BaseTest {


	@Test
	public void searchingFloorPlanTest() throws Exception {

		LoginPage login = new LoginPage(driver);

		login.login(prop.getProperty("id"), prop.getProperty("password"));

		ClientLoginPage clientLogin = new ClientLoginPage(driver);

		clientLogin.clientLogin(prop.getProperty("Client"));

		FloorPlansPage floorPlansPage = new FloorPlansPage(driver);


		WebElement element = driver.findElement(By.cssSelector("i.ion-cube"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		driver.findElement(By.linkText("Floor Plans")).click();

		String floorPlanName =  floorPlansPage.getAnyFloorPlanName();
		floorPlansPage.clickOnFunnelIcon();


		floorPlansPage.enterFloorPlanName(floorPlanName);

		floorPlansPage.clickOnFilterButton();

		Assert.assertEquals(driver.findElement(By.xpath("//a[text()='All Floor Plans']/following::label[1]")).getText(),
				floorPlanName, "Not matched");

	}

}
