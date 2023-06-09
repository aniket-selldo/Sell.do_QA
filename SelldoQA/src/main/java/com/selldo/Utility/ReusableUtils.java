package com.selldo.Utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableUtils {

	private WebDriver driver;
	private FileWriter writer;
	private BufferedWriter buffer;
	private final static int waitingTime_Sec = 5;

	public ReusableUtils(WebDriver driver) {
		this.driver = driver;
	}

	protected Properties getGobalData() {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(System.getProperty("user.dir") + "/config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

// --------------------------Wait ------------------------

	protected WebElement waitUntilVisiblity(WebElement we) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitingTime_Sec));
		wait.until(ExpectedConditions.visibilityOf(we));
		Square(we);
		return we;
	}
	protected WebElement waitUntilVisiblity(WebElement we, long delay) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(delay));
		wait.until(ExpectedConditions.visibilityOf(we));
		Square(we);
		return we;
	}
	protected List<WebElement> invisibilityOfAllElements(List<WebElement> we) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitingTime_Sec));
		wait.until(ExpectedConditions.invisibilityOfAllElements(we));
		// Square(we);
		return we;
	}

	protected WebElement waitUntilInvisibility(WebElement we) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitingTime_Sec));
		wait.until(ExpectedConditions.invisibilityOf(we));
		return we;
	}

	protected WebElement waitUntilClickable(WebElement we) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitingTime_Sec));
		wait.until(ExpectedConditions.elementToBeClickable(we));
		System.out.println("Clicked Element -> " + we.getText().trim());
		Square(we);
		return we;
	}

	protected WebElement waitUntilClickable(WebElement we, int time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.elementToBeClickable(we));
		Square(we);
		return we;
	}

	protected List<WebElement> waitUntilVisibilityOfElements(List<WebElement> we) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitingTime_Sec));
		wait.until(ExpectedConditions.visibilityOfAllElements(we));
		return we;
	}

	protected List<WebElement> waitUntilInVisibilityOfElements(List<WebElement> we) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitingTime_Sec));
		wait.until(ExpectedConditions.invisibilityOfAllElements(we));
		return we;
	}

	protected void waitElementToBeClickable(WebElement we) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitingTime_Sec));
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(we)));
		Square(we);
	}

	protected void wait(int value) {
		try {
			Thread.sleep(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
//-------------------------------- Action ----------------------

	protected void HoverAndClick(WebDriver driver, WebElement elementToHover, WebElement elementToClick) {
		Actions action = new Actions(driver);
		action.moveToElement(elementToHover).click(elementToClick).build().perform();
	}

	protected void moveToElement(WebElement we) {
		Actions actions = new Actions(driver);
		Square(we);
		actions.moveToElement(we).build().perform();
	}

	protected void moveToElementClick(WebElement we) {
		Actions actions = new Actions(driver);
		actions.moveToElement(we).click().build().perform();
	}

	protected void moveToAndEnter(WebElement we) {
		Actions actions = new Actions(driver);
		actions.moveToElement(we);
		actions.click();
		actions.sendKeys(Keys.ENTER);
		actions.build().perform();
	}

	protected void moveToAndEnter(WebElement we, String value) {
		Actions actions = new Actions(driver);
		actions.moveToElement(we).click().sendKeys(value).sendKeys(Keys.ENTER).build().perform();
		;

	}

	protected void moveToAndSendKeyEnter(WebElement we, String s) {
		Actions actions = new Actions(driver);
		actions.moveToElement(we);
		actions.click();
		actions.sendKeys(s);
		actions.sendKeys(Keys.ENTER);
		actions.build().perform();
	}

	protected void moveToAndSendKey(WebElement we, String s) {
		Actions actions = new Actions(driver);
		actions.moveToElement(we);
		Square(we);
		actions.click();
		actions.sendKeys(s);
		actions.build().perform();
	}

	protected void scrollAction(WebElement we, WebElement we2) {
		Actions actions = new Actions(driver);
		actions.moveToElement(we);
		Square(we);
		actions.scrollToElement(we2);
		actions.build().perform();
	}

	protected void moveToAndSendEnter(WebElement we) {
		Actions actions = new Actions(driver);
		actions.moveToElement(we);
		Square(we);
		actions.click();
		actions.sendKeys(Keys.ENTER);
		actions.build().perform();
	}

	protected void move2click(WebElement we, WebElement we2) {
		Actions actions = new Actions(driver);
		actions.moveToElement(we);
		Square(we);
		actions.moveToElement(we2);
		actions.click();
		actions.build().perform();
	}

	protected void move2click(WebElement we, int value) {
		Actions actions = new Actions(driver);
		actions.moveToElement(we);
		Square(we);
		actions.build().perform();

		driver.findElement(By.cssSelector(
				"body > div.main-nav-container > div.sub-navigation-bar > div:nth-child(1) > div:nth-child(" + value
						+ ") > a"))
				.click();
	}

//-------------------JavascriptExecutor---------------- 
	protected void scrollIntoView(WebElement we) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", we);
		scrollBy(-100);
		// wait(500);
		Square(we);
	}

	protected WebElement scrollIntoViewUp(WebElement we) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false);", we);
		Square(we);
		return we;
	}

	protected void scrollBy(int scroll) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + scroll + ")", "");
	}

	protected void jsClick(WebElement we) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitingTime_Sec));
		wait.until(ExpectedConditions.elementToBeClickable(we));
		Square(we);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		System.out.println("jsClicked Element -> " + we.getText().trim());
		executor.executeScript("arguments[0].click();", we);
	}

	protected void scrollHeight() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	protected WebElement Square(WebElement we) {
		wait(500);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='5px solid Red'", we);
		return we;
	}

	protected WebElement jsSendKey(WebElement we, String txt) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Square(we);
		js.executeScript("arguments[0].value='" + txt + "'", we);
		return we;
	}

	protected String jsGetText(WebElement we) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Square(we);
		return (String) js.executeScript("return arguments[0].text;", we);

	}

// ----------------Select ------------------
	protected void selectByIndex(WebElement we, int index) {
		Square(we);
		Select oSelect = new Select(we);
		oSelect.selectByIndex(index);
	}

	protected void selectByVisibleText(WebElement we, String index) {
		Square(we);
		Select oSelect = new Select(we);
		oSelect.selectByVisibleText(index);
	}

	protected void selectByVisibleValue(WebElement we, String index) {
		Square(we);
		Select oSelect = new Select(we);
		oSelect.selectByValue(index);
	}
// -------------------------RANDOME-------------------------------

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
			writer = new FileWriter(System.getProperty("user.dir") + "/Random Values/" + method + " value" + ".txt");
			buffer = new BufferedWriter(writer);
			buffer.write("for : " + method + " : " + Return);
			buffer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Return;

	}

	// -----------------------Switching frame-------------------
	protected void frameSwitch(int value) {
		driver.switchTo().frame(value);
	}

	protected void frameSwitch(String value) {
		driver.switchTo().frame(value);
	}

	protected void frameSwitch(WebElement value) {
		driver.switchTo().frame(value);
	}

	protected void defaultContentSwitch() {
		driver.switchTo().defaultContent();
	}

//--------------Other------------------------------------------------
	protected void refresh() {
		driver.navigate().refresh();
	}

	protected void robotScroll(WebElement element, int value) {
		wait(999);
		Robot rb = null;
		try {
			rb = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		Point point = element.getLocation();
		int x = point.getX();
		int y = point.getY();
		rb.mouseMove(x, y);
		rb.mouseWheel(value);
	}

	protected String date(String format) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);// dd/MM/yyyy HH:mm:ss
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}

	protected void waitInvisblityLoading() {
		waitUntilVisiblity(driver.findElement(By.xpath("//div[@class='tc loading_screen_bars']")));
		waitUntilInvisibility(driver.findElement(By.xpath("//div[@class='tc loading_screen_bars']")));
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
			waitUntilInvisibility(ele);
		} catch (Exception e) {
		}
		return Noty;
	}

	public String randomEmail() {
		return "aniket.khandizod+" + random("", "AN", 10) + "@sell.do";
	}
	public String randomPhone() {
		return " 12345"+random("","N",5);
	}

}
