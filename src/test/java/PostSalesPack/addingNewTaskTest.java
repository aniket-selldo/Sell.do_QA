package PostSalesPack;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.SalesPresalesDashboardPage;
import com.selldo.Utility.BaseTest;
import com.selldo.Utility.GetTestData;

import postSales.PostSalesDashboardPage;
import postSales.TaskPage;

public class addingNewTaskTest extends BaseTest {

	@Test
	public void addingNewTaskTest() throws Exception {
		LoginPage login = new LoginPage(driver);
		login.login("tanvi+ps2_manager@sell.do", prop("Password"));

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);

		SalesPresalesDashboardPage salesPresalesDashboard = new SalesPresalesDashboardPage(driver);
		PostSalesDashboardPage postsalesDashboardPage = new PostSalesDashboardPage(driver);

		postsalesDashboardPage.clickOnConfirmedBookingsBucket();

		Thread.sleep(2000);

		postsalesDashboardPage.openLeadProfile();

		Thread.sleep(2000);

		jse.executeScript("window.scrollBy(0,600)", "");

		TaskPage taskPage = new TaskPage(driver);

		taskPage.addingTask();

		GetTestData getTestData = new GetTestData();

		String titleNameObj = getTestData.title;
		System.out.println(titleNameObj);
		taskPage.inputTasktitle(titleNameObj);

		String descriptionNameObj = getTestData.description;
		System.out.println(descriptionNameObj);
		taskPage.inputTaskDescription(descriptionNameObj);
		Thread.sleep(2000);
		taskPage.selectDate();

		taskPage.selectSalesUser("Aniket");

		/*
		 * getExtTest().log(Status.INFO, " Adding attachment for the task.......");
		 * taskPage.clickOnUploadAttachments();
		 */

		taskPage.clickOnSaveButton();

		Thread.sleep(2000);

		driver.navigate().refresh();

		Thread.sleep(5000);

		String text = driver.findElement(By.xpath("//span[contains(text(),'Get Document')]")).getText().trim();
		text = text.replaceAll("'Get Document'", "Get Document");
		System.out.println(text);

		String expectedString = "The task " + titleNameObj + " is assigned to "
				+ "Aniket" + ".";

		SoftAssert assertion = new SoftAssert();

		Assert.assertEquals(text, titleNameObj);
		assertion.assertAll();

	}


}