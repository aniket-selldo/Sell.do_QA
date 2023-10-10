package A_Experiment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.selldo.Utility.BaseTest;

import myPom.loginPage;

public class Test001 extends BaseTest {

	@Test
	public void t1() throws InterruptedException {
		loginPage loginPage = new loginPage(driver);
		loginPage.login_suppoort("divya+superadmin@amuratech.com","amura@123");
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		
		driver.get("https://v2b.sell.do/sidekiq/scheduled");
		executor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		List<WebElement> ls =driver.findElements(By.xpath("//a[@href='/sidekiq/queues/reporting']/parent::td/parent::tr/td[1]/input"));
		System.out.println(ls.size());
		Thread.sleep(1000);
		for (int i = 0; i < ls.size(); i++) {
			executor.executeScript("arguments[0].click();", ls.get(i));
			executor.executeScript("arguments[0].style.border='5px solid Green'", ls.get(i));
		}
		Thread.sleep(1000);
		executor.executeScript("arguments[0].style.border='5px solid Green'", driver.findElement(By.xpath("//input[@value=\"Add to queue\"]")));
		driver.findElement(By.xpath("//input[@value=\"Add to queue\"]")).click();
		Thread.sleep(1000);
	}
}
