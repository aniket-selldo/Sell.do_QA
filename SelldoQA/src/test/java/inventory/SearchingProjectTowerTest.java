package inventory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.crm.ClientLoginPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.inventory.ProjectTowersPage;
import com.selldo.Utility.BaseTest;

public class SearchingProjectTowerTest extends BaseTest {

	@Test
	public void searchingProjectTowerTest() throws Exception {

		LoginPage login = new LoginPage(driver);

		login.login(prop("Client_id"), prop("Password"));
		Thread.sleep(3000);

		ProjectTowersPage projectTowersPage = new ProjectTowersPage(driver);

		WebElement element = driver.findElement(By.cssSelector("i.ion-cube"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		driver.findElement(By.linkText("Project Towers")).click();

		String projectTowerName = projectTowersPage.getAnyprojectTowerName();
		projectTowersPage.clickOnFunnelIcon();

		projectTowersPage.enterProjectTowerName(projectTowerName);

		projectTowersPage.clickOnApplyButton();

		Assert.assertEquals(
				driver.findElement(By.xpath("//a[text()='All Project Towers']/following::label[1]")).getText(),
				projectTowerName, "Not matched");

	}

}
