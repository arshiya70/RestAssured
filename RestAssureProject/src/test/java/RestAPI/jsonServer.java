package RestAPI;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.baseURI;
import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.matcher.RestAssuredMatchers;

import static io.restassured.RestAssured.given;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class jsonServer {
	// npm install -g json-server
	// run ->json-server --watch db.json ->http://localhost:3000/
	// open db.json in notepad and cutoze

	// @Test
	public void test_get() {

		baseURI = "http://localhost:3000";

		given().get("/users").then().statusCode(200).log().all();

		given().param("firstName", "Arshiya").get("/users").then().statusCode(200).log().all();

	}

	// @Test
	public void test_post() {

		JSONObject req = new JSONObject();

		req.put("id", 4);
		req.put("firstName", "Siraj");
		req.put("lastName", "uddin");
		req.put("Age", 58);

		baseURI = "http://localhost:3000";

		given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(req.toJSONString()).when().post("/users").then().statusCode(201).log().all();

	}

	// @Test
	public void test_patch() {

		JSONObject req = new JSONObject();

		req.put("id", 3);

		baseURI = "http://localhost:3000";

		given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(req.toJSONString()).when().patch("/users/3").then().statusCode(200).log().all();

	}

	@Test
	public void test_del() {

		JSONObject req = new JSONObject();

		baseURI = "http://localhost:3000";

		given().when().delete("/users/4").then().statusCode(200).log().all();

	}
}
