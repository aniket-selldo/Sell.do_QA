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

public class LeadBooking_NonInventory_ConfirmedTest extends BaseTest {

	@Test
	public void bookingALead_ConfirmedTest() throws Exception {

		LoginPage login = new LoginPage(driver);
		login.login(prop("Sales_email"), prop("Password"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);

		SalesPresalesDashboardPage salesPresalesDashboard = new SalesPresalesDashboardPage(driver);

		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);
		adminDashboardPage.searchLead("#"+new APIs().createLead(prop("Sales_id")).getSell_do_lead_id());

		String leadIdObj = driver.findElement(By.cssSelector("span[name='lead_id']")).getText().replaceAll("\\s+", "");
		System.out.println(leadIdObj);

		leadProfilePage.changing_Stage("Booked");

		LeadBookingFormPage leadBooking = new LeadBookingFormPage(driver);
		//leadBooking.selectProject("Mamta Building");
		leadBooking.selectProject("Mamta Building");
		leadBooking.addPhoneNumber(randomPhone());

		jse.executeScript("window.scrollBy(0,250)", "");

		//leadBooking.selectStage("Confirmed");

		leadBooking.selectUnitType("Apartment");

		leadBooking.inputFloorNumber("3");

		leadBooking.inputUnitNumber("4");

		leadBooking.inputBuildingName("Building2");

		leadBooking.inputCarpetArea("1000");

		leadBooking.inputSaleableArea("1200");

		leadBooking.inputParkingNumber("304");

		leadBooking.inputBedroomPreferences("2 BHK");

		leadBooking.inputPanNumber("ASXCD1234S");

		leadBooking.inputBasicRate("1000");

		leadBooking.inputEffectiveRate("10000");

		leadBooking.inputOffer("New Offer");

		leadBooking.inputAddressAndStreet("Balewadi", "Dashra");

		leadBooking.inputCityAndState("Pune", "Maharashtra");

		leadBooking.inputCountryAndZip("411024");

		leadBooking.clickOnSaveButton();
		
		leadProfilePage.selectBookings();
		
		Thread.sleep(4000);
		System.out.println("Started verification");
		Assert.assertEquals(driver.findElement(By.xpath("//span[@class='badge badge-success']")).getText(),
				"Tentative", "Not matched");
		Assert.assertEquals(driver.findElement(By.xpath("//button[text()='Add new Booking']")).getText(),
				"Add new Booking", "Not matched");
		Assert.assertEquals(
				driver.findElement(By.xpath("//button[@class='btn btn-default close_profile_form']")).getText(),
				"Close", "Not matched");
		System.out.println("Completed verification");

		leadProfilePage.clickOnCloseButton_Bookingdetails();

		salesPresalesDashboard.searchLead(leadIdObj);

		String textDropdownObj = driver
				.findElement(By.xpath("//button[@class='btn dropdown-toggle btn-sm btn-outline-primary']//span"))
				.getAttribute("innerHTML").trim();
		System.out.println(textDropdownObj);

		Assert.assertEquals(textDropdownObj, "Booked", "Not matched");

	}

}
