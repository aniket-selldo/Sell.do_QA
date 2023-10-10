import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;

public class AddAccessSM extends BaseTest {

	@Test
	public void addSMPermsssion() throws InterruptedException {
		LoginPage login = new LoginPage(driver);
		login.login(prop("SM"), prop("Password"));

		waitUntilClickable(driver.findElement(By.linkText("Support Permissions"))).click();
		addSMpermission("aniket.khandizod@sell.do");

	}
//
	public void addSMpermission(String str) throws InterruptedException {

		for (int j = 0; j < 5; j++) {
			Thread.sleep(3000);
			for (int i = 0; i < 15; i++) {
				Thread.sleep(3000);
				waitUntilClickable(driver
						.findElements(By.xpath("//a[@class='table-action-btn dropdown-toggle btn btn-light btn-sm']"))
						.get(i)).click();
				waitUntilClickable(driver.findElements(By.linkText("Edit Users")).get(i)).click();
				waitUntilClickable(driver.findElement(By.cssSelector("#s2id_support_permission_user_ids"))).click();
				waitUntilVisiblity(
						driver.findElement(By.cssSelector("#s2id_support_permission_user_ids #s2id_autogen1")))
						.sendKeys(str);
				waitUntilClickable(driver.findElement(By.cssSelector(
						"li[class='select2-results-dept-0 select2-result select2-result-selectable select2-highlighted']")))
						.click();
				waitUntilClickable(driver.findElement(By.cssSelector("input.btn.btn-primary.user_submit"))).click();
			}
			Thread.sleep(3000);
			if (waitUntilVisiblity(driver.findElement(By.linkText("Next →"))).isEnabled()) {
				Thread.sleep(3000);
				waitUntilClickable(driver.findElement(By.linkText("Next →"))).click();
			}
		}
	}

	protected WebElement waitUntilVisiblity(WebElement we) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(we));
		Square(we);
		return we;
	}

	protected WebElement waitUntilClickable(WebElement we) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(we));
		System.out.println("Clicked Element -> " + we.getText().trim());
		Square(we);
		return we;
	}

	protected WebElement Square(WebElement we) throws InterruptedException {
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='5px solid Red'", we);
		return we;
	}
}
