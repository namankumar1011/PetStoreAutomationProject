package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payloads.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


//similarly we need to create different classes for diff module endpoints
public class UserEndPoints {
	public static Response createUser(User payload) {
		Response res=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
			.when()
				.post(Routes.post_url);
		
		return res;
	}
	
	public static Response readUser(String userName) {
		Response res=given()
				.pathParam("username", userName)
			.when()
				.get(Routes.get_url);
		
		return res;
		
	}
	public static Response updateUser(String userName, User payload) {
		Response res=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.pathParam("username", userName)
			.when()
				.put(Routes.put_url);
		
		return res;
	}
	
	public static Response deleteUser(String userName) {
		Response res=given()
				.pathParam("username", userName)
			.when()
				.delete(Routes.delete_url);
		
		return res;
		
	}
	
	
	
}
