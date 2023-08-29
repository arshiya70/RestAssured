package RestAPI;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.assertThat;

import org.testng.annotations.Test;

public class SchemaValidation {
	@Test
	public void test() {
		baseURI = "https://reqres.in/api/";
		given()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.assertThat()
		.body(matchesJsonSchemaInClasspath("schema.json"))
		.statusCode(200)
		.log()
		.all();
	}
}
