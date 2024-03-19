package apidemo;
import static org.hamcrest.Matchers.*;


import java.io.File;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class DeleteRepo {
	@BeforeClass
	public void setUp() {
		 RestAssured.baseURI = "https://api.github.com";
    }
		
	@Test
    public void testDeleteRepository() {
        String owner = "anuoh"; 
        String repoName = "lates"; 

        given()
            .header("Authorization, "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") ;
            .pathParam("owner", owner)
            .pathParam("repo", repoName)
        .when()
            .delete("/repos/{owner}/{repo}")
        .then()
            .assertThat().statusCode(204)
            .body(isEmptyOrNullString());
    
		
	}

}


