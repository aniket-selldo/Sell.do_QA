package otherLeadActivitiesPack;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.crm.LeadBookingFormPage;
import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.SalesPresalesDashboardPage;
import com.selldo.Utility.BaseTest;

import API.APIs;

public class LeadBooking_NonInventory_TentativeTest extends BaseTest {

	@Test
	public void bookingALead_ConfirmedTest() throws Exception {

		LoginPage login = new LoginPage(driver);
		login.login(prop("Sales_email"), prop("Password"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);

		SalesPresalesDashboardPage salesPresalesDashboard = new SalesPresalesDashboardPage(driver);

		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);
		adminDashboardPage.searchLead("#" + new APIs().createLead(prop("Sales_id")).getSell_do_lead_id());

		String leadIdObj = driver.findElement(By.cssSelector("span[name='lead_id']")).getText().replaceAll("\\s+", "");
		System.out.println(leadIdObj);

		Thread.sleep(4000);

		leadProfilePage.changing_Stage("Booked");

		LeadBookingFormPage leadBooking = new LeadBookingFormPage(driver);
		leadBooking.selectProject(new APIs().getdisableEnventryName() );
		leadBooking.addPhoneNumber(randomPhone());

		Thread.sleep(3000);

		jse.executeScript("window.scrollBy(0,250)", "");

		leadBooking.selectUnitType("villa");

		leadBooking.inputFloorNumber(Random("N",1));

		leadBooking.inputUnitNumber(Random("N",1));

		leadBooking.inputBuildingName(Random("N",1));

		leadBooking.inputCarpetArea(Random("N",3));

		leadBooking.inputSaleableArea(Random("N",3));

		leadBooking.inputParkingNumber(Random("N",2));

		leadBooking.inputBedroomPreferences(R('1','2','3'));

		leadBooking.inputPanNumber(randomPAN());

		leadBooking.inputBasicRate(Random("N",5));

		leadBooking.inputEffectiveRate(Random("N",5));

		leadBooking.inputOffer("New Offer");

		leadBooking.inputAddressAndStreet(Random("A",10),Random("A",10));

		leadBooking.inputCityAndState("Pune","Maharashtra");

		leadBooking.inputCountryAndZip(Random("N",6));

		leadBooking.clickOnSaveButton();

		Thread.sleep(4000);

		leadProfilePage.selectBookings();

		Thread.sleep(2000);

		System.out.println("Started verification");
		Assert.assertEquals(driver.findElement(By.xpath("//span[@class='badge badge-success']")).getText(), "Tentative",
				"Not matched");
		Assert.assertEquals(driver.findElement(By.xpath("//button[text()='Add new Booking']")).getText(),
				"Add new Booking", "Not matched");
		Assert.assertEquals(
				driver.findElement(By.xpath("//button[@class='btn btn-default close_profile_form']")).getText(),
				"Close", "Not matched");
		System.out.println("Completed verification");

		Thread.sleep(1000);

		leadProfilePage.clickOnCloseButton_Bookingdetails();

		Thread.sleep(3000);

		salesPresalesDashboard.searchLead(leadIdObj);

		String textDropdownObj = driver
				.findElement(By.xpath("//button[@class='btn dropdown-toggle btn-sm btn-outline-primary']//span"))
				.getAttribute("innerHTML").trim();
		System.out.println(textDropdownObj);

		Assert.assertEquals(textDropdownObj, "Booked", "Not matched");

	}

}
