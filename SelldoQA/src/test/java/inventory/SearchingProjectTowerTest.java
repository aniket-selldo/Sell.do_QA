package inventory;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.mail.EmailException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import adminPages.AdminDashboardPage;
import crm.selldo.ClientLoginPage;
import crm.selldo.LoginPage;
import utility.SetUp;

public class SearchingProjectTowerTest extends SetUp {

	final static Logger logger = Logger.getLogger(SearchingProjectTowerTest.class);

	// Description:

	@BeforeTest

	public void sales_presalesLogin() throws Exception {

		mysetUp();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		Properties property = new Properties();
		FileInputStream fileInputObj = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//java//Config File//global.properties");
		property.load(fileInputObj);

		LoginPage login = new LoginPage(driver);

		logger.info("Logging in to client page.......");
		login.login(property.getProperty("superadmin_name") + property.getProperty("superadmin_email"),
				property.getProperty("password"));

		ClientLoginPage clientLogin = new ClientLoginPage(driver);

		logger.info("Logging in to Admin/Support Home Page......");
		clientLogin.clientLogin(property.getProperty("client_name"));

	}

	@AfterTest

	public void endingTest() throws Exception {

		Thread.sleep(3000);

		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);

		logger.info("Logging out of Selldo......");
		adminDashboardPage.loggingOut();

		logger.info("Closing Browser......");
		driver.close();
	}

	@Test

	public void searchingProjectTowerTest() throws Exception {

		test = extent.createTest("searchingProjectTowerTest");
		setExtentTest(test);

		Properties property = new Properties();
		FileInputStream fileInputObj = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//java//Config File//global.properties");
		property.load(fileInputObj);

		Thread.sleep(3000);

		ProjectTowersPage projectTowersPage = new ProjectTowersPage(driver);

		SoftAssert assertion = new SoftAssert();

		test.log(Status.INFO, "Selecting Project Towers by mouse hovering over Inventory icon.......");
		WebElement element = driver.findElement(By.cssSelector("i.ion-cube"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		driver.findElement(By.linkText("Project Towers")).click();

		test.log(Status.INFO, "Cicking on Funnel Icon.....");
		projectTowersPage.clickOnFunnelIcon();

		String projectTowerName = property.getProperty("projectTower_name_searchingProjectTowerTest");

		test.log(Status.INFO, "Entering Project Tower's name to be searched......");
		projectTowersPage.enterProjectTowerName(projectTowerName);

		test.log(Status.INFO, "Cicking on Apply button.....");
		projectTowersPage.clickOnApplyButton();

		test.log(Status.INFO, "Verifying that Project Tower is searched......");
		AssertJUnit.assertEquals(
				driver.findElement(By.xpath("//a[text()='All Project Towers']/following::label[1]")).getText(),
				projectTowerName, "Not matched");

		assertion.assertAll();

	}

}
