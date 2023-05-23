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
	@FindBy(how = How.CSS, using = "#select2-drop > ul > li > div")
	private List<WebElement> template_dd;

	public void selectSmsTemplate(String templateName) {

		templateDropdown.click();
		List<WebElement> list = template_dd;

		for (WebElement ele : list) {
			// for every elements it will print the name using innerHTML

			System.out.println("Values " + ele.getAttribute("innerHTML"));

			// Here we will verify if link (item) is equal to Template

			if (ele.getAttribute("innerHTML").contains(templateName)) {

				// if yes then click on link

				ele.click();

				System.out.println("Clicked on Template");

				// break the loop or come out of loop

				break;
			}
		}

	}

	public void clickOnSendSmsButton() {
		jsClick(sendSmsButton);
	}

}
