package apidemo;

import java.util.HashMap;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
public class CREATERepo {
	HashMap<String, String> hm= new HashMap<String, String>();
@BeforeMethod
public void createPostData() {
	hm.put("name","Hello-World");
	hm.put("description","This is your first repo");
	hm.put("private","false");
	
	RestAssured.baseURI="https://github.com";
	RestAssured.basePath=" user/repos";
}
@Test
public void createResource() {
RestAssured
.given()
	.contentType("application/json;charset=utf-8")
	    .body(hm)
	    .header("Autorization, Bearer a6051b65aa55628bd170fe22f6a0dc950c3c378e9874da2ce34d618154e25101");
.when()
    .post()
.then()
  .statusCode(201).body("name", equalTo("Hello-World"))
  .body("owner.login", equalTo("anuoh")) 
  .body("owner.type", equalTo("User"))
  .extract().response();

	.log().all();
}
}
