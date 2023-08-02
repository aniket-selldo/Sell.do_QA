package inventory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.inventory.UnitsPage;
import com.selldo.Utility.BaseTest;

public class SearchingUnitTest extends BaseTest {

	@Test
	public void searchingUnitTest() throws Exception {

		LoginPage login = new LoginPage(driver);

		login.login(prop("Client_id"), prop("Password"));

		Thread.sleep(3000);

		UnitsPage unitsPage = new UnitsPage(driver);

		WebElement element = driver.findElement(By.cssSelector("i.ion-cube"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		driver.findElement(By.linkText("Units")).click();

		String unitName = unitsPage.getAnyUnitName();
		unitsPage.clickOnFunnelIcon();

		unitsPage.enterUnitName(unitName);

		unitsPage.clickOnApplyButton();

		Assert.assertEquals(driver.findElement(By.xpath("//a[text()='All Units']/following::label[1]")).getText(),
				unitName, "Not matched");

	}

}
