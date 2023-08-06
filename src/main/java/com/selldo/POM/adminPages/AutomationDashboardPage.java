package com.selldo.POM.adminPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selldo.Utility.ReusableUtils;

public class AutomationDashboardPage extends ReusableUtils {

	public WebDriver driver;

	public AutomationDashboardPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.CSS, using = "i.ion-gear-b.text-secondary")
	private WebElement campaignSetupTab;
	@FindBy(how = How.XPATH, using = "//a[@class='select2-choice select2-default']")
	private WebElement searchCampaignSetup;
	@FindBy(how = How.XPATH, using = "//*[@id=\"select2-drop\"]/ul/li/div")
	private WebElement clickCampaignSetup;

	public void cickOnCampaignSetUp() {
		campaignSetupTab.click();
	}

	public void searchCampaignSetup() {
		Actions actions = new Actions(driver);
		actions.moveToElement(searchCampaignSetup).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		actions.sendKeys("Campaign Setup");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		actions.moveToElement(clickCampaignSetup).click();
	}

}
