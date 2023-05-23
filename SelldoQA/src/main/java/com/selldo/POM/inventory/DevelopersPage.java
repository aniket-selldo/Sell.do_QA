package com.selldo.POM.inventory;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selldo.Utility.ReusableUtils;

public class DevelopersPage extends ReusableUtils {

	public WebDriver driver;

	public DevelopersPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//a[text()='New Developer']")
	private WebElement newDeveloperButton;
	@FindBy(how = How.CSS, using = "i.ion-funnel")
	private WebElement funnelIcon;
	@FindBy(how = How.XPATH, using = "//label[text()=' Developer ']/following::span[1]")
	private WebElement deveoperSpan;
	@FindBy(how = How.XPATH, using = "//*[@id='select2-drop']//div//input")
	private WebElement developerInputField;
	@FindBy(how = How.XPATH, using = "//th[text()='Actions']/following::a[2]")
	private WebElement actionBar;
	@FindBy(how = How.XPATH, using = "//th[text()='Actions']/following::a[text()='Edit'][1]")
	private WebElement editLink;
	@FindBy(how = How.XPATH, using = "//a[text()='Apply']")
	private WebElement applyButton;
	@FindBy(how = How.XPATH, using = "//a[text()='Clear All']")
	private WebElement clearAllLink;
	@FindBy(how = How.XPATH, using = "//input[@value='Apply']/preceding::i[@class='ion-android-close'][1]")
	private WebElement crossIcon;

	public void clickOnNewDevekoperButton() {
		newDeveloperButton.click();
	}

	public void selectEdit() {
		actionBar.click();
		editLink.click();
	}

	public void clickOnFunnelIcon() {
		funnelIcon.click();
	}

	public void enterDeveloperName(String developer) throws InterruptedException {
		deveoperSpan.click();
		developerInputField.sendKeys(developer);
		Thread.sleep(2000);
		developerInputField.sendKeys(Keys.ENTER);
	}

	public void clickOnApplyButton() {
		applyButton.click();
	}

	public void clickOnClearAllLink() {
		clearAllLink.click();
	}

	public void clickOnCrossIcon() {
		crossIcon.click();
	}

}
