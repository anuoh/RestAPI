package apidemo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


public class JSONSchemaValidator {
	
	@Test
public void validateJSONschema() {
	RestAssured.given()
	           .when()
	                 .get("https://reqres.in/api/users?page=2")
	           .then()
	           .assertThat()
	           .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("expectedJSONschema.json"));
}
}