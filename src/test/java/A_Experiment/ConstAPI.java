package A_Experiment;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.selldo.POM.crm.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class ConstAPI {
	protected static String prop(String str) {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(System.getProperty("user.dir") + "/config.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop.getProperty(str);
	}

	public JsonPath getConstant(String id, String password) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get(prop("URL"));
		new LoginPage(driver).login(id, password);

		Cookie CRM_session = driver.manage().getCookieNamed("_crm_session");
		Cookie sesion_id = driver.manage().getCookieNamed("_session_id");

		String url = prop("URL") + "/client/constants";
		JsonPath js = RestAssured.given().with()
				.header("Cookie", "_crm_session=" + CRM_session.getValue() + ";_session_id=" + sesion_id.getValue())
				.header("Host", prop("URL").split("//")[1]).header("Accept", "*/*").when().get(url).then().extract()
				.response().jsonPath();
		System.out.println("Constant API working Fine");
		return js;

	}

	public static void main(String[] args) {
		ConstAPI ConstAPI = new ConstAPI();
		JsonPath js = ConstAPI.getConstant("aniket.khandizod+qe@sell.do", "amura@123");
		
		System.out.print("{");
		for (int i = 0; i < 14; i++) {
			
			System.out.print("\""+js.getString("Constants.BedroomTypes."+i+"")+"\",");
		}
		System.out.print("}");
	}

}
