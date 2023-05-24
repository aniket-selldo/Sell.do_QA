package otherLeadActivitiesPack;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.SalesPresalesDashboardPage;
import com.selldo.Utility.BaseTest;

public class AddingInterestedPropertyTest extends BaseTest {
	
	@Test
	public void addingInterestedPropertyTest() throws Exception {
		LoginPage login = new LoginPage(driver);
		login.login(prop.getProperty("name"), prop.getProperty("password"));

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);

		SalesPresalesDashboardPage salesPresalesDashboard = new SalesPresalesDashboardPage(driver);

		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);

		//getExtTest().log(Status.INFO, "Going to All Lead List.......");
		salesPresalesDashboard.goToAllLeadsList();

		//Thread.sleep(2000);

		//getExtTest().log(Status.INFO, "Selecting Incoming list......");
		adminDashboardPage.SelectList("Incoming");

		//getExtTest().log(Status.INFO, "Opening Lead Deatils Page.......");
		salesPresalesDashboard.openLeadDetails(2);
		//adminDashboardPage.searchLead(Integer.parseInt(R('1', '2', '3', '4', '5', '6')), "Prospect");

		//Thread.sleep(2000);

		jse.executeScript("window.scrollBy(0,600)", "");

		//getExtTest().log(Status.INFO, "selecting project to add on lead.......");
		String projectName = leadProfilePage.selectProject(0);

		//getExtTest().log(Status.INFO, "capturig project to be added on lead.......");
		//String projectName = leadProfilePage.projectName();
		System.out.println(projectName);

		//Thread.sleep(2000);

		//getExtTest().log(Status.INFO, "Adding Project on lead.......");
		//driver.findElement(leadProfilePage.addButton).click();
		leadProfilePage.clickOnAddButton();
		//Thread.sleep(2000);

		//jse.executeScript("window.scrollTo(0,0)", "");

		//getExtTest().log(Status.INFO, "Clicking on Feed tab.......");
		leadProfilePage.clickFeedTab();

		//getExtTest().log(Status.INFO, "Fetching the text appeared after adding project....");
		String text = driver.findElement(By.cssSelector(
				"#tab-activity > div.activities_list > div:nth-child(1) > div > div.card > div > div > div > span:nth-child(1)"))
				.getText().trim();


		//getExtTest().log(Status.INFO, "Verifying that Project " + projectName + " added successfully on lead....");
		AssertJUnit.assertEquals("Lead showed interest in " + projectName + "", text);
		// sell.do Project

	}

}
