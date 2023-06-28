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
import com.selldo.POM.inventory.NewDeveloperFormPage;
import com.selldo.Utility.BaseTest;

public class AddingNewDeveloperTest extends BaseTest {

	String developerName;

	@Test
	public void addingNewDeveloperTest() throws Exception {

		LoginPage login = new LoginPage(driver);

		login.login(prop.getProperty("id"), prop.getProperty("password"));

		ClientLoginPage clientLogin = new ClientLoginPage(driver);

		clientLogin.clientLogin(prop.getProperty("Client"));

		DevelopersPage developersPage = new DevelopersPage(driver);

		NewDeveloperFormPage newDeveloperFormPage = new NewDeveloperFormPage(driver);

		extentTest.get().log(Status.INFO, "Selecting Developres by mouse hovering over Inventory icon.......");
		WebElement element = driver.findElement(By.cssSelector("i.ion-cube"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		driver.findElement(By.linkText("Developers")).click();

		extentTest.get().log(Status.INFO, "Cicking on New Developer button......");
		developersPage.clickOnNewDevekoperButton();

		developerName = Random("A", 5).toUpperCase() + " " + DateTime("dd/MM/yyyy HH:mm:ss");

		extentTest.get().log(Status.INFO, "Entering Developer name......");
		newDeveloperFormPage.enterDeveloperName(developerName);

		extentTest.get().log(Status.INFO, "Entering some description about developer......");
		newDeveloperFormPage.enterDescription(Random("AN", 200));

		extentTest.get().log(Status.INFO, "Entering Address......");
		newDeveloperFormPage.enterAddress(prop.getProperty("address_addingNewDeveloperTest"));

		extentTest.get().log(Status.INFO, "Entering Street......");
		newDeveloperFormPage.enterStreet(prop.getProperty("street_addingNewDeveloperTest"));

		String city = prop.getProperty("city_addingNewDeveloperTest");

		extentTest.get().log(Status.INFO, "Entering City......");
		newDeveloperFormPage.enterCity(city);

		extentTest.get().log(Status.INFO, "Selecting Country......");
		newDeveloperFormPage.selectCountry(prop.getProperty("country_addingNewDeveloperTest"));

		extentTest.get().log(Status.INFO, "Selecting State......");
		newDeveloperFormPage.selectState(prop.getProperty("state_addingNewDeveloperTest"));

		extentTest.get().log(Status.INFO, "Entering Zip......");
		newDeveloperFormPage.enterZip(prop.getProperty("zip_addingNewDeveloperTest"));

		extentTest.get().log(Status.INFO, "Selecting Salutation......");
		newDeveloperFormPage.selectSalutation();

		String name = Random("A", 10);

		extentTest.get().log(Status.INFO, "Entering First Name......");
		newDeveloperFormPage.enterFirstName(name);

		extentTest.get().log(Status.INFO, "Entering Last Name......");
		newDeveloperFormPage.enterLastName(prop.getProperty("lastName_addingNewDeveloperTest"));

		extentTest.get().log(Status.INFO, "Entering Phone number......");
		newDeveloperFormPage.enterPhoneNumber(" " + prop.getProperty("phone_addingNewDeveloperTest"));

		extentTest.get().log(Status.INFO, "Entering Email......");
		newDeveloperFormPage.enterEmail(name + "@" + "gmail.com");

		extentTest.get().log(Status.INFO, "Clicking on Save button......");
		newDeveloperFormPage.clickOnSaveButton();

		// developerName =
		// driver.findElement(By.cssSelector("label[class='lead']")).getText();

		extentTest.get().log(Status.INFO, "Verifying that developer is added from Edit form.......");
		Assert.assertEquals(newDeveloperFormPage.getDevlopersName2(), developerName, "Not matched");
		Assert.assertEquals(newDeveloperFormPage.getDevlopersName(), developerName, "Not matched");

	}
}
