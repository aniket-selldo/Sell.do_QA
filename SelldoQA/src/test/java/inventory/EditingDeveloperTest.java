package inventory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.selldo.POM.crm.ClientLoginPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.inventory.DevelopersPage;
import com.selldo.POM.inventory.EditDeveloperFormPage;
import com.selldo.Utility.BaseTest;

public class EditingDeveloperTest extends BaseTest {

	@Test
	public void editingDeveloperTest() throws Exception {

		LoginPage login = new LoginPage(driver);

		login.login(prop.getProperty("id"), prop.getProperty("password"));

		ClientLoginPage clientLogin = new ClientLoginPage(driver);

		clientLogin.clientLogin(prop.getProperty("Client"));

		DevelopersPage developersPage = new DevelopersPage(driver);

		EditDeveloperFormPage editDeveloperFormPage = new EditDeveloperFormPage(driver);

		extentTest.get().log(Status.INFO, "Selecting Developres by mouse hovering over Inventory icon.......");
		WebElement element = driver.findElement(By.cssSelector("i.ion-cube"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		driver.findElement(By.linkText("Developers")).click();

		extentTest.get().log(Status.INFO, "Clicking on Funnel Icon.....");
		developersPage.clickOnFunnelIcon();

		String developerName = developersPage.getAnyDevloperName();

		extentTest.get().log(Status.INFO, "Entering Developer's name to be searched......");
		developersPage.enterDeveloperName(developerName);

		extentTest.get().log(Status.INFO, "Cicking on Filter button.....");
		developersPage.clickOnApplyButton();

		extentTest.get().log(Status.INFO, "Verifying that Developer is searched whose name to be changed.......");
		Assert.assertEquals(driver.findElement(By.xpath("//a[text()='All Developers']/following::label[1]")).getText(),
				developerName, "Not matched");

		Thread.sleep(3000);

		String changedDeveloperName = Random("A",10).toUpperCase();

		extentTest.get().log(Status.INFO, "Changing Developer's name......");
		editDeveloperFormPage.changeDeveloperName(changedDeveloperName);

		extentTest.get().log(Status.INFO, "Clicking on Save Button......");
		editDeveloperFormPage.clickOnSaveButton();

		Thread.sleep(2000);

		extentTest.get().log(Status.INFO, "Verifying that Developer is changed by new name......");
		Assert.assertEquals(driver.findElement(By.xpath("//a[text()='All Developers']/following::label[1]")).getText(),
				changedDeveloperName, "Not matched");

		extentTest.get().log(Status.INFO, "Clicking on Address link......");
		editDeveloperFormPage.clickOnAddressLink();

		extentTest.get().log(Status.INFO, "Verifying Address link.......");
		Assert.assertEquals(driver.findElement(By.xpath("//label[@for='developer_address_address1']"))
				.getAttribute("innerHTML").trim(), "Address", "Not matched");

		driver.navigate().back();

		extentTest.get().log(Status.INFO, "Clicking on Contacts link......");
		editDeveloperFormPage.clickOnContactsLink();

		extentTest.get().log(Status.INFO, "Verifying Contacts link.......");
		Assert.assertEquals(
				driver.findElement(By.xpath("//label[contains(text(),'Salutation')]")).getAttribute("innerHTML").trim(),
				"Salutation", "Not matched");

		driver.navigate().back();

		extentTest.get().log(Status.INFO, "Clicking on All Developers link......");
		editDeveloperFormPage.clickOnAllDevelopers();

		extentTest.get().log(Status.INFO, "Verifying All Developers link.......");
		Assert.assertEquals(
				driver.findElement(By.xpath("//a[text()='New Developer']")).getAttribute("innerHTML").trim(),
				"New Developer", "Not matched");

		driver.navigate().back();

		extentTest.get().log(Status.INFO, "Clicking on Add Developer link......");
		editDeveloperFormPage.clickOnAddDeveloper();

	}

}
