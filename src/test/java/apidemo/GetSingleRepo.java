package apidemo;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetSingleRepo {
	
		  
		@BeforeClass
	    public void setup() {
	        RestAssured.baseURI = "https://api.github.com";
	    }

	    @Test
	    public void testGetRepository() {
	    	
	        given()
	            .pathParam("owner", "anuoh")
	            .pathParam("repo", "Automation")
	        .when()
	            .get("/repos/anuoh/Automation")
	        .then()
	            .assertThat().statusCode(200)
	          
	            .header("content-type", "application/json; charset=utf-8");
	    }
	
	}

