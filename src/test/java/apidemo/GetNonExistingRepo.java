package apidemo;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
public class GetNonExistingRepo {
	@BeforeClass
    public void setUp() {
        RestAssured.baseURI = "https://api.github.com";
    }

    @Test
    public void testGetNonExistingRepository() {
        String owner = "anuoh"; 
        String repoName = "abc"; 
        given()
            .header("Authorization", "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") 
            .pathParam("anuoh", owner)
            .pathParam("repo", repoName)
        .when()
            .get("/repos/{owner}/{repo}")
        .then()
            .assertThat().statusCode(404)
            .body("message", equalTo("Not Found"));
    }
}
}
