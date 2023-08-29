package Frameaworks;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.matcher.RestAssuredMatchers;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.Object;

@Test
public class DataDrivenExamples extends DataDriven_DataForTests{
	
	
	
	//@Test(dataProvider = "DataForPost")
	public void test_1_post(int id , String firstName, String lastName, int Age) {

		JSONObject request = new JSONObject();

		request.put("id", id);
		request.put("firstName", firstName);
		request.put("lastName", lastName);
		request.put("Age", Age);

		baseURI = "http://localhost:3000";

		System.out.println(request);
		System.out.println(request.toJSONString());

		given()
		.header("Content-Type", "application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()
		.post("/users")
		.then()
		.statusCode(201);

	}
	
		
		//@Test(dataProvider = "DelDataProvide")
		public void delete(int id) {
			baseURI = "http://localhost:3000";
			
			when().
			delete("/users/"+id).
			then().
			statusCode(200).
			log().all();
		}
		
		@Parameters({"id"}) //right click on project -> tectNG -> Convert to TestNg
		public void deleteParam(int id) {
			
			System.out.println("Id value : "+id);
			
			baseURI = "http://localhost:3000";
			
			when().
			delete("/users/"+id).
			then().
			statusCode(200).
			log().all();
		}
	
}
