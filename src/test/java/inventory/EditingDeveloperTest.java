package inventory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.crm.ClientLoginPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.inventory.DevelopersPage;
import com.selldo.POM.inventory.EditDeveloperFormPage;
import com.selldo.Utility.BaseTest;

public class EditingDeveloperTest extends BaseTest {

	@Test
	public void editingDeveloperTest() throws Exception {

		LoginPage login = new LoginPage(driver);

		login.login(prop("Clinet_Email"), prop("Password"));

		DevelopersPage developersPage = new DevelopersPage(driver);

		EditDeveloperFormPage editDeveloperFormPage = new EditDeveloperFormPage(driver);

		WebElement element = driver.findElement(By.cssSelector("i.ion-cube"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		driver.findElement(By.linkText("Developers")).click();

		developersPage.clickOnFunnelIcon();

		String developerName = developersPage.getAnyDevloperName();

		developersPage.enterDeveloperName(developerName);

		developersPage.clickOnApplyButton();

		Assert.assertEquals(driver.findElement(By.xpath("//a[text()='All Developers']/following::label[1]")).getText(),
				developerName, "Not matched");

		String changedDeveloperName = Random("A", 10).toUpperCase();

		editDeveloperFormPage.changeDeveloperName(changedDeveloperName);

		editDeveloperFormPage.clickOnSaveButton();

		Assert.assertEquals(driver.findElement(By.xpath("//a[text()='All Developers']/following::label[1]")).getText(),
				changedDeveloperName, "Not matched");

		editDeveloperFormPage.clickOnAddressLink();

		Assert.assertEquals(driver.findElement(By.xpath("//label[@for='developer_address_address1']"))
				.getAttribute("innerHTML").trim(), "Address", "Not matched");

		driver.navigate().back();

		editDeveloperFormPage.clickOnContactsLink();

		Assert.assertEquals(
				driver.findElement(By.xpath("//label[contains(text(),'Salutation')]")).getAttribute("innerHTML").trim(),
				"Salutation", "Not matched");

		driver.navigate().back();

		editDeveloperFormPage.clickOnAllDevelopers();

		Assert.assertEquals(
				driver.findElement(By.xpath("//a[text()='New Developer']")).getAttribute("innerHTML").trim(),
				"New Developer", "Not matched");

		driver.navigate().back();

		editDeveloperFormPage.clickOnAddDeveloper();

	}

}
