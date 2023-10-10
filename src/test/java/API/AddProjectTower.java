package API;

import static io.restassured.RestAssured.given;

import com.selldo.Utility.API_Reusable;

import POJO_CreateProjectTower_GET.Root_AddTower;
import io.restassured.http.ContentType;

public class AddProjectTower extends API_Reusable {

	public Root_AddTower addProjectTower(String projectID) {

		return given().urlEncodingEnabled(true).contentType(ContentType.URLENC)
				.formParam("project_tower[name]", Random("AN", 10)+" REST").formParam("project_tower[project_id]", projectID)
				.formParam("project_tower[total_floors]", Random("N",2))
				.formParam("project_tower[rera_tower_id]", Random("AN",10)).formParam("commit", "save")
				.formParam("api_key", prop("Clinet_API_Full")).formParam("client_id", prop("Client_id")).when()
				.post(prop("URL") + "/client/project_towers.json").then().extract().response().as(Root_AddTower.class);

	}
}
