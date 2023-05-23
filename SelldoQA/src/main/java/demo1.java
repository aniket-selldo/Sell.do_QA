import org.testng.annotations.Test;

import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.Utility.BaseTest;

import Enums.AutoForwarding;
import Enums.Strategy;

public class demo1 extends BaseTest{

	@Test
	public void demo() {
		AdminDashboardPage ad = new AdminDashboardPage(driver);
		ad.AutoForwading("Aniket Automation", Strategy.Project, AutoForwarding.OFF);
	}
}
