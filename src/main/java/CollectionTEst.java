import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.selldo.Utility.BaseTest;

public class CollectionTEst extends BaseTest{

	@Test
	public void clickMultipe() throws InterruptedException {
		driver.get("https://www.google.com");
		String SearchText ="Nature";
		driver.findElement(By.name("q")).sendKeys(SearchText);
		List<WebElement>ele=driver.findElements(By.cssSelector("[role='listbox'] li"));
		Thread.sleep(5000);
		ele.stream().filter(S->S.getText().equalsIgnoreCase(SearchText)).findAny().get().click();
		Thread.sleep(5000);
	}
}
/*
 * Stream.of("cat", "dog", "elephant", "fox", "rabbit", "duck") .takeWhile(n ->
 * n.length() % 2 != 0) .forEach(System.out::println);
 * 
 * 
 */