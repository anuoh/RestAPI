package apidemo;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
public class DeleteNonExistingRepo {
	@BeforeClass
    public void setUp() {
        RestAssured.baseURI = "https://api.github.com";
    }

    @Test
    public void testDeleteNonExistingRepository() {
        String owner = "anuoh"; 
        String repoName = "non"; 

        given()
            .header("Authorization , Bearer a6051b65aa55628bd170fe22f6a0dc950c3c378e9874da2ce34d618154e25101\");
            .pathParam("owner", owner)
            .pathParam("repo", repoName)
        .when()
            .delete("/repos/{owner}/{repo}")
        .then()
            .assertThat().statusCode(404)
            .body("message", equalTo("Not Found"));
    }
}

