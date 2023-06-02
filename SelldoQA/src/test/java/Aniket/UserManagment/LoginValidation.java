package Aniket.UserManagment;

import java.io.IOException;

import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;
import com.selldo.Utility.XLUtils;

public class LoginValidation extends BaseTest {

	@Test(dataProvider = "getData")
	public void validateLogin(String id, String pswd, String exp) {
		System.out.println(driver.getTitle());
		LoginPage A = new LoginPage(driver);
		A.login(id, pswd);
		String exp_url = "https://v3b.sell.do/users/login";
		String current_url = driver.getCurrentUrl();

		if (exp.equals("valid")) {
			if (!exp_url.equals(current_url)) {
				System.out.println("URL diffrent");
				AssertJUnit.assertTrue(false);
			} else {
				AssertJUnit.assertTrue(true);
			}
		} else if (exp.equals("invalid")) {
			if (exp_url.equals(current_url)) {
				AssertJUnit.assertTrue(true);
			} else {
				AssertJUnit.assertTrue(false);
			}
		}
	}
//
	@DataProvider(name = "getData")
	public String[][] getData() throws IOException {

		XLUtils XL = new XLUtils(
				System.getProperty("user.dir") + "//src//main//java//com//selldo//Utility//idPassword.xlsx");
		int row = XL.getRowCount("login");
		int col = XL.getCellCount("login", 1);
		// System.out.println(row+" "+col);

		String loginData[][] = new String[row][col];
		for (int i = 1; i <= row; i++) {
			for (int j = 0; j < col; j++) {
				loginData[i - 1][j] = XL.getCellData("login", i, j);
			}
		}
		return loginData;
	}
	@Test(dependsOnMethods = { "validateLogin" })
	public void M2() {
		LoginPage A = new LoginPage(driver);
		A.login(prop.getProperty("id"), prop.getProperty("pswd"));
	}
	
	public void clienCreation() {
		
	}
}
