package Aniket.UserManagment;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.Utility.BaseTest;

import POM.clientCreationPage.createClientPage;

public class ClientCreation extends BaseTest{

	@Test
	public void createPostpaidClient() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyy");// yyyy/MM/dd
		LocalDateTime now = LocalDateTime.now();
		createClientPage page= new createClientPage(driver);
		page.clickOnClientButton();
		page.enterFirstName(random("enterFirstName","A",7));
		page.enterLastName(random("enterLastName","A",7));
		page.enterBuisnessName(dtf.format(now));
		page.selectBuisnessType();
		page.shortName(random("shortName","A",6));
		page.enterClientWebsite(random("enterClientWebsite","AN",7));
		page.enterclinetEmail(random("enterclinetEmail","AN",7));
		page.uploadFile("nun");
		page.enterClientPhone(random("enterClientPhone","N",9));
		page.enterMask(random("enterMask","A",6));
		page.selectIndustry(3);// 0) Real Estate 1) Education 2) BFSI  3) Generic
		page.enterAddres(random("enterAddres","A",6));
		page.enterCountry(1);
		page.enterState(1);
		page.enterCity("Pune");
		page.enterZip(414003);
		page.enterUserFirstName("2june2023");
		page.enterUserLasttName("user");
		page.enterUserPhone(random("enterClientPhone","N",9));
		page.enterEmail("aniket.khandizod+2june2023");
		page.enterUserTeam(random("enterUserTeam","A",7));
		page.selectVendores();
		String respone = page.clickOnsave();
		Assert.assertEquals(respone, "","Success massage not as expected");
	}
}
