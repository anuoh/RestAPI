package apidemo;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CreateExistingRepo {
	@BeforeClass
    public void setUp() {
        RestAssured.baseURI = "https://api.github.com";
    }

    @Test
    public void testCreateExistingRepository() {
        String owner = "anuoh"; 
        String repoName = "Automation"; 

        // Request body for creating a repository
        String requestBody = "{\"name\":\"EXISTING_REPO\",\"description\":\"This is a test repo!\",\"homepage\":\"https://github.com\",\"private\":false}";

        given()
            .header("Authorization", "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") 
            .body(requestBody)
        .when()
            .post("/user/repos")
        .then()
            .assertThat().statusCode(422)
            .body("message", equalTo("name already exists on this account"));
    }
}
}
