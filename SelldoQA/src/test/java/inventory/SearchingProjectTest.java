package inventory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.crm.ClientLoginPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.inventory.ProjectsPage;
import com.selldo.Utility.BaseTest;

public class SearchingProjectTest extends BaseTest {

	@Test
	public void searchingProjectTest() throws Exception {

		LoginPage login = new LoginPage(driver);

		login.login(prop.getProperty("id"), prop.getProperty("password"));

		ClientLoginPage clientLogin = new ClientLoginPage(driver);

		clientLogin.clientLogin(prop.getProperty("Client"));

		ProjectsPage projectsPage = new ProjectsPage(driver);

		WebElement element = driver.findElement(By.cssSelector("i.ion-cube"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		driver.findElement(By.linkText("Projects")).click();

		projectsPage.clickOnFunnelIcon();

		String projectName = projectsPage.getAnyProjectName();

		projectsPage.enterProjectName(projectName);

		projectsPage.clickOnFilterButton();

		Assert.assertEquals(driver.findElement(By.xpath("//a[text()='All Projects']/following::label[1]")).getText(),
				projectName, "Not matched");

	}

}
