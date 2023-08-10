package inventory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.inventory.EditProjectTowerFormPage;
import com.selldo.POM.inventory.ProjectTowersPage;
import com.selldo.Utility.BaseTest;

public class EditingProjectTowerTest extends BaseTest {

	@Test
	public void editingProjectTowerTest() throws Exception {
		LoginPage login = new LoginPage(driver);

		login.login(prop("Clinet_Email"), prop("Password"));

		ProjectTowersPage projectTowersPage = new ProjectTowersPage(driver);

		EditProjectTowerFormPage editProjectTowerFormPage = new EditProjectTowerFormPage(driver);

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

		Thread.sleep(3000);

		String changedProjectTowerName = Random("A", 10).toUpperCase();

		editProjectTowerFormPage.changeProjectTowerName(changedProjectTowerName);

		editProjectTowerFormPage.clickOnSaveButton();

		Thread.sleep(2000);

		Assert.assertEquals(
				driver.findElement(By.xpath("//a[text()='All Project Towers']/following::label[1]")).getText(),
				changedProjectTowerName, "Not matched");

		editProjectTowerFormPage.clickOnAreaAndCostingLink();

		Assert.assertEquals(driver.findElement(By.xpath("//label[@for='project_tower_total_builtup_area']"))
				.getAttribute("innerHTML").trim(), "Total builtup area", "Not matched");

		driver.navigate().back();

		editProjectTowerFormPage.clickOnOtherDetailsLink();

		driver.navigate().back();

		editProjectTowerFormPage.clickOnCostTemplateLink();

		driver.navigate().back();

		editProjectTowerFormPage.clickOnPaymentScheduleLink();

		Assert.assertEquals(driver.findElement(By.xpath("//a[text()='New Schedule']")).getAttribute("innerHTML").trim(),
				"New Schedule", "Not matched");




	}
}
