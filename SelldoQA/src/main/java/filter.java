import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.crm.ClientLoginPage;
import com.selldo.POM.crm.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class filter {

	static WebDriver driver;

	protected static WebElement waitUntilVisiblity(WebElement we) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(we));
		Square(we);
		return we;
	}

	protected static WebElement waitUntilClickable(WebElement we) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(we));
		System.out.println("Clicked Element -> " + we.getText().trim());
		Square(we);
		return we;
	}

	protected static WebElement waitUntilClickable(WebElement we, int time) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.elementToBeClickable(we));
		System.out.println("Clicked Element -> " + we.getText().trim());
		Square(we);
		return we;
	}

	protected static WebElement Square(WebElement we) throws InterruptedException {
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='5px solid Red'", we);
		return we;
	}

	public static void applayCJS(String userName, String CJS) throws InterruptedException {
		LoginPage login = new LoginPage(driver);
		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);
		ClientLoginPage clientLogin = new ClientLoginPage(driver);
		login.login("ketan@amuratech.com", "amura@123");

		try {
			waitUntilClickable(driver.findElement(By.cssSelector("#main-menu-settings")), 1).isDisplayed();
			System.out.println("SM Alredy loggedIn");
			adminDashboardPage.loggingOut();
			login.login("ketan@amuratech.com", "amura@123");
		} catch (Exception e) {
			System.out.println("SM No Alredy loggedIn");

		}
		clientLogin.clientLogin(userName);
		Thread.sleep(2000);
		waitUntilClickable(driver.findElement(By.cssSelector("#activity_tabs_more_lead_profile"))).click();
		waitUntilClickable(driver.findElement(By.linkText("Apply Custom JS"))).click();
		waitUntilVisiblity(driver.findElement(By.cssSelector("#client_id_for_custom_js"))).clear();
		waitUntilVisiblity(driver.findElement(By.cssSelector("#client_id_for_custom_js"))).sendKeys(CJS);
		waitUntilClickable(driver.findElement(By.xpath("//input[@class='btn btn-primary']"))).click();

		waitUntilClickable(driver.findElement(By.cssSelector("#main-menu-settings"))).click();
		waitUntilClickable(driver.findElement(By.xpath("//a[@ubts='Lead Settings']"))).click();
		waitUntilClickable(driver.findElement(By.xpath("//a[@ubts='Customize Your Lead Form']"))).click();
		Thread.sleep(1000);
		WebElement ele = driver.findElement(By.cssSelector("#client_configuration_custom_ui_sales"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String s = (String) js.executeScript("return arguments[0].length;", ele);
		System.out.println(">> "+s);
//		if (!b) {
//			waitUntilClickable(driver.findElement(By.xpath("(//label[@class='form-check-label'])[2]"))).click();
//		}
//		waitUntilClickable(driver.findElement(By.xpath("//input[@class='btn btn-primary save']"))).click();
//		adminDashboardPage.loggingOut();

	}

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://v3.sell.do/client/support_dashboard");
		applayCJS("Amura custom js", "6405e0c9a6bbc90373e51161");
		driver.quit();

	}
}
