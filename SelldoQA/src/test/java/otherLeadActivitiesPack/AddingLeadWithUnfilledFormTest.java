package otherLeadActivitiesPack;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.selldo.POM.crm.AddLeadFormPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.SalesPresalesDashboardPage;
import com.selldo.Utility.BaseTest;

public class AddingLeadWithUnfilledFormTest extends BaseTest {

	@Test

	public void addingLeadWithUnfilledFormTest() throws Exception {
		LoginPage login = new LoginPage(driver);
		login.login(prop.getProperty("name"), prop.getProperty("password"));
		SalesPresalesDashboardPage salesPresalesDashboard = new SalesPresalesDashboardPage(driver);

		extentTest.get().log(Status.INFO, "Clicking on New Lead .......");
		salesPresalesDashboard.selectLeadActions(3);

		Thread.sleep(2000);

		AddLeadFormPage addLeadForm = new AddLeadFormPage(driver);

		extentTest.get().log(Status.INFO, "Clicking on Save button.......");
		addLeadForm.clickOnSaveButton();

		extentTest.get().log(Status.INFO, "Verifying error message below Primary Email Field.......");
		Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Primary Email']/following::span[1]"))
				.getAttribute("innerHTML"), "Please set atleast a phone or email for this customer", "Not matched");

		extentTest.get().log(Status.INFO, "Verifying error message below Primary Phone Field.......");
		Assert.assertEquals(
				driver.findElement(By.xpath("//label[text()='Tags']/preceding::p[1]")).getAttribute("innerHTML"),
				"Please set atleast a phone or email for this customer", "Not matched");

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)", "");

		extentTest.get().log(Status.INFO, "Verifying error message below Project Field.......");

		Assert.assertEquals(driver.findElement(By.cssSelector("#basic_info > div.form-group.has-error > span"))
				.getAttribute("innerHTML"), "Please add a Project as its a walkin lead.", "Not matched");

		extentTest.get().log(Status.INFO, "Clicking on Close button.......");
		addLeadForm.clickOnCloseButton();
		String alertString = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		Assert.assertEquals(alertString, "The form might have unsaved changes. Are you sure you want to close it?");
	}
}
