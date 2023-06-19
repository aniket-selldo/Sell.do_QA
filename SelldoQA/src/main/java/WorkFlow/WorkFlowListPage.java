package WorkFlow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selldo.Utility.ReusableUtils;

public class WorkFlowListPage extends ReusableUtils {
	public WebDriver driver;

	public WorkFlowListPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.CSS, using = "button[class='btn btn-light btn-icon toggle-filters']")
	private WebElement clickOnFilter;
	@FindBy(how = How.XPATH, using = "//a[text()='Clear All']")
	private WebElement clickOnClearAll;
	@FindBy(how = How.XPATH, using = "//div[@class='dropdown-menu dropdown-menu-right show'] //button")
	private WebElement clickOnActivateButton;
	
	
	
	public void clearFilter() {
		waitUntilClickable(clickOnFilter).click();
		waitUntilClickable(clickOnClearAll).click();
	}
	public void Activate_OR_Deactivate_WorkFlow(String str) {
		waitUntilClickable(driver.findElement(By.xpath("//td[text()='"+str+"']/parent::tr//a[@id='btn-drip-actions']"))).click();
		waitUntilClickable(clickOnActivateButton).click();
	}
}
