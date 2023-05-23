package Aniket.UserManagment;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.selldo.POM.login.LoginPage;
import com.selldo.Utility.BaseTest;
import com.selldo.userManagement.SelectClient;

public class UserManagment extends BaseTest {
	
	private SelectClient selectClient ;
	
	@Test
	public void manageUser() {
		LoginPage A = new LoginPage(driver);
		selectClient= A.login(prop.getProperty("id"), prop.getProperty("pswd"));
		selectClient.selectClient("AniketBuisnessNameMain");
		
	}
	@Test
	public void M1() {
		AssertJUnit.assertTrue(true);
	}
	@Test
	public void M12(){
		AssertJUnit.assertTrue(true);

	}
	@Test
	public void M13() {
		AssertJUnit.assertTrue(true);

	}
	@Test
	public void M122() {
		AssertJUnit.assertTrue(true);

	}
	@Test
	public void M153() {
		AssertJUnit.assertTrue(true);

	}
	@Test
	public void M124(){
		AssertJUnit.assertTrue(true);

	}
	@Test
	public void M143() {
		AssertJUnit.assertTrue(true);

	}
	@Test
	public void M1252() {
		AssertJUnit.assertTrue(true);

	}
	@Test
	public void M155() {
		AssertJUnit.assertTrue(true);

	}
}

