package apidemo;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
public class GetAllRepo {
	 @BeforeClass
	    public void setUp() {
	        RestAssured.baseURI = "https://api.github.com";
	    }

	    @Test
	    public void testGetAllRepositories() {
	        Response response =
	            given()
	                .header("Authorization", "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") 
	            .when()
	                .get("/repos/anuoh/Automation")
	            .then()
	                .assertThat().statusCode(200)
	                .header("content-type", "application/json; charset=utf-8")
	                .extract().response();

	        // Validate schema
	        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("repositories_schema.json"));

	        // Get total number of repositories
	        int totalRepositories = response.jsonPath().getList("$").size();
	        System.out.println("Total number of repositories: " + totalRepositories);

	        // Print only the repositories names which are public
	        System.out.println("Public repositories:");
	        response.jsonPath().getList("findAll { it.private == false }.name").forEach(System.out::println);
	    }
	}

