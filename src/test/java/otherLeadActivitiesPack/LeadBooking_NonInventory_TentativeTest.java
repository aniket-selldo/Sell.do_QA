package otherLeadActivitiesPack;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
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
		;

		// getExtTest().log(Status.INFO, "Getting Lead Id whose stage is to be
		// changed.......");
		String leadIdObj = driver.findElement(By.cssSelector("span[name='lead_id']")).getText().replaceAll("\\s+", "");
		System.out.println(leadIdObj);

		Thread.sleep(4000);

		leadProfilePage.changing_Stage("Booked");

		LeadBookingFormPage leadBooking = new LeadBookingFormPage(driver);
		leadBooking.selectProject("Mamta Building");
		leadBooking.addPhoneNumber(prop.getProperty("Applicant_Phone_Number"));

		Thread.sleep(3000);

		jse.executeScript("window.scrollBy(0,250)", "");

		leadBooking.selectUnitType(prop.getProperty("UnitType_BookingALead"));

		leadBooking.inputFloorNumber(prop.getProperty("FloorNumber_BookingALead"));

		leadBooking.inputUnitNumber(prop.getProperty("UnitNumber_BookingALead"));

		leadBooking.inputBuildingName(prop.getProperty("BuildingName_BookingALead"));

		leadBooking.inputCarpetArea(prop.getProperty("CarpetArea_BookingALead"));

		leadBooking.inputSaleableArea(prop.getProperty("SaleableArea_BookingALead"));

		leadBooking.inputParkingNumber(prop.getProperty("ParkingNumber_BookingALead"));

		leadBooking.inputBedroomPreferences(prop.getProperty("BedroomPreferences_BookingALead"));

		leadBooking.inputPanNumber(prop.getProperty("PanNumber_BookingALead"));

		leadBooking.inputBasicRate(prop.getProperty("BasicRate_BookingALead"));

		leadBooking.inputEffectiveRate(prop.getProperty("EffectiveRate_BookingALead"));

		leadBooking.inputOffer(prop.getProperty("InputOffer_BookingALead"));

		leadBooking.inputAddressAndStreet(prop.getProperty("Address_BookingALead"),
				prop.getProperty("Street_BookingALead"));

		leadBooking.inputCityAndState(prop.getProperty("City_BookingALead"), prop.getProperty("State_BookingALead"));

		leadBooking.inputCountryAndZip(prop.getProperty("Zip_BookingALead"));

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
