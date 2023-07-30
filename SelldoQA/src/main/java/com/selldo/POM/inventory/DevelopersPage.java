package com.selldo.POM.inventory;

import java.util.List;

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
	@FindBy(how = How.XPATH, using = "//table[@class='table table-responsive']/tbody/tr/td[1]")
	private List<WebElement> getAllDevloperName;

	public String getAnyDevloperName() {
		int index = (int) (Math.random() * getAllDevloperName.size());
		return waitUntilVisiblity(getAllDevloperName.get(index)).getText().trim();
	}

	public void clickOnNewDevekoperButton() {
		waitUntilClickable(newDeveloperButton).click();
	}

	public void selectEdit() {
		waitUntilClickable(actionBar).click();
		waitUntilClickable(editLink).click();
	}

	public void clickOnFunnelIcon() {
		waitUntilClickable(funnelIcon).click();
	}

	public void enterDeveloperName(String developer) throws InterruptedException {
		waitUntilClickable(deveoperSpan).click();
		waitUntilVisiblity(developerInputField).sendKeys(developer);
		wait(2000);
		waitUntilVisiblity(developerInputField).sendKeys(Keys.ENTER);
	}

	public void clickOnApplyButton() {
		waitUntilClickable(applyButton).click();
	}

	public void clickOnClearAllLink() {
		waitUntilClickable(clearAllLink).click();
	}

	public void clickOnCrossIcon() {
		waitUntilClickable(crossIcon).click();
	}

}
