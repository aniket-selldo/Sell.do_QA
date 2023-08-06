package adminPack;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.selldo.POM.crm.ClientLoginPage;
import com.selldo.POM.crm.LeadBookingFormPage;
import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.SalesPresalesDashboardPage;
import com.selldo.POM.inventory.NewUnitFormPage;
import com.selldo.POM.inventory.UnitsPage;
import com.selldo.Utility.BaseTest;

import inventory.AddingNewUnitTest;

public class BookingALead_ConfirmedTest extends BaseTest {

//	@BeforeTest //
//
//	public void appLogin() throws Exception {
//
//		// Add new unit before booking a lead
//		AddingNewUnitTest addingNewUnitTest = new AddingNewUnitTest();
//
//		addingNewUnitTest.sales_presalesLogin();
//
//		addingNewUnitTest.addingNewUnitTest();
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//
//		addingNewUnitTest.endingTest();
//	}

	@Test
	public void bookingALead_ConfirmedTest() throws Exception {

		AddingNewUnitTest addingNewUnitTest = new AddingNewUnitTest();
		SalesPresalesDashboardPage salesPresalesDashboard = new SalesPresalesDashboardPage(driver);

		addNewUnit();
		driver.get(System.getProperty("user.dir") + "/users/logout");

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);

		LoginPage login = new LoginPage(driver);

		login.login(prop.getProperty("name") + "+" + prop.getProperty("user_email_bookingALead_ConfirmedTest"),
				prop.getProperty("password"));

		salesPresalesDashboard.goToAllLeadsList();

		salesPresalesDashboard.SelectList("Opportunity");

		salesPresalesDashboard.openLeadDetails(1);

		String leadIdObj = driver.findElement(By.cssSelector("span[name='lead_id']")).getText().replaceAll("\\s+", "");
		System.out.println("Lead ID-" + leadIdObj);

		Thread.sleep(1000);

		leadProfilePage.addingInventory();

		jse.executeScript("window.scrollBy(0,-300)", "");

		Thread.sleep(2000);

		leadProfilePage.changeFilters();

		leadProfilePage.selectingUnit();

		Thread.sleep(2000);

		leadProfilePage.bookingUnit();

		LeadBookingFormPage leadBooking = new LeadBookingFormPage(driver);

		leadBooking.addingCostDetails();

		leadBooking.clickBasicDetails();

		leadBooking.addingAndRemovingSecondaryBookingName(prop.getProperty("SecondaryBookingName_BookingALead"));

		Thread.sleep(3000);

		jse.executeScript("window.scrollBy(0,250)", "");

		leadBooking.selectStage(prop.getProperty("Confirm_Booking"));

		leadBooking.inputFloorNumber(prop.getProperty("FloorNumber_BookingALead"));

		leadBooking.inputBuildingName(prop.getProperty("BuildingName_BookingALead"));

		leadBooking.inputCarpetArea(prop.getProperty("CarpetArea_BookingALead"));

		leadBooking.inputSaleableArea(prop.getProperty("SaleableArea_BookingALead"));

		leadBooking.inputParkingNumber(prop.getProperty("ParkingNumber_BookingALead"));

		leadBooking.inputBedroomPreferences(prop.getProperty("BedroomPreferences_BookingALead"));

		leadBooking.inputPanNumber(prop.getProperty("PanNumber_BookingALead"));

		leadBooking.inputAddressAndStreet(prop.getProperty("Address_BookingALead"),
				prop.getProperty("Street_BookingALead"));

		leadBooking.inputCityAndState(prop.getProperty("City_BookingALead"), prop.getProperty("State_BookingALead"));

		leadBooking.inputCountryAndZip(prop.getProperty("Zip_BookingALead"));

		leadBooking.clickOnSaveButton();

		Thread.sleep(4000);

		leadProfilePage.selectBookings();

		Thread.sleep(2000);

		System.out.println("Started verification");
		String stage = driver.findElement(By.xpath("//span[@class='badge badge-success']")).getText();
		System.out.println("Booking Stage-" + stage);
		Assert.assertEquals(stage, "confirmed", "Not matched");

		Thread.sleep(1000);

		String addNewBookingButton = driver.findElement(By.xpath("//button[@class='btn btn-default add_booking_form']"))
				.getText().toLowerCase();
		System.out.println("Button text-" + addNewBookingButton);
		Assert.assertEquals(addNewBookingButton, "add new booking", "Not matched");

		Thread.sleep(1000);

		String closeButton = driver.findElement(By.xpath("//button[@class='btn btn-default close_profile_form']"))
				.getText().toLowerCase();
		System.out.println("Button text-" + closeButton);
		Assert.assertEquals(closeButton, "close", "Not matched");

		System.out.println("Completed verification");

		leadProfilePage.clickOnCloseButton_Bookingdetails();

		Thread.sleep(3000);

		salesPresalesDashboard.searchLead(leadIdObj);

		String textDropdownObj = driver
				.findElement(By.xpath("//button[@class='btn dropdown-toggle btn-sm btn-outline-primary']//span"))
				.getAttribute("innerHTML").trim();
		System.out.println("Stage changed-" + textDropdownObj);
		Assert.assertEquals(textDropdownObj, "Booked", "Not matched");

	}

	public void addNewUnit() throws Exception {
		LoginPage login = new LoginPage(driver);
		login.login(prop.getProperty("admin"), prop.getProperty("password"));

		ClientLoginPage clientLogin = new ClientLoginPage(driver);

		clientLogin.clientLogin(prop.getProperty("Client"));

		UnitsPage unitsPage = new UnitsPage(driver);
		NewUnitFormPage newUnitFormPage = new NewUnitFormPage(driver);

		WebElement element = driver.findElement(By.cssSelector("i.ion-cube"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		driver.findElement(By.linkText("Units")).click();

		unitsPage.clickOnNewUnitButton();

		newUnitFormPage.enterDeveloperName("AniketBuisnessNameMain");

		newUnitFormPage.enterProjectName("Aniket Project 02");

		newUnitFormPage.enterProjectTowerName("su");

		newUnitFormPage.enterFloorPlanName("Floor Plan");

		String unitName = Random("A", 10).toUpperCase();

		newUnitFormPage.enterUnitName(unitName);

		newUnitFormPage.enterNumberOfFloors(prop.getProperty("numberOfFloors_addingNewUnitTest"));

		newUnitFormPage.enterUnitBaseRate(Random("N", 10));

		newUnitFormPage.selectNumberOfBedrooms();

		newUnitFormPage.selectNumberOfBathrooms();

		newUnitFormPage.selectCategory();

		newUnitFormPage.selectType();

		newUnitFormPage.enterSaleableArea(Random("N", 10));

		newUnitFormPage.enterCarpetArea(Random("N", 10));

		newUnitFormPage.enterNumberOfFloors(Random("N", 1));

		newUnitFormPage.clickOnSaveButton();
	}
}
