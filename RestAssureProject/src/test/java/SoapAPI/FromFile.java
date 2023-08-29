package SoapAPI;

import org.apache.commons.io.IOUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.baseURI;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers;

import static io.restassured.RestAssured.given;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FromFile {

	@Test
	public void test() throws IOException{
		File file = new File("./SOAPRequest/add.xml");
		if (file.exists())
			System.out.println("file exists");

		FileInputStream fileInputStream = new FileInputStream(file);
		String requestBody = IOUtils.toString(fileInputStream, "UTF-8");

		baseURI = "http://www.dneonline.com";

		given()
		.contentType("text/xml")
		.header("Accept", "text/xml")
		.body(requestBody)
		.when()
		.post("/calculator.asmx")
		.then()
		.statusCode(200)
		.log()
		.all()
		
		.and()
		.body("//*:AddResult.text()", equalTo("4"))
		
		.and()
		.assertThat()
		.body(RestAssuredMatchers.matchesXsdInClasspath("XSDFile.xsd"));
	}

}
