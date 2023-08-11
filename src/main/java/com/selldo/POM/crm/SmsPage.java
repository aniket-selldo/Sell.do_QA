package com.selldo.POM.crm;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selldo.Utility.ReusableUtils;

public class SmsPage extends ReusableUtils {
	public WebDriver driver;

	public SmsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//button[text()='Send SMS']")
	private WebElement sendSmsButton;
	@FindBy(how = How.XPATH, using = "//label[text()='Compose using template']/following::span[1]")
	private WebElement templateDropdown;
	@FindBy(how = How.CSS, using = "div[class='form-group sms_template_select'] div")
	private WebElement clickOnSelectTamplete;
	@FindBy(how = How.CSS, using = "#select2-drop > ul > li > div")
	private List<WebElement> template_dd;
	
	public void selectSmsTemplate(String templateName) {
		waitUntilClickable(clickOnSelectTamplete).click();
	//	waitUntilClickable(templateDropdown).click();
		List<WebElement> list = template_dd;

		for (WebElement ele : list) {
			if (ele.getAttribute("innerHTML").contains(templateName)) {
				waitUntilClickable(ele).click();
				break;
			}
		}

	}

	public void clickOnSendSmsButton() {
		jsClick(sendSmsButton);
	}

}
