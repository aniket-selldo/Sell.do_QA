package API;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import POJO_UpdateUser.OnlyProject;
import POJO_UpdateUser.Root;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdateUser {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		Properties prop = new Properties();
		prop.load(new FileInputStream(System.getProperty("user.dir") + "/config.properties"));
		String userID ="649588d1b08345ff55d115f4";
		String FullAccessAPI="c13ad8e13264b1c22bc39bb475889c7e";
		String ClientID="587ddb2b5a9db31da9000002";
		
		OnlyProject op = new OnlyProject();
		ArrayList <String> ary= GetAllProjectIDAndName.getAllProjectID(FullAccessAPI, ClientID);

		op.setProject_ids(ary);
		
		String putRequest =prop.getProperty("URL")+"/client/users/"+userID+".json?api_key="+FullAccessAPI+"&client_id="+ClientID+"";
		Response response = RestAssured.given().contentType(ContentType.JSON).body(op).put(putRequest);
		System.out.println(response.statusCode());

		
	}
}
