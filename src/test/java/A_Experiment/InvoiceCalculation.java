package A_Experiment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;

public class InvoiceCalculation extends BaseTest {

	@Test
	public void test1() throws InterruptedException {
		LoginPage login = new LoginPage(driver);
		login.login(prop("Aniket_SM"), prop("Aniket_SM_PSWD"));

		driver.get(prop("URL") + "/admin/invoices/6571c168b083454e52acbe84");
		double GST =Double.parseDouble( driver.findElement(By.xpath("//td[starts-with(text(),'Taxes')]/following-sibling::td")).getText());
		double main =Double.parseDouble( driver.findElement(By.xpath("//td[starts-with(text(),'Total cost')]/following-sibling::td")).getText());
		double main_GST =Double.parseDouble( driver.findElement(By.xpath("//td[starts-with(text(),'Total Amount')]/following-sibling::td")).getText());
		
		
		double extraCost = Double.parseDouble(driver.findElement(By.xpath("//td[starts-with(text(),'Previous Balance')]/following-sibling::td[3]")).getText());
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		List<WebElement> ar = driver.findElements(By.xpath("//*[@id='content']/div/div[4]/div/table/tbody/tr/td[5]"));

		double sum = 0;
		for (int i = 0; i < ar.size(); i++) {
			if (ar.get(i).getText().trim().length() != 0) {
				double val = Double.parseDouble(ar.get(i).getText());
				sum += val;
			}

		}
		sum-=extraCost;
		System.out.println("Original cost : "+sum);
		
		double gst = 0.18 * (sum);
		System.out.println("With GST : "+(sum + gst));
		Assert.assertEquals((long)(gst+sum),main_GST );
		Assert.assertEquals((long)gst,(long)GST);
		

		
	}
}
