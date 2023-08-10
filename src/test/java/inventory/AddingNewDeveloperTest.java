package inventory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

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

		login.login(prop("Clinet_Email"), prop("Password"));

		DevelopersPage developersPage = new DevelopersPage(driver);

		NewDeveloperFormPage newDeveloperFormPage = new NewDeveloperFormPage(driver);

		WebElement element = driver.findElement(By.cssSelector("i.ion-cube"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		driver.findElement(By.linkText("Developers")).click();

		developersPage.clickOnNewDevekoperButton();

		developerName = Random("A", 5).toUpperCase() + " " + DateTime("dd/MM/yyyy HH:mm:ss");

		newDeveloperFormPage.enterDeveloperName(developerName);

		newDeveloperFormPage.enterDescription(Random("AN", 200));

		newDeveloperFormPage.enterAddress(Random("A",10));

		newDeveloperFormPage.enterStreet(Random("A",10));

		String city = Random("A",10);

		newDeveloperFormPage.enterCity(city);

		newDeveloperFormPage.selectCountry("India");

		newDeveloperFormPage.selectState("Maharashtra");

		newDeveloperFormPage.enterZip(Random("N", 6));

		newDeveloperFormPage.selectSalutation();

		newDeveloperFormPage.enterFirstName(Random("A", 10));

		newDeveloperFormPage.enterLastName(Random("A", 10));

		newDeveloperFormPage.enterPhoneNumber(randomPhone());

		newDeveloperFormPage.enterEmail(randomEmail());

		newDeveloperFormPage.alternateEmail(randomEmail());

		newDeveloperFormPage.enterAlternateNumber(randomPhone());

		newDeveloperFormPage.PAN((Random("A",5)+Random("N",4)+Random("A",1)).toUpperCase());

		newDeveloperFormPage.designation(Random("A", 5));

		newDeveloperFormPage.clickOnSaveButton();

		Thread.sleep(1000);
		Assert.assertEquals(newDeveloperFormPage.getDevlopersName(), developerName, "Not matched");

	}
}
