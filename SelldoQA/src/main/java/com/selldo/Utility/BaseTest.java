package com.selldo.Utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v112.emulation.Emulation;
import org.openqa.selenium.devtools.v112.network.Network;
import org.openqa.selenium.devtools.v112.network.model.ConnectionType;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import myPom.LoginAsClient;

enum Browser {
	chromeAdv, firefox, edge, safari, HeadLess, Chrome;
}

public class BaseTest {
	// public static ChromeDriver driver;

	public static Properties prop;
	public static ChromeDriver driver;
	public static LoginAsClient client;
	public static FileWriter writer;
	public static BufferedWriter buffer;
	public static String projectPath;
	public static WebDriverWait wait;
	public static ExtentTest test;
	public static ExtentReports extent = ExtentReporterNG.getReportObject();
	public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	public static File filee;

	@BeforeSuite(alwaysRun = true)
	public void ObjectInvokder() throws IOException {
		writer = new FileWriter(System.getProperty("user.dir") + "/Random Values/value.txt", true);
		buffer = new BufferedWriter(writer);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");// yyyy/MM/dd
		LocalDateTime now = LocalDateTime.now();
		buffer.newLine();
		buffer.write("===========================================================");
		buffer.newLine();
		buffer.write("------------------" + dtf.format(now) + "----------------------");
		buffer.newLine();
		buffer.write("⇓ ⇟ ⇩ ⇓ ⇟ ⇩ ⇓ ⇟ ⇩ ⇓ ⇟ ⇩ ⇓ ⇟ ⇩ ⇓ ⇟ ⇩ ⇓ ⇟ ⇩ ⇓ ⇟ ⇩ ⇓ ⇟ ⇩ ⇓ ⇟ ⇩ ");
		buffer.newLine();
		projectPath = System.getProperty("user.dir");

	}

	
	@BeforeMethod(alwaysRun = true)
	protected void browserConfig() throws FileNotFoundException, IOException, AWTException {

		// -------------------Property Files-------------------//
		prop = new Properties();
		prop.load(new FileInputStream(System.getProperty("user.dir") + "/config.properties"));

		// -------------------get Browser Property-------------------//
		String browser = prop.getProperty("browser").trim();
		// -------------------WebDriver-------------------//
		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			//================To disable Automation name==========
			options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
			
			//================To disble notification popup========
			options.addArguments("--disable-notifications");
			
			//================disable save password=======
			options.addArguments("--start-maximized");
			options.addArguments("--disable-web-security");
			options.addArguments("--no-proxy-server");
			Map<String, Object> p = new HashMap<String, Object>();
			p.put("credentials_enable_service", false);
			p.put("profile.password_manager_enabled", false);
			options.setExperimentalOption("prefs", p);
		
			// ===============WebDriver=================//
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
			DevTools devTool = driver.getDevTools();
			devTool.createSession();
			devTool.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
			devTool.send(Network.emulateNetworkConditions(false, 0, 0, 0, Optional.of(ConnectionType.CELLULAR4G)));

			double latitude = 35.8617;
			double longitude = 104.1954;
			devTool.send(
					Emulation.setGeolocationOverride(Optional.of(latitude), Optional.of(longitude), Optional.of(1)));
			devTool.send(Emulation.setScriptExecutionDisabled(false));
		}
//		 else if (browser.equalsIgnoreCase("firefoxdriver")) {
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
//		} else if (browser.equalsIgnoreCase("edgedriver")) {
//			WebDriverManager.edgedriver().setup();
//			driver = new EdgeDriver();
//		} else if (browser.equalsIgnoreCase("SafariDriver")) {
//			WebDriverManager.safaridriver().setup();
//			driver = new SafariDriver();
//		} else if (browser.equalsIgnoreCase("HtmlUnitDriver")) {
//			driver = new HtmlUnitDriver(BrowserVersion.CHROME);
//		}else if (browser.equalsIgnoreCase("ChromeDriver")) {
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//		}
		// -------------------Browser Management-------------------//
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_MINUS);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_MINUS);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_MINUS);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_MINUS);
		robot.keyPress(KeyEvent.VK_F11);
		robot.keyRelease(KeyEvent.VK_F11);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	}

	@AfterMethod(alwaysRun = true)
	protected void terminate() throws InterruptedException {

		try {
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterSuite(alwaysRun = true)
	protected void ObjectSupressor() throws IOException {
		buffer.close();
	}

	public String getScreenshot(String fileName, WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		filee = new File(System.getProperty("user.dir") + "//reports//" + fileName + ".png");
		try {
			FileUtils.copyFile(file, filee);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return System.getProperty("user.dir") + "//reports//" + fileName + ".png";
	}
	public void zoomAndFullScreen() {
		
	}

	protected String random(String method, String choise, int size) {
		String Return = "";
		switch (choise) {
		case "AN":
			Return = RandomStringUtils.randomAlphanumeric(size);
			break;// pX4Mv3KsJU
		case "A":
			Return = RandomStringUtils.randomAlphabetic(size);
			break;// ZLTRqGyuXk
		case "R":
			Return = RandomStringUtils.random(size);
			break;// 嚰险걻鯨贚䵧縓
		case "N":
			Return = RandomStringUtils.randomNumeric(size);
			break;// 3511779161
		default:
			break;
		}

		try {
			buffer.write("for : " + method + " : " + Return);
			buffer.newLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Return;
	}

	protected String R(char... arr) {
		return RandomStringUtils.random(1, arr);
	}

	protected String getSuccessMSG() {

		WebElement ele = driver.findElement(By.xpath("//div[@class='noty_message']"));
		new ReusableUtils(driver).waitUntilVisiblity(ele);
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (ele.getText().trim().length() > 5) {
				break;
			}
		}
		String Noty = ele.getText().trim();
		System.out.println("Noty Message >>> " + ele.getText());
		try {
			new ReusableUtils(driver).waitUntilInvisibility(ele);
		} catch (Exception e) {}
		return Noty;
	}

	protected String getSuccessMSG2() {

		WebElement ele = driver.findElement(By.cssSelector(".alert.alert-success"));
		new ReusableUtils(driver).waitUntilVisiblity(ele);
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (ele.getText().trim().length() > 10) {
				break;
			}
		}
		String Noty = ele.getText().replaceAll("^×", "").trim();
		System.out.println("Noty Message >>> " + ele.getText());
		// new ReusableUtils(driver).waitUntilInvisibility(ele);
		return Noty;
	}

	protected void getSuccessMSGinvisiblity() {

		boolean ele = driver.findElement(By.xpath("//div[@class='noty_message']")).isDisplayed();
		while (ele) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			ele = driver.findElement(By.xpath("//div[@class='noty_message']")).isDisplayed();
		}
	}
	public String DateTime(String time) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(time);// yyyy/MM/dd
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}
}


