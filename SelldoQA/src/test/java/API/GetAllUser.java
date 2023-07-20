package API;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import com.selldo.Utility.XLUtils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetAllUser {

	private static void getuserData() throws IOException {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(System.getProperty("user.dir") + "/config.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String APIKeys = "c13ad8e13264b1c22bc39bb475889c7e";
		String ClientID = "587ddb2b5a9db31da9000002";
		String full = prop.getProperty("URL") + "/client/users.json?api_key=" + APIKeys + "&client_id=" + ClientID + "";

		// RestAssured.baseURI = "https://v2.sell.do";
		// RestAssured.baseURI =full;
		Response response = RestAssured.given().contentType(ContentType.JSON).when().get(full).then().extract()
				.response();
		System.out.println(response.jsonPath().getString("page"));
		System.out.println(response.asString());

		JsonPath js = new JsonPath(response.asString());
		int size = js.getInt("all_users.size()");
		System.out.println("Total user count -> " + size);
//		for (int i = 0; i < size; i++) {
//			System.out.print("" + (i + 1) + " : ");
//			System.out.print(js.getString("all_users[" + i + "].text") + "  ->  ");
//			System.out.print(js.getString("all_users[" + i + "].id"));
//			System.out.println(" Active : " + js.getString("all_users[" + i + "].is_active"));
//		}
//		int count = 1;
//		for (int i = 0; i < size; i++) {
//			if (js.getString("all_users[" + i + "].is_active").equalsIgnoreCase("true")) {
//				System.out.print("" + (count++) + " : ");
//				System.out.print(js.getString("all_users[" + i + "].text") + "  ->  ");
//				System.out.print(js.getString("all_users[" + i + "].id"));
//				System.out.println(" Active : " + js.getString("all_users[" + i + "].is_active"));
//			} else {
//
//			}
//		}
		String fileName = "aadad";
		XLUtils xl = new XLUtils(System.getProperty("user.dir") + "" + fileName + ".xlsx");
		xl.setCellData("Sheet1", 0, 0, "User Name");
		xl.setCellData("Sheet1", 0, 1, "User ID");
		xl.setCellData("Sheet1", 0, 2, "Active");
		for (int i = 0; i < size; i++) {
			xl.setCellData("Sheet1", i + 1, 0, js.getString("all_users[" + i + "].text"));
		}

		for (int i = 0; i < size; i++) {
			xl.setCellData("Sheet1", i + 1, 1, js.getString("all_users[" + i + "].id"));
		}

		for (int i = 0; i < size; i++) {
			xl.setCellData("Sheet1", i + 1, 2, js.getString("all_users[" + i + "].is_active"));
		}

		System.out.println("Done");
	}

	public static void main(String[] args) throws IOException {
		getuserData();
	}
}
