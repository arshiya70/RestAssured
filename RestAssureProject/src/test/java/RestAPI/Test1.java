package RestAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.baseURI;
import io.restassured.RestAssured.*;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;

public class Test1 {
	@Test
	public void test1() {
		baseURI = "https://reqres.in/api/";

		Response response = null;
		response = RestAssured.given().when().get("users?page=2");

		System.out.println("Response is :\n" + response.getBody().asString());
		System.out.println(response.getHeader("content-type"));
		int statusCode = response.getStatusCode();
		System.out.println(response.getStatusCode());

		Assert.assertEquals(statusCode, 200);

	}

	@Test
	public void test2() {

		get("https://reqres.in/api/users?page=2").body().asString();

		given().get("https://reqres.in/api/users?page=2").then().statusCode(200);

	}

	

	@Test
	public void test3() {

		given()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.body("data.id[0]", equalTo(9));
	}

}
